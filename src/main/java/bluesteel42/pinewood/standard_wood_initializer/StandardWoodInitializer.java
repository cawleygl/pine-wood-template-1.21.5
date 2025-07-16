package bluesteel42.pinewood.standard_wood_initializer;

import bluesteel42.pinewood.PineWood;
import bluesteel42.pinewood.world.ModConfiguredFeatures;
import bluesteel42.pinewood.standard_wood_initializer.block.StandardWoodModBlocks;
import bluesteel42.pinewood.standard_wood_initializer.entity.StandardWoodModBoats;
import bluesteel42.pinewood.standard_wood_initializer.item.StandardWoodModItems;
import bluesteel42.pinewood.standard_wood_initializer.registries.StandardWoodModRegistries;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.MapColor;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.FoliageColors;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;

import java.util.Optional;

public class StandardWoodInitializer {
    /*
     * Standard Wood Type Initializer
     *  - Edits: None
     */
    public static String MOD_ID = PineWood.MOD_ID;
    public static String WOOD_TYPE = "pine";
    public static MapColor BARK_COLOR = MapColor.TERRACOTTA_ORANGE;
    public static MapColor FIBER_COLOR = MapColor.TERRACOTTA_WHITE;
    public static int LEAF_TINT_COLOR = FoliageColors.DEFAULT;

    public static float SAPLING_RARE_VARIANT_CHANCE = 0.5F;
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SAPLING_STANDARD_TREE = Optional.of(TreeConfiguredFeatures.PINE);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SAPLING_RARE_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SAPLING_MEGA_TREE = Optional.of(ModConfiguredFeatures.MEGA_PINE_HIGH_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SAPLING_RARE_MEGA_TREE = Optional.of(ModConfiguredFeatures.MEGA_PINE_LOW_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SAPLING_BEES_TREE = Optional.of(ModConfiguredFeatures.PINE_BEES_005_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SAPLING_RARE_BEES_TREE = Optional.empty();

    public static void initalizeWoodType() {
        StandardWoodModBlocks.initialize();
        StandardWoodModItems.initialize();
        StandardWoodModBoats.initialize();
        StandardWoodModRegistries.registerStrippables();
        StandardWoodModRegistries.registerCompostables();
        StandardWoodModRegistries.registerFlammables();
        StandardWoodModRegistries.registerTrades();
    }

    public static void initializeWoodTypeClient() {
        // Register Boat Models
        TerraformBoatClientHelper.registerModelLayers(StandardWoodModBoats.MOD_BOATS_ID);

        // Color Leaves
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            if (view == null || pos == null) {
                return LEAF_TINT_COLOR;
            }
            return BiomeColors.getFoliageColor(view, pos);
        }, StandardWoodModBlocks.MOD_LEAVES);
    }
}
