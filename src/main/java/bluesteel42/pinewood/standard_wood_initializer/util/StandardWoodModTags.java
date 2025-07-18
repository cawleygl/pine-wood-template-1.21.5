package bluesteel42.pinewood.standard_wood_initializer.util;

import bluesteel42.pinewood.standard_wood_initializer.StandardWoodInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class StandardWoodModTags {
    public static class Blocks {
        public static final TagKey<Block> MOD_LOGS = createTag(StandardWoodInitializer.WOOD_TYPE + "_logs");

        public static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(StandardWoodInitializer.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> MOD_LOGS = createTag(StandardWoodInitializer.WOOD_TYPE + "_logs");

        public static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(StandardWoodInitializer.MOD_ID, name));
        }
    }
}
