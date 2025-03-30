package bluesteel42.pinewood.datagen;

import bluesteel42.pinewood.block.ModBlocks;
import bluesteel42.pinewood.entity.ModBoats;
import bluesteel42.pinewood.item.ModItems;
import bluesteel42.pinewood.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.PINE_LOGS)
                .add(ModBlocks.PINE_LOG.asItem())
                .add(ModBlocks.PINE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_PINE_LOG.asItem())
                .add(ModBlocks.STRIPPED_PINE_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN).addTag(ModTags.Items.PINE_LOGS);
        getOrCreateTagBuilder(ItemTags.PLANKS).add(ModBlocks.PINE_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(ModBlocks.PINE_STAIRS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(ModBlocks.PINE_SLAB.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS).add(ModBlocks.PINE_DOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS).add(ModBlocks.PINE_TRAPDOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(ModBlocks.PINE_FENCE.asItem());
        getOrCreateTagBuilder(ItemTags.FENCE_GATES).add(ModBlocks.PINE_FENCE_GATE.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS).add(ModBlocks.PINE_BUTTON.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.PINE_PRESSURE_PLATE.asItem());

        getOrCreateTagBuilder(ItemTags.SIGNS).add(ModItems.PINE_SIGN);
        getOrCreateTagBuilder(ItemTags.HANGING_SIGNS).add(ModItems.PINE_HANGING_SIGN);

        getOrCreateTagBuilder(ItemTags.BOATS).add(ModBoats.PINE_BOAT.asItem());
        getOrCreateTagBuilder(ItemTags.CHEST_BOATS).add(ModBoats.PINE_CHEST_BOAT.asItem());

        getOrCreateTagBuilder(ItemTags.LEAVES).add(ModBlocks.PINE_LEAVES.asItem());
        getOrCreateTagBuilder(ItemTags.SAPLINGS).add(ModBlocks.PINE_SAPLING.asItem());
    }
}
