package bluesteel42.pinewood.world;

import bluesteel42.pinewood.PineWood;
import bluesteel42.pinewood.block.ModBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.MegaPineFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.treedecorator.AttachedToLogsTreeDecorator;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_PINE_KEY = registerKey("mega_pine");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_PINE_SPRUCE_KEY = registerKey("mega_pine_spruce");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_PINE_TREE_KEY = registerKey("fallen_pine_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, MEGA_PINE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PINE_LOG),
                new GiantTrunkPlacer(13, 2, 14),

                BlockStateProvider.of(ModBlocks.PINE_LEAVES),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(3, 7)),

                new TwoLayersFeatureSize(1, 1, 2)
        ).decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)))).build());

        register(context, MEGA_PINE_SPRUCE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PINE_LOG),
                new GiantTrunkPlacer(13, 2, 14),

                BlockStateProvider.of(ModBlocks.PINE_LEAVES),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(13, 17)),

                new TwoLayersFeatureSize(1, 1, 2)
        ).decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)))).build());

        register(context, FALLEN_PINE_TREE_KEY, Feature.FALLEN_TREE, new FallenTreeFeatureConfig.Builder(BlockStateProvider.of(ModBlocks.PINE_LOG), UniformIntProvider.create(6, 10))
                .logDecorators(
                        ImmutableList.of(
                                new AttachedToLogsTreeDecorator(
                                        0.1F,
                                        new WeightedBlockStateProvider(Pool.<BlockState>builder().add(Blocks.RED_MUSHROOM.getDefaultState(), 2).add(Blocks.BROWN_MUSHROOM.getDefaultState(), 1)),
                                        List.of(Direction.UP)
                                )
                        )
                ).build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(PineWood.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration ) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
