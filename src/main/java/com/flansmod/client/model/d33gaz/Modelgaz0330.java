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

public class Modelgaz0330 extends SovietModelVehicleReaSpar //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	//private ResourceLocation black_dirt = new ResourceLocation("minecraft:d33vaz/textures/model/black_dirt.png");
	private ResourceLocation far_p = new ResourceLocation("minecraft:d33gaz/textures/model/far_p.png");
	private ResourceLocation leather= new ResourceLocation("minecraft:d33gaz/textures/model/leather.png");
	private ResourceLocation olddosk= new ResourceLocation("minecraft:d33gaz/textures/model/olddosk.png");
	private ResourceLocation molotovgaz= new ResourceLocation("minecraft:d33gaz/textures/model/molotovgaz.png");
	private ResourceLocation aep = new ResourceLocation("minecraft:d33gaz/textures/model/aep.png");
	private ResourceLocation fara = new ResourceLocation("minecraft:d33gaz/textures/model/fara.png");
	private ResourceLocation numbers = new ResourceLocation("minecraft:d33gaz/textures/model/numbers.png");
	private ResourceLocation spedo_whe = new ResourceLocation("minecraft:d33gaz/textures/model/spedo_whe.png");
	private ResourceLocation spedo = new ResourceLocation("minecraft:d33gaz/textures/model/spedo.png");
	//public IModelCustom modeldisk;
	public Modelgaz0330() //Same as Filename
	{	    	
		    steer = color; //new ResourceLocation("d33vaz:textures/model/color.png");
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33gaz/textures/model/gaz0330.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);
	        
	       // ResourceLocation disk = new ResourceLocation("minecraft:d33vaz/textures/model/disk/statusdisk_circle.obj");
	       // modeldisk = AdvancedModelLoader.loadModel(disk);
	       // modeldisk = new ModelWrapperDisplayList((WavefrontObject) modeldisk);

	        steerX = -32F;
	        steerY = 132.5f;
	        steerZ = -119.5F;
	        steerR = -42F;
	        
	        wheelX = 73F;
	        wheelX1 = 80F;
	        wheelY = 37f;
	        wheelZ = -244F;
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
		model.renderPart("Mesh_0736_");
		model.renderPart("Mesh_0735_");
		model.renderPart("Mesh_0734_");
		model.renderPart("Mesh_0731_");
		model.renderPart("Mesh_0688_");
		model.renderPart("Mesh_0733_");
		model.renderPart("Mesh_0839_");
		model.renderPart("Mesh_0695_");
		model.renderPart("Mesh_0865_");
		model.renderPart("Mesh_0864_");
		model.renderPart("Mesh_0853_");
		model.renderPart("Mesh_0848_");
		model.renderPart("Mesh_0651_");
		model.renderPart("Mesh_0854_");
		model.renderPart("Mesh_0791_");
		model.renderPart("Mesh_0790_");
		model.renderPart("Mesh_0888_");
		 model.renderPart("potol_color");
		
		//model.renderAll();
		
	 }
	 @Override
	 public void renderWheelsFro(){
		   // GL11.glScalef(0.9F, 0.9F, 0.9F);
		//	Minecraft.getMinecraft().renderEngine.bindTexture(kama301);
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.2F, 0.2F, 0.22F);
		    model.renderPart("wheel_lf_colo");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("wheel_lf_rezin");
		    GL11.glColor3f(1F, 1F, 1F);
	 }
	 @Override
	 public void renderWheelsRea(){
			//GL11.glScalef(0.9F, 0.9F, 0.9F);
		// Minecraft.getMinecraft().renderEngine.bindTexture(kama301);
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.2F, 0.2F, 0.22F);
			model.renderPart("wheel_lb_colo");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("wheel_lb_rezin");
			GL11.glColor3f(1F, 1F, 1F);
		 }
	 
	 @Override
	 public void renderSteer(){
		GL11.glColor3f(0.1F, 0.1F, 0.1F);
		model.renderPart("steer");
		GL11.glColor3f(1F, 1F, 1F);
	 }
	 
	 @Override
	 public void renderTexturedParts(){
			Minecraft.getMinecraft().renderEngine.bindTexture(far_p);	
			 model.renderPart("Mesh_0677_");
			 model.renderPart("Mesh_0678_");
			 model.renderPart("Mesh_0796");
			Minecraft.getMinecraft().renderEngine.bindTexture(leather);
			 model.renderPart("Mesh_0648_");
			 model.renderPart("Mesh_0714_");
			 model.renderPart("Mesh_0666_");
			 model.renderPart("Mesh_0716_");
			 model.renderPart("Mesh_0710_");
			 model.renderPart("Mesh_0709_");
			 model.renderPart("Mesh_0713_");
			 model.renderPart("Mesh_0654_");
			 Minecraft.getMinecraft().renderEngine.bindTexture(olddosk);
			 model.renderPart("Mesh_0660_");
			 Minecraft.getMinecraft().renderEngine.bindTexture(spedo_whe);
			 model.renderPart("Mesh_0747_");
			 Minecraft.getMinecraft().renderEngine.bindTexture(spedo);
			 model.renderPart("Mesh_0746_");
			 Minecraft.getMinecraft().renderEngine.bindTexture(numbers);
			 model.renderPart("Mesh_0750_");
			 Minecraft.getMinecraft().renderEngine.bindTexture(aep);
			 model.renderPart("Mesh_0762_");
			 Minecraft.getMinecraft().renderEngine.bindTexture(fara);
			 model.renderPart("Mesh_0698_");
			 Minecraft.getMinecraft().renderEngine.bindTexture(molotovgaz);
			 model.renderPart("Mesh_0663_");
			 model.renderPart("Mesh_0833_");
			 model.renderPart("Mesh_0835_");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.7F, 0.7F, 0.7F);
            model.renderPart("Mesh_0664_");
            model.renderPart("Mesh_0793_");
            model.renderPart("Mesh_0692_");
            model.renderPart("Mesh_0787_");
            model.renderPart("Mesh_0859_");
            model.renderPart("Mesh_0775_");
            model.renderPart("Mesh_0858_");
            model.renderPart("Mesh_0857_");
            model.renderPart("Mesh_0868_");
            model.renderPart("Mesh_0856_");
            model.renderPart("Mesh_0794_");
            model.renderPart("Mesh_0642_");
            model.renderPart("Mesh_0643_");
            model.renderPart("Mesh_0786_");
            model.renderPart("Mesh_0869_");
            model.renderPart("Mesh_0779_");
            model.renderPart("Mesh_0870_");
            model.renderPart("chrome_up");
            model.renderPart("chrome_salo");
            model.renderPart("Mesh_0900_");
			GL11.glColor3f(0.3F, 0.3F, 0.3F);	
			model.renderPart("Mesh_0655_");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("Mesh_0675_");
			model.renderPart("Mesh_0667_");
			model.renderPart("Mesh_0671_");
			model.renderPart("Mesh_0685_");
			model.renderPart("Mesh_0665_");
			model.renderPart("Mesh_0669_");
			model.renderPart("chassis");
			model.renderPart("Mesh_0770_");
			model.renderPart("Mesh_0670_");
			model.renderPart("Mesh_0717_");
			model.renderPart("Mesh_0711_");
			model.renderPart("Mesh_0715_");
			model.renderPart("Mesh_0727_");
			model.renderPart("Mesh_0726_");
			model.renderPart("Mesh_0741_");
			model.renderPart("Mesh_0729_");
			model.renderPart("Mesh_0773_");
			model.renderPart("Mesh_0772_");
			model.renderPart("Mesh_0728_");
			model.renderPart("Mesh_0708_");
			model.renderPart("Mesh_0658_");
			model.renderPart("Mesh_0768_");
			model.renderPart("Mesh_0769_");
			model.renderPart("Mesh_0687_");
			model.renderPart("Mesh_0704_");
			model.renderPart("Mesh_0705_");
			model.renderPart("Mesh_0700_");
			model.renderPart("Mesh_0653__1");
			model.renderPart("Mesh_0767_");
			model.renderPart("Mesh_0834_");
			model.renderPart("Mesh_0699_");
			model.renderPart("Mesh_0656_");
			model.renderPart("Mesh_0832_");
			model.renderPart("Mesh_0676_");
			model.renderPart("Mesh_0842_");
			model.renderPart("Mesh_0732_");
			model.renderPart("Mesh_0851_");
			model.renderPart("Mesh_0841_");
			model.renderPart("Mesh_0701_");
			model.renderPart("Mesh_0845_");
			model.renderPart("Mesh_0844_");
			model.renderPart("Mesh_0843_");
			model.renderPart("Mesh_0840_");
			model.renderPart("Mesh_0846_");
			model.renderPart("Mesh_0867_");
			model.renderPart("Mesh_0855_");
			model.renderPart("Mesh_0847_");
			model.renderPart("Mesh_0652_");
			model.renderPart("balkaPered");
			model.renderPart("resora");
			model.renderPart("tajga");
			model.renderPart("Bolt");
			model.renderPart("Mesh_0686_");
			GL11.glColor3f(0.5F, 0.1F, 0.1F);
			
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
	 @Override
	 public void frontWheelsStuff(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(0.3F, 0.3F, 0.3F);
			GL11.glRotatef(180F, 0, 1F, 0);
			GL11.glTranslatef(-8F, 0, 0);
			model.renderPart("StupkaP");
			GL11.glTranslatef(8F, 0, 0);
			GL11.glRotatef(180F, 0, 1F, 0);
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
	 }
}