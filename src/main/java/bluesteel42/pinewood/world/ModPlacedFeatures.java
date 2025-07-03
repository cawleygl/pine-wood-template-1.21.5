package bluesteel42.pinewood.world;

import bluesteel42.pinewood.PineWood;
import bluesteel42.pinewood.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> PINE_BEES_005_PLACED_KEY = registerKey("pine_bees_005");
    public static final RegistryKey<PlacedFeature> MEGA_PINE_HIGH_PLACED_KEY = registerKey("mega_pine_high");
    public static final RegistryKey<PlacedFeature> MEGA_PINE_LOW_PLACED_KEY = registerKey("mega_pine_low");
    public static final RegistryKey<PlacedFeature> FALLEN_PINE_PLACED_KEY = registerKey("fallen_pine_tree");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, PINE_BEES_005_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PINE_BEES_005_KEY),
                PlacedFeatures.wouldSurvive(ModBlocks.PINE_SAPLING)
        );
        register(context, MEGA_PINE_HIGH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MEGA_PINE_HIGH_KEY),
                PlacedFeatures.wouldSurvive(ModBlocks.PINE_SAPLING)
        );
        register(context, MEGA_PINE_LOW_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MEGA_PINE_LOW_KEY),
                PlacedFeatures.wouldSurvive(ModBlocks.PINE_SAPLING)
        );
        register(context, FALLEN_PINE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FALLEN_PINE_TREE_KEY),
                PlacedFeatures.wouldSurvive(ModBlocks.PINE_SAPLING)
        );

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(PineWood.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
