package de.rubymc.lobbysystem.gui;

import de.rubymc.lobbysystem.util.ItemBuilder;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Inventories {

    public static void openNavigator(Player player) {
        Inventory nav;
        nav = Bukkit.createInventory(null, 45, "§0➥ Navigator");

        for (int i = 0; i <= 8; i++) {
            nav.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            nav.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }

        List<String> infolore = new ArrayList<>();
        infolore.add("§7Hier kannst du unsere Spielmodi");
        infolore.add("§7finden, und hast einen Überblick!");
        nav.setItem(4, new ItemBuilder(Material.WRITABLE_BOOK).setDisplayName("§8> §6Information").setLore(infolore).build());

        nav.setItem(40, new ItemBuilder(Material.SNOWBALL).setDisplayName("§8> §bSpawn").build());

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
        nav.setItem(11, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§a§lFree§2§lbuild").setLore(freebuildlore).getSkull("http://textures.minecraft.net/texture/a33898d014250f264f6984d11bf152ec4af6478384aec8ae46965bd2c4f6f929").build());


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
        nav.setItem(29, new ItemBuilder(Material.IRON_PICKAXE).setDisplayName("§f§lBauserver §e§l1.8").setLore(b1lore).build());

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
        nav.setItem(31, new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName("§b§lBauserver §e§l1.16").setLore(b2lore).build());

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
        nav.setItem(33, new ItemBuilder(Material.GOLDEN_PICKAXE).setDisplayName("§6§lBauserver §e§l1.12").setLore(b3lore).build());

        nav.setItem(13, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());
        nav.setItem(15, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());
        nav.setItem(21, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());
        nav.setItem(23, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());

        player.openInventory(nav);
    }

    public static void openLobbyswitcher(Player player) {
        Inventory lobbys;

        ItemStack fulllobby = new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("").getSkull("http://textures.minecraft.net/texture/5e48615df6b7ddf3ad495041876d9169bdc983a3fa69a2aca107e8f251f7687").build();

        ItemStack emptylobby = new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("").getSkull("http://textures.minecraft.net/texture/211ab3a1132c9d1ef835ea81d972ed9b5cd8ddff0a07c55a749bcfcf8df5").build();

        List<String> offlore = new ArrayList<>();
        offlore.add("");
        offlore.add("§7Status: §cOffline");
        offlore.add("§7Spieler: §c0");
        ItemStack offlobby = new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("").getSkull("http://textures.minecraft.net/texture/884e92487c6749995b79737b8a9eb4c43954797a6dd6cd9b4efce17cf475846").setLore(offlore).build();

        lobbys = Bukkit.createInventory(null, InventoryType.HOPPER, "§0➥ Lobbys");

        for (int i = 0; i <= 4; i++) {
            lobbys.setItem(i, offlobby);
        }

        player.openInventory(lobbys);
    }

    public static void hiderGUI(Player player) {
        Inventory hider;

        hider = Bukkit.createInventory(null, 45, "§0➥ Playerhider");

        for (int i = 0; i <= 8; i++) {
            hider.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            hider.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }

        List<String> infolore = new ArrayList<>();
        infolore.add("§7Hier kannst du Spieler nach");
        infolore.add("§7belieben deaktivieren ^^");
        hider.setItem(4, new ItemBuilder(Material.WRITABLE_BOOK).setDisplayName("§8> §6Information").setLore(infolore).build());

        /*
        ItemStack all = new ItemStack(Material.FIREWORK_STAR);
        ItemMeta allmeta = all.getItemMeta();
        allmeta.setDisplayName("§aAlle anzeigen");
        FireworkEffectMeta allfwmeta = (FireworkEffectMeta) allmeta;
        FireworkEffect allcolor = FireworkEffect.builder().withColor(Color.LIME).build();
        allfwmeta.setEffect(allcolor);
        all.setItemMeta(allfwmeta);
        */

        hider.setItem(12, new ItemBuilder(Material.LIME_DYE).setDisplayName("§aAlle anzeigen").build());
        hider.setItem(14, new ItemBuilder(Material.RED_DYE).setDisplayName("§cKeine anzeigen").build());
        hider.setItem(20, new ItemBuilder(Material.YELLOW_DYE).setDisplayName("§eLehrlinge anzeigen").build());
        hider.setItem(22, new ItemBuilder(Material.GREEN_DYE).setDisplayName("§2Bauern anzeigen").build());
        hider.setItem(24, new ItemBuilder(Material.ORANGE_DYE).setDisplayName("§6VIP anzeigen").build());
        hider.setItem(30, new ItemBuilder(Material.BLACK_DYE).setDisplayName("§0Ritter anzeigen").build());
        hider.setItem(32, new ItemBuilder(Material.PURPLE_DYE).setDisplayName("§5Drache anzeigen").build());

        player.openInventory(hider);
    }

    public static void settingsGUI(Player player) {
        Inventory settings;

        settings = Bukkit.createInventory(null, 45, "§0➥ Einstellungen");

        for (int i = 0; i <= 8; i++) {
            settings.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            settings.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        settings.setItem(22, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());

        List<String> infolore = new ArrayList<>();
        infolore.add("§7Hier kannst du einige Einstellungen");
        infolore.add("§7zur Barrierefreiheit finden!");
        settings.setItem(4, new ItemBuilder(Material.WRITABLE_BOOK).setDisplayName("§8> §6Information").setLore(infolore).build());

        //Aus der Datenbank die Spielersettings laden, oder bei PrimeAPI fragen wie manche Dinge gespeichert werden!

        //Privatnachrichten

        //Deutsch-Englisch

        //Hinterherspringen

        //Immer zum Spawn gesetzt werden

        //Freundejoinnachrichten

        player.openInventory(settings);
    }

    public static void profileGUI(Player player) {
        Inventory profile;

        profile = Bukkit.createInventory(null, 45, "§0➥ Profil");

        for (int i = 0; i <= 8; i++) {
            profile.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            profile.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        profile.setItem(31, new ItemBuilder(Material.BOOK).setDisplayName("§8> §5Freunde").build());
        profile.setItem(29, new ItemBuilder(Material.IRON_SWORD).setDisplayName("§8> §eClan").build());
        profile.setItem(33, new ItemBuilder(Material.PAPER).setDisplayName("§8> §9Party").build());

        List<String> playerlore = new ArrayList<>();
        playerlore.add("");
        playerlore.add("§7Rang: §e%vault_rank%");
        playerlore.add("§7Coins: §e%prime_coins%");
        playerlore.add("");
        playerlore.add("§7Level: §e%alonsolevels_level%");
        playerlore.add("§7Fortschritt:");
        playerlore.add("%alonsolevels_progress_bar_format%");
        playerlore = PlaceholderAPI.setPlaceholders(player, playerlore);
        profile.setItem(13, new ItemBuilder(Material.PLAYER_HEAD).setHead(player.getName()).setDisplayName("§8> §bProfil").setLore(playerlore).build());

        player.openInventory(profile);
    }

    public static void effectGUI(Player player) {
        Inventory effects;
        Inventory pi = player.getInventory();

        for (int i = 9; i <= 35; i++) {
            pi.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§c").build());
        }
        pi.setItem(19, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§eKosmetik §8× §7Effekte").getSkull("http://textures.minecraft.net/texture/52e98165deef4ed621953921c1ef817dc638af71c1934a4287b69d7a31f6b8").build());
        pi.setItem(21, new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName("§eKosmetik §8× §7Rüstung").build());
        pi.setItem(23, new ItemBuilder(Material.FISHING_ROD).setDisplayName("§eKosmetik §8× §7Gadgets").build());
        pi.setItem(25, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§eKosmetik §8× §7Pets").getSkull("http://textures.minecraft.net/texture/3a7fe5a0b6c0d40c18084165d1f21b2c1d01276e0eb15944d5ad3b03de442").build());

        effects = Bukkit.createInventory(null, 45, "§0➥ Kosmetik - Effekte");

        for (int i = 0; i <= 8; i++) {
            effects.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            effects.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        effects.setItem(22, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());

        player.openInventory(effects);
    }

    public static void armorGUI(Player player) {
        Inventory armor;
        Inventory pi = player.getInventory();

        for (int i = 9; i <= 35; i++) {
            pi.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§c").build());
        }
        pi.setItem(19, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§eKosmetik §8× §7Effekte").getSkull("http://textures.minecraft.net/texture/52e98165deef4ed621953921c1ef817dc638af71c1934a4287b69d7a31f6b8").build());
        pi.setItem(21, new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName("§eKosmetik §8× §7Rüstung").build());
        pi.setItem(23, new ItemBuilder(Material.FISHING_ROD).setDisplayName("§eKosmetik §8× §7Gadgets").build());
        pi.setItem(25, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§eKosmetik §8× §7Pets").getSkull("http://textures.minecraft.net/texture/3a7fe5a0b6c0d40c18084165d1f21b2c1d01276e0eb15944d5ad3b03de442").build());

        armor = Bukkit.createInventory(null, 45, "§0➥ Kosmetik - Rüstungen");

        for (int i = 0; i <= 8; i++) {
            armor.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            armor.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        armor.setItem(22, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());

        player.openInventory(armor);
    }

    public static void gadgetsGUI(Player player) {
        Inventory gadgets;
        Inventory pi = player.getInventory();

        for (int i = 9; i <= 35; i++) {
            pi.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§c").build());
        }
        pi.setItem(19, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§eKosmetik §8× §7Effekte").getSkull("http://textures.minecraft.net/texture/52e98165deef4ed621953921c1ef817dc638af71c1934a4287b69d7a31f6b8").build());
        pi.setItem(21, new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName("§eKosmetik §8× §7Rüstung").build());
        pi.setItem(23, new ItemBuilder(Material.FISHING_ROD).setDisplayName("§eKosmetik §8× §7Gadgets").build());
        pi.setItem(25, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§eKosmetik §8× §7Pets").getSkull("http://textures.minecraft.net/texture/3a7fe5a0b6c0d40c18084165d1f21b2c1d01276e0eb15944d5ad3b03de442").build());

        gadgets = Bukkit.createInventory(null, 45, "§0➥ Kosmetik - Gadgets");

        for (int i = 0; i <= 8; i++) {
            gadgets.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            gadgets.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        gadgets.setItem(22, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());

        player.openInventory(gadgets);
    }

    public static void petsGUI(Player player) {
        Inventory pets;
        Inventory pi = player.getInventory();

        for (int i = 9; i <= 35; i++) {
            pi.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§c").build());
        }
        pi.setItem(19, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§eKosmetik §8× §7Effekte").getSkull("http://textures.minecraft.net/texture/52e98165deef4ed621953921c1ef817dc638af71c1934a4287b69d7a31f6b8").build());
        pi.setItem(21, new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName("§eKosmetik §8× §7Rüstung").build());
        pi.setItem(23, new ItemBuilder(Material.FISHING_ROD).setDisplayName("§eKosmetik §8× §7Gadgets").build());
        pi.setItem(25, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§eKosmetik §8× §7Pets").getSkull("http://textures.minecraft.net/texture/3a7fe5a0b6c0d40c18084165d1f21b2c1d01276e0eb15944d5ad3b03de442").build());

        pets = Bukkit.createInventory(null, 45, "§0➥ Kosmetik - Pets");

        for (int i = 0; i <= 8; i++) {
            pets.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        for (int i = 36; i <= 44; i++) {
            pets.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").build());
        }
        pets.setItem(22, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§cKommt bald...").getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").build());

        player.openInventory(pets);
    }


}
