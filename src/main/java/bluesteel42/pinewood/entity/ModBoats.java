package bluesteel42.pinewood.entity;

import bluesteel42.pinewood.PineWood;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModBoats {
    public static final Identifier PINE_BOATS_ID = Identifier.of(PineWood.MOD_ID, "pine");

    public static final Item PINE_BOAT = registerBoatItem("pine_boat", ModBoats.PINE_BOATS_ID, false, false);
    public static final Item PINE_CHEST_BOAT = registerBoatItem("pine_chest_boat", ModBoats.PINE_BOATS_ID, true, false);

    public static Item registerBoatItem(String path, Identifier boatId, boolean chest, boolean raft) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PineWood.MOD_ID, path));
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
                    itemGroup.addAfter(Items.PALE_OAK_CHEST_BOAT, ModBoats.PINE_CHEST_BOAT);
                    itemGroup.addAfter(Items.PALE_OAK_CHEST_BOAT, ModBoats.PINE_BOAT);
                });

    }

}
