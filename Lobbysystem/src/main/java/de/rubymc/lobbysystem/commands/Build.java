package de.rubymc.lobbysystem.commands;

import de.rubymc.lobbysystem.Main;
import de.rubymc.lobbysystem.util.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Build implements CommandExecutor {

    public static ArrayList<Player> build = new ArrayList<>();
    FileConfiguration config = Main.plugin.getConfig();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player)sender;
        String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
        String noperm = ChatColor.translateAlternateColorCodes('&', config.getString("messages.commands.noperm"));

        if (cmd.getName().equalsIgnoreCase("build")) {
            if (player.hasPermission("lobby.build")) {
                if (build.contains(player)) {
                    build.remove(player);
                    player.getInventory().clear();
                    player.sendMessage(prefix + "§7Du bist nun nichtmehr im §cBaumodus§7.");
                    player.setGameMode(GameMode.SURVIVAL);

                    for (int i = 9; i <= 35; i++) {
                        player.getInventory().setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§c").build());
                    }
                    player.getInventory().setItem(20, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§6Instagram §8× §7Folgen").getSkull("http://textures.minecraft.net/texture/25b3f2cfa0739c4e828316f39f90b05bc1f4ed27b1e35888511f558d4675").build());
                    player.getInventory().setItem(22, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§bDiscord §8× §7Beitreten").getSkull("http://textures.minecraft.net/texture/4d42337be0bdca2128097f1c5bb1109e5c633c17926af5fb6fc20000011aeb53").build());
                    player.getInventory().setItem(24, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§6Website §8× §7Klick").getSkull("http://textures.minecraft.net/texture/b3175286cd3ba1a3a9c9082977d09dd37b177abf37a466580c27d1dee72b3c18").build());
                    player.getInventory().setItem(4, new ItemBuilder(Material.COMPASS).setDisplayName("§bNavigator §8× §7Rechtsklick").setGlow(true).build());
                    player.getInventory().setItem(8, new ItemBuilder(Material.PLAYER_HEAD).setHead(player.getName()).setDisplayName("§bProfil §8× §7Rechtsklick").build());
                    player.getInventory().setItem(5, new ItemBuilder(Material.LIME_DYE).setDisplayName("§bPlayerhider §8× §aAlle").build());
                    player.getInventory().setItem(0, new ItemBuilder(Material.CHEST).setDisplayName("§bKosmetik §8× §7Rechtsklick").build());
                    player.getInventory().setItem(1, new ItemBuilder(Material.GRAY_DYE).setDisplayName("§bGadgets §8× §cLeer").build());
                    player.getInventory().setItem(7, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§bEinstellungen §8× §7Rechtsklick").getSkull("http://textures.minecraft.net/texture/e4d49bae95c790c3b1ff5b2f01052a714d6185481d5b1c85930b3f99d2321674").build());
                    player.getInventory().setItem(3, new ItemBuilder(Material.NETHER_STAR).setDisplayName("§eLobbyswitcher §8× §7Rechtsklick").build());
                } else if (!build.contains(player)) {
                    build.add(player);
                    player.getInventory().clear();
                    player.sendMessage(prefix + "§7Du bist nun im §aBaumodus§7.");
                    player.setGameMode(GameMode.CREATIVE);
                }
            } else {
                sender.sendMessage(prefix + noperm);
            }
        }
        return true;
    }
}
