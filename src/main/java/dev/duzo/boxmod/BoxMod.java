package dev.duzo.boxmod;

import dev.duzo.boxmod.ait.BoxExteriors;
import net.fabricmc.api.ModInitializer;

public class BoxMod implements ModInitializer {
    public static final String MOD_ID = "boxmod";

    @Override
    public void onInitialize() {
        BoxExteriors.register();
    }
}
