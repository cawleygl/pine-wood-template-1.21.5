package bluesteel42.pinewood;

import bluesteel42.pinewood.block.ModBlocks;
import bluesteel42.pinewood.entity.ModBoats;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.world.biome.FoliageColors;

public class PineWoodClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Register Boat Models
        TerraformBoatClientHelper.registerModelLayers(ModBoats.PINE_BOATS_ID);

        // Color Leaves
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            if (view == null || pos == null) {
                return FoliageColors.DEFAULT;
            }
            return BiomeColors.getFoliageColor(view, pos);
        }, ModBlocks.PINE_LEAVES);
    }
}
