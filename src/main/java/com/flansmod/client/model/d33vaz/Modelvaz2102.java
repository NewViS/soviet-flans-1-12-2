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

public class Modelvaz2102 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	public ResourceLocation tex = new ResourceLocation("minecraft:d33vaz/textures/model/ruch1.png");
	public ResourceLocation tex2 = new ResourceLocation("minecraft:d33vaz/textures/model/ruch2.png");
	public ResourceLocation kolodki = new ResourceLocation("minecraft:d33vaz/textures/model/nomer.png");
	public ResourceLocation disk = new ResourceLocation("minecraft:d33vaz/textures/model/VAZ_Main.png");
	public ResourceLocation pedal= new ResourceLocation("minecraft:d33vaz/textures/model/vaz2102.png");
	public ResourceLocation kpp= new ResourceLocation("minecraft:d33vaz/textures/model/obivka.png");
	public Modelvaz2102() //Same as Filename
	{	    	
		    steer = disk;
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33vaz/textures/model/vaz2102.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);

	        steerX = -36F;
	        steerY = 83F;
	        steerZ = -67F;
	        steerR = -30F;
	        
	        wheelX = 55F;
	        wheelX1 = 58F;
	        wheelY = 25F;
	        wheelZ = -142F;
	        wheelZ1 = 100F;
	    	//list = GL11.glGenLists(1);
	        //GL11.glNewList(list, GL11.GL_COMPILE);
	   	  	        
	        //GL11.glEndList();
	    	 
	        translateAll(0F, 0F, 0F);
	        
	 		//flipAll();	    
	}
	 @Override
	 public void renderColoredParts(){
		model.renderPart("door_rr");
		model.renderPart("door_fl");
		model.renderPart("door_rf");
		model.renderPart("hood");
		model.renderPart("boot");
		model.renderPart("Chassis");
		model.renderPart("door_fr");
	 }
	 @Override
	 public void renderWheels(){
		/*Minecraft.getMinecraft().renderEngine.bindTexture(wheel_vaz_shtamp);
		d33wheel.renderPart("wheel_vazkolpac");*/
	 }
	 @Override
	 public void renderTexturedParts(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(tex);
			model.renderPart("ruk_fl");
			Minecraft.getMinecraft().renderEngine.bindTexture(tex2);
			model.renderPart("ruk_fr");
			model.renderPart("ruk_rr");
			model.renderPart("ruk_rf");
			Minecraft.getMinecraft().renderEngine.bindTexture(kpp);
			model.renderPart("obiv_fr");
			model.renderPart("obiv_fl");
			model.renderPart("siden");
			model.renderPart("obiv_rr");
			model.renderPart("obiv_rf");
			model.renderPart("dno");
			Minecraft.getMinecraft().renderEngine.bindTexture(pedal);
			model.renderPart("wing_lf");
			model.renderPart("wing_rf");
			model.renderPart("Dvigatel");
			model.renderPart("pov");	
			model.renderPart("dvor");
			model.renderPart("Fari_zad");
			model.renderPart("boot_pfr");
			model.renderPart("bump_rea");
			model.renderPart("Interior");
			model.renderPart("bump_fro");
			Minecraft.getMinecraft().renderEngine.bindTexture(disk);
			model.renderPart("doorpanel_rr");
			model.renderPart("doorpanel_fr");
			model.renderPart("doorpanel_fl");
			model.renderPart("doorpanel_rf");
			model.renderPart("undercap");
			model.renderPart("fullsize_a");
			model.renderPart("fullsize_c");
			model.renderPart("fullsize_s");
			model.renderPart("fullsize_l");
			model.renderPart("fullsize_11");
			model.renderPart("fullsize_u");
			model.renderPart("fullsize_12");
			model.renderPart("fullsize_9");
			model.renderPart("fullsize_10");
			model.renderPart("fullsize_f");
			model.renderPart("fullsize_t");
			//model.renderPart("fullsize_steer");
			model.renderPart("intmirror");
			//model.renderPart("extra");
			Minecraft.getMinecraft().renderEngine.bindTexture(kolodki);
			model.renderPart("nomer_fro");
			model.renderPart("nomerzad");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.5F, 0.5F, 0.5F);
			model.renderPart("mirror");
			model.renderPart("body_chrome");
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			model.renderPart("baraban");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("dnodna");
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
	 @Override
	 public void frontWheelsStuff(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			GL11.glTranslatef(-11F, 0, 0);
			model.renderPart("brakedisc_");
			GL11.glTranslatef(11F, 0, 0);
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
}