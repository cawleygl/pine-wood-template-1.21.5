package bluesteel42.pinewood.world;

import bluesteel42.pinewood.PineWood;
import bluesteel42.pinewood.standard_wood_initializer.block.StandardWoodModBlocks;
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
import net.minecraft.world.gen.foliage.PineFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.treedecorator.AttachedToLogsTreeDecorator;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> PINE_BEES_005_KEY = registerKey("pine_bees_005");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_PINE_HIGH_KEY = registerKey("mega_pine_high");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_PINE_LOW_KEY = registerKey("mega_pine_low");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_PINE_TREE_KEY = registerKey("fallen_pine_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, PINE_BEES_005_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(StandardWoodModBlocks.MOD_LOG),
                new StraightTrunkPlacer(6, 4, 0),

                BlockStateProvider.of(StandardWoodModBlocks.MOD_LEAVES),
                new PineFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), UniformIntProvider.create(3, 4)),

                new TwoLayersFeatureSize(2, 0, 2)
        ).ignoreVines().decorators(List.of(new BeehiveTreeDecorator(0.05F))).build());

        register(context, MEGA_PINE_HIGH_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(StandardWoodModBlocks.MOD_LOG),
                new GiantTrunkPlacer(13, 2, 14),

                BlockStateProvider.of(StandardWoodModBlocks.MOD_LEAVES),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(3, 7)),

                new TwoLayersFeatureSize(1, 1, 2)
        ).decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)))).build());

        register(context, MEGA_PINE_LOW_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(StandardWoodModBlocks.MOD_LOG),
                new GiantTrunkPlacer(13, 2, 14),

                BlockStateProvider.of(StandardWoodModBlocks.MOD_LEAVES),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(7, 11)),

                new TwoLayersFeatureSize(1, 1, 2)
        ).decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)))).build());

        register(context, FALLEN_PINE_TREE_KEY, Feature.FALLEN_TREE, new FallenTreeFeatureConfig.Builder(BlockStateProvider.of(StandardWoodModBlocks.MOD_LOG), UniformIntProvider.create(6, 10))
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
