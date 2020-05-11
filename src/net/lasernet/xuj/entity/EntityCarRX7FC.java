package net.lasernet.xuj.entity;

import java.util.Random;
import net.lasernet.xuj.carparts.EnumCarType;
import net.minecraft.world.World;

public class EntityCarRX7FC extends EntityCar
{
    public EntityCarRX7FC(World worldIn)
    {
        super(worldIn, EnumCarType.RX7FC);
        this.setSize(2.5F, 1.8F, 2.5F);
        this.color = (new Random()).nextInt(16777215);
        this.deceleration = 1.8F;
        this.maxLeanAngle = 3.0F;
    }

    public float[] getWheelPos()
    {
        return new float[] { -1.8F, 0.45F, 1.05F, -1.8F, 0.45F, -1.05F, 3.55F, 90.0F};
    }

    public float[] getExhaustPos()
    {
        return new float[] {3.1F, 0.5F, 0.8F, 3.1F, 0.5F, -0.8F};
    }

    public float[] getModelInfo()
    {
        return new float[] {1.2F, -90.0F};
    }

    public float[][] getSeatPositions()
    {
        return new float[][] {{0.4F, 0.25F, 0.6F}, {0.4F, 0.25F, -0.6F}};
    }

    public float[] getEngineOffset()
    {
        return new float[] { -2.0F, 0.55F, 0.0F};
    }
}
