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
        if(player.hasPermission("lobby.build") && player.getGameMode().equals(GameMode.CREATIVE)) {
            return;
        }
        else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void BlockBreakEvent(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if(player.hasPermission("lobby.build") && player.getGameMode().equals(GameMode.CREATIVE)) {
            return;
        }
        else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if(player.hasPermission("lobby.build") && player.getGameMode().equals(GameMode.CREATIVE)) {
            return;
        }
        else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void secondHand(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();
        if(player.hasPermission("lobby.build") && player.getGameMode().equals(GameMode.CREATIVE)) {
            return;
        }
        else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void inventoryClickEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if(player.hasPermission("lobby.build") && player.getGameMode().equals(GameMode.CREATIVE)) {
            return;
        }
        else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void inventoryMoveEvent(InventoryMoveItemEvent event) {
        Player player = (Player) event.getInitiator();
        if(player.hasPermission("lobby.build") && player.getGameMode().equals(GameMode.CREATIVE)) {
            return;
        }
        else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void inventoryDragEvent(InventoryDragEvent event) {
        Player player = (Player) event.getWhoClicked();
        if(player.hasPermission("lobby.build") && player.getGameMode().equals(GameMode.CREATIVE)) {
            return;
        }
        else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void armorstand(PlayerArmorStandManipulateEvent event) {
        Player player = event.getPlayer();
        if(player.hasPermission("lobby.build") && player.getGameMode().equals(GameMode.CREATIVE)) {
            return;
        }
        else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemFrame(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if(player.hasPermission("lobby.build") && player.getGameMode().equals(GameMode.CREATIVE)) {
            return;
        }
        else {
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
            player.getInventory().setItem(4, new ItemBuilder(Material.COMPASS).setDisplayName("§bNavigator §8× §7Rightclick").setGlow(true).build());
            player.getInventory().setItem(8, new ItemBuilder(Material.PLAYER_HEAD, (short) 3).setHead(player.getName()).setDisplayName("§bProfile §8× §7Rightclick").build());
            player.getInventory().setItem(5, new ItemBuilder(Material.LIME_DYE).setDisplayName("§bPlayerhider §8× §aAlle").build());
            player.getInventory().setItem(0, new ItemBuilder(Material.CHEST).setDisplayName("§bCosmetics §8× §7Rightclick").build());
            player.getInventory().setItem(1, new ItemBuilder(Material.GRAY_DYE).setDisplayName("§bGadgets §8× §cEmpty").build());
            player.getInventory().setItem(7, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§bSettings §8× §7Rightclick").getSkull("http://textures.minecraft.net/texture/e4d49bae95c790c3b1ff5b2f01052a714d6185481d5b1c85930b3f99d2321674").build());
            player.getInventory().setItem(3, new ItemBuilder(Material.NETHER_STAR).setDisplayName("Lobbyswitcher §8× §7Rightclick").build());
        }
        else {
            event.setCancelled(true);
        }
    }

}
