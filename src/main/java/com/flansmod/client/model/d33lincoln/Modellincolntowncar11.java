//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: vaz2101
// Model Creator: 
// Created on: 01.03.2018 - 00:00:58
// Last changed on: 01.03.2018 - 00:00:58

package com.flansmod.client.model.d33lincoln; //Path where the model is located

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicle;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modellincolntowncar11 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation towncar11 = new ResourceLocation("minecraft:d33vaz/textures/model/towncar11.png");
	private ResourceLocation prib = new ResourceLocation("minecraft:d33lincoln/textures/model/prib.png");
	private ResourceLocation stng = new ResourceLocation("minecraft:d33lincoln/textures/model/stng.png");
	public Modellincolntowncar11() //Same as Filename
	{	    	
		    steer = towncar11; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33lincoln/textures/model/towncar2011.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);
	        maxSpedoAngle = 230F;
	        
	        steerX = -41.5F;
	        steerY = 85F;
	        steerZ = -70F;
	        steerR = -30F;
	        
	        wheelX = 72F;
	        wheelX1 = 73F;
	        wheelY = 28F;
	        wheelZ = -175F;
	        wheelZ1 = 137F;
	        
	        translateAll(0F, 0F, 0F);
	        
	}
	 @Override
	 public void renderColoredParts(){
		model.renderPart("boot_col");
		model.renderPart("bonnet_col");
		model.renderPart("bump_reacol");
		model.renderPart("bump_frocol");
		model.renderPart("col");
		model.renderPart("door_rf_col");
		model.renderPart("door_lf_col");
		model.renderPart("door_lr_col");
		model.renderPart("door_rr_col");
		model.renderPart("wing_lf_col");
		model.renderPart("wing_rf_col");
	 }
	 @Override
	 public void renderWheels(){	
		GL11.glScalef(1.13F, 1.13F, 1.13F);
	 }
	 @Override
	 public void renderSpedo(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(prib);
		 GL11.glTranslatef(-52F, 88F, -94.5F);
		 GL11.glRotatef(-34F, 1f, 0f, 0f);
	 }
	 @Override
	 public void renderTexturedParts(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(towncar11);
			model.renderPart("boot_main");
			model.renderPart("boot_light");
			model.renderPart("boot_logo");
			model.renderPart("bonnet_logo");
			model.renderPart("ins");
			model.renderPart("far");
			model.renderPart("door_rf_ins");
			model.renderPart("door_lf_ins");
			model.renderPart("door_lr_ins");
			model.renderPart("door_rr_ins");
			Minecraft.getMinecraft().renderEngine.bindTexture(prib);
			model.renderPart("dashb");
			Minecraft.getMinecraft().renderEngine.bindTexture(stng);
			model.renderPart("boot_dno");
			model.renderPart("bonnet_dno");
			model.renderPart("bump_readno");
			model.renderPart("bump_frodno");
			model.renderPart("dno");
			model.renderPart("wing_lf_ins");
			model.renderPart("wing_rf_ins");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.6F, 0.6F, 0.6F);
			model.renderPart("boot_cr");
			model.renderPart("bonnet_cr");
			model.renderPart("bonnet_cr1");
			model.renderPart("bump_reacr");
			model.renderPart("bump_frocr");
			model.renderPart("cr");
			model.renderPart("door_rf_cr");
			model.renderPart("door_lf_cr");
			model.renderPart("door_lr_cr");
			model.renderPart("door_rr_cr");
			model.renderPart("wing_lf_cr");
			model.renderPart("wing_rf_cr");
		    GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("bl");
			model.renderPart("door_rf_bl");
			model.renderPart("door_lf_bl");
			model.renderPart("door_lr_bl");
			model.renderPart("door_rr_bl");
			model.renderPart("glass_bl");
			model.renderPart("bonnet_bl");
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDepthMask(false);
			GL11.glColor4f(0.6F, 0.6F, 0.65F, 0.6F);
			model.renderPart("glass_far");
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glDepthMask(true);
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