package com.anthony.tutorialmod.item.custom;

import com.anthony.tutorialmod.item.ModItems;
import com.anthony.tutorialmod.sound.ModSounds;
import com.anthony.tutorialmod.util.InventoryUtil;
import com.anthony.tutorialmod.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import javax.management.modelmbean.ModelMBeanInfoSupport;
import java.util.List;

public class DowsingRodItem extends Item {
    public DowsingRodItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        if(pContext.getLevel().isClientSide()) { //checking the world level and if we are on the client
            BlockPos positionClicked = pContext.getClickedPos(); //get the position that we just clicked, saving to variable
            Player player = pContext.getPlayer(); //get which player clicked, saving to variable
            boolean foundBlock = false; //initializing boolean for foundblock

            for(int i = 0; i <= positionClicked.getY() + 64; i++) { // for loop goes from the block we found and goes down to -64 and checks if the block is valuable
                Block blockBelow = pContext.getLevel().getBlockState(positionClicked.below(i)).getBlock(); //

                if(isValuableBlock(blockBelow)) { //checking if it is valuable
                    outputValuableCoordinates(positionClicked.below(i), player, blockBelow); // if it is valuable we output the coords here
                    foundBlock = true; //set foundblock = true


                    if(InventoryUtil.hasPlayerStackInInventory(player, ModItems.DATA_TABLET.get())) {
                        addNbtToDataTablet(player, positionClicked.below(i), blockBelow);
                    }

                    pContext.getLevel().playSound(player, positionClicked, ModSounds.DOWSING_ROD_FOUND_ORE.get(),
                            SoundSource.BLOCKS, 1f, 1f);

                    break;
                }
            }

            if(!foundBlock) { //if no block was found
                player.sendMessage(new TranslatableComponent("item.tutorialmod.dowsing_rod.no_valuables"), //displays no valuable were found
                        player.getUUID());
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), //damage and durrability
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(pContext);
    }

    private void addNbtToDataTablet(Player player, BlockPos pos, Block blockBelow) {
        ItemStack dataTablet =
                player.getInventory().getItem(InventoryUtil.getFirstInventoryIndex(player, ModItems.DATA_TABLET.get()));

        CompoundTag nbtData = new CompoundTag();
        nbtData.putString("tutorialmod.last_ore", "Found " + blockBelow.asItem().getRegistryName().toString() + " at (" +
                pos.getX() + ", "+ pos.getY() + ", "+ pos.getZ() + ")");

        dataTablet.setTag(nbtData);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasAltDown())
        {
            pTooltipComponents.add(new TranslatableComponent("tooltip.tutorialmod.dowsing_rod.tooltip.shift")); //translation key
        }else{
            pTooltipComponents.add(new TranslatableComponent("tooltip.tutorialmod.dowsing_rod.tooltip")); //translation key
        }
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow) { // sends blocks coordenates through the player
        player.sendMessage(new TextComponent("Found " + blockBelow.asItem().getRegistryName().toString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"), player.getUUID());
    }

    private boolean isValuableBlock(Block block) { //checks if a block we are passing in is valuable
        return Registry.BLOCK.getHolderOrThrow(Registry.BLOCK.getResourceKey(block).get()).is(ModTags.Blocks.DOWSING_ROD_VALUABLES);
    }
}