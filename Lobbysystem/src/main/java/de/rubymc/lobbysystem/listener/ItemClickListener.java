package de.rubymc.lobbysystem.listener;

import de.rubymc.lobbysystem.Main;
import de.rubymc.lobbysystem.util.ItemBuilder;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
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

public class ItemClickListener implements Listener {

    FileConfiguration config = Main.plugin.getConfig();

    /*
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

            else if (event.getMaterial().equals(Material.RED_DYE)) {
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 3);

                ItemStack playerhider = new ItemBuilder(Material.PURPLE_DYE).setDisplayName("§6Playerhider §8× §5Freunde").build();
                player.getInventory().setItem(5, playerhider);
            }

            else if (event.getMaterial().equals(Material.PURPLE_DYE)) {
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 3);

                ItemStack playerhider = new ItemBuilder(Material.ORANGE_DYE).setDisplayName("§6Playerhider §8× §6VIP").build();
                player.getInventory().setItem(5, playerhider);

                //hier mit der PrimeAPI Api arbeiten!
                for (Player all : Bukkit.getOnlinePlayers()) {
                    player.hidePlayer(all);
                }

                for (Player all : Bukkit.getOnlinePlayers()) {
                    if (all.hasPermission("lobby.vip")) {
                        player.showPlayer(all);
                    }
                    else {
                        player.hidePlayer(all);
                    }
                }
            }

            else if(event.getMaterial().equals(Material.ORANGE_DYE)) {
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 3);

                ItemStack playerhider = new ItemBuilder(Material.LIME_DYE).setDisplayName("§6Playerhider §8× §aAlle").build();
                player.getInventory().setItem(5, playerhider);

                for(Player all : Bukkit.getOnlinePlayers()) {
                    player.showPlayer(all);
                }
            }
        }
    }

    @EventHandler
    public void navigator(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getItem().getItemMeta().getDisplayName().equals("§bNavigator §8× §7Rechtsklick")) {
                Inventory inv = Bukkit.createInventory(null, 45, "§0➥ Navigator");

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

                player.openInventory(inv);
            }
        }
    }
    */

    //Clicks im Inventar lesen, muss noch überarbeitet werden.
    @EventHandler
    public void inventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§6Instagram §8× §7Folgen")) {
            String message = ChatColor.translateAlternateColorCodes('&', config.getString("messages.socials.instagram"));
            String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
            player.sendMessage(prefix + message);
        }

        else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§bDiscord §8× §7Beitreten")) {
            String message = ChatColor.translateAlternateColorCodes('&', config.getString("messages.socials.discord"));
            String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
            player.sendMessage(prefix + message);
        }

        else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§6Website §8× §7Klick")) {
            String message = ChatColor.translateAlternateColorCodes('&', config.getString("messages.socials.website"));
            String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
            player.sendMessage(prefix + message);
        }
    }
}package de.rubymc.lobbysystem.listener;

import de.rubymc.lobbysystem.Main;
import de.rubymc.lobbysystem.util.ItemBuilder;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
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

public class ItemClickListener implements Listener {

    FileConfiguration config = Main.plugin.getConfig();

    /*
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

            else if (event.getMaterial().equals(Material.RED_DYE)) {
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 3);

                ItemStack playerhider = new ItemBuilder(Material.PURPLE_DYE).setDisplayName("§6Playerhider §8× §5Freunde").build();
                player.getInventory().setItem(5, playerhider);
            }

            else if (event.getMaterial().equals(Material.PURPLE_DYE)) {
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 3);

                ItemStack playerhider = new ItemBuilder(Material.ORANGE_DYE).setDisplayName("§6Playerhider §8× §6VIP").build();
                player.getInventory().setItem(5, playerhider);

                //hier mit der PrimeAPI Api arbeiten!
                for (Player all : Bukkit.getOnlinePlayers()) {
                    player.hidePlayer(all);
                }

                for (Player all : Bukkit.getOnlinePlayers()) {
                    if (all.hasPermission("lobby.vip")) {
                        player.showPlayer(all);
                    }
                    else {
                        player.hidePlayer(all);
                    }
                }
            }

            else if(event.getMaterial().equals(Material.ORANGE_DYE)) {
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 3);

                ItemStack playerhider = new ItemBuilder(Material.LIME_DYE).setDisplayName("§6Playerhider §8× §aAlle").build();
                player.getInventory().setItem(5, playerhider);

                for(Player all : Bukkit.getOnlinePlayers()) {
                    player.showPlayer(all);
                }
            }
        }
    }

    @EventHandler
    public void navigator(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getItem().getItemMeta().getDisplayName().equals("§bNavigator §8× §7Rechtsklick")) {
                Inventory inv = Bukkit.createInventory(null, 45, "§0➥ Navigator");

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

                player.openInventory(inv);
            }
        }
    }
    */

    //Clicks im Inventar lesen, muss noch überarbeitet werden.
    @EventHandler
    public void inventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§6Instagram §8× §7Folgen")) {
            String message = ChatColor.translateAlternateColorCodes('&', config.getString("messages.socials.instagram"));
            String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
            player.sendMessage(prefix + message);
        }

        else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§bDiscord §8× §7Beitreten")) {
            String message = ChatColor.translateAlternateColorCodes('&', config.getString("messages.socials.discord"));
            String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
            player.sendMessage(prefix + message);
        }

        else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§6Website §8× §7Klick")) {
            String message = ChatColor.translateAlternateColorCodes('&', config.getString("messages.socials.website"));
            String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
            player.sendMessage(prefix + message);
        }
    }
}
