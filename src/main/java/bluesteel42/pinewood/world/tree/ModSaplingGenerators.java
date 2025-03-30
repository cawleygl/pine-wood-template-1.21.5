package bluesteel42.pinewood.world.tree;

import bluesteel42.pinewood.PineWood;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator PINE = new SaplingGenerator(PineWood.MOD_ID + ":pine",
            Optional.of(TreeConfiguredFeatures.MEGA_PINE), Optional.of(TreeConfiguredFeatures.PINE), Optional.empty());
}
