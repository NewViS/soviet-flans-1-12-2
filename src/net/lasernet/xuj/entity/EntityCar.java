package net.lasernet.xuj.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import javax.annotation.Nullable;
import net.lasernet.xuj.ModItems;
import net.lasernet.xuj.XujMod;
import net.lasernet.xuj.carparts.CarPart;
import net.lasernet.xuj.carparts.CarPartEngine;
import net.lasernet.xuj.carparts.CarPartWheels;
import net.lasernet.xuj.carparts.EnumCarType;
import net.lasernet.xuj.items.ItemCarBox;
import net.lasernet.xuj.items.ItemCarPart;
import net.lasernet.xuj.items.ItemLugWrench;
import net.lasernet.xuj.items.ItemPaintCan;
import net.lasernet.xuj.items.ItemWD40;
import net.lasernet.xuj.network.CarToClientMessage;
import net.lasernet.xuj.network.CarToServerMessage;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;

public abstract class EntityCar extends Entity
{
    public static Map<String, Float> fuelMap = new HashMap<String, Float>();
    public static final int[] COLORS = new int[] {16383998, 16351261, 13061821, 3847130, 16701501, 8439583, 15961002, 4673362, 10329495, 1481884, 8991416, 3949738, 8606770, 6192150, 11546150, 1908001, 16383998, 16351261, 13061821, 3847130, 16701501, 8439583, 15961002, 4673362, 10329495, 1481884, 8991416, 3949738, 8606770, 6192150, 11546150, 1908001};
    protected EnumCarType carType;
    private float length = 0.0F;
    protected float acceleration = 1.0F;
    protected float deceleration = 1.0F;
    protected float steeringCoefcient = 5.0F;
    protected float maxLeanAngle = 5.0F;
    public boolean isRearEngined = false;
    public boolean hasWheels = true;
    protected int color = 16777215;
    protected List<CarPart> carpartslist = new ArrayList<CarPart>();
    protected byte[] carparts;
    protected CarPartEngine engine;
    protected FluidStack fuel;
    protected float fuelFloat = 0.0F;
    protected float accelerationTick = 0.0F;
    protected float steeringAngle = 0.0F;
    protected float oversteerAngle = 0.0F;
    protected boolean isOversteer = false;
    protected boolean isBreaking = false;
    protected boolean isBurnout = false;
    protected boolean wasBurnout = false;
    private UUID activePlayer;
    public float rotX = 0.0F;
    public float rotZ = 0.0F;
    private int sendPeriod = 0;
    protected IBakedModel bakedmodel = null;

    public static void initCars()
    {
        fuelMap.put("rocket_fuel", Float.valueOf(1.8F));
        fuelMap.put("ethanol", Float.valueOf(1.0F));
        fuelMap.put("methanol", Float.valueOf(0.9F));
        fuelMap.put("biodiesel", Float.valueOf(0.6F));
        fuelMap.put("plantoil", Float.valueOf(5.5F));
        fuelMap.put("uutils_fuel", Float.valueOf(1.2F));
    }

    public EntityCar(World worldIn, EnumCarType carType)
    {
        super(worldIn);
        this.carType = carType;
        this.stepHeight = 0.3F;
        this.carparts = new byte[0];
        this.fuel = new FluidStack(FluidRegistry.getFluid("ethanol"), 0);
    }

    protected void entityInit()
    {
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readEntityFromNBT(NBTTagCompound nbt)
    {
        if (nbt.hasKey("steeringAngle"))
        {
            this.steeringAngle = nbt.getFloat("steeringAngle");
        }

        if (nbt.hasKey("carcolor"))
        {
            this.setColor(nbt.getInteger("carcolor"));
        }

        if (nbt.hasKey("fuel"))
        {
            this.fuel = FluidStack.loadFluidStackFromNBT((NBTTagCompound)nbt.getTag("fuel"));
        }

        if (nbt.hasKey("carparts"))
        {
            int[] aint = nbt.getIntArray("carparts");
            this.carparts = new byte[aint.length];

            for (int i = 0; i < aint.length; ++i)
            {
                this.carparts[i] = (byte)aint[i];
                this.carpartslist.add(CarPart.partList.get(this.carparts[i]));

                if (CarPart.partList.get(this.carparts[i]) instanceof CarPartEngine)
                {
                    this.engine = (CarPartEngine)CarPart.partList.get(this.carparts[i]);
                    this.acceleration = 1.0F + 1.0E-5F * (float)this.engine.getHorsepower();
                }
            }
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    protected void writeEntityToNBT(NBTTagCompound nbt)
    {
        nbt.setFloat("steeringAngle", this.steeringAngle);
        nbt.setInteger("carcolor", this.color);
        int[] aint = new int[this.carparts.length];

        for (int i = 0; i < this.carparts.length; ++i)
        {
            aint[i] = this.carparts[i];
        }

        nbt.setIntArray("carparts", aint);

        if (this.fuel != null)
        {
            nbt.setTag("fuel", this.fuel.writeToNBT(new NBTTagCompound()));
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        try
        {
            this.doUpdt();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void doUpdt()
    {
        this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        this.motionX = 0.0D;
        this.motionZ = 0.0D;
        this.motionY -= 0.08D;

        if (!this.world.isRemote)
        {
            if (this.sendPeriod > 5)
            {
                if (this.getPassengers().size() > 0)
                {
                    this.activePlayer = ((Entity)this.getPassengers().get(0)).getUniqueID();
                }

                if (this.carparts.length > 0)
                {
                    XujMod.channel.sendToAllAround(new CarToClientMessage(this.getEntityId(), this.getActivePlayer(), this.getColor(), this.carparts, this.steeringAngle, this.fuel.writeToNBT(new NBTTagCompound())), new TargetPoint(this.dimension, this.posX, this.posY, this.posZ, 32.0D));
                }
                else
                {
                    XujMod.channel.sendToAllAround(new CarToClientMessage(this.getEntityId(), this.getActivePlayer(), this.getColor(), this.steeringAngle, this.fuel.writeToNBT(new NBTTagCompound())), new TargetPoint(this.dimension, this.posX, this.posY, this.posZ, 32.0D));
                }

                if (this.accelerationTick != 0.0F || this.steeringAngle != 0.0F)
                {
                    XujMod.channel.sendToAllAround(new CarToClientMessage(this.getEntityId(), this.getActivePlayer(), this.steeringAngle, this.accelerationTick, this.isBurnout, this.isOversteer, this.fuel.writeToNBT(new NBTTagCompound())), new TargetPoint(this.dimension, this.posX, this.posY, this.posZ, 32.0D));
                }

                this.sendPeriod = 0;
            }

            ++this.sendPeriod;
        }

        if (this.getPassengers().size() >= 1 && this.fuel.amount != 0 && this.engine != null)
        {
            CarPartWheels carpartwheels = null;

            for (CarPart carpart : this.carpartslist)
            {
                if (carpart instanceof CarPartWheels)
                {
                    carpartwheels = (CarPartWheels)carpart;
                    break;
                }
            }

            if (carpartwheels != null)
            {
                if (this.world.isRemote && this.isActiveClient() && this.sendPeriod > 5)
                {
                    XujMod.channel.sendToServer(new CarToServerMessage(this.getEntityId(), this.steeringAngle, this.accelerationTick, this.isBurnout, this.isOversteer));
                    this.sendPeriod = 0;
                }

                ++this.sendPeriod;
                float f = 0.0F;

                if (this.getAccelerationTick() > 0.0F)
                {
                    f = this.acceleration * (this.getAccelerationTick() / 10.0F) * (this.getAccelerationTick() / 10.0F);
                }
                else if (this.getAccelerationTick() < 0.0F)
                {
                    f = -this.acceleration * (this.getAccelerationTick() / 10.0F) * (this.getAccelerationTick() / 10.0F);
                }

                f = Math.min(f, this.engine.getTopSpeed());

                if (this.isBurnout && f > this.engine.getBurnoutMax())
                {
                    f = this.engine.getBurnoutMax();
                    this.wasBurnout = true;
                }
                else if (!this.isBurnout && this.wasBurnout && this.getAccelerationTick() > 0.0F)
                {
                    f = this.engine.getTopSpeed() * 0.6F;
                    this.setAccelerationTick(this.engine.getTopSpeed() * 7.0F);
                    this.wasBurnout = false;
                }
                else
                {
                    this.wasBurnout = false;
                }

                if (f != 0.0F)
                {
                    if (f > 0.0F)
                    {
                        this.rotationYaw += this.steeringAngle / 10.0F;
                    }
                    else
                    {
                        this.rotationYaw -= this.steeringAngle / 10.0F;
                    }

                    if (this.steeringAngle > 0.0F)
                    {
                        this.steeringAngle -= this.steeringCoefcient;
                    }
                    else if (this.steeringAngle < 0.0F)
                    {
                        this.steeringAngle += this.steeringCoefcient;
                    }

                    if (!this.world.isRemote)
                    {
                        this.updateFuel(f);

                        if (MathHelper.abs(f) > 0.5F)
                        {
                            this.doCollisionCheck();
                        }
                    }

                    if (!this.isBurnout && this.isOversteer && f > 0.0F)
                    {
                        this.oversteerAngle = -this.steeringAngle * 1.0F / f * 0.5F;
                        float f1 = this.rotationYaw + this.oversteerAngle;
                        this.motionX += (double)(MathHelper.cos(f1 * 0.017453292F) * -f);
                        this.motionZ += (double)(MathHelper.sin(-f1 * 0.017453292F) * -f);
                    }
                    else if (!this.isBurnout)
                    {
                        this.motionX += (double)(MathHelper.cos(this.rotationYaw * 0.017453292F) * -f);
                        this.motionZ += (double)(MathHelper.sin(-this.rotationYaw * 0.017453292F) * -f);
                    }
                }

                if (this.world.isRemote)
                {
                    if (f > 0.1F && this.steeringAngle != 0.0F)
                    {
                        if (this.isOversteer)
                        {
                            if (this.steeringAngle < 0.0F)
                            {
                                this.rotZ = Math.min(-this.steeringAngle * 0.1F * f, this.maxLeanAngle / 2.0F);
                            }
                            else
                            {
                                this.rotZ = Math.max(-this.steeringAngle * 0.1F * f, -this.maxLeanAngle / 2.0F);
                            }
                        }
                        else if (this.steeringAngle > 0.0F)
                        {
                            this.rotZ = Math.min(this.steeringAngle * 0.1F * f, this.maxLeanAngle);
                        }
                        else
                        {
                            this.rotZ = Math.max(this.steeringAngle * 0.1F * f, -this.maxLeanAngle);
                        }
                    }
                    else
                    {
                        this.rotZ = 0.0F;
                    }

                    this.updateParticles(f);
                }
            }
        }
        else
        {
            this.setAccelerationTick(0.0F);
        }
    }

    private void doCollisionCheck()
    {
        List<Entity> list = this.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(this.getPosition().north(2).east(2).up(), this.getPosition().south(2).west(2).down()));

        if (list.size() > 0)
        {
            for (Entity entity : list)
            {
                if (entity instanceof EntityCreeper && !entity.isDead && ((EntityCreeper)entity).getHealth() > 0.0F)
                {
                    EntityCreeper entitycreeper = (EntityCreeper)entity;
                    entitycreeper.setLastAttackedEntity(this.getRidingEntity());
                    entitycreeper.setHealth(0.0F);
                    int i = this.rand.nextInt(14);

                    if (i < 3)
                    {
                        this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY, this.posZ, new ItemStack(ModItems.itemXujDiscDejavu, 1)));
                    }
                    else if (i >= 3 && i < 6)
                    {
                        this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY, this.posZ, new ItemStack(ModItems.itemXujDiscGas, 1)));
                    }
                    else if (i >= 6 && i < 9)
                    {
                        this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY, this.posZ, new ItemStack(ModItems.itemXujDiscRunning, 1)));
                    }
                }
                else if (entity instanceof EntityLiving && !entity.isDead && ((EntityLiving)entity).getHealth() > 0.0F)
                {
                    ((EntityLiving)entity).setLastAttackedEntity(this.getRidingEntity());
                    ((EntityLiving)entity).setHealth(((EntityLiving)entity).getHealth() - 10.0F);
                }
            }
        }
    }

    private void updateParticles(float accel)
    {
        Random random = new Random();
        float f = MathHelper.cos(this.rotationYaw * 0.017453292F);
        float f1 = MathHelper.sin(-this.rotationYaw * 0.017453292F);
        float[] afloat = this.getExhaustPos();
        float f2 = f * afloat[0];
        float f3 = f1 * afloat[0];
        f2 = f2 + MathHelper.cos((this.rotationYaw - 90.0F) * 0.017453292F) * afloat[2];
        f3 = f3 + MathHelper.sin(-(this.rotationYaw - 90.0F) * 0.017453292F) * afloat[2];

        if (accel > 1.2F && random.nextInt(20) == 5)
        {
            if (afloat.length > 3)
            {
                float f12 = f * afloat[3];
                float f13 = f1 * afloat[3];
                f12 = f12 + MathHelper.cos((this.rotationYaw - 90.0F) * 0.017453292F) * afloat[5];
                f13 = f13 + MathHelper.sin(-(this.rotationYaw - 90.0F) * 0.017453292F) * afloat[5];
                this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX + (double)f12, this.posY + (double)afloat[4], this.posZ + (double)f13, 0.0D, 0.05D, 0.0D, new int[0]);
            }
        }
        else
        {
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX + (double)f2, this.posY + (double)afloat[1], this.posZ + (double)f3, 0.0D, 0.1D, 0.0D, new int[0]);

            if (afloat.length > 3)
            {
                float f4 = f * afloat[3];
                float f5 = f1 * afloat[3];
                f4 = f4 + MathHelper.cos((this.rotationYaw - 90.0F) * 0.017453292F) * afloat[5];
                f5 = f5 + MathHelper.sin(-(this.rotationYaw - 90.0F) * 0.017453292F) * afloat[5];
                this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX + (double)f4, this.posY + (double)afloat[4], this.posZ + (double)f5, 0.0D, 0.1D, 0.0D, new int[0]);
            }
        }

        IBlockState iblockstate = this.world.getBlockState(this.getPosition().down(1));

        if (accel > 0.0F && iblockstate != null && MathHelper.abs((float)(this.lastTickPosX - this.posX)) < accel * 0.8F && MathHelper.abs((float)(this.lastTickPosZ - this.posZ)) < accel * 0.8F || this.isOversteer)
        {
            float[] afloat1 = this.getWheelPos();
            float f6 = f * (afloat1[0] + afloat1[6]);
            float f7 = f1 * (afloat1[0] + afloat1[6]);
            float f8 = f6 + MathHelper.cos((this.rotationYaw - 90.0F) * 0.017453292F) * afloat1[2];
            float f9 = f7 + MathHelper.sin(-(this.rotationYaw - 90.0F) * 0.017453292F) * afloat1[2];
            float f10 = f6 + MathHelper.cos((this.rotationYaw + 90.0F) * 0.017453292F) * afloat1[2];
            float f11 = f7 + MathHelper.sin(-(this.rotationYaw + 90.0F) * 0.017453292F) * afloat1[2];
            this.world.spawnParticle(EnumParticleTypes.BLOCK_DUST, this.posX + (double)f8, this.posY, this.posZ + (double)f9, (double)(f / (5.0F / accel)), (double)(random.nextFloat() / 5.0F), (double)(f1 / (5.0F / accel)), new int[] {Block.getStateId(iblockstate)});
            this.world.spawnParticle(EnumParticleTypes.BLOCK_DUST, this.posX + (double)f10, this.posY, this.posZ + (double)f11, (double)(f / (5.0F / accel)), (double)(random.nextFloat() / 5.0F), (double)(f1 / (5.0F / accel)), new int[] {Block.getStateId(iblockstate)});

            if (accel > 0.1F && (iblockstate.getMaterial() == Material.ROCK || iblockstate.getMaterial() == Material.IRON))
            {
                this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX + (double)f8, this.posY, this.posZ + (double)f9, (double)(f / (5.0F / accel)), (double)(random.nextFloat() / 5.0F), (double)(f1 / (5.0F / accel)), new int[0]);
                this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX + (double)f10, this.posY, this.posZ + (double)f11, (double)(f / (5.0F / accel)), (double)(random.nextFloat() / 5.0F), (double)(f1 / (5.0F / accel)), new int[0]);
            }
        }
    }

    public void updatePassenger(Entity passenger)
    {
        if (this.isPassenger(passenger))
        {
            float[] afloat = this.getSeatPositions()[this.getPassengers().indexOf(passenger)];
            float f = MathHelper.cos(this.rotationYaw * 0.017453292F);
            float f1 = MathHelper.sin(-this.rotationYaw * 0.017453292F);
            float f2 = f * afloat[0];
            float f3 = f1 * afloat[0];
            f2 = f2 + MathHelper.cos((this.rotationYaw - 90.0F) * 0.017453292F) * afloat[2];
            f3 = f3 + MathHelper.sin(-(this.rotationYaw - 90.0F) * 0.017453292F) * afloat[2];
            passenger.setPosition(this.posX + (double)f2, this.posY + (double)afloat[1] + passenger.getYOffset(), this.posZ + (double)f3);
        }

        if (this.world.isRemote)
        {
            if (!(passenger instanceof EntityPlayerSP))
            {
                return;
            }

            EntityPlayerSP entityplayersp = (EntityPlayerSP)passenger;

            if (!entityplayersp.getUniqueID().equals(this.activePlayer))
            {
                return;
            }

            if (entityplayersp.movementInput.forwardKeyDown)
            {
                ++this.accelerationTick;

                if (entityplayersp.movementInput.backKeyDown)
                {
                    this.isBurnout = true;
                }
                else
                {
                    this.isBurnout = false;
                }
            }
            else if (entityplayersp.movementInput.backKeyDown)
            {
                if (this.getAccelerationTick() > 0.0F)
                {
                    this.isBreaking = true;
                    this.setAccelerationTick(this.getAccelerationTick() - this.getAccelerationTick() * 2.0F / (this.deceleration * 7.0F));

                    if (!entityplayersp.movementInput.forwardKeyDown)
                    {
                        this.isBurnout = false;

                        if (MathHelper.abs((float)(this.lastTickPosX - this.posX)) < 0.5F && MathHelper.abs((float)(this.lastTickPosZ - this.posZ)) < 0.5F)
                        {
                            this.accelerationTick = 0.0F;
                        }
                    }
                }
                else if (!this.isBreaking)
                {
                    this.accelerationTick -= 0.2F;

                    if (this.accelerationTick < -5.0F)
                    {
                        this.accelerationTick = -5.0F;
                    }
                }
            }
            else if (!entityplayersp.movementInput.backKeyDown)
            {
                this.isBreaking = false;
            }

            if (entityplayersp.movementInput.leftKeyDown && this.steeringAngle < 60.0F)
            {
                this.steeringAngle += 10.0F;
            }
            else if (entityplayersp.movementInput.rightKeyDown && this.steeringAngle > -60.0F)
            {
                this.steeringAngle -= 10.0F;
            }

            if (entityplayersp.movementInput.jump)
            {
                this.isOversteer = true;
                this.oversteerAngle = -this.steeringAngle * 1.0F / (this.acceleration * (this.getAccelerationTick() / 10.0F) * (this.getAccelerationTick() / 10.0F)) * 0.5F;
            }
            else if (this.isOversteer && this.steeringAngle > -15.0F && this.steeringAngle < 15.0F && !entityplayersp.movementInput.leftKeyDown && !entityplayersp.movementInput.rightKeyDown || this.getAccelerationTick() == 0.0F)
            {
                this.isOversteer = false;
            }
        }
    }

    public boolean processInitialInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (!this.world.isRemote && !player.isSneaking())
        {
            if (itemstack != ItemStack.EMPTY && itemstack.getItem() instanceof ItemWD40)
            {
                player.openGui(XujMod.instance, 1, this.world, (int)this.posX, (int)this.posY, (int)this.posZ);
            }
            else if (itemstack != ItemStack.EMPTY && itemstack.getItem() instanceof ItemLugWrench)
            {
                player.openGui(XujMod.instance, 3, this.world, (int)this.posX, (int)this.posY, (int)this.posZ);
            }
            else if (itemstack != ItemStack.EMPTY && this.fuel.amount < this.getFuelTankSize())
            {
                NBTTagCompound nbttagcompound = itemstack.serializeNBT();

                if (nbttagcompound != null && nbttagcompound.hasKey("tag") && (nbttagcompound.getCompoundTag("tag").hasKey("fluid") || nbttagcompound.getCompoundTag("tag").hasKey("Fluid")))
                {
                    NBTTagCompound nbttagcompound1 = null;

                    if (nbttagcompound.getCompoundTag("tag").hasKey("fluid"))
                    {
                        nbttagcompound1 = nbttagcompound.getCompoundTag("tag").getCompoundTag("fluid");
                    }
                    else if (nbttagcompound.getCompoundTag("tag").hasKey("Fluid"))
                    {
                        nbttagcompound1 = nbttagcompound.getCompoundTag("tag").getCompoundTag("Fluid");
                    }

                    String s = nbttagcompound1.getString("FluidName");
                    int i = nbttagcompound1.getInteger("Amount");

                    if (isFuelCompatible(s) && (this.fuel.isFluidEqual(itemstack) || this.fuel.amount == 0) && i > 0)
                    {
                        this.fuel = new FluidStack(FluidRegistry.getFluid(s), this.fuel.amount);

                        if (this.fuel.amount + i <= this.getFuelTankSize())
                        {
                            this.fuel.amount += i;
                            i = 0;
                        }
                        else if (this.fuel.amount + i > this.getFuelTankSize())
                        {
                            int j = i - (this.getFuelTankSize() - this.fuel.amount);
                            this.fuel.amount = this.getFuelTankSize();
                            i = j;
                        }

                        if (itemstack.getCount() > 1)
                        {
                            ItemStack itemstack2 = new ItemStack(itemstack.getItem(), 1, itemstack.getMetadata());
                            NBTTagCompound nbttagcompound2 = itemstack2.serializeNBT();
                            NBTTagCompound nbttagcompound3 = new NBTTagCompound();

                            if (i > 0)
                            {
                                nbttagcompound3.setString("FluidName", s);
                                nbttagcompound3.setInteger("Amount", i);
                            }

                            NBTTagCompound nbttagcompound4 = new NBTTagCompound();
                            nbttagcompound4.setTag("fluid", nbttagcompound3);
                            nbttagcompound2.setTag("tag", nbttagcompound4);
                            itemstack2.deserializeNBT(nbttagcompound2);
                            this.world.spawnEntity(new EntityItem(this.world, player.posX, player.posY, player.posZ, itemstack2));
                            player.inventory.decrStackSize(player.inventory.currentItem, 1);
                            ItemStack itemstack1 = player.inventory.getStackInSlot(player.inventory.currentItem);
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, itemstack1.copy());
                        }
                        else
                        {
                            if (i == 0)
                            {
                                nbttagcompound.getCompoundTag("tag").removeTag("Fluid");
                                nbttagcompound.getCompoundTag("tag").removeTag("fluid");

                                if (nbttagcompound.getCompoundTag("tag").hasNoTags())
                                {
                                    nbttagcompound.removeTag("tag");
                                }
                            }
                            else
                            {
                                nbttagcompound1.setInteger("Amount", i);
                                nbttagcompound.setTag("fluid", nbttagcompound1);
                            }

                            itemstack.deserializeNBT(nbttagcompound);
                        }
                    }
                }
            }
            else
            {
                if (this.activePlayer == null)
                {
                    this.setActivePlayer(player.getUniqueID().toString());
                }

                player.setPosition(this.posX, this.posY, this.posZ);
                player.startRiding(this);
            }
        }

        if (!player.isSneaking())
        {
            if (itemstack != ItemStack.EMPTY && itemstack.getItem() instanceof ItemCarPart)
            {
                if (itemstack.getMetadata() > 0)
                {
                    CarPart carpart = CarPart.partList.get(itemstack.getMetadata() - 1);

                    if (!(carpart instanceof CarPartEngine) && (carpart.carFor == this.carType || carpart.carFor == EnumCarType.ANY) && !this.carpartslist.contains(carpart))
                    {
                        player.setHeldItem(hand, ItemStack.EMPTY);
                        this.addCarPart(carpart, itemstack);
                    }
                }
            }
            else if (itemstack != ItemStack.EMPTY && itemstack.getItem() instanceof ItemPaintCan)
            {
                if (itemstack.getMetadata() > 0)
                {
                    this.setColor(COLORS[16 - itemstack.getMetadata()]);
                    player.setHeldItem(hand, new ItemStack(ModItems.itemPaintBottle, 1, 0));
                }
            }
            else if (itemstack != ItemStack.EMPTY && itemstack.getItem() instanceof ItemCarBox && !itemstack.hasTagCompound())
            {
                NBTTagCompound nbttagcompound5 = new NBTTagCompound();
                nbttagcompound5.setInteger("cartype", this.carType.toInt());
                nbttagcompound5.setInteger("color", this.color);

                if (this.fuel != null)
                {
                    nbttagcompound5.setTag("fuel", this.getFuel().writeToNBT(new NBTTagCompound()));
                }

                if (this.carparts.length > 0)
                {
                    nbttagcompound5.setByteArray("carparts", this.carparts);
                }

                itemstack.setTagCompound(nbttagcompound5);
                this.setDead();
            }
        }

        return true;
    }

    private void updateFuel(float accel)
    {
        if (accel != 0.0F)
        {
            accel = MathHelper.abs(accel);
        }

        if (this.fuelFloat <= 0.001F)
        {
            this.fuelFloat = 1.0F;
            --this.fuel.amount;
        }
        else
        {
            if (getCompatibleFuels().get(this.fuel.getUnlocalizedName().substring(6)) == null)
            {
                System.out.println("What even. Someone tried feeding a car with " + this.fuel.getUnlocalizedName());
                System.out.println("Unexceptable! >:( @ " + this.getPosition());
                this.fuel.amount = 0;
                return;
            }

            this.fuelFloat -= accel * 0.1F * ((Float)getCompatibleFuels().get(this.fuel.getUnlocalizedName().substring(6))).floatValue() * this.engine.getMillageCoef();
        }
    }

    public boolean isActiveClient()
    {
        return Minecraft.getMinecraft().player.getUniqueID().equals(this.activePlayer);
    }

    public String getActivePlayer()
    {
        return this.activePlayer != null ? this.activePlayer.toString() : "";
    }

    public void setActivePlayer(String uuid)
    {
        if (uuid != null && UUID.fromString(uuid) != null)
        {
            this.activePlayer = UUID.fromString(uuid);
        }
    }

    public IBakedModel getBakedModel(OBJModel model)
    {
        if (this.bakedmodel == null)
        {
            this.bakedmodel = model.bake(model.getDefaultState(), DefaultVertexFormats.ITEM, RenderCar.dtg);
        }

        return this.bakedmodel;
    }

    public void addCarPart(CarPart part, ItemStack stack)
    {
        if (part != null && CarPart.partList.get(stack.getMetadata() - 1) != null)
        {
            for (int i = 0; i < this.carparts.length; ++i)
            {
                if (this.carparts[i] == stack.getMetadata() - 1)
                {
                    return;
                }
            }

            byte[] abyte = (byte[])this.carparts.clone();
            this.carparts = new byte[this.carparts.length + 1];

            for (int j = 0; j < abyte.length; ++j)
            {
                this.carparts[j] = abyte[j];
            }

            this.carparts[this.carparts.length - 1] = (byte)(stack.getMetadata() - 1);
            this.carpartslist.add(part);

            if (part instanceof CarPartEngine)
            {
                this.engine = (CarPartEngine)part;
                this.acceleration = 1.0F + 1.0E-5F * (float)this.engine.getHorsepower();
            }

            if (!this.world.isRemote)
            {
                XujMod.channel.sendToAllAround(new CarToClientMessage(this.getEntityId(), this.getActivePlayer(), this.getColor(), this.carparts, this.steeringAngle, this.fuel.writeToNBT(new NBTTagCompound())), new TargetPoint(this.dimension, this.posX, this.posY, this.posZ, 32.0D));
            }
        }
    }

    public void setCarParts(byte[] carparts)
    {
        this.carparts = carparts;
        this.carpartslist.clear();
        this.engine = null;

        for (int i = 0; i < carparts.length; ++i)
        {
            this.carpartslist.add(CarPart.partList.get(carparts[i]));

            if (CarPart.partList.get(carparts[i]) instanceof CarPartEngine)
            {
                this.engine = (CarPartEngine)CarPart.partList.get(carparts[i]);
                this.acceleration = 1.0F + 1.0E-5F * (float)this.engine.getHorsepower();
            }
        }

        if (!this.world.isRemote)
        {
            XujMod.channel.sendToAllAround(new CarToClientMessage(this.getEntityId(), this.getActivePlayer(), this.getColor(), carparts, this.steeringAngle, this.fuel.writeToNBT(new NBTTagCompound())), new TargetPoint(this.dimension, this.posX, this.posY, this.posZ, 32.0D));
        }
    }

    public void removeCarPart(int i)
    {
        byte[] abyte = (byte[])this.carparts.clone();
        this.carparts = new byte[this.carparts.length - 1];
        //int i = 0;

        for (int j = 0; i < abyte.length && j < this.carparts.length; ++i)
        {
            if (i != i)
            {
                this.carparts[j] = abyte[i];
                ++j;
            }
        }

        this.carpartslist.remove(i);

        if (!this.world.isRemote)
        {
            XujMod.channel.sendToAllAround(new CarToClientMessage(this.getEntityId(), this.getActivePlayer(), this.getColor(), this.carparts, this.steeringAngle, this.fuel.writeToNBT(new NBTTagCompound())), new TargetPoint(this.dimension, this.posX, this.posY, this.posZ, 32.0D));
        }
    }

    public void setEngine(CarPartEngine engine)
    {
        if (this.engine == null)
        {
            if (engine != null)
            {
                byte[] abyte = (byte[])this.carparts.clone();
                this.carparts = new byte[this.carparts.length + 1];

                for (int i = 0; i < abyte.length; ++i)
                {
                    this.carparts[i] = abyte[i];
                }

                this.carparts[this.carparts.length - 1] = (byte)CarPart.getID(engine);
                this.carpartslist.add(engine);
                this.engine = engine;
                this.acceleration = 1.0F + 1.0E-5F * (float)engine.getHorsepower();
            }
        }
        else
        {
            if (engine == null)
            {
                byte[] abyte1 = (byte[])this.carparts.clone();
                byte[] abyte2 = new byte[this.carparts.length - 1];
                int j = 0;

                for (int k = 0; j < abyte1.length && k < this.carparts.length; ++j)
                {
                    if (!(CarPart.partList.get(abyte1[j]) instanceof CarPartEngine))
                    {
                        abyte2[k] = abyte1[j];
                        ++k;
                    }
                }

                this.setCarParts(abyte2);
                this.engine = null;
                return;
            }

            int l = this.carpartslist.indexOf(this.engine);
            this.carparts[l] = (byte)CarPart.getID(engine);
            this.carpartslist.set(l, engine);
            this.engine = engine;
        }

        if (!this.world.isRemote)
        {
            XujMod.channel.sendToAllAround(new CarToClientMessage(this.getEntityId(), this.getActivePlayer(), this.getColor(), this.carparts, this.steeringAngle, this.fuel.writeToNBT(new NBTTagCompound())), new TargetPoint(this.dimension, this.posX, this.posY, this.posZ, 32.0D));
        }
    }

    public CarPartEngine getEngine()
    {
        return this.engine;
    }

    public void dismountRidingEntity()
    {
        this.activePlayer = null;
        super.dismountRidingEntity();
    }

    protected void setSize(float width, float height, float length)
    {
        float f = this.width;
        this.width = width;
        this.height = height;
        this.length = length;
        AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
        this.setEntityBoundingBox(new AxisAlignedBB(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ, axisalignedbb.minX + (double)this.width, axisalignedbb.minY + (double)this.height, axisalignedbb.minZ + (double)length));

        if (this.width > f && !this.firstUpdate && !this.world.isRemote)
        {
            this.move(MoverType.SELF, (double)(f - this.width), 0.0D, (double)(f - length));
        }
    }

    /**
     * Sets the width and height of the entity.
     */
    protected void setSize(float width, float height)
    {
        this.setSize(width, height, this.length);
    }

    /**
     * Sets the x,y,z of the entity from the given parameters. Also seems to set up a bounding box.
     */
    public void setPosition(double x, double y, double z)
    {
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        float f = this.width / 2.0F;
        float f1 = this.height;
        float f2 = this.length / 2.0F;
        this.setEntityBoundingBox(new AxisAlignedBB(x - (double)f, y, z - (double)f2, x + (double)f, y + (double)f1, z + (double)f2));
    }

    protected boolean canFitPassenger(Entity passenger)
    {
        return this.getPassengers().size() < this.getSeatPositions().length;
    }

    @Deprecated
    @Nullable

    /**
     * For vehicles, the first passenger is generally considered the controller and "drives" the vehicle. For example,
     * Pigs, Horses, and Boats are generally "steered" by the controlling passenger.
     */
    public Entity getControllingPassenger()
    {
        List<Entity> list = this.getPassengers();
        return list.isEmpty() ? null : (Entity)list.get(0);
    }

    public abstract float[][] getSeatPositions();

    public abstract float[] getWheelPos();

    public abstract float[] getExhaustPos();

    public abstract float[] getModelInfo();

    public abstract float[] getEngineOffset();

    public static EntityCar createCar(int id, World world)
    {
        switch (id)
        {
            case 0:
                return new EntityManta(world);

            case 1:
                return new EntityCarRX7FC(world);

            case 2:
                return new EntityCarE30(world);

            case 3:
                return new EntityCarE36(world);

            case 4:
                return new EntityTrabant(world);

            case 5:
                return new EntityCarNissanJunior(world);

            case 6:
                return new EntityCarLambo(world);

            case 7:
                return new EntityCarMustang1969(world);

            default:
                return null;
        }
    }

    public static Map<String, Float> getCompatibleFuels()
    {
        return fuelMap;
    }

    public static boolean isFuelCompatible(String name)
    {
        return getCompatibleFuels().containsKey(name);
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }

    @Nullable

    /**
     * Returns a boundingBox used to collide the entity with other entities and blocks. This enables the entity to be
     * pushable on contact, like boats or minecarts.
     */
    public AxisAlignedBB getCollisionBox(Entity entityIn)
    {
        return entityIn instanceof EntityLivingBase && !entityIn.isDead && ((EntityLivingBase)entityIn).getHealth() > 0.0F ? entityIn.getEntityBoundingBox() : null;
    }

    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    public boolean canBePushed()
    {
        return false;
    }

    @Nullable

    /**
     * Returns the collision bounding box for this entity
     */
    public AxisAlignedBB getCollisionBoundingBox()
    {
        return this.getEntityBoundingBox();
    }

    public FluidStack getFuel()
    {
        return this.fuel;
    }

    public void setFuel(FluidStack fuel)
    {
        this.fuel = fuel;
    }

    public void setFuel(NBTTagCompound fuel2)
    {
        this.fuel = FluidStack.loadFluidStackFromNBT(fuel2);
    }

    public int getFuelTankSize()
    {
        return 5000;
    }

    public boolean isBurnout()
    {
        return this.isBurnout;
    }

    public void setBurnout(boolean brn)
    {
        this.isBurnout = brn;
    }

    public void setOversteer(boolean oversteer)
    {
        this.isOversteer = oversteer;
    }

    public List<CarPart> getCarParts()
    {
        return this.carpartslist;
    }

    public boolean hasWheels()
    {
        return this.hasWheels;
    }

    public int getColor()
    {
        return this.color;
    }

    public void setColor(int color)
    {
        this.color = color;
    }

    public float getSteeringAngle()
    {
        return this.steeringAngle;
    }

    public void setSteeringAngle(float steeringAngle)
    {
        this.steeringAngle = steeringAngle;
    }

    public float getAccelerationTick()
    {
        return this.accelerationTick;
    }

    public void setAccelerationTick(float accelerationTick)
    {
        this.accelerationTick = accelerationTick;
    }

    public EnumCarType getCarType()
    {
        return this.carType;
    }
}
