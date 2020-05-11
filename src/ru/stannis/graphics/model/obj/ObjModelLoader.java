package ru.stannis.graphics.model.obj;

import net.minecraft.util.ResourceLocation;
import ru.stannis.graphics.model.IModelCustom;
import ru.stannis.graphics.model.IModelCustomLoader;
import ru.stannis.graphics.model.ModelFormatException;

public class ObjModelLoader implements IModelCustomLoader
{

    @Override
    public String getType()
    {
        return "OBJ model";
    }

    private static final String[] types = { "obj" };
    @Override
    public String[] getSuffixes()
    {
        return types;
    }

    @Override
    public IModelCustom loadInstance(ResourceLocation resource) throws ModelFormatException
    {
        return new WavefrontObject(resource);
    }
}
