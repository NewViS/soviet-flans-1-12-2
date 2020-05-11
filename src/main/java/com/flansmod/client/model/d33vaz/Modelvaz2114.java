//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: vaz2101
// Model Creator: 
// Created on: 01.03.2018 - 00:00:58
// Last changed on: 01.03.2018 - 00:00:58

package com.flansmod.client.model.d33vaz; //Path where the model is located

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicle;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modelvaz2114 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation vpv_099 = new ResourceLocation("minecraft:d33vaz/textures/model/vpv_099.png");
	private ResourceLocation molding15 = new ResourceLocation("minecraft:d33vaz/textures/model/molding15.png");
	private ResourceLocation molding = new ResourceLocation("minecraft:d33vaz/textures/model/molding.png");
	private ResourceLocation int_gr = new ResourceLocation("minecraft:d33vaz/textures/model/int_gr.png");
	private ResourceLocation leather_grey = new ResourceLocation("minecraft:d33vaz/textures/model/leather_greyb.png");
	private ResourceLocation underbody= new ResourceLocation("minecraft:d33vaz/textures/model/underbody.png");
	private ResourceLocation gr_panel2= new ResourceLocation("minecraft:d33vaz/textures/model/gr_panel2.png");
    private ResourceLocation obsh_potol= new ResourceLocation("minecraft:d33vaz/textures/model/obsh_potol.png");
	private ResourceLocation carpet= new ResourceLocation("minecraft:d33vaz/textures/model/carpet.png");
	private ResourceLocation gr_texture= new ResourceLocation("minecraft:d33vaz/textures/model/gr_texture.png");
	private ResourceLocation obivka2= new ResourceLocation("minecraft:d33vaz/textures/model/obivka2.png");
	//private ResourceLocation panel_texture= new ResourceLocation("minecraft:d33vaz/textures/model/panel_texture.png");
	//private ResourceLocation osfar_zad= new ResourceLocation("minecraft:d33vaz/textures/model/osfar_zad.png");
	//public IModelCustom modeldisk;
	public Modelvaz2114() //Same as Filename
	{	    	
		    steer = color; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33vaz/textures/model/vaz2114.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);
	        
	       // ResourceLocation disk = new ResourceLocation("minecraft:d33vaz/textures/model/disk/statusdisk_circle.obj");
	       // modeldisk = AdvancedModelLoader.loadModel(disk);
	       // modeldisk = new ModelWrapperDisplayList((WavefrontObject) modeldisk);

	        steerX = -34.5F;
	        steerY = 73.5F;
	        steerZ = -60F;
	        steerR = -15F;
	        
	        wheelX = 60F;
	        wheelX1 = 60F;
	        wheelY = 25F;
	        wheelZ = -139F;
	        wheelZ1 = 100F;
	        
	        maxSpedoAngle = 205F;
	    	//list = GL11.glGenLists(1);
	        //GL11.glNewList(list, GL11.GL_COMPILE);
	   	  	        
	        //GL11.glEndList();
	    	 
	        translateAll(0F, 0F, 0F);
	        
	 		//flipAll();	    
	}
	 @Override
	 public void renderColoredParts(){
		// GL11.glTranslatef(0.0F, -45.0F, 0.0F);	
		model.renderPart("bonnet_col");
		model.renderPart("boot_col");
		model.renderPart("bump_fro_col");
		model.renderPart("bump_rea_col");
		model.renderPart("door_lf_col");	
		model.renderPart("door_lr_col");
		model.renderPart("door_rf_col");
		model.renderPart("door_rr_col");
		model.renderPart("color1");
		model.renderPart("color");
		
		Minecraft.getMinecraft().renderEngine.bindTexture(molding15);
		model.renderPart("bump_fro_mold");
		model.renderPart("bump_rea_mold");
		model.renderPart("door_lf_mold");
		model.renderPart("door_lr_mold");
		model.renderPart("door_rf_mold");
		model.renderPart("door_rr_mold");
		model.renderPart("molding_kuzov");
		//model.renderAll();
	 }
	 @Override
	 public void renderWheels(){
		GL11.glScalef(0.96F, 0.96F, 0.96F);
		GL11.glColor3f(0.9F, 0.9F, 0.9F);
	 }
	 
	 @Override
	 public void renderSpedo(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(gr_panel2);
		 GL11.glTranslatef(-29F, 83.4F, -86.3F);
		 GL11.glRotatef(-21F, 1f, 0f, 0f);
	 }
	 
	 @Override
	 public void renderSteer(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(leather_grey);
			model.renderPart("steer");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.5F, 0.5F, 0.5F);
			model.renderPart("steer_chrome");
			GL11.glColor3f(1F, 1F, 1F);
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, -10.0F, 0.0F);	
		 Minecraft.getMinecraft().renderEngine.bindTexture(vpv_099);
			model.renderPart("mains");
			model.renderPart("boot_main");
			model.renderPart("bump_fro_main");
			model.renderPart("bump_rea_main");
			model.renderPart("mains_under");
			model.renderPart("main");
			model.renderPart("mains1");
			model.renderPart("door_lf_main");
			model.renderPart("door_lr_main");
			model.renderPart("door_rf_main");
			model.renderPart("door_rr_mains");
			Minecraft.getMinecraft().renderEngine.bindTexture(molding);
			model.renderPart("boot_mold");
			model.renderPart("molding");
			Minecraft.getMinecraft().renderEngine.bindTexture(int_gr);
			model.renderPart("sed");
			Minecraft.getMinecraft().renderEngine.bindTexture(obivka2);
			model.renderPart("boot_obiv");
			model.renderPart("obiv");
			Minecraft.getMinecraft().renderEngine.bindTexture(leather_grey);
			model.renderPart("door_lf_obiv");
			model.renderPart("door_lr_obiv");
			model.renderPart("door_rf_obiv");
			model.renderPart("door_rr_leagr");
			model.renderPart("lea");
			Minecraft.getMinecraft().renderEngine.bindTexture(underbody);
			model.renderPart("bump_fro_und");
			model.renderPart("bump_rea_und");
			model.renderPart("under");
			//gr_panel2= new ResourceLocation("minecraft:d33vaz/textures/model/gr_panel2.png");
			Minecraft.getMinecraft().renderEngine.bindTexture(gr_panel2);
			model.renderPart("panel");
			Minecraft.getMinecraft().renderEngine.bindTexture(obsh_potol);
			model.renderPart("potol");
			Minecraft.getMinecraft().renderEngine.bindTexture(gr_texture);
			model.renderPart("door_lf_kol");
			model.renderPart("door_rf_kol");
			model.renderPart("rul");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.7F, 0.7F, 0.7F);
			model.renderPart("bonnet_main");
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			GL11.glScalef(0.9F, 1F, 1F);
			model.renderPart("baraban");
			GL11.glScalef(1/0.9F, 1F, 1F);
			GL11.glColor3f(0.3F, 0.1F, 0.1F);
			model.renderPart("pruzin");
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDepthMask(false);
			GL11.glColor4f(0.7F, 0.7F, 0.7F, 0.6F);
			model.renderPart("far_gl");
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glDepthMask(true);
			
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
	 @Override
	 public void frontWheelsStuff(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			GL11.glTranslatef(-5F, 0, 0);
			model.renderPart("brakedisc_");
			GL11.glTranslatef(5F, 0, 0);
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
}