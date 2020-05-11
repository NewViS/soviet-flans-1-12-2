package net.lasernet.xuj.carparts;

public enum EnumCarType
{
    OPEL_MANTA("Opel Manta", 0),
    RX7FC("RX7 FC", 1),
    E30("BMW E30", 2),
    E36("BMW E36", 3),
    TRABANT("Trabant", 4),
    JUNIOR("Nissan Junior", 5),
    LAMBO("Lamborghini Huracan", 6),
    MUSTANG1969("Mustang 1969", 7),
    ANY("Any car", -1);

    private String name;
    private int id;

    private EnumCarType(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public int toInt()
    {
        return this.id;
    }

    public static EnumCarType getByID(int id)
    {
        for (EnumCarType enumcartype : values())
        {
            if (enumcartype.id == id)
            {
                return enumcartype;
            }
        }

        return null;
    }
}
