package de.rubymc.lobbysystem.gui;

import de.rubymc.lobbysystem.Main;
import de.rubymc.lobbysystem.util.ItemBuilder;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class LobbyGUI implements Listener {

    Inventory inv;
    FileConfiguration config = Main.plugin.getConfig();

    @EventHandler
    public void openInventory(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getMaterial().equals(Material.NETHER_STAR)) {
                GUI();

                player.openInventory(inv);
            }
        }
    }

    //CloudNet API nutzen ^^
    private void GUI() {
        ItemStack fulllobby = new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("").getSkull("").build();
        ItemStack emptylobby = new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("").getSkull("").build();
        List<String> offlore = new ArrayList<>();
        offlore.add("");
        offlore.add("§7Status: §cOffline");
        offlore.add("§7Spieler: §c0");
        ItemStack offlobby = new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("").getSkull("http://textures.minecraft.net/texture/884e92487c6749995b79737b8a9eb4c43954797a6dd6cd9b4efce17cf475846").setLore(offlore).build();

        inv = Bukkit.createInventory(null, InventoryType.HOPPER, "§0➥ Lobbys");

        for (int i = 0; i <= 4; i++) {
            inv.setItem(i, offlobby);
        }
    }
}