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

public class Modelzil130ac40 extends SovietModelVehicleReaSpar //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	//private ResourceLocation black_dirt = new ResourceLocation("minecraft:d33vaz/textures/model/black_dirt.png");
	private ResourceLocation fara = new ResourceLocation("minecraft:d33zil/textures/model/fara.png");
	private ResourceLocation katex8= new ResourceLocation("minecraft:d33zil/textures/model/katex8.png");
	private ResourceLocation laz695n_protivotumanka= new ResourceLocation("minecraft:d33zil/textures/model/laz695n_protivotumanka.png");
	private ResourceLocation zildisk= new ResourceLocation("minecraft:d33zil/textures/model/zildisk.png");
	private ResourceLocation pol= new ResourceLocation("minecraft:d33zil/textures/model/pol.png");
	private ResourceLocation pribors= new ResourceLocation("minecraft:d33zil/textures/model/pribors.png");
	private ResourceLocation radiator= new ResourceLocation("minecraft:d33zil/textures/model/radiator.png");
	private ResourceLocation sgu= new ResourceLocation("minecraft:d33zil/textures/model/sgu.png");
	private ResourceLocation transceiver= new ResourceLocation("minecraft:d33zil/textures/model/transceiver.png");
	private ResourceLocation vehiclegeneric256= new ResourceLocation("minecraft:d33zil/textures/model/vehiclegeneric256.png");
	private ResourceLocation vehiclelights128= new ResourceLocation("minecraft:d33zil/textures/model/vehiclelights128.png");
	private ResourceLocation zil130a00c= new ResourceLocation("minecraft:d33zil/textures/model/zil130a00c.png");
	private ResourceLocation zil130a00e= new ResourceLocation("minecraft:d33zil/textures/model/zil130a00e.png");
	private ResourceLocation zil130a002= new ResourceLocation("minecraft:d33zil/textures/model/zil130a002.png");
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
	private ResourceLocation zil130b040= new ResourceLocation("minecraft:d33zil/textures/model/zil130b040.png");
	private ResourceLocation zil131a01a= new ResourceLocation("minecraft:d33zil/textures/model/zil131a01a.png");
	private ResourceLocation zil130a00a= new ResourceLocation("minecraft:d33zil/textures/model/zil130a00a.png");
	private ResourceLocation ziltyre= new ResourceLocation("minecraft:d33zil/textures/model/ziltyre.png");
	private ResourceLocation leather_black= new ResourceLocation("minecraft:d33zil/textures/model/leather_black.png");
	private ResourceLocation obivka2= new ResourceLocation("minecraft:d33zil/textures/model/obivka2.png");
	//public IModelCustom modeldisk;
	public Modelzil130ac40() //Same as Filename
	{	    	
		    steer = zil130as002; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33zil/textures/model/zil130ac40.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);
	        
	       // ResourceLocation disk = new ResourceLocation("minecraft:d33vaz/textures/model/disk/statusdisk_circle.obj");
	       // modeldisk = AdvancedModelLoader.loadModel(disk);
	       // modeldisk = new ModelWrapperDisplayList((WavefrontObject) modeldisk);

	        steerX = -59F;
	        steerY = 166f;
	        steerZ = -174F;
	        steerR = -37F;
	        
	        wheelX = 125F;
	        wheelX1 = 112F;
	        wheelY = 54f;
	        wheelZ = -274F;
	        wheelZ1 = 165F;
	        
	        maxSpedoAngle = 160F;
	    	//list = GL11.glGenLists(1);
	        //GL11.glNewList(list, GL11.GL_COMPILE);
	   	  	        
	        //GL11.glEndList();
	    	 
	        translateAll(0F, 0F, 0F);
	        
	 		//flipAll();	    
	}
	 /*@Override
	 public void renderColoredParts(){
	 }*/
	@Override
	 public void renderSpedo(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(pribors);
		 GL11.glTranslatef(-76.8F, 165F, -202.8F);
		 GL11.glRotatef(-5F, 1f, 0f, 0f);
		 GL11.glRotatef(-22F, 0f, 0f, 1f);
	 }
	 @Override
	 public void renderWheelsFro(){
		 	//GL11.glScalef(0.2F, 0.2F, 0.2F);
		    Minecraft.getMinecraft().renderEngine.bindTexture(ziltyre);
			model.renderPart("tyre21");
			Minecraft.getMinecraft().renderEngine.bindTexture(zildisk);
			model.renderPart("___________wheel_rf_001");
	 }
	 @Override
	 public void renderWheelsRea(){
			//GL11.glScalef(0.2F, 0.2F, 0.2F);
		 Minecraft.getMinecraft().renderEngine.bindTexture(ziltyre);
			model.renderPart("tyre211");
			Minecraft.getMinecraft().renderEngine.bindTexture(zildisk);
			model.renderPart("___________wheel_rb_001");
		 }
	 
	 @Override
	 public void renderSteer(){
		model.renderPart("___________rul_001");
	 }
	 
	 @Override
	 public void renderTexturedParts(){ 
		    Minecraft.getMinecraft().renderEngine.bindTexture(zildisk);
		    model.renderPart("___________disk_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(pribors);
			model.renderPart("___________pribors_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(obivka2);
			model.renderPart("obiv_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(leather_black);
			model.renderPart("sidzad_001");
			model.renderPart("sed_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(ziltyre);
			model.renderPart("tyre21_3");
			/*Minecraft.getMinecraft().renderEngine.bindTexture(laz695n_protivotumanka);
			model.renderPart("___________fara_001");*/
			Minecraft.getMinecraft().renderEngine.bindTexture(fara);
			model.renderPart("___________stekla_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(pol);
			model.renderPart("pol_001");
			/*Minecraft.getMinecraft().renderEngine.bindTexture(podn);
			model.renderPart("___________baki1_001");
			model.renderPart("___________podnog_001");*/
			Minecraft.getMinecraft().renderEngine.bindTexture(sgu);
			model.renderPart("___________sgu_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130b02c);
			model.renderPart("___________baki_001");
			model.renderPart("___________gluh_tex_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130as022);
			model.renderPart("____________30as022_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130a00e);
			model.renderPart("___________rama15_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130a002);
			//model.renderPart("___________bumpr_tex_001");
			model.renderPart("___________rama18_001");
			
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130a00a);
			model.renderPart("___________rama17_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130a00c);
			model.renderPart("___________rama16_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil131a01a);
			model.renderPart("____________3101a_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130as018);
			model.renderPart("___________rama14_001");
			model.renderPart("___________zerkal_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130a008);
			model.renderPart("___________rama110_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130a004);
			model.renderPart("___________rama19_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130a006);
			model.renderPart("___________rama1_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130as01c);
			model.renderPart("____________30as01c_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130as00e);
			model.renderPart("___________as00c_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130as01e);
			model.renderPart("___________as01e_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(zil130b040);
			model.renderPart("___________rama13_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(vehiclelights128);
			model.renderPart("___________light_001");
			model.renderPart("___________light1_001");
			model.renderPart("___________lights_001");
			model.renderPart("___________fari1_001");
			model.renderPart("___________fari_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(radiator);
			model.renderPart("___________radiator_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(transceiver);
			model.renderPart("___________transcieve_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(katex8);
			model.renderPart("kpp_001");
			model.renderPart("dno_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(vehiclegeneric256);
			model.renderPart("___________generic_001");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.6F, 0.6F, 0.6F);
			model.renderPart("door_rf_ch_001");
			model.renderPart("chrom2_001");
			model.renderPart("chrom_001");
			model.renderPart("door_rr_ch_001");
			model.renderPart("door_lr_ch_001");
			model.renderPart("chrom3_001");
			model.renderPart("chrome_001");
			model.renderPart("door_lf_ch_001");
			model.renderPart("chrom1_001");
			model.renderPart("red2_001");
			GL11.glColor3f(0.3F, 0.3F, 0.3F);	
			model.renderPart("grey5_001");
			model.renderPart("grey1_001");
			model.renderPart("grey6_001");
			model.renderPart("grey3_001");
			model.renderPart("ru4_001");
			model.renderPart("grey4_001");
			model.renderPart("grey10_001");
			
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("black4_001");
			model.renderPart("black16_001");
			model.renderPart("black13_001");
			model.renderPart("rama130_001");
			model.renderPart("black10_001");
			model.renderPart("black17_001");
			model.renderPart("boot_black_001");
			model.renderPart("black14_001");
			model.renderPart("rama11_001");
			model.renderPart("fari_black_001");
			model.renderPart("black2_001");
			model.renderPart("black1_001");
			model.renderPart("black3_001");
			model.renderPart("black12_001");
			model.renderPart("door_lf_bl_001");
			model.renderPart("black11_001");
			model.renderPart("black8_001");
			model.renderPart("fari__001");
			model.renderPart("anten_001");
			model.renderPart("black15_001");
			model.renderPart("gromk_001");
			model.renderPart("black9_001");
			model.renderPart("door_rr_bl_001");
			model.renderPart("door_rf_bl_001");
			model.renderPart("door_lr_bl_001");
			model.renderPart("___________baki1_001");
			model.renderPart("___________podnog_001");
			GL11.glColor3f(255/255F, 50/255F, 20/255F);
			model.renderPart("resh_001");
			model.renderPart("boot_color_001");
			model.renderPart("color7_001");
			model.renderPart("red1_001");
			model.renderPart("door_rr_co_001");
			model.renderPart("bonnet_col_001");
			//model.renderPart("red2_001");
			model.renderPart("color8_001");
			model.renderPart("color6_001");
			model.renderPart("door_lr_co_001");
			model.renderPart("red_001");
			model.renderPart("color1_001");
			GL11.glColor3f(0.0F, 0.2F, 0.15F);
			model.renderPart("color5_001");
			model.renderPart("color__2_001");
			model.renderPart("sidza_001");
			model.renderPart("door_lf_in_001");
			model.renderPart("color2_001");
			model.renderPart("door_lr_in_001");
			model.renderPart("door_rf_in_001");
			model.renderPart("door_rr_in_001");
			GL11.glColor3f(0.9F, 0.9F, 0.9F);
			model.renderPart("bonnet_whi_001");
			model.renderPart("door_lf_co_001");
			model.renderPart("door_rf_co_001");
			model.renderPart("white_001");
			model.renderPart("rama12_001");
			model.renderPart("door_lr_wh_001");
			model.renderPart("white1_001");
			model.renderPart("door_rr_wh_001");
			model.renderPart("white_podnog");
			model.renderPart("___________bumpr_tex_001");
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDepthMask(false);
			GL11.glColor4f(0.1F, 0.1F, 0.5F, 0.7F);
			model.renderPart("lamp_blue_001");
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