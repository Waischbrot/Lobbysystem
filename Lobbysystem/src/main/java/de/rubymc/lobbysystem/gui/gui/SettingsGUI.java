package de.rubymc.lobbysystem.gui;

import de.rubymc.lobbysystem.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class SettingsGUI implements Listener {

    Inventory inv;

    @EventHandler
    public void openInventory(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getItem().getItemMeta().getDisplayName().equals("§bEinstellungen §8× §7Rechtsklick")) {
                GUI();

                player.openInventory(inv);
            }
        }
    }

    private void GUI() {
        inv = Bukkit.createInventory(null, 45, "§0➥ Einstellungen");

        for (int i = 0; i <= 8; i++) {
            inv.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            inv.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }

        List<String> infolore = new ArrayList<>();
        infolore.add("§7Hier kannst du einige Einstellungen");
        infolore.add("§7zur Barrierefreiheit finden!");
        inv.setItem(4, new ItemBuilder(Material.WRITABLE_BOOK).setDisplayName("§8> §6Information").setLore(infolore).build());

        //Aus der Datenbank die Spielersettings laden, oder bei PrimeAPI fragen wie manche Dinge gespeichert werden!

        //Privatnachrichten

        //Deutsch-Englisch

        //Hinterherspringen

        //Immer zum Spawn gesetzt werden

        //Freundejoinnachrichten
    }
}
