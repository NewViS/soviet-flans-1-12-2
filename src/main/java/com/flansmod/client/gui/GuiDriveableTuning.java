package com.flansmod.client.gui;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.io.IOException;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import com.flansmod.client.FlansModResourceHandler;
import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.ContainerDriveableMenu;
import com.flansmod.common.driveables.DriveableData;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.driveables.mechas.MechaType;
import com.flansmod.common.network.PacketDriveableGUI;


public class GuiDriveableTuning extends GuiContainer
{
	private static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/vehicletuning.png");

	private boolean colorchoice = false;
	private int clc=0;
    public GuiDriveableTuning(InventoryPlayer inventoryplayer, World world1, EntityDriveable entPlane)
    {
        super(new ContainerDriveableMenu(inventoryplayer, world1, false, true, entPlane));
		plane = entPlane;
		//161
		ySize = 187;
		world = world1;
		inventory = inventoryplayer;
    }
    @Override
    public void initGui(){
    	super.initGui();
    	//GuiButton tuningColor = new GuiButton(1, width / 2 -82, height / 2 -65, 46, 20, "Color");
		//bombButton.enabled = type.numBombSlots > 0;
		//buttonList.add(tuningColor);
    	
    }
    
    @Override
    public void actionPerformed(GuiButton button){
    	 if(button.id == 1) //Tuning
         {
    		 if(clc==1){
    			 colorchoice=false;
    		 }else
    		 {colorchoice=true;}
    		 clc=0;
         }
    }
    
    @Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
    {
    	ScaledResolution scaledresolution = new ScaledResolution(mc);
    	int w = scaledresolution.getScaledWidth();
		int h = scaledresolution.getScaledHeight();
    	spinner++;
    	DriveableType selectedType = plane.getDriveableType();
    	//w = w / 2 - 88;
		//h = h / 2 - 99;
		w=41;
		h=38;
    	//Render rotating driveable model
    			GL11.glPushMatrix();
    			GL11.glEnable(GL11.GL_DEPTH_TEST);
    			GL11.glEnable(GL11.GL_ALPHA_TEST);
    			GL11.glTranslatef(w, h, 100);
    			if(selectedType instanceof MechaType)
    				GL11.glTranslatef(0, 15, 0);
    			GL11.glScalef(-50F * selectedType.modelScale / selectedType.cameraDistance, 50F * selectedType.modelScale / selectedType.cameraDistance, 50F * selectedType.modelScale / selectedType.cameraDistance);
    			GL11.glRotatef(180F, 0F, 0F, 1F);
    			GL11.glRotatef(30F, 1F, 0F, 0F);
    			GL11.glRotatef(spinner / 5F, 0F, 1F, 0F);
    			mc.renderEngine.bindTexture(FlansModResourceHandler.getTexture(selectedType));
    			//selectedType.model.render(selectedType);
    			selectedType.model.render(plane, 0F);
    			GL11.glDisable(GL11.GL_DEPTH_TEST);
    			GL11.glDisable(GL11.GL_ALPHA_TEST);
    			GL11.glPopMatrix();
    			
    	
    			fontRenderer.drawString(plane.getDriveableType().name + " - Tuning", 6, 2, 0x404040);
    			fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
    }

    @Override
	protected void drawGuiContainerBackgroundLayer(float f, int i1, int j1)
    {
		long newTime = mc.world.getWorldInfo().getWorldTime();
		if(newTime > lastTime)
		{
			lastTime = newTime;
			if(newTime % 5 == 0)
				anim++;
		}
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        
        mc.renderEngine.bindTexture(texture);

        int j = (width - xSize) / 2;
        int k = (height - ySize) / 2;
        drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
        
    }
	
	@Override
	protected void mouseClicked(int i, int j, int k)
    {
        try {
			super.mouseClicked(i, j, k);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int m = i - (width - xSize) / 2;
		int n = j - (height - ySize) / 2;
		if(m > 161 && m < 171 && n > 5 && n < 15)
		{
			 mc.displayGuiScreen(new GuiDriveableMenu(inventory, world, plane));
		}
		if(m > 87 && m < 153 && n > 14 && n < 50){

		try {
			PointerInfo a = MouseInfo.getPointerInfo();
			Point b = a.getLocation();
			int x = (int) b.getX();
			int y = (int) b.getY();
			Robot robot = new Robot();
			Color colors = robot.getPixelColor(x, y);
			colorchoice = false;
			/*System.out.println("Red   = " + colors.getRed());
            System.out.println("Green = " + colors.getGreen());
            System.out.println("Blue  = " + colors.getBlue());*/
            DriveableData data = plane.getDriveableData();
            data.fr = colors.getRed()/255F;
            data.fg = colors.getGreen()/255F;
            data.fb = colors.getBlue()/255F;
		} catch (AWTException e) {
			System.err.println(e.getMessage() + " выбор цвета");
			System.exit(0);
		}
		}
	}

	public World world;
	public InventoryPlayer inventory;
	public EntityDriveable plane;
	private int anim = 0;
	private long lastTime;
	private float spinner = 0;
}
