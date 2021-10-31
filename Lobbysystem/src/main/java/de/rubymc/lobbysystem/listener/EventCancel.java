package de.rubymc.lobbysystem.listener;

import de.rubymc.lobbysystem.util.ItemBuilder;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.*;

public class EventCancel implements Listener {

    @EventHandler
    public void BlockPlaceEvent(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("lobby.build") || !player.getGameMode().equals(GameMode.CREATIVE)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void BlockBreakEvent(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("lobby.build") || !player.getGameMode().equals(GameMode.CREATIVE)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("lobby.build") || !player.getGameMode().equals(GameMode.CREATIVE)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void secondHand(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("lobby.build") || !player.getGameMode().equals(GameMode.CREATIVE)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void inventoryClickEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getInventory().equals(player.getInventory())) {
            if (!player.hasPermission("lobby.build") || !player.getGameMode().equals(GameMode.CREATIVE)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void inventoryMoveEvent(InventoryMoveItemEvent event) {
        Player player = (Player) event.getInitiator();
        if (!player.hasPermission("lobby.build") || !player.getGameMode().equals(GameMode.CREATIVE)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void inventoryDragEvent(InventoryDragEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (!player.hasPermission("lobby.build") || !player.getGameMode().equals(GameMode.CREATIVE)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void armorstand(PlayerArmorStandManipulateEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("lobby.build") || !player.getGameMode().equals(GameMode.CREATIVE)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemFrame(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("lobby.build") || !player.getGameMode().equals(GameMode.CREATIVE)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPickup(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("lobby.build") || !player.getGameMode().equals(GameMode.CREATIVE)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onGamemodeChange(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();
        if(player.hasPermission("lobby.build") && event.getNewGameMode().equals(GameMode.CREATIVE) && player.getGameMode().equals(GameMode.SURVIVAL)) {
            player.getInventory().clear();
        }
        else if (event.getNewGameMode().equals(GameMode.SURVIVAL)) {
            player.getInventory().clear();
            for (int i = 9; i <= 35; i++) {
                player.getInventory().setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§c").build());
            }
            player.getInventory().setItem(20, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§6Instagram §8× §7Folgen").getSkull("http://textures.minecraft.net/texture/25b3f2cfa0739c4e828316f39f90b05bc1f4ed27b1e35888511f558d4675").build());
            player.getInventory().setItem(22, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§bDiscord §8× §7Beitreten").getSkull("http://textures.minecraft.net/texture/4d42337be0bdca2128097f1c5bb1109e5c633c17926af5fb6fc20000011aeb53").build());
            player.getInventory().setItem(24, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§6Website §8× §7Klick").getSkull("http://textures.minecraft.net/texture/b3175286cd3ba1a3a9c9082977d09dd37b177abf37a466580c27d1dee72b3c18").build());
            player.getInventory().setItem(4, new ItemBuilder(Material.COMPASS).setDisplayName("§bNavigator §8× §7Rechtsklick").setGlow(true).build());
            player.getInventory().setItem(8, new ItemBuilder(Material.PLAYER_HEAD, (short) 3).setHead(player.getName()).setDisplayName("§bProfil §8× §7Rechtsklick").build());
            player.getInventory().setItem(5, new ItemBuilder(Material.LIME_DYE).setDisplayName("§bPlayerhider §8× §aAlle").build());
            player.getInventory().setItem(0, new ItemBuilder(Material.CHEST).setDisplayName("§bKosmetik §8× §7Rechtsklick").build());
            player.getInventory().setItem(1, new ItemBuilder(Material.GRAY_DYE).setDisplayName("§bGadgets §8× §cLeer").build());
            player.getInventory().setItem(7, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§bEinstellungen §8× §7Rechtsklick").getSkull("http://textures.minecraft.net/texture/e4d49bae95c790c3b1ff5b2f01052a714d6185481d5b1c85930b3f99d2321674").build());
            player.getInventory().setItem(3, new ItemBuilder(Material.NETHER_STAR).setDisplayName("§eLobbyswitcher §8× §7Rechtsklick").build());
        }
        else {
            event.setCancelled(true);
        }
    }
}
