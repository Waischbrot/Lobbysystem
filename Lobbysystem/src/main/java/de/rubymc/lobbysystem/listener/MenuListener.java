package de.rubymc.lobbysystem.listener;

import de.rubymc.lobbysystem.Main;
import de.rubymc.lobbysystem.gui.Inventories;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class MenuListener implements Listener {

    FileConfiguration config = Main.plugin.getConfig();

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem().getItemMeta().getDisplayName().equals("§bNavigator §8× §7Rechtsklick")) {
                Inventories.openNavigator(player);
            }
            else if (event.getItem().getItemMeta().getDisplayName().equals("§bProfil §8× §7Rechtsklick")) {
                Inventories.profileGUI(player);
            }
            else if (event.getMaterial() == Material.LIME_DYE && event.getMaterial() == Material.RED_DYE && event.getMaterial() == Material.YELLOW_DYE && event.getMaterial() == Material.GREEN_DYE && event.getMaterial() == Material.ORANGE_DYE && event.getMaterial() == Material.BLACK_DYE && event.getMaterial() == Material.PURPLE_DYE) {
                Inventories.hiderGUI(player);
            }
            else if (event.getItem().getItemMeta().getDisplayName().equals("§bKosmetik §8× §7Rechtsklick")) {
                Inventories.effectGUI(player);
            }
            else if (event.getItem().getItemMeta().getDisplayName().equals("§bEinstellungen §8× §7Rechtsklick")) {
                Inventories.settingsGUI(player);
            }
            else if (event.getItem().getItemMeta().getDisplayName().equals("§eLobbyswitcher §8× §7Rechtsklick")) {
                Inventories.openLobbyswitcher(player);
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        int slot = event.getRawSlot();
        String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));

        //Inventaritems
        if (event.getClickedInventory() == player.getInventory()) {
            //Socials
            if (slot == 20 && event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                String instagram = ChatColor.translateAlternateColorCodes('&', config.getString("messages.socials.instagram"));
                player.sendMessage(prefix + instagram);
            }
            else if (slot == 22 && event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                String discord = ChatColor.translateAlternateColorCodes('&', config.getString("messages.socials.discord"));
                player.sendMessage(prefix + discord);
            }
            else if (slot == 24 && event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                String website = ChatColor.translateAlternateColorCodes('&', config.getString("messages.socials.website"));
                player.sendMessage(prefix + website);
            }
            //Cosmetics
            else if (slot == 19 && event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                Inventories.effectGUI(player);
            }
            else if (slot == 21 && event.getCurrentItem().getType() == Material.IRON_CHESTPLATE) {
                Inventories.armorGUI(player);
            }
            else if (slot == 23 && event.getCurrentItem().getType() == Material.FISHING_ROD) {
                Inventories.gadgetsGUI(player);
            }
            else if (slot == 25 && event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                Inventories.petsGUI(player);
            }
        }
        //Navigatoritems
        if (event.getClickedInventory().getItem(40).getType() == Material.SNOWBALL) {
            if (slot == 11) {
                player.performCommand("warp freebuild");
            }
            else if (slot == 29) {
                player.performCommand("warp bauserver1");
            }
            else if (slot == 31) {
                player.performCommand("warp bauserver2");
            }
            else if (slot == 33) {
                player.performCommand("warp bauserver3");
            }
            else if (slot == 13 || slot == 15 || slot == 21 || slot == 23) {
                String maintenance = ChatColor.translateAlternateColorCodes('&', config.getString("messages.games.maintenance"));
                player.sendMessage(prefix + maintenance);
            }
            else if (slot == 40) {
                player.performCommand("spawn");
            }
        }
    }
}
