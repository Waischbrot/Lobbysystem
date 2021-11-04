package de.rubymc.lobbysystem.listener;

import de.rubymc.lobbysystem.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ItemClickListener implements Listener {

    @EventHandler
    public void inventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        FileConfiguration config = Main.plugin.getConfig();

        if (event.getClickedInventory().equals(player.getInventory())) {
            if (event.getSlot() == 20) {
                String message = ChatColor.translateAlternateColorCodes('&', config.getString("messages.socials.instagram"));
                String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
                player.sendMessage(prefix + message);
            }

            else if (event.getSlot() == 22) {
                String message = ChatColor.translateAlternateColorCodes('&', config.getString("messages.socials.discord"));
                String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
                player.sendMessage(prefix + message);
            }

            else if (event.getSlot() == 24) {
                String message = ChatColor.translateAlternateColorCodes('&', config.getString("messages.socials.website"));
                String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
                player.sendMessage(prefix + message);
            }
        }
    }
}