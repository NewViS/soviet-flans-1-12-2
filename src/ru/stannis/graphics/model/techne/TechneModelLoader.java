package ru.stannis.graphics.model.techne;

import net.minecraft.util.ResourceLocation;
import ru.stannis.graphics.model.IModelCustom;
import ru.stannis.graphics.model.IModelCustomLoader;
import ru.stannis.graphics.model.ModelFormatException;

public class TechneModelLoader implements IModelCustomLoader {
    
    @Override
    public String getType()
    {
        return "Techne model";
    }

    private static final String[] types = { "tcn" };
    @Override
    public String[] getSuffixes()
    {
        return types;
    }

    @Override
    public IModelCustom loadInstance(ResourceLocation resource) throws ModelFormatException
    {
        return new TechneModel(resource);
    }

}
