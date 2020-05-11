package net.lasernet.xuj;

import net.lasernet.graphics.RenderEngineHoist;
import net.lasernet.graphics.RenderHydraulicPress;
import net.lasernet.xuj.blocks.TileEntityEngineHoist;
import net.lasernet.xuj.blocks.TileEntityHydraulicPress;
import net.lasernet.xuj.carparts.CarPart;
import net.lasernet.xuj.entity.EntityCarE30;
import net.lasernet.xuj.entity.EntityCarE36;
import net.lasernet.xuj.entity.EntityCarLambo;
import net.lasernet.xuj.entity.EntityCarMustang1969;
import net.lasernet.xuj.entity.EntityCarNissanJunior;
import net.lasernet.xuj.entity.EntityCarRX7FC;
import net.lasernet.xuj.entity.EntityManta;
import net.lasernet.xuj.entity.EntityTrabant;
import net.lasernet.xuj.entity.RenderCar;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{
    public RenderCar renderManta;
    public RenderCar renderRx7FC;
    public RenderCar renderE30;
    public RenderCar renderE36;
    public RenderCar renderTrabant;
    public RenderCar renderJunior;
    public RenderCar renderLambo;
    public RenderCar renderMustang1969;

    public void preInit()
    {
        OBJLoader.INSTANCE.addDomain("xujmod");
        OBJModel objmodel = null;
        OBJModel objmodel1 = null;
        OBJModel objmodel2 = null;
        OBJModel objmodel3 = null;
        OBJModel objmodel4 = null;
        OBJModel objmodel5 = null;
        OBJModel objmodel6 = null;
        OBJModel objmodel7 = null;
        OBJModel objmodel8 = null;
        OBJModel objmodel9 = null;
        OBJModel objmodel10 = null;
        OBJModel objmodel11 = null;
        OBJModel objmodel12 = null;
        OBJModel objmodel13 = null;
        OBJModel objmodel14 = null;
        OBJModel objmodel15 = null;
        OBJModel objmodel16 = null;

        try
        {
            objmodel = (OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/manta/manta.obj"));
            objmodel1 = (OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/manta/mantainclude.obj"));
            ((CarPart)CarPart.partList.get(0)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/manta/chrome.obj")));
            ((CarPart)CarPart.partList.get(1)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/manta/fronthl.obj")));
            ((CarPart)CarPart.partList.get(2)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/manta/rearlights.obj")));
            ((CarPart)CarPart.partList.get(3)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/manta/windows.obj")));
            ((CarPart)CarPart.partList.get(4)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/inlinefour.obj")));
            ((CarPart)CarPart.partList.get(5)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/veightna.obj")));
            ((CarPart)CarPart.partList.get(6)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/veightblower.obj")));
            objmodel3 = (OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/rx7fc/rx7fc.obj"));
            objmodel4 = (OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/rx7fc/rx7include.obj"));
            ((CarPart)CarPart.partList.get(7)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/rx7fc/rx7frontwindow.obj")));
            ((CarPart)CarPart.partList.get(8)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/rx7fc/rx7rearwindow.obj")));
            ((CarPart)CarPart.partList.get(9)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/rx7fc/rx7sunroof.obj")));
            ((CarPart)CarPart.partList.get(10)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/rx7fc/rx7wing.obj")));
            ((CarPart)CarPart.partList.get(11)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/rotaryengine.obj")));
            objmodel2 = (OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/block/3d/enginehoist.obj"));
            objmodel5 = (OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/e30/e30.obj"));
            objmodel6 = (OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/e30/e30include.obj"));
            ((CarPart)CarPart.partList.get(12)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/e30/e30windshield.obj")));
            ((CarPart)CarPart.partList.get(13)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/e30/e30fbumper.obj")));
            ((CarPart)CarPart.partList.get(14)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/e30/e30rbumper.obj")));
            ((CarPart)CarPart.partList.get(15)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/e30/e30wing.obj")));
            objmodel7 = (OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/e36/e36.obj"));
            objmodel8 = (OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/e36/e36include.obj"));
            ((CarPart)CarPart.partList.get(16)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/e36/e36windows.obj")));
            ((CarPart)CarPart.partList.get(17)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/e36/e36fbumper.obj")));
            ((CarPart)CarPart.partList.get(18)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/e36/e36rbumper.obj")));
            ((CarPart)CarPart.partList.get(19)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/manta/mantawing.obj")));
            objmodel9 = (OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/trabant/trabant.obj"));
            objmodel10 = (OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/trabant/trabantinclude.obj"));
            ((CarPart)CarPart.partList.get(20)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/trabant/trabantbumpers.obj")));
            ((CarPart)CarPart.partList.get(21)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/trabant/trabantscaffold.obj")));
            ((CarPart)CarPart.partList.get(22)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/e36/e36hood.obj")));
            ((CarPart)CarPart.partList.get(23)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/2jz.obj")));
            ((CarPart)CarPart.partList.get(24)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/wheels/trabantsz.obj")));
            ((CarPart)CarPart.partList.get(25)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/wheels/mantas.obj")));
            ((CarPart)CarPart.partList.get(26)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/wheels/rx7wheel.obj")));
            ((CarPart)CarPart.partList.get(27)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/wheels/truckwheel.obj")));
            objmodel11 = (OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/nissanjunior/nissanjunior.obj"));
            objmodel12 = (OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/nissanjunior/include.obj"));
            ((CarPart)CarPart.partList.get(28)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/nissanjunior/bumpers.obj")));
            ((CarPart)CarPart.partList.get(29)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/nissanjunior/rollbar.obj")));
            objmodel13 = (OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/lambo/lambo.obj"));
            objmodel14 = (OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/lambo/lamboinclude.obj"));
            objmodel15 = (OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/1969/mustang.obj"));
            objmodel16 = (OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/1969/mustanginclude.obj"));
            ((CarPart)CarPart.partList.get(30)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/cars/1969/mustangHood.obj")));
            ((CarPart)CarPart.partList.get(31)).setModel((OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation("xujmod", "models/wheels/musclewheels.obj")));
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        this.renderManta = (new RenderCar(Minecraft.getMinecraft().getRenderManager(), objmodel)).addRequred(objmodel1);
        Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(EntityManta.class, this.renderManta);
        this.renderRx7FC = (new RenderCar(Minecraft.getMinecraft().getRenderManager(), objmodel3)).addRequred(objmodel4);
        Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(EntityCarRX7FC.class, this.renderRx7FC);
        this.renderE30 = (new RenderCar(Minecraft.getMinecraft().getRenderManager(), objmodel5)).addRequred(objmodel6);
        Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(EntityCarE30.class, this.renderE30);
        this.renderE36 = (new RenderCar(Minecraft.getMinecraft().getRenderManager(), objmodel7)).addRequred(objmodel8);
        Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(EntityCarE36.class, this.renderE36);
        this.renderTrabant = (new RenderCar(Minecraft.getMinecraft().getRenderManager(), objmodel9)).addRequred(objmodel10);
        Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(EntityTrabant.class, this.renderTrabant);
        this.renderJunior = (new RenderCar(Minecraft.getMinecraft().getRenderManager(), objmodel11)).addRequred(objmodel12);
        Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(EntityCarNissanJunior.class, this.renderJunior);
        this.renderLambo = (new RenderCar(Minecraft.getMinecraft().getRenderManager(), objmodel13)).addRequred(objmodel14);
        Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(EntityCarLambo.class, this.renderLambo);
        this.renderMustang1969 = (new RenderCar(Minecraft.getMinecraft().getRenderManager(), objmodel15)).addRequred(objmodel16);
        Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(EntityCarMustang1969.class, this.renderMustang1969);
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEngineHoist.class, new RenderEngineHoist(objmodel2));
        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHydraulicPress.class, new RenderHydraulicPress());
        System.out.println("XujMod Models loaded");
    }

    public void registerModel(Item i, int meta, String id)
    {
        ModelLoader.setCustomModelResourceLocation(i, meta, new ModelResourceLocation("xujmod:" + id, "inventory"));
    }

    public void registerItemRenderer(Item item, int meta, String id)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation("xujmod:" + id, "inventory"));
    }

    public void registerFullItemRenderer(Item item, int meta, String id)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation("xujmod:" + id, "inventory"));
    }

    public void registerRender(Block block)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

    @Deprecated
    public void registerRender(Block block, String name)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(name, "inventory"));
    }

    public String localize(String unlocalized, Object... args)
    {
        return I18n.format(unlocalized, args);
    }
}
