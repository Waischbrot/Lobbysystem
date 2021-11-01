package de.rubymc.lobbysystem.listener;

import de.rubymc.lobbysystem.Main;
import de.rubymc.lobbysystem.gui.CosmeticGUI;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ItemClickListener implements Listener {

    FileConfiguration config = Main.plugin.getConfig();

    @EventHandler
    public void inventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§6Instagram §8× §7Folgen")) {
            String message = ChatColor.translateAlternateColorCodes('&', config.getString("messages.socials.instagram"));
            String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
            player.sendMessage(prefix + message);
        }

        else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§bDiscord §8× §7Beitreten")) {
            String message = ChatColor.translateAlternateColorCodes('&', config.getString("messages.socials.discord"));
            String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
            player.sendMessage(prefix + message);
        }

        else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§6Website §8× §7Klick")) {
            String message = ChatColor.translateAlternateColorCodes('&', config.getString("messages.socials.website"));
            String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
            player.sendMessage(prefix + message);
        }
    }
}