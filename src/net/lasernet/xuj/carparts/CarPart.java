package net.lasernet.xuj.carparts;

import java.util.ArrayList;
import java.util.List;
import net.lasernet.xuj.ModItems;
import net.lasernet.xuj.entity.RenderCar;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CarPart
{
    public static List<CarPart> partList = new ArrayList<CarPart>();
    @SideOnly(Side.CLIENT)
    public IBakedModel model;
    @SideOnly(Side.CLIENT)
    public OBJModel objmodel;
    public String title;
    public String description;
    public EnumCarType carFor;
    protected int color = 16777215;
    protected boolean shouldBodyColor = false;
    protected float[] modelinfo;
    protected EnumCarPartType partType = EnumCarPartType.DEFAULT;

    public static void init()
    {
        partList.add(new CarPart("Chrome Trim", EnumCarType.OPEL_MANTA, "Default Chrome Parts"));
        partList.add(new CarPart("Head Lights", EnumCarType.OPEL_MANTA, "Front lights including fog lights"));
        partList.add(new CarPart("Tail Lights", EnumCarType.OPEL_MANTA, "Tail lights"));
        partList.add(new CarPart("Windows", EnumCarType.OPEL_MANTA, "Windshield, rear and side windows"));
        partList.add((new CarPartEngine("2.0L Engine", "150HP", 150, 1.8F, 0.2F, 1.0F)).setModelInfo(new float[] {0.8F, 0.0F, 0.0F, 0.0F, -90.0F}));
        partList.add((new CarPartEngine("5.0L V8 Engine", "NA, 350HP", 350, 1.9F, 0.8F, 1.2F)).setModelInfo(new float[] {0.5F, -1.0F, 0.45F, 0.0F, 90.0F}));
        partList.add((new CarPartEngine("5.0L V8 Blower Engine", "Blower, 600HP", 600, 2.0F, 1.0F, 1.8F)).setModelInfo(new float[] {0.5F, -1.0F, 0.3F, 0.0F, 90.0F}));
        partList.add(new CarPart("Windshield", EnumCarType.RX7FC, "Windshield only"));
        partList.add(new CarPart("Rear Window", EnumCarType.RX7FC, "Rear Window"));
        partList.add(new CarPart("Sunroof", EnumCarType.RX7FC, "Windshield only"));
        partList.add((new CarPart("Wing", EnumCarType.RX7FC, "The RX7 Rear wing")).setShouldBodyColor(true));
        partList.add((new CarPartEngine("Rotary Engine", "3Rotor, 220HP", 220, 2.2F, 0.6F, 1.6F)).setModelInfo(new float[] {0.8F, 0.0F, 0.1F, 0.0F, -90.0F}));
        partList.add(new CarPart("Windshield", EnumCarType.E30, "Windshield"));
        partList.add((new CarPart("Front Bumper", EnumCarType.E30, "Front Bumper")).setShouldBodyColor(true));
        partList.add((new CarPart("Rear Bumper", EnumCarType.E30, "Rear Bumper")).setShouldBodyColor(true));
        partList.add((new CarPart("Wing", EnumCarType.E30, "Small rear wing")).setShouldBodyColor(true));
        partList.add(new CarPart("Windows", EnumCarType.E36, "Front Windows and winshield"));
        partList.add((new CarPart("Front Bumper", EnumCarType.E36, "Front Bumper")).setShouldBodyColor(true));
        partList.add((new CarPart("Rear Bumper", EnumCarType.E36, "Rear Bumper")).setShouldBodyColor(true));
        partList.add((new CarPart("Wing", EnumCarType.OPEL_MANTA, "Racing wing")).setShouldBodyColor(true));
        partList.add((new CarPart("Bumpers", EnumCarType.TRABANT, "Front and rear Bumper")).setShouldBodyColor(true));
        partList.add(new CarPart("Rollcage", EnumCarType.TRABANT, "A bunch of pipes"));
        partList.add((new CarPart("Hood", EnumCarType.E36, "Hood")).setShouldBodyColor(true));
        partList.add((new CarPartEngine("2JZ", "220HP", 220, 2.2F, 1.0F, 1.7F)).setModelInfo(new float[] {0.042F, -45.0F, 2.6F, -3.0F, -90.0F}));
        partList.add(new CarPartWheels("Steelies", 0.013F)
        {
            public void rotateWheel(int index, float steeringAngle, boolean spin, float speed)
            {
                if (index == 0)
                {
                    GlStateManager.rotate(steeringAngle, 0.0F, 1.0F, 0.0F);
                    GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);

                    if (spin)
                    {
                        GlStateManager.rotate(speed, 0.0F, 0.0F, -1.0F);
                    }
                }
                else if (index == 1)
                {
                    GlStateManager.rotate(steeringAngle, 0.0F, 1.0F, 0.0F);

                    if (spin)
                    {
                        GlStateManager.rotate(speed, 0.0F, 0.0F, 1.0F);
                    }
                }
                else if (index == 2)
                {
                    GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);

                    if (spin)
                    {
                        GlStateManager.rotate(speed, 0.0F, 0.0F, -1.0F);
                    }
                }
                else if (index == 3 && spin)
                {
                    GlStateManager.rotate(speed, 0.0F, 0.0F, 1.0F);
                }
            }
        });
        partList.add(new CarPartWheels("Mantas", 0.0065F)
        {
            public void rotateWheel(int index, float steeringAngle, boolean spin, float speed)
            {
                if (index == 0)
                {
                    GlStateManager.rotate(steeringAngle, 0.0F, 1.0F, 0.0F);

                    if (spin)
                    {
                        GlStateManager.rotate(speed, 0.0F, 0.0F, 1.0F);
                    }
                }
                else if (index == 1)
                {
                    GlStateManager.rotate(steeringAngle, 0.0F, 1.0F, 0.0F);
                    GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);

                    if (spin)
                    {
                        GlStateManager.rotate(speed, 0.0F, 0.0F, -1.0F);
                    }
                }
                else if (index == 2)
                {
                    if (spin)
                    {
                        GlStateManager.rotate(speed, 0.0F, 0.0F, 1.0F);
                    }
                }
                else if (index == 3)
                {
                    GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);

                    if (spin)
                    {
                        GlStateManager.rotate(speed, 0.0F, 0.0F, -1.0F);
                    }
                }
            }
        });
        partList.add(new CarPartWheels("RX7 Wheels", 1.3F)
        {
            public void rotateWheel(int index, float steeringAngle, boolean spin, float speed)
            {
                if (index == 0)
                {
                    GlStateManager.rotate(steeringAngle, 0.0F, 1.0F, 0.0F);
                    GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);

                    if (spin)
                    {
                        GlStateManager.rotate(speed, -1.0F, 0.0F, 0.0F);
                    }
                }
                else if (index == 1)
                {
                    GlStateManager.rotate(steeringAngle, 0.0F, 1.0F, 0.0F);
                    GlStateManager.rotate(270.0F, 0.0F, 1.0F, 0.0F);

                    if (spin)
                    {
                        GlStateManager.rotate(speed, 1.0F, 0.0F, 0.0F);
                    }
                }
                else if (index == 2)
                {
                    GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);

                    if (spin)
                    {
                        GlStateManager.rotate(speed, -1.0F, 0.0F, 0.0F);
                    }
                }
                else if (index == 3)
                {
                    GlStateManager.rotate(270.0F, 0.0F, 1.0F, 0.0F);

                    if (spin)
                    {
                        GlStateManager.rotate(speed, 1.0F, 0.0F, 0.0F);
                    }
                }
            }
        });
        partList.add(new CarPartWheels("Truck wheels", 0.045F)
        {
            public void rotateWheel(int index, float steeringAngle, boolean spin, float speed)
            {
                if (index == 0)
                {
                    GlStateManager.rotate(steeringAngle, 0.0F, 1.0F, 0.0F);

                    if (spin)
                    {
                        GlStateManager.rotate(speed, 0.0F, 0.0F, 1.0F);
                    }
                }
                else if (index == 1)
                {
                    GlStateManager.rotate(steeringAngle, 0.0F, 1.0F, 0.0F);
                    GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);

                    if (spin)
                    {
                        GlStateManager.rotate(speed, 0.0F, 0.0F, -1.0F);
                    }
                }
                else if (index == 2)
                {
                    if (spin)
                    {
                        GlStateManager.rotate(speed, 0.0F, 0.0F, 1.0F);
                    }
                }
                else if (index == 3)
                {
                    GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);

                    if (spin)
                    {
                        GlStateManager.rotate(speed, 0.0F, 0.0F, -1.0F);
                    }
                }
            }
        });
        partList.add((new CarPart("Bumpers", EnumCarType.JUNIOR, "Front and rear Bumper")).setShouldBodyColor(true));
        partList.add(new CarPart("Roll bar", EnumCarType.JUNIOR, "A bunch of pipes"));
        partList.add((new CarPart("Hood", EnumCarType.MUSTANG1969, "Hood")).setShouldBodyColor(true));
        partList.add(new CarPartWheels("Muscle wheels", 0.014F)
        {
            public void rotateWheel(int index, float steeringAngle, boolean spin, float speed)
            {
                if (index == 0)
                {
                    GlStateManager.rotate(steeringAngle, 0.0F, 1.0F, 0.0F);

                    if (spin)
                    {
                        GlStateManager.rotate(speed, 0.0F, 0.0F, 1.0F);
                    }
                }
                else if (index == 1)
                {
                    GlStateManager.rotate(steeringAngle, 0.0F, 1.0F, 0.0F);
                    GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);

                    if (spin)
                    {
                        GlStateManager.rotate(speed, 0.0F, 0.0F, -1.0F);
                    }
                }
                else if (index == 2)
                {
                    if (spin)
                    {
                        GlStateManager.rotate(speed, 0.0F, 0.0F, 1.0F);
                    }
                }
                else if (index == 3)
                {
                    GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);

                    if (spin)
                    {
                        GlStateManager.rotate(speed, 0.0F, 0.0F, -1.0F);
                    }
                }
            }
        });
    }

    public CarPart(String title, EnumCarType carFor, String description)
    {
        this.title = title;
        this.carFor = carFor;
        this.description = description;
    }

    public static int getID(CarPart p)
    {
        return partList.indexOf(p);
    }

    public float[] getModelInfo()
    {
        return this.modelinfo;
    }

    public CarPart setModelInfo(float[] modelinfo)
    {
        this.modelinfo = modelinfo;
        return this;
    }

    public CarPart setShouldBodyColor(boolean b)
    {
        this.shouldBodyColor = b;
        return this;
    }

    public boolean shouldBodyColor()
    {
        return this.shouldBodyColor;
    }

    @SideOnly(Side.CLIENT)
    public void setModel(OBJModel objmodel)
    {
        this.objmodel = objmodel;
    }

    @SideOnly(Side.CLIENT)
    public IBakedModel getModel()
    {
        if (this.model == null)
        {
            this.model = this.objmodel.bake(this.objmodel.getDefaultState(), DefaultVertexFormats.ITEM, RenderCar.dtg);
        }

        return this.model;
    }

    @SideOnly(Side.CLIENT)
    public boolean isRenderable()
    {
        return this.objmodel != null;
    }

    public static int[] generalCarPartIDs()
    {
        List<Integer> list = new ArrayList<Integer>();

        for (CarPart carpart : partList)
        {
            if (!(carpart instanceof CarPartEngine))
            {
                list.add(Integer.valueOf(getID(carpart)));
            }
        }

        int[] aint = new int[list.size()];

        for (int i = 0; i < aint.length; ++i)
        {
            aint[i] = ((Integer)list.get(i)).intValue();
        }

        return aint;
    }

    public static int[] engineIDs()
    {
        List<Integer> list = new ArrayList<Integer>();

        for (CarPart carpart : partList)
        {
            if (carpart instanceof CarPartEngine)
            {
                list.add(Integer.valueOf(getID(carpart)));
            }
        }

        int[] aint = new int[list.size()];

        for (int i = 0; i < aint.length; ++i)
        {
            aint[i] = ((Integer)list.get(i)).intValue();
        }

        return aint;
    }

    public static List<ItemStack> getGeneralStacks()
    {
        List<ItemStack> list = new ArrayList<ItemStack>();

        for (CarPart carpart : partList)
        {
            if (carpart instanceof CarPartWheels)
            {
                list.add(new ItemStack(ModItems.itemWheels, 1, getID(carpart) + 1));
            }
            else if (!(carpart instanceof CarPartEngine))
            {
                list.add(new ItemStack(ModItems.itemCarPart, 1, getID(carpart) + 1));
            }
        }

        return list;
    }

    public static ItemStack getItemStack(CarPart p)
    {
        if (p instanceof CarPartEngine)
        {
            return new ItemStack(ModItems.itemEngine, 1, getID(p) + 1);
        }
        else
        {
            return p instanceof CarPartWheels ? new ItemStack(ModItems.itemWheels, 1, getID(p) + 1) : new ItemStack(ModItems.itemCarPart, 1, getID(p) + 1);
        }
    }

    public EnumCarPartType getPartType()
    {
        return this.partType;
    }

    public CarPart setPartType(EnumCarPartType partType)
    {
        this.partType = partType;
        return this;
    }

    public CarPart get(int i)
    {
        return partList.get(i);
    }
}
