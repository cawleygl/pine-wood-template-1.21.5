package bluesteel42.pinewood.world.tree;

import bluesteel42.pinewood.PineWood;
import bluesteel42.pinewood.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator PINE = new SaplingGenerator(
            PineWood.MOD_ID + ":pine",
            0.5F,
            Optional.of(ModConfiguredFeatures.MEGA_PINE_HIGH_KEY),
            Optional.of(ModConfiguredFeatures.MEGA_PINE_LOW_KEY),
            Optional.of(TreeConfiguredFeatures.PINE),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.PINE_BEES_005_KEY),
            Optional.empty()
    );
}
