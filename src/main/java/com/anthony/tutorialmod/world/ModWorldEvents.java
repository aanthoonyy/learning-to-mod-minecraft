package com.anthony.tutorialmod.world;
import com.anthony.tutorialmod.TutorialMod;
import com.anthony.tutorialmod.world.gen.ModFlowerGeneration;
import com.anthony.tutorialmod.world.gen.ModOreGeneration;
import com.anthony.tutorialmod.world.gen.ModTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModOreGeneration.generateOres(event);
        ModTreeGeneration.generateTrees(event);
        ModFlowerGeneration.generateFlowers(event);
    }

}
