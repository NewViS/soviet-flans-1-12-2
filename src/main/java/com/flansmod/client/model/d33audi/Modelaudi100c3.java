//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: vaz2101
// Model Creator: 
// Created on: 01.03.2018 - 00:00:58
// Last changed on: 01.03.2018 - 00:00:58

package com.flansmod.client.model.d33audi; //Path where the model is located

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicle;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modelaudi100c3 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation bonnet = new ResourceLocation("minecraft:d33audi/textures/model/bonnet.png");
	private ResourceLocation boot = new ResourceLocation("minecraft:d33audi/textures/model/boot.png");
	private ResourceLocation carpet = new ResourceLocation("minecraft:d33audi/textures/model/carpet.png");
	private ResourceLocation hod1 = new ResourceLocation("minecraft:d33audi/textures/model/hod1.png");
	private ResourceLocation hod2 = new ResourceLocation("minecraft:d33audi/textures/model/hod2.png");
	private ResourceLocation hod3 = new ResourceLocation("minecraft:d33audi/textures/model/hod3.png");
	private ResourceLocation kozha = new ResourceLocation("minecraft:d33audi/textures/model/kozha.png");
	private ResourceLocation leather_grey = new ResourceLocation("minecraft:d33audi/textures/model/leather_grey.png");
	private ResourceLocation optika = new ResourceLocation("minecraft:d33audi/textures/model/optika.png");
	private ResourceLocation pol= new ResourceLocation("minecraft:d33audi/textures/model/pol.png");
	private ResourceLocation pribori= new ResourceLocation("minecraft:d33audi/textures/model/pribori.png");
    private ResourceLocation roof= new ResourceLocation("minecraft:d33audi/textures/model/roof.png");
    private ResourceLocation text1= new ResourceLocation("minecraft:d33audi/textures/model/text1.png");
    private ResourceLocation text2= new ResourceLocation("minecraft:d33audi/textures/model/text2.png");
    private ResourceLocation underbody= new ResourceLocation("minecraft:d33audi/textures/model/underbody.png");
	public Modelaudi100c3() //Same as Filename
	{	    	
		    steer = kozha; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33audi/textures/model/audi100c3.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);

	        steerX = -37.5F;
	        steerY = 85F;
	        steerZ = -55F;
	        steerR = -30F;
	        
	        wheelX = 68F;
	        wheelX1 = 65F;
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
		model.renderPart("color1");
		model.renderPart("color_main");
		model.renderPart("door_rf_color");
		model.renderPart("boot_color");
		model.renderPart("door_rr_color");
		model.renderPart("door_lr_color");
		model.renderPart("door_lf_color");
		model.renderPart("bonnet_color");
	 }
	 @Override
	 public void renderSteer(){
		//Minecraft.getMinecraft().renderEngine.bindTexture(rul);
		model.renderPart("rul");
		Minecraft.getMinecraft().renderEngine.bindTexture(text1);
		model.renderPart("rul_logo");
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
		 Minecraft.getMinecraft().renderEngine.bindTexture(bonnet);
			model.renderPart("bonnet_under");
			Minecraft.getMinecraft().renderEngine.bindTexture(roof);
			model.renderPart("potol");
			Minecraft.getMinecraft().renderEngine.bindTexture(pol);
			model.renderPart("pol");
			Minecraft.getMinecraft().renderEngine.bindTexture(leather_grey);
			model.renderPart("lea_gr");
			model.renderPart("door_rf_leagr");
			model.renderPart("door_rr_leagr");
			model.renderPart("door_lr_leagr");
			model.renderPart("door_lf_obiv2");
			Minecraft.getMinecraft().renderEngine.bindTexture(text1);
			model.renderPart("tex");
			model.renderPart("tex_main");
			model.renderPart("bump_fro");
			model.renderPart("bump_rea");
			model.renderPart("door_rf_tex");
			model.renderPart("boot_tex");
			model.renderPart("door_rr_tex");
			model.renderPart("door_lr_tex");
			model.renderPart("door_lf_tex");
			Minecraft.getMinecraft().renderEngine.bindTexture(text2);
			model.renderPart("text21");
			model.renderPart("text2");
			Minecraft.getMinecraft().renderEngine.bindTexture(pribori);
			model.renderPart("spedom");
			Minecraft.getMinecraft().renderEngine.bindTexture(boot);
			model.renderPart("boot_under");
			Minecraft.getMinecraft().renderEngine.bindTexture(carpet);
			model.renderPart("carpet");
			Minecraft.getMinecraft().renderEngine.bindTexture(hod1);
			model.renderPart("hod1");
			Minecraft.getMinecraft().renderEngine.bindTexture(hod2);
			model.renderPart("hod2");
			Minecraft.getMinecraft().renderEngine.bindTexture(hod3);
			model.renderPart("hod3");
			Minecraft.getMinecraft().renderEngine.bindTexture(optika);
			model.renderPart("fari");
			Minecraft.getMinecraft().renderEngine.bindTexture(kozha);
			model.renderPart("lea_bl");
			model.renderPart("door_rf_leabl");
			model.renderPart("door_rr_leabl");
			model.renderPart("door_lr_leabl");
			model.renderPart("door_lf_obiv");
			Minecraft.getMinecraft().renderEngine.bindTexture(underbody);
			model.renderPart("underbody");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			//GL11.glColor3f(0.6F, 0.6F, 0.6F);
			//model.renderPart("fara_r");
		    GL11.glColor3f(0.3F, 0.3F, 0.3F);
			//model.renderPart("boot_black1");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("bonnet_black");
			model.renderPart("far_black");
			GL11.glColor3f(0.3F, 0.1F, 0.1F);
			//model.renderPart("far_red");
			GL11.glColor3f(0.9F, 0.9F, 0.9F);
			//model.renderPart("white");
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