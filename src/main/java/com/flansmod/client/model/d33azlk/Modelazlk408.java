package com.flansmod.client.model.d33azlk;

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelWrapperDisplayList;
import com.flansmod.client.model.SovietModelVehicle;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class Modelazlk408 extends SovietModelVehicle //как и название файла класса
{
	int textureX = 512;
	int textureY = 512;
	private ResourceLocation text1 = new ResourceLocation("minecraft:d33azlk/textures/model/bump.png");
	private ResourceLocation text2 = new ResourceLocation("minecraft:d33azlk/textures/model/dirt.png");
	private ResourceLocation text3 = new ResourceLocation("minecraft:d33azlk/textures/model/divan.png");
	private ResourceLocation text4 = new ResourceLocation("minecraft:d33azlk/textures/model/fara.png");
	private ResourceLocation text5 = new ResourceLocation("minecraft:d33azlk/textures/model/obivka_3.png");
	private ResourceLocation text6 = new ResourceLocation("minecraft:d33azlk/textures/model/optikaa.png");
	private ResourceLocation text7 = new ResourceLocation("minecraft:d33azlk/textures/model/prib.png");
	private ResourceLocation text8 = new ResourceLocation("minecraft:d33azlk/textures/model/pribor.png");
	private ResourceLocation text9 = new ResourceLocation("minecraft:d33azlk/textures/model/radiator.png");
	private ResourceLocation azlk_logo = new ResourceLocation("minecraft:d33azlk/textures/model/num.png");
	public Modelazlk408() //как и название файла
	{	    	
		steer = text1;
		    ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33azlk/textures/model/azlk408.obj");
		    model = AdvancedModelLoader.loadModel(ArbolPlataform);
	        model = new ModelWrapperDisplayList((WavefrontObject) model);

		    steerX = -29.5F;
	        steerY = 88F;
	        steerZ = -44F;
	        steerR = -35F;
	        
	        wheelX = 56F;
	        wheelX1 = 56F;
	        wheelY = 25F;
	        wheelZ = -134F;
	        wheelZ1 = 107F;
	        
	        translateAll(0F, 0F, 0F);
	        
	}
	 @Override
	 public void renderColoredParts(){
		 
		model.renderPart("door_rf_col");
		model.renderPart("door_rr_col");
		model.renderPart("door_lr_col");
		model.renderPart("door_lf_col");
		model.renderPart("boot");
		model.renderPart("bonnet");
		model.renderPart("col");
		model.renderPart("col1");
		model.renderPart("panel");
		model.renderPart("wing_rf_col");
		model.renderPart("wing_lf_col");
	 }
	 @Override
	 public void renderSteer(){
		 Minecraft.getMinecraft().renderEngine.bindTexture(color);
		 GL11.glColor3f(0.7F, 0.7F, 0.7F);
		model.renderPart("rulcr");
		GL11.glColor3f(0.2F, 0.2F, 0.2F);
		model.renderPart("rulpan");
		GL11.glColor3f(1F, 1F, 1F);
	 }
	
	 @Override
	 public void renderTexturedParts(){
		//text3 = new ResourceLocation("minecraft:d33azlk/textures/model/divan.png");
		Minecraft.getMinecraft().renderEngine.bindTexture(text9);
			model.renderPart("rad");
			Minecraft.getMinecraft().renderEngine.bindTexture(text4);
			model.renderPart("fara");
			Minecraft.getMinecraft().renderEngine.bindTexture(text2);
			model.renderPart("dirt");
			Minecraft.getMinecraft().renderEngine.bindTexture(text8);
			model.renderPart("pech");
			Minecraft.getMinecraft().renderEngine.bindTexture(text7);
			model.renderPart("prib");
			Minecraft.getMinecraft().renderEngine.bindTexture(text1);
			model.renderPart("bump_rear");
			model.renderPart("bump_front");
			model.renderPart("reshet");
			model.renderPart("reshet1");
			Minecraft.getMinecraft().renderEngine.bindTexture(azlk_logo);
			model.renderPart("logo");
			Minecraft.getMinecraft().renderEngine.bindTexture(text5);
			model.renderPart("bag_ins");
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("pol");
			GL11.glColor3f(0.2F, 0.2F, 0.2F);
			model.renderPart("pan2");
			GL11.glColor3f(1.6F, 1.6F, 1.6F);
			model.renderPart("potol");
			model.renderPart("door_rf_obiv2");
			model.renderPart("door_rr_obiv2");
			model.renderPart("door_lr_obiv2");
			model.renderPart("door_lf_obiv2");
			GL11.glColor3f(95/255F, 160/255F, 198/255F);
			model.renderPart("door_lf_obiv");
			model.renderPart("door_lr_obiv");
			model.renderPart("door_rr_obiv");
			model.renderPart("door_rf_obiv");
			Minecraft.getMinecraft().renderEngine.bindTexture(text3);
			model.renderPart("sed");
			Minecraft.getMinecraft().renderEngine.bindTexture(color);
			GL11.glColor3f(250/255F, 40/255F, 40/255F);
			model.renderPart("stopaki");
			GL11.glColor3f(237/255F, 187/255F, 66/255F);
			model.renderPart("wing_rf_pov");
			model.renderPart("wing_lf_pov");
			model.renderPart("povorot");
			GL11.glColor3f(0.8F, 0.8F, 0.8F);
			model.renderPart("pov");
			//хром
			GL11.glColor3f(0.7F, 0.7F, 0.7F);
			model.renderPart("door_rf_chrome");
			model.renderPart("door_rr_cr");
			model.renderPart("door_lr_cr");
			model.renderPart("door_lf_cr");
			model.renderPart("boot_cr");
			model.renderPart("bonnet_cr");
			model.renderPart("zerc");
			model.renderPart("cr");
			model.renderPart("knop");
			model.renderPart("wing_rf_cr");
			model.renderPart("wing_lf_cr");
			//черный
			GL11.glColor3f(0.1F, 0.1F, 0.1F);
			model.renderPart("door_rf_ruk");
			model.renderPart("door_rr_bl");
			model.renderPart("door_lr_bl");
			model.renderPart("door_lf_bl");
			model.renderPart("akk");
			model.renderPart("zercalo");
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
}
