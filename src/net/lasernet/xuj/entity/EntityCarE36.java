package net.lasernet.xuj.entity;

import java.util.Random;
import net.lasernet.xuj.carparts.EnumCarType;
import net.minecraft.world.World;

public class EntityCarE36 extends EntityCar
{
    public EntityCarE36(World worldIn)
    {
        super(worldIn, EnumCarType.E36);
        this.setSize(2.5F, 1.8F, 2.5F);
        this.color = (new Random()).nextInt(16777215);
        this.deceleration = 1.8F;
        this.maxLeanAngle = 3.0F;
    }

    public float[] getWheelPos()
    {
        return new float[] { -1.82F, 0.41F, 0.96F, -1.82F, 0.41F, -1.02F, 3.75F, -90.0F};
    }

    public float[] getExhaustPos()
    {
        return new float[] {3.25F, 0.5F, 0.65F};
    }

    public float[] getModelInfo()
    {
        return new float[] {0.0025F, -90.0F, -0.05F};
    }

    public float[][] getSeatPositions()
    {
        return new float[][] {{0.3F, 0.2F, 0.5F}, {0.3F, 0.2F, -0.5F}, {1.5F, 0.2F, 0.5F}, {1.5F, 0.2F, -0.5F}};
    }

    public float[] getEngineOffset()
    {
        return new float[] { -2.0F, 0.46F, 0.0F};
    }
}
