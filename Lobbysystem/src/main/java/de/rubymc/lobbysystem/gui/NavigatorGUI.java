package de.rubymc.lobbysystem.gui;

import de.rubymc.lobbysystem.Main;
import de.rubymc.lobbysystem.util.ItemBuilder;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
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
    public void openInteractInventory(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getMaterial().equals(Material.COMPASS)) {
                GUI(player);

                player.openInventory(inv);
            }
        }
    }

    private void GUI(Player player) {
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

        String freebuild = PlaceholderAPI.setPlaceholders(player, "%bungee_Freebuild-1%");
        List<String> freebuildlore = new ArrayList<>();
        freebuildlore.add("");
        freebuildlore.add("§fGründe dein eigenes Land,");
        freebuildlore.add("§fund herrsche schon bald mit");
        freebuildlore.add("§feinem großen Vermögen über Freebuild");
        freebuildlore.add("");
        freebuildlore.add("§7Es spielen gerade §e" + freebuild + " §7Spieler!");
        freebuildlore.add("");
        freebuildlore.add("§8➥ §cKlicke zum beitreten!");
        inv.setItem(11, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§a§lFree§2§lbuild").setLore(freebuildlore).getSkull("http://textures.minecraft.net/texture/a33898d014250f264f6984d11bf152ec4af6478384aec8ae46965bd2c4f6f929").build());


        String bauserver1 = PlaceholderAPI.setPlaceholders(player, "%bungee_Bauserver-1%");
        List<String> b1lore = new ArrayList<>();
        b1lore.add("");
        b1lore.add("§fBaue frei von Mauern alles");
        b1lore.add("§fwas du dir auch nur im entferntesten");
        b1lore.add("§fVorstellen kannst!");
        b1lore.add("");
        b1lore.add("§7Es spielen gerade §e" + bauserver1 + " §7Spieler!");
        b1lore.add("");
        b1lore.add("§8➥ §cKlicke zum beitreten!");
        inv.setItem(29, new ItemBuilder(Material.IRON_PICKAXE).setDisplayName("§f§lBauserver §e§l1.8").setLore(b1lore).build());

        String bauserver2 = PlaceholderAPI.setPlaceholders(player, "%bungee_Bauserver-2%");
        List<String> b2lore = new ArrayList<>();
        b2lore.add("");
        b2lore.add("§fBaue frei von Mauern alles");
        b2lore.add("§fwas du dir auch nur im entferntesten");
        b2lore.add("§fVorstellen kannst!");
        b2lore.add("");
        b2lore.add("§7Es spielen gerade §e" + bauserver2 + " §7Spieler!");
        b2lore.add("");
        b2lore.add("§8➥ §cKlicke zum beitreten!");
        inv.setItem(31, new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName("§b§lBauserver §e§l1.16").setLore(b2lore).build());

        String bauserver3 = PlaceholderAPI.setPlaceholders(player, "%bungee_Bauserver-3%");
        List<String> b3lore = new ArrayList<>();
        b3lore.add("");
        b3lore.add("§fBaue frei von Mauern alles");
        b3lore.add("§fwas du dir auch nur im entferntesten");
        b3lore.add("§fVorstellen kannst!");
        b3lore.add("");
        b3lore.add("§7Es spielen gerade §e" + bauserver3 + " §7Spieler!");
        b3lore.add("");
        b3lore.add("§8➥ §cKlicke zum beitreten!");
        inv.setItem(33, new ItemBuilder(Material.GOLDEN_PICKAXE).setDisplayName("§6§lBauserver §e§l1.12").setLore(b3lore).build());

        inv.setItem(13, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());
        inv.setItem(15, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());
        inv.setItem(21, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());
        inv.setItem(23, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());
    }

    // Check
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        event.setCancelled(true);
        int slot = event.getRawSlot();

        if (event.getInventory() != inv) {
            return;
        }
        //Spawn
        if (slot == 40) {
            Location location = player.getLocation();
            location.setX(config.getLong("warps.spawn.location.X"));
            location.setY(config.getLong("warps.spawn.location.Y"));
            location.setZ(config.getLong("warps.spawn.location.Z"));
            location.setYaw(config.getLong("warps.spawn.location.YAW"));
            location.setPitch(config.getLong("warps.spawn.location.PITCH"));

            player.teleport(location);

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
            Location location = player.getLocation();
            location.setX(config.getLong("warps.freebuild.location.X"));
            location.setY(config.getLong("warps.freebuild.location.Y"));
            location.setZ(config.getLong("warps.freebuild.location.Z"));
            location.setYaw(config.getLong("warps.freebuild.location.YAW"));
            location.setPitch(config.getLong("warps.freebuild.location.PITCH"));

            player.teleport(location);

            player.closeInventory();
        }

        //Bauserver1
        else if (slot == 29) {
            Location location = player.getLocation();
            location.setX(config.getLong("warps.bauserver1.location.X"));
            location.setY(config.getLong("warps.bauserver1.location.Y"));
            location.setZ(config.getLong("warps.bauserver1.location.Z"));
            location.setYaw(config.getLong("warps.bauserver1.location.YAW"));
            location.setPitch(config.getLong("warps.bauserver1.location.PITCH"));

            player.teleport(location);

            player.closeInventory();
        }

        //Bauserver2
        else if (slot == 31) {
            Location location = player.getLocation();
            location.setX(config.getLong("warps.bauserver2.location.X"));
            location.setY(config.getLong("warps.bauserver2.location.Y"));
            location.setZ(config.getLong("warps.bauserver2.location.Z"));
            location.setYaw(config.getLong("warps.bauserver2.location.YAW"));
            location.setPitch(config.getLong("warps.bauserver2.location.PITCH"));

            player.teleport(location);

            player.closeInventory();
        }

        //Bauserver3
        else if (slot == 33) {
            Location location = player.getLocation();
            location.setX(config.getLong("warps.bauserver3.location.X"));
            location.setY(config.getLong("warps.bauserver3.location.Y"));
            location.setZ(config.getLong("warps.bauserver3.location.Z"));
            location.setYaw(config.getLong("warps.bauserver3.location.YAW"));
            location.setPitch(config.getLong("warps.bauserver3.location.PITCH"));

            player.teleport(location);

            player.closeInventory();
        }

    }
}
