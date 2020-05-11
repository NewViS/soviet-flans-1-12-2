package net.lasernet.xuj.entity;

import java.util.Random;
import net.lasernet.xuj.carparts.EnumCarType;
import net.minecraft.world.World;

public class EntityCarNissanJunior extends EntityCar
{
    public EntityCarNissanJunior(World worldIn)
    {
        super(worldIn, EnumCarType.JUNIOR);
        this.setSize(2.5F, 1.8F, 2.5F);
        this.color = (new Random()).nextInt(16777215);
        this.deceleration = 1.8F;
        this.stepHeight = 0.5F;
    }

    public float[] getWheelPos()
    {
        return new float[] { -2.3F, 0.45F, 0.96F, -2.3F, 0.45F, -1.02F, 3.9F, -90.0F};
    }

    public float[] getExhaustPos()
    {
        return new float[] {3.3F, 0.5F, 0.65F};
    }

    public float[] getModelInfo()
    {
        return new float[] {0.045F, 180.0F, -0.05F};
    }

    public float[][] getSeatPositions()
    {
        return new float[][] {{ -0.7F, 0.5F, 0.4F}, { -0.7F, 0.5F, -0.4F}};
    }

    public float[] getEngineOffset()
    {
        return new float[] { -3.0F, 1.0F, -0.15F};
    }
}
