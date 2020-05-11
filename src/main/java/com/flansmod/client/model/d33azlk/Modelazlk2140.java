//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: vaz2101
// Model Creator: 
// Created on: 01.03.2018 - 00:00:58
// Last changed on: 01.03.2018 - 00:00:58

package com.flansmod.client.model.d33azlk; //Path where the model is located

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicle;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modelazlk2140 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation azlk2140_main = new ResourceLocation("minecraft:d33azlk/textures/model/azlk2140_main.png");
	private ResourceLocation kozha = new ResourceLocation("minecraft:d33azlk/textures/model/kozha.png");
	private ResourceLocation azlk_logo = new ResourceLocation("minecraft:d33azlk/textures/model/azlk_logo.png");
	private ResourceLocation azlk_salon = new ResourceLocation("minecraft:d33azlk/textures/model/azlk_salon.png");
	private ResourceLocation dirt = new ResourceLocation("minecraft:d33azlk/textures/model/dirt.png");
	public Modelazlk2140() //Same as Filename
	{	    	
		    steer = azlk_salon;
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33azlk/textures/model/azlk2140.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);

	        steerX = -29.5F;
	        steerY = 88F;
	        steerZ = -44F;
	        steerR = -20F;
	        
	        wheelX = 56F;
	        wheelX1 = 57F;
	        wheelY = 25F;
	        wheelZ = -134F;
	        wheelZ1 = 107F;
	        
	        translateAll(0F, 0F, 0F);
	        
	}
	 @Override
	 public void renderColoredParts(){
		 //GL11.glTranslatef(0.0F, -3.0F, 0.0F);	
		 //GL11.glColor3f(0.05F, 0.05F, 0.05F);
		model.renderPart("bonnet_ok");
		model.renderPart("Boot_ok");
		model.renderPart("door_lf_col");
		model.renderPart("door_lr_col");
		model.renderPart("door_rf_col");
		model.renderPart("door_rr_col");
		model.renderPart("color");
	 }
	 @Override
	 public void renderSteer(){
		model.renderPart("rul");
	 }
	
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, -10.0F, 0.0F);	
		 //GL11.glTranslatef(0.0F, 8.0F, 0.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(azlk2140_main);
			model.renderPart("Chassis");
			model.renderPart("Boot_tex");
			Minecraft.getMinecraft().renderEngine.bindTexture(azlk_logo);
			model.renderPart("logo");
			Minecraft.getMinecraft().renderEngine.bindTexture(azlk_salon);
			model.renderPart("Salon");
			model.renderPart("door_lf_ok");
			model.renderPart("door_lr_ok");
			model.renderPart("door_rf_tex");
			model.renderPart("door_rr_tex");
			Minecraft.getMinecraft().renderEngine.bindTexture(dirt);
			model.renderPart("Dvigatel");
			Minecraft.getMinecraft().renderEngine.bindTexture(kozha);
			model.renderPart("Salon1");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.6F, 0.6F, 0.6F);
			model.renderPart("bump_front_ok");
			model.renderPart("Bump_rear_ok");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("black");
			model.renderPart("black_zad");
			model.renderPart("door_lr_bl");
			model.renderPart("door_rr_bl");
			model.renderPart("bump_front_bl");
			model.renderPart("Bump_rear_bl");
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