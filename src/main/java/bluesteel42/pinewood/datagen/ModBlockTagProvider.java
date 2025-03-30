package bluesteel42.pinewood.datagen;

import bluesteel42.pinewood.block.ModBlocks;
import bluesteel42.pinewood.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Blocks.PINE_LOGS)
                .add(ModBlocks.PINE_LOG)
                .add(ModBlocks.PINE_WOOD)
                .add(ModBlocks.STRIPPED_PINE_LOG)
                .add(ModBlocks.STRIPPED_PINE_WOOD);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).addTag(ModTags.Blocks.PINE_LOGS);
        getOrCreateTagBuilder(BlockTags.PLANKS).add(ModBlocks.PINE_PLANKS);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(ModBlocks.PINE_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(ModBlocks.PINE_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(ModBlocks.PINE_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.PINE_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.PINE_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.PINE_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(ModBlocks.PINE_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.PINE_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.STANDING_SIGNS).add(ModBlocks.PINE_STANDING_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_SIGNS).add(ModBlocks.PINE_WALL_SIGN);
        getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS).add(ModBlocks.PINE_HANGING_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(ModBlocks.PINE_WALL_HANGING_SIGN);

        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(ModBlocks.PINE_WALL_HANGING_SIGN);

        getOrCreateTagBuilder(BlockTags.LEAVES).add(ModBlocks.PINE_LEAVES);
        getOrCreateTagBuilder(BlockTags.SAPLINGS).add(ModBlocks.PINE_SAPLING);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(ModBlocks.POTTED_PINE_SAPLING);
    }
}
