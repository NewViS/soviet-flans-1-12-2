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

public class Modelvaz2104 extends SovietModelVehicle //Same as Filename
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
	private ResourceLocation farz= new ResourceLocation("minecraft:d33vaz/textures/model/fara2104.jpg");
	private ResourceLocation pribor2105= new ResourceLocation("minecraft:d33vaz/textures/model/pribor2105.png");
	public Modelvaz2104() //Same as Filename
	{	    	
		    steer = color; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33vaz/textures/model/vaz2104.obj");
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
	 @Override
	 public void renderColoredParts(){
		// GL11.glTranslatef(0.0F, -45.0F, 0.0F);	
		model.renderPart("body_color");
		model.renderPart("RF_color");
		model.renderPart("FR_color");
		model.renderPart("bonnet");
		model.renderPart("lr_color");
		model.renderPart("rr_color");
		model.renderPart("bagcolor");
	 }
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
		 Minecraft.getMinecraft().renderEngine.bindTexture(black_dirt);
			model.renderPart("dno");
			Minecraft.getMinecraft().renderEngine.bindTexture(optika2);
			model.renderPart("pov");
			model.renderPart("far_l");
			model.renderPart("far_r");
			Minecraft.getMinecraft().renderEngine.bindTexture(farz);
			model.renderPart("fazrz");
			model.renderPart("shild");
			Minecraft.getMinecraft().renderEngine.bindTexture(torpeda);
			model.renderPart("torpeda_te");
			Minecraft.getMinecraft().renderEngine.bindTexture(pribor2105);
			model.renderPart("prib");
			Minecraft.getMinecraft().renderEngine.bindTexture(leather_black);
			//model.renderPart("panel_lea");
			Minecraft.getMinecraft().renderEngine.bindTexture(obivka2);
			model.renderPart("potolok");
			Minecraft.getMinecraft().renderEngine.bindTexture(obivka);
			model.renderPart("sed");
			model.renderPart("RF_leather");
			model.renderPart("FR_leather");
			model.renderPart("rr_lea");
			model.renderPart("lr_lea");
			
			model.renderPart("lea_potol");
			Minecraft.getMinecraft().renderEngine.bindTexture(torpeda_05);
			model.renderPart("prib2");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.5F, 0.5F, 0.5F);
			model.renderPart("body_chrome");
			model.renderPart("bumpf_chro");
			model.renderPart("bumpr_chro");
			model.renderPart("RF_chrome");
			model.renderPart("FR_chrome");
			model.renderPart("torpeda_ch");
			model.renderPart("body_");
			model.renderPart("logo_1");
			model.renderPart("body_chrom");
			model.renderPart("lr_chrome");
			model.renderPart("rr_chrome");
			model.renderPart("bag_chrome");
			model.renderPart("baglamp");
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			model.renderPart("podves_gre");
			model.renderPart("grey_salon");
			//model.renderPart("extra3");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("body_black");
			model.renderPart("dvorniki");
			model.renderPart("bumpf_blac");
			model.renderPart("bumpr_blac");
			model.renderPart("black_salo");
			model.renderPart("FR_black");
			model.renderPart("RF_black");
			model.renderPart("pol");
			model.renderPart("panel_lea");
			model.renderPart("polca");
			model.renderPart("farz_black");
			model.renderPart("bagajb");
			model.renderPart("black_2");
			model.renderPart("lr_black");
			model.renderPart("rr_black");
			model.renderPart("bagruk");
			model.renderPart("bag_black");
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