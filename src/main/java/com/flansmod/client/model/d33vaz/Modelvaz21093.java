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

public class Modelvaz21093 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation black_dirt = new ResourceLocation("minecraft:d33vaz/textures/model/black_dirt.png");
	private ResourceLocation far = new ResourceLocation("minecraft:d33vaz/textures/model/far.png");
	private ResourceLocation leather_black = new ResourceLocation("minecraft:d33vaz/textures/model/leather_black.png");
	private ResourceLocation leather_grey = new ResourceLocation("minecraft:d33vaz/textures/model/leather_grey.png");
	private ResourceLocation karter= new ResourceLocation("minecraft:d33vaz/textures/model/karter.png");
	private ResourceLocation obivka= new ResourceLocation("minecraft:d33vaz/textures/model/obivka.png");
    private ResourceLocation obivka2= new ResourceLocation("minecraft:d33vaz/textures/model/obivka2.png");
	private ResourceLocation knopki= new ResourceLocation("minecraft:d33vaz/textures/model/knopki.png");
	private ResourceLocation kpp21093= new ResourceLocation("minecraft:d33vaz/textures/model/kpp21093.png");
	private ResourceLocation mafon= new ResourceLocation("minecraft:d33vaz/textures/model/mafon.png");
	private ResourceLocation panel_texture= new ResourceLocation("minecraft:d33vaz/textures/model/panel_texture.png");
	private ResourceLocation osfar_zad= new ResourceLocation("minecraft:d33vaz/textures/model/osfar_zad.png");
	//public IModelCustom modeldisk;
	public Modelvaz21093() //Same as Filename
	{	    	
		    steer = color; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33vaz/textures/model/vaz21093.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);
	        
	       // ResourceLocation disk = new ResourceLocation("minecraft:d33vaz/textures/model/disk/statusdisk_circle.obj");
	       // modeldisk = AdvancedModelLoader.loadModel(disk);
	       // modeldisk = new ModelWrapperDisplayList((WavefrontObject) modeldisk);

	        steerX = -33F;
	        steerY = 77F;
	        steerZ = -57.5F;
	        steerR = -20F;
	        
	        wheelX = 58F;
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
		// GL11.glTranslatef(0.0F, -45.0F, 0.0F);	
		model.renderPart("color_lf");
		model.renderPart("color_lr");
		model.renderPart("color_rr");
		model.renderPart("bonnet_o01_1");
		//model.renderPart("color");	
		model.renderPart("color1");
		model.renderPart("kapot2");
		model.renderPart("color_rf");
		//model.renderAll();
	 }
	 @Override
	 public void renderWheels(){
		GL11.glScalef(0.96F, 0.96F, 0.96F);
		/*Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		d33wheel.renderPart("status_tyre");*/
		//Minecraft.getMinecraft().renderEngine.bindTexture(status_disk);
		GL11.glColor3f(0.9F, 0.9F, 0.9F);
		//modeldisk.renderAll();
		//GL11.glColor3f(1F, 1F, 1F);
	 }
	 
	 @Override
	 public void renderSteer(){
		GL11.glColor3f(0.1F, 0.1F, 0.1F);
		model.renderPart("steer");
		GL11.glColor3f(0.5F, 0.5F, 0.5F);
		model.renderPart("steer_chrome");
		GL11.glColor3f(1F, 1F, 1F);
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, -10.0F, 0.0F);	
		 Minecraft.getMinecraft().renderEngine.bindTexture(black_dirt);
			model.renderPart("dnishe");
			model.renderPart("black_dirt");
			Minecraft.getMinecraft().renderEngine.bindTexture(far);
			model.renderPart("fara_slekl");
			Minecraft.getMinecraft().renderEngine.bindTexture(leather_black);
			/*model.renderPart("lea_lf");
			model.renderPart("obiv");
			model.renderPart("lea_rf");
			model.renderPart("lea_lr");
			model.renderPart("lea_rr");
			model.renderPart("torpedo_lea");
			model.renderPart("seats_zad1");
			model.renderPart("seats_zad");*/
			Minecraft.getMinecraft().renderEngine.bindTexture(leather_grey);
			//model.renderPart("torpeda_tex");
			Minecraft.getMinecraft().renderEngine.bindTexture(karter);
			model.renderPart("zashita");
			Minecraft.getMinecraft().renderEngine.bindTexture(obivka);
			//model.renderPart("panel_lea");
			Minecraft.getMinecraft().renderEngine.bindTexture(obivka2);
			GL11.glColor3f(0.7F, 0.7F, 0.7F);
			model.renderPart("obiv_rf");
			model.renderPart("seats_fron");
			model.renderPart("polka_zad");
			model.renderPart("seats_fron1");
			model.renderPart("obiv_rr");
			model.renderPart("obiv_lr");
			model.renderPart("obiv_lf");
			model.renderPart("obiv1");
			GL11.glColor3f(1F, 1F, 1F);
			Minecraft.getMinecraft().renderEngine.bindTexture(knopki);
			model.renderPart("knopki");
			Minecraft.getMinecraft().renderEngine.bindTexture(kpp21093);
			model.renderPart("kpp");
			Minecraft.getMinecraft().renderEngine.bindTexture(mafon);
			model.renderPart("pov");			
			model.renderPart("mafon");
			Minecraft.getMinecraft().renderEngine.bindTexture(panel_texture);
			model.renderPart("prib");
			Minecraft.getMinecraft().renderEngine.bindTexture(osfar_zad);
			model.renderPart("far_z");
			model.renderPart("svet");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.7F, 0.7F, 0.7F);
			model.renderPart("chrome1");
			model.renderPart("chrome3");
			model.renderPart("reshetka_logo");
			model.renderPart("chrome_lf_1");
			model.renderPart("chrome_rf_1");
			//model.renderPart("chrome");
			model.renderPart("boot_ok1");
			model.renderPart("boot_dam");
			model.renderPart("chrome2");
			GL11.glColor3f(0.3F, 0.3F, 0.3F);		
			model.renderPart("grey3");
			model.renderPart("grey_lf");
			model.renderPart("grey_rf");
			model.renderPart("grey_rr");
			model.renderPart("grey2");
			model.renderPart("grey1_1");
			model.renderPart("grey_lr");
			model.renderPart("Pedali");
			model.renderPart("grey");
			model.renderPart("grey_1");
			GL11.glScalef(0.9F, 1F, 1F);
			model.renderPart("baraban");
			GL11.glScalef(1/0.9F, 1F, 1F);
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("black4");
			model.renderPart("black9");
			model.renderPart("black_rr_1");
			model.renderPart("kovriki");
			model.renderPart("black_rf_1");
			model.renderPart("black8");
			model.renderPart("liniya");
			model.renderPart("liniya2");
			model.renderPart("black5");
			model.renderPart("bonnet_ok1");
			model.renderPart("black6");
			model.renderPart("black_lr_1");
			model.renderPart("black10");
			model.renderPart("black2");
			model.renderPart("black1_1");
			model.renderPart("black7");
			model.renderPart("black");
			model.renderPart("black_lf_1");
			model.renderPart("bump_rea01");
			model.renderPart("bump_fro01");
			model.renderPart("black3");
			model.renderPart("reshetka");
			model.renderPart("dvorniki");
			model.renderPart("black_1");
			model.renderPart("lea_lf");
			model.renderPart("obiv");
			model.renderPart("lea_rf");
			model.renderPart("lea_lr");
			model.renderPart("lea_rr");
			model.renderPart("torpedo_lea");
			model.renderPart("seats_zad1");
			model.renderPart("seats_zad");
			model.renderPart("boot_ok");
			model.renderPart("boot_dam1");
			GL11.glColor3f(0.3F, 0.1F, 0.1F);
			model.renderPart("pruzin");
			GL11.glColor3f(0.5F, 0.1F, 0.1F);
			model.renderPart("strel");
			model.renderPart("red");
			GL11.glColor3f(0.1F, 0.1F, 0.5F);
			model.renderPart("blue1");
			//GL11.glColor3f(0.9F, 0.9F, 0.9F);
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