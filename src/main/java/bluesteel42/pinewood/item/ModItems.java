package bluesteel42.pinewood.item;

import bluesteel42.pinewood.PineWood;
import bluesteel42.pinewood.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PINE_SIGN = registerSignItem("pine_sign");
    public static final Item PINE_HANGING_SIGN = registerHangingSignItem("pine_hanging_sign");

    public static Item registerSignItem(String path) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PineWood.MOD_ID, path));
        final Item item = new SignItem(
                ModBlocks.PINE_STANDING_SIGN,
                ModBlocks.PINE_WALL_SIGN,
                new Item.Settings().registryKey(registryKey).maxCount(16));

        return Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }

    public static Item registerHangingSignItem(String path) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PineWood.MOD_ID, path));
        final Item item = new HangingSignItem(
                ModBlocks.PINE_HANGING_SIGN,
                ModBlocks.PINE_WALL_HANGING_SIGN,
                new Item.Settings().registryKey(registryKey).maxCount(16));

        return Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.PALE_OAK_HANGING_SIGN, ModItems.PINE_HANGING_SIGN);
                    itemGroup.addAfter(Items.PALE_OAK_HANGING_SIGN, ModItems.PINE_SIGN);
                });

    }
}
