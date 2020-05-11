package com.flansmod.client.model;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.driveables.DriveableData;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.driveables.VehicleType;
import com.flansmod.common.vector.Vector3f;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;
import ru.d33.graphics.model.IModelCustom;


//Extensible ModelVehicle class for rendering vehicle models
public class SovietModelVehicleReaSpar extends ModelVehicle
{
	public ResourceLocation steer;
	//public ResourceLocation wheel_gaz_shtamp= new ResourceLocation("minecraft:d33gaz/textures/model/wheel_vaz_shtamp.png");
	public ResourceLocation color = new ResourceLocation("minecraft:d33vaz/textures/model/paint.png");
	//public ResourceLocation statusdisk = new ResourceLocation("minecraft:d33vaz/textures/model/statusdisk.png");
	//public ResourceLocation status_tyre= new ResourceLocation("minecraft:d33vaz/textures/model/status_tyre.png");
	//public ResourceLocation kolesa = new ResourceLocation("minecraft:d33vaz/textures/model/d33wheels.obj");
	//public ResourceLocation statusdisk_circle = new ResourceLocation("minecraft:d33vaz/textures/model/statusdisk_circle.obj");
	public ResourceLocation kuzov_texture= new ResourceLocation("minecraft:d33vaz/textures/model/bort.png");
	public IModelCustom model;
	/*public ResourceLocation disk_texture;
	public ResourceLocation disk_model;
	public ResourceLocation disk_model1= new ResourceLocation("minecraft:d33vaz/textures/model/disk/statusdisk_5rect.obj");
	public IModelCustom wheelinhand =AdvancedModelLoader.loadModel(disk_model1);
	IModelCustom d33wheel = AdvancedModelLoader.loadModel(kolesa);
	 String str3 = "";
	 String str4 = "";*/
	public ResourceLocation kuzov_model1 = new ResourceLocation("minecraft:d33vaz/textures/model/kuzov/grey_kuzov.obj");
	private IModelCustom d33kuzov = AdvancedModelLoader.loadModel(kuzov_model1);
	
	public boolean isKuzov = false;
	
    public ModelRendererTurbo turretModel[] = new ModelRendererTurbo[0];			//The turret (for tanks)
	public ModelRendererTurbo barrelModel[] = new ModelRendererTurbo[0];			//The barrel of the main turret
	public ModelRendererTurbo ammoModel[][] = new ModelRendererTurbo[0][0];			//Ammo models for the main turret. ammoModel[i] will render if the vehicle has less than 3 ammo slots or if slot i is full. Checks shell / missile inventory
    public ModelRendererTurbo frontWheelModel[] = new ModelRendererTurbo[0];		//Front and back wheels are for bicycles and motorbikes and whatnot
    public ModelRendererTurbo backWheelModel[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo leftFrontWheelModel[] = new ModelRendererTurbo[0];	//This set of 4 wheels are for 4 or more wheeled things
    public ModelRendererTurbo rightFrontWheelModel[] = new ModelRendererTurbo[0];	//The front wheels will turn as the player steers, and the back ones will not
    public ModelRendererTurbo leftBackWheelModel[] = new ModelRendererTurbo[0];		//They will all turn as the car drives if the option to do so is set on
    public ModelRendererTurbo rightBackWheelModel[] = new ModelRendererTurbo[0];	//In the vehicle type file
    public ModelRendererTurbo rightTrackModel[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo leftTrackModel[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo rightTrackWheelModels[] = new ModelRendererTurbo[0];	//These go with the tracks but rotate
    public ModelRendererTurbo leftTrackWheelModels[] = new ModelRendererTurbo[0];
	
	public ModelRendererTurbo bodyDoorOpenModel[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyDoorCloseModel[] = new ModelRendererTurbo[0];	
	public ModelRendererTurbo trailerModel[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo steeringWheelModel[] = new ModelRendererTurbo[0];
	
	public ModelRendererTurbo drillHeadModel[] = new ModelRendererTurbo[0]; 		//Drill head. Rotates around
	public Vector3f drillHeadOrigin = new Vector3f();								//this point
	//float flr;
	public float steerX, steerY, steerZ, steerR;
	public float wheelX, wheelX1, wheelY, wheelZ, wheelZ1;
	
	public float maxSpedoAngle;
	@Override
	public void render(EntityDriveable driveable, float f1)
	{
		render(0.0625F, (EntityVehicle)driveable, f1);
	}
	
	@Override
	/** GUI render method */
	public void render(DriveableType type)
	{
		super.render(type);
		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
   	    GL11.glScalef(0.015F, 0.015F, 0.015F);   		
		GL11.glRotatef(-90F, 0.0f, 1.0f, 0.0f);
		GL11.glTranslatef(0.0F, -40.0F, 0.0F);	
		renderTexturedParts();
		GL11.glColor3f(0.5F, 0.5F, 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(color);
		renderColoredParts();
	    GL11.glColor3f(1.0F, 1.0F, 1.0F);

		GL11.glPushMatrix();
	    GL11.glTranslatef(steerX, steerY, steerZ);	
	    GL11.glRotatef(steerR, 1f, 0.0f, 0f);
	    Minecraft.getMinecraft().renderEngine.bindTexture(steer);
		renderSteer();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		if(isKuzov){
			 renderKuzov();
			 Minecraft.getMinecraft().renderEngine.bindTexture(kuzov_texture);
				d33kuzov.renderAll();
			}
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(-wheelX, wheelY, wheelZ);	
	    frontWheelsStuff();
	    GL11.glRotatef(90F, 0f, 1f, 0f);
	    //GL11.glScalef(5F, 5F, 5F); 
	    renderWheelsFro();
	   /* Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		d33wheel.renderPart("status_tyre");
		Minecraft.getMinecraft().renderEngine.bindTexture(statusdisk);
		wheelinhand.renderAll();*/
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(wheelX, wheelY, wheelZ);	
	    frontWheelsStuff();
	    GL11.glRotatef(-90F, 0f, 1f, 0f);
	    //GL11.glScalef(5F, 5F, 5F); 
	    renderWheelsFro();
	    /*Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		d33wheel.renderPart("status_tyre");
		Minecraft.getMinecraft().renderEngine.bindTexture(statusdisk);
		wheelinhand.renderAll();*/
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(-wheelX1, wheelY, wheelZ1);	
	    GL11.glRotatef(90F, 0f, 1f, 0f);
	    //GL11.glScalef(5F, 5F, 5F); 
	    renderWheelsRea();
	    /*Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		d33wheel.renderPart("status_tyre");
		Minecraft.getMinecraft().renderEngine.bindTexture(statusdisk);
		wheelinhand.renderAll();*/
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(wheelX1, wheelY, wheelZ1);	
	    GL11.glRotatef(-90F, 0f, 1f, 0f);
	    //GL11.glScalef(5F, 5F, 5F); 
	    /*Minecraft.getMinecraft().renderEngine.bindTexture(lrctire);
		d33wheel.renderPart("fr");
		Minecraft.getMinecraft().renderEngine.bindTexture(lrcdisk);
		d33wheel.renderPart("fr2");*/
	    renderWheelsRea();
	    /*Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		d33wheel.renderPart("status_tyre");
		Minecraft.getMinecraft().renderEngine.bindTexture(statusdisk);
		wheelinhand.renderAll();*/
		GL11.glPopMatrix();
		
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        
		renderPart(leftBackWheelModel);
		renderPart(rightBackWheelModel);
		renderPart(leftFrontWheelModel);
		renderPart(rightFrontWheelModel);
		renderPart(rightTrackModel);
		renderPart(leftTrackModel);
		renderPart(rightTrackWheelModels);
		renderPart(leftTrackWheelModels);
		renderPart(bodyDoorCloseModel);
		renderPart(trailerModel);
		renderPart(turretModel);
		renderPart(barrelModel);
		renderPart(drillHeadModel);
		for(ModelRendererTurbo[] mods : ammoModel)
			renderPart(mods);
		renderPart(steeringWheelModel);
	}
	public void renderColoredParts(){}
	public void renderTexturedParts(){}
	public void frontWheelsStuff(){}
	public void renderWheelsFro(){
	}
	public void renderWheelsRea(){
	}
	public void renderKuzov(){
	}
	public void renderSpedo() {
	}
	public void renderSteer(){
		model.renderPart("steer");
	}
	
	//@Override
	//TODO array generator for disks
    public void render(float f5, EntityVehicle vehicle, float f)
    {   boolean rotateWheels = vehicle.getVehicleType().rotateWheels;
    DriveableData data = vehicle.getDriveableData();
    
    if (vehicle.kuzov_model != null)
		if (vehicle.kuzov_model.getPath() != vehicle.kuzov_model1.getPath()) {
			vehicle.kuzov_model1 = vehicle.kuzov_model;
			vehicle.d33kuzov = AdvancedModelLoader.loadModel(vehicle.kuzov_model1);
			vehicle.d33kuzov = new ModelWrapperDisplayList((WavefrontObject) vehicle.d33kuzov);
		}
    
    if(vehicle.iskup){
    	vehicle.kuzov_model1 = vehicle.kuzov_model;
		vehicle.d33kuzov = AdvancedModelLoader.loadModel(vehicle.kuzov_model1);
		vehicle.d33kuzov = new ModelWrapperDisplayList((WavefrontObject) vehicle.d33kuzov);
		vehicle.iskup=false;
	}
    
		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
   	    GL11.glScalef(0.015F, 0.015F, 0.015F);   
		GL11.glRotatef(-90F, 0.0f, 1.0f, 0.0f);
		GL11.glTranslatef(0.0F, -40.0F, 0.0F);	
		renderTexturedParts();
		GL11.glColor3f(data.fr, data.fg, data.fb);
		Minecraft.getMinecraft().renderEngine.bindTexture(color);
		renderColoredParts();
		GL11.glColor3f(1.0F, 1.0F, 1.0F);
	    
		GL11.glPushMatrix();
		renderSpedo();
		if(vehicle.throttle>0)
		GL11.glRotatef(-vehicle.throttle*maxSpedoAngle, 0f, 0f, 1f);
		model.renderPart("spedo");
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
	    GL11.glTranslatef(steerX, steerY, steerZ);	
	    GL11.glRotatef(steerR, 1f, 0.0f, 0f);
	    GL11.glRotatef(vehicle.wheelsYaw * 3.14159265F * -15F, 0.0f, 0.0f, 1f);
	    Minecraft.getMinecraft().renderEngine.bindTexture(steer);
	    renderSteer();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(-wheelX, wheelY, wheelZ);	
	    GL11.glRotatef(-vehicle.wheelsYaw * 3.14159265F +3.14159265F, 0f, 1f, 0f);
	    frontWheelsStuff();
	    GL11.glRotatef(rotateWheels ? -vehicle.wheelsAngle*180 : 0, 1f, 0f, 0f);
	    GL11.glRotatef(90F, 0f, 1f, 0f);
	    //GL11.glScalef(5F, 5F, 5F); 
	    renderWheelsFro();
	    /*
		Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		d33wheel.renderPart("status_tyre");
		Minecraft.getMinecraft().renderEngine.bindTexture(vehicle.disk_texture);
		vehicle.d33wheel.renderAll();
		*/
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(wheelX, wheelY, wheelZ);
	    GL11.glRotatef(-vehicle.wheelsYaw * 3.14159265F +3.14159265F, 0f, 1f, 0f);
	    GL11.glRotatef(-180F, 0f, 1f, 0f);
	    GL11.glRotatef(-180F, 1f, 0f, 0f);
	    frontWheelsStuff();
	    GL11.glRotatef(180F, 1f, 0f, 0f);
	    GL11.glRotatef(180F, 0f, 1f, 0f);
	    GL11.glRotatef(rotateWheels ? -vehicle.wheelsAngle*180 : 0, 1f, 0f, 0f);
	    GL11.glRotatef(-90F, 0f, 1f, 0f);
	    //GL11.glScalef(5F, 5F, 5F); 
	    renderWheelsFro();
	    /*
	    Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		d33wheel.renderPart("status_tyre");
		Minecraft.getMinecraft().renderEngine.bindTexture(vehicle.disk_texture);
		vehicle.d33wheel.renderAll();
	    */
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(-wheelX1, wheelY, wheelZ1);	
	    GL11.glRotatef(rotateWheels ? -vehicle.wheelsAngle*180 : 0, 1f, 0f, 0f);
	    GL11.glRotatef(90F, 0f, 1f, 0f);
	    //GL11.glScalef(5F, 5F, 5F); 
	    renderWheelsRea();
/*
	    Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		d33wheel.renderPart("status_tyre");
		Minecraft.getMinecraft().renderEngine.bindTexture(vehicle.disk_texture);
		vehicle.d33wheel.renderAll();
	    */
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(wheelX1, wheelY, wheelZ1);	
	    GL11.glRotatef(rotateWheels ? -vehicle.wheelsAngle*180 : 0, 1f, 0f, 0f);
	    GL11.glRotatef(-90F, 0f, 1f, 0f);
	    //GL11.glScalef(5F, 5F, 5F); 
	    renderWheelsRea();
/*
	    Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		d33wheel.renderPart("status_tyre");
		Minecraft.getMinecraft().renderEngine.bindTexture(vehicle.disk_texture);
		vehicle.d33wheel.renderAll();
	    */
		GL11.glPopMatrix();
		
		if(isKuzov){
		 renderKuzov();
		 Minecraft.getMinecraft().renderEngine.bindTexture(vehicle.kuzov_texture);
			if (vehicle.d33kuzov != null)
				vehicle.d33kuzov.renderAll();
			else d33kuzov.renderAll();
		}
		
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		
		//Rendering the body
        if(vehicle.isPartIntact(EnumDriveablePart.core))
        {
			for (ModelRendererTurbo aBodyModel : bodyModel) {
				aBodyModel.render(f5, oldRotateOrder);
			}
			for (ModelRendererTurbo aBodyDoorOpenModel : bodyDoorOpenModel) {
				if (vehicle.varDoor)
					aBodyDoorOpenModel.render(f5, oldRotateOrder);
			}
			for (ModelRendererTurbo aBodyDoorCloseModel : bodyDoorCloseModel) {
				if (!vehicle.varDoor)
					aBodyDoorCloseModel.render(f5, oldRotateOrder);
			}
			for (ModelRendererTurbo aSteeringWheelModel : steeringWheelModel) {
				aSteeringWheelModel.rotateAngleX = vehicle.wheelsYaw * 3.14159265F / 180F * 3F;
				aSteeringWheelModel.render(f5, oldRotateOrder);
				
				
			}
        }
		
		//Wheels
        if(vehicle.isPartIntact(EnumDriveablePart.backLeftWheel))
        {
			for (ModelRendererTurbo aLeftBackWheelModel : leftBackWheelModel) {
				aLeftBackWheelModel.rotateAngleZ = rotateWheels ? -vehicle.wheelsAngle : 0;
				aLeftBackWheelModel.render(f5, oldRotateOrder);
			}
        }
        if(vehicle.isPartIntact(EnumDriveablePart.backRightWheel))
        {
			for (ModelRendererTurbo aRightBackWheelModel : rightBackWheelModel) {
				aRightBackWheelModel.rotateAngleZ = rotateWheels ? -vehicle.wheelsAngle : 0;
				aRightBackWheelModel.render(f5, oldRotateOrder);
			}
        }
        if(vehicle.isPartIntact(EnumDriveablePart.frontLeftWheel))
        {
			for (ModelRendererTurbo aLeftFrontWheelModel : leftFrontWheelModel) {
				aLeftFrontWheelModel.rotateAngleZ = rotateWheels ? -vehicle.wheelsAngle : 0;
				aLeftFrontWheelModel.rotateAngleY = -vehicle.wheelsYaw * 3.14159265F / 180F * 3F;
				aLeftFrontWheelModel.render(f5, oldRotateOrder);
			}
        }
        if(vehicle.isPartIntact(EnumDriveablePart.frontRightWheel))
        {
			for (ModelRendererTurbo aRightFrontWheelModel : rightFrontWheelModel) {
				aRightFrontWheelModel.rotateAngleZ = rotateWheels ? -vehicle.wheelsAngle : 0;
				aRightFrontWheelModel.rotateAngleY = -vehicle.wheelsYaw * 3.14159265F / 180F * 3F+3.14159265F;
				aRightFrontWheelModel.render(f5, oldRotateOrder);
			}
        }        
        if(vehicle.isPartIntact(EnumDriveablePart.frontWheel))
        {
			for (ModelRendererTurbo aFrontWheelModel : frontWheelModel) {
				aFrontWheelModel.rotateAngleZ = rotateWheels ? -vehicle.wheelsAngle : 0;
				aFrontWheelModel.rotateAngleY = -vehicle.wheelsYaw * 3.14159265F / 180F * 3F;
				aFrontWheelModel.render(f5, oldRotateOrder);
			}
        }
        if(vehicle.isPartIntact(EnumDriveablePart.backWheel))
        {
			for (ModelRendererTurbo aBackWheelModel : backWheelModel) {
				aBackWheelModel.rotateAngleZ = rotateWheels ? -vehicle.wheelsAngle : 0;
				aBackWheelModel.render(f5, oldRotateOrder);
			}
        }
        
        if(vehicle.isPartIntact(EnumDriveablePart.leftTrack))
        {
			for (ModelRendererTurbo aLeftTrackModel : leftTrackModel) {
				aLeftTrackModel.render(f5, oldRotateOrder);
			}
			for (ModelRendererTurbo leftTrackWheelModel : leftTrackWheelModels) {
				leftTrackWheelModel.rotateAngleZ = rotateWheels ? -vehicle.wheelsAngle : 0;
				leftTrackWheelModel.render(f5, oldRotateOrder);
			}
        }
        
        if(vehicle.isPartIntact(EnumDriveablePart.rightTrack))
        {
			for (ModelRendererTurbo aRightTrackModel : rightTrackModel) {
				aRightTrackModel.render(f5, oldRotateOrder);
			}
			for (ModelRendererTurbo rightTrackWheelModel : rightTrackWheelModels) {
				rightTrackWheelModel.rotateAngleZ = rotateWheels ? -vehicle.wheelsAngle : 0;
				rightTrackWheelModel.render(f5, oldRotateOrder);
			}
        }

        if(vehicle.isPartIntact(EnumDriveablePart.trailer))
        {
			for (ModelRendererTurbo aTrailerModel : trailerModel) {
				aTrailerModel.render(f5, oldRotateOrder);
			}
        }
                
        //Render guns
        for(EntitySeat seat : vehicle.getSeats())
        {
        	//If the seat has a gun model attached
        	if(seat != null && seat.seatInfo != null && seat.seatInfo.gunName != null && gunModels.get(seat.seatInfo.gunName) != null && vehicle.isPartIntact(seat.seatInfo.part) && !vehicle.rotateWithTurret(seat.seatInfo))
        	{
        		float yaw = seat.prevLooking.getYaw() + (seat.looking.getYaw() - seat.prevLooking.getYaw()) * f;
        		float pitch = seat.prevLooking.getPitch() + (seat.looking.getPitch() - seat.prevLooking.getPitch()) * f;     
        		
        		//Iterate over the parts of that model
        		ModelRendererTurbo[][] gunModel = gunModels.get(seat.seatInfo.gunName);
        		//Yaw only parts
    			for(ModelRendererTurbo gunModelPart : gunModel[0])
    			{
    				//Yaw and render
        			gunModelPart.rotateAngleY = -yaw * 3.14159265F / 180F;
        			gunModelPart.render(f5);
    			}
        		//Yaw and pitch, no recoil parts
    			for(ModelRendererTurbo gunModelPart : gunModel[1])
    			{
    				//Yaw, pitch and render
        			gunModelPart.rotateAngleY = -yaw * 3.14159265F / 180F;
        			gunModelPart.rotateAngleZ = -pitch * 3.14159265F / 180F;
        			gunModelPart.render(f5);
    			}
        		//Yaw, pitch and recoil parts
    			for(ModelRendererTurbo gunModelPart : gunModel[2])
    			{
    				//Yaw, pitch, recoil and render
        			gunModelPart.rotateAngleY = -yaw * 3.14159265F / 180F;
        			gunModelPart.rotateAngleZ = -pitch * 3.14159265F / 180F;
        			gunModelPart.render(f5);
    			}
        	}
        }
	}
		
    /** Render the tank turret 
     * @param dt */
	public void renderTurret(float f, float f1, float f2, float f3, float f4, float f5, EntityVehicle vehicle, float dt)
    {		
		VehicleType type = vehicle.getVehicleType();
		
		//Render main turret barrel
		{
			float yaw = vehicle.getSeats()[0].looking.getYaw();
			float pitch = vehicle.getSeats()[0].looking.getPitch();

			for (ModelRendererTurbo aTurretModel : turretModel) {
				aTurretModel.render(f5, oldRotateOrder);
			}
			for (ModelRendererTurbo aBarrelModel : barrelModel) {
				aBarrelModel.rotateAngleZ = -pitch * 3.14159265F / 180F;
				aBarrelModel.render(f5, oldRotateOrder);
			}
			for(int i = 0; i < ammoModel.length; i++)
			{
				if(i >= type.numMissileSlots || vehicle.getDriveableData().missiles[i] != null)
				{
					for(int j = 0; j < ammoModel[i].length; j++)
					{
						ammoModel[i][j].rotateAngleZ = -pitch * 3.14159265F / 180F;
						ammoModel[i][j].render(f5, oldRotateOrder);
					}
				}
			}
		}
		
        //Render turret guns
        for(EntitySeat seat : vehicle.getSeats())
        {
        	//If the seat has a gun model attached
        	if(seat != null && seat.seatInfo != null && seat.seatInfo.gunName != null && gunModels.get(seat.seatInfo.gunName) != null && vehicle.isPartIntact(seat.seatInfo.part) && vehicle.rotateWithTurret(seat.seatInfo))
        	{
        		EntitySeat driverSeat = vehicle.getSeats()[0];
        		
        		float driverYaw = driverSeat.prevLooking.getYaw() + (driverSeat.looking.getYaw() - driverSeat.prevLooking.getYaw()) * dt;
        		float yaw = seat.prevLooking.getYaw() + (seat.looking.getYaw() - seat.prevLooking.getYaw()) * dt;
        		float pitch = seat.prevLooking.getPitch() + (seat.looking.getPitch() - seat.prevLooking.getPitch()) * dt;     
        		
        		float effectiveYaw = yaw - driverYaw;
        		
        		//Iterate over the parts of that model
        		ModelRendererTurbo[][] gunModel = gunModels.get(seat.seatInfo.gunName);
        		//Yaw only parts
    			for(ModelRendererTurbo gunModelPart : gunModel[0])
    			{
    				//Yaw and render
        			gunModelPart.rotateAngleY = -effectiveYaw * 3.14159265F / 180F;
        			gunModelPart.render(f5, oldRotateOrder);
    			}
        		//Yaw and pitch, no recoil parts
    			for(ModelRendererTurbo gunModelPart : gunModel[1])
    			{
    				//Yaw, pitch and render
        			gunModelPart.rotateAngleY = -effectiveYaw * 3.14159265F / 180F;
        			gunModelPart.rotateAngleZ = -pitch * 3.14159265F / 180F;
        			gunModelPart.render(f5, oldRotateOrder);
    			}
        		//Yaw, pitch and recoil parts
    			for(ModelRendererTurbo gunModelPart : gunModel[2])
    			{
    				//Yaw, pitch, recoil and render
        			gunModelPart.rotateAngleY = -effectiveYaw * 3.14159265F / 180F;
        			gunModelPart.rotateAngleZ = -pitch * 3.14159265F / 180F;
        			gunModelPart.render(f5, oldRotateOrder);
    			}
        	}
        }
    }
	
	public void renderDrillBit(EntityVehicle vehicle, float f) 
	{
        if(vehicle.isPartIntact(EnumDriveablePart.harvester))
        {
			for (ModelRendererTurbo adrillHeadModel : drillHeadModel) {
				adrillHeadModel.render(0.0625F, oldRotateOrder);
			}
        }
	}
	
	@Override
	public void flipAll()
	{
		super.flipAll();
		flip(bodyDoorOpenModel);
		flip(bodyDoorCloseModel);
		flip(turretModel);
		flip(barrelModel);
		flip(leftFrontWheelModel);
		flip(rightFrontWheelModel);
		flip(leftBackWheelModel);
		flip(rightBackWheelModel);
		flip(rightTrackModel);
		flip(leftTrackModel);
		flip(rightTrackWheelModels);
		flip(leftTrackWheelModels);
		flip(trailerModel);
		flip(steeringWheelModel);
		flip(frontWheelModel);
		flip(backWheelModel);
		flip(drillHeadModel);
	}	
	
	@Override
	public void translateAll(float x, float y, float z)
	{
		super.translateAll(x, y, z);
		translate(bodyDoorOpenModel, x, y, z);
		translate(bodyDoorCloseModel, x, y, z);		
		translate(turretModel, x, y, z);
		translate(barrelModel, x, y, z);
		translate(leftFrontWheelModel, x, y, z);
		translate(rightFrontWheelModel, x, y, z);
		translate(leftBackWheelModel, x, y, z);
		translate(rightBackWheelModel, x, y, z);
		translate(rightTrackModel, x, y, z);
		translate(leftTrackModel, x, y, z);
		translate(rightTrackWheelModels, x, y, z);
		translate(leftTrackWheelModels, x, y, z);
		translate(trailerModel, x, y, z);
		translate(steeringWheelModel, x, y, z);
		translate(frontWheelModel, x, y, z);
		translate(backWheelModel, x, y, z);
		translate(drillHeadModel, x, y, z);
	}
}
