//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: vaz2101
// Model Creator: 
// Created on: 01.03.2018 - 00:00:58
// Last changed on: 01.03.2018 - 00:00:58

package com.flansmod.client.model.d33mercedes; //Path where the model is located

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicle;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modelmercedesg500 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation black_dirt = new ResourceLocation("minecraft:d33mercedes/textures/model/black_dirt.png");
	private ResourceLocation amg = new ResourceLocation("minecraft:d33mercedes/textures/model/amg.png");
	private ResourceLocation benzobak = new ResourceLocation("minecraft:d33mercedes/textures/model/benzobak.png");
	private ResourceLocation gps= new ResourceLocation("minecraft:d33mercedes/textures/model/gps.png");
	private ResourceLocation grill2= new ResourceLocation("minecraft:d33mercedes/textures/model/grill2.png");
    private ResourceLocation interior= new ResourceLocation("minecraft:d33mercedes/textures/model/interior.png");
    private ResourceLocation rul= new ResourceLocation("minecraft:d33mercedes/textures/model/rul.png");
    private ResourceLocation rul2= new ResourceLocation("minecraft:d33mercedes/textures/model/rul2.png");
    private ResourceLocation salonwithderevo= new ResourceLocation("minecraft:d33mercedes/textures/model/salonwithderevo.png");
	public Modelmercedesg500() //Same as Filename
	{	    	
		    steer = rul; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33mercedes/textures/model/gclass.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);

	        steerX = -43.5F;
	        steerY = 110F;
	        steerZ = -40F;
	        steerR = -30F;
	        
	        wheelX = 58F;
	        wheelX1 = 58F;
	        wheelY = 25F;
	        wheelZ = -142F;
	        wheelZ1 = 125F;
	        
	        translateAll(0F, 0F, 0F);
	        
	}
	 @Override
	 public void renderColoredParts(){
		 //GL11.glTranslatef(0.0F, 10.0F, 0.0F);	
		 GL11.glColor3f(0.05F, 0.05F, 0.05F);
		model.renderPart("color");
		model.renderPart("boot_color");
		model.renderPart("lr_color");
		model.renderPart("rr_color");
		model.renderPart("rf_color");
		model.renderPart("lf_color");
		model.renderPart("bumpf_color");
		model.renderPart("bumpr_color");
		model.renderPart("bonnet");
	 }
	 @Override
	 public void renderSteer(){
		Minecraft.getMinecraft().renderEngine.bindTexture(rul);
		model.renderPart("rul_pered");
		Minecraft.getMinecraft().renderEngine.bindTexture(rul2);
		model.renderPart("rul_zad");
	 }
	 @Override
	 public void renderWheels(){
		GL11.glScalef(1.21F, 1.21F, 1.4F);
		/*Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		d33wheel.renderPart("status_tyre");
		Minecraft.getMinecraft().renderEngine.bindTexture(statusdisk);
		d33wheel.renderPart("vazrect_shtamp");*/
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, -10.0F, 0.0F);	
		 GL11.glTranslatef(0.0F, 8.0F, 0.0F);
		 Minecraft.getMinecraft().renderEngine.bindTexture(black_dirt);
			model.renderPart("dno");
			Minecraft.getMinecraft().renderEngine.bindTexture(amg);
			model.renderPart("amg");
			Minecraft.getMinecraft().renderEngine.bindTexture(benzobak);
			model.renderPart("benz");
			Minecraft.getMinecraft().renderEngine.bindTexture(gps);
			model.renderPart("gps");
			Minecraft.getMinecraft().renderEngine.bindTexture(grill2);
			model.renderPart("reshet");
			model.renderPart("bumpf_tex");
			Minecraft.getMinecraft().renderEngine.bindTexture(interior);
			model.renderPart("interior");
			Minecraft.getMinecraft().renderEngine.bindTexture(salonwithderevo);
			model.renderPart("boot_tex");
			model.renderPart("lr_tex");
			model.renderPart("rr_tex");
			model.renderPart("lf_tex");
			model.renderPart("rf_tex");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.6F, 0.6F, 0.6F);
			model.renderPart("fara_r");
			model.renderPart("fara2");
			model.renderPart("fara1");
			model.renderPart("exhaust_ok");
			model.renderPart("boot_chrome");
			model.renderPart("lr_chrome");
			model.renderPart("lf_chrome");
			model.renderPart("rf_chrome");
			model.renderPart("rr_chrome");
			model.renderPart("bumpf_chrome");
			model.renderPart("chrome");
		    GL11.glColor3f(0.3F, 0.3F, 0.3F);
			model.renderPart("boot_black1");
			//model.renderPart("extra3");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("black");
			model.renderPart("exhaust_ok1");
			model.renderPart("boot_black");
			model.renderPart("lr_black");
			model.renderPart("rr_black");
			model.renderPart("rf_black");
			model.renderPart("lf_black");
			GL11.glColor3f(0.3F, 0.1F, 0.1F);
			model.renderPart("far_red");
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