//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: vaz2101
// Model Creator: 
// Created on: 01.03.2018 - 00:00:58
// Last changed on: 01.03.2018 - 00:00:58

package com.flansmod.client.model.d33chevrolet; //Path where the model is located

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicle;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modelcamaro89 extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation camaro_by_azrael = new ResourceLocation("minecraft:d33chevrolet/textures/model/camaro_by_azrael.png");
	private ResourceLocation camaro_exterior = new ResourceLocation("minecraft:d33chevrolet/textures/model/camaro_exterior.png");
	private ResourceLocation denx_kovrolin = new ResourceLocation("minecraft:d33chevrolet/textures/model/denx_kovrolin.png");
	private ResourceLocation denx_tkan = new ResourceLocation("minecraft:d33chevrolet/textures/model/denx_tkan.png");
	private ResourceLocation gm_engine = new ResourceLocation("minecraft:d33chevrolet/textures/model/gm_engine.png");
	private ResourceLocation pumbars_torzer = new ResourceLocation("minecraft:d33chevrolet/textures/model/pumbars_torzer.png");
	private ResourceLocation radiator = new ResourceLocation("minecraft:d33chevrolet/textures/model/radiator.png");
	private ResourceLocation w220_leather1 = new ResourceLocation("minecraft:d33chevrolet/textures/model/w220_leather1.png");
	private ResourceLocation vehiclelights = new ResourceLocation("minecraft:d33chevrolet/textures/model/vehiclelights.png");
	public Modelcamaro89() //Same as Filename
	{	    	
		    steer = w220_leather1; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33chevrolet/textures/model/camaro89.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);
	        ismqo=true;
	        
	        steerX = -39.911F;
	        steerY = 69.475F;
	        steerZ = -24.119F;
	        steerR = -6.911F;
	        
	        wheelX = 62F;
	        wheelX1 = 62F;
	        wheelY = 29F;
	        wheelZ = -142F;
	        wheelZ1 = 123F;
	        
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
		 wheelX = 68F;
	        wheelX1 = 68F;
	        wheelY = 29F;
	        wheelZ = -138F;
	        wheelZ1 = 123F;
		 	model.renderPart("bonnet_col");
			model.renderPart("door_lf_col");
			model.renderPart("door_rf_col");
			model.renderPart("wing_rf_col");
			model.renderPart("wing_lf_col");
			model.renderPart("wing_rf_1");
			model.renderPart("boot_col");
			model.renderPart("bump_reacol");
			model.renderPart("bump_frocol");
			model.renderPart("col");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
	 }
	 @Override
	 public void renderWheels(){
		 GL11.glScaled(1.1, 1.1, 1.3);
	 }
	 
	 @Override
	 public void pre(){
		 //GL11.glTranslatef(0.0F, 0.0F, 0.0F);	
		 //GL11.glShadeModel(GL11.GL_SMOOTH);
	 }
	 
	 @Override
	 public void renderSpedo(){
		 GL11.glPushMatrix();
		 	 
		 GL11.glTranslatef(46.857F, 82.257F, -63.852F);
			 GL11.glRotatef(-10F, 1f, 0f, 0f);
			
			 if(vet>0)
			GL11.glRotatef(-vet*maxSpedoAngle, 0f, 0f, 1f);
			 
			 GL11.glRotatef(10F, 1f, 0f, 0f);
			 GL11.glTranslatef(-46.857F, -82.257F, 63.852F);

			 Minecraft.getMinecraft().renderEngine.bindTexture(vehiclelights);
			model.renderPart("spedo");
			GL11.glColor3f(1F, 1F, 1F);
			GL11.glPopMatrix();
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, 1.0F, 0.0F);	
		 Minecraft.getMinecraft().renderEngine.bindTexture(camaro_by_azrael);
		 	model.renderPart("door_lf_in");
		 	model.renderPart("door_rf_in");
			model.renderPart("colins");
			model.renderPart("");
			model.renderPart("");
		 	model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			Minecraft.getMinecraft().renderEngine.bindTexture(camaro_exterior);
			model.renderPart("door_lf_zerc");
		 	model.renderPart("door_rf_zerc");
			model.renderPart("zerc");
			model.renderPart("wing_rf_ext");
			model.renderPart("wing_lf_ext");
		 	model.renderPart("bump_froext");
			model.renderPart("ext");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			Minecraft.getMinecraft().renderEngine.bindTexture(denx_kovrolin);
			model.renderPart("pol");
			Minecraft.getMinecraft().renderEngine.bindTexture(denx_tkan);
			model.renderPart("boot_in");
		 	model.renderPart("carpet");
			model.renderPart("sedup");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			Minecraft.getMinecraft().renderEngine.bindTexture(gm_engine);
			model.renderPart("motor");
		 	model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			Minecraft.getMinecraft().renderEngine.bindTexture(pumbars_torzer);
			model.renderPart("pumbas");
			Minecraft.getMinecraft().renderEngine.bindTexture(radiator);
			model.renderPart("rad");
			Minecraft.getMinecraft().renderEngine.bindTexture(w220_leather1);
			model.renderPart("sedown");
			model.renderPart("int");
			Minecraft.getMinecraft().renderEngine.bindTexture(vehiclelights);
			model.renderPart("vehlight");
			model.renderPart("");
		 	model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3d(0.9, 0.9, 0.9);
			model.renderPart("bak");
			model.renderPart("detal");
			GL11.glColor3d(0.1, 0.1, 0.1);
			model.renderPart("bonnet_bl");
			model.renderPart("door_lf_ruk");
			model.renderPart("door_rf_rul");
		 	model.renderPart("zercin");
			model.renderPart("bl");
			model.renderPart("wing_lf_bl");
			model.renderPart("wing_rf_bl");
			model.renderPart("boot_bl");
			model.renderPart("bump_reabl");
			model.renderPart("bump_frobl");
			model.renderPart("bump_frobl1");
			model.renderPart("luk");
			model.renderPart("wipers");
			model.renderPart("bl");
			model.renderPart("blm");
			model.renderPart("bl1");
			model.renderPart("");
			model.renderPart("");
			model.renderPart("");
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDepthMask(false);
			GL11.glColor4f(0.1F, 0.1F, 0.1F, 0.6F);
			model.renderPart("door_lf_gl");
		 	model.renderPart("door_rf_gl");
			model.renderPart("windscre");
			model.renderPart("boot_gl");
			model.renderPart("");
			model.renderPart("");
			GL11.glColor4f(0.6F, 0.6F, 0.65F, 0.6F);
			model.renderPart("");
			model.renderPart("");
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glDepthMask(true);
         
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
			Minecraft.getMinecraft().renderEngine.bindTexture(camaro_exterior);
		model.renderPart("steer_ext");
		Minecraft.getMinecraft().renderEngine.bindTexture(w220_leather1);
		model.renderPart("steer_int");
	 }
}