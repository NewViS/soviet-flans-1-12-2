//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: vaz2101
// Model Creator: 
// Created on: 01.03.2018 - 00:00:58
// Last changed on: 01.03.2018 - 00:00:58

package com.flansmod.client.model.d33toyota; //Path where the model is located

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicle;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modeltoyotaft1 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation toyota_ft1_fan = new ResourceLocation("minecraft:d33toyota/textures/model/toyota_ft1_fan.png");
	private ResourceLocation toyota_ft1_grill = new ResourceLocation("minecraft:d33toyota/textures/model/toyota_ft1_grill.png");
	private ResourceLocation toyota_ft1_int = new ResourceLocation("minecraft:d33toyota/textures/model/toyota_ft1_int.png");
	private ResourceLocation vehiclelights = new ResourceLocation("minecraft:d33toyota/textures/model/vehiclelights.png");
	private ResourceLocation toyota_ft1_misc = new ResourceLocation("minecraft:d33toyota/textures/model/toyota_ft1_misc.png");
	public Modeltoyotaft1() //Same as Filename
	{	    	
		    steer = toyota_ft1_int; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33toyota/textures/model/toyotaft1.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);
	        ismqo=true;
	        
	        steerX = -34.486F;
	        steerY = 74.351F;
	        steerZ = -13.453F;
	        steerR = -14.341F;
	        
	        wheelX = 65F;
	        wheelX1 = 65F;
	        wheelY = 29F;
	        wheelZ = -142F;
	        wheelZ1 = 121F;
	        
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
		 	
		 //GL11.glScaled(100, 100, 100);
		// GL11.glTranslatef(0.0F, -45.0F, 0.0F);	
		 Minecraft.getMinecraft().renderEngine.bindTexture(toyota_ft1_misc);
		 	model.renderPart("doorrf_col");
			model.renderPart("doorlf_col");
			model.renderPart("body");
	 }
	 @Override
	 public void renderWheels(){
		 GL11.glScaled(1.15, 1.15, 1.4);
	 }
	 
	 @Override
	 public void pre(){
		 GL11.glShadeModel(GL11.GL_SMOOTH);
	 }
	 
	 @Override
	 public void renderSpedo(){
		 /*GL11.glPushMatrix();
			FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
			GL11.glTranslatef(39.65F, 86F, -58.2F);
			GL11.glRotatef(-30F, 1f, 0f, 0f);
	        GL11.glScalef(0.42F, -0.42F, 1.0F);
	        //GL11.glDepthMask(true);
	                fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) , 10, 0x379e80);
	                
	        //GL11.glDepthMask(false);
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        GL11.glPopMatrix();*/
		 
		 /*Minecraft.getMinecraft().renderEngine.bindTexture(hakumai_interior);
		 GL11.glTranslatef(-28F, 81.4F, -83.3F);
		 GL11.glRotatef(-14F, 1f, 0f, 0f);*/
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, 1.0F, 0.0F);	
		 Minecraft.getMinecraft().renderEngine.bindTexture(toyota_ft1_fan);
		 	model.renderPart("fan");
			Minecraft.getMinecraft().renderEngine.bindTexture(toyota_ft1_grill);
			model.renderPart("grill");
			Minecraft.getMinecraft().renderEngine.bindTexture(toyota_ft1_int);
			model.renderPart("doorrf_int");
			model.renderPart("doorlf_int");
			model.renderPart("interior");
			model.renderPart("dno");
			Minecraft.getMinecraft().renderEngine.bindTexture(toyota_ft1_misc);
			model.renderPart("doorrf_main");
			model.renderPart("doorlf_main");
			model.renderPart("logo");
			model.renderPart("main");
			Minecraft.getMinecraft().renderEngine.bindTexture(vehiclelights);
			model.renderPart("light");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDepthMask(false);
			GL11.glColor4f(0.1F, 0.1F, 0.1F, 0.6F);
			model.renderPart("windscre");
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glDepthMask(true);
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
         
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