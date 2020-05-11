//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: vaz2101
// Model Creator: 
// Created on: 01.03.2018 - 00:00:58
// Last changed on: 01.03.2018 - 00:00:58

package com.flansmod.client.model.d33gaz; //Path where the model is located

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicle;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modelgaz2410 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation leather_black = new ResourceLocation("minecraft:d33gaz/textures/model/leather_black.png");
	private ResourceLocation volga_main = new ResourceLocation("minecraft:d33gaz/textures/model/volga24_main.png");
	private ResourceLocation volga_salon = new ResourceLocation("minecraft:d33gaz/textures/model/volga_salon.png");
	private ResourceLocation fara24 = new ResourceLocation("minecraft:d33gaz/textures/model/fara24.png");
	private ResourceLocation gaz24 = new ResourceLocation("minecraft:d33gaz/textures/model/gaz24.png");
	private ResourceLocation gaz24_wheel = new ResourceLocation("minecraft:d33gaz/textures/model/gaz24_wheel.png");
	private ResourceLocation inside2 = new ResourceLocation("minecraft:d33gaz/textures/model/inside2.png");
	private ResourceLocation inside3_material = new ResourceLocation("minecraft:d33gaz/textures/model/inside3_material.png");
	private ResourceLocation potol = new ResourceLocation("minecraft:d33gaz/textures/model/potol.png");
	private ResourceLocation rombik = new ResourceLocation("minecraft:d33gaz/textures/model/rombik.png");
	private ResourceLocation stuff24 = new ResourceLocation("minecraft:d33gaz/textures/model/stuff24.png");
	private ResourceLocation texture_for_engine = new ResourceLocation("minecraft:d33gaz/textures/model/texture_for_engine.png");
	private ResourceLocation torpedo3 = new ResourceLocation("minecraft:d33gaz/textures/model/torpedo3.png");
	public Modelgaz2410() //Same as Filename
	{	    	
		    steer = volga_salon; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33gaz/textures/model/gaz24_10.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);

	        steerX = -32.5F;
	        steerY = 76F;
	        steerZ = -52F;
	        steerR = -15F;
	        
	        wheelX = 64F;
	        wheelX1 = 64F;
	        wheelY = 25F;
	        wheelZ = -142F;
	        wheelZ1 = 125F;
	        
	        translateAll(0F, 0F, 0F);
	        
	}
	 @Override
	 public void renderColoredParts(){
		 //GL11.glTranslatef(0.0F, -3.0F, 0.0F);	
		 //GL11.glColor3f(0.05F, 0.05F, 0.05F);
	        
		    model.renderPart("col1");
			model.renderPart("col");
			model.renderPart("col3");
			model.renderPart("col2");
			model.renderPart("door_lf_col");
			model.renderPart("door_lr_col");
			model.renderPart("door_rr_col");
			model.renderPart("wing_lf_col");
			model.renderPart("wing_rf_col");
			model.renderPart("bonnet_hi_");
			model.renderPart("boot_col");
			model.renderPart("door_rf_col");
			model.renderPart("door_lf_col1");
			model.renderPart("door_lr_col1");
			model.renderPart("door_rr_col1");
			model.renderPart("door_rf_col1");
		
	 }
	 @Override
	 public void renderSteer(){
		//Minecraft.getMinecraft().renderEngine.bindTexture(rul);
		model.renderPart("rul_logo");
		Minecraft.getMinecraft().renderEngine.bindTexture(leather_black);
		model.renderPart("rul_bl");
	 }
	 @Override
	 public void renderWheels(){	
		//GL11.glScalef(0.95F, 0.95F, 0.95F);
		/*Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		d33wheel.renderPart("status_tyre");
		Minecraft.getMinecraft().renderEngine.bindTexture(statusdisk);
		d33wheel.renderPart("vazrect_shtamp");*/
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, -10.0F, 0.0F);	
		 //GL11.glTranslatef(0.0F, 8.0F, 0.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(leather_black);
			model.renderPart("Interior2");
			model.renderPart("door_lf_ok1");
			model.renderPart("door_rf_ok1");
			model.renderPart("door_lr_ok1");
			model.renderPart("door_rr_ok1");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			
			Minecraft.getMinecraft().renderEngine.bindTexture(volga_main);
			model.renderPart("Interior1");
			model.renderPart("Chassis");
			model.renderPart("door_lf_ok");
			model.renderPart("door_rf_ok2");
			model.renderPart("door_lr_ok");
			model.renderPart("door_rr_ok");
			model.renderPart("_410_pov1");
			model.renderPart("_410_pov");
			
			Minecraft.getMinecraft().renderEngine.bindTexture(volga_salon);
			model.renderPart("Interior3");
			model.renderPart("logo");
			model.renderPart("door_lf_ok2");
			model.renderPart("door_rf_ok");
			model.renderPart("door_lr_ok2");
			model.renderPart("door_rr_ok2");
			model.renderPart("");
			model.renderPart("");
			
			Minecraft.getMinecraft().renderEngine.bindTexture(texture_for_engine);
			model.renderPart("underbody1");
			Minecraft.getMinecraft().renderEngine.bindTexture(stuff24);
			model.renderPart("body");
			model.renderPart("body1");
			model.renderPart("bla1");
			model.renderPart("bl2");
			model.renderPart("bump_reacr");
			model.renderPart("bump_reabl");
			model.renderPart("wing_lf_pov");
			model.renderPart("wing_lf_und");
			model.renderPart("underbody");
			model.renderPart("wing_rf_pov");
			model.renderPart("bla");
			model.renderPart("wing_rf_und");
			model.renderPart("bump_frocr");
			model.renderPart("bump_frobl");
			model.renderPart("boot_cr1");
			
			Minecraft.getMinecraft().renderEngine.bindTexture(fara24);
			model.renderPart("Object01");
			model.renderPart("Object02");
			model.renderPart("far");
			
			Minecraft.getMinecraft().renderEngine.bindTexture(rombik);
			model.renderPart("vzb");
			
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.6F, 0.6F, 0.6F);
			model.renderPart("dvorn");
			model.renderPart("underbody2");
			model.renderPart("underbody6");
			model.renderPart("cr");
			model.renderPart("cr1");
			model.renderPart("boot_cr");
			model.renderPart("");
			model.renderPart("");
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			model.renderPart("underbody3");
			model.renderPart("underbody5");
			model.renderPart("underbody7");
			model.renderPart("underbody8");
			model.renderPart("underbody9");
			model.renderPart("underbody10");
			model.renderPart("underbody12");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("underbody4");
			model.renderPart("bl");
			model.renderPart("wing_lf_bl");
			model.renderPart("wing_rf_bl");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
			
	 }
	 /*@Override
	 public void frontWheelsStuff(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			GL11.glTranslatef(-10F, 0, 0);
			model.renderPart("");
			GL11.glTranslatef(10F, 0, 0);
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }*/
}