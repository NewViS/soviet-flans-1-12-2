package jp.amrex.modelloader;

import java.util.ArrayList;

import ru.d33.graphics.model.obj.Side;
import ru.d33.graphics.model.obj.SideOnly;
import ru.d33.graphics.model.obj.Tessellator;

@SideOnly(Side.CLIENT)
public class MQO_GroupObject
{
	public String name;
	public ArrayList<MQO_Face> faces = new ArrayList<MQO_Face>();
	public int glDrawingMode;

	public MQO_GroupObject()
	{
		this("");
	}

	public MQO_GroupObject(String name)
	{
		this(name, -1);
	}

	public MQO_GroupObject(String name, int glDrawingMode)
	{
		this.name = name;
		this.glDrawingMode = glDrawingMode;
	}

	public void render()
	{
		if (faces.size() > 0)
		{
			Tessellator tessellator = Tessellator.instance;
			tessellator.startDrawing(glDrawingMode);
			render(tessellator);
			tessellator.draw();
		}
	}

	public void render(Tessellator tessellator)
	{
		if (faces.size() > 0)
		{
			for (MQO_Face face : faces)
			{
				face.addFaceForRender(tessellator);
			}
		}
	}
}
