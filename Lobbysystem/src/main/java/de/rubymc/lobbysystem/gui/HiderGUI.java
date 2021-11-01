package de.rubymc.lobbysystem.gui;

import de.rubymc.lobbysystem.Main;
import de.rubymc.lobbysystem.util.ItemBuilder;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class HiderGUI implements Listener {

    Inventory inv;
    FileConfiguration config = Main.plugin.getConfig();

    @EventHandler
    public void openInventory(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getMaterial().equals(Material.LIME_DYE) || event.getMaterial().equals(Material.RED_DYE) || event.getMaterial().equals(Material.PURPLE_DYE) || event.getMaterial().equals(Material.ORANGE_DYE)) {
                GUI();

                player.openInventory(inv);
            }
        }
    }

    private void GUI() {
        inv = Bukkit.createInventory(null, InventoryType.BREWING, "§0➥ Playerhider");

        List<String> infolore = new ArrayList<>();
        infolore.add("§7Hier kannst du Spieler nach");
        infolore.add("§7belieben deaktivieren ^^");
        inv.setItem(4, new ItemBuilder(Material.WRITABLE_BOOK).setDisplayName("§8> §6Information").setLore(infolore).build());

        inv.setItem(3, new ItemBuilder(Material.LIME_DYE).setDisplayName("§aAlle anzeigen").build());
        inv.setItem(2, new ItemBuilder(Material.PURPLE_DYE).setDisplayName("§5Freunde anzeigen").build());
        inv.setItem(1, new ItemBuilder(Material.ORANGE_DYE).setDisplayName("§6VIP anzeigen").build());
        inv.setItem(0, new ItemBuilder(Material.RED_DYE).setDisplayName("§cKeine anzeigen").build());
    }

    // Check
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        event.setCancelled(true);
        int slot = event.getRawSlot();

        // Alle
        if (slot == 3) {
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 3);

            ItemStack playerhider = new ItemBuilder(Material.LIME_DYE).setDisplayName("§6Playerhider §8× §aAlle").build();
            player.getInventory().setItem(5, playerhider);

            for(Player all : Bukkit.getOnlinePlayers()) {
                player.showPlayer(all);
            }

            player.closeInventory();
        }

        else if (slot == 0) {
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 3);

            ItemStack playerhider = new ItemBuilder(Material.RED_DYE).setDisplayName("§6Playerhider §8× §cKeine").build();
            player.getInventory().setItem(5, playerhider);

            for(Player all : Bukkit.getOnlinePlayers()) {
                player.hidePlayer(all);
            }

            player.closeInventory();
        }

        else if (slot == 1) {
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 3);

            ItemStack playerhider = new ItemBuilder(Material.ORANGE_DYE).setDisplayName("§6Playerhider §8× §6VIP").build();
            player.getInventory().setItem(5, playerhider);

            for (Player all : Bukkit.getOnlinePlayers()) {
                if (all.hasPermission("lobby.vip")) {
                    player.showPlayer(all);
                }
                else {
                    player.hidePlayer(all);
                }
            }

            player.closeInventory();
        }

        else if (slot == 2) {
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 3);

            ItemStack playerhider = new ItemBuilder(Material.PURPLE_DYE).setDisplayName("§6Playerhider §8× §5Freunde").build();
            player.getInventory().setItem(5, playerhider);

            //Hier noch mit der PrimeAPI des Bungeesystems arbeiten!
            for (Player all : Bukkit.getOnlinePlayers()) {
                player.showPlayer(all);
            }

            player.closeInventory();
        }
    }
}
