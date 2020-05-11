//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: vaz2101
// Model Creator: 
// Created on: 01.03.2018 - 00:00:58
// Last changed on: 01.03.2018 - 00:00:58

package com.flansmod.client.model.d33cadillac; //Path where the model is located

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.MQO_ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicle;

import jp.amrex.modelloader.MQO_MetasequoiaObject;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;


public class Modelcadilleldorado extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation carpet = new ResourceLocation("minecraft:d33cadillac/textures/model/carpet.png");
	private ResourceLocation Eldorado = new ResourceLocation("minecraft:d33cadillac/textures/model/Eldorado.png");
	private ResourceLocation Eldorado2 = new ResourceLocation("minecraft:d33cadillac/textures/model/Eldorado2.png");
	private ResourceLocation gm_engine = new ResourceLocation("minecraft:d33cadillac/textures/model/gm_engine.png");
	private ResourceLocation leider2 = new ResourceLocation("minecraft:d33cadillac/textures/model/leider2.png");
	private ResourceLocation material = new ResourceLocation("minecraft:d33cadillac/textures/model/material.png");
	private ResourceLocation underbody = new ResourceLocation("minecraft:d33cadillac/textures/model/underbody.png");
	private ResourceLocation vehlight = new ResourceLocation("minecraft:d33cadillac/textures/model/vehlight.png");
	public Modelcadilleldorado() //Same as Filename
	{	    	
		    steer = Eldorado; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33cadillac/textures/model/cadilleldorado.mqo");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
		    //model = (MQO_MetasequoiaObject) model;
		    model = new MQO_ModelWrapperDisplayList((MQO_MetasequoiaObject) model);
		    maxSpedoAngle = 111F;
	        
	        steerX = -40.808F;
	        steerY = 81.966F;
	        steerZ = -40.126F;
	        steerR = -21.083F;
	        ismqo=true;
	        
	        wheelX = 72F;
	        wheelX1 = 72F;
	        wheelY = 26F;
	        wheelZ = -175F;
	        wheelZ1 = 142F;
	        
	        GL11.glTranslatef(0F, 100F, 0F);
	        
	}
	 @Override
	 public void renderColoredParts(){
		 GL11.glScaled(100, 100, 100);
		 wheelZ1 = 135F;
		 
		    model.renderPart("nump");
			model.renderPart("under_col");
			model.renderPart("verh");
			model.renderPart("krish");
			model.renderPart("col");
			model.renderPart("bonnet_col");
			model.renderPart("bonnet_col1");
			model.renderPart("bump_plate");
			model.renderPart("boot_col");
			model.renderPart("wing_lf_col");
			model.renderPart("wing_rf_col");
			model.renderPart("door_lf_col_2");
			model.renderPart("door_lf_niz");
			model.renderPart("door_lf_col");
			model.renderPart("door_rf_col");
			model.renderPart("door_rf_niz");
			model.renderPart("door_rf_col_2");
	 }
	 @Override
	 public void renderSpedo(){
		 GL11.glPushMatrix();
		 GL11.glScaled(100, 100, 100);
		 	 
		 GL11.glTranslatef(-0.41358F, 0.81497F, -0.66045F);
			 GL11.glRotatef(-8.867F, 1f, 0f, 0f);
			
			 if(vet>0)
			GL11.glRotatef(-vet*maxSpedoAngle, 0f, 0f, 1f);
			 
			 GL11.glRotatef(8.867F, 1f, 0f, 0f);
			 GL11.glTranslatef(0.41358F, -0.81497F, 0.66045F);

			 Minecraft.getMinecraft().renderEngine.bindTexture(color);
				GL11.glColor3f(0.88F, 0.18F, 0.18F);
			model.renderPart("spedo");
			GL11.glColor3f(1F, 1F, 1F);
			GL11.glPopMatrix();
		
	 }
	
	 @Override
	 public void renderSteer(){
		 GL11.glScaled(100, 100, 100);
		 Minecraft.getMinecraft().renderEngine.bindTexture(Eldorado2);
	        model.renderPart("rul_sed");
	        Minecraft.getMinecraft().renderEngine.bindTexture(Eldorado);
	        model.renderPart("rul_main");
	 }
	 
	 @Override
	 public void pre(){
		 GL11.glShadeModel(GL11.GL_SMOOTH);
		 GL11.glTranslatef(0, 9F, 0);
	 }
	 
	 @Override
	 public void renderWheels(){	
		//GL11.glTranslatef(0F, 0.09F, 0F);
		GL11.glScalef(1.2F, 1.2F, 1.1F);
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		 
		 //GL11.glTranslatef(0F, 0.09F, 0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(carpet);
		model.renderPart("carpet");
		model.renderPart("bagins");
		Minecraft.getMinecraft().renderEngine.bindTexture(gm_engine);
		model.renderPart("eng_tex");
			Minecraft.getMinecraft().renderEngine.bindTexture(Eldorado2);
			model.renderPart("sed");
			Minecraft.getMinecraft().renderEngine.bindTexture(Eldorado);
			model.renderPart("main");
			model.renderPart("bonnet_logo");
			model.renderPart("boot_ok");
			model.renderPart("door_lf_ins");
			model.renderPart("wing_rf_pov");
			model.renderPart("wing_lf_pov");
			model.renderPart("door_rf_ins");
			Minecraft.getMinecraft().renderEngine.bindTexture(underbody);
			model.renderPart("dno");
			Minecraft.getMinecraft().renderEngine.bindTexture(vehlight);
			model.renderPart("farz");
			model.renderPart("bump_light");

		
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.88F, 0.18F, 0.18F);
			model.renderPart("red");
			GL11.glColor3f(0.88F, 0.88F, 0.88F);
			model.renderPart("bak");
			GL11.glColor3f(0.48F, 0.48F, 0.28F);
			model.renderPart("mmm");
			GL11.glColor3f(0.28F, 0.28F, 0.18F);
			model.renderPart("brown");
			model.renderPart("bump_br");
			model.renderPart("bump_r_br");
			GL11.glColor3f(0.58F, 0.58F, 0.28F);
			model.renderPart("colp");
			GL11.glColor3f(0.18F, 0.18F, 0.88F);
			model.renderPart("eng_bl");
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			model.renderPart("akkum");
			GL11.glColor3f(0.6F, 0.6F, 0.6F);
			model.renderPart("zercm");
			model.renderPart("chrome");
			model.renderPart("bonnet_cr");
			model.renderPart("bump_cr");
			model.renderPart("boot_cr");
			model.renderPart("bump_r_cr");
			model.renderPart("wing_lf_cr");
			model.renderPart("wing_rf_cr");
			model.renderPart("door_lf_zerc");
			model.renderPart("door_lf_cr");
			model.renderPart("door_rf_zerc");
			model.renderPart("door_rf_cr");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("bl");
			model.renderPart("bump_bl");
			model.renderPart("door_lf_bl");
			model.renderPart("door_rf_bl");
			
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDepthMask(false);
			GL11.glColor4f(1F,1F, 1F, 0.6F);
			Minecraft.getMinecraft().renderEngine.bindTexture(vehlight);
			model.renderPart("wing_lf_light");
			model.renderPart("wing_rf_light");
			GL11.glColor4f(0.9F, 0.9F, 0.95F, 0.6F);
		    model.renderPart("lamp");
		    GL11.glColor4f(0.1F, 0.1F, 0.1F, 0.6F);
			model.renderPart("gl");
			model.renderPart("door_lf_gl");
			model.renderPart("door_rf_gl");
			model.renderPart("windscre01");

			GL11.glDisable(GL11.GL_BLEND);
			
			GL11.glDepthMask(true);
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
	 //@Override
	 
}