package de.rubymc.lobbysystem.gui;

import de.rubymc.lobbysystem.Main;
import de.rubymc.lobbysystem.util.ItemBuilder;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class NavigatorGUI implements Listener {

    Inventory inv;
    FileConfiguration config = Main.plugin.getConfig();

    @EventHandler
    public void openInventory(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getMaterial().equals(Material.COMPASS)) {
                GUI();

                player.openInventory(inv);
            }
        }
    }

    private void GUI() {
        inv = Bukkit.createInventory(null, 45, "§0➥ Navigator");

        for (int i = 0; i <= 8; i++) {
            inv.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            inv.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }

        List<String> infolore = new ArrayList<>();
        infolore.add("§7Hier kannst du unsere Spielmodi");
        infolore.add("§7finden, und hast einen Überblick!");
        inv.setItem(4, new ItemBuilder(Material.WRITABLE_BOOK).setDisplayName("§8> §6Information").setLore(infolore).build());

        inv.setItem(40, new ItemBuilder(Material.SNOWBALL).setDisplayName("§8> §bSpawn").build());

        inv.setItem(11, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§aFreebuild").getSkull("http://textures.minecraft.net/texture/a33898d014250f264f6984d11bf152ec4af6478384aec8ae46965bd2c4f6f929").build());
        inv.setItem(13, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());
        inv.setItem(15, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());
        inv.setItem(21, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());
        inv.setItem(23, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());
        inv.setItem(29, new ItemBuilder(Material.IRON_PICKAXE).setDisplayName("§fBauserver §7(§e1.8§7)").build());
        inv.setItem(31, new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName("§bBauserver §7(§e1.16§7)").build());
        inv.setItem(33, new ItemBuilder(Material.GOLDEN_PICKAXE).setDisplayName("§6Bauserver §7(§e1.12§7)").build());
    }

    // Check
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        event.setCancelled(true);
        int slot = event.getRawSlot();

        //Spawn
        if (slot == 40) {

            player.closeInventory();
        }

        // Wartungsmodus
        else if (slot == 13 || slot == 15 || slot == 21 || slot == 23) {
            String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
            String message = ChatColor.translateAlternateColorCodes('&', config.getString("messages.games.maintenance"));
            player.sendMessage(prefix + message);

            player.closeInventory();
        }

        //Freebuild
        else if (slot == 11) {
            player.closeInventory();
        }

        //Bauserver1
        else if (slot == 29) {
            player.closeInventory();
        }

        //Bauserver2
        else if (slot == 31) {
            player.closeInventory();
        }

        //Bauserver3
        else if (slot == 33) {
            player.closeInventory();
        }

    }
}
