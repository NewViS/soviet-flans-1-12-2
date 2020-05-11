package jp.amrex.modelloader;

import ru.d33.graphics.model.obj.Side;
import ru.d33.graphics.model.obj.SideOnly;

@SideOnly(Side.CLIENT)
public class MQO_TextureCoordinate
{
	public float u, v, w;

	public MQO_TextureCoordinate(float u, float v)
	{
		this(u, v, 0F);
	}

	public MQO_TextureCoordinate(float u, float v, float w)
	{
		this.u = u;
		this.v = v;
		this.w = w;
	}
}
