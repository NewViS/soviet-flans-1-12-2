//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: vaz2101
// Model Creator: 
// Created on: 01.03.2018 - 00:00:58
// Last changed on: 01.03.2018 - 00:00:58

package com.flansmod.client.model.d33bmw; //Path where the model is located

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicle;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modelbmwm5f90 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation bmw_m5_badges = new ResourceLocation("minecraft:d33bmw/textures/model/bmw_m5_badges.png");
	private ResourceLocation bmw_m5_cab = new ResourceLocation("minecraft:d33bmw/textures/model/bmw_m5_cab.png");
	private ResourceLocation bmw_m5_ext_alpine_white = new ResourceLocation("minecraft:d33bmw/textures/model/bmw_m5_ext_alpine_white.png");
	private ResourceLocation bmw_m5_lights = new ResourceLocation("minecraft:d33bmw/textures/model/bmw_m5_lights.png");
	private ResourceLocation car_chassis = new ResourceLocation("minecraft:d33bmw/textures/model/car_chassis.png");
	private ResourceLocation spedom5 = new ResourceLocation("minecraft:d33bmw/textures/model/spedom5.png");
	public Modelbmwm5f90() //Same as Filename
	{	    	
		    steer = bmw_m5_cab; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33bmw/textures/model/bmwm5f90.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);
	        ismqo=true;
	        
	        steerX = -39.392F;
	        steerY = 89.545F;
	        steerZ = -41.863F;
	        steerR = -20.916F;
	        
	        wheelX = 67F;
	        wheelX1 = 67F;
	        wheelY = 29F;
	        wheelZ = -160F;
	        wheelZ1 = 136F;
	        
	        maxSpedoAngle = 230F;
	        //mSpeed = 210;
	        //elSpedo = true;
	    	//list = GL11.glGenLists(1);
	        //GL11.glNewList(list, GL11.GL_COMPILE);
	   	  	        
	        //GL11.glEndList();
	    	 
	        translateAll(0F, 0F, 0F);
	        
	 		//flipAll();	    
	}
	 @Override
	 public void renderColoredParts(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(bmw_m5_ext_alpine_white);
		 	model.renderPart("doorlf_zercc");
		 	model.renderPart("doorlf_col");
			model.renderPart("body");
			model.renderPart("bumpr");
			model.renderPart("bag");
			model.renderPart("uncap");
			model.renderPart("bumpf");
			model.renderPart("doorrf_col");
			model.renderPart("doorrf_zercc");
			model.renderPart("cap");
	 }
	 @Override
	 public void renderWheels(){
		 GL11.glScaled(1.15, 1.15, 1.4);
	 }
	 
	 @Override
	 public void pre(){
		 //GL11.glTranslatef(0.0F, 0.0F, 0.0F);	
		 //GL11.glShadeModel(GL11.GL_SMOOTH);
	 }
	 
	 @Override
	 public void renderSpedo(){
		 GL11.glPushMatrix();
		 	 
		 GL11.glTranslatef(-45.803F, 91.467F, -67.636F);
			 GL11.glRotatef(-19.553F, 1f, 0f, 0f);
			
			 if(vet>0)
			GL11.glRotatef(-vet*maxSpedoAngle, 0f, 0f, 1f);
			 
			 GL11.glRotatef(19.553F, 1f, 0f, 0f);
			 GL11.glTranslatef(45.803F, -91.467F, 67.636F);

			 Minecraft.getMinecraft().renderEngine.bindTexture(spedom5);
			model.renderPart("spedo");
			GL11.glColor3f(1F, 1F, 1F);
			GL11.glPopMatrix();
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, 1.0F, 0.0F);	
		 Minecraft.getMinecraft().renderEngine.bindTexture(bmw_m5_badges);
		 	model.renderPart("bumplog");
			model.renderPart("logoc");
			model.renderPart("reshet");
			model.renderPart("m5");
			model.renderPart("logob");
			Minecraft.getMinecraft().renderEngine.bindTexture(bmw_m5_cab);
			model.renderPart("int");
			model.renderPart("doorlf_bl");
			model.renderPart("doorlr_bl");
			model.renderPart("bl");
			model.renderPart("doorlf_zercb");
			model.renderPart("bagins");
			model.renderPart("doorrf_zercb");
			model.renderPart("doorrf_bl");
			model.renderPart("reshrad");
			model.renderPart("reaglb");
			model.renderPart("doorrr_bl");
			model.renderPart("plast");
			model.renderPart("doorlf_int");
			Minecraft.getMinecraft().renderEngine.bindTexture(bmw_m5_ext_alpine_white);
			model.renderPart("bumprp");
			model.renderPart("gluh");
			Minecraft.getMinecraft().renderEngine.bindTexture(bmw_m5_lights);
			model.renderPart("stop");
			model.renderPart("farz");
			model.renderPart("katafr");
			model.renderPart("kataf");
			model.renderPart("farb");
			model.renderPart("doorrf_pov");
			model.renderPart("farpr");
			model.renderPart("bumprl");
			model.renderPart("doorlf_pov");
			model.renderPart("far");
			model.renderPart("farpl");
			Minecraft.getMinecraft().renderEngine.bindTexture(car_chassis);
			model.renderPart("dno");
			model.renderPart("black");
			model.renderPart("windscreb");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3d(0.7, 0.7, 0.75);
			model.renderPart("doorrf_zerc");
			model.renderPart("doorlf_zerc");
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDepthMask(false);
			GL11.glColor4f(0.1F, 0.1F, 0.1F, 0.6F);
			model.renderPart("doorlf_gl");
			model.renderPart("doorrr_gl");
			model.renderPart("doorlr_gl");
			model.renderPart("reagl");
			model.renderPart("windscre");
			model.renderPart("doorrf_gl");
			GL11.glColor4f(0.6F, 0.6F, 0.65F, 0.6F);
			model.renderPart("farprgl");
			model.renderPart("farpgll");
			GL11.glColor4f(0.6F, 0.05F, 0.05F, 0.6F);
			model.renderPart("gl_bag");
			model.renderPart("fongll");
			model.renderPart("fonglr");
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glDepthMask(true);
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
         
	 }
	 /*@Override
	 public void frontWheelsStuff(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			GL11.glTranslatef(-10F, 0, 0);
			model.renderPart("brakedisc_");
			GL11.glTranslatef(10F, 0, 0);
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
	 */
	 @Override
	 public void renderSteer(){
		model.renderPart("steer");
	 }
}