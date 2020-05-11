//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: vaz2101
// Model Creator: 
// Created on: 01.03.2018 - 00:00:58
// Last changed on: 01.03.2018 - 00:00:58

package com.flansmod.client.model.d33chevrolet; //Path where the model is located

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicle;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modelchevsubur8 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation body = new ResourceLocation("minecraft:d33chevrolet/textures/model/leather_black.png");
	private ResourceLocation bodypaint = new ResourceLocation("minecraft:d33chevrolet/textures/model/bodypaint.png");
	private ResourceLocation chev1 = new ResourceLocation("minecraft:d33chevrolet/textures/model/chev1.png");
	private ResourceLocation inter11 = new ResourceLocation("minecraft:d33chevrolet/textures/model/inter11.png");
	private ResourceLocation stuf41 = new ResourceLocation("minecraft:d33chevrolet/textures/model/stuf41.png");
	private ResourceLocation sub_light3 = new ResourceLocation("minecraft:d33chevrolet/textures/model/sub_light3.png");
	public Modelchevsubur8() //Same as Filename
	{	    	
		    steer = chev1; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33chevrolet/textures/model/suburban8.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);
	        maxSpedoAngle = 145F;
	        
	        steerX = -40F;
	        steerY = 99.5F;
	        steerZ = -84F;
	        steerR = -20F;
	        
	        wheelX = 58F;
	        wheelX1 = 57F;
	        wheelY = 26F;
	        wheelZ = -175F;
	        wheelZ1 = 142F;
	        
	        GL11.glTranslatef(0F, 100F, 0F);
	        
	}
	 @Override
	 public void renderColoredParts(){
	Minecraft.getMinecraft().renderEngine.bindTexture(bodypaint);
		model.renderPart("bump_col");
		model.renderPart("door_lf_col");
		model.renderPart("bumprea_col");
		model.renderPart("body");
		model.renderPart("boot_col");
		model.renderPart("door_lr_col");
		model.renderPart("door_rr_col");
		model.renderPart("door_rf_col");
		model.renderPart("bonnet");
	 }
	 @Override
	 public void renderSpedo(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(chev1);
		 GL11.glTranslatef(-33.7F, 105.4F, -103.3F);
		 GL11.glRotatef(-24F, 0f, 0f, 1f);
		 GL11.glRotatef(-14F, 1f, 0f, 0f);
	 }
	 @Override
	 public void renderSteer(){
	        model.renderPart("rul_tex");
			Minecraft.getMinecraft().renderEngine.bindTexture(inter11);
			model.renderPart("rul_drev");
	 }
	 @Override
	 public void pre(){
		 GL11.glTranslatef(0F, 9F, 0F);
	 }
	 @Override
	 public void renderWheels(){	
		GL11.glScalef(1.35F, 1.35F, 1.45F);
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		
		 Minecraft.getMinecraft().renderEngine.bindTexture(chev1);
		 	model.renderPart("sal_tex");
			model.renderPart("door_rf_ruk");
			model.renderPart("door_lf_ruk");
			model.renderPart("door_lr_ruk");
			model.renderPart("bump_chev");
			model.renderPart("door_rr_ruk");
			model.renderPart("chev_logo");
		Minecraft.getMinecraft().renderEngine.bindTexture(inter11);
		 	model.renderPart("sal_drev");
		 	model.renderPart("sal_drev2");
			model.renderPart("door_lf_drev");
			model.renderPart("door_rr_drev");
			model.renderPart("door_lr_drev");
			model.renderPart("door_rf_drev");
			Minecraft.getMinecraft().renderEngine.bindTexture(body);
			model.renderPart("boot_int");
			model.renderPart("bump_reshet");
			model.renderPart("verh");
			model.renderPart("door_rr_obiv");
			model.renderPart("door_lf_obiv");
			model.renderPart("dno");
			model.renderPart("sal_potol");
			model.renderPart("sal_potol2");
			model.renderPart("door_rf_obiv");
			model.renderPart("door_lr_biv");
			Minecraft.getMinecraft().renderEngine.bindTexture(bodypaint);
			model.renderPart("bumprea_body");
			Minecraft.getMinecraft().renderEngine.bindTexture(sub_light3);
			model.renderPart("bag_far");
			model.renderPart("far");
			model.renderPart("farpi_tex");
			Minecraft.getMinecraft().renderEngine.bindTexture(stuf41);
			model.renderPart("sal_podves");
			model.renderPart("farpi_bl");
			model.renderPart("bumprea_dno");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.6F, 0.6F, 0.6F);
			model.renderPart("door_rf_shild");
			model.renderPart("sal_cr");
			model.renderPart("door_rf_cr");
			model.renderPart("bump_cr");
			model.renderPart("shild1");
			model.renderPart("door_lf_cr");
			model.renderPart("door_lf_shild");
			model.renderPart("farpi_cr");
			model.renderPart("shild");
		    //GL11.glColor3f(0.1F, 0.1F, 0.1F);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDepthMask(false);
			GL11.glColor4f(0.6F, 0.6F, 0.65F, 0.6F);
			model.renderPart("farp");
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