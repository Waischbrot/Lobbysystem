package de.rubymc.lobbysystem.listener;

import de.rubymc.lobbysystem.util.ItemBuilder;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import java.util.List;

public class ItemClickListener implements Listener {

    @EventHandler
    public void playerHider(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        try {
            if (event.getItem().getItemMeta().getDisplayName().equals("§bPlayerhider §8× §aAlle")) {
                Inventory hider = Bukkit.createInventory(player, InventoryType.BREWING);

                hider.setItem(0, new ItemBuilder(Material.RED_DYE).setDisplayName("§cAlle verstecken").build());

                hider.setItem(1, new ItemBuilder(Material.ORANGE_DYE).setDisplayName("§6Nur VIP").build());

                hider.setItem(2, new ItemBuilder(Material.PURPLE_DYE).setDisplayName("§5Nur Freunde").build());

                hider.setItem(3, new ItemBuilder(Material.LIME_DYE).setDisplayName("§aAlle anzeigen").build());

                hider.setItem(4, new ItemBuilder(Material.WRITTEN_BOOK).setDisplayName("§7Informationen").setLore("Test").build());


                player.openInventory(hider);
            }
        } catch (Exception e) {

        }
    }
}
