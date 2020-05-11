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

public class Modelazlk400 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation azlk400_main = new ResourceLocation("minecraft:d33azlk/textures/model/azlk400_main.png");
	private ResourceLocation dirt = new ResourceLocation("minecraft:d33azlk/textures/model/dirt.png");
	private ResourceLocation kozha = new ResourceLocation("minecraft:d33azlk/textures/model/kozha.png");
	private ResourceLocation mzma_logo = new ResourceLocation("minecraft:d33azlk/textures/model/mzma_logo.png");

	/*private ResourceLocation konsol = new ResourceLocation("minecraft:d33azlk/textures/model/konsol.png");
	private ResourceLocation leather_grey = new ResourceLocation("minecraft:d33azlk/textures/model/leather_grey.png");
	private ResourceLocation obivka_3 = new ResourceLocation("minecraft:d33azlk/textures/model/obivka_3.png");
	private ResourceLocation kozha = new ResourceLocation("minecraft:d33azlk/textures/model/kozha.png");
	private ResourceLocation koleso2141 = new ResourceLocation("minecraft:d33vaz/textures/model/koleso2141.png");*/
	public Modelazlk400() //Same as Filename
	{	    	
		    steer = azlk400_main;
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33azlk/textures/model/azlk400.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);

	        steerX = -27.5F;
	        steerY = 98F;
	        steerZ = -34F;
	        steerR = -20F;
	        
	        wheelX = 58F;
	        wheelX1 = 58F;
	        wheelY = 30F;
	        wheelZ = -139F;
	        wheelZ1 = 117F;
	        
	        translateAll(0F, 0F, 0F);
	        
	}
	 @Override
	 public void renderColoredParts(){
		 //GL11.glTranslatef(0.0F, -3.0F, 0.0F);	
		 //GL11.glColor3f(0.05F, 0.05F, 0.05F);
		model.renderPart("color_int");
		model.renderPart("door_lf_col");
		model.renderPart("door_rf_col");
		model.renderPart("wing_lf_col");
		model.renderPart("wing_rf_col");
		model.renderPart("color");
		model.renderPart("door_rr_col");
		model.renderPart("door_lr_col");
		model.renderPart("colorint2");
	 }
	 @Override
	 public void renderSteer(){
		model.renderPart("tex_rul");
		Minecraft.getMinecraft().renderEngine.bindTexture(color);
		GL11.glColor3f(0.6F, 0.6F, 0.6F);
		model.renderPart("rul");
		GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
	
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, -10.0F, 0.0F);	
		 //GL11.glTranslatef(0.0F, 8.0F, 0.0F);
		 Minecraft.getMinecraft().renderEngine.bindTexture(mzma_logo);
		  model.renderPart("logotip");
		 Minecraft.getMinecraft().renderEngine.bindTexture(azlk400_main);
		    model.renderPart("tex");
			model.renderPart("farp");
			model.renderPart("farza");
			model.renderPart("black");
			model.renderPart("farz");
			Minecraft.getMinecraft().renderEngine.bindTexture(kozha);
			model.renderPart("pol");
			model.renderPart("sed");
			model.renderPart("door_lf_obiv");
			model.renderPart("door_rf_obiv");
			model.renderPart("door_rr_obiv");
			model.renderPart("door_lr_obiv");
			Minecraft.getMinecraft().renderEngine.bindTexture(dirt);
			model.renderPart("Dvigatel");
			model.renderPart("dno");
			model.renderPart("dirt");
			model.renderPart("pedal");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.6F, 0.6F, 0.6F);
			model.renderPart("chrome");
			model.renderPart("bump_fro");
			model.renderPart("bump_rea");
			model.renderPart("door_lf_chrome");
			model.renderPart("door_rf_chrome");
			model.renderPart("wing_lf_chrome");
			model.renderPart("wing_rf_chrome");
			model.renderPart("chrome1");
			model.renderPart("door_rr_chrome");
			model.renderPart("door_lr_chrome");
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
	 @Override
	 public void renderWheels(){	
		 GL11.glScalef(1.20F, 1.20F, 1.0F);	
		
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