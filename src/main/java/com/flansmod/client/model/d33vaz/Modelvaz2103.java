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

public class Modelvaz2103 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation derevo = new ResourceLocation("minecraft:d33vaz/textures/model/derevo.png");
	private ResourceLocation farp = new ResourceLocation("minecraft:d33vaz/textures/model/far_p.png");
	private ResourceLocation pribory = new ResourceLocation("minecraft:d33vaz/textures/model/pribory.png");
	private ResourceLocation salo_tex = new ResourceLocation("minecraft:d33vaz/textures/model/salo_tex.png");
	private ResourceLocation torpeda= new ResourceLocation("minecraft:d33vaz/textures/model/torpeda.png");
	private ResourceLocation obivka= new ResourceLocation("minecraft:d33vaz/textures/model/obivka.png");
	private ResourceLocation VAZ_Main= new ResourceLocation("minecraft:d33vaz/textures/model/VAZ_Main.png");
	private ResourceLocation vaz2102= new ResourceLocation("minecraft:d33vaz/textures/model/vaz2102.png");
	private ResourceLocation z_far_03= new ResourceLocation("minecraft:d33vaz/textures/model/z_far_03.png");
	private ResourceLocation z_far_03_big= new ResourceLocation("minecraft:d33vaz/textures/model/z_far_03_big.png");
	public Modelvaz2103() //Same as Filename
	{	    	
		    steer = torpeda; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33vaz/textures/model/vaz21036.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);

	        steerX = -28.7F;
	        steerY = 81F;
	        steerZ = -64F;
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
		model.renderPart("body");
		model.renderPart("door_lf_ok");
		model.renderPart("door_lr_ok");
		model.renderPart("bonnet_ok");
		model.renderPart("door_rf_ok");
		model.renderPart("door_rr_ok");
		model.renderPart("boot_ok");
	 }
	 @Override
	 public void renderWheels(){
		/*Minecraft.getMinecraft().renderEngine.bindTexture(wheel_vaz_shtamp);
		d33wheel.renderPart("wheel_vazkolpac");*/
	 }
	 @Override
	 public void renderTexturedParts(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(derevo);
			model.renderPart("derevo");
			Minecraft.getMinecraft().renderEngine.bindTexture(farp);
			model.renderPart("reshet");
			Minecraft.getMinecraft().renderEngine.bindTexture(pribory);
			model.renderPart("pribor");
			Minecraft.getMinecraft().renderEngine.bindTexture(salo_tex);
			model.renderPart("remni");
			Minecraft.getMinecraft().renderEngine.bindTexture(torpeda);
			model.renderPart("panel");
			Minecraft.getMinecraft().renderEngine.bindTexture(obivka);
			model.renderPart("dash");
			model.renderPart("sed");
			model.renderPart("sed_1");
			model.renderPart("sidenz");
			model.renderPart("door_lf_obiv");
			model.renderPart("door_rr_obiv");
			model.renderPart("door_lr_obiv");
			model.renderPart("door_rf_obiv");
			Minecraft.getMinecraft().renderEngine.bindTexture(VAZ_Main);
			model.renderPart("fullsize_a");
			model.renderPart("fulls10");
			model.renderPart("fulls11");
			model.renderPart("fulls12");
			model.renderPart("fulls5");
			model.renderPart("fullsize_u");
			model.renderPart("fullsize_f");
			model.renderPart("fulls9");
			model.renderPart("fullsize_l");
			model.renderPart("fullsize_c");
			model.renderPart("fulls9_001");
			model.renderPart("undercap");
			Minecraft.getMinecraft().renderEngine.bindTexture(vaz2102);
			model.renderPart("Dvigatel");
			model.renderPart("bump_fro");
			Minecraft.getMinecraft().renderEngine.bindTexture(z_far_03);
			model.renderPart("pov");
			model.renderPart("pov1");
			Minecraft.getMinecraft().renderEngine.bindTexture(z_far_03_big);
			model.renderPart("far_r");
			model.renderPart("far_l");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.5F, 0.5F, 0.5F);
			model.renderPart("door_rr_chrome");
			model.renderPart("door_lr_chrome");
			model.renderPart("door_rf_chrome");
			model.renderPart("door_lf_chrome");
			model.renderPart("body_chrome");
			model.renderPart("body_chrome_1");
			model.renderPart("boot_chrome");
			model.renderPart("bump_rea011");
			model.renderPart("ram_r");
			model.renderPart("ram_l");
			model.renderPart("chrome");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("dnodna");
			model.renderPart("bump_rea01");
			model.renderPart("boot_black");
			model.renderPart("pol");
			GL11.glColor3f(0.2F, 0.2F, 0.2F);
			model.renderPart("dvorniki");
			model.renderPart("door_rf_black");
			model.renderPart("door_lr_black");
			model.renderPart("door_lf_black");
			model.renderPart("door_rr_black");
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			model.renderPart("baraban");
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