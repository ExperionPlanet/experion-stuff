package io.github.experionplanet.experionstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.SideShapeType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.block.WireOrientation;
import org.jetbrains.annotations.Nullable;

public class FirePitBlock extends Block {
    public static final BooleanProperty TOPPED = BooleanProperty.of("topped");

    private void upd(BlockState state, World world, BlockPos pos) {
        BlockState upState = world.getBlockState(pos.add(0, 1, 0));
        BlockState downState = world.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()));

        if (downState.isAir()) {
            world.breakBlock(pos, true);
            return;
        }

        if (!upState.isAir()) {
            if (upState.getBlock() == this) {
                world.setBlockState(pos, state.with(TOPPED, true));
                return;
            }
        }

        world.setBlockState(pos, state.with(TOPPED, false));

    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TOPPED);
    }

    public FirePitBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(2, 0, 2, 14, 16, 14);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(TOPPED)) {
            return Block.createCuboidShape(2, 0, 2, 14, 16, 14);
        }
        return VoxelShapes.union(Block.createCuboidShape(2, 0, 2, 14, 16, 14), Block.createCuboidShape(0,13, 0, 16,16,16));
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, wireOrientation, notify);
        upd(state, world, pos);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        upd(state,world,pos);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos bottom = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
        BlockState v = world.getBlockState(bottom);

        return !v.isAir();
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);

        if (!state.get(TOPPED)) {
            world.addParticleClient(ParticleTypes.LAVA, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0,0,0);
        }


    }
}
