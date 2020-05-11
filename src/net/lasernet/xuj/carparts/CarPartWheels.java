package net.lasernet.xuj.carparts;

public abstract class CarPartWheels extends CarPart
{
    public CarPartWheels(String title, float scale)
    {
        super(title, EnumCarType.ANY, "Wheels: " + title);
        this.modelinfo = new float[] {scale};
    }

    public abstract void rotateWheel(int var1, float var2, boolean var3, float var4);
}
