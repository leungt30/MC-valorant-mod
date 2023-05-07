package net.tim.valorantmod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tim.valorantmod.ValorantMod;
import net.tim.valorantmod.item.ModCreativeModeTab;
import net.tim.valorantmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ValorantMod.MOD_ID);

    public static final RegistryObject<Block> ZIRCON_BLOCK= registerBlock("zircon_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), //PROPERTIES OF THE BLOCK
            ModCreativeModeTab.VALORANT_TAB);
    public static final RegistryObject<Block> ZIRCON_ORE= registerBlock("zircon_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops(), UniformInt.of(3,7)), //PROPERTIES OF THE BLOCK
            ModCreativeModeTab.VALORANT_TAB);
    public static final RegistryObject<Block> DEEPSLATE_ZIRCON_ORE= registerBlock("deepslate_zircon_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops(), UniformInt.of(3,7)), //PROPERTIES OF THE BLOCK
            ModCreativeModeTab.VALORANT_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        //this function registers a block as an item as well (when we create a block, we also create the corresponding item)

        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        //takes a block and registers it as an item as well
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}

