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
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class CosmeticGUI implements Listener {

    Inventory effects;
    Inventory armor;
    Inventory gadgets;
    Inventory pets;
    FileConfiguration config = Main.plugin.getConfig();

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

    private void EffectGUI() {
        effects = Bukkit.createInventory(null, 45, "§0➥ Kosmetik - Effekte");

        for (int i = 0; i <= 8; i++) {
            effects.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            effects.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
    }
}
