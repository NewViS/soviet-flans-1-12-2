package net.lasernet.graphics;

import com.google.common.base.Function;
import java.util.List;
import javax.annotation.Nullable;
import net.lasernet.xuj.blocks.TileEntityEngineHoist;
import net.lasernet.xuj.carparts.CarPartEngine;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.client.model.pipeline.LightUtil;

public class RenderEngineHoist extends TileEntitySpecialRenderer<TileEntityEngineHoist>
{
    private IBakedModel model;

    public RenderEngineHoist(OBJModel enginehoist)
    {
        this.model = enginehoist.bake(enginehoist.getDefaultState(), DefaultVertexFormats.ITEM, RenderEngineHoist.DefaultTextureGetter.INSTANCE);
    }

    public void render(TileEntityEngineHoist te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        GlStateManager.pushMatrix();
        GlStateManager.disableCull();
        GlStateManager.disableAlpha();
        GlStateManager.disableBlend();
        GlStateManager.enableNormalize();
        GlStateManager.disableTexture2D();
        GlStateManager.translate((float)x + 0.5F, (float)y, (float)z + 0.5F);
        GlStateManager.scale(0.075F, 0.075F, 0.075F);
        EnumFacing enumfacing;

        try
        {
            enumfacing = (EnumFacing)te.getWorld().getBlockState(te.getPos()).getProperties().get(BlockHorizontal.FACING);
        }
        catch (Exception var13)
        {
            return;
        }

        if (enumfacing != null)
        {
            switch (enumfacing)
            {
                case SOUTH:
                    GlStateManager.rotate(90.0F, 0.0F, -1.0F, 0.0F);
                    break;

                case WEST:
                    GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
                    break;

                case NORTH:
                    GlStateManager.rotate(90.0F, 0.0F, 2.0F, 0.0F);
            }
        }

        this.renderModel(this.model, 16777215);
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();

        if (te.getEngine() != null)
        {
            GlStateManager.pushMatrix();
            CarPartEngine carpartengine = te.getEngine();
            GlStateManager.disableCull();
            GlStateManager.disableAlpha();
            GlStateManager.disableBlend();
            GlStateManager.enableNormalize();
            GlStateManager.disableTexture2D();
            GlStateManager.translate((float)x + 0.5F, (float)y, (float)z + 0.5F);

            if (enumfacing == EnumFacing.SOUTH)
            {
                GlStateManager.rotate(90.0F, 0.0F, -1.0F, 0.0F);
            }
            else if (enumfacing == EnumFacing.WEST)
            {
                GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
            }
            else if (enumfacing == EnumFacing.NORTH)
            {
                GlStateManager.rotate(90.0F, 0.0F, 2.0F, 0.0F);
            }

            GlStateManager.translate(0.9F, 1.2F, 0.0F);
            GlStateManager.scale(carpartengine.getModelInfo()[0], carpartengine.getModelInfo()[0], carpartengine.getModelInfo()[0]);
            GlStateManager.rotate(carpartengine.getModelInfo()[4], 0.0F, 1.0F, 0.0F);
            this.renderModel(carpartengine.getModel(), 16777215);
            GlStateManager.enableTexture2D();
            GlStateManager.popMatrix();
        }
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

    private void renderQuads(BufferBuilder renderer, List<BakedQuad> quads, int color, @Nullable ItemStack stack)
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

            LightUtil.renderQuadColor(renderer, bakedquad, k);
        }
    }

    public static enum DefaultTextureGetter implements Function<ResourceLocation, TextureAtlasSprite>
    {
        INSTANCE;

        public TextureAtlasSprite apply(ResourceLocation location)
        {
            return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());
        }
    }
}
