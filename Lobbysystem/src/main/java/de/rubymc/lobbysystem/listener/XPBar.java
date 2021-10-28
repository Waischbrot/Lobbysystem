package de.rubymc.lobbysystem.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class XPBar implements Listener {

    @EventHandler
    public void xpBar(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setLevel(2021);
        player.setExp(1.0f);
    }
}
