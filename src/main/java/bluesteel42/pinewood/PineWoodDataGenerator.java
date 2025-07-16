package bluesteel42.pinewood;

import bluesteel42.pinewood.datagen.*;
import bluesteel42.pinewood.standard_wood_initializer.datagen.*;
import bluesteel42.pinewood.world.ModConfiguredFeatures;
import bluesteel42.pinewood.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class PineWoodDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(StandardWoodModBlockTagProvider::new);
		pack.addProvider(StandardWoodModItemTagProvider::new);
		pack.addProvider(StandardWoodModLootTableProvider::new);
		pack.addProvider(StandardWoodModModelProvider::new);
		pack.addProvider(StandardWoodModRecipeProvider::new);
		pack.addProvider(ModRegistryDataGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}

}
