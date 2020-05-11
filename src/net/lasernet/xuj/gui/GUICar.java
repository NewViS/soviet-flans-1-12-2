package net.lasernet.xuj.gui;

import java.util.ArrayList;
import java.util.List;
import net.lasernet.xuj.entity.EntityCar;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class GUICar extends GuiContainer
{
    private static final ResourceLocation BG_TEXTURE = new ResourceLocation("xujmod", "textures/gui/single.png");
    private static final ResourceLocation SLOT_TEXTURE = new ResourceLocation("xujmod", "textures/gui/slot.png");
    private InventoryPlayer playerInv;
    private EntityCar car;

    public GUICar(Container inventorySlotsIn, InventoryPlayer playerInv)
    {
        super(inventorySlotsIn);
        this.car = ((ContainerCar)inventorySlotsIn).getCar();
        this.playerInv = playerInv;
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.drawGuiContainerForegroundLayer(mouseX, mouseY);
    }

    /**
     * Draws the background layer of this container (behind the items).
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(BG_TEXTURE);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = this.car.getCarType().getName();
        this.fontRenderer.drawString(s, 8, 6, 4210752);
        this.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, this.ySize - 94, 4210752);

        if (this.car.getFuel() != null)
        {
            String s1 = this.car.getFuel().amount + " / " + this.car.getFuelTankSize();
            this.fontRenderer.drawString(s1, 169 - this.fontRenderer.getStringWidth(s1), 6, 4210752);
            Fluid fluid = this.car.getFuel().getFluid();
            this.mc.renderEngine.bindTexture(new ResourceLocation(fluid.getStill().getResourceDomain(), "textures/" + fluid.getStill().getResourcePath() + ".png"));
            int i = this.car.getFuel().amount * 52 / this.car.getFuelTankSize();
            drawModalRectWithCustomSizedTexture(134, 17 + (52 - i), 0.0F, 0.0F, 34, i, 16.0F, 16.0F);

            if (this.isPointInRegion(134, 17, 34, 52, mouseX, mouseY))
            {
                List list = new ArrayList();
                list.add(this.car.getFuel().getLocalizedName());
                int j = (this.width - this.xSize) / 2;
                int k = (this.height - this.ySize) / 2;
                this.drawHoveringText(list, mouseX - j, mouseY - k);
            }
        }
    }
}
