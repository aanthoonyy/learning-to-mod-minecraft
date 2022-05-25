package com.anthony.tutorialmod.item;

import com.anthony.tutorialmod.TutorialMod;
import com.anthony.tutorialmod.block.custom.CoalCokeItem;
import com.anthony.tutorialmod.item.custom.DowsingRodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

public class ModItems { // a list of my items that i am creating
    public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID); // tutorialmod.mod_id holds all the item list


    //registering item
    public  static  final RegistryObject<Item> CITRINE = ITEMS.register("citrine", //citrine is the custom item
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    // second item, no need for new class all you need is a new field
    public  static  final RegistryObject<Item> RAW_CITRINE = ITEMS.register("raw_citrine", //raw citrine is the custom item
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    // dowsing rod
    public  static  final RegistryObject<Item> DOWSING_ROD = ITEMS.register("dowsing_rod", //dowsing rod is the custom item
            () -> new DowsingRodItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).durability(16)));

    //cucumber
    public  static  final RegistryObject<Item> CUCUMBER = ITEMS.register("cucumber", //cucumber is the custom item
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).food(ModFoods.CUCUMBER)));
    //coalcoke
    public  static  final RegistryObject<Item> COAL_COKE = ITEMS.register("coal_coke", //coal coke is the custom item
            () -> new CoalCokeItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);

    }

}
