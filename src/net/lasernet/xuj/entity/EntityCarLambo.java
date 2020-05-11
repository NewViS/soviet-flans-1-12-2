package net.lasernet.xuj.entity;

import java.util.Random;
import net.lasernet.xuj.carparts.EnumCarType;
import net.minecraft.world.World;

public class EntityCarLambo extends EntityCar
{
    public EntityCarLambo(World worldIn)
    {
        super(worldIn, EnumCarType.LAMBO);
        this.setSize(2.5F, 1.8F, 2.5F);
        this.color = (new Random()).nextInt(16777215);
        this.deceleration = 1.8F;
        this.isRearEngined = true;
        this.stepHeight = 0.25F;
        this.maxLeanAngle = 2.0F;
    }

    public float[] getWheelPos()
    {
        return new float[] { -1.7F, 0.45F, 1.15F, -1.7F, 0.45F, -1.15F, 3.63F};
    }

    public float[] getExhaustPos()
    {
        return new float[] {3.1F, 0.7F, 0.6F, 3.1F, 0.7F, -0.6F};
    }

    public float[] getModelInfo()
    {
        return new float[] {0.014F, 0.0F, -0.05F};
    }

    public float[][] getSeatPositions()
    {
        return new float[][] {{ -0.3F, 0.0F, 0.57F}, { -0.3F, 0.0F, -0.57F}};
    }

    public float[] getEngineOffset()
    {
        return new float[] {1.0F, 0.5F, 0.0F};
    }
}
