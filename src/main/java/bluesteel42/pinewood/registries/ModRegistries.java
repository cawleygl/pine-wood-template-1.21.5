package bluesteel42.pinewood.registries;

import bluesteel42.pinewood.block.ModBlocks;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModRegistries {
    public static void registerCompostables() {
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.PINE_LEAVES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES, 0.3F);
    }

    public static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PINE_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES, 30, 60);
    }

}
