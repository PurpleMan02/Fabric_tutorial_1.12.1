package net.purple.tutorial.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.purple.tutorial.Component.ModDataComponents;
import net.purple.tutorial.block.ModBlocks;

import java.util.List;
import java.util.Map;
import java.util.Random;

//ctrl + H on "Item" to show the list of all vanilla items
public class ChiselItem extends Item {

    public static Block getRandomBlock () {
        Random random = new Random();

        int size = Registries.BLOCK.size();

        int randomBlockIndex = random.nextInt(size);

        return Registries.BLOCK.get(randomBlockIndex);
    }

    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.PURPUR_BLOCK, Blocks.PURPUR_PILLAR,
                    ModBlocks.SixSquare, ModBlocks.SevenSquare,
                    Blocks.ICE, Blocks.TNT
            );


    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.tutorial-mod.chisel.tooltip_shift_down"));
        } else {
            tooltip.add(Text.translatable("tooltip.tutorial-mod.chisel.tooltip"));
        }

        if (stack.get(ModDataComponents.COORDINATES) != null) {
             tooltip.add(Text.literal("Last block changed at: " + stack.get(ModDataComponents.COORDINATES)));
        }


        super.appendTooltip(stack, context, tooltip, type);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (CHISEL_MAP.containsKey(clickedBlock)) {
            if (!world.isClient) {
                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_ANVIL_USE, SoundCategory.BLOCKS);
            }
        } else if (clickedBlock == Blocks.DIRT) {
            if (!world.isClient) {
                Block block = getRandomBlock();
                if (block != null) {
                    world.setBlockState(context.getBlockPos(), getRandomBlock().getDefaultState());

                    context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                            item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                    world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_ANVIL_USE, SoundCategory.BLOCKS);
                }
            }
        }

        context.getStack().set(ModDataComponents.COORDINATES, context.getBlockPos());

        return ActionResult.SUCCESS;
    }
}
