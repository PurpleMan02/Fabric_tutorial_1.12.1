package net.purple.tutorial.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.purple.tutorial.TutorialMod;
import net.purple.tutorial.item.ModItems;

//ctrl + h on "Block" to see the code of all Vanilla blocks
public class MagicBlock extends Block {

    public MagicBlock(Settings settings) {
        super(settings);

    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player,
                                 BlockHitResult hit) {
        return ActionResult.SUCCESS;
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
                                             PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand.MAIN_HAND);

        if (itemStack.isOf(ModItems.Six)) {
            world.playSound(player, pos, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1f, 1f);
            //player.setStackInHand(hand.MAIN_HAND, new ItemStack(ModItems.Seven));
            itemStack.split(1);
            player.giveItemStack(ModItems.Seven.getDefaultStack());

            return ItemActionResult.success(world.isClient);
        }

        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity item) {
            if (item.getStack().getItem() == ModItems.Six)  {
                item.setStack(new ItemStack(ModItems.Seven, item.getStack().getCount()));
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}
