package bluesteel42.pinewood;

import bluesteel42.pinewood.standard_wood_initializer.StandardWoodInitializer;
import net.fabricmc.api.ClientModInitializer;

public class PineWoodClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        StandardWoodInitializer.initializeWoodTypeClient();
    }
}
