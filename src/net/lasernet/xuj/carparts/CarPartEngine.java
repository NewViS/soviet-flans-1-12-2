package net.lasernet.xuj.carparts;

public class CarPartEngine extends CarPart
{
    private int horsepower = 0;
    private float topSpeed = 0.0F;
    private float millageCoef = 1.0F;
    private float burnoutMax = 0.0F;

    public CarPartEngine(String title, String description, int horsepower, float topSpeed, float burnoutMax, float millageCoef)
    {
        super(title, EnumCarType.ANY, description);
        this.horsepower = horsepower;
        this.topSpeed = topSpeed;
        this.burnoutMax = burnoutMax;
        this.millageCoef = millageCoef;
        this.partType = EnumCarPartType.ENGINE;
    }

    public float getBurnoutMax()
    {
        return this.burnoutMax;
    }

    public int getHorsepower()
    {
        return this.horsepower;
    }

    public float getTopSpeed()
    {
        return this.topSpeed;
    }

    public float getMillageCoef()
    {
        return this.millageCoef;
    }
}
