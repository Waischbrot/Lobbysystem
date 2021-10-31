package de.rubymc.lobbysystem.listener;

import de.rubymc.lobbysystem.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class JoinMessage implements Listener {

    FileConfiguration config = Main.plugin.getConfig();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        List<String> list = config.getStringList("joinmessage.message");

        if (config.getBoolean("joinmessage.enabled"))
            for (String message : list) {
                String messagecolour = ChatColor.translateAlternateColorCodes('&', message);
                player.sendMessage(messagecolour);
            }
    }
}
