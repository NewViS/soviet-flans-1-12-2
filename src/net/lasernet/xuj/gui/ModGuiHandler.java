package net.lasernet.xuj.gui;

import java.util.List;
import net.lasernet.xuj.blocks.TileEntityHydraulicPress;
import net.lasernet.xuj.entity.EntityCar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler
{
    public static final int PARTMAKER = 0;
    public static final int CARPARTS = 1;
    public static final int HYDRAULICPRESS = 2;
    public static final int CARWHEELS = 3;

    public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
            case 1:
                BlockPos blockpos = new BlockPos(x, y, z);
                AxisAlignedBB axisalignedbb = new AxisAlignedBB(blockpos.down().east(), blockpos.up().west());
                List<EntityCar> list = world.getEntitiesWithinAABB(EntityCar.class, axisalignedbb);

                if (list.size() > 0)
                {
                    return new ContainerCar(player.inventory, list.get(0), false);
                }

                return null;

            case 2:
                TileEntityHydraulicPress tileentityhydraulicpress = (TileEntityHydraulicPress)world.getTileEntity(new BlockPos(x, y, z));
                return new ContainerHydraulicPress(player.inventory, tileentityhydraulicpress);

            case 3:
                BlockPos blockpos1 = new BlockPos(x, y, z);
                AxisAlignedBB axisalignedbb1 = new AxisAlignedBB(blockpos1.down().east(), blockpos1.up().west());
                List<EntityCar> list1 = world.getEntitiesWithinAABB(EntityCar.class, axisalignedbb1);

                if (list1.size() > 0)
                {
                    return new ContainerCar(player.inventory, list1.get(0), true);
                }

                return null;

            default:
                return null;
        }
    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
            case 1:
                return new GUICar(this.getServerGuiElement(ID, player, world, x, y, z), player.inventory);

            case 2:
                return new GUIHydraulicPress(this.getServerGuiElement(ID, player, world, x, y, z), player.inventory, (TileEntityHydraulicPress)world.getTileEntity(new BlockPos(x, y, z)));

            case 3:
                return new GUICar(this.getServerGuiElement(ID, player, world, x, y, z), player.inventory);

            default:
                return null;
        }
    }
}
