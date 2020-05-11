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

public class Modelgaz20 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation leather_black = new ResourceLocation("minecraft:d33gaz/textures/model/leather_black.png");
	private ResourceLocation fara24 = new ResourceLocation("minecraft:d33gaz/textures/model/fara24.png");
	private ResourceLocation dirt = new ResourceLocation("minecraft:d33gaz/textures/model/dirt.png");
	private ResourceLocation engine = new ResourceLocation("minecraft:d33gaz/textures/model/engine.png");
	private ResourceLocation lights = new ResourceLocation("minecraft:d33gaz/textures/model/lights.png");
	private ResourceLocation logo = new ResourceLocation("minecraft:d33gaz/textures/model/logo.png");
	private ResourceLocation m20_chrome = new ResourceLocation("minecraft:d33gaz/textures/model/m20_chrome.png");
	private ResourceLocation m20v1 = new ResourceLocation("minecraft:d33gaz/textures/model/m20v1.png");
	private ResourceLocation m20v3 = new ResourceLocation("minecraft:d33gaz/textures/model/m20v3.png");
	private ResourceLocation m72v1 = new ResourceLocation("minecraft:d33gaz/textures/model/m72v1.png");
	private ResourceLocation pol = new ResourceLocation("minecraft:d33gaz/textures/model/pol.png");
	private ResourceLocation resh = new ResourceLocation("minecraft:d33gaz/textures/model/resh.png");
	public Modelgaz20() //Same as Filename
	{	    	
		    steer = resh; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33gaz/textures/model/pobeda.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);

	        steerX = -33F;
	        steerY = 90F;
	        steerZ = -50F;
	        steerR = -23F;
	        
			 wheelX = 57F;
		        wheelX1 = 60F;
		        wheelY = 25F;
		        wheelZ = -152F;
		        wheelZ1 = 105F;
	        
	        translateAll(0F, 0F, 0F);
	        
	}
	 @Override
	 public void renderColoredParts(){
		 //GL11.glTranslatef(0.0F, -3.0F, 0.0F);	
		 //GL11.glColor3f(0.05F, 0.05F, 0.05F);
		model.renderPart("color");
		model.renderPart("wing_rf_col");
		model.renderPart("wing_lf_col");
		model.renderPart("door_rr_col");
		model.renderPart("door_lf_col");
		model.renderPart("door_lr_col");
		model.renderPart("door_rf_col");
		
		model.renderPart("door_rr_col1");
		model.renderPart("door_lf_col1");
		model.renderPart("col1");
		model.renderPart("boot_col1");
		model.renderPart("door_rf_col1");
		model.renderPart("door_lr_col1");
		model.renderPart("bonnet_col");
		model.renderPart("boot_col");
		
	 }
	 @Override
	 public void renderSteer(){
		Minecraft.getMinecraft().renderEngine.bindTexture(m72v1);
		model.renderPart("rul_m72v1");
		Minecraft.getMinecraft().renderEngine.bindTexture(color);
		GL11.glColor3f(192/255F, 186/255F, 107/255F);
		model.renderPart("rul_vanil");
		GL11.glColor3f(0.6F, 0.6F, 0.6F);
		model.renderPart("rul_chrome");
		GL11.glColor3f(1F, 1F, 1F);
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
			
			/*Minecraft.getMinecraft().renderEngine.bindTexture(m72v1);
			//model.renderPart("reshet1");
			model.renderPart("m72v1");*/
			Minecraft.getMinecraft().renderEngine.bindTexture(resh);
			model.renderPart("reshet");
			Minecraft.getMinecraft().renderEngine.bindTexture(m20v1);
			model.renderPart("pribor");
			model.renderPart("logo");
			Minecraft.getMinecraft().renderEngine.bindTexture(m20v3);
			model.renderPart("m20v3");
			Minecraft.getMinecraft().renderEngine.bindTexture(m20_chrome);
			model.renderPart("reshetka");
			model.renderPart("bonnet_shild");
			Minecraft.getMinecraft().renderEngine.bindTexture(dirt);
			model.renderPart("tex");
			model.renderPart("gluh");
			model.renderPart("rama");
			model.renderPart("dno");
			Minecraft.getMinecraft().renderEngine.bindTexture(engine);
			model.renderPart("tex1");
			model.renderPart("engine");
			Minecraft.getMinecraft().renderEngine.bindTexture(lights);
			model.renderPart("lightsl");
			model.renderPart("lightsr");
			model.renderPart("wing_rf_far");
			model.renderPart("wing_lf_far");
			model.renderPart("boot_far");
			Minecraft.getMinecraft().renderEngine.bindTexture(pol);
			model.renderPart("pol");
			Minecraft.getMinecraft().renderEngine.bindTexture(leather_black);
			model.renderPart("sed");
			model.renderPart("door_rr_lea");
			model.renderPart("door_lf_lea");
			model.renderPart("door_lr_lea");
			model.renderPart("door_rf_lea");
			Minecraft.getMinecraft().renderEngine.bindTexture(fara24);
			model.renderPart("wing_rf_gl");
			model.renderPart("wing_lf_gl");
			/*Minecraft.getMinecraft().renderEngine.bindTexture(logo);
			model.renderPart("bonnet_logo");*/
			
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.6F, 0.6F, 0.6F);
			model.renderPart("door_rl_cr1");
			model.renderPart("door_rf_cr1");
			model.renderPart("chrome");
			model.renderPart("door_lf_cr1");
			model.renderPart("door_rr_cr1");
			model.renderPart("chrome1");
			model.renderPart("antcr");
			model.renderPart("wing_rf_cr");
			model.renderPart("wing_lf_cr");
			model.renderPart("door_rr_cr");
			model.renderPart("door_lf_cr");
			model.renderPart("door_lr_cr");
			model.renderPart("door_rf_cr");
			model.renderPart("boot_cr");
			model.renderPart("boot_ok");
			model.renderPart("bonnet_cr");
			model.renderPart("bump_fro01");
			model.renderPart("bump_rea01");
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			model.renderPart("grey");
			model.renderPart("grey1");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("black");
			model.renderPart("bl");
			model.renderPart("antbl");
			GL11.glColor3f(0.6F, 0.1F, 0.1F);
			model.renderPart("red");
			GL11.glColor3f(192/255F, 186/255F, 107/255F);
			model.renderPart("door_rl_vanil");
			model.renderPart("door_rf_vanil");
			model.renderPart("vanil");
			model.renderPart("door_lf_vanil");
			model.renderPart("door_rr_vanil");
			/*GL11.glEnable(GL11.GL_BLEND);
			GL11.glDepthMask(false);
			GL11.glColor4f(192/255F, 186/255F, 107/255F, 0.5F);
			model.renderPart("windscre");
			model.renderPart("door_rf_gl");
			model.renderPart("back_wind");
			model.renderPart("door_lf_gl");
			model.renderPart("door_rr_gl");
			model.renderPart("door_lr_gl");
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glDepthMask(true);*/
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