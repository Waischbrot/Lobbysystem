package de.rubymc.lobbysystem.listener;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        String message = ChatColor.translateAlternateColorCodes('&', event.getMessage());
        String rang = PlaceholderAPI.setPlaceholders(player, "%vault_prefix%");

        event.setFormat(rang + player.getName() + " §8➽ §7" + message);
    }
}
