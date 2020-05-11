//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: vaz2101
// Model Creator: 
// Created on: 01.03.2018 - 00:00:58
// Last changed on: 01.03.2018 - 00:00:58

package com.flansmod.client.model.d33zaz; //Path where the model is located

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicle;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modelzaz965 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation bamp_r3 = new ResourceLocation("minecraft:d33zaz/textures/model/bamp_r3.png");
	private ResourceLocation kozha = new ResourceLocation("minecraft:d33zaz/textures/model/kozha.png");
	private ResourceLocation leather_grey = new ResourceLocation("minecraft:d33zaz/textures/model/leather_grey.png");
	private ResourceLocation pribor2 = new ResourceLocation("minecraft:d33zaz/textures/model/pribor2.png");
	private ResourceLocation obivka_3 = new ResourceLocation("minecraft:d33zaz/textures/model/obivka_3.png");
	private ResourceLocation rezina = new ResourceLocation("minecraft:d33zaz/textures/model/rezina.png");
	private ResourceLocation sidenia = new ResourceLocation("minecraft:d33zaz/textures/model/sidenia.png");
	private ResourceLocation stop = new ResourceLocation("minecraft:d33zaz/textures/model/stop.png");
	private ResourceLocation ZAZ_Main2 = new ResourceLocation("minecraft:d33zaz/textures/model/ZAZ_Main2.png");
	public Modelzaz965() //Same as Filename
	{	    	
		    steer = ZAZ_Main2; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33zaz/textures/model/zaz965.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);

	        steerX = -28.7F;
	        steerY = 81.5F;
	        steerZ = -53F;
	        steerR = -21F;
	        
	        wheelX = 49F;
	        wheelX1 = 49F;
	        wheelY = 24.5F;
	        wheelZ = -104F;
	        wheelZ1 = 92F;
	        
	        maxSpedoAngle = 160F;
	        translateAll(0F, 0F, 0F);
	        
	}
	 @Override
	 public void renderColoredParts(){
		 //GL11.glTranslatef(0.0F, -3.0F, 0.0F);	
		 //GL11.glColor3f(0.05F, 0.05F, 0.05F);
		model.renderPart("door_lf_col");
		model.renderPart("door_rf_col");
		model.renderPart("boot_col");
		model.renderPart("bonnet_ok");
		model.renderPart("color_main");
		model.renderPart("color3");
		model.renderPart("color2");
		model.renderPart("color1");
		model.renderPart("color");
	 }
	 
	 public void renderSpedo(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(pribor2);
		 GL11.glTranslatef(-28.3F, 84.6F, -62.5F);
		 GL11.glRotatef(-14F, 1f, 0f, 0f);
	 }
	 
	 @Override
	 public void renderSteer(){
		model.renderPart("rul_tex");
		Minecraft.getMinecraft().renderEngine.bindTexture(color);
		  GL11.glColor3f(210/255F, 176/255F, 115/255F);
		model.renderPart("rul_color");
		  GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
	 @Override
	 public void renderWheels(){	
		 GL11.glScalef(0.92F, 0.92F, 0.92F);
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, -10.0F, 0.0F);	
		 //GL11.glTranslatef(0.0F, 8.0F, 0.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(leather_grey);
			model.renderPart("door_rf_lea");
			model.renderPart("Interior_1");
			model.renderPart("door_lf_lea");
			Minecraft.getMinecraft().renderEngine.bindTexture(kozha);
			model.renderPart("door_rf_karm");
			model.renderPart("door_lf_karm");
			Minecraft.getMinecraft().renderEngine.bindTexture(bamp_r3);
			model.renderPart("bump_rear_ok");
			model.renderPart("bump_front_ok");
			Minecraft.getMinecraft().renderEngine.bindTexture(pribor2);
			model.renderPart("pribor");
			Minecraft.getMinecraft().renderEngine.bindTexture(rezina);
			model.renderPart("pol");
			model.renderPart("pedal");
			Minecraft.getMinecraft().renderEngine.bindTexture(sidenia);
			model.renderPart("sed");
			Minecraft.getMinecraft().renderEngine.bindTexture(obivka_3);
			model.renderPart("potol");
			Minecraft.getMinecraft().renderEngine.bindTexture(stop);
			model.renderPart("stop");
			Minecraft.getMinecraft().renderEngine.bindTexture(ZAZ_Main2);
			model.renderPart("door_lf_tex");
			model.renderPart("door_rf_tex");
			model.renderPart("boot_tex");
			model.renderPart("bonnet_logo");
			model.renderPart("tex");
			//model.renderPart("extra1");
			model.renderPart("logo");
			model.renderPart("Dno");
			model.renderPart("Xod");
			model.renderPart("Interior_tex");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.6F, 0.6F, 0.6F);
			model.renderPart("door_lf_chrome");
			model.renderPart("door_rf_chrome");
			model.renderPart("chrome1");
			model.renderPart("chrome");
			model.renderPart("Interior");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("black_main");
			model.renderPart("black_int");
			 GL11.glColor3f(210/255F, 176/255F, 115/255F);
			model.renderPart("Interior1");
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