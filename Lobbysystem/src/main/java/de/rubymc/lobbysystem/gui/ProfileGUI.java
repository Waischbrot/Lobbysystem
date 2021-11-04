package de.rubymc.lobbysystem.gui;

import de.rubymc.lobbysystem.util.ItemBuilder;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class ProfileGUI implements Listener {

    Inventory inv;
    Inventory clan;
    Inventory friends;
    Inventory party;

    private void GUI() {
        inv = Bukkit.createInventory(null, 45, "§0➥ Profil");

        for (int i = 0; i <= 8; i++) {
            inv.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            inv.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        inv.setItem(31, new ItemBuilder(Material.BOOK).setDisplayName("§8> §5Freunde").build());
        inv.setItem(29, new ItemBuilder(Material.IRON_SWORD).setDisplayName("§8> §eClan").build());
        inv.setItem(33, new ItemBuilder(Material.PAPER).setDisplayName("§8> §9Party").build());
    }

    private void Clan() {
        clan = Bukkit.createInventory(null, 45, "§0➥ Profil - Clan");

        for (int i = 0; i <= 8; i++) {
            clan.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            clan.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        clan.setItem(4, new ItemBuilder(Material.BARRIER).setDisplayName("§cZurück").build());

        //PrimeAPI !!!
    }

    private void Friends() {
        friends = Bukkit.createInventory(null, 45, "§0➥ Profil - Freunde");

        for (int i = 0; i <= 8; i++) {
            friends.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            friends.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        friends.setItem(4, new ItemBuilder(Material.BARRIER).setDisplayName("§cZurück").build());
    }

    private void Party() {
        party = Bukkit.createInventory(null, 45, "§0➥ Profil - Party");

        for (int i = 0; i <= 8; i++) {
            party.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            party.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        party.setItem(4, new ItemBuilder(Material.BARRIER).setDisplayName("§cZurück").build());
    }

    @EventHandler
    public void openInventory(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getItem().getItemMeta().getDisplayName().equals("§bProfil §8× §7Rechtsklick")) {
                GUI();

                List<String> playerlore = new ArrayList<>();
                playerlore.add("");
                playerlore.add("§7Rang: §e%vault_rank%");
                playerlore.add("§7Coins: §e%prime_coins%");
                playerlore.add("");
                playerlore.add("§7Level: §e%alonsolevels_level%");
                playerlore.add("§7Fortschritt:");
                playerlore.add("%alonsolevels_progress_bar_format%");
                playerlore = PlaceholderAPI.setPlaceholders(player, playerlore);
                inv.setItem(13, new ItemBuilder(Material.PLAYER_HEAD).setHead(player.getName()).setDisplayName("§8> §bProfil").setLore(playerlore).build());

                player.openInventory(inv);
            }
        }
    }

    // Check
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        event.setCancelled(true);
        int slot = event.getRawSlot();

        if (event.getInventory() != inv && event.getInventory() != clan && event.getInventory() != friends && event.getInventory() != party) {
            return;
        }

        //Profilmenü
        if (event.getInventory() == inv) {
            if (slot == 29) {
                Clan();

                player.openInventory(clan);
            }
            else if (slot == 31) {
                Friends();

                player.openInventory(friends);
            }
            else if (slot == 33) {
                Party();

                player.openInventory(party);
            }
        }

        //Clanmenü
        else if (event.getInventory() == clan) {
            if (slot == 4) {
                GUI();

                //PAPI Placeholder einfügen!
                List<String> playerlore = new ArrayList<>();
                playerlore.add("");
                playerlore.add("§7Rang: §e%vault_rank%");
                playerlore.add("§7Coins: §e%prime_coins%");
                playerlore.add("");
                playerlore.add("§7Level: §e%alonsolevels_level%");
                playerlore.add("§7Fortschritt:");
                playerlore.add("%alonsolevels_progress_bar_format%");
                inv.setItem(13, new ItemBuilder(Material.PLAYER_HEAD).setHead(player.getName()).setDisplayName("§8> §bProfil").setLore(playerlore).build());

                player.openInventory(inv);
            }
        }

        //Freundemenü
        else if (event.getInventory() == friends) {
            if (slot == 4) {
                GUI();

                //PAPI Placeholder einfügen!
                List<String> playerlore = new ArrayList<>();
                playerlore.add("");
                playerlore.add("§7Rang: §e");
                playerlore.add("§7Coins: §e");
                playerlore.add("");
                playerlore.add("§7Level: §e");
                playerlore.add("§7Fortschritt:");
                playerlore.add("");
                inv.setItem(13, new ItemBuilder(Material.PLAYER_HEAD).setHead(player.getName()).setDisplayName("§8> §bProfil").setLore(playerlore).build());

                player.openInventory(inv);
            }
        }

        //Partymenü
        else if (event.getInventory() == party) {
            if (slot == 4) {
                GUI();

                //PAPI Placeholder einfügen!
                List<String> playerlore = new ArrayList<>();
                playerlore.add("");
                playerlore.add("§7Rang: §e");
                playerlore.add("§7Coins: §e");
                playerlore.add("");
                playerlore.add("§7Level: §e");
                playerlore.add("§7Fortschritt:");
                playerlore.add("");
                inv.setItem(13, new ItemBuilder(Material.PLAYER_HEAD).setHead(player.getName()).setDisplayName("§8> §bProfil").setLore(playerlore).build());

                player.openInventory(inv);
            }
        }
    }
}
