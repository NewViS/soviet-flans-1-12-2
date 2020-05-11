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

public class Modelquattro extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation body = new ResourceLocation("minecraft:d33audi/textures/model/body.png");
	private ResourceLocation body_part = new ResourceLocation("minecraft:d33audi/textures/model/body_part.png");
	private ResourceLocation glasshh = new ResourceLocation("minecraft:d33audi/textures/model/glasshh.png");
	private ResourceLocation konsola = new ResourceLocation("minecraft:d33audi/textures/model/konsola.png");
	private ResourceLocation mot = new ResourceLocation("minecraft:d33audi/textures/model/mot.png");
	private ResourceLocation qua3 = new ResourceLocation("minecraft:d33audi/textures/model/qua3.png");
	private ResourceLocation qua4 = new ResourceLocation("minecraft:d33audi/textures/model/qua4.png");
	private ResourceLocation qua5 = new ResourceLocation("minecraft:d33audi/textures/model/qua5.png");
	private ResourceLocation qua6 = new ResourceLocation("minecraft:d33audi/textures/model/qua6.png");
	private ResourceLocation pol= new ResourceLocation("minecraft:d33audi/textures/model/pol.png");
	private ResourceLocation qua1111= new ResourceLocation("minecraft:d33audi/textures/model/qua1111.png");
    private ResourceLocation silnik= new ResourceLocation("minecraft:d33audi/textures/model/silnik.png");
    private ResourceLocation kozha= new ResourceLocation("minecraft:d33audi/textures/model/leather_grey.png");
    private ResourceLocation text1= new ResourceLocation("minecraft:d33audi/textures/model/text1.png");
    private ResourceLocation reshet= new ResourceLocation("minecraft:d33audi/textures/model/reshet.png");
	public Modelquattro() //Same as Filename
	{	    	
		    steer = kozha; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33audi/textures/model/quattro.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);

	        steerX = -32.5F;
	        steerY = 81F;
	        steerZ = -48F;
	        steerR = -30F;
	        
	        wheelX = 65F;
	        wheelX1 = 62F;
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
		 Minecraft.getMinecraft().renderEngine.bindTexture(body);
		model.renderPart("color_tex4");
		model.renderPart("bump_reacolt");
		model.renderPart("boot_tex");
		model.renderPart("bonnet_tex");
		model.renderPart("door_lf_tex");
		model.renderPart("door_rf_tex");
		model.renderPart("bump_frotex");
		model.renderPart("wing_lf_tex");
		model.renderPart("wing_rf_tex");
		 Minecraft.getMinecraft().renderEngine.bindTexture(body_part);
		model.renderPart("color_part");
		model.renderPart("bump_reacolp");
		model.renderPart("boot_colp");
		model.renderPart("bonnet_part");
		model.renderPart("door_lf_part");
		model.renderPart("door_rf_part");
		model.renderPart("bump_frpart");
		model.renderPart("wing_lf_part");
		model.renderPart("wing_rf_part");
		}
	 @Override
	 public void renderSteer(){
		 GL11.glColor3f(0.6F, 0.6F, 0.65F);
		//Minecraft.getMinecraft().renderEngine.bindTexture(rul);
		model.renderPart("rul");
		//Minecraft.getMinecraft().renderEngine.bindTexture(text1);
		model.renderPart("rul_logo");
		GL11.glColor3f(1F, 1F, 1F);
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
		 Minecraft.getMinecraft().renderEngine.bindTexture(qua5);
		    model.renderPart("sed");
			 Minecraft.getMinecraft().renderEngine.bindTexture(reshet);
			 model.renderPart("reshet");
			 Minecraft.getMinecraft().renderEngine.bindTexture(qua3);
			model.renderPart("panel");
			 Minecraft.getMinecraft().renderEngine.bindTexture(mot);
			model.renderPart("mot");
			model.renderPart("bump_reamot");
			model.renderPart("boot_mot");
			 Minecraft.getMinecraft().renderEngine.bindTexture(qua4);
			model.renderPart("pol4");
			model.renderPart("door_lf_obiv");
			model.renderPart("door_rf_obiv");
			 Minecraft.getMinecraft().renderEngine.bindTexture(qua6);
			model.renderPart("far6");
			model.renderPart("door_lf_zerc");
			model.renderPart("door_rf_zerc");
			 Minecraft.getMinecraft().renderEngine.bindTexture(kozha);
			model.renderPart("zerc");
			 Minecraft.getMinecraft().renderEngine.bindTexture(silnik);
			model.renderPart("motor");
			 Minecraft.getMinecraft().renderEngine.bindTexture(konsola);
			model.renderPart("konsola");
			model.renderPart("bump_fropov");
			model.renderPart("bump_frop");
			 Minecraft.getMinecraft().renderEngine.bindTexture(glasshh);
			model.renderPart("glassh");
			model.renderPart("bump_frotum");
			model.renderPart("wing_lf_far");
			model.renderPart("wing_rf_far");
			 Minecraft.getMinecraft().renderEngine.bindTexture(qua1111);
			model.renderPart("underbody");
			model.renderPart("boot_gr");
			model.renderPart("bump_frobl");
			
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.6F, 0.6F, 0.6F);
			model.renderPart("exhaust");
		    GL11.glColor3f(0.3F, 0.3F, 0.3F);
			model.renderPart("bump_reagr");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("exhaustbl");
			model.renderPart("door_lf_blgr");
			model.renderPart("door_rf_blgr");
			GL11.glColor3f(0.7F, 0.1F, 0.1F);
			model.renderPart("strel");
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