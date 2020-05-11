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

public class Modelvaz2105rust extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation black_dirt = new ResourceLocation("minecraft:d33vaz/textures/model/black_dirt.png");
	private ResourceLocation exterier = new ResourceLocation("minecraft:d33vaz/textures/model/exterier.png");
	private ResourceLocation leather_black = new ResourceLocation("minecraft:d33vaz/textures/model/leather_black.png");
	private ResourceLocation leather_grey= new ResourceLocation("minecraft:d33vaz/textures/model/leather_grey.png");
	private ResourceLocation obivka= new ResourceLocation("minecraft:d33vaz/textures/model/obivka.png");
    private ResourceLocation obivka2= new ResourceLocation("minecraft:d33vaz/textures/model/obivka2.png");
	private ResourceLocation torpeda_05= new ResourceLocation("minecraft:d33vaz/textures/model/torpeda_05.png");
	private ResourceLocation torpeda= new ResourceLocation("minecraft:d33vaz/textures/model/torpeda.png");
	private ResourceLocation optika2= new ResourceLocation("minecraft:d33vaz/textures/model/optika2.png");
	private ResourceLocation pribor2105= new ResourceLocation("minecraft:d33vaz/textures/model/pribor2105.png");
	private ResourceLocation rust= new ResourceLocation("minecraft:d33vaz/textures/model/rust.jpg");
	public Modelvaz2105rust() //Same as Filename
	{	    	
		    steer = color; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33vaz/textures/model/vaz2105rust.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);

	        steerX = -31.5F;
	        steerY = 81F;
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
	/* @Override
	 public void renderColoredParts(){ }*/
	 @Override
	 public void renderSteer(){
		GL11.glColor3f(0.1F, 0.1F, 0.1F);
		model.renderPart("steer");
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
		    GL11.glColor3f(0.4F, 0.4F, 0.4F);
			Minecraft.getMinecraft().renderEngine.bindTexture(exterier);
			model.renderPart("trunk_tex");
			Minecraft.getMinecraft().renderEngine.bindTexture(rust);
			model.renderPart("body_color");
			model.renderPart("body_chrome");
			model.renderPart("RF_color");
			model.renderPart("RL_color");
			model.renderPart("FR_color");
			model.renderPart("RR_color");
			model.renderPart("bonnet");
			model.renderPart("trunk");
			model.renderPart("bumpf_chrome");
			model.renderPart("podves_grey");
	        model.renderPart("baraban");
	        model.renderPart("dno");
			Minecraft.getMinecraft().renderEngine.bindTexture(optika2);
			model.renderPart("pov");
			model.renderPart("far_l");
			model.renderPart("far_r");
			model.renderPart("far_z");
			Minecraft.getMinecraft().renderEngine.bindTexture(torpeda);
			model.renderPart("torpeda_tex");
			Minecraft.getMinecraft().renderEngine.bindTexture(pribor2105);
			model.renderPart("prib");
			Minecraft.getMinecraft().renderEngine.bindTexture(leather_black);
			//model.renderPart("panel_lea");
			Minecraft.getMinecraft().renderEngine.bindTexture(obivka2);
			model.renderPart("obiv_salon");
			Minecraft.getMinecraft().renderEngine.bindTexture(obivka);
			model.renderPart("sed");
			model.renderPart("RF_leather");
			model.renderPart("FR_leather");
			model.renderPart("RR_leather");
			model.renderPart("RL_leather");
			Minecraft.getMinecraft().renderEngine.bindTexture(torpeda_05);
			model.renderPart("prib2");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.5F, 0.5F, 0.5F);
			model.renderPart("RF_chrome");
			model.renderPart("FR_chrome");
			model.renderPart("RR_chrome");
			model.renderPart("RL_chrome");
			model.renderPart("trunk_chrome");
			model.renderPart("torpeda_chrome");
			model.renderPart("logo_1");
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			model.renderPart("grey_salon");
			model.renderPart("pol");
			//model.renderPart("extra3");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("body_black");
			model.renderPart("RF_black");
			model.renderPart("RL_black");
			model.renderPart("FR_black");
			model.renderPart("RR_black");
			model.renderPart("black_salon");
			model.renderPart("bumpf_black");
			model.renderPart("trunk_black");
			model.renderPart("dvorniki");
			model.renderPart("panel_lea");
			GL11.glColor3f(0.3F, 0.1F, 0.1F);
			model.renderPart("pruzin");
			GL11.glColor3f(0.9F, 0.9F, 0.9F);
			model.renderPart("white");
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