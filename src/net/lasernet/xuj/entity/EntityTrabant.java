package net.lasernet.xuj.entity;

import java.util.Random;
import net.lasernet.xuj.carparts.EnumCarType;
import net.minecraft.world.World;

public class EntityTrabant extends EntityCar
{
    public EntityTrabant(World worldIn)
    {
        super(worldIn, EnumCarType.TRABANT);
        this.setSize(2.2F, 1.8F, 2.2F);
        this.color = (new Random()).nextInt(16777215);
        this.deceleration = 1.8F;
    }

    public float[] getWheelPos()
    {
        return new float[] { -1.62F, 0.41F, 0.9F, -1.62F, 0.41F, -0.9F, 2.9F, 180.0F};
    }

    public float[] getExhaustPos()
    {
        return new float[] {2.5F, 0.5F, 0.5F};
    }

    public float[] getModelInfo()
    {
        return new float[] {0.0125F, 0.0F};
    }

    public float[][] getSeatPositions()
    {
        return new float[][] {{0.2F, 0.3F, 0.37F}, {0.2F, 0.3F, -0.37F}, {1.3F, 0.3F, 0.0F}};
    }

    public float[] getEngineOffset()
    {
        return new float[] { -2.0F, 0.5F, 0.0F};
    }
}
