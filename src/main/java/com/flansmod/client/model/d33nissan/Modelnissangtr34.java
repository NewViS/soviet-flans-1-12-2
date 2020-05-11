//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: vaz2101
// Model Creator: 
// Created on: 01.03.2018 - 00:00:58
// Last changed on: 01.03.2018 - 00:00:58

package com.flansmod.client.model.d33nissan; //Path where the model is located

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicle;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;


public class Modelnissangtr34 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation car_chassis = new ResourceLocation("minecraft:d33nissan/textures/model/car_chassis.png");
	private ResourceLocation r34_badges = new ResourceLocation("minecraft:d33nissan/textures/model/r34_badges2.png");
	private ResourceLocation r34_cab = new ResourceLocation("minecraft:d33nissan/textures/model/r34_cab.png");
	private ResourceLocation r34_ext = new ResourceLocation("minecraft:d33nissan/textures/model/r34_ext.png");
	private ResourceLocation r34_lights = new ResourceLocation("minecraft:d33nissan/textures/model/r34_lights.png");
	private ResourceLocation r34_misc = new ResourceLocation("minecraft:d33nissan/textures/model/r34_misc.png");
	private ResourceLocation carbon_black = new ResourceLocation("minecraft:d33nissan/textures/model/carbon_black.png");
	private ResourceLocation strel = new ResourceLocation("minecraft:d33nissan/textures/model/strel1.png");
	public Modelnissangtr34() //Same as Filename
	{	    	
		    steer = r34_cab; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33nissan/textures/model/skyline34.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);
	        ismqo=true;
	        
	        steerX = 35.738F;
	        steerY = 76.305F;
	        steerZ = -36.926F;
	        steerR = -16F;
	        
	        wheelX = 62F;
	        wheelX1 = 62F;
	        wheelY = 29F;
	        wheelZ = -142F;
	        wheelZ1 = 123F;
	        
	        maxSpedoAngle = 230F;
	        //mSpeed = 210;
	        //elSpedo = true;
	    	//list = GL11.glGenLists(1);
	        //GL11.glNewList(list, GL11.GL_COMPILE);
	   	  	        
	        //GL11.glEndList();
	    	 
	        translateAll(0F, 0F, 0F);
	        
	 		//flipAll();	    
	}
	 @Override
	 public void renderColoredParts(){
		 	model.renderPart("REARBUMPER_mm_ext");
			model.renderPart("MIRROR_RIGHT_mm_ext");
			model.renderPart("MIRROR_LEFT_mm_ext");
			model.renderPart("FRONTBUMPER_mm_ext");
			model.renderPart("DOOR_RIGHT_mm_ext");
			model.renderPart("DOOR_LEFT_mm_ext");
			model.renderPart("BOOT_mm_ext");
			model.renderPart("BODY_mm_ext");
	 }
	 @Override
	 public void renderWheels(){
		 GL11.glScaled(1.1, 1.1, 1.3);
	 }
	 
	 @Override
	 public void pre(){
		 //GL11.glTranslatef(0.0F, 0.0F, 0.0F);	
		 //GL11.glShadeModel(GL11.GL_SMOOTH);
	 }
	 
	 @Override
	 public void renderSpedo(){
		 GL11.glPushMatrix();
		 	 
		 GL11.glTranslatef(46.857F, 82.257F, -63.852F);
			 GL11.glRotatef(-10F, 1f, 0f, 0f);
			
			 if(vet>0)
			GL11.glRotatef(-vet*maxSpedoAngle, 0f, 0f, 1f);
			 
			 GL11.glRotatef(10F, 1f, 0f, 0f);
			 GL11.glTranslatef(-46.857F, -82.257F, 63.852F);

			 Minecraft.getMinecraft().renderEngine.bindTexture(strel);
			model.renderPart("spedo");
			GL11.glColor3f(1F, 1F, 1F);
			GL11.glPopMatrix();
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, 1.0F, 0.0F);	
		 Minecraft.getMinecraft().renderEngine.bindTexture(carbon_black);
		 	model.renderPart("bonnet_col");
			Minecraft.getMinecraft().renderEngine.bindTexture(r34_cab);
			model.renderPart("INTERIOR_mm_cab");
		 	model.renderPart("DOOR_RIGHT_mm_cab");
			model.renderPart("DOOR_LEFT_mm_cab");
			model.renderPart("BODY_mm_cab");
			Minecraft.getMinecraft().renderEngine.bindTexture(r34_ext);
			model.renderPart("FRONTBUMPER_logo");
			Minecraft.getMinecraft().renderEngine.bindTexture(r34_lights);
			model.renderPart("RIGHT_mm_lights");
		 	model.renderPart("LEFT_mm_lights");
			model.renderPart("REARBUMPER_mm_lights");
			model.renderPart("CHASSIS_mm_lights");
			model.renderPart("BOOT_mm_lights");
			model.renderPart("BODY_mm_lights");
			Minecraft.getMinecraft().renderEngine.bindTexture(r34_misc);
			model.renderPart("bonnet_misc");
		 	model.renderPart("REARBUMPER_mm_misc");
			model.renderPart("FRONTBUMPER_mm_misc");
			model.renderPart("GLASS_REARb");
			model.renderPart("EXHAUST_mm_misc");
			model.renderPart("DOOR_RIGHT_mm_misc");
			model.renderPart("DOOR_LEFT_mm_misc");
			model.renderPart("CHASSIS_mm_misc");
			model.renderPart("BOOT_mm_misc");
			model.renderPart("BODY_mm_misc");
			Minecraft.getMinecraft().renderEngine.bindTexture(car_chassis);
			model.renderPart("CHASSIS_mm_chassis");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3d(0.7, 0.7, 0.75);
			model.renderPart("GLASS_RIGHT_mm_misc");
			model.renderPart("GLASS_LEFT_mm_misc");
			GL11.glColor3d(0.1, 0.1, 0.1);
			model.renderPart("GLASS_REARb");
			model.renderPart("GLASS_FRONTb");
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDepthMask(false);
			GL11.glColor4f(0.1F, 0.1F, 0.1F, 0.6F);
			model.renderPart("GLASS_RIGHT");
			model.renderPart("GLASS_RIGHT_Q");
			model.renderPart("GLASS_REAR");
			model.renderPart("GLASS_LEFT");
			model.renderPart("GLASS_LEFT_Q");
			model.renderPart("GLASS_FRONT");
			GL11.glColor4f(0.6F, 0.6F, 0.65F, 0.6F);
			model.renderPart("LENS_RIGHT");
			model.renderPart("LENS_LEFT");
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(r34_badges);
			 	model.renderPart("REARBUMPER_mm_badges");
			 	model.renderPart("FRONTBUMPER_mm_badges");
				model.renderPart("DOOR_RIGHT_mm_badges");
				model.renderPart("DOOR_LEFT_mm_badges");
				model.renderPart("BOOT_mm_badges");
				model.renderPart("BODY_mm_badges");
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glDepthMask(true);
         
	 }
	 /*@Override
	 public void frontWheelsStuff(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			GL11.glTranslatef(-10F, 0, 0);
			model.renderPart("brakedisc_");
			GL11.glTranslatef(10F, 0, 0);
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
	 */
	 @Override
	 public void renderSteer(){
		model.renderPart("steer");
	 }
}