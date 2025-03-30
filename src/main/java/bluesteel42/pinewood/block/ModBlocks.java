package bluesteel42.pinewood.block;

import bluesteel42.pinewood.PineWood;
import bluesteel42.pinewood.world.tree.ModSaplingGenerators;
import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    public static final Block PINE_LOG = registerBlock("pine_log", PillarBlock::new, Blocks.createLogSettings(MapColor.TERRACOTTA_WHITE, MapColor.TERRACOTTA_ORANGE, BlockSoundGroup.WOOD));
    public static final Block PINE_WOOD = registerBlock("pine_wood", PillarBlock::new, Blocks.createLogSettings(MapColor.TERRACOTTA_ORANGE, MapColor.TERRACOTTA_ORANGE, BlockSoundGroup.WOOD));
    public static final Block STRIPPED_PINE_LOG = registerBlock("stripped_pine_log", PillarBlock::new, Blocks.createLogSettings(MapColor.TERRACOTTA_WHITE, MapColor.TERRACOTTA_WHITE, BlockSoundGroup.WOOD));
    public static final Block STRIPPED_PINE_WOOD = registerBlock("stripped_pine_wood", PillarBlock::new, Blocks.createLogSettings(MapColor.TERRACOTTA_WHITE, MapColor.TERRACOTTA_WHITE, BlockSoundGroup.WOOD));
    public static final Block PINE_PLANKS = registerBlock(
            "pine_planks",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
    );
    public static final Block PINE_STAIRS = registerBlock(
            "pine_stairs",
            settings -> new StairsBlock(PINE_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(PINE_PLANKS)
    );
    public static final Block PINE_SLAB = registerBlock(
            "pine_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
    );
    public static final Block PINE_BUTTON = registerBlock(
            "pine_button",
            settings -> new ButtonBlock(BlockSetType.OAK, 30, settings),
            AbstractBlock.Settings.create()
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block PINE_PRESSURE_PLATE = registerBlock(
            "pine_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(0.5F)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block PINE_FENCE = registerBlock(
            "pine_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
    );
    public static final Block PINE_FENCE_GATE = registerBlock(
            "pine_fence_gate",
            settings -> new FenceGateBlock(WoodType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .burnable()
    );
    public static final Block PINE_DOOR = registerNonOpaqueBlock(
            "pine_door",
            settings -> new DoorBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block PINE_TRAPDOOR = registerNonOpaqueBlock(
            "pine_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .burnable()
    );
    public static final Identifier PINE_SIGN_TEXTURE = Identifier.of(PineWood.MOD_ID, "entity/signs/pine");
    public static final Identifier PINE_HANGING_SIGN_TEXTURE = Identifier.of(PineWood.MOD_ID, "entity/signs/hanging/pine");
    public static final Identifier PINE_HANGING_GUI_SIGN_TEXTURE = Identifier.of(PineWood.MOD_ID, "textures/gui/hanging_signs/pine");
    public static final Block PINE_STANDING_SIGN = registerBlockWithoutItem(
            "pine_standing_sign",
            settings -> new TerraformSignBlock(PINE_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN)
                    .mapColor(MapColor.TERRACOTTA_WHITE)
    );

    public static final Block PINE_WALL_SIGN = registerBlockWithoutItem(
            "pine_wall_sign",
            settings -> new TerraformWallSignBlock(PINE_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN).mapColor(MapColor.TERRACOTTA_WHITE).lootTable(PINE_STANDING_SIGN.getLootTableKey()).overrideTranslationKey(PINE_STANDING_SIGN.getTranslationKey())
    );

    public static final Block PINE_HANGING_SIGN = registerBlockWithoutItem(
            "pine_hanging_sign",
            settings -> new TerraformHangingSignBlock(PINE_HANGING_SIGN_TEXTURE, PINE_HANGING_GUI_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)
                    .mapColor(MapColor.TERRACOTTA_WHITE)
    );

    public static final Block PINE_WALL_HANGING_SIGN = registerBlockWithoutItem(
            "pine_hanging_wall_sign",
            settings -> new TerraformWallHangingSignBlock(PINE_HANGING_SIGN_TEXTURE, PINE_HANGING_GUI_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.TERRACOTTA_WHITE).lootTable(PINE_HANGING_SIGN.getLootTableKey()).overrideTranslationKey(PINE_HANGING_SIGN.getTranslationKey())
    );

    public static final BlockFamily PINE_SIGN_FAMILY = BlockFamilies.register(ModBlocks.PINE_PLANKS)
            .sign(ModBlocks.PINE_STANDING_SIGN, ModBlocks.PINE_WALL_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static final BlockFamily PINE_HANGING_SIGN_FAMILY = BlockFamilies.register(ModBlocks.STRIPPED_PINE_LOG)
            .sign(ModBlocks.PINE_HANGING_SIGN, ModBlocks.PINE_WALL_HANGING_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static final Block PINE_LEAVES = registerNonOpaqueBlock(
            "pine_leaves",
            settings -> new TintedParticleLeavesBlock(0.01F, settings),
            Blocks.createLeavesSettings(BlockSoundGroup.GRASS)
    );
    public static final Block PINE_SAPLING = registerNonOpaqueBlock(
            "pine_sapling",
            settings -> new SaplingBlock(ModSaplingGenerators.PINE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)
    );
    public static final Block POTTED_PINE_SAPLING = registerNonOpaqueBlock(
            "potted_pine_sapling",
            settings -> new FlowerPotBlock(PINE_SAPLING, settings),
            Blocks.createFlowerPotSettings()
    );

    private static Block registerBlock(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(PineWood.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);

        return block;
    }

    private static Block registerNonOpaqueBlock(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(PineWood.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);

        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());

        Items.register(block);

        return block;
    }

    private static Block registerBlockWithoutItem(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(PineWood.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        return Blocks.register(registryKey, factory, settings);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.PINE_BUTTON);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.PINE_PRESSURE_PLATE);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.PINE_TRAPDOOR);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.PINE_DOOR);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.PINE_FENCE_GATE);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.PINE_FENCE);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.PINE_SLAB);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.PINE_STAIRS);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.PINE_PLANKS);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.STRIPPED_PINE_WOOD);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.STRIPPED_PINE_LOG);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.PINE_WOOD);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.PINE_LOG);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.PALE_OAK_LOG, ModBlocks.PINE_LOG);
                    itemGroup.addAfter(Items.PALE_OAK_LEAVES, ModBlocks.PINE_LEAVES);
                    itemGroup.addAfter(Items.PALE_OAK_SAPLING, ModBlocks.PINE_SAPLING);
                });
    }
}
