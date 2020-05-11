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

public class Modeltoyotamark2100 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation logos = new ResourceLocation("minecraft:d33toyota/textures/model/logos.png");
	private ResourceLocation toyotaint5 = new ResourceLocation("minecraft:d33toyota/textures/model/toyotaint5.png");
	private ResourceLocation vehiclegeneric = new ResourceLocation("minecraft:d33toyota/textures/model/vehiclegeneric.png");
	private ResourceLocation vehiclelights = new ResourceLocation("minecraft:d33toyota/textures/model/vehiclelights.png");
	private ResourceLocation benzobak = new ResourceLocation("minecraft:d33toyota/textures/model/benzobak.png");
	public Modeltoyotamark2100() //Same as Filename
	{	    	
		    steer = toyotaint5; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33toyota/textures/model/mark2100.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);

	        steerX = 37.3F;
	        steerY = 77F;
	        steerZ = -57F;
	        steerR = -15F;
	        
	        wheelX = 69F;
	        wheelX1 = 69F;
	        wheelY = 25F;
	        wheelZ = -142F;
	        wheelZ1 = 125F;
	        
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
		// GL11.glTranslatef(0.0F, -45.0F, 0.0F);	
		 	model.renderPart("colmain");
			model.renderPart("colin");
			model.renderPart("bonnet_col");
			model.renderPart("bump_froc");
			model.renderPart("bump_reac");
			model.renderPart("door_rf_col");
			model.renderPart("door_lf_col");
			model.renderPart("door_lr_col");
			model.renderPart("bonnet_in");
			model.renderPart("boot_col1");
			model.renderPart("boot_col");
			model.renderPart("");
			model.renderPart("door_rr_col1");
			model.renderPart("");
			model.renderPart("");
	 }
	 @Override
	 public void renderWheels(){
		//GL11.glScalef(1.00F,1.00F, 1.00F);
		/*Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		d33wheel.renderPart("status_tyre");
		Minecraft.getMinecraft().renderEngine.bindTexture(statusdisk);
		d33wheel.renderPart("status_disk");*/
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
		 Minecraft.getMinecraft().renderEngine.bindTexture(logos);
		 	model.renderPart("bonnet_log");
			model.renderPart("logos");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			Minecraft.getMinecraft().renderEngine.bindTexture(benzobak);
			model.renderPart("bak");
			Minecraft.getMinecraft().renderEngine.bindTexture(toyotaint5);
			model.renderPart("bagins");
			model.renderPart("rearseats");
			model.renderPart("int");
			model.renderPart("frontseats");
			model.renderPart("door_rf_in");
			model.renderPart("door_lf_in");
			model.renderPart("door_lr_in");
			model.renderPart("boot_in");
			model.renderPart("door_rr_in");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			Minecraft.getMinecraft().renderEngine.bindTexture(vehiclegeneric);
			model.renderPart("dno");
			model.renderPart("engine");
			model.renderPart("bump_read");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			Minecraft.getMinecraft().renderEngine.bindTexture(vehiclelights);
			model.renderPart("farz");
			model.renderPart("fonarl");
			model.renderPart("fonar");
			model.renderPart("far");
			model.renderPart("far1");
			model.renderPart("bump_frof");
			model.renderPart("boot_far");
			model.renderPart("");
			model.renderPart("");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.6F, 0.6F, 0.6F);
			model.renderPart("cr");
			model.renderPart("");
			model.renderPart("cr1");
			model.renderPart("frontseats_cr");
			model.renderPart("exhaust");
			model.renderPart("bonnet_cr");
			model.renderPart("bonnet_cr1");
		    model.renderPart("door_rf_cr");
			model.renderPart("door_lf_cr");
			model.renderPart("");
			model.renderPart("");
		    GL11.glColor3f(0.1F, 0.1F, 0.1F);
		    model.renderPart("bl");
		    model.renderPart("bl1");
			model.renderPart("exhaust_bl");
			model.renderPart("bonnet_cr2");
			model.renderPart("door_rf_ruk");
		    model.renderPart("door_rf_bl1");
		    model.renderPart("door_rf_bl");
			model.renderPart("door_lf_ruk");
			model.renderPart("door_lf_bl1");
			model.renderPart("door_lf_bl");
			model.renderPart("door_lf_bl");
			model.renderPart("door_lr_ruk");
			model.renderPart("door_rr_ruk");
			model.renderPart("plast");
			model.renderPart("door_rr_col");
			model.renderPart("door_lr_col1");
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDepthMask(false);
			GL11.glColor4f(0.6F, 0.6F, 0.65F, 0.6F);
			model.renderPart("frontglass");
			Minecraft.getMinecraft().renderEngine.bindTexture(vehiclelights);
			model.renderPart("steklrea");
			model.renderPart("boot_gl");
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
		//GL11.glColor3f(0.1F, 0.1F, 0.1F);
		GL11.glScalef(1.2F,1.2F, 1.20F);
		model.renderPart("fullsize_steer");
		//GL11.glColor3f(1F, 1F, 1F);
	 }
}