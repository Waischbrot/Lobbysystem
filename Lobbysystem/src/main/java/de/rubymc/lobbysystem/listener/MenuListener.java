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
            if (player.getItemInHand().getItemMeta().getDisplayName().equals("§bNavigator §8× §7Rechtsklick")) {
                Inventories.openNavigator(player);
            }
            else if (player.getItemInHand().getItemMeta().getDisplayName().equals("§bProfil §8× §7Rechtsklick")) {
                Inventories.profileGUI(player);
            }
            else if (player.getItemInHand().getItemMeta().getDisplayName().equals("§bPlayerhider §8× §aAlle")) {
                Inventories.hiderGUI(player);
            }
            else if (player.getItemInHand().getItemMeta().getDisplayName().equals("§bKosmetik §8× §7Rechtsklick")) {
                Inventories.effectGUI(player);
            }
            else if (player.getItemInHand().getItemMeta().getDisplayName().equals("§bEinstellungen §8× §7Rechtsklick")) {
                Inventories.settingsGUI(player);
            }
            else if (player.getItemInHand().getItemMeta().getDisplayName().equals("§eLobbyswitcher §8× §7Rechtsklick")) {
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
            if (slot == 20) {
                String instagram = ChatColor.translateAlternateColorCodes('&', config.getString("messages.socials.instagram"));
                player.sendMessage(prefix + instagram);
            }
            else if (slot == 22) {
                String discord = ChatColor.translateAlternateColorCodes('&', config.getString("messages.socials.discord"));
                player.sendMessage(prefix + discord);
            }
            else if (slot == 24) {
                String website = ChatColor.translateAlternateColorCodes('&', config.getString("messages.socials.website"));
                player.sendMessage(prefix + website);
            }
            //Cosmetics
            else if (slot == 19) {
                Inventories.effectGUI(player);
            }
            else if (slot == 21) {
                Inventories.armorGUI(player);
            }
            else if (slot == 23) {
                Inventories.gadgetsGUI(player);
            }
            else if (slot == 25) {
                Inventories.petsGUI(player);
            }
        }
        else {
            //Navigatoritems
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lFree§2§lbuild")) {
                player.performCommand("warp Freebuild");
            }
            else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§f§lBauserver §e§l1.8")) {
                player.performCommand("warp Bauserver1");
            }
            else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§b§lBauserver §e§l1.16")) {
                player.performCommand("warp Bauserver2");
            }
            else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§6§lBauserver §e§l1.12")) {
                player.performCommand("warp Bauserver3");
            }
            else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§cKommt bald...")) {
                String maintenance = ChatColor.translateAlternateColorCodes('&', config.getString("messages.games.maintenance"));
                player.sendMessage(prefix + maintenance);
            }
            else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8> §bSpawn")) {
                player.performCommand("spawn");
            }
        }
    }
}
