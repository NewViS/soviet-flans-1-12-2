//This File was created with the Minecraft-SMP Modelling Toolbox 2.2.1.1
// Copyright (C) 2015 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

package com.flansmod.client.model.d33vaz; //Path where the model is located

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.model.ModelWrapperDisplayList;
import com.flansmod.client.tmt.Coord2D;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.client.tmt.Shape2D;
import com.flansmod.common.driveables.EntityVehicle;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;
import ru.d33.graphics.model.IModelCustom;

public class ModelKubel extends ModelVehicle //Same as Filename
{
	int textureX = 512;
	int textureY = 512;
	
	ResourceLocation ArbolPlataform = new ResourceLocation("minecraft:d33vaz/textures/model/lada_priora.obj");
	IModelCustom model;
     
	public ModelKubel() //Same as Filename
	{
		model = AdvancedModelLoader.loadModel(ArbolPlataform);
	    model = new ModelWrapperDisplayList((WavefrontObject) model);
		
		/*bodyModel = new ModelRendererTurbo[2];
		bodyModel[0] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 0
		
		//bodyModel[0].setDefaultTexture("d33vaz/textures/model/polik.png");
		//bodyModel[0].set
		//bodyModel[0].addObj("models/wheelsmz");
		//bodyModel[0].setRotationPoint(0F, 0F, 0F);
		
		bodyModel[1] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 0
		
		bodyModel[1].setDefaultTexture("d33vaz/textures/model/polik.png");
		//bodyModel[0].set
		bodyModel[1].addObj("wheelsmz");
		bodyModel[1].setRotationPoint(0F, 0F, 0F);

		bodyDoorOpenModel = new ModelRendererTurbo[1];
		bodyDoorOpenModel[0] = new ModelRendererTurbo(this, 161, 97, textureX, textureY); // Box 75

		bodyDoorOpenModel[0].addShapeBox(0F, 0F, -0.5F, 14, 12, 1, 0F, 0F, 0F, -0.1F, 0F, 0F, 0.8F, 0F, 0F, -1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, 0.8F, 0F, 0F, -1F, 0F, 0F, -0.1F); // Box 75
		bodyDoorOpenModel[0].setRotationPoint(-3F, -14F, 13F);
		bodyDoorOpenModel[0].rotateAngleY = 1.57079633F;


		bodyDoorCloseModel = new ModelRendererTurbo[1];
		bodyDoorCloseModel[0] = new ModelRendererTurbo(this, 377, 41, textureX, textureY); // Box 0
		
		bodyDoorCloseModel[0].addShapeBox(-13F, 0F, -0.5F, 13, 12, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 0
		bodyDoorCloseModel[0].setRotationPoint(-5F, -14F, 13F);
		

		leftFrontWheelModel = new ModelRendererTurbo[1];
		leftFrontWheelModel[0] = new ModelRendererTurbo(this, 321, 237, textureX, textureY); // Shape 10

		leftFrontWheelModel[0].addShape3D(8F, -7F, -5F, new Shape2D(new Coord2D[]{new Coord2D(4, 0, 4, 0), new Coord2D(12, 0, 12, 0), new Coord2D(15, 3, 15, 3), new Coord2D(15, 11, 15, 11), new Coord2D(12, 14, 12, 14), new Coord2D(4, 14, 4, 14), new Coord2D(1, 11, 1, 11), new Coord2D(1, 3, 1, 3)}), 5, 17, 17, 52, 5, ModelRendererTurbo.MR_FRONT, new float[]{5, 8, 5, 8, 5, 8, 5, 8}); // Shape 10
		leftFrontWheelModel[0].setRotationPoint(25F, 3F, 11F);


		rightFrontWheelModel = new ModelRendererTurbo[1];
		rightFrontWheelModel[0] = new ModelRendererTurbo(this, 321, 237, textureX, textureY); // Shape 2

		rightFrontWheelModel[0].addShape3D(8F, -7F, 0F, new Shape2D(new Coord2D[]{new Coord2D(4, 0, 4, 0), new Coord2D(12, 0, 12, 0), new Coord2D(15, 3, 15, 3), new Coord2D(15, 11, 15, 11), new Coord2D(12, 14, 12, 14), new Coord2D(4, 14, 4, 14), new Coord2D(1, 11, 1, 11), new Coord2D(1, 3, 1, 3)}), 5, 17, 17, 52, 5, ModelRendererTurbo.MR_FRONT, new float[]{5, 8, 5, 8, 5, 8, 5, 8}); // Shape 2
		rightFrontWheelModel[0].setRotationPoint(25F, 3F, -10F);


		leftBackWheelModel = new ModelRendererTurbo[1];
		leftBackWheelModel[0] = new ModelRendererTurbo(this, 321, 237, textureX, textureY); // Shape 4

		leftBackWheelModel[0].addShape3D(8F, -7F, -5F, new Shape2D(new Coord2D[]{new Coord2D(4, 0, 4, 0), new Coord2D(12, 0, 12, 0), new Coord2D(15, 3, 15, 3), new Coord2D(15, 11, 15, 11), new Coord2D(12, 14, 12, 14), new Coord2D(4, 14, 4, 14), new Coord2D(1, 11, 1, 11), new Coord2D(1, 3, 1, 3)}), 5, 17, 17, 52, 5, ModelRendererTurbo.MR_FRONT, new float[]{5, 8, 5, 8, 5, 8, 5, 8}); // Shape 4
		leftBackWheelModel[0].setRotationPoint(-29F, 3F, 11F);


		rightBackWheelModel = new ModelRendererTurbo[1];
		rightBackWheelModel[0] = new ModelRendererTurbo(this, 321, 237, textureX, textureY); // Shape 3

		rightBackWheelModel[0].addShape3D(8F, -7F, 0F, new Shape2D(new Coord2D[]{new Coord2D(4, 0, 4, 0), new Coord2D(12, 0, 12, 0), new Coord2D(15, 3, 15, 3), new Coord2D(15, 11, 15, 11), new Coord2D(12, 14, 12, 14), new Coord2D(4, 14, 4, 14), new Coord2D(1, 11, 1, 11), new Coord2D(1, 3, 1, 3)}), 5, 17, 17, 52, 5, ModelRendererTurbo.MR_FRONT, new float[]{5, 8, 5, 8, 5, 8, 5, 8}); // Shape 3
		rightBackWheelModel[0].setRotationPoint(-29F, 3F, -10F);


		steeringWheelModel = new ModelRendererTurbo[9];
		steeringWheelModel[0] = new ModelRendererTurbo(this, 89, 41, textureX, textureY); // Box 15
		steeringWheelModel[1] = new ModelRendererTurbo(this, 121, 41, textureX, textureY); // Box 16
		steeringWheelModel[2] = new ModelRendererTurbo(this, 105, 9, textureX, textureY); // Box 17
		steeringWheelModel[3] = new ModelRendererTurbo(this, 209, 57, textureX, textureY); // Box 25
		steeringWheelModel[4] = new ModelRendererTurbo(this, 209, 57, textureX, textureY); // Box 25
		steeringWheelModel[5] = new ModelRendererTurbo(this, 105, 9, textureX, textureY); // Box 26
		steeringWheelModel[6] = new ModelRendererTurbo(this, 105, 9, textureX, textureY); // Box 27
		steeringWheelModel[7] = new ModelRendererTurbo(this, 209, 57, textureX, textureY); // Box 28
		steeringWheelModel[8] = new ModelRendererTurbo(this, 209, 57, textureX, textureY); // Box 29

		steeringWheelModel[0].addShapeBox(0F, -0.5F, -0.5F, 3, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 15
		steeringWheelModel[0].setRotationPoint(7F, -13F, 5F);
		steeringWheelModel[0].rotateAngleZ = -0.43633231F;

		steeringWheelModel[1].addShapeBox(-1F, -0.5F, -0.5F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 16
		steeringWheelModel[1].setRotationPoint(7F, -13F, 5F);
		steeringWheelModel[1].rotateAngleZ = -0.43633231F;

		steeringWheelModel[2].addShapeBox(-1F, -0.8F, 0.3F, 1, 1, 3, 0F, -0.3F, -0.3F, 0F, -0.3F, -0.3F, 0F, -0.3F, 1.7F, -1F, -0.3F, 1.7F, -1F, -0.3F, -0.3F, 0F, -0.3F, -0.3F, 0F, -0.3F, -2.3F, -1F, -0.3F, -2.3F, -1F); // Box 17
		steeringWheelModel[2].setRotationPoint(7F, -13F, 5F);
		steeringWheelModel[2].rotateAngleZ = -0.43633231F;

		steeringWheelModel[3].addShapeBox(-1F, -3F, -3F, 1, 1, 6, 0F, -0.2F, 0F, -1F, -0.2F, 0F, -1F, -0.2F, 0F, -1F, -0.2F, 0F, -1F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 25
		steeringWheelModel[3].setRotationPoint(7F, -13F, 5F);
		steeringWheelModel[3].rotateAngleZ = -0.43633231F;

		steeringWheelModel[4].addShapeBox(-1F, 2F, -3F, 1, 1, 6, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -1F, -0.2F, 0F, -1F, -0.2F, 0F, -1F, -0.2F, 0F, -1F); // Box 25
		steeringWheelModel[4].setRotationPoint(7F, -13F, 5F);
		steeringWheelModel[4].rotateAngleZ = -0.43633231F;

		steeringWheelModel[5].addShapeBox(-1F, -0.8F, -3.3F, 1, 1, 3, 0F, -0.3F, 1.7F, -1F, -0.3F, 1.7F, -1F, -0.3F, -0.3F, 0F, -0.3F, -0.3F, 0F, -0.3F, -2.3F, -1F, -0.3F, -2.3F, -1F, -0.3F, -0.3F, 0F, -0.3F, -0.3F, 0F); // Box 26
		steeringWheelModel[5].setRotationPoint(7F, -13F, 5F);
		steeringWheelModel[5].rotateAngleZ = -0.43633231F;

		steeringWheelModel[6].addShapeBox(-1F, 0.8F, -2.85F, 1, 1, 3, 0F, -0.3F, 0.3F, -2.7F, -0.3F, 0.3F, -2.7F, -0.3F, 0.3F, 0F, -0.3F, 0.3F, 0F, -0.3F, 0.3F, -2.7F, -0.3F, 0.3F, -2.7F, -0.3F, 0.3F, 0F, -0.3F, 0.3F, 0F); // Box 27
		steeringWheelModel[6].setRotationPoint(7F, -13F, 5F);
		steeringWheelModel[6].rotateAngleZ = -0.43633231F;

		steeringWheelModel[7].addShapeBox(-1F, -0.5F, -0.5F, 1, 1, 6, 0F, -0.2F, 2.5F, -2.5F, -0.2F, 2.5F, -2.5F, -0.2F, 1.5F, -2.5F, -0.2F, 1.5F, -2.5F, -0.2F, 2.5F, -2.5F, -0.2F, 2.5F, -2.5F, -0.2F, 1.5F, -2.5F, -0.2F, 1.5F, -2.5F); // Box 28
		steeringWheelModel[7].setRotationPoint(7F, -13F, 5F);
		steeringWheelModel[7].rotateAngleZ = -0.43633231F;

		steeringWheelModel[8].addShapeBox(-1F, -0.5F, -5.5F, 1, 1, 6, 0F, -0.2F, 1.5F, -2.5F, -0.2F, 1.5F, -2.5F, -0.2F, 2.5F, -2.5F, -0.2F, 2.5F, -2.5F, -0.2F, 1.5F, -2.5F, -0.2F, 1.5F, -2.5F, -0.2F, 2.5F, -2.5F, -0.2F, 2.5F, -2.5F); // Box 29
		steeringWheelModel[8].setRotationPoint(7F, -13F, 5F);
		steeringWheelModel[8].rotateAngleZ = -0.43633231F;


		// Passenger 2
		ModelRendererTurbo[][] gun_1_Model = new ModelRendererTurbo[3][];

		gun_1_Model[0] = new ModelRendererTurbo[0];

		gun_1_Model[1] = new ModelRendererTurbo[16];
		gun_1_Model[1][0] = new ModelRendererTurbo(this, 9, 227, textureX, textureY); // Box 4
		gun_1_Model[1][1] = new ModelRendererTurbo(this, 41, 227, textureX, textureY); // Box 5
		gun_1_Model[1][2] = new ModelRendererTurbo(this, 1, 235, textureX, textureY); // Box 6
		gun_1_Model[1][3] = new ModelRendererTurbo(this, 57, 227, textureX, textureY); // Box 7
		gun_1_Model[1][4] = new ModelRendererTurbo(this, 17, 235, textureX, textureY); // Box 8
		gun_1_Model[1][5] = new ModelRendererTurbo(this, 25, 235, textureX, textureY); // Box 9
		gun_1_Model[1][6] = new ModelRendererTurbo(this, 33, 235, textureX, textureY); // Box 10
		gun_1_Model[1][7] = new ModelRendererTurbo(this, 41, 235, textureX, textureY); // Box 12
		gun_1_Model[1][8] = new ModelRendererTurbo(this, 49, 235, textureX, textureY); // Box 13
		gun_1_Model[1][9] = new ModelRendererTurbo(this, 1, 243, textureX, textureY); // Box 15
		gun_1_Model[1][10] = new ModelRendererTurbo(this, 9, 243, textureX, textureY); // Box 16
		gun_1_Model[1][11] = new ModelRendererTurbo(this, 17, 243, textureX, textureY); // Box 17
		gun_1_Model[1][12] = new ModelRendererTurbo(this, 25, 243, textureX, textureY); // Box 18
		gun_1_Model[1][13] = new ModelRendererTurbo(this, 33, 227, textureX, textureY); // Box 19
		gun_1_Model[1][14] = new ModelRendererTurbo(this, 1, 251, textureX, textureY); // Box 0
		gun_1_Model[1][15] = new ModelRendererTurbo(this, 49, 243, textureX, textureY); // Box 1

		gun_1_Model[1][0].addShapeBox(1F, -1.3F, -0.5F, 12, 1, 1, 0F, 0F, 0.2F, 0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.2F, 0.2F); // Box 4

		gun_1_Model[1][1].addShapeBox(-2F, -1.3F, -0.5F, 3, 1, 1, 0F, 0F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0.5F, 0.5F); // Box 5

		gun_1_Model[1][2].addShapeBox(-7F, -1.3F, -0.5F, 5, 1, 1, 0F, 0F, 0.2F, -0.2F, 0F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0.2F, -0.2F, 0F, 0.5F, -0.2F, 0F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0.5F, -0.2F); // Box 6

		gun_1_Model[1][3].addShapeBox(14F, -1.3F, -0.5F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0.1F, 0.1F, 0F, 0.1F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0.1F, 0F, 0.1F, 0.1F, 0F, 0F, 0F); // Box 7

		gun_1_Model[1][4].addShapeBox(13F, -1.3F, -0.5F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0.1F, 0.1F, 0F, 0.1F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0.1F, 0F, 0.1F, 0.1F, 0F, 0F, 0F); // Box 8

		gun_1_Model[1][5].addShapeBox(0F, -1.5F, -2F, 1, 2, 1, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 9

		gun_1_Model[1][6].addShapeBox(0F, -1.5F, -1.5F, 1, 2, 1, 0F, -0.4F, -0.2F, 0F, -0.4F, -0.2F, 0F, -0.4F, -0.2F, 0F, -0.4F, -0.2F, 0F, -0.4F, -0.2F, 0F, -0.4F, -0.2F, 0F, -0.4F, -0.2F, 0F, -0.4F, -0.2F, 0F); // Box 10

		gun_1_Model[1][7].addShapeBox(12F, -2.3F, -0.5F, 1, 1, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F); // Box 12

		gun_1_Model[1][8].addShapeBox(2F, -2F, -1F, 2, 1, 2, 0F, 0F, 0F, -0.6F, 0F, 0F, -0.6F, 0F, 0F, -0.6F, 0F, 0F, -0.6F, 0F, 0F, -0.6F, 0F, 0F, -0.6F, 0F, 0F, -0.6F, 0F, 0F, -0.6F); // Box 13

		gun_1_Model[1][9].addShapeBox(-4.9F, -1.8F, -0.5F, 1, 1, 1, 0F, 0F, 0F, -0.1F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 15

		gun_1_Model[1][10].addShapeBox(-9F, -1.3F, -0.5F, 2, 1, 1, 0F, 0F, 0.5F, 0F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.5F, 0F, 0F, 1F, 0F, 0F, 0.5F, -0.2F, 0F, 0.5F, -0.2F, 0F, 1F, 0F); // Box 16

		gun_1_Model[1][11].addShapeBox(-6F, 0.2F, -0.5F, 1, 2, 1, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 1F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, -0.2F, 1F, 0F, -0.2F); // Box 17

		gun_1_Model[1][12].addShapeBox(-1.5F, -0.8F, 1F, 2, 3, 4, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F); // Box 18

		gun_1_Model[1][13].addShapeBox(-1.5F, -1.5F, 0.4F, 2, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.6F, 0F, 0F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 19

		gun_1_Model[1][14].addShapeBox(1F, -1.3F, -0.5F, 12, 1, 1, 0F, 0F, 0F, 0.4F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.4F, 0F, 0F, 0.4F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.4F); // Box 0

		gun_1_Model[1][15].addShapeBox(-1.5F, -0.9F, 1F, 2, 3, 4, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F); // Box 1

		//Gun Origin
		for(ModelRendererTurbo gunPart : gun_1_Model[1])
		{
			gunPart.setRotationPoint(-5F, -25F, 0F);
		}


		gun_1_Model[2] = new ModelRendererTurbo[0];

		registerGunModel("PassengerGun1", gun_1_Model);*/

		translateAll(0F, 0F, 0F);


		flipAll();
	}
	@Override
	public void render(float f5, EntityVehicle vehicle, float f){
		super.render(f5, vehicle, f);
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_LIGHTING);
		//GL11.glEnable(GL11.GL_SMOOTH);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glScaled(0.01, 0.01, 0.01);
		model.renderAll();
		GL11.glPopMatrix();
		//System.out.println(vehicle.disk_model.getPath());
	}
}
