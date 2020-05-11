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

public class Modelgaz51 extends SovietModelVehicleReaSpar //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	//private ResourceLocation black_dirt = new ResourceLocation("minecraft:d33vaz/textures/model/black_dirt.png");
	private ResourceLocation GAZ51_Main = new ResourceLocation("minecraft:d33gaz/textures/model/GAZ51_Main.png");
	private ResourceLocation rezin= new ResourceLocation("minecraft:d33gaz/textures/model/rezin.png");
	private ResourceLocation leather_black= new ResourceLocation("minecraft:d33gaz/textures/model/leather_black.png");
	//public IModelCustom modeldisk;
	public Modelgaz51() //Same as Filename
	{	    	
		    steer = GAZ51_Main; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33gaz/textures/model/gaz51.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);
	        
	       // ResourceLocation disk = new ResourceLocation("minecraft:d33vaz/textures/model/disk/statusdisk_circle.obj");
	       // modeldisk = AdvancedModelLoader.loadModel(disk);
	       // modeldisk = new ModelWrapperDisplayList((WavefrontObject) modeldisk);

	        	steerX = -35F;
		        steerY = 157f;
		        steerZ = -145F;
		        steerR = -20F;
	        
				 wheelX = 102F;
			        wheelX1 = 97F;
			        wheelY = 47f;
			        wheelZ = -233F;
			        wheelZ1 = 150F;
	        
					 maxSpedoAngle = 140F;
	    	isKuzov = true;
	    	//list = GL11.glGenLists(1);
	        //GL11.glNewList(list, GL11.GL_COMPILE);
	   	  	        
	        //GL11.glEndList();
	    	 
	        translateAll(0F, 0F, 0F);
	        
	 		//flipAll();	    
	}
	 @Override
	 public void renderColoredParts(){ 
		// GL11.glTranslatef(0.0F, -45.0F, 0.0F);	
		model.renderPart("colorin");
		model.renderPart("colorin1");
		model.renderPart("wing_lf_col");
		model.renderPart("door_lf_col");
		model.renderPart("wing_rf_col");
		model.renderPart("door_rf_col");
		model.renderPart("bonnet_col");
		/*GL11.glPushMatrix();
		GL11.glScalef(-1F, 1F, 1F);
		model.renderPart("colorin");
		GL11.glPopMatrix();*/
	 }
	 
	 @Override
	 public void renderSpedo(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(GAZ51_Main);
		 GL11.glTranslatef(-36.8F, 157.4F, -167.3F);
		 GL11.glRotatef(-5F, 1f, 0f, 0f);
		 GL11.glRotatef(-22F, 0f, 0f, 1f);
	 }
	 @Override
	 public void renderWheelsFro(){
		 	//GL11.glScalef(0.2F, 0.2F, 0.2F);
		    Minecraft.getMinecraft().renderEngine.bindTexture(GAZ51_Main);
			model.renderPart("wheel_rf_rez");		
			model.renderPart("wheel_rf_main");
			 Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.15F, 0.15F, 0.15F);
			model.renderPart("wheel_rf_disk");
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
	 @Override
	 public void renderWheelsRea(){
			//GL11.glScalef(0.2F, 0.2F, 0.2F);
		 Minecraft.getMinecraft().renderEngine.bindTexture(GAZ51_Main);
			model.renderPart("wheel_rb_rez");		
			model.renderPart("wheel_rb_main");
			 Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.15F, 0.15F, 0.15F);
			model.renderPart("wheel_rb_disk");
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
		 }
	 
	 @Override
	 public void renderSteer(){
		model.renderPart("steer");
	 }
	 
	 @Override
	 public void renderKuzov(){
		GL11.glScalef(0.95F, 0.9F, 0.915F);
		GL11.glTranslatef(0, 146F, -54F);
	 }
	 
	 @Override
	 public void renderTexturedParts(){ 
			Minecraft.getMinecraft().renderEngine.bindTexture(leather_black);
			model.renderPart("sed");
			Minecraft.getMinecraft().renderEngine.bindTexture(GAZ51_Main);
			model.renderPart("farz");
			model.renderPart("main");
			model.renderPart("Rama1");
			model.renderPart("wing_lf_main");
			model.renderPart("door_lf_main1");
			model.renderPart("wing_rf_main");
			model.renderPart("door_rf_main1");
			model.renderPart("bump_fro");
			model.renderPart("bonnet_main");
			Minecraft.getMinecraft().renderEngine.bindTexture(rezin);
			model.renderPart("pol");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("rama");
			GL11.glColor3f(0.6F, 0.6F, 0.6F);
			model.renderPart("door_rf_main");
			model.renderPart("door_lf_main");
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
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