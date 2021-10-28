package de.rubymc.lobbysystem.listener;

import de.rubymc.lobbysystem.Main;
import de.rubymc.lobbysystem.util.ItemBuilder;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemClickListener implements Listener {

    Main plugin;

    @EventHandler
    public void playerHider(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(event.getMaterial().equals(Material.LIME_DYE)) {
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 3);

                ItemStack playerhider = new ItemBuilder(Material.RED_DYE).setDisplayName("§6Playerhider §8× §cKeine").build();
                player.getInventory().setItem(5, playerhider);

                for(Player all : Bukkit.getOnlinePlayers()) {
                    player.hidePlayer(all);
                }
            }
            else if(event.getMaterial().equals(Material.RED_DYE)) {
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 3);

                ItemStack playerhider = new ItemBuilder(Material.LIME_DYE).setDisplayName("§6Playerhider §8× §aAlle").build();
                player.getInventory().setItem(5, playerhider);

                for(Player all : Bukkit.getOnlinePlayers()) {
                    player.showPlayer(all);
                }
            }
        }
    }
}
