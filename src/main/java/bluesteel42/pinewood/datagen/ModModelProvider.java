package bluesteel42.pinewood.datagen;

import bluesteel42.pinewood.block.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.TexturedModel;
import net.minecraft.world.biome.FoliageColors;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.createLogTexturePool(ModBlocks.PINE_LOG).log(ModBlocks.PINE_LOG).wood(ModBlocks.PINE_WOOD);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_PINE_LOG).log(ModBlocks.STRIPPED_PINE_LOG).wood(ModBlocks.STRIPPED_PINE_WOOD);

        BlockStateModelGenerator.BlockTexturePool pinePlankPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PINE_PLANKS);
        pinePlankPool.stairs(ModBlocks.PINE_STAIRS);
        pinePlankPool.slab(ModBlocks.PINE_SLAB);
        pinePlankPool.button(ModBlocks.PINE_BUTTON);
        pinePlankPool.fence(ModBlocks.PINE_FENCE);
        pinePlankPool.fenceGate(ModBlocks.PINE_FENCE_GATE);
        pinePlankPool.pressurePlate(ModBlocks.PINE_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.PINE_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.PINE_TRAPDOOR);

        // Signs Textures
        pinePlankPool.family(ModBlocks.PINE_SIGN_FAMILY);
        pinePlankPool.family(ModBlocks.PINE_HANGING_SIGN_FAMILY);

        blockStateModelGenerator.registerTintedBlockAndItem(ModBlocks.PINE_LEAVES, TexturedModel.LEAVES, FoliageColors.SPRUCE);
        blockStateModelGenerator.registerFlowerPotPlantAndItem(ModBlocks.PINE_SAPLING, ModBlocks.POTTED_PINE_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
