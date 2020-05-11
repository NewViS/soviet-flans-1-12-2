//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: vaz2101
// Model Creator: 
// Created on: 01.03.2018 - 00:00:58
// Last changed on: 01.03.2018 - 00:00:58

package com.flansmod.client.model.d33zil; //Path where the model is located

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicleReaSpar;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modelzil130 extends SovietModelVehicleReaSpar //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	//private ResourceLocation black_dirt = new ResourceLocation("minecraft:d33vaz/textures/model/black_dirt.png");
	private ResourceLocation fara = new ResourceLocation("minecraft:d33zil/textures/model/fara.png");
	private ResourceLocation katex8= new ResourceLocation("minecraft:d33zil/textures/model/katex8.png");
	private ResourceLocation zildisk= new ResourceLocation("minecraft:d33zil/textures/model/zildisk.png");
	private ResourceLocation pol= new ResourceLocation("minecraft:d33zil/textures/model/pol.png");
	private ResourceLocation pribors= new ResourceLocation("minecraft:d33zil/textures/model/pribors.png");
	private ResourceLocation radiator= new ResourceLocation("minecraft:d33zil/textures/model/radiator.png");
	private ResourceLocation vehiclegeneric256= new ResourceLocation("minecraft:d33zil/textures/model/vehiclegeneric256.png");
	private ResourceLocation vehiclelights128= new ResourceLocation("minecraft:d33zil/textures/model/vehiclelights128.png");
	private ResourceLocation zil130a00c= new ResourceLocation("minecraft:d33zil/textures/model/zil130a00c.png");
	private ResourceLocation zil130a00e= new ResourceLocation("minecraft:d33zil/textures/model/zil130a00e.png");
	private ResourceLocation zil130a004= new ResourceLocation("minecraft:d33zil/textures/model/zil130a004.png");
	private ResourceLocation zil130a006= new ResourceLocation("minecraft:d33zil/textures/model/zil130a006.png");
	private ResourceLocation zil130a008= new ResourceLocation("minecraft:d33zil/textures/model/zil130a008.png");
	private ResourceLocation zil130as00e= new ResourceLocation("minecraft:d33zil/textures/model/zil130as00e.png");
	private ResourceLocation zil130as01c= new ResourceLocation("minecraft:d33zil/textures/model/zil130as01c.png");
	private ResourceLocation zil130as01e= new ResourceLocation("minecraft:d33zil/textures/model/zil130as01e.png");
	private ResourceLocation zil130as002= new ResourceLocation("minecraft:d33zil/textures/model/zil130as002.png");
	private ResourceLocation zil130as018= new ResourceLocation("minecraft:d33zil/textures/model/zil130as018.png");
	private ResourceLocation zil130as022= new ResourceLocation("minecraft:d33zil/textures/model/zil130as022.png");
	private ResourceLocation zil130b02c= new ResourceLocation("minecraft:d33zil/textures/model/zil130b02c.png");
	private ResourceLocation zil131a01a= new ResourceLocation("minecraft:d33zil/textures/model/zil131a01a.png");
	private ResourceLocation zil130a00a= new ResourceLocation("minecraft:d33zil/textures/model/zil130a00a.png");
	private ResourceLocation ziltyre= new ResourceLocation("minecraft:d33zil/textures/model/ziltyre1.png");
	private ResourceLocation leather_black= new ResourceLocation("minecraft:d33zil/textures/model/leather_black.png");
	private ResourceLocation obivka2= new ResourceLocation("minecraft:d33zil/textures/model/obivka2.png");
	private ResourceLocation zadnyaya= new ResourceLocation("minecraft:d33zil/textures/model/zadnyaya.png");
	//public IModelCustom modeldisk;
	public Modelzil130() //Same as Filename
	{	    	
		    steer = zil130as002; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33zil/textures/model/zil130.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);
	        
	       // ResourceLocation disk = new ResourceLocation("minecraft:d33vaz/textures/model/disk/statusdisk_circle.obj");
	       // modeldisk = AdvancedModelLoader.loadModel(disk);
	       // modeldisk = new ModelWrapperDisplayList((WavefrontObject) modeldisk);

	        steerX = -59F;
	        steerY = 168f;
	        steerZ = -175F;
	        steerR = -37F;
	        
	        wheelX = 125F;
	        wheelX1 = 112F;
	        wheelY = 54f;
	        wheelZ = -274F;
	        wheelZ1 = 165F;
	        
			maxSpedoAngle = 160F;
	    	isKuzov = true;
	    	//list = GL11.glGenLists(1);
	        //GL11.glNewList(list, GL11.GL_COMPILE);
	   	  	        
	        //GL11.glEndList();
	    	 
	        translateAll(0F, 0F, 0F);
	        
	 		//flipAll();	    
	}
	 @Override
	 public void renderColoredParts(){
		 
		// GL11.glTranslatef(0.0F, -45.0F, 0.0F);	
		model.renderPart("door_rf_col");
		model.renderPart("bonnet_logo");
		model.renderPart("door_lf_col");
		model.renderPart("col");
	 }
	 
	 @Override
	 public void renderSpedo(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(pribors);
		 GL11.glTranslatef(-76F, 165.4F, -204.3F);
		 GL11.glRotatef(-5F, 1f, 0f, 0f);
		 GL11.glRotatef(-22F, 0f, 0f, 1f);
	 }
	 @Override
	 public void renderWheelsFro(){
		 	//GL11.glScalef(0.2F, 0.2F, 0.2F);
		    Minecraft.getMinecraft().renderEngine.bindTexture(ziltyre);
			model.renderPart("tyre21");
			Minecraft.getMinecraft().renderEngine.bindTexture(zildisk);
			model.renderPart("wheel_rf");
	 }
	 @Override
	 public void renderWheelsRea(){
			//GL11.glScalef(0.2F, 0.2F, 0.2F);
		 Minecraft.getMinecraft().renderEngine.bindTexture(ziltyre);
			model.renderPart("tyre211");
			Minecraft.getMinecraft().renderEngine.bindTexture(zildisk);
			model.renderPart("wheel_rb");
		 }
	 
	 @Override
	 public void renderSteer(){
		model.renderPart("rul");
	 }
	 
	 @Override
	 public void renderKuzov(){
		GL11.glScalef(1.09F, 1.09F, 1.09F);
		GL11.glTranslatef(0, 145F, -70F);
	 }
	 
	 @Override
	 public void renderTexturedParts(){ 
		 Minecraft.getMinecraft().renderEngine.bindTexture(zildisk);
		    model.renderPart("disk");
		    Minecraft.getMinecraft().renderEngine.bindTexture(zadnyaya);
		    model.renderPart("steklofar");
			Minecraft.getMinecraft().renderEngine.bindTexture(pribors);
			model.renderPart("prib");
			Minecraft.getMinecraft().renderEngine.bindTexture(obivka2);
			model.renderPart("obiv");
			Minecraft.getMinecraft().renderEngine.bindTexture(leather_black);
			model.renderPart("sed");
			Minecraft.getMinecraft().renderEngine.bindTexture(ziltyre);
			model.renderPart("tyre213");
			Minecraft.getMinecraft().renderEngine.bindTexture(fara);
			model.renderPart("fari");
			Minecraft.getMinecraft().renderEngine.bindTexture(pol);
			model.renderPart("pol");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130b02c);
			model.renderPart("gluh_tex");
			model.renderPart("baki");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130as022);
			model.renderPart("zamok");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130a00e);
			model.renderPart("rama15");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130a00a);
			model.renderPart("rama17");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130a00c);
			model.renderPart("rama16");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil131a01a);
			model.renderPart("dvorn");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130as018);
			model.renderPart("rama14");
			model.renderPart("zerc");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130a008);
			model.renderPart("rama110");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130a004);
			model.renderPart("rama19");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130a006);
			model.renderPart("rama1");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130as01c);
			model.renderPart("pedal");
			model.renderPart("kpp_panel");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130as00e);
			model.renderPart("knop");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130as01e);
			model.renderPart("panel");
			Minecraft.getMinecraft().renderEngine.bindTexture(vehiclelights128);
			model.renderPart("pov");
			model.renderPart("pov1");
			model.renderPart("ka_lamp");
			Minecraft.getMinecraft().renderEngine.bindTexture(radiator);
			model.renderPart("radiator");
			Minecraft.getMinecraft().renderEngine.bindTexture(katex8);
			model.renderPart("kpp");
			model.renderPart("kpp_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(vehiclegeneric256);
			model.renderPart("generic");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.6F, 0.6F, 0.6F);
			model.renderPart("ruk");
			model.renderPart("door_lf_rins");
			model.renderPart("bonnet_col");
			model.renderPart("ka_cr");
			model.renderPart("door_rf_cr");
			model.renderPart("door_lf_ruk");
			model.renderPart("door_rf_ruk");
			model.renderPart("door_lf_cr");
			model.renderPart("door_rf_rins");
			model.renderPart("faricr");
			
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("door_rf_bolt");
			model.renderPart("door_lf_bolt");
			model.renderPart("door_lf_bl");
			model.renderPart("brizg");
			model.renderPart("bump_front");
			model.renderPart("bl");
			model.renderPart("ka_bl");
			model.renderPart("bort");
			model.renderPart("bump_front_kl");
			model.renderPart("door_rf_bl");
			model.renderPart("farbl");
			model.renderPart("kabina_bl");
			model.renderPart("faribl");
			model.renderPart("ka_uplot");
			model.renderPart("dno");
			model.renderPart("podnog");
			model.renderPart("ramab");
			
			//GL11.glScalef(1.07F, 1F, 1F);
			model.renderPart("brizg_1");
			model.renderPart("brizg_2");
			//GL11.glScalef(1/1.07F, 1F, 1F);
			
			GL11.glColor3f(0.9F, 0.9F, 0.9F);
			model.renderPart("mord");
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