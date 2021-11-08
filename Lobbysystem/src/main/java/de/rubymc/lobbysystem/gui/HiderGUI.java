package de.rubymc.lobbysystem.gui;

import de.rubymc.lobbysystem.util.ItemBuilder;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class HiderGUI implements Listener {

    Inventory inv;

    @EventHandler
    public void openInventory(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (player.hasPermission("lobby.build") && player.getGameMode().equals(GameMode.CREATIVE)) {
            return;
        }

        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getMaterial().equals(Material.LIME_DYE) || event.getMaterial().equals(Material.RED_DYE) || event.getMaterial().equals(Material.PURPLE_DYE) || event.getMaterial().equals(Material.ORANGE_DYE)) {
                GUI();

                player.openInventory(inv);
            }
        }
    }

    private void GUI() {
        inv = Bukkit.createInventory(null, 45, "§0➥ Playerhider");

        for (int i = 0; i <= 8; i++) {
            inv.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            inv.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }

        List<String> infolore = new ArrayList<>();
        infolore.add("§7Hier kannst du Spieler nach");
        infolore.add("§7belieben deaktivieren ^^");
        inv.setItem(4, new ItemBuilder(Material.WRITABLE_BOOK).setDisplayName("§8> §6Information").setLore(infolore).build());

        inv.setItem(13, new ItemBuilder(Material.LIME_DYE).setDisplayName("§aAlle anzeigen").build());
        inv.setItem(21, new ItemBuilder(Material.PURPLE_DYE).setDisplayName("§5Freunde anzeigen").build());
        inv.setItem(23, new ItemBuilder(Material.ORANGE_DYE).setDisplayName("§6VIP anzeigen").build());
        inv.setItem(31, new ItemBuilder(Material.RED_DYE).setDisplayName("§cKeine anzeigen").build());
    }

    // Check
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (player.hasPermission("lobby.build") && player.getGameMode().equals(GameMode.CREATIVE)) {
            return;
        }

        event.setCancelled(true);
        int slot = event.getRawSlot();

        if (event.getInventory() != inv) {
            return;
        }

        // Alle
        if (slot == 13) {
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 3);

            ItemStack playerhider = new ItemBuilder(Material.LIME_DYE).setDisplayName("§bPlayerhider §8× §aAlle").build();
            player.getInventory().setItem(5, playerhider);

            for(Player all : Bukkit.getOnlinePlayers()) {
                player.showPlayer(all);
            }

            player.closeInventory();
        }

        else if (slot == 31) {
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 3);

            ItemStack playerhider = new ItemBuilder(Material.RED_DYE).setDisplayName("§bPlayerhider §8× §cKeine").build();
            player.getInventory().setItem(5, playerhider);

            for(Player all : Bukkit.getOnlinePlayers()) {
                player.hidePlayer(all);
            }

            player.closeInventory();
        }

        else if (slot == 23) {
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 3);

            ItemStack playerhider = new ItemBuilder(Material.ORANGE_DYE).setDisplayName("§bPlayerhider §8× §6VIP").build();
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

        else if (slot == 21) {
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 3);

            ItemStack playerhider = new ItemBuilder(Material.PURPLE_DYE).setDisplayName("§bPlayerhider §8× §5Freunde").build();
            player.getInventory().setItem(5, playerhider);

            for(Player all : Bukkit.getOnlinePlayers()) {
                player.hidePlayer(all);
            }

            player.closeInventory();
        }
    }
}
