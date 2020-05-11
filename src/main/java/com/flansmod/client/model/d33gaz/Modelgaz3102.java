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
import com.flansmod.client.model.SovietModelVehicle;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modelgaz3102 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation leather_black = new ResourceLocation("minecraft:d33gaz/textures/model/leather_black.png");
	private ResourceLocation volga_main = new ResourceLocation("minecraft:d33gaz/textures/model/volga_main.png");
	private ResourceLocation volga_salon = new ResourceLocation("minecraft:d33gaz/textures/model/volga_salon.png");
	public Modelgaz3102() //Same as Filename
	{	    	
		    steer = volga_salon; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33gaz/textures/model/gaz3102.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);

	        steerX = -32.5F;
	        steerY = 76F;
	        steerZ = -52F;
	        steerR = -15F;
	        
	        wheelX = 64F;
	        wheelX1 = 64F;
	        wheelY = 25F;
	        wheelZ = -139F;
	        wheelZ1 = 117F;
	        
	        translateAll(0F, 0F, 0F);
	        
	}
	 @Override
	 public void renderColoredParts(){
		 //GL11.glTranslatef(0.0F, -3.0F, 0.0F);	
		 //GL11.glColor3f(0.05F, 0.05F, 0.05F);
		model.renderPart("color");
		model.renderPart("salo_color");
		model.renderPart("boot_color");
		model.renderPart("bonnet");
		model.renderPart("door_rr_color");
		model.renderPart("door_lr_color");
		model.renderPart("door_rf_color");
		model.renderPart("door_lf_color");
		
	 }
	 @Override
	 public void renderSteer(){
		//Minecraft.getMinecraft().renderEngine.bindTexture(rul);
		model.renderPart("rul_logo");
		Minecraft.getMinecraft().renderEngine.bindTexture(leather_black);
		model.renderPart("rul_bl");
	 }
	 @Override
	 public void renderWheels(){	
		//GL11.glScalef(0.95F, 0.95F, 0.95F);
		/*Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		d33wheel.renderPart("status_tyre");
		Minecraft.getMinecraft().renderEngine.bindTexture(statusdisk);
		d33wheel.renderPart("vazrect_shtamp");*/
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, -10.0F, 0.0F);	
		 //GL11.glTranslatef(0.0F, 8.0F, 0.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(leather_black);
			model.renderPart("lea_bl_1");
			model.renderPart("door_rr_leabl");
			model.renderPart("door_lr_leabl");
			model.renderPart("door_rf_leabl");
			model.renderPart("door_lf_leabl");
			
			
			Minecraft.getMinecraft().renderEngine.bindTexture(volga_main);
			model.renderPart("Stekla_far");
			model.renderPart("Fari_zad");
			model.renderPart("main_tex");
			model.renderPart("main_tex2");
			model.renderPart("Dvigatel_main");
			model.renderPart("salo_main");
			model.renderPart("boot_main");
			model.renderPart("bump_fro");
			model.renderPart("door_rr_main");
			model.renderPart("door_lr_main");
			model.renderPart("bump_rea");
			model.renderPart("door_rf_main");
			model.renderPart("door_lf_main");
			
			Minecraft.getMinecraft().renderEngine.bindTexture(volga_salon);
			model.renderPart("logo");
			model.renderPart("salon");
			model.renderPart("door_rr_salon");
			model.renderPart("door_lr_salon");
			model.renderPart("door_rf_salon");
			model.renderPart("door_lf_salon");
			
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