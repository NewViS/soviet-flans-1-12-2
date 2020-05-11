//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: vaz2101
// Model Creator: 
// Created on: 01.03.2018 - 00:00:58
// Last changed on: 01.03.2018 - 00:00:58

package com.flansmod.client.model.d33zaz; //Path where the model is located

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modelzaz968m extends SovietModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation dver = new ResourceLocation("minecraft:d33zaz/textures/model/dver.png");
	private ResourceLocation metal = new ResourceLocation("minecraft:d33zaz/textures/model/metal.png");
	private ResourceLocation potolok = new ResourceLocation("minecraft:d33zaz/textures/model/potolok.png");
	private ResourceLocation prib_968 = new ResourceLocation("minecraft:d33zaz/textures/model/prib_968.png");
	private ResourceLocation rezina = new ResourceLocation("minecraft:d33zaz/textures/model/rezina.png");
	private ResourceLocation sidenia = new ResourceLocation("minecraft:d33zaz/textures/model/obivka_3.png");
	private ResourceLocation rzhavchina = new ResourceLocation("minecraft:d33zaz/textures/model/rzhavchina.png");
	private ResourceLocation sidenie1 = new ResourceLocation("minecraft:d33zaz/textures/model/sidenie1.png");
	private ResourceLocation sidenie2 = new ResourceLocation("minecraft:d33zaz/textures/model/sidenie2.png");
    private ResourceLocation ZAZ_main = new ResourceLocation("minecraft:d33zaz/textures/model/ZAZ_main.png");
    
    private ResourceLocation backfar = new ResourceLocation("minecraft:d33zaz/textures/model/backfar.png");
    private ResourceLocation glass = new ResourceLocation("minecraft:d33zaz/textures/model/glass.png");
    private ResourceLocation indwing = new ResourceLocation("minecraft:d33zaz/textures/model/indwing.png");
    private ResourceLocation raznoe = new ResourceLocation("minecraft:d33zaz/textures/model/raznoe.png");
    private ResourceLocation smth = new ResourceLocation("minecraft:d33zaz/textures/model/smth.png");
    private ResourceLocation time = new ResourceLocation("minecraft:d33zaz/textures/model/time.png");
    private ResourceLocation tum = new ResourceLocation("minecraft:d33zaz/textures/model/tum.png");
public Modelzaz968m() //Same as Filename
	{	    	
		    steer = ZAZ_main; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33zaz/textures/model/zaz968m.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);

			steerX = -28.7F;
		    steerY = 75.5F;
		    steerZ = -53F;
		    steerR = -21F;
	        
	        wheelX = 52F;
	        wheelX1 = 52F;
	        wheelY = 24.5F;
	        wheelZ = -118F;
	        wheelZ1 = 95F;
	        
	        maxSpedoAngle = 160F;
	        translateAll(0F, 0F, 0F);
	        
	}
	 @Override
	 public void renderColoredParts(){
		 //GL11.glTranslatef(0.0F, -3.0F, 0.0F);	
		 //GL11.glColor3f(0.05F, 0.05F, 0.05F);
		model.renderPart("door_lf_col");
		model.renderPart("col1");
		model.renderPart("col3");
		model.renderPart("door_rf_col");
		model.renderPart("bonnet_col");
		model.renderPart("col2");
		model.renderPart("col");
		model.renderPart("boot_col");
	 }
	 @Override
	 public void renderSteer(){       
		model.renderPart("rul");
	 }
	 @Override
	 public void renderWheels(){	
		 GL11.glScalef(0.92F, 0.92F, 0.92F);
	 }
	 
	 @Override
	 public void renderTexturedParts(){
		 //GL11.glTranslatef(0.0F, -10.0F, 0.0F);	
		 //GL11.glTranslatef(0.0F, 8.0F, 0.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(dver);
			model.renderPart("door_lf_obiv");
			model.renderPart("door_rf_obiv");
			model.renderPart("dver");
			Minecraft.getMinecraft().renderEngine.bindTexture(rezina);
			model.renderPart("pol");
			Minecraft.getMinecraft().renderEngine.bindTexture(metal);
			model.renderPart("Dvigatel");
			Minecraft.getMinecraft().renderEngine.bindTexture(sidenie1);
			model.renderPart("sedp");
			Minecraft.getMinecraft().renderEngine.bindTexture(rzhavchina);
			model.renderPart("_bl");
			Minecraft.getMinecraft().renderEngine.bindTexture(sidenie2);
			model.renderPart("sedz");
			Minecraft.getMinecraft().renderEngine.bindTexture(potolok);
			model.renderPart("potol");
			GL11.glColor3f(173/255F, 154/255F, 123/255F);
			Minecraft.getMinecraft().renderEngine.bindTexture(sidenia);
			model.renderPart("lea");
			GL11.glColor3f(1F, 1F, 1F);
			Minecraft.getMinecraft().renderEngine.bindTexture(prib_968);
			model.renderPart("spedom");
			Minecraft.getMinecraft().renderEngine.bindTexture(ZAZ_main);
			model.renderPart("_under");
			Minecraft.getMinecraft().renderEngine.bindTexture(glass);
			model.renderPart("fary");
			Minecraft.getMinecraft().renderEngine.bindTexture(indwing);
			model.renderPart("pov");
			Minecraft.getMinecraft().renderEngine.bindTexture(raznoe);
			model.renderPart("raznoe");
			Minecraft.getMinecraft().renderEngine.bindTexture(tum);
			model.renderPart("bump_front_lamp");
			Minecraft.getMinecraft().renderEngine.bindTexture(time);
			model.renderPart("time");
			Minecraft.getMinecraft().renderEngine.bindTexture(backfar);
			model.renderPart("farz");
			Minecraft.getMinecraft().renderEngine.bindTexture(smth);
			model.renderPart("knop");
			
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.6F, 0.6F, 0.6F);
			model.renderPart("bonnet_cr");
			model.renderPart("cr1");
			model.renderPart("door_lf_cr");
			model.renderPart("boot_cr");
			model.renderPart("bump_front_cr");
			model.renderPart("door_rf_cr");
			model.renderPart("bump_rear_cr");
			model.renderPart("cr");
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			model.renderPart("door_lf_gr");
			model.renderPart("door_rf_gr");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("bump_front_bl");
			model.renderPart("pedal");
			model.renderPart("bump_rear_bl");
			model.renderPart("bonnet_bl");
			model.renderPart("bl");
			model.renderPart("boot_bl");
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
	 
	 public void renderSpedo(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(prib_968);
		 GL11.glTranslatef(-29F, 77.4F, -73.3F);
		 GL11.glRotatef(-14F, 1f, 0f, 0f);
	 }
}