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
import com.flansmod.client.model.SovietModelVehicleReaSpar;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modelgaz2705 extends SovietModelVehicleReaSpar //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	//private ResourceLocation black_dirt = new ResourceLocation("minecraft:d33vaz/textures/model/black_dirt.png");
	private ResourceLocation gazel_kuzov = new ResourceLocation("minecraft:d33gaz/textures/model/gazel_kuzov.png");
	private ResourceLocation gazel_ste= new ResourceLocation("minecraft:d33gaz/textures/model/gazel_ste.png");
	//public IModelCustom modeldisk;
	public Modelgaz2705() //Same as Filename
	{	    	
		    steer = gazel_kuzov; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33gaz/textures/model/gaz2705.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);
	        
	       // ResourceLocation disk = new ResourceLocation("minecraft:d33vaz/textures/model/disk/statusdisk_circle.obj");
	       // modeldisk = AdvancedModelLoader.loadModel(disk);
	       // modeldisk = new ModelWrapperDisplayList((WavefrontObject) modeldisk);

	        steerX = -50F;
	        steerY = 143f;
	        steerZ = -195F;
	        steerR = -37F;
	        
	        wheelX = 90F;
	        wheelX1 = 85F;
	        wheelY = 34f;
	        wheelZ = -231F;
	        wheelZ1 = 90F;
	    	//list = GL11.glGenLists(1);
	        //GL11.glNewList(list, GL11.GL_COMPILE);
	   	  	        
	        //GL11.glEndList();
	    	 
	        translateAll(0F, 0F, 0F);
	        
	 		//flipAll();	    
	}
	 @Override
	 public void renderColoredParts(){
	 }
	 @Override
	 public void renderWheelsFro(){
			Minecraft.getMinecraft().renderEngine.bindTexture(gazel_kuzov);
		    model.renderPart("wheel_fr");
	 }
	 @Override
	 public void renderWheelsRea(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(gazel_kuzov);
		    model.renderPart("wheel_rea");
		 }
	 
	 @Override
	 public void renderSteer(){
		model.renderPart("rul");
	 }
	 
	 @Override
	 public void renderTexturedParts(){
			Minecraft.getMinecraft().renderEngine.bindTexture(gazel_kuzov);
			model.renderPart("door_rr");
			model.renderPart("door_rl");
			model.renderPart("door_lf");
			model.renderPart("door_rf");
			model.renderPart("kuzov");
			model.renderPart("gaz2705");
			Minecraft.getMinecraft().renderEngine.bindTexture(gazel_ste);
			model.renderPart("reshet");
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDepthMask(false);
			GL11.glColor4f(0.7F, 0.7F, 0.7F, 0.6F);
			model.renderPart("far_ste");
			//model.renderPart("glass");
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glDepthMask(true);
	 }
	 @Override
	 public void frontWheelsStuff(){
		 /*Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			GL11.glTranslatef(-10F, 0, 0);
			model.renderPart("brakedisc_");
			GL11.glTranslatef(10F, 0, 0);
			GL11.glColor3f(1.0F, 1.0F, 1.0F);*/
	 }
}