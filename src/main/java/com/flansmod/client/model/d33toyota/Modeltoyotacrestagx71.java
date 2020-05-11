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
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modeltoyotacrestagx71 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation bodyuv = new ResourceLocation("minecraft:d33toyota/textures/model/bodyuv.png");
	private ResourceLocation bumpuv = new ResourceLocation("minecraft:d33toyota/textures/model/bumpuv.png");
	private ResourceLocation dooruv = new ResourceLocation("minecraft:d33toyota/textures/model/dooruv.png");
	private ResourceLocation hakumai_interior = new ResourceLocation("minecraft:d33toyota/textures/model/hakumai_interior.png");
	private ResourceLocation hakumai_lights = new ResourceLocation("minecraft:d33toyota/textures/model/hakumai_lights.png");
	private ResourceLocation hooduv = new ResourceLocation("minecraft:d33toyota/textures/model/hooduv.png");
	private ResourceLocation logo = new ResourceLocation("minecraft:d33toyota/textures/model/logo.png");
	private ResourceLocation main = new ResourceLocation("minecraft:d33toyota/textures/model/main.png");
	private ResourceLocation underbody = new ResourceLocation("minecraft:d33toyota/textures/model/underbody.png");
	private ResourceLocation vehicle_generic_detail = new ResourceLocation("minecraft:d33toyota/textures/model/vehicle_generic_detail.png");
	public Modeltoyotacrestagx71() //Same as Filename
	{	    	
		    steer = hakumai_interior; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33toyota/textures/model/cresta_gx71.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);

	     	steerX = 33.3F;
	        steerY = 74F;
	        steerZ = -40F;
	        steerR = -15F;
	        
	        wheelX = 59F;
	        wheelX1 = 59F;
	        wheelY = 25F;
	        wheelZ = -142F;
	        wheelZ1 = 123F;
	        
	        //maxSpedoAngle = 230F;
	        mSpeed = 210;
	        elSpedo = true;
	    	//list = GL11.glGenLists(1);
	        //GL11.glNewList(list, GL11.GL_COMPILE);
	   	  	        
	        //GL11.glEndList();
	    	 
	        translateAll(0F, 0F, 0F);
	        
	 		//flipAll();	    
	}
	 @Override
	 public void renderColoredParts(){
		// GL11.glTranslatef(0.0F, -45.0F, 0.0F);	
		 Minecraft.getMinecraft().renderEngine.bindTexture(bumpuv);
			model.renderPart("bump_fro_uv");
			model.renderPart("bump_rea_uv");
			Minecraft.getMinecraft().renderEngine.bindTexture(dooruv);
			model.renderPart("door_lr_col");
			model.renderPart("door_lf_col");
			model.renderPart("door_rr_col");
			model.renderPart("door_rf_col");
			Minecraft.getMinecraft().renderEngine.bindTexture(hooduv);
			model.renderPart("boot");
			model.renderPart("bonnet");
			Minecraft.getMinecraft().renderEngine.bindTexture(bodyuv);
			model.renderPart("chassis_col");
			model.renderPart("eng_col");
	 }
	 @Override
	 public void renderWheels(){
		GL11.glScalef(0.96F, 0.96F, 0.96F);
		/*Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		d33wheel.renderPart("status_tyre");
		Minecraft.getMinecraft().renderEngine.bindTexture(statusdisk);
		d33wheel.renderPart("status_disk");*/
	 }
	 
	 @Override
	 public void renderSpedo(){
		 GL11.glPushMatrix();
			FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
			GL11.glTranslatef(39.65F, 86F, -58.2F);
			GL11.glRotatef(-30F, 1f, 0f, 0f);
	        GL11.glScalef(0.42F, -0.42F, 1.0F);
	        //GL11.glDepthMask(true);
	                fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) , 10, 0x379e80);
	                
	        //GL11.glDepthMask(false);
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        GL11.glPopMatrix();
		 
		 /*Minecraft.getMinecraft().renderEngine.bindTexture(hakumai_interior);
		 GL11.glTranslatef(-28F, 81.4F, -83.3F);
		 GL11.glRotatef(-14F, 1f, 0f, 0f);*/
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, -10.0F, 0.0F);	
		 Minecraft.getMinecraft().renderEngine.bindTexture(hakumai_interior);
		 	model.renderPart("door_lr_ins");
			model.renderPart("door_lf_ins");
			model.renderPart("door_rr_ins");
			model.renderPart("door_rf_ins");
			model.renderPart("inside");
			Minecraft.getMinecraft().renderEngine.bindTexture(hakumai_lights);
			model.renderPart("bump_fro_light");
			model.renderPart("light_rea");
			model.renderPart("light_reap");
			Minecraft.getMinecraft().renderEngine.bindTexture(vehicle_generic_detail);
			model.renderPart("bump_fro_gendet");
			model.renderPart("exhaust_ok");
			model.renderPart("bump_rea_gendet");
			model.renderPart("door_lr_gendet");
			model.renderPart("door_lf_gendet");
			model.renderPart("door_rr_gendet");
			model.renderPart("door_rf_gendet");
			model.renderPart("light_gendet");
			model.renderPart("gendet");
			model.renderPart("chassis_gendet");
			Minecraft.getMinecraft().renderEngine.bindTexture(main);
			model.renderPart("eng_mains");
			Minecraft.getMinecraft().renderEngine.bindTexture(underbody);
			model.renderPart("dno");
			model.renderPart("eng_unbod");
			Minecraft.getMinecraft().renderEngine.bindTexture(logo);
			model.renderPart("boot_logo");
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
	/* @Override
	 public void renderSteer(){
		//GL11.glColor3f(0.1F, 0.1F, 0.1F);
		model.renderPart("steer");
		//GL11.glColor3f(1F, 1F, 1F);
	 }*/
}