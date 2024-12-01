package de.erdbeerbaerlp.dcintegration.architectury.fabric;

import de.erdbeerbaerlp.dcintegration.architectury.fabriclike.DiscordIntegrationFabricLike;
import net.fabricmc.api.DedicatedServerModInitializer;

public final class DiscordIntegrationFabric implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        DiscordIntegrationFabricLike.init();
    }
}
