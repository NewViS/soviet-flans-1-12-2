//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: vaz2101
// Model Creator: 
// Created on: 01.03.2018 - 00:00:58
// Last changed on: 01.03.2018 - 00:00:58

package com.flansmod.client.model.d33tesla; //Path where the model is located

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.MQO_ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicle;

import jp.amrex.modelloader.MQO_MetasequoiaObject;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;

public class Modelcybertruck extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation lowpolyboi_wheel = new ResourceLocation("minecraft:d33tesla/textures/model/lowpolyboi_wheel.png");
	private ResourceLocation led = new ResourceLocation("minecraft:d33tesla/textures/model/led.png");
	private ResourceLocation vehicle_generic_smallspecmap = new ResourceLocation("minecraft:d33tesla/textures/model/vehicle_generic_smallspecmap.png");
	private ResourceLocation vehiclelights = new ResourceLocation("minecraft:d33tesla/textures/model/vehiclelights.png");
	public Modelcybertruck() //Same as Filename
	{	    	
		    steer = vehicle_generic_smallspecmap; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33tesla/textures/model/cybertruck1.mqo");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
		    //model = (MQO_MetasequoiaObject) model;
		    model = new MQO_ModelWrapperDisplayList((MQO_MetasequoiaObject) model);
	        maxSpedoAngle = 145F;
	        
	        steerX = -40.80F;
	        steerY = 94.87F;
	        steerZ = -87.51F;
	        steerR = -12.17F;
	        ismqo=true;
	        
	        wheelX = 62F;
	        wheelX1 = 62F;
	        wheelY = 26F;
	        wheelZ = -175F;
	        wheelZ1 = 142F;
	        
	        GL11.glTranslatef(0F, 100F, 0F);
	        
	}
	/* @Override
	 public void renderColoredParts(){
		 steerX = -40.80F;
	        steerY = 94.87F;
	        steerZ = 87.51F;
	        
	        steerR = 12.17F;
	        
		 wheelX = 58F;
	        wheelX1 = 57F;
	        wheelY = 35F;
	        wheelZ = -175F;
	        wheelZ1 = 142F;

	 }*/
	 /*@Override
	 public void renderSpedo(){
		 GL11.glTranslatef(-33.7F, 105.4F, -103.3F);
		 GL11.glRotatef(-24F, 0f, 0f, 1f);
		 GL11.glRotatef(-14F, 1f, 0f, 0f);
	 }*/
	
	 @Override
	 public void renderSteer(){
		 GL11.glScaled(100, 100, 100);
	        model.renderPart("steer");
	 }
	 
	 @Override
	 public void pre(){
		 GL11.glShadeModel(GL11.GL_SMOOTH);
		 GL11.glTranslatef(0, 9F, 0);
	 }
	 
	 @Override
	 public void renderWheels(){	
		//GL11.glTranslatef(0F, 0.09F, 0F);
		GL11.glScalef(1.35F, 1.35F, 1.45F);
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		
		 GL11.glScaled(100, 100, 100);
		 //GL11.glTranslatef(0F, 0.09F, 0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(vehicle_generic_smallspecmap);
		//model.renderPart("LED");
		model.renderPart("panel");
		model.renderPart("int");
		Minecraft.getMinecraft().renderEngine.bindTexture(led);
		model.renderPart("LED");
			Minecraft.getMinecraft().renderEngine.bindTexture(vehiclelights);
			model.renderPart("farr");
			model.renderPart("farl");
			model.renderPart("fonar");
			model.renderPart("pov");

			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.68F, 0.68F, 0.68F);
			model.renderPart("drr_col");
			model.renderPart("dlr_col");
			model.renderPart("drf_col");
			model.renderPart("dlf_col");
			model.renderPart("col");
			model.renderPart("zrc");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("bl");
			model.renderPart("drr_bl");
			model.renderPart("dlr_bl");
			model.renderPart("drf_bl");
			model.renderPart("dlf_bl");
			model.renderPart("blback");
		    //GL11.glColor3f(0.1F, 0.1F, 0.1F);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDepthMask(false);
			GL11.glColor4f(0.1F, 0.1F, 0.1F, 0.6F);
		    model.renderPart("windscre");
			model.renderPart("drr_gl");
			model.renderPart("dlr_gl");
			model.renderPart("drf_gl");
			model.renderPart("dlf_gl");

			GL11.glDisable(GL11.GL_BLEND);
			GL11.glDepthMask(true);
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
	 //@Override
	 
}