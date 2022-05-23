package com.anthony.tutorialmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

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
                    break; //break out the loop
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


    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow) { // sends blocks coordenates through the player
        player.sendMessage(new TextComponent("Found " + blockBelow.asItem().getRegistryName().toString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"), player.getUUID());
    }

    private boolean isValuableBlock(Block block) { //checks if a block we are passing in is valuable
        return block == Blocks.COAL_ORE || block == Blocks.COPPER_ORE // valuable ores
                || block == Blocks.DIAMOND_ORE || block == Blocks.IRON_ORE;
    }
}