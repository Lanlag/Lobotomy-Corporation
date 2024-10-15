package net.uniego.aida.lobecorp.util;

import net.minecraft.block.Block;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class BlockUtil {
    //通过Blockbench参数创建体素形状
    public static VoxelShape createBBCuboidShape(double posX, double posY, double posZ, double sizeX, double sizeY, double sizeZ){
        return Block.createCuboidShape(
                posX,posY,posZ,
                posX + sizeX,posY + sizeY,posZ + sizeZ
                );
    }

    //水平旋转体素形状
    public static VoxelShape rotateShapeHorizontal(Direction to, VoxelShape shape) {
        VoxelShape[] buffer = new VoxelShape[]{shape, VoxelShapes.empty()};

        int times = (to.getHorizontal() - Direction.NORTH.getHorizontal() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.union(buffer[1], VoxelShapes.cuboid(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = VoxelShapes.empty();
        }

        return buffer[0];
    }
}
