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

public class Modelvaz2111 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation body = new ResourceLocation("minecraft:d33vaz/textures/model/body11.png");
	private ResourceLocation dver = new ResourceLocation("minecraft:d33vaz/textures/model/dver.png");
	private ResourceLocation far2110 = new ResourceLocation("minecraft:d33vaz/textures/model/far2110.png");
	private ResourceLocation kpp = new ResourceLocation("minecraft:d33vaz/textures/model/kpp.png");
	private ResourceLocation pedal= new ResourceLocation("minecraft:d33vaz/textures/model/pedal.png");
	private ResourceLocation gr_panel2= new ResourceLocation("minecraft:d33vaz/textures/model/gr_panel2.png");
    private ResourceLocation rul= new ResourceLocation("minecraft:d33vaz/textures/model/rul.png");
	private ResourceLocation sab= new ResourceLocation("minecraft:d33vaz/textures/model/sab.png");
	private ResourceLocation sed= new ResourceLocation("minecraft:d33vaz/textures/model/sed.png");
	//private ResourceLocation obivka2= new ResourceLocation("minecraft:d33vaz/textures/model/obivka2.png");
	//private ResourceLocation panel_texture= new ResourceLocation("minecraft:d33vaz/textures/model/panel_texture.png");
	//private ResourceLocation osfar_zad= new ResourceLocation("minecraft:d33vaz/textures/model/osfar_zad.png");
	//public IModelCustom modeldisk;
	public Modelvaz2111() //Same as Filename
	{	    	
		    steer = rul; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33vaz/textures/model/vaz2111.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);
	        
	       // ResourceLocation disk = new ResourceLocation("minecraft:d33vaz/textures/model/disk/statusdisk_circle.obj");
	       // modeldisk = AdvancedModelLoader.loadModel(disk);
	       // modeldisk = new ModelWrapperDisplayList((WavefrontObject) modeldisk);

	      	steerX = -30.3F;
	        steerY = 82F;
	        steerZ = -58F;
	        steerR = -15F;
	        
	        wheelX = 60F;
	        wheelX1 = 60F;
	        wheelY = 28F;
	        wheelZ = -139F;
	        wheelZ1 = 98F;
	        
	        maxSpedoAngle = 205F;
	    	//list = GL11.glGenLists(1);
	        //GL11.glNewList(list, GL11.GL_COMPILE);
	   	  	        
	        //GL11.glEndList();
	    	 
	        translateAll(0F, 0F, 0F);
	        
	 		//flipAll();	    
	}
	 @Override
	 public void renderColoredParts(){
		Minecraft.getMinecraft().renderEngine.bindTexture(body);
		model.renderPart("bumprea");
		model.renderPart("bumpfro");
		model.renderPart("porogl");
		model.renderPart("poogr");
		model.renderPart("krish");
		model.renderPart("door_l");
		model.renderPart("door_r");
		model.renderPart("bonnet");
		model.renderPart("left");
		model.renderPart("right");
		model.renderPart("left_f");
		model.renderPart("right_f");
		model.renderPart("reshet");
		model.renderPart("trunk");
	 }
	 @Override
	 public void renderWheels(){
		GL11.glScalef(0.96F, 0.96F, 0.96F);
		GL11.glColor3f(0.9F, 0.9F, 0.9F);
	 }
	 @Override
	 public void pre(){
		 GL11.glTranslatef(0.0F, -3.0F, 0.0F);
	 }
	 @Override
	 public void renderSteer(){
			model.renderPart("rul");
	 }
	 @Override
	 public void renderSpedo(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(gr_panel2);
		 GL11.glTranslatef(-25.5F, 86.7F, -74.5F);
		 GL11.glRotatef(-18F, 1f, 0f, 0f);
	 }
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, -10.0F, 0.0F);
		
		 Minecraft.getMinecraft().renderEngine.bindTexture(body);
		 	model.renderPart("rog");
			model.renderPart("gluh");
			model.renderPart("panel");
			model.renderPart("ruk_l");
			model.renderPart("ruk_r");
			model.renderPart("dno");
			Minecraft.getMinecraft().renderEngine.bindTexture(dver);
			model.renderPart("obiv");
			Minecraft.getMinecraft().renderEngine.bindTexture(far2110);
			model.renderPart("far");
			model.renderPart("real");
			model.renderPart("farf");
			model.renderPart("povr");
			model.renderPart("povrf");
			model.renderPart("povrm");
			model.renderPart("kataf");
			model.renderPart("povr1");
			model.renderPart("povrf1");
			model.renderPart("povrm1");
			model.renderPart("stop");
			Minecraft.getMinecraft().renderEngine.bindTexture(kpp);
			model.renderPart("kpp");
			Minecraft.getMinecraft().renderEngine.bindTexture(pedal);
			model.renderPart("ped");
			Minecraft.getMinecraft().renderEngine.bindTexture(sed);
			model.renderPart("sed");
			Minecraft.getMinecraft().renderEngine.bindTexture(sab);
			model.renderPart("sab");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.7F, 0.7F, 0.7F);
			model.renderPart("zercl");
			model.renderPart("zercr");
			model.renderPart("zercm");
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			GL11.glScalef(0.9F, 1F, 1F);
			model.renderPart("baraban");
			GL11.glScalef(1/0.9F, 1F, 1F);
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