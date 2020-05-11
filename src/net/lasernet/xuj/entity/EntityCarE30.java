package net.lasernet.xuj.entity;

import java.util.Random;
import net.lasernet.xuj.carparts.EnumCarType;
import net.minecraft.world.World;

public class EntityCarE30 extends EntityCar
{
    public EntityCarE30(World worldIn)
    {
        super(worldIn, EnumCarType.E30);
        this.setSize(2.5F, 1.8F, 2.5F);
        this.color = (new Random()).nextInt(16777215);
        this.deceleration = 1.8F;
        this.maxLeanAngle = 3.0F;
    }

    public float[] getWheelPos()
    {
        return new float[] { -1.75F, 0.45F, 0.9F, -1.75F, 0.45F, -1.1F, 3.6F, 90.0F};
    }

    public float[] getExhaustPos()
    {
        return new float[] {3.5F, 0.6F, 0.62F};
    }

    public float[] getModelInfo()
    {
        return new float[] {0.0034F, 90.0F, 0.2F};
    }

    public float[][] getSeatPositions()
    {
        return new float[][] {{0.3F, 0.3F, 0.45F}, {0.3F, 0.3F, -0.45F}};
    }

    public float[] getEngineOffset()
    {
        return new float[] { -2.0F, 0.6F, -0.15F};
    }
}
