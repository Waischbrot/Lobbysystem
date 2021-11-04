package de.rubymc.lobbysystem.features;

import de.rubymc.lobbysystem.Main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

public class JoinMessage implements Listener {

    FileConfiguration config = Main.plugin.getConfig();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        List<String> list = config.getStringList("joinmessage.message");

        if (config.getBoolean("joinmessage.enabled")) {
            for (String message : list) {
                String messagecolour = ChatColor.translateAlternateColorCodes('&', message);
                messagecolour = PlaceholderAPI.setPlaceholders(player, messagecolour);
                player.sendMessage(messagecolour);
            }
        }
    }

    @EventHandler
    public void joinMessage(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage("");
    }

    @EventHandler
    public void leaveMessage(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        event.setQuitMessage("");
    }
}