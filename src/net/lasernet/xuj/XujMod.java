package net.lasernet.xuj;

import net.lasernet.xuj.carparts.CarPart;
import net.lasernet.xuj.entity.EntityCar;
import net.lasernet.xuj.entity.EntityCarE30;
import net.lasernet.xuj.entity.EntityCarE36;
import net.lasernet.xuj.entity.EntityCarLambo;
import net.lasernet.xuj.entity.EntityCarMustang1969;
import net.lasernet.xuj.entity.EntityCarNissanJunior;
import net.lasernet.xuj.entity.EntityCarRX7FC;
import net.lasernet.xuj.entity.EntityManta;
import net.lasernet.xuj.entity.EntityTrabant;
import net.lasernet.xuj.gui.ModGuiHandler;
import net.lasernet.xuj.network.CarToClientMessage;
import net.lasernet.xuj.network.CarToServerMessage;
import net.lasernet.xuj.network.HydraulicPressMessage;
import net.lasernet.xuj.network.HydraulicPressMessageHandler;
import net.lasernet.xuj.network.XujClientMessageHandler;
import net.lasernet.xuj.network.XujServerMessageHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(
    modid = "xujmod",
    version = "2.0.8",
    acceptedMinecraftVersions = "[1.12.2]"
)
public class XujMod
{
    public static final String MODID = "xujmod";
    public static final String VERSION = "2.0.8";
    public static final SimpleNetworkWrapper channel = NetworkRegistry.INSTANCE.newSimpleChannel("xujmod");
    @Instance("xujmod")
    public static XujMod instance;
    @SidedProxy(
        serverSide = "net.lasernet.xuj.CommonProxy",
        clientSide = "net.lasernet.xuj.ClientProxy"
    )
    public static CommonProxy proxy;
    public static final CreativeTabs tabXuj = new CreativeTabs("xujmod")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem()
        {
            return new ItemStack(ModItems.wd40Item);
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        CarPart.init();
        EntityCar.initCars();
        ModItems.init();
        ModBlocks.init();
        EntityRegistry.registerModEntity(new ResourceLocation("xujmod", "manta"), EntityManta.class, "manta", 0, this, 32, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("xujmod", "rx7fc"), EntityCarRX7FC.class, "rx7fc", 1, this, 32, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("xujmod", "e30"), EntityCarE30.class, "e30", 2, this, 32, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("xujmod", "e36"), EntityCarE36.class, "e36", 3, this, 32, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("xujmod", "trabant"), EntityTrabant.class, "trabant", 4, this, 32, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("xujmod", "junior"), EntityCarNissanJunior.class, "junior", 5, this, 32, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("xujmod", "lambo"), EntityCarLambo.class, "lambo", 6, this, 32, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("xujmod", "mustang1969"), EntityCarMustang1969.class, "mustang1969", 7, this, 32, 1, true);
        VillagerRegistry.instance().registerVillageCreationHandler(new VillageGarage.VillageManager());
        MapGenStructureIO.registerStructureComponent(VillageGarage.class, "xujmod:Garage");
        channel.registerMessage(XujServerMessageHandler.class, CarToServerMessage.class, 0, Side.SERVER);
        channel.registerMessage(XujClientMessageHandler.class, CarToClientMessage.class, 1, Side.CLIENT);
        channel.registerMessage(HydraulicPressMessageHandler.class, HydraulicPressMessage.class, 2, Side.SERVER);
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new ModGuiHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModItems.initRecipes();
        ModBlocks.initRecipes();
        proxy.preInit();
    }
}
