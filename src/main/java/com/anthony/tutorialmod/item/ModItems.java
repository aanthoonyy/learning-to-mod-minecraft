package com.anthony.tutorialmod.item;

import com.anthony.tutorialmod.TutorialMod;
import com.anthony.tutorialmod.block.ModBlocks;
import com.anthony.tutorialmod.block.custom.CoalCokeItem;
import com.anthony.tutorialmod.block.custom.DataTabletItem;
import com.anthony.tutorialmod.block.custom.LevitationSwordItem;
import com.anthony.tutorialmod.block.custom.ModArmorItem;
import com.anthony.tutorialmod.item.custom.DowsingRodItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
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
    // citrine sword
    public  static  final RegistryObject<Item> CITRINE_SWORD = ITEMS.register("citrine_sword", //coal coke is the custom item
            () -> new LevitationSwordItem(ModTiers.CITRINE, 2,3f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    //pickaxe
    public  static  final RegistryObject<Item> CITRINE_PICKAXE = ITEMS.register("citrine_pickaxe", //coal coke is the custom item
            () -> new PickaxeItem(ModTiers.CITRINE, 2,3f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    //shovel
    public  static  final RegistryObject<Item> CITRINE_SHOVEL = ITEMS.register("citrine_shovel", //coal coke is the custom item
            () -> new ShovelItem(ModTiers.CITRINE, 2,3f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    // axe
    public  static  final RegistryObject<Item> CITRINE_AXE = ITEMS.register("citrine_axe", //coal coke is the custom item
            () -> new AxeItem(ModTiers.CITRINE, 2,3f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    // hoe
    public  static  final RegistryObject<Item> CITRINE_HOE = ITEMS.register("citrine_hoe", //coal coke is the custom item
            () -> new HoeItem(ModTiers.CITRINE, 2,3f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    //armor
    public  static  final RegistryObject<Item> CITRINE_HELMET = ITEMS.register("citrine_helmet", //coal coke is the custom item
            () -> new ModArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public  static  final RegistryObject<Item> CITRINE_CHESTPLATE = ITEMS.register("citrine_chestplate", //coal coke is the custom item
            () -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public  static  final RegistryObject<Item> CITRINE_LEGGING = ITEMS.register("citrine_leggings", //coal coke is the custom item
            () -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public  static  final RegistryObject<Item> CITRINE_BOOTS = ITEMS.register("citrine_boots", //coal coke is the custom item
            () -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    //magic dust
    public  static  final RegistryObject<Item> MAGIC_DUST = ITEMS.register("magic_dust",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    //data tablet
    public  static  final RegistryObject<Item> DATA_TABLET = ITEMS.register("data_tablet",
            () -> new DataTabletItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));
    //kaupenbow
    public  static  final RegistryObject<Item> KAUPENBOW = ITEMS.register("kaupenbow",
            () -> new BowItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).durability(500)));
    //cucumber seeds
    public static final RegistryObject<Item> CUCUMBER_SEEDS = ITEMS.register("cucumber_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CUCUMBER_PLANT.get(),
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);

    }

}
