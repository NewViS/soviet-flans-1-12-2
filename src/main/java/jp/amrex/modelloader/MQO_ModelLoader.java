package jp.amrex.modelloader;

import net.minecraft.util.ResourceLocation;
import ru.d33.graphics.model.IModelCustom;
import ru.d33.graphics.model.IModelCustomLoader;
import ru.d33.graphics.model.ModelFormatException;

public class MQO_ModelLoader implements IModelCustomLoader
{
	@Override
	public String getType()
	{
		return "Metasequoia model";
	}

	private static final String[] types = { "mqo" };

	@Override
	public String[] getSuffixes()
	{
		return types;
	}

	public IModelCustom loadInstance(ResourceLocation resource) throws ModelFormatException
	{
		return new MQO_MetasequoiaObject(resource);
	}
}
