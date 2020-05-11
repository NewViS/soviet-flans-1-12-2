package net.lasernet.xuj;

import net.lasernet.xuj.blocks.BlockEngineHoist;
import net.lasernet.xuj.blocks.BlockHydraulicPress;
import net.lasernet.xuj.blocks.TileEntityEngineHoist;
import net.lasernet.xuj.blocks.TileEntityHydraulicPress;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber(
    modid = "xujmod"
)
public class ModBlocks
{
    public static Block blockEngineHoist;
    //public static Block blockHydraulicPress;

    public static void init()
    {
        blockEngineHoist = new BlockEngineHoist();
        TileEntity.register("enginehoist", TileEntityEngineHoist.class);
        //blockHydraulicPress = new BlockHydraulicPress();
        //TileEntity.register("hydraulicpress", TileEntityHydraulicPress.class);
    }

    public static void initRecipes()
    {
        GameRegistry.addShapedRecipe(blockEngineHoist.getRegistryName(), new ResourceLocation("xujmod"), new ItemStack(blockEngineHoist, 1), new Object[] {"IIH", "  I", "III", 'H', ModItems.itemHydraulicCyl, 'I', Items.IRON_INGOT});
        //GameRegistry.addShapedRecipe(blockHydraulicPress.getRegistryName(), new ResourceLocation("xujmod"), new ItemStack(blockHydraulicPress, 1), new Object[] {" H ", " IL", "III", 'H', ModItems.itemHydraulicCyl, 'I', Items.IRON_INGOT, 'L', Blocks.LEVER});
    }

    @SubscribeEvent
    public static void registerBlocks(Register<Block> event)
    {
        event.getRegistry().registerAll(new Block[] {blockEngineHoist});
        //event.getRegistry().registerAll(new Block[] {blockHydraulicPress});
    }

    @SubscribeEvent
    public static void registerItemBlocks(Register<Item> event)
    {
        event.getRegistry().registerAll(new Item[] {(Item)(new ItemBlock(blockEngineHoist)).setRegistryName(blockEngineHoist.getRegistryName())});
        //event.getRegistry().registerAll(new Item[] {(Item)(new ItemBlock(blockHydraulicPress)).setRegistryName(blockHydraulicPress.getRegistryName())});
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event)
    {
        XujMod.proxy.registerFullItemRenderer(Item.getItemFromBlock(blockEngineHoist), 0, "enginehoist");
        //XujMod.proxy.registerFullItemRenderer(Item.getItemFromBlock(blockHydraulicPress), 0, "hydraulicpress");
    }
}
