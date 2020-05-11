//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: vaz2101
// Model Creator: 
// Created on: 01.03.2018 - 00:00:58
// Last changed on: 01.03.2018 - 00:00:58

package com.flansmod.client.model.d33gaz; //Path where the model is located

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicleReaSpar;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modelgaz3221 extends SovietModelVehicleReaSpar //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	//private ResourceLocation black_dirt = new ResourceLocation("minecraft:d33vaz/textures/model/black_dirt.png");
	private ResourceLocation fara_zad = new ResourceLocation("minecraft:d33gaz/textures/model/fara_zad.png");
	private ResourceLocation gaz_salon1= new ResourceLocation("minecraft:d33gaz/textures/model/gaz_salon1.png");
	private ResourceLocation gaz_salon2= new ResourceLocation("minecraft:d33gaz/textures/model/gaz_salon2.png");
	private ResourceLocation gaz_tex1= new ResourceLocation("minecraft:d33gaz/textures/model/gaz_tex1.png");
	private ResourceLocation pribors= new ResourceLocation("minecraft:d33gaz/textures/model/pribors.png");
	private ResourceLocation kama301= new ResourceLocation("minecraft:d33gaz/textures/model/wheel_kama301.png");
	//public IModelCustom modeldisk;
	public Modelgaz3221() //Same as Filename
	{	    	
		    steer = gaz_salon1; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33gaz/textures/model/gazel_3221.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);
	        
	       // ResourceLocation disk = new ResourceLocation("minecraft:d33vaz/textures/model/disk/statusdisk_circle.obj");
	       // modeldisk = AdvancedModelLoader.loadModel(disk);
	       // modeldisk = new ModelWrapperDisplayList((WavefrontObject) modeldisk);

	        steerX = -57F;
	        steerY = 145f;
	        steerZ = -206F;
	        steerR = -37F;
	        
	        wheelX = 90F;
	        wheelX1 = 85F;
	        wheelY = 34f;
	        wheelZ = -231F;
	        wheelZ1 = 78F;
	    	//list = GL11.glGenLists(1);
	        //GL11.glNewList(list, GL11.GL_COMPILE);
	   	  	        
	        //GL11.glEndList();
	    	 
	        translateAll(0F, 0F, 0F);
	        
	 		//flipAll();	    
	}
	 @Override
	 public void renderColoredParts(){
		// GL11.glTranslatef(0.0F, -45.0F, 0.0F);	
		model.renderPart("chassis_co");
		model.renderPart("bonnet_ok");
		model.renderPart("lf_color");
		model.renderPart("rf_color");
		//model.renderPart("color");	
		model.renderPart("salon_colo");
		model.renderPart("color_door");
		model.renderPart("door_zadco");
		//model.renderAll();
	 }
	 @Override
	 public void renderWheelsFro(){
		 	//GL11.glScalef(0.2F, 0.2F, 0.2F);
			Minecraft.getMinecraft().renderEngine.bindTexture(kama301);
			model.renderPart("tyre1");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.9F, 0.9F, 0.9F);
		    model.renderPart("wheel_rf");
		    GL11.glColor3f(1F, 1F, 1F);
	 }
	 @Override
	 public void renderWheelsRea(){
			//GL11.glScalef(0.2F, 0.2F, 0.2F);
		 Minecraft.getMinecraft().renderEngine.bindTexture(kama301);
			model.renderPart("tyre2");
			model.renderPart("tyre21");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.9F, 0.9F, 0.9F);
			model.renderPart("wheel_rb");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("wheel_rbb");
			GL11.glColor3f(1F, 1F, 1F);
		 }
	 
	 @Override
	 public void renderSteer(){
		model.renderPart("rul");
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, -10.0F, 0.0F);	
		 //Minecraft.getMinecraft().renderEngine.bindTexture(black_dirt);
			/*model.renderPart("dnishe");
			model.renderPart("black_dirt");*/
			Minecraft.getMinecraft().renderEngine.bindTexture(fara_zad);
			model.renderPart("zad_far");
			Minecraft.getMinecraft().renderEngine.bindTexture(gaz_salon1);
			//model.renderPart("rul");
			model.renderPart("lf_tex");
			//model.renderPart("pol");
			model.renderPart("torpedo_tex");
			model.renderPart("rf_tex");
			Minecraft.getMinecraft().renderEngine.bindTexture(gaz_salon2);
			model.renderPart("pedal");
			model.renderPart("siden1");
			Minecraft.getMinecraft().renderEngine.bindTexture(gaz_tex1);
			model.renderPart("lf_tex2");
			model.renderPart("rf_tex2");
			model.renderPart("chassis_te");
			Minecraft.getMinecraft().renderEngine.bindTexture(pribors);
			model.renderPart("prib");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.7F, 0.7F, 0.7F);
			model.renderPart("rf_chrome");
			model.renderPart("lf_chrome");
			model.renderPart("chrome");
			model.renderPart("chrome1");
			model.renderPart("chrome2");
			model.renderPart("chrome3");
			GL11.glColor3f(0.3F, 0.3F, 0.3F);	
			//model.renderPart("pol");
			model.renderPart("doorz2");
			model.renderPart("grey1");
			model.renderPart("grey9");
			model.renderPart("grey4");
			model.renderPart("gey");
			model.renderPart("grey10");
			model.renderPart("podnog");
			model.renderPart("obiv2");
			model.renderPart("obiv");
			model.renderPart("verx");
			model.renderPart("lf_grey_1");
			model.renderPart("grey");
			model.renderPart("grey5");
			model.renderPart("grey2");
			model.renderPart("rf_grey_1");
			model.renderPart("bump_fro01");
			model.renderPart("motor");
			model.renderPart("obiv1");
			model.renderPart("grey6");
			model.renderPart("grey7");
			model.renderPart("grey8");
			model.renderPart("sed_salon");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("pol");
			model.renderPart("windscre_black");
			model.renderPart("black6");
			model.renderPart("rf_black1");
			model.renderPart("blackdirt1");	
			model.renderPart("blackdirt2_1");
			model.renderPart("black15");
			model.renderPart("black13");
			model.renderPart("blackdirt3");
			model.renderPart("black11");
			model.renderPart("black4");
			model.renderPart("black3");
			model.renderPart("blackdirt_");
			model.renderPart("br");
			model.renderPart("black");
			model.renderPart("lf_black2");
			model.renderPart("black9");
			model.renderPart("grey3");
			model.renderPart("black18");
			model.renderPart("black26");
			model.renderPart("black25");
			model.renderPart("black5");
			model.renderPart("black8");
			model.renderPart("black19");
			model.renderPart("blackdirt");
			model.renderPart("rf_black");
			model.renderPart("blackdirt5");
			model.renderPart("blackdirt4");
			model.renderPart("black20");
			model.renderPart("blackdirt2");
			model.renderPart("lf_black1");
			model.renderPart("black24");
			model.renderPart("lf_black");
			model.renderPart("door_zad");
			model.renderPart("black7");
			model.renderPart("rf_black2");
			model.renderPart("black21");
			model.renderPart("black17");
			model.renderPart("black10");
			model.renderPart("black12");
			model.renderPart("black2");
			model.renderPart("black22");
			model.renderPart("black16");
			model.renderPart("poruk2");
			model.renderPart("poruk");
			model.renderPart("black14");
			model.renderPart("sed_salon_b");
			/*GL11.glColor3f(0.3F, 0.1F, 0.1F);
			model.renderPart("pruzin");*/
			GL11.glColor3f(0.5F, 0.1F, 0.1F);
			model.renderPart("red");
			model.renderPart("red1");
			//model.renderPart("extra3");
			/*GL11.glColor3f(0.1F, 0.1F, 0.5F);
			model.renderPart("blue1");*/
			//GL11.glColor3f(0.9F, 0.9F, 0.9F);
			//model.renderPart("white");
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDepthMask(false);
			GL11.glColor4f(0.7F, 0.7F, 0.7F, 0.6F);
			model.renderPart("stekla_far");
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glDepthMask(true);
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
	 @Override
	 public void frontWheelsStuff(){
		 /*Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			GL11.glTranslatef(-10F, 0, 0);
			model.renderPart("brakedisc_");
			GL11.glTranslatef(10F, 0, 0);
			GL11.glColor3f(1.0F, 1.0F, 1.0F);*/
	 }
}