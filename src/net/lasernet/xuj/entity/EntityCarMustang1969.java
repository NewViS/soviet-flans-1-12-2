package net.lasernet.xuj.entity;

import java.util.Random;
import net.lasernet.xuj.carparts.EnumCarType;
import net.minecraft.world.World;

public class EntityCarMustang1969 extends EntityCar
{
    public EntityCarMustang1969(World worldIn)
    {
        super(worldIn, EnumCarType.MUSTANG1969);
        this.setSize(2.5F, 1.8F, 2.5F);
        this.color = (new Random()).nextInt(16777215);
        this.deceleration = 1.8F;
        this.stepHeight = 0.25F;
    }

    public float[] getWheelPos()
    {
        return new float[] { -1.75F, 0.45F, 0.97F, -1.75F, 0.45F, -0.97F, 3.35F};
    }

    public float[] getExhaustPos()
    {
        return new float[] {2.9F, 0.7F, 0.85F, 2.9F, 0.7F, -0.85F};
    }

    public float[] getModelInfo()
    {
        return new float[] {0.014F, 0.0F, 0.0F};
    }

    public float[][] getSeatPositions()
    {
        return new float[][] {{0.2F, 0.1F, 0.5F}, {0.2F, 0.1F, -0.5F}};
    }

    public float[] getEngineOffset()
    {
        return new float[] { -2.0F, 0.6F, 0.0F};
    }
}
