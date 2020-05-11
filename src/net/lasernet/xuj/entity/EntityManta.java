package net.lasernet.xuj.entity;

import java.util.Random;
import net.lasernet.xuj.carparts.CarPartEngine;
import net.lasernet.xuj.carparts.EnumCarType;
import net.minecraft.world.World;

public class EntityManta extends EntityCar
{
    public EntityManta(World worldIn)
    {
        super(worldIn, EnumCarType.OPEL_MANTA);
        this.setSize(2.5F, 1.8F, 2.5F);
        this.color = (new Random()).nextInt(16777215);
        this.deceleration = 1.8F;
    }

    public EntityManta(World worldIn, CarPartEngine engine, int color)
    {
        super(worldIn, EnumCarType.OPEL_MANTA);
        this.setSize(2.5F, 1.8F, 2.5F);
        this.color = color;
        this.deceleration = 1.8F;
        this.engine = engine;
    }

    public float[] getWheelPos()
    {
        return new float[] { -1.65F, 0.4F, 1.05F, -1.65F, 0.4F, -1.05F, 3.33F};
    }

    public float[] getExhaustPos()
    {
        return new float[] {3.1F, 0.5F, 0.5F};
    }

    public float[] getModelInfo()
    {
        return new float[] {0.006F, 0.0F};
    }

    public float[][] getSeatPositions()
    {
        return new float[][] {{0.2F, 0.3F, 0.5F}, {0.2F, 0.3F, -0.5F}, {1.3F, 0.3F, 0.0F}};
    }

    public float[] getEngineOffset()
    {
        return new float[] { -2.0F, 0.6F, 0.0F};
    }
}
