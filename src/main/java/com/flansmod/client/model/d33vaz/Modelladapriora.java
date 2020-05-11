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
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modelladapriora extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation black_dirt = new ResourceLocation("minecraft:d33vaz/textures/model/black_dirt.png");
	private ResourceLocation karter = new ResourceLocation("minecraft:d33vaz/textures/model/karter.png");
	private ResourceLocation leather_black = new ResourceLocation("minecraft:d33vaz/textures/model/leather_black.png");
	private ResourceLocation leather_grey= new ResourceLocation("minecraft:d33vaz/textures/model/leather_grey.png");
	private ResourceLocation obivka2= new ResourceLocation("minecraft:d33vaz/textures/model/obivka2.png");
	private ResourceLocation polik= new ResourceLocation("minecraft:d33vaz/textures/model/polik.png");
	private ResourceLocation priora_optik= new ResourceLocation("minecraft:d33vaz/textures/model/priora_optik.png");
	private ResourceLocation priora_prib= new ResourceLocation("minecraft:d33vaz/textures/model/priora_prib.png");
	private ResourceLocation priora_spedo1= new ResourceLocation("minecraft:d33vaz/textures/model/priora_spedo1.png");
	public Modelladapriora() //Same as Filename
	{	    	
		    steer = leather_black; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33vaz/textures/model/lada_priora.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);

	        steerX = -36.5F;
	        steerY = 77F;
	        steerZ = -64.5F;
	        steerR = -25F;
	        
	        wheelX = 58F;
	        wheelX1 = 58F;
	        wheelY = 25F;
	        wheelZ = -142F;
	        wheelZ1 = 100F;
	        
	        maxSpedoAngle = 230F;
	        //mSpeed = 185;
	        //elSpedo = true;
	    	//list = GL11.glGenLists(1);
	        //GL11.glNewList(list, GL11.GL_COMPILE);
	   	  	        
	        //GL11.glEndList();
	    	 
	        translateAll(0F, 0F, 0F);
	        
	 		//flipAll();	    
	}
	 @Override
	 public void renderColoredParts(){
		// GL11.glTranslatef(0.0F, -45.0F, 0.0F);	
		model.renderPart("fulls");
		model.renderPart("fullsize_f");
		model.renderPart("fulls1");
		model.renderPart("bumper_F");
		model.renderPart("door_RR");
		model.renderPart("bumper_R");
		model.renderPart("door_FL");
		model.renderPart("fullsize_b");
		model.renderPart("door_FR");
		model.renderPart("fullsize_h");
		model.renderPart("door_RL");
	 }
	 @Override
	 public void renderWheels(){
		GL11.glScalef(0.96F, 0.96F, 0.96F);
		/*Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		d33wheel.renderPart("status_tyre");
		Minecraft.getMinecraft().renderEngine.bindTexture(statusdisk);
		d33wheel.renderPart("status_disk");*/
	 }
	 
	 @Override
	 public void renderSpedo(){
		 /*GL11.glPushMatrix();
			FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
			GL11.glTranslatef(-36F, 84.3F, -85.2F);
			GL11.glRotatef(-11F, 1f, 0f, 0f);
	        GL11.glScalef(0.2F, -0.2F, 1.0F);
	        GL11.glDepthMask(true);
	                fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, 10, 0xFFFFFF);
	                
	        //GL11.glDepthMask(false);
	        //GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        GL11.glPopMatrix();*/
		 
		 Minecraft.getMinecraft().renderEngine.bindTexture(priora_spedo1);
		 GL11.glTranslatef(-28F, 81.4F, -83.3F);
		 GL11.glRotatef(-14F, 1f, 0f, 0f);
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, -10.0F, 0.0F);	
		 Minecraft.getMinecraft().renderEngine.bindTexture(black_dirt);
			model.renderPart("dno");
			model.renderPart("bak");
			model.renderPart("zad_podves");
			model.renderPart("podves_per");
			model.renderPart("swaybar");
			model.renderPart("fullsize_u");
			Minecraft.getMinecraft().renderEngine.bindTexture(karter);
			model.renderPart("zashita");
			model.renderPart("pedal");
			Minecraft.getMinecraft().renderEngine.bindTexture(priora_prib);
			model.renderPart("prib");
			Minecraft.getMinecraft().renderEngine.bindTexture(leather_black);
			model.renderPart("FL_lea01");
			model.renderPart("leather01");
			model.renderPart("RL_leat1");
			model.renderPart("seats_R");
			model.renderPart("FR_leat1");
			model.renderPart("front_seat");
			model.renderPart("RR_leat1");
			Minecraft.getMinecraft().renderEngine.bindTexture(priora_spedo1);
			model.renderPart("pribors");
			Minecraft.getMinecraft().renderEngine.bindTexture(leather_grey);
			model.renderPart("RL_leat");
			model.renderPart("RR_leat");
			model.renderPart("FR_leat");
			model.renderPart("leat");
			model.renderPart("FL_lea");
			model.renderPart("kozir");
			Minecraft.getMinecraft().renderEngine.bindTexture(obivka2);
			model.renderPart("RR_obivk");
			model.renderPart("FL_obiv");
			model.renderPart("RL_obivk");
			model.renderPart("obivka");
			//model.renderPart("kozir");
			model.renderPart("FR_obiv");
			Minecraft.getMinecraft().renderEngine.bindTexture(polik);
			model.renderPart("pol");
			Minecraft.getMinecraft().renderEngine.bindTexture(priora_optik);
			model.renderPart("lf_texture");
			model.renderPart("fullsize_t");
			model.renderPart("optic_rea");
			model.renderPart("rf_texture");
			//model.renderPart("light_bump");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.5F, 0.5F, 0.5F);
			model.renderPart("lf_otr");
			model.renderPart("chrome_tru");
			model.renderPart("glass_pla");
			model.renderPart("chrome_bum");
			model.renderPart("rf_otr");
			model.renderPart("chrome_hoo");
			model.renderPart("chrome_FR");
			model.renderPart("chrome");
			model.renderPart("glush");
			model.renderPart("chrome_FL");
			model.renderPart("chrom");
			model.renderPart("light_bump");
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			model.renderPart("grey_pla");
			model.renderPart("needle_tac");
			model.renderPart("grey_");
			model.renderPart("baraban");
			//model.renderPart("brakedisc_");
			model.renderPart("zerkal");
			model.renderPart("black_chro");
			model.renderPart("needle_spe");
			//model.renderPart("brake");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("black_RR");
			model.renderPart("black_bump");
			model.renderPart("black_torp");
			model.renderPart("black_FL");
			model.renderPart("black_seat");
			//model.renderPart("antena");
			model.renderPart("dvornik");
			model.renderPart("black_hood");
			model.renderPart("black_RL");
			model.renderPart("black_trun");
			model.renderPart("black_FR");
			model.renderPart("rf_black");
			model.renderPart("lf_black");
			model.renderPart("black_tail");
			model.renderPart("black_body");
			// model.renderPart("leather01");
			GL11.glColor3f(0.3F, 0.1F, 0.1F);
			model.renderPart("pruzin");
			GL11.glColor3f(0.8F, 0.9F, 0.8F);
			model.renderPart("torpeda_li");
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDepthMask(false);
			GL11.glColor4f(0.7F, 0.7F, 0.7F, 0.6F);
			model.renderPart("fl_glass");
			model.renderPart("fr_glass");
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glDepthMask(true);
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
	 @Override
	 public void frontWheelsStuff(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			GL11.glTranslatef(-10F, 0, 0);
			model.renderPart("brakedisc_");
			GL11.glTranslatef(10F, 0, 0);
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
	 
	/* @Override
	 public void renderSteer(){
		//GL11.glColor3f(0.1F, 0.1F, 0.1F);
		model.renderPart("steer");
		//GL11.glColor3f(1F, 1F, 1F);
	 }*/
}