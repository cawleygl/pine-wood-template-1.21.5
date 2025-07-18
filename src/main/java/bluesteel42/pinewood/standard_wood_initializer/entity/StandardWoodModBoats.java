package bluesteel42.pinewood.standard_wood_initializer.entity;

import bluesteel42.pinewood.standard_wood_initializer.StandardWoodInitializer;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class StandardWoodModBoats {
    public static final Identifier MOD_BOATS_ID = Identifier.of(StandardWoodInitializer.MOD_ID, StandardWoodInitializer.WOOD_TYPE);

    public static final Item MOD_BOAT = registerBoatItem(StandardWoodInitializer.WOOD_TYPE + "_boat", StandardWoodModBoats.MOD_BOATS_ID, false, false);
    public static final Item MOD_CHEST_BOAT = registerBoatItem(StandardWoodInitializer.WOOD_TYPE + "_chest_boat", StandardWoodModBoats.MOD_BOATS_ID, true, false);

    public static Item registerBoatItem(String path, Identifier boatId, boolean chest, boolean raft) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(StandardWoodInitializer.MOD_ID, path));
        return TerraformBoatItemHelper.registerBoatItem(
                boatId,
                new Item.Settings().maxCount(1).registryKey(registryKey),
                chest,
                raft
        );
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.PALE_OAK_CHEST_BOAT, StandardWoodModBoats.MOD_CHEST_BOAT);
                    itemGroup.addAfter(Items.PALE_OAK_CHEST_BOAT, StandardWoodModBoats.MOD_BOAT);
                });

    }
}
