package net.purple.tutorial.item.custom;

import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends MiningToolItem {

    public HammerItem(ToolMaterial material, Settings settings) {
        super(material, BlockTags.PICKAXE_MINEABLE, settings);
    }

    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos brokenBlockPos, ServerPlayerEntity playerEntity) {
        List<BlockPos> positions = new ArrayList<>();
        //raycasting - "shoots" a "laser" from the player's pov to the "maxDistance"
        HitResult hit = playerEntity.raycast(20, 0, false);

        if (hit.getType() == HitResult.Type.BLOCK) {

            //casting it to BlockhitResult because HitResult type cant save directions
            BlockHitResult blockHit = (BlockHitResult) hit;

            Direction side = blockHit.getSide();

            if (side == Direction.DOWN || side == Direction.UP) {
                //Important distinction - the nested 'for' loop gets reset every time
                //its being run by the main 'for' loop, which causes it (the nested 'for') to run 9 times
                for (int x = -range; x <= range; x++) {
                    for (int z = -range; z <= range; z++) {
                        positions.add(new BlockPos(brokenBlockPos.getX() + x, brokenBlockPos.getY(), brokenBlockPos.getZ() + z));
                    }
                }
            } else if (side == Direction.NORTH || side == Direction.SOUTH) {
                for (int x = -range; x <= range; x++) {
                    for (int y = -range; y <= range; y++) {
                        positions.add(new BlockPos(brokenBlockPos.getX() + x, brokenBlockPos.getY() + y, brokenBlockPos.getZ()));
                    }
                }
            } else if (side == Direction.EAST || side == Direction.WEST) {
                for (int z = -range; z <= range; z++) {
                    for (int y = -range; y <= range; y++) {
                        positions.add(new BlockPos(brokenBlockPos.getX(), brokenBlockPos.getY() + y, brokenBlockPos.getZ() + z));
                    }
                }
            }
        }

        return positions;
    }
}
