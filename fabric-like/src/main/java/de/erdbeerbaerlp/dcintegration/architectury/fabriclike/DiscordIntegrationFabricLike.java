package de.erdbeerbaerlp.dcintegration.architectury.fabriclike;

import de.erdbeerbaerlp.dcintegration.architectury.DiscordIntegrationMod;
import de.erdbeerbaerlp.dcintegration.architectury.util.MessageUtilsImpl;
import de.erdbeerbaerlp.dcintegration.common.DiscordIntegration;
import de.erdbeerbaerlp.dcintegration.common.WorkThread;
import de.erdbeerbaerlp.dcintegration.common.compat.DynmapListener;
import de.erdbeerbaerlp.dcintegration.common.storage.Configuration;
import de.erdbeerbaerlp.dcintegration.common.storage.Localization;
import de.erdbeerbaerlp.dcintegration.common.storage.linking.LinkManager;
import de.erdbeerbaerlp.dcintegration.common.util.DiscordMessage;
import de.erdbeerbaerlp.dcintegration.common.util.TextColors;
import me.drex.vanish.api.VanishAPI;
import me.drex.vanish.api.VanishEvents;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.loader.impl.FabricLoaderImpl;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;

import java.util.UUID;

import static de.erdbeerbaerlp.dcintegration.architectury.DiscordIntegrationMod.server;
import static de.erdbeerbaerlp.dcintegration.common.DiscordIntegration.INSTANCE;

public final class DiscordIntegrationFabricLike {
    public static void init() {
        DiscordIntegrationMod.init();
        if (!Configuration.instance().general.botToken.equals("INSERT BOT TOKEN HERE")) {
            ServerLifecycleEvents.SERVER_STARTED.register(DiscordIntegrationMod::serverStarted);
            ServerLifecycleEvents.SERVER_STARTING.register(DiscordIntegrationMod::serverStarting);
            ServerLifecycleEvents.SERVER_STARTING.register(DiscordIntegrationFabricLike::serverStarting);
            ServerLifecycleEvents.SERVER_STOPPED.register(DiscordIntegrationMod::serverStopped);
            ServerLifecycleEvents.SERVER_STOPPING.register(DiscordIntegrationMod::serverStopping);
        } else {
            DiscordIntegration.LOGGER.error("Please check the config file and set an bot token");
        }
    }

    public static void serverStarting(MinecraftServer minecraftServer) {
        if (FabricLoaderImpl.INSTANCE.isModLoaded("dynmap")) {
            new DynmapListener().register();
        }
        if(FabricLoaderImpl.INSTANCE.isModLoaded("melius-vanish")){
            VanishEvents.VANISH_EVENT.register(DiscordIntegrationMod::vanish);
        }
    }


}
