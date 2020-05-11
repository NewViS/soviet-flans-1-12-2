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

public class Modelazlk2141 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation azlk_main = new ResourceLocation("minecraft:d33azlk/textures/model/azlk_main.png");
	private ResourceLocation dno = new ResourceLocation("minecraft:d33azlk/textures/model/dno.png");
	private ResourceLocation engine = new ResourceLocation("minecraft:d33azlk/textures/model/engine.png");
	private ResourceLocation konsol = new ResourceLocation("minecraft:d33azlk/textures/model/konsol.png");
	private ResourceLocation leather_grey = new ResourceLocation("minecraft:d33azlk/textures/model/leather_grey.png");
	private ResourceLocation obivka_3 = new ResourceLocation("minecraft:d33azlk/textures/model/obivka_3.png");
	private ResourceLocation kozha = new ResourceLocation("minecraft:d33azlk/textures/model/kozha.png");
	private ResourceLocation koleso2141 = new ResourceLocation("minecraft:d33vaz/textures/model/koleso2141.png");
	public Modelazlk2141() //Same as Filename
	{	    	
		    steer = azlk_main;
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33azlk/textures/model/azlk2141.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);

	        steerX = -37.5F;
	        steerY = 79F;
	        steerZ = -59F;
	        steerR = -20F;
	        
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
		model.renderPart("Salon_color");
		model.renderPart("boot_color");
		model.renderPart("bonnet");
		model.renderPart("door_lf_color");
		model.renderPart("door_lr_color");
		model.renderPart("door_rf_color");
		model.renderPart("door_rr_color");
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
		 Minecraft.getMinecraft().renderEngine.bindTexture(koleso2141);
			model.renderPart("koleso");
			Minecraft.getMinecraft().renderEngine.bindTexture(leather_grey);
			model.renderPart("door_lf_leagr");
			model.renderPart("door_rf_leagr");
			model.renderPart("door_lr_leagr");
			model.renderPart("door_rr_leagr");
			Minecraft.getMinecraft().renderEngine.bindTexture(engine);
			model.renderPart("engine");
			Minecraft.getMinecraft().renderEngine.bindTexture(azlk_main);
			model.renderPart("Dvigatel_main");
			model.renderPart("boot_main");
			model.renderPart("bump_rea");
			model.renderPart("bump_fro");
			model.renderPart("door_lf_main");
			model.renderPart("door_rf_main");
			model.renderPart("door_rr_main");
			model.renderPart("door_lr_main");
			model.renderPart("main");
			model.renderPart("Salon_main");
			Minecraft.getMinecraft().renderEngine.bindTexture(konsol);
			model.renderPart("konsol");
			Minecraft.getMinecraft().renderEngine.bindTexture(obivka_3);
			model.renderPart("Salon_leagr");
			model.renderPart("Salon_obiv");
			model.renderPart("boot_obiv");
			Minecraft.getMinecraft().renderEngine.bindTexture(dno);
			model.renderPart("dno");
			Minecraft.getMinecraft().renderEngine.bindTexture(kozha);
			model.renderPart("Salon_leabl");
			model.renderPart("Salon_pol");
			model.renderPart("Salon_leabl1");
			model.renderPart("door_lf_leabl");
			model.renderPart("door_rf_leabl");
			model.renderPart("door_lr_leabl");
			model.renderPart("door_rr_leabl");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("black");
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