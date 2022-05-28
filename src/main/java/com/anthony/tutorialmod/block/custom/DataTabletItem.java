package com.anthony.tutorialmod.block.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DataTabletItem extends Item {
    public DataTabletItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(pPlayer.getItemInHand(pUsedHand).hasTag()) { //returns true if the itemstack has a NBTTag
            pPlayer.getItemInHand(pUsedHand).setTag(new CompoundTag()); //Empty tag
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return pStack.hasTag();// if the actualy stack has this tag added to it, it will have the glistening enchantment
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents,// shows tooltip if we have the tag available to us
                                TooltipFlag pIsAdvanced) {
        if(pStack.hasTag()) {
            String currentOre = pStack.getTag().getString("tutorialmod.last_ore"); //tags store data like a map
            pTooltipComponents.add(new TextComponent(currentOre));
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}