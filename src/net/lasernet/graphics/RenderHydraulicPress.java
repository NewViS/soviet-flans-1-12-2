package net.lasernet.graphics;

import net.lasernet.xuj.blocks.TileEntityHydraulicPress;
import net.lasernet.xuj.items.ItemPaintCan;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;

public class RenderHydraulicPress extends TileEntitySpecialRenderer<TileEntityHydraulicPress>
{
    public void render(TileEntityHydraulicPress te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        try
        {
            ItemStack itemstack = te.getStackInSlot(0);

            if (itemstack != null)
            {
                GlStateManager.enableRescaleNormal();
                GlStateManager.alphaFunc(516, 0.1F);
                GlStateManager.enableBlend();
                RenderHelper.enableStandardItemLighting();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                GlStateManager.pushMatrix();
                GlStateManager.translate(x + 0.5D, y + 0.5D, z + 0.37D);
                GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
                IBakedModel ibakedmodel = Minecraft.getMinecraft().getRenderItem().getItemModelWithOverrides(itemstack, te.getWorld(), (EntityLivingBase)null);
                ibakedmodel = ForgeHooksClient.handleCameraTransforms(ibakedmodel, TransformType.GROUND, false);
                Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                Minecraft.getMinecraft().getRenderItem().renderItem(itemstack, ibakedmodel);
                GlStateManager.popMatrix();
                GlStateManager.disableRescaleNormal();
                GlStateManager.disableBlend();
            }

            ItemStack itemstack2 = te.getStackInSlot(1);
            ItemStack itemstack1 = te.getStackInSlot(2);

            if (itemstack2 != null)
            {
                GlStateManager.enableRescaleNormal();
                GlStateManager.alphaFunc(516, 0.1F);
                GlStateManager.enableBlend();
                RenderHelper.enableStandardItemLighting();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                GlStateManager.pushMatrix();

                if (!(itemstack2.getItem() instanceof ItemPaintCan))
                {
                    GlStateManager.translate(x + 0.5D, y + 0.2D, z + 0.37D);
                    GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
                }
                else
                {
                    GlStateManager.translate(x + 0.5D, y + 0.2D, z + 0.5D);
                }

                IBakedModel ibakedmodel1 = Minecraft.getMinecraft().getRenderItem().getItemModelWithOverrides(itemstack2, te.getWorld(), (EntityLivingBase)null);
                ibakedmodel1 = ForgeHooksClient.handleCameraTransforms(ibakedmodel1, TransformType.GROUND, false);
                Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                Minecraft.getMinecraft().getRenderItem().renderItem(itemstack2, ibakedmodel1);
                GlStateManager.popMatrix();
                GlStateManager.disableRescaleNormal();
                GlStateManager.disableBlend();
            }
            else if (itemstack1 != null)
            {
                GlStateManager.enableRescaleNormal();
                GlStateManager.alphaFunc(516, 0.1F);
                GlStateManager.enableBlend();
                RenderHelper.enableStandardItemLighting();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                GlStateManager.pushMatrix();

                if (!(itemstack1.getItem() instanceof ItemPaintCan))
                {
                    GlStateManager.translate(x + 0.5D, y + 0.2D, z + 0.37D);
                    GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
                }
                else
                {
                    GlStateManager.translate(x + 0.5D, y + 0.2D, z + 0.5D);
                }

                IBakedModel ibakedmodel2 = Minecraft.getMinecraft().getRenderItem().getItemModelWithOverrides(itemstack1, te.getWorld(), (EntityLivingBase)null);
                ibakedmodel2 = ForgeHooksClient.handleCameraTransforms(ibakedmodel2, TransformType.GROUND, false);
                Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                Minecraft.getMinecraft().getRenderItem().renderItem(itemstack1, ibakedmodel2);
                GlStateManager.popMatrix();
                GlStateManager.disableRescaleNormal();
                GlStateManager.disableBlend();
            }
        }
        catch (Exception var15)
        {
            ;
        }
    }
}
