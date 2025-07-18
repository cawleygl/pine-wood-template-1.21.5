package bluesteel42.pinewood;

import bluesteel42.pinewood.block.ModBlocks;
import bluesteel42.pinewood.particle.ModNeedlesParticle;
import bluesteel42.pinewood.particle.ModParticles;
import bluesteel42.pinewood.standard_wood_initializer.StandardWoodInitializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.particle.LeavesParticle;
import net.minecraft.world.biome.FoliageColors;

public class PineWoodClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        StandardWoodInitializer.initializeWoodTypeClient();
        // Color Leaves
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            if (view == null || pos == null) {
                return FoliageColors.DEFAULT;
            }
            return BiomeColors.getFoliageColor(view, pos);
        }, ModBlocks.PINE_LEAVES);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> FoliageColors.SPRUCE, ModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES);
        // Register Leaf Particle Effect
        ParticleFactoryRegistry.getInstance().register(ModParticles.PINE_NEEDLES, ModNeedlesParticle.TintedNeedlesFactory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.SPRUCE_NEEDLES, ModNeedlesParticle.TintedNeedlesFactory::new);
    }
}
