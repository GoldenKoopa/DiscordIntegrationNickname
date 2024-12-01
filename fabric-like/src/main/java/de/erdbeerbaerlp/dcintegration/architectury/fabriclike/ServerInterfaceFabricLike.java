package de.erdbeerbaerlp.dcintegration.architectury.fabriclike;

import de.erdbeerbaerlp.dcintegration.common.util.MinecraftPermission;
import me.lucko.fabric.api.permissions.v0.Permissions;
import net.minecraft.world.entity.player.Player;

import java.util.UUID;

public class ServerInterfaceFabricLike {
    public static boolean playerHasPermissionsX(UUID player, String... permissions) {
        for (String permission : permissions) {
            for (final MinecraftPermission perm : MinecraftPermission.values()) {
                if(perm.getAsString().equals(permission)){
                    if(Permissions.check(player,perm.getAsString(), perm.getDefaultValue()).join()){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean playerHasPermissionsX(Player player, String... permissions) {
        for (String permission : permissions) {
            for (MinecraftPermission value : MinecraftPermission.values()) {
                if(value.getAsString().equals(permission)){
                    if(Permissions.check(player,value.getAsString(), value.getDefaultValue())){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
