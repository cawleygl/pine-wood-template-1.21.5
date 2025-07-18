package bluesteel42.pinewood.datagen;

import bluesteel42.pinewood.block.ModBlocks;
import bluesteel42.pinewood.standard_wood_initializer.block.StandardWoodModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    public void generateStandardWoodLootTables() {
        addDrop(StandardWoodModBlocks.MOD_LOG);
        addDrop(StandardWoodModBlocks.MOD_WOOD);
        addDrop(StandardWoodModBlocks.STRIPPED_MOD_LOG);
        addDrop(StandardWoodModBlocks.STRIPPED_MOD_WOOD);

        addDrop(StandardWoodModBlocks.MOD_PLANKS);
        addDrop(StandardWoodModBlocks.MOD_STAIRS);
        addDrop(StandardWoodModBlocks.MOD_BUTTON);
        addDrop(StandardWoodModBlocks.MOD_FENCE_GATE);
        addDrop(StandardWoodModBlocks.MOD_FENCE);
        addDrop(StandardWoodModBlocks.MOD_PRESSURE_PLATE);
        addDrop(StandardWoodModBlocks.MOD_TRAPDOOR);
        addDrop(StandardWoodModBlocks.MOD_DOOR, doorDrops(StandardWoodModBlocks.MOD_DOOR));
        addDrop(StandardWoodModBlocks.MOD_SLAB, slabDrops(StandardWoodModBlocks.MOD_SLAB));

        addDrop(StandardWoodModBlocks.MOD_STANDING_SIGN);
        addDrop(StandardWoodModBlocks.MOD_WALL_SIGN);
        addDrop(StandardWoodModBlocks.MOD_HANGING_SIGN);
        addDrop(StandardWoodModBlocks.MOD_WALL_HANGING_SIGN);

        addDrop(StandardWoodModBlocks.MOD_SAPLING);
        addDrop(StandardWoodModBlocks.POTTED_MOD_SAPLING, pottedPlantDrops(StandardWoodModBlocks.MOD_SAPLING));
//        addDrop(StandardWoodModBlocks.MOD_LEAVES, leavesDrops(StandardWoodModBlocks.MOD_LEAVES, StandardWoodModBlocks.MOD_SAPLING, 0.05f));
    }


    @Override
    public void generate() {
        generateStandardWoodLootTables();
        addDrop(ModBlocks.PINE_LEAVES, leavesDrops(ModBlocks.PINE_LEAVES, StandardWoodModBlocks.MOD_SAPLING, 0.05f));
        addDrop(ModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES, leavesDrops(ModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES, Blocks.SPRUCE_SAPLING, 0.05f));
    }
}
