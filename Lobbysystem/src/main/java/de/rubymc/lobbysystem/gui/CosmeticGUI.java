package de.rubymc.lobbysystem.gui;

import de.rubymc.lobbysystem.util.ItemBuilder;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class CosmeticGUI implements Listener {

    Inventory effects;
    Inventory armor;
    Inventory gadgets;
    Inventory pets;

    @EventHandler
    public void openInventory(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getMaterial().equals(Material.CHEST)) {
                EffectGUI();

                //Setzt das Spielerinventar
                for (int i = 9; i <= 35; i++) {
                    player.getInventory().setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§c").build());
                }
                player.getInventory().setItem(19, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§eKosmetik §8× §7Effekte").getSkull("http://textures.minecraft.net/texture/52e98165deef4ed621953921c1ef817dc638af71c1934a4287b69d7a31f6b8").build());
                player.getInventory().setItem(21, new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName("§eKosmetik §8× §7Rüstung").build());
                player.getInventory().setItem(23, new ItemBuilder(Material.FISHING_ROD).setDisplayName("§eKosmetik §8× §7Gadgets").build());
                player.getInventory().setItem(25, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§eKosmetik §8× §7Pets").getSkull("http://textures.minecraft.net/texture/3a7fe5a0b6c0d40c18084165d1f21b2c1d01276e0eb15944d5ad3b03de442").build());

                player.openInventory(effects);
            }
        }
    }

    // Check
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getClickedInventory() == player.getInventory()) {
            if (event.getSlot() == 19) {
                EffectGUI();

                player.openInventory(effects);

                //Setzt das Spielerinventar
                for (int i = 9; i <= 35; i++) {
                    player.getInventory().setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§c").build());
                }
                player.getInventory().setItem(19, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§eKosmetik §8× §7Effekte").getSkull("http://textures.minecraft.net/texture/52e98165deef4ed621953921c1ef817dc638af71c1934a4287b69d7a31f6b8").build());
                player.getInventory().setItem(21, new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName("§eKosmetik §8× §7Rüstung").build());
                player.getInventory().setItem(23, new ItemBuilder(Material.FISHING_ROD).setDisplayName("§eKosmetik §8× §7Gadgets").build());
                player.getInventory().setItem(25, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§eKosmetik §8× §7Pets").getSkull("http://textures.minecraft.net/texture/3a7fe5a0b6c0d40c18084165d1f21b2c1d01276e0eb15944d5ad3b03de442").build());
            } else if (event.getSlot() == 21) {
                ArmorGUI();

                player.openInventory(armor);

                //Setzt das Spielerinventar
                for (int i = 9; i <= 35; i++) {
                    player.getInventory().setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§c").build());
                }
                player.getInventory().setItem(19, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§eKosmetik §8× §7Effekte").getSkull("http://textures.minecraft.net/texture/52e98165deef4ed621953921c1ef817dc638af71c1934a4287b69d7a31f6b8").build());
                player.getInventory().setItem(21, new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName("§eKosmetik §8× §7Rüstung").build());
                player.getInventory().setItem(23, new ItemBuilder(Material.FISHING_ROD).setDisplayName("§eKosmetik §8× §7Gadgets").build());
                player.getInventory().setItem(25, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§eKosmetik §8× §7Pets").getSkull("http://textures.minecraft.net/texture/3a7fe5a0b6c0d40c18084165d1f21b2c1d01276e0eb15944d5ad3b03de442").build());
            } else if (event.getSlot() == 23) {
                GadgetsGUI();

                player.openInventory(gadgets);

                //Setzt das Spielerinventar
                for (int i = 9; i <= 35; i++) {
                    player.getInventory().setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§c").build());
                }
                player.getInventory().setItem(19, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§eKosmetik §8× §7Effekte").getSkull("http://textures.minecraft.net/texture/52e98165deef4ed621953921c1ef817dc638af71c1934a4287b69d7a31f6b8").build());
                player.getInventory().setItem(21, new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName("§eKosmetik §8× §7Rüstung").build());
                player.getInventory().setItem(23, new ItemBuilder(Material.FISHING_ROD).setDisplayName("§eKosmetik §8× §7Gadgets").build());
                player.getInventory().setItem(25, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§eKosmetik §8× §7Pets").getSkull("http://textures.minecraft.net/texture/3a7fe5a0b6c0d40c18084165d1f21b2c1d01276e0eb15944d5ad3b03de442").build());
            } else if (event.getSlot() == 25) {
                PetsGUI();

                player.openInventory(pets);

                //Setzt das Spielerinventar
                for (int i = 9; i <= 35; i++) {
                    player.getInventory().setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§c").build());
                }
                player.getInventory().setItem(19, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§eKosmetik §8× §7Effekte").getSkull("http://textures.minecraft.net/texture/52e98165deef4ed621953921c1ef817dc638af71c1934a4287b69d7a31f6b8").build());
                player.getInventory().setItem(21, new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName("§eKosmetik §8× §7Rüstung").build());
                player.getInventory().setItem(23, new ItemBuilder(Material.FISHING_ROD).setDisplayName("§eKosmetik §8× §7Gadgets").build());
                player.getInventory().setItem(25, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§eKosmetik §8× §7Pets").getSkull("http://textures.minecraft.net/texture/3a7fe5a0b6c0d40c18084165d1f21b2c1d01276e0eb15944d5ad3b03de442").build());
            }
        }
    }

    @EventHandler
    public void onInvClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();

        for (int i = 9; i <= 35; i++) {
            player.getInventory().setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§c").build());
        }
        player.getInventory().setItem(20, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§6Instagram §8× §7Folgen").getSkull("http://textures.minecraft.net/texture/25b3f2cfa0739c4e828316f39f90b05bc1f4ed27b1e35888511f558d4675").build());
        player.getInventory().setItem(22, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§bDiscord §8× §7Beitreten").getSkull("http://textures.minecraft.net/texture/4d42337be0bdca2128097f1c5bb1109e5c633c17926af5fb6fc20000011aeb53").build());
        player.getInventory().setItem(24, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§6Website §8× §7Klick").getSkull("http://textures.minecraft.net/texture/b3175286cd3ba1a3a9c9082977d09dd37b177abf37a466580c27d1dee72b3c18").build());
    }

    private void EffectGUI() {
        effects = Bukkit.createInventory(null, 45, "§0➥ Kosmetik - Effekte");

        for (int i = 0; i <= 8; i++) {
            effects.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            effects.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        effects.setItem(22, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());
    }

    private void ArmorGUI() {
        armor = Bukkit.createInventory(null, 45, "§0➥ Kosmetik - Rüstungen");

        for (int i = 0; i <= 8; i++) {
            armor.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            armor.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        armor.setItem(22, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());
    }

    private void GadgetsGUI() {
        gadgets = Bukkit.createInventory(null, 45, "§0➥ Kosmetik - Gadgets");

        for (int i = 0; i <= 8; i++) {
            gadgets.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            gadgets.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        gadgets.setItem(22, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());
    }

    private void PetsGUI() {
        pets = Bukkit.createInventory(null, 45, "§0➥ Kosmetik - Pets");

        for (int i = 0; i <= 8; i++) {
            pets.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            pets.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        pets.setItem(22, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());
    }
}
