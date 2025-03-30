package bluesteel42.pinewood.datagen;

import bluesteel42.pinewood.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.PINE_LOG);
        addDrop(ModBlocks.PINE_WOOD);
        addDrop(ModBlocks.STRIPPED_PINE_LOG);
        addDrop(ModBlocks.STRIPPED_PINE_WOOD);

        addDrop(ModBlocks.PINE_PLANKS);
        addDrop(ModBlocks.PINE_STAIRS);
        addDrop(ModBlocks.PINE_BUTTON);
        addDrop(ModBlocks.PINE_FENCE_GATE);
        addDrop(ModBlocks.PINE_FENCE);
        addDrop(ModBlocks.PINE_PRESSURE_PLATE);
        addDrop(ModBlocks.PINE_TRAPDOOR);
        addDrop(ModBlocks.PINE_DOOR, doorDrops(ModBlocks.PINE_DOOR));
        addDrop(ModBlocks.PINE_SLAB, slabDrops(ModBlocks.PINE_SLAB));

        addDrop(ModBlocks.PINE_STANDING_SIGN);
        addDrop(ModBlocks.PINE_WALL_SIGN);
        addDrop(ModBlocks.PINE_HANGING_SIGN);
        addDrop(ModBlocks.PINE_WALL_HANGING_SIGN);

        addDrop(ModBlocks.PINE_SAPLING);
        addDrop(ModBlocks.POTTED_PINE_SAPLING, pottedPlantDrops(ModBlocks.PINE_SAPLING));
        addDrop(ModBlocks.PINE_LEAVES, leavesDrops(ModBlocks.PINE_LEAVES, ModBlocks.PINE_SAPLING, 0.05f));
    }
}
