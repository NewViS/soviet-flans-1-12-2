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

public class Modelvaz21099 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation vpv_099 = new ResourceLocation("minecraft:d33vaz/textures/model/vpv_099.png");
	private ResourceLocation far = new ResourceLocation("minecraft:d33vaz/textures/model/far2.png");
	private ResourceLocation leather_black = new ResourceLocation("minecraft:d33vaz/textures/model/leather_greyb.png");
	private ResourceLocation carpet = new ResourceLocation("minecraft:d33vaz/textures/model/carpet.png");
	private ResourceLocation inter= new ResourceLocation("minecraft:d33vaz/textures/model/int1.png");
	private ResourceLocation pov= new ResourceLocation("minecraft:d33vaz/textures/model/pov.png");
    private ResourceLocation obsh_potol= new ResourceLocation("minecraft:d33vaz/textures/model/obsh_potol.png");
	private ResourceLocation underbody= new ResourceLocation("minecraft:d33vaz/textures/model/underbody.png");
	//private ResourceLocation kpp21093= new ResourceLocation("minecraft:d33vaz/textures/model/kpp21093.png");
	//private ResourceLocation mafon= new ResourceLocation("minecraft:d33vaz/textures/model/mafon.png");
	private ResourceLocation panel_te= new ResourceLocation("minecraft:d33vaz/textures/model/panel_te.png");
	private ResourceLocation far_z= new ResourceLocation("minecraft:d33vaz/textures/model/far_z.png");
	//public IModelCustom modeldisk;
	public Modelvaz21099() //Same as Filename
	{	    	
		    steer = panel_te; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33vaz/textures/model/vaz21099.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);
	        
	       // ResourceLocation disk = new ResourceLocation("minecraft:d33vaz/textures/model/disk/statusdisk_circle.obj");
	       // modeldisk = AdvancedModelLoader.loadModel(disk);
	       // modeldisk = new ModelWrapperDisplayList((WavefrontObject) modeldisk);

	        steerX = -32F;
	        steerY = 75F;
	        steerZ = -58.5F;
	        steerR = -20F;
	        
	        wheelX = 58F;
	        wheelX1 = 58F;
	        wheelY = 25F;
	        wheelZ = -142F;
	        wheelZ1 = 100F;
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
		model.renderPart("door_rf_col");
		model.renderPart("door_rf_col1");
		model.renderPart("door_lf_col");	
		model.renderPart("door_lf_col1");
		model.renderPart("door_rr_col1");
		model.renderPart("door_rr_col");
		model.renderPart("door_lr_col");
		model.renderPart("door_lr_col1");
		model.renderPart("porog");
		model.renderPart("color_main");
		model.renderPart("color");	
		//model.renderAll();
	 }
	 @Override
	 public void renderWheels(){
		GL11.glScalef(0.96F, 0.96F, 0.96F);
		/*Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		d33wheel.renderPart("status_tyre");*/
		//Minecraft.getMinecraft().renderEngine.bindTexture(status_disk);
		GL11.glColor3f(0.9F, 0.9F, 0.9F);
		//modeldisk.renderAll();
		//GL11.glColor3f(1F, 1F, 1F);
	 }
	 
	 @Override
	 public void renderSteer(){
		model.renderPart("rul");
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, -10.0F, 0.0F);	
		 Minecraft.getMinecraft().renderEngine.bindTexture(vpv_099);
		 model.renderPart("boot_tex");
			model.renderPart("tex");
			model.renderPart("chassis");
			Minecraft.getMinecraft().renderEngine.bindTexture(far);
			model.renderPart("fari");
			Minecraft.getMinecraft().renderEngine.bindTexture(leather_black);
			model.renderPart("leabl");
			Minecraft.getMinecraft().renderEngine.bindTexture(carpet);
			model.renderPart("pol");
			Minecraft.getMinecraft().renderEngine.bindTexture(obsh_potol);
			model.renderPart("potol");
			Minecraft.getMinecraft().renderEngine.bindTexture(inter);
			model.renderPart("door_rf_int");
			model.renderPart("door_lf_int");
			model.renderPart("door_rr_int");
			model.renderPart("door_lr_int");
			model.renderPart("sed");
			Minecraft.getMinecraft().renderEngine.bindTexture(pov);
			model.renderPart("pov");
			Minecraft.getMinecraft().renderEngine.bindTexture(panel_te);
			model.renderPart("panel");
			Minecraft.getMinecraft().renderEngine.bindTexture(far_z);
			model.renderPart("chassis1");	
			Minecraft.getMinecraft().renderEngine.bindTexture(underbody);
			model.renderPart("under");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.7F, 0.7F, 0.7F);
			model.renderPart("gluh");
			model.renderPart("door_rf_chrome");
			model.renderPart("chrome");
			model.renderPart("door_lf_chrome");
			model.renderPart("sed_chrome");	
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("bonnet_bl");
			model.renderPart("bump_fro");
			model.renderPart("bump_rea");
			model.renderPart("door_rf_bl");
			model.renderPart("door_lf_bl");	
			model.renderPart("door_rf_zrc");
			model.renderPart("door_lf_zrc");
			model.renderPart("door_rr_bl");
			model.renderPart("door_lr_bl");
			model.renderPart("black");
			model.renderPart("farb");
			model.renderPart("bag");
			model.renderPart("int_bl");	
			model.renderPart("far_bl");
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
	 @Override
	 public void frontWheelsStuff(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			GL11.glTranslatef(-10F, 0, 0);
			model.renderPart("brakedisc_");
			GL11.glTranslatef(10F, 0, 0);
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
}