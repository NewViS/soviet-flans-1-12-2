package com.flansmod.common.driveables;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import com.flansmod.common.guns.ItemBullet;
import com.flansmod.common.parts.EnumPartCategory;
import com.flansmod.common.parts.ItemPart;
import com.flansmod.common.parts.PartType;

public class DriveableData implements IInventory
{
	/**
	 * The name of this driveable's type
	 */
	public String type;
	/**
	 * The sizes of each inventory (guns, bombs / mines, missiles / shells, cargo)
	 */
	public int numGuns, numBombs, numMissiles, numCargo;
	/**
	 * The inventory stacks
	 */
	public ItemStack[] ammo, bombs, missiles, cargo;
	/**
	 * The engine in this driveable
	 */
	public PartType engine;
	/**
	 * The stack in the fuel slot
	 */
	public ItemStack fuel;
	/**
	 * The amount of fuel in the tank
	 */
	public float fuelInTank;
	/**
	 * Each driveable part has a small class that holds its current status
	 */
	public HashMap<EnumDriveablePart, DriveablePart> parts;
	/**
	 * Paintjob index
	 */
	public int paintjobID;
	
	public ItemStack disk;
	//TODO
	public float fr = 0F;
    public float fg = 0F;
    public float fb = 0F;
	
	public String str1="statusdisk_5rect";
	public String str2="";
	public String str3="bort_grey_kuzov";
	public String disk_path="";
    public String disk_texture_path="";
    String[] subStr1;
    String delimeter1 = "_";
    public ResourceLocation disk_texture= new ResourceLocation("minecraft:d33vaz/textures/model/statusdisk.png");
	public ResourceLocation disk_model= new ResourceLocation("minecraft:d33vaz/textures/model/disk/statusdisk_5rect.obj");
	public ResourceLocation disk_model1= new ResourceLocation("minecraft:d33vaz/textures/model/disk/statusdisk_5rect.obj");
	
	public ResourceLocation kuzov_texture= new ResourceLocation("minecraft:d33vaz/textures/model/bort.png");
	public ResourceLocation kuzov_model= new ResourceLocation("minecraft:d33vaz/textures/model/kuzov/grey_kuzov.obj");
	public ResourceLocation kuzov_model1= new ResourceLocation("minecraft:d33vaz/textures/model/kuzov/grey_kuzov.obj");
	
	public DriveableData(NBTTagCompound tags, int paintjobID)
	{
		this(tags);
		this.paintjobID = paintjobID;
	}
	
	public DriveableData(NBTTagCompound tags)
	{
		parts = new HashMap<>();
		readFromNBT(tags);
	}
	//TODO
	public String getResourcePath(ResourceLocation res)
	{
		String str[];
		str= res.getPath().split("/");
		/*str=str[str.length-1].split("\\.");
		return str[0];*/
		return str[str.length-1];
	}
	
	public void readFromNBT(NBTTagCompound tag)
	{
		if(tag == null)
			return;
		if(!tag.hasKey("Type"))
			return;
		
		fr = tag.getFloat("FloatR");
		fg = tag.getFloat("FloatG");
		fb = tag.getFloat("FloatB");
		type = tag.getString("Type");
		str1 = tag.getString("Pathstr1");
		if(fr==0.00F&&fg==0.00F&&fb==0.00F){
			fr = (float)Math.random();
		    fg = (float)Math.random();
		    fb = (float)Math.random();
		}
		//disk_path = tag.getString("model_disk");
		//disk_texture_path = tag.getString("texture_disk");
		// Get disk texture and model
	       // str3=data.str1;
			if (disk_path != str1) {
				if (str1 != "") {
					subStr1 = str1.split(delimeter1);
					if (subStr1.length == 2) {
						/* if(subStr[0]!="") */disk_texture_path = subStr1[0];
						disk_texture = new ResourceLocation("minecraft:d33vaz/textures/model/" + disk_texture_path + ".png");
						/* if(subStr[1]!="") */disk_path = str1;
						disk_model = new ResourceLocation("minecraft:d33vaz/textures/model/disk/" + disk_path + ".obj");
						System.out.println(getResourcePath(disk_model));
						//d33wheel = AdvancedModelLoader.loadModel(disk_model);
					}
					else if (subStr1.length == 3) {
						/* if(subStr[0]!="") */disk_texture_path = subStr1[0];
						kuzov_texture = new ResourceLocation("minecraft:d33vaz/textures/model/" + disk_texture_path + ".png");
						/* if(subStr[1]!="") */disk_path = subStr1[1]+"_"+subStr1[2];
						kuzov_model = new ResourceLocation("minecraft:d33vaz/textures/model/kuzov/" + disk_path + ".obj");
						System.out.println(getResourcePath(kuzov_model));
						//d33wheel = AdvancedModelLoader.loadModel(disk_model);
					}
				} 
				else /*if (data.str1 == "") */{
					disk_texture_path = disk_path = "";
					disk_texture = new ResourceLocation("minecraft:d33vaz/textures/model/statusdisk.png");
					disk_model = disk_model1;
					
					kuzov_texture = new ResourceLocation("minecraft:d33vaz/textures/model/bort.png");
					kuzov_model = kuzov_model1;
					System.out.println(getResourcePath(disk_model));
					System.out.println(getResourcePath(kuzov_model));
					//d33wheel = AdvancedModelLoader.loadModel(disk_model);
				}
			}
		
		type = tag.getString("Type");
		DriveableType dType = DriveableType.getDriveable(type);
		numBombs = dType.numBombSlots;
		numCargo = dType.numCargoSlots;
		numMissiles = dType.numMissileSlots;
		numGuns = dType.ammoSlots();
		engine = PartType.getPart(tag.getString("Engine"));
		paintjobID = tag.getInteger("Paint");
		ammo = new ItemStack[numGuns];
		bombs = new ItemStack[numBombs];
		missiles = new ItemStack[numMissiles];
		cargo = new ItemStack[numCargo];
		for(int i = 0; i < numGuns; i++)
			ammo[i] = new ItemStack(tag.getCompoundTag("Ammo " + i));
		
		for(int i = 0; i < numBombs; i++)
			bombs[i] = new ItemStack(tag.getCompoundTag("Bombs " + i));
		
		for(int i = 0; i < numMissiles; i++)
			missiles[i] = new ItemStack(tag.getCompoundTag("Missiles " + i));
		
		for(int i = 0; i < numCargo; i++)
			cargo[i] = new ItemStack(tag.getCompoundTag("Cargo " + i));
		
		fuel = new ItemStack(tag.getCompoundTag("Fuel"));
		disk = new ItemStack(tag.getCompoundTag("Disk"));
		fuelInTank = tag.getInteger("FuelInTank");
		for(EnumDriveablePart part : EnumDriveablePart.values())
		{
			parts.put(part, new DriveablePart(part, dType.health.get(part)));
		}
		for(DriveablePart part : parts.values())
		{
			part.readFromNBT(tag);
		}
	}
	
	public void writeToNBT(NBTTagCompound tag)
	{
		tag.setString("Type", type);
		tag.setString("Engine", engine.shortName);
		tag.setInteger("Paint", paintjobID);
		
		tag.setFloat("FloatR", fr);
		tag.setFloat("FloatG", fg);
		tag.setFloat("FloatB", fb);
		
		for(int i = 0; i < ammo.length; i++)
		{
			if(ammo[i] != null)
				tag.setTag("Ammo " + i, ammo[i].writeToNBT(new NBTTagCompound()));
		}
		for(int i = 0; i < bombs.length; i++)
		{
			if(bombs[i] != null)
				tag.setTag("Bombs " + i, bombs[i].writeToNBT(new NBTTagCompound()));
		}
		for(int i = 0; i < missiles.length; i++)
		{
			if(missiles[i] != null)
				tag.setTag("Missiles " + i, missiles[i].writeToNBT(new NBTTagCompound()));
		}
		for(int i = 0; i < cargo.length; i++)
		{
			if(cargo[i] != null)
				tag.setTag("Cargo " + i, cargo[i].writeToNBT(new NBTTagCompound()));
		}
		if(fuel != null)
			tag.setTag("Fuel", fuel.writeToNBT(new NBTTagCompound()));
		if(disk != null)
			tag.setTag("Disk", disk.writeToNBT(new NBTTagCompound()));
		tag.setInteger("FuelInTank", (int)fuelInTank);
		for(DriveablePart part : parts.values())
		{
			part.writeToNBT(tag);
		}
	}
	
	@Override
	public int getSizeInventory()
	{
		return getDiskSlot() + 1; 
	}
	
	@Override
	public ItemStack getStackInSlot(int i)
	{
		//Find the correct inventory
		ItemStack[] inv = ammo;
		if(i >= ammo.length)
		{
			i -= ammo.length;
			inv = bombs;
			if(i >= bombs.length)
			{
				i -= bombs.length;
				inv = missiles;
				if(i >= missiles.length)
				{
					i -= missiles.length;
					inv = cargo;
					if(i >= cargo.length)
					{
						if(i==getFuelSlot())
							return fuel;
							else
							if(i==getDiskSlot())
							return disk;
					}
				}
			}
		}
		//Return the stack in the slot
		return inv[i];
	}
	
	@Override
	public ItemStack decrStackSize(int i, int j)
	{
		//Find the correct inventory
		ItemStack[] inv = ammo;
		if(i >= ammo.length)
		{
			i -= ammo.length;
			inv = bombs;
			if(i >= bombs.length)
			{
				i -= bombs.length;
				inv = missiles;
				if(i >= missiles.length)
				{
					i -= missiles.length;
					inv = cargo;
					if(i >= cargo.length)
					{
						//Put the fuel stack in a stack array just to simplify the code
						i -= cargo.length;
						inv = new ItemStack[2];
						inv[0] = fuel;	
						inv[1] = disk;
						
						//setInventorySlotContents(getFuelSlot(), ItemStack.EMPTY.copy());
					}
				}
			}
		}
		//Decrease the stack size
		if(inv[i] != null)
		{
			if(inv[i].getCount() <= j)
			{
				ItemStack itemstack = inv[i];
				inv[i] = ItemStack.EMPTY.copy();
				return itemstack;
			}
			ItemStack itemstack1 = inv[i].splitStack(j);
			if(inv[i].getCount() <= 0)
			{
				inv[i] = ItemStack.EMPTY.copy();
			}
			return itemstack1;
		}
		else
		{
			return ItemStack.EMPTY.copy();
		}
		
	}
	
	@Override
	public void setInventorySlotContents(int i, ItemStack stack)
	{
		//Find the correct inventory
		ItemStack[] inv = ammo;
		if(i >= ammo.length)
		{
			i -= ammo.length;
			inv = bombs;
			if(i >= bombs.length)
			{
				i -= bombs.length;
				inv = missiles;
				if(i >= missiles.length)
				{
					i -= missiles.length;
					inv = cargo;
					if(i >= cargo.length)
					{
						if(i==getFuelSlot())
							//fuel = stack;
								fuel = stack;
							else
							if(i==getDiskSlot()){
								//fuel = stack;
									disk = stack;
									if(disk!=null && disk.getItem() instanceof ItemPart){
										ItemPart diskItem = (ItemPart)disk.getItem();
										if(diskItem.type.category == EnumPartCategory.DISK)
							                str2 = disk.getTranslationKey();
										//TODO
										System.out.println(str2);
										  String[] subStr;
									      String delimeter = "\\."; // Разделитель
									      subStr = str2.split(delimeter);
									      if(subStr.length==2)
									      if(subStr[1] != null)
									    	  if(str1!= subStr[1])str1 =subStr[1];
										}
									else str1 = "";
									System.out.println(str1);
									// Get disk texture and model
								       // str3=data.str1;
										if (disk_path != str1) {
											if (str1 != "") {
												subStr1 = str1.split(delimeter1);
												if (subStr1.length == 2) {
													/* if(subStr[0]!="") */disk_texture_path = subStr1[0];
													disk_texture = new ResourceLocation("minecraft:d33vaz/textures/model/" + disk_texture_path + ".png");
													/* if(subStr[1]!="") */disk_path = str1;
													disk_model = new ResourceLocation("minecraft:d33vaz/textures/model/disk/" + disk_path + ".obj");
													System.out.println(getResourcePath(disk_model));
													//d33wheel = AdvancedModelLoader.loadModel(disk_model);
												}
												else if (subStr1.length == 3) {
													/* if(subStr[0]!="") */disk_texture_path = subStr1[0];
													kuzov_texture = new ResourceLocation("minecraft:d33vaz/textures/model/" + disk_texture_path + ".png");
													/* if(subStr[1]!="") */disk_path = subStr1[1]+"_"+subStr1[2];
													kuzov_model = new ResourceLocation("minecraft:d33vaz/textures/model/kuzov/" + disk_path + ".obj");
													System.out.println(getResourcePath(kuzov_model));
													//d33wheel = AdvancedModelLoader.loadModel(disk_model);
												}
											}
											else /*if (data.str1 == "") */{
												disk_texture_path = disk_path = "";
												disk_texture = new ResourceLocation("minecraft:d33vaz/textures/model/statusdisk.png");
												disk_model = disk_model1;
												
												kuzov_texture = new ResourceLocation("minecraft:d33vaz/textures/model/bort.png");
												kuzov_model = kuzov_model1;
												System.out.println(getResourcePath(disk_model));
												System.out.println(getResourcePath(kuzov_model));
												//d33wheel = AdvancedModelLoader.loadModel(disk_model);
											}
										}
							}
							return;
					}
				}
			}
		}
		//Set the stack
		inv[i] = stack;
	}
	
	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}
	
	@Override
	public void markDirty()
	{
	}
	
	@Override
	public boolean isUsableByPlayer(EntityPlayer player)
	{
		return true;
	}
	
	public int getAmmoInventoryStart()
	{
		return 0;
	}
	
	public int getBombInventoryStart()
	{
		return ammo.length;
	}
	
	public int getMissileInventoryStart()
	{
		return ammo.length + bombs.length;
	}
	
	public int getCargoInventoryStart()
	{
		return ammo.length + bombs.length + missiles.length;
	}
	
	public int getFuelSlot()
	{
		return ammo.length + bombs.length + missiles.length + cargo.length;
	}
	
	public int getDiskSlot()
	{
		return ammo.length + bombs.length + missiles.length + cargo.length + 1;
	}
	
	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		if(i < getBombInventoryStart() && itemstack != null && itemstack.getItem() instanceof ItemBullet) //Ammo
		{
			return true;
		}
		if(i >= getBombInventoryStart() && i < getMissileInventoryStart() && itemstack != null && itemstack.getItem() instanceof ItemBullet) //Ammo
		{
			return true;
		}
		if(i >= getMissileInventoryStart() && i < getCargoInventoryStart() && itemstack != null && itemstack.getItem() instanceof ItemBullet)
		{
			return true;
		}
		if(i >= getCargoInventoryStart() && i < getFuelSlot())
		{
			return true;
		}
		if(i == getFuelSlot() && itemstack != null && itemstack.getItem() instanceof ItemPart && ((ItemPart)itemstack.getItem()).type.category == EnumPartCategory.FUEL) //Fuel
		{
			return true;
		}
		
		if(i == getDiskSlot() && itemstack != null/* && itemstack.getItem() instanceof ItemPart && ((ItemPart)itemstack.getItem()).type.category == 9*/) //Fuel
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public String getName()
	{
		return "Flan's Secret Data";
	}
	
	@Override
	public boolean hasCustomName()
	{
		return false;
	}
	
	@Override
	public ITextComponent getDisplayName()
	{
		return null;
	}
	
	@Override
	public void openInventory(EntityPlayer player)
	{
	}
	
	@Override
	public void closeInventory(EntityPlayer player)
	{
	}
	
	@Override
	public int getField(int id)
	{
		return 0;
	}
	
	@Override
	public void setField(int id, int value)
	{
		
	}
	
	@Override
	public int getFieldCount()
	{
		return 0;
	}
	
	@Override
	public void clear()
	{
		
	}
	
	@Override
	public boolean isEmpty()
	{
		return false;
	}
	
	@Override
	public ItemStack removeStackFromSlot(int index)
	{
		return ItemStack.EMPTY.copy();
	}
	
}
