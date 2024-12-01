package de.erdbeerbaerlp.dcintegration.architectury.quilt;

import net.fabricmc.api.ModInitializer;
import org.quiltmc.loader.api.ModContainer;

import de.erdbeerbaerlp.dcintegration.architectury.fabriclike.DiscordIntegrationFabricLike;

public final class DiscordIntegrationQuilt implements ModInitializer{
    public void onInitialize() {
        // Run the Fabric-like setup.
        DiscordIntegrationFabricLike.init();
    }
}
