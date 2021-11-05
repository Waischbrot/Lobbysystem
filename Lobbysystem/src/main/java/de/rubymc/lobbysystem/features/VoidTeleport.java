package de.rubymc.lobbysystem.features;

import de.rubymc.lobbysystem.Main;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class VoidTeleport implements Listener {

    FileConfiguration config = Main.plugin.getConfig();

    @EventHandler
    public void onVoidDrop(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();

        if (!player.hasPermission("lobby.build") || !player.getGameMode().equals(GameMode.CREATIVE)) {
            if (location.getY() < 45.0) {

                location.setX(config.getLong("warps.spawn.location.X"));
                location.setY(config.getLong("warps.spawn.location.Y"));
                location.setZ(config.getLong("warps.spawn.location.Z"));
                location.setYaw(config.getLong("warps.spawn.location.YAW"));
                location.setPitch(config.getLong("warps.spawn.location.PITCH"));

                player.teleport(location);
            }
        }
    }
}
