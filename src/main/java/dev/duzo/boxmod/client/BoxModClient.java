package dev.duzo.boxmod.client;

import dev.duzo.boxmod.ait.BoxExteriors;
import dev.duzo.boxmod.client.ait.BoxExteriorsClient;
import net.fabricmc.api.ClientModInitializer;

public class BoxModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BoxExteriorsClient.register();
    }
}
