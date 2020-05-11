package net.lasernet.xuj.entity;

import com.google.common.base.Function;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import javax.annotation.Nullable;
import net.lasernet.xuj.carparts.CarPart;
import net.lasernet.xuj.carparts.CarPartEngine;
import net.lasernet.xuj.carparts.CarPartWheels;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.client.model.pipeline.LightUtil;
import org.lwjgl.BufferUtils;

public class RenderCar extends Render<EntityCar>
{
    public OBJModel model;
    private IBakedModel ibakedmodel;
    private IBakedModel required;
    public static final RenderCar.DefaultTextureGetter dtg = new RenderCar.DefaultTextureGetter();

    public RenderCar(RenderManager renderManager, OBJModel model)
    {
        super(renderManager);
        this.model = model;
        this.ibakedmodel = model.bake(model.getDefaultState(), DefaultVertexFormats.ITEM, dtg);
    }

    protected ResourceLocation getEntityTexture(EntityCar entity)
    {
        return new ResourceLocation("xujmod:blocks/ic2conduit");
    }

    public void doRender(EntityCar entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        try
        {
            this.rend(entity, x, y, z, entityYaw, partialTicks);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void rend(EntityCar entity, double x, double y, double z, float entityYaw, float partialTicks) throws Exception
    {
        if (entity != null)
        {
            float f = (float)(Minecraft.getSystemTime() / 10L) * entity.getAccelerationTick();
            GlStateManager.pushMatrix();

            if (this.renderOutlines)
            {
                GlStateManager.enableColorMaterial();
                GlStateManager.enableOutlineMode(this.getTeamColor(entity));
            }

            GlStateManager.disableCull();
            GlStateManager.disableAlpha();
            GlStateManager.disableBlend();
            GlStateManager.enableNormalize();
            GlStateManager.disableTexture2D();

            if (entity.getModelInfo().length > 2)
            {
                GlStateManager.translate((float)x, (float)y + entity.getModelInfo()[2], (float)z);
            }
            else
            {
                GlStateManager.translate((float)x, (float)y, (float)z);
            }

            GlStateManager.scale(entity.getModelInfo()[0], entity.getModelInfo()[0], entity.getModelInfo()[0]);
            GlStateManager.rotate(entityYaw + entity.getModelInfo()[1], 0.0F, 1.0F, 0.0F);

            if (entity.getModelInfo()[1] % 180.0F == 0.0F && entity.getModelInfo()[1] != 0.0F)
            {
                GlStateManager.rotate(entity.rotX, 0.0F, 0.0F, 1.0F);
                GlStateManager.rotate(entity.rotZ, 1.0F, 0.0F, 0.0F);
            }
            else if (entity.getModelInfo()[1] == 0.0F)
            {
                GlStateManager.rotate(entity.rotX, 0.0F, 0.0F, -1.0F);
                GlStateManager.rotate(entity.rotZ, -1.0F, 0.0F, 0.0F);
            }
            else if (entity.getModelInfo()[1] == 90.0F)
            {
                GlStateManager.rotate(entity.rotX, -1.0F, 0.0F, 0.0F);
                GlStateManager.rotate(entity.rotZ, 0.0F, 0.0F, -1.0F);
            }
            else
            {
                GlStateManager.rotate(entity.rotX, 1.0F, 0.0F, 0.0F);
                GlStateManager.rotate(entity.rotZ, 0.0F, 0.0F, 1.0F);
            }

            if (this.required != null)
            {
                this.renderModel(this.required, 16777215);
            }

            this.renderModel(this.ibakedmodel, entity.getColor());

            try
            {
                for (CarPart carpart : entity.getCarParts())
                {
                    if (carpart.isRenderable() && !(carpart instanceof CarPartEngine) && !(carpart instanceof CarPartWheels))
                    {
                        if (carpart.shouldBodyColor())
                        {
                            this.renderModel(carpart.getModel(), entity.getColor());
                        }
                        else
                        {
                            this.renderModel(carpart.getModel(), 16777215);
                        }
                    }
                }
            }
            catch (ConcurrentModificationException var15)
            {
                ;
            }

            if (this.renderOutlines)
            {
                GlStateManager.disableOutlineMode();
                GlStateManager.disableColorMaterial();
            }

            GlStateManager.enableTexture2D();
            GlStateManager.popMatrix();

            if (entity.engine != null)
            {
                GlStateManager.pushMatrix();
                GlStateManager.disableCull();
                GlStateManager.disableAlpha();
                GlStateManager.disableBlend();
                GlStateManager.enableNormalize();
                GlStateManager.disableTexture2D();
                GlStateManager.translate((float)x, (float)y, (float)z);
                GlStateManager.rotate(entityYaw, 0.0F, 1.0F, 0.0F);
                GlStateManager.rotate(entity.rotX, 0.0F, 0.0F, -1.0F);
                GlStateManager.rotate(entity.rotZ, -1.0F, 0.0F, 0.0F);
                GlStateManager.scale(entity.engine.getModelInfo()[0], entity.engine.getModelInfo()[0], entity.engine.getModelInfo()[0]);

                if (entity.isRearEngined)
                {
                    GlStateManager.translate(-entity.engine.getModelInfo()[1], entity.engine.getModelInfo()[2], entity.engine.getModelInfo()[3]);
                }
                else
                {
                    GlStateManager.translate(entity.engine.getModelInfo()[1], entity.engine.getModelInfo()[2], entity.engine.getModelInfo()[3]);
                }

                if (entity.getEngineOffset() != null)
                {
                    GlStateManager.translate(entity.getEngineOffset()[0], entity.getEngineOffset()[1], entity.getEngineOffset()[2]);
                }

                GlStateManager.rotate(entity.engine.getModelInfo()[4], 0.0F, 1.0F, 0.0F);
                this.renderModel(entity.engine.getModel(), 16777215);
                GlStateManager.enableTexture2D();
                GlStateManager.popMatrix();
            }

            CarPartWheels carpartwheels = null;

            try
            {
                for (CarPart carpart1 : entity.getCarParts())
                {
                    if (carpart1 instanceof CarPartWheels)
                    {
                        carpartwheels = (CarPartWheels)carpart1;
                        break;
                    }
                }
            }
            catch (ConcurrentModificationException var14)
            {
                ;
            }

            if (carpartwheels != null)
            {
                GlStateManager.pushMatrix();
                GlStateManager.translate(x, y, z);
                GlStateManager.rotate(entityYaw, 0.0F, 1.0F, 0.0F);
                GlStateManager.translate(entity.getWheelPos()[0], entity.getWheelPos()[1], entity.getWheelPos()[2]);
                carpartwheels.rotateWheel(0, entity.getSteeringAngle(), entity.getAccelerationTick() != 0.0F && !entity.isBurnout() && entity.engine != null, f);
                GlStateManager.disableCull();
                GlStateManager.disableAlpha();
                GlStateManager.enableNormalize();
                GlStateManager.disableTexture2D();
                GlStateManager.scale(carpartwheels.getModelInfo()[0], carpartwheels.getModelInfo()[0], carpartwheels.getModelInfo()[0]);
                this.renderModel(carpartwheels.getModel(), 16777215);
                GlStateManager.popMatrix();
                GlStateManager.pushMatrix();
                GlStateManager.translate(x, y, z);
                GlStateManager.rotate(entityYaw, 0.0F, 1.0F, 0.0F);
                GlStateManager.translate(entity.getWheelPos()[3], entity.getWheelPos()[4], entity.getWheelPos()[5]);
                carpartwheels.rotateWheel(1, entity.getSteeringAngle(), entity.getAccelerationTick() != 0.0F && !entity.isBurnout() && entity.engine != null, f);
                GlStateManager.disableCull();
                GlStateManager.disableAlpha();
                GlStateManager.enableNormalize();
                GlStateManager.disableTexture2D();
                GlStateManager.scale(carpartwheels.getModelInfo()[0], carpartwheels.getModelInfo()[0], carpartwheels.getModelInfo()[0]);
                this.renderModel(carpartwheels.getModel(), 16777215);
                GlStateManager.popMatrix();
                GlStateManager.pushMatrix();
                GlStateManager.translate(x, y, z);
                GlStateManager.rotate(entityYaw, 0.0F, 1.0F, 0.0F);
                GlStateManager.translate(entity.getWheelPos()[0] + entity.getWheelPos()[6], entity.getWheelPos()[1], entity.getWheelPos()[2]);
                carpartwheels.rotateWheel(2, entity.getSteeringAngle(), entity.getAccelerationTick() != 0.0F && entity.engine != null, f);
                GlStateManager.disableCull();
                GlStateManager.disableAlpha();
                GlStateManager.enableNormalize();
                GlStateManager.disableTexture2D();
                GlStateManager.scale(carpartwheels.getModelInfo()[0], carpartwheels.getModelInfo()[0], carpartwheels.getModelInfo()[0]);
                this.renderModel(carpartwheels.getModel(), 16777215);
                GlStateManager.popMatrix();
                GlStateManager.pushMatrix();
                GlStateManager.translate(x, y, z);
                GlStateManager.rotate(entityYaw, 0.0F, 1.0F, 0.0F);
                GlStateManager.translate(entity.getWheelPos()[3] + entity.getWheelPos()[6], entity.getWheelPos()[4], entity.getWheelPos()[5]);
                carpartwheels.rotateWheel(3, entity.getSteeringAngle(), entity.getAccelerationTick() != 0.0F && entity.engine != null, f);
                GlStateManager.disableCull();
                GlStateManager.disableAlpha();
                GlStateManager.enableNormalize();
                GlStateManager.disableTexture2D();
                GlStateManager.scale(carpartwheels.getModelInfo()[0], carpartwheels.getModelInfo()[0], carpartwheels.getModelInfo()[0]);
                this.renderModel(carpartwheels.getModel(), 16777215);
                GlStateManager.enableTexture2D();
                GlStateManager.popMatrix();
            }

            super.doRender(entity, x, y, z, entityYaw, partialTicks);
        }
    }

    public RenderCar addRequred(OBJModel mdl)
    {
        try
        {
            this.required = mdl.bake(mdl.getDefaultState(), DefaultVertexFormats.ITEM, dtg);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return this;
    }

    public FloatBuffer floatBuffer(float a, float b, float c, float d)
    {
        float[] afloat = new float[] {a, b, c, d};
        FloatBuffer floatbuffer = BufferUtils.createFloatBuffer(afloat.length);
        floatbuffer.put(afloat);
        floatbuffer.flip();
        return floatbuffer;
    }

    private void renderModel(IBakedModel model, int color)
    {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.ITEM);

        for (EnumFacing enumfacing : EnumFacing.values())
        {
            this.renderQuads(bufferbuilder, model.getQuads((IBlockState)null, enumfacing, 0L), color, (ItemStack)null);
        }

        this.renderQuads(bufferbuilder, model.getQuads((IBlockState)null, (EnumFacing)null, 0L), color, (ItemStack)null);
        tessellator.draw();
    }

    private void renderQuads(BufferBuilder vertexbuffer, List<BakedQuad> quads, int color, @Nullable ItemStack stack)
    {
        boolean flag = color == -1 && stack != null;
        int i = 0;

        for (int j = quads.size(); i < j; ++i)
        {
            BakedQuad bakedquad = quads.get(i);
            int k = color;

            if (flag && bakedquad.hasTintIndex())
            {
                k = 16777215;

                if (EntityRenderer.anaglyphEnable)
                {
                    k = TextureUtil.anaglyphColor(k);
                }

                k = k | -16777216;
            }

            LightUtil.renderQuadColor(vertexbuffer, bakedquad, k);
        }
    }

    public void setupRotation(EntityManta p_188311_1_, float p_188311_2_, float p_188311_3_)
    {
        GlStateManager.rotate(180.0F - p_188311_2_, 0.0F, 1.0F, 0.0F);
        GlStateManager.scale(-1.0F, -1.0F, 1.0F);
    }

    public void setupTranslation(double p_188309_1_, double p_188309_3_, double p_188309_5_)
    {
        GlStateManager.translate((float)p_188309_1_, (float)p_188309_3_ + 0.375F, (float)p_188309_5_);
    }

    public static class DefaultTextureGetter implements Function<ResourceLocation, TextureAtlasSprite>
    {
        public TextureAtlasSprite apply(ResourceLocation location)
        {
            return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite("missingno");
        }
    }
}
