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

public class Modelvaz2101 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	protected ResourceLocation black_dirt = new ResourceLocation("minecraft:d33vaz/textures/model/black_dirt.png");
	protected ResourceLocation derevo = new ResourceLocation("minecraft:d33vaz/textures/model/chrome_lines.png");
	protected ResourceLocation obivka = new ResourceLocation("minecraft:d33vaz/textures/model/obivka.png");
	protected ResourceLocation potol = new ResourceLocation("minecraft:d33vaz/textures/model/obivka2.png");
	protected ResourceLocation doors2101 = new ResourceLocation("minecraft:d33vaz/textures/model/doors2101.png");
	protected ResourceLocation engine2101= new ResourceLocation("minecraft:d33vaz/textures/model/engine2101.png");
	protected ResourceLocation exterior2101= new ResourceLocation("minecraft:d33vaz/textures/model/exterior2101.png");
	protected ResourceLocation melochi2101= new ResourceLocation("minecraft:d33vaz/textures/model/melochi2101.png");
	protected ResourceLocation salon2101= new ResourceLocation("minecraft:d33vaz/textures/model/210113.png");
	protected ResourceLocation sed= new ResourceLocation("minecraft:d33vaz/textures/model/sidushki2101.png");
	//private ResourceLocation torpeda= new ResourceLocation("minecraft:d33vaz/textures/model/torpeda.png");
	//private ResourceLocation optika2= new ResourceLocation("minecraft:d33vaz/textures/model/optika2107.jpg");
	//private ResourceLocation pribor2105= new ResourceLocation("minecraft:d33vaz/textures/model/pribor2105.png");
	//private ResourceLocation rust= new ResourceLocation("minecraft:d33vaz/textures/model/rust.jpg");
	public Modelvaz2101() //Same as Filename
	{	    	
		    steer = salon2101; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33vaz/textures/model/vaz2101.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);
	        disk_model1 = new ResourceLocation("minecraft:d33vaz/textures/model/disk/statusdisk_circlerect.obj");
	        d33wheel = AdvancedModelLoader.loadModel(disk_model1);
	        steerX = -30.5F;
	        steerY = 80F;
	        steerZ = -58F;
	        steerR = -30F;
	        
	        wheelX = 58F;
	        wheelX1 = 55F;
	        wheelY = 25F;
	        wheelZ = -142F;
	        wheelZ1 = 100F;
	        
	        translateAll(0F, 0F, 0F);
	        
	}
	 @Override
	 public void renderColoredParts(){
		// GL11.glTranslatef(0.0F, -45.0F, 0.0F);	
		model.renderPart("body_color");
		model.renderPart("lf_color");
		model.renderPart("rf_color");
		model.renderPart("rr_color");
		model.renderPart("lr_color");
		model.renderPart("salon_color");
		model.renderPart("bonnet_color");
		model.renderPart("boot_color");
		model.renderPart("under_color");
	 }
	/* @Override
	 public void renderSteer(){
		model.renderPart("rul_tex");
		Minecraft.getMinecraft().renderEngine.bindTexture(color);
		GL11.glColor3f(0.6F, 0.6F, 0.6F);
		model.renderPart("rul_chrome");
		GL11.glColor3f(1F, 1F, 1F);
	 }*/
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
			Minecraft.getMinecraft().renderEngine.bindTexture(derevo);
			model.renderPart("torpeda_derev");
			Minecraft.getMinecraft().renderEngine.bindTexture(melochi2101);
			model.renderPart("melochi_tex");
			model.renderPart("melochi_tex1");
			Minecraft.getMinecraft().renderEngine.bindTexture(salon2101);
			model.renderPart("torpeda_salon");
			model.renderPart("torpeda_tex1");
			Minecraft.getMinecraft().renderEngine.bindTexture(doors2101);
			model.renderPart("lf_tex");
			model.renderPart("rf_tex");
			model.renderPart("rr_tex");
			model.renderPart("lr_tex");
			Minecraft.getMinecraft().renderEngine.bindTexture(engine2101);
			model.renderPart("dvigatel");
			Minecraft.getMinecraft().renderEngine.bindTexture(obivka);
			model.renderPart("kozir");
			Minecraft.getMinecraft().renderEngine.bindTexture(sed);
			model.renderPart("sidushki");
			Minecraft.getMinecraft().renderEngine.bindTexture(potol);
			model.renderPart("potol");
			Minecraft.getMinecraft().renderEngine.bindTexture(exterior2101);
			model.renderPart("logo");
			model.renderPart("farar_ste");
			model.renderPart("fara_pered");
			model.renderPart("pov_pered");
			model.renderPart("boot_tex");
			model.renderPart("body_tex");
			model.renderPart("bum");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.6F, 0.6F, 0.6F);
			model.renderPart("reshet");
			model.renderPart("bumpf_chrome");
			model.renderPart("lf_chrome");
			model.renderPart("rf_chrome");
			model.renderPart("rr_chrome");
			model.renderPart("lr_chrome");
			model.renderPart("bumpr_chrome");
			model.renderPart("gluh");
			model.renderPart("body_chrome1");
			model.renderPart("body_chrome");
			model.renderPart("torpeda_chrome1");
			model.renderPart("salon_chrome");
			model.renderPart("pered_chrome");
			model.renderPart("fara_chrome");
			model.renderPart("zerkal");
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			model.renderPart("body_grey");
			GL11.glScalef(0.9F, 1F, 1F);
			model.renderPart("baraban");
			GL11.glScalef(1/0.9F, 1F, 1F);
			
			//model.renderPart("extra3");
			GL11.glColor3f(0.87F, 0.4F, 0.07F);
			model.renderPart("pov_");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("torpeda_pol");
			model.renderPart("torpeda_black2_torpeda_chrome");
			model.renderPart("torpeda_black");
			model.renderPart("body_ark");
			model.renderPart("fara__black");
			model.renderPart("uplot1");
			model.renderPart("salon_black");
			model.renderPart("bumpr_tex");
			model.renderPart("bumpf_tex");
			model.renderPart("uplot");
			model.renderPart("uplotn");
			model.renderPart("arki");
			model.renderPart("pered_black");
			model.renderPart("torpeda_lea");
			model.renderPart("pol");
			model.renderPart("patrub");
			model.renderPart("torpeda_black1");
			model.renderPart("pol1");
			model.renderPart("under_black");
			GL11.glColor3f(0.3F, 0.1F, 0.1F);
			model.renderPart("pruzin");
			GL11.glColor3f(0.9F, 0.9F, 0.9F);
			//model.renderPart("white");
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