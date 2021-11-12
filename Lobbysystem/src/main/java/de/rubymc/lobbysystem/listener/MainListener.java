package de.rubymc.lobbysystem.listener;

import de.rubymc.lobbysystem.commands.Build;
import de.rubymc.lobbysystem.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.help.HelpTopic;

public class MainListener implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (!Build.build.contains(player)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (!Build.build.contains(player)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDdd(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByBlockEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityDamage1(EntityDamageEvent event) {
        if (event.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onChange(WeatherChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        String command = event.getMessage().split(" ")[0];
        HelpTopic helptopic = Bukkit.getHelpMap().getHelpTopic(command);
        event.setCancelled(helptopic == null);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            if (event.getCause().equals(EntityDamageEvent.DamageCause.DROWNING)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void secondHand(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();
        if (!Build.build.contains(player)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPickup(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        if (!Build.build.contains(player)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onArmorstand(PlayerArmorStandManipulateEvent event) {
        Player player = event.getPlayer();
        if (!Build.build.contains(player)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (!Build.build.contains(player)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void inventoryMoveEvent(InventoryMoveItemEvent event) {
        Player player = (Player) event.getInitiator();
        if (!Build.build.contains(player)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void inventoryDragEvent(InventoryDragEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (!Build.build.contains(player)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void invClose(InventoryCloseEvent event) {

        if (!Build.build.contains((Player) event.getPlayer())) {
            for (int i = 9; i <= 35; i++) {
                event.getPlayer().getInventory().setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§c").build());
            }
            event.getPlayer().getInventory().setItem(20, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§6Instagram §8× §7Folgen").getSkull("http://textures.minecraft.net/texture/25b3f2cfa0739c4e828316f39f90b05bc1f4ed27b1e35888511f558d4675").build());
            event.getPlayer().getInventory().setItem(22, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§bDiscord §8× §7Beitreten").getSkull("http://textures.minecraft.net/texture/4d42337be0bdca2128097f1c5bb1109e5c633c17926af5fb6fc20000011aeb53").build());
            event.getPlayer().getInventory().setItem(24, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§6Website §8× §7Klick").getSkull("http://textures.minecraft.net/texture/b3175286cd3ba1a3a9c9082977d09dd37b177abf37a466580c27d1dee72b3c18").build());
        }
    }

    @EventHandler
    public void dragonEGG(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getClickedBlock().getType() == Material.DRAGON_EGG) {
            event.setCancelled(true);
        }
        else if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getClickedBlock().getType() == Material.HOPPER) {
            event.setCancelled(true);
        }
    }
}
