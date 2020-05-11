//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: vaz2101
// Model Creator: 
// Created on: 01.03.2018 - 00:00:58
// Last changed on: 01.03.2018 - 00:00:58

package com.flansmod.client.model.d33vaz; //Path where the model is located

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicle;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modeloka1111 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation body_oka = new ResourceLocation("minecraft:d33vaz/textures/model/body_oka.png");
	private ResourceLocation carpet = new ResourceLocation("minecraft:d33vaz/textures/model/carpet.png");
	private ResourceLocation leather_black = new ResourceLocation("minecraft:d33vaz/textures/model/leather_black.png");
	private ResourceLocation leagr2 = new ResourceLocation("minecraft:d33vaz/textures/model/leagr2.png");
	private ResourceLocation obsh_potol= new ResourceLocation("minecraft:d33vaz/textures/model/obsh_potol.png");
	private ResourceLocation oka_engine= new ResourceLocation("minecraft:d33vaz/textures/model/oka_engine.png");
    private ResourceLocation underbody= new ResourceLocation("minecraft:d33vaz/textures/model/underbody.png");
	//public IModelCustom modeldisk;
	public Modeloka1111() //Same as Filename
	{	    	
		    steer = body_oka; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33vaz/textures/model/oka1111.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);
	        
	       // ResourceLocation disk = new ResourceLocation("minecraft:d33vaz/textures/model/disk/statusdisk_circle.obj");
	       // modeldisk = AdvancedModelLoader.loadModel(disk);
	       // modeldisk = new ModelWrapperDisplayList((WavefrontObject) modeldisk);

	        steerX = -27.5F;
	        steerY = 83.5F;
	        steerZ = -52F;
	        steerR = -28F;
	        
	        wheelX = 51F;
	        wheelX1 = 51F;
	        wheelY = 24F;
	        wheelZ = -112F;
	        wheelZ1 = 92F;
	    	//list = GL11.glGenLists(1);
	        //GL11.glNewList(list, GL11.GL_COMPILE);
	   	  	        
	        //GL11.glEndList();
	    	 
	        translateAll(0F, 0F, 0F);
	        
	 		//flipAll();	    
	}
	 @Override
	 public void renderColoredParts(){
		// GL11.glTranslatef(0.0F, -45.0F, 0.0F);	
		model.renderPart("color");
		model.renderPart("bonnet_color");
		model.renderPart("boot_col");
		model.renderPart("door_lf_col");
		model.renderPart("door_rf_col");	
		model.renderPart("color1");
		//model.renderAll();
	 }
	 @Override
	 public void renderWheels(){
		GL11.glScalef(0.86F, 0.86F, 0.86F);
	 }
	 
	 @Override
	 public void renderSteer(){
		model.renderPart("rul");
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, -10.0F, 0.0F);	
		 Minecraft.getMinecraft().renderEngine.bindTexture(body_oka);
			model.renderPart("tex_main");
			model.renderPart("bonnet_tex");
			model.renderPart("boot_tex");
			model.renderPart("bump_fro");
			model.renderPart("bump_rea");
			model.renderPart("door_lf_tex");
			model.renderPart("door_rf_tex");
			model.renderPart("rad");
			model.renderPart("parts");
			//
			model.renderPart("salon");
			model.renderPart("kpp");
			model.renderPart("torpeda");
			model.renderPart("drive_whee");
			model.renderPart("buttons");
			model.renderPart("peregorodk");
			model.renderPart("seats_main");
			model.renderPart("lights_black");
			model.renderPart("lightstex");
			model.renderPart("lights_gla");
			model.renderPart("reshetka");
			Minecraft.getMinecraft().renderEngine.bindTexture(carpet);
			model.renderPart("pol");
			Minecraft.getMinecraft().renderEngine.bindTexture(leather_black);
			model.renderPart("door_lf_leabl");
			model.renderPart("door_rf_leabl");
			model.renderPart("tunnel_carp");
			model.renderPart("seats_bl");
			model.renderPart("seatr_bl");
			Minecraft.getMinecraft().renderEngine.bindTexture(leagr2);
			model.renderPart("door_lf_leagr");
			model.renderPart("door_rf_leagr");
			model.renderPart("seats_gr");
			model.renderPart("seatr_gr");
			Minecraft.getMinecraft().renderEngine.bindTexture(obsh_potol);
			model.renderPart("potol");
			Minecraft.getMinecraft().renderEngine.bindTexture(oka_engine);
			model.renderPart("engine_oka");
			Minecraft.getMinecraft().renderEngine.bindTexture(underbody);
			model.renderPart("under_eng");
			model.renderPart("underbumpe");
			model.renderPart("under");
			model.renderPart("Podveska");
			model.renderPart("podv_1");
	 }
	 @Override
	 public void frontWheelsStuff(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			GL11.glTranslatef(-10F, 0, 0);
			model.renderPart("brakedisc_");
			GL11.glTranslatef(10F, 0, 0);
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
}