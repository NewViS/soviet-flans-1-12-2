//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: vaz2101
// Model Creator: 
// Created on: 01.03.2018 - 00:00:58
// Last changed on: 01.03.2018 - 00:00:58

package com.flansmod.client.model.d33vazs; //Path where the model is located

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicle;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modelvaz2105s extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation black_dirt = new ResourceLocation("minecraft:d33vazs/textures/model/black_dirt.png");
	private ResourceLocation exterier = new ResourceLocation("minecraft:d33vazs/textures/model/exterier.png");
	private ResourceLocation leather_black = new ResourceLocation("minecraft:d33vazs/textures/model/leather_black.png");
	private ResourceLocation leather_grey= new ResourceLocation("minecraft:d33vazs/textures/model/leather_grey.png");
	private ResourceLocation obivka= new ResourceLocation("minecraft:d33vazs/textures/model/obivka.png");
    private ResourceLocation obivka2= new ResourceLocation("minecraft:d33vazs/textures/model/obivka2.png");
	private ResourceLocation torpeda_05= new ResourceLocation("minecraft:d33vazs/textures/model/torpeda_05.png");
	private ResourceLocation torpeda= new ResourceLocation("minecraft:d33vazs/textures/model/torpeda.png");
	private ResourceLocation optika2= new ResourceLocation("minecraft:d33vazs/textures/model/optika2.png");
	private ResourceLocation pribor2105= new ResourceLocation("minecraft:d33vazs/textures/model/pribor2105.png");
	public Modelvaz2105s() //Same as Filename
	{	    	
		    steer = color; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33vazs/textures/model/vaz2105s.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);

	        steerX = -31.5F;
	        steerY = 75F;
	        steerZ = -49F;
	        steerR = -30F;
	        
	        wheelX = 59F;
	        wheelX1 = 59F;
	        wheelY = 25F;
	        wheelZ = -142F;
	        wheelZ1 = 95F;
	    	//list = GL11.glGenLists(1);
	        //GL11.glNewList(list, GL11.GL_COMPILE);
	   	  	        
	        //GL11.glEndList();
	    	 
	        translateAll(0F, 0F, 0F);
	        
	 		//flipAll();	    
	}
	 @Override
	 public void renderColoredParts(){
		// GL11.glTranslatef(0.0F, -45.0F, 0.0F);	
		model.renderPart("body_color_001");
		model.renderPart("RF_color_001");
		model.renderPart("RL_color_001");
		model.renderPart("FR_color_001");
		model.renderPart("RR_color_001");
		model.renderPart("bonnet_001");
		model.renderPart("trunk_001");
		model.renderPart("obves");
	 }
	 @Override
	 public void renderSteer(){
		GL11.glColor3f(0.1F, 0.1F, 0.1F);
		model.renderPart("steer_001");
		GL11.glColor3f(1F, 1F, 1F);
	 }
	 @Override
	 public void renderWheels(){
		GL11.glScalef(0.96F, 0.96F, 0.96F);
		/*Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		d33wheel.renderPart("status_tyre");
		Minecraft.getMinecraft().renderEngine.bindTexture(statusdisk);
		d33wheel.renderPart("vazrect_shtamp");*/
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, -10.0F, 0.0F);	
		 Minecraft.getMinecraft().renderEngine.bindTexture(black_dirt);
			model.renderPart("dno_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(exterier);
			model.renderPart("trunk_tex_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(optika2);
			model.renderPart("pov_001");
			model.renderPart("far_l_001");
			model.renderPart("far_r_001");
			model.renderPart("far_z_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(torpeda);
			model.renderPart("torpeda_tex_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(pribor2105);
			model.renderPart("prib_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(leather_black);
			//model.renderPart("panel_lea");
			Minecraft.getMinecraft().renderEngine.bindTexture(obivka2);
			model.renderPart("obiv_salon_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(obivka);
			model.renderPart("sed_001");
			model.renderPart("RF_leather_001");
			model.renderPart("FR_leather_001");
			model.renderPart("RR_leather_001");
			model.renderPart("RL_leather_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(torpeda_05);
			model.renderPart("prib2_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.5F, 0.5F, 0.5F);
			model.renderPart("body_chrome_001");
			model.renderPart("bumpf_chrome");
			model.renderPart("RF_chrome_001");
			model.renderPart("FR_chrome_001");
			model.renderPart("RR_chrome_001");
			model.renderPart("RL_chrome_001");
			model.renderPart("bumpr_chrome_001");
			model.renderPart("trunk_chrome_001");
			model.renderPart("torpeda_chrome_001");
			model.renderPart("logo_1_001");
			model.renderPart("glushak");
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			model.renderPart("podves_grey_001");
			model.renderPart("baraban_001");
			model.renderPart("grey_salon_001");
			model.renderPart("pol_001");
			//model.renderPart("extra3");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("body_black_001");
			model.renderPart("RF_black_001");
			model.renderPart("RL_black_001");
			model.renderPart("FR_black_001");
			model.renderPart("RR_black_001");
			model.renderPart("black_salon_001");
			model.renderPart("bumpr_black_001");
			model.renderPart("bumpf_black");
			model.renderPart("trunk_black_001");
			model.renderPart("dvorniki_001");
			model.renderPart("panel_lea_001");
			model.renderPart("spoiler");
			GL11.glColor3f(0.3F, 0.1F, 0.1F);
			model.renderPart("pruzin_001");
			GL11.glColor3f(0.9F, 0.9F, 0.9F);
			model.renderPart("white_001");
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
	 @Override
	 public void frontWheelsStuff(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			GL11.glTranslatef(-5F, 0, 0);
			model.renderPart("brakedisc_");
			GL11.glTranslatef(5F, 0, 0);
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
}