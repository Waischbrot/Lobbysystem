package de.rubymc.lobbysystem.listener;

import de.rubymc.lobbysystem.commands.Build;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BauEvent implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (Build.build.contains(player)) {
            event.setCancelled(false);
        } else if (!Build.build.contains(player)) {
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (Build.build.contains(player)) {
            event.setCancelled(false);
        } else if (!Build.build.contains(player)) {
            event.setCancelled(true);
        }
    }
}

