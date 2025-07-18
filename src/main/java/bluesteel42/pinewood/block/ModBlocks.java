package bluesteel42.pinewood.block;

import bluesteel42.pinewood.PineWood;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final Block PINE_LEAVES = register(
            "pine_leaves",
            settings -> new TintedParticlePineNeedleLeavesBlock(0.01F, settings),
            Blocks.createLeavesSettings(BlockSoundGroup.GRASS),true,true
    );
    public static final Block SPRUCE_LEAVES_FALLING_NEEDLES = register(
            "spruce_leaves",
            settings -> new TintedParticleSpruceNeedleLeavesBlock(0.01F, settings),
            Blocks.createLeavesSettings(BlockSoundGroup.GRASS),true,true
    );

    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings, boolean registerItem, boolean nonOpaqueBlock) {
        final Identifier identifier = Identifier.of(PineWood.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);

        if (registerItem) {
            Items.register(block);
        }

        if (nonOpaqueBlock) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        }

        return block;
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.PALE_OAK_LEAVES, ModBlocks.PINE_LEAVES);
                    itemGroup.addAfter(Items.SPRUCE_LEAVES, ModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES);
                });
    }
}
