package net.lasernet.xuj;

import net.lasernet.xuj.items.ItemBase;
import net.lasernet.xuj.items.ItemCarBox;
import net.lasernet.xuj.items.ItemCarPart;
import net.lasernet.xuj.items.ItemEngine;
import net.lasernet.xuj.items.ItemLugWrench;
import net.lasernet.xuj.items.ItemPaintCan;
import net.lasernet.xuj.items.ItemWD40;
import net.lasernet.xuj.items.ItemWheels;
import net.lasernet.xuj.items.ItemXujDisc;
import net.minecraft.entity.passive.EntityVillager.ITradeList;
import net.minecraft.entity.passive.EntityVillager.ListItemForEmeralds;
import net.minecraft.entity.passive.EntityVillager.PriceInfo;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerCareer;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(
    modid = "xujmod"
)
public class ModItems
{
    public static ItemBase wd40Item;
    public static ItemBase itemCarPart;
    public static ItemBase itemEngine;
    public static ItemBase itemPaintBottle;
    public static Item itemXujDiscDejavu;
    public static Item itemXujDiscGas;
    public static Item itemXujDiscRunning;
    public static ItemBase itemCarBox;
    public static ItemBase itemHydraulicCyl;
    public static ItemBase itemWheels;
    public static ItemBase itemLugWrench;
    public static final VillagerProfession PROFESSION = new VillagerProfession("xujmod:carguy", "minecraft:textures/entity/villager/villager.png", "");
    public static VillagerCareer CAREER;

    public static void init()
    {
        wd40Item = new ItemWD40();
        itemLugWrench = new ItemLugWrench();
        itemPaintBottle = new ItemPaintCan();

        for (int i = 0; i < 16; ++i)
        {
            HydraulicPressRecipes.instance().addPressRecipe(new ItemStack(Items.DYE, 1, i), new ItemStack(itemPaintBottle, 1, 0), new ItemStack(itemPaintBottle, 1, i + 1));
        }

        itemCarPart = new ItemCarPart();
        itemEngine = new ItemEngine();
        itemWheels = new ItemWheels();
        itemXujDiscDejavu = new ItemXujDisc("dejavu", "dejavu");
        itemXujDiscGas = new ItemXujDisc("gasgasgas", "gas");
        itemXujDiscRunning = new ItemXujDisc("running", "running");
        itemCarBox = new ItemCarBox();
        HydraulicPressRecipes.instance().addPress(Item.getItemFromBlock(Blocks.IRON_BLOCK), Item.getItemFromBlock(Blocks.CHEST), new ItemStack(itemCarBox));
        itemHydraulicCyl = new ItemBase("hydrauliccyl");
    }

    @SubscribeEvent
    public static void registerItems(Register<Item> event)
    {
        event.getRegistry().registerAll(new Item[] {wd40Item, itemCarPart, itemEngine, itemPaintBottle, itemXujDiscDejavu, itemXujDiscGas, itemXujDiscRunning, itemCarBox, itemHydraulicCyl, itemWheels, itemLugWrench});
    }

    public static void initRecipes()
    {
        GameRegistry.addShapedRecipe(itemHydraulicCyl.getRegistryName(), new ResourceLocation("xujmod"), new ItemStack(itemHydraulicCyl, 1, 0), new Object[] {"DID", "IBI", "III", 'B', Items.WATER_BUCKET, 'I', Items.IRON_INGOT, 'D', new ItemStack(Items.DYE, 1, 1)});
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event)
    {
        XujMod.proxy.registerItemRenderer(wd40Item, 0, "wd40");
        XujMod.proxy.registerItemRenderer(itemLugWrench, 0, "lugwrench");
        XujMod.proxy.registerItemRenderer(itemPaintBottle, 0, "paintcan");

        for (int i = 0; i < 16; ++i)
        {
            XujMod.proxy.registerItemRenderer(itemPaintBottle, i + 1, "paintcan");
        }

        XujMod.proxy.registerItemRenderer(itemCarPart, 0, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 1, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 2, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 3, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 4, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 8, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 9, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 10, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 11, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 13, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 14, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 15, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 16, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 17, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 18, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 19, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 20, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 21, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 22, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 23, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 29, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 30, "carpart");
        XujMod.proxy.registerItemRenderer(itemCarPart, 31, "carpart");
        XujMod.proxy.registerItemRenderer(itemEngine, 5, "engine");
        XujMod.proxy.registerItemRenderer(itemEngine, 6, "engine");
        XujMod.proxy.registerItemRenderer(itemEngine, 7, "engine");
        XujMod.proxy.registerItemRenderer(itemEngine, 12, "engine");
        XujMod.proxy.registerItemRenderer(itemEngine, 24, "engine");
        XujMod.proxy.registerItemRenderer(itemWheels, 25, "wheel_pack");
        XujMod.proxy.registerItemRenderer(itemWheels, 26, "wheel_pack");
        XujMod.proxy.registerItemRenderer(itemWheels, 27, "wheel_pack");
        XujMod.proxy.registerItemRenderer(itemWheels, 28, "wheel_pack");
        XujMod.proxy.registerItemRenderer(itemWheels, 32, "wheel_pack");
        XujMod.proxy.registerFullItemRenderer(itemXujDiscDejavu, 0, "disc");
        XujMod.proxy.registerFullItemRenderer(itemXujDiscGas, 0, "disc");
        XujMod.proxy.registerFullItemRenderer(itemXujDiscRunning, 0, "disc");
        XujMod.proxy.registerItemRenderer(itemCarBox, 0, "carbox");
        XujMod.proxy.registerItemRenderer(itemHydraulicCyl, 0, "hydrauliccyl");
    }

    @SubscribeEvent
    public static void onEvent(Register<VillagerProfession> event)
    {
        IForgeRegistry<VillagerProfession> iforgeregistry = event.getRegistry();
        CAREER = (new VillagerCareer(PROFESSION, "carguy")).addTrade(1, new ITradeList[] {new ListItemForEmeralds(new ItemStack(wd40Item, 1), new PriceInfo(4, 1))}).addTrade(2, new ITradeList[] {new ListItemForEmeralds(new ItemStack(itemCarBox, 1), new PriceInfo(6, 1))}).addTrade(3, new ITradeList[] {new ListItemForEmeralds(new ItemStack(ModBlocks.blockEngineHoist, 1), new PriceInfo(9, 1))});
        iforgeregistry.register(PROFESSION);
    }
}
