package net.lasernet.xuj.gui;

import java.io.IOException;
import net.lasernet.xuj.ModBlocks;
import net.lasernet.xuj.XujMod;
import net.lasernet.xuj.blocks.TileEntityHydraulicPress;
import net.lasernet.xuj.network.HydraulicPressMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GUIHydraulicPress extends GuiContainer
{
    private static final ResourceLocation BG_TEXTURE = new ResourceLocation("xujmod", "textures/gui/hydraulicpress.png");
    private InventoryPlayer playerInv;
    private ContainerHydraulicPress container;
    private TileEntityHydraulicPress te;
    private long lastclick = 0L;

    public GUIHydraulicPress(Container inventorySlotsIn, InventoryPlayer playerInv, TileEntityHydraulicPress te)
    {
        super(inventorySlotsIn);
        this.container = (ContainerHydraulicPress)inventorySlotsIn;
        this.playerInv = playerInv;
        this.te = te;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    public void initGui()
    {
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.buttonList.add(new GuiButton(0, i + 100, j + 16, 40, 20, "PRESS"));
        super.initGui();
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
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
    protected void actionPerformed(GuiButton button) throws IOException
    {
        if (button.id == 0 && Minecraft.getSystemTime() > this.lastclick + 250L)
        {
            XujMod.channel.sendToServer(new HydraulicPressMessage(this.te.getPos()));
            this.te.doPressing();
            this.lastclick = Minecraft.getSystemTime();
        }
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

        if (this.te.pressingTick > 0)
        {
            this.drawTexturedModalRect(i + 79, j + 52, 176, 14, this.te.pressingTick * 18 / 10 + 1, 16);
        }
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        //String s = I18n.format(ModBlocks.blockHydraulicPress.getUnlocalizedName() + ".name", new Object[0]);
        //this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, this.ySize - 94, 4210752);
    }
}
