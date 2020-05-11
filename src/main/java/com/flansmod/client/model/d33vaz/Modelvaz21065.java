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

public class Modelvaz21065 extends Modelvaz2106 //Same as Filename
{
	public Modelvaz21065() //Same as Filename
	{	    
	}
	 @Override
	 public void renderTexturedParts(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(derevo);
			model.renderPart("derevo");
			Minecraft.getMinecraft().renderEngine.bindTexture(farp);
			model.renderPart("farp");
			Minecraft.getMinecraft().renderEngine.bindTexture(pribory);
			model.renderPart("pribor");
			Minecraft.getMinecraft().renderEngine.bindTexture(salo_tex);
			model.renderPart("remni");
			Minecraft.getMinecraft().renderEngine.bindTexture(torpeda);
			model.renderPart("panel");
			Minecraft.getMinecraft().renderEngine.bindTexture(obivka);
			model.renderPart("dash");
			model.renderPart("sed");
			model.renderPart("sed_1");
			model.renderPart("sidenz");
			model.renderPart("door_lf_obiv");
			model.renderPart("door_rr_obiv");
			model.renderPart("door_lr_obiv");
			model.renderPart("door_rf_obiv");
			Minecraft.getMinecraft().renderEngine.bindTexture(VAZ_Main);
			model.renderPart("fullsize_a");
			model.renderPart("fulls10");
			model.renderPart("fulls11");
			model.renderPart("fulls12");
			model.renderPart("fulls5");
			model.renderPart("fullsize_u");
			model.renderPart("fullsize_f");
			model.renderPart("fulls9");
			model.renderPart("fullsize_l");
			model.renderPart("fullsize_c");
			model.renderPart("fulls9_001");
			model.renderPart("undercap");
			Minecraft.getMinecraft().renderEngine.bindTexture(vaz2102);
			model.renderPart("Dvigatel");
			//model.renderPart("bump_fro");
			Minecraft.getMinecraft().renderEngine.bindTexture(z_far_03);
			model.renderPart("pov");
			Minecraft.getMinecraft().renderEngine.bindTexture(pov_2106);
			model.renderPart("pov_3");
			Minecraft.getMinecraft().renderEngine.bindTexture(fara);
			model.renderPart("st01");
			//model.renderPart("far_l");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.5F, 0.5F, 0.5F);
			model.renderPart("door_rr_chrome");
			model.renderPart("door_lr_chrome");
			model.renderPart("door_rf_chrome");
			model.renderPart("door_lf_chrome");
			model.renderPart("body_chrome");
			model.renderPart("boot_chrome");
			model.renderPart("bumpr_chrome_1");
			model.renderPart("bumpf_chrome_1");
			model.renderPart("logo");
			model.renderPart("reshetka_c");
			model.renderPart("chrome_3");
			//model.renderPart("ram_l");
			model.renderPart("chrome");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("dnodna");
			model.renderPart("bumpr_black");
			model.renderPart("bumpf_black");
			model.renderPart("boot_black");
			model.renderPart("pol");
			model.renderPart("reshetka_b");
			model.renderPart("br");
			model.renderPart("fara_zad");
			GL11.glColor3f(0.2F, 0.2F, 0.2F);
			model.renderPart("dvorniki");
			model.renderPart("door_rf_black");
			model.renderPart("door_lr_black");
			model.renderPart("door_lf_black");
			model.renderPart("door_rr_black");
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			model.renderPart("baraban");
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
}