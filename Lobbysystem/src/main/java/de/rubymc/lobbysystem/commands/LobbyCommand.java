package de.rubymc.lobbysystem.commands;

import de.rubymc.lobbysystem.Main;
import de.rubymc.lobbysystem.util.Configmanager;
import de.rubymc.lobbysystem.util.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class LobbyCommand implements CommandExecutor {

    FileConfiguration config = Main.plugin.getConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player)  sender;

            String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
            String reload = ChatColor.translateAlternateColorCodes('&', config.getString("messages.commands.reload"));
            String noperm = ChatColor.translateAlternateColorCodes('&', config.getString("messages.commands.noperm"));


            if (args.length == 0) {
                sendUsage(sender);
                return true;
            }

            switch (args[0].toLowerCase()) {
                case "reload": {
                    if (!player.hasPermission("lobby.reload")) {
                        sender.sendMessage(prefix + noperm);
                        break;
                    }

                    Configmanager.reloadConfiguration();
                    sender.sendMessage(prefix + reload);

                    break;
                }

                case "setlocation": {
                    if (!player.hasPermission("lobby.setlocation")) {
                        sender.sendMessage(prefix + noperm);
                        break;
                    }

                    try {
                        String name = args[1];
                        Configmanager.addWarp(name, player.getLocation());
                        player.sendMessage(prefix + "Du hast die Position §c" + name + " §7gesetzt!");
                    } catch (Exception e) {
                        sender.sendMessage(prefix + "§cEtwas hat anscheinend nicht funktioniert!");
                    }
                    break;
                }

                case  "removelocation": {
                    if (!player.hasPermission("lobby.removelocation")) {
                        sender.sendMessage(prefix + noperm);
                        break;
                    }

                    try {
                        String name = args[1];
                        Configmanager.removeWarp(name);
                        player.sendMessage(prefix + "Du hast die Position §c" + name + " §7gelöscht!");
                    } catch (Exception e) {
                        sender.sendMessage(prefix + "§cEtwas hat anscheinend nicht funktioniert!");
                    }

                    break;
                }

                case "build": {
                    if (!player.hasPermission("lobby.build")) {
                        sender.sendMessage(prefix + noperm);
                        break;
                    }

                    if (player.getGameMode().equals(GameMode.SURVIVAL)) {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(prefix + "§7Du bist nun im §aBaumodus§7.");

                        player.getInventory().clear();

                    }
                    else {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(prefix + "§7Du bist nun nichtmehr im §cBaumodus§7.");

                        player.getInventory().clear();

                        for (int i = 9; i <= 35; i++) {
                            player.getInventory().setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§c").build());
                        }
                        player.getInventory().setItem(20, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§6Instagram §8× §7Folgen").getSkull("http://textures.minecraft.net/texture/25b3f2cfa0739c4e828316f39f90b05bc1f4ed27b1e35888511f558d4675").build());
                        player.getInventory().setItem(22, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§bDiscord §8× §7Beitreten").getSkull("http://textures.minecraft.net/texture/4d42337be0bdca2128097f1c5bb1109e5c633c17926af5fb6fc20000011aeb53").build());
                        player.getInventory().setItem(24, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§6Website §8× §7Klick").getSkull("http://textures.minecraft.net/texture/b3175286cd3ba1a3a9c9082977d09dd37b177abf37a466580c27d1dee72b3c18").build());
                        player.getInventory().setItem(4, new ItemBuilder(Material.COMPASS).setDisplayName("§bNavigator §8× §7Rechtsklick").setGlow(true).build());
                        player.getInventory().setItem(8, new ItemBuilder(Material.PLAYER_HEAD, (short) 3).setHead(player.getName()).setDisplayName("§bProfil §8× §7Rechtsklick").build());
                        player.getInventory().setItem(5, new ItemBuilder(Material.LIME_DYE).setDisplayName("§bPlayerhider §8× §aAlle").build());
                        player.getInventory().setItem(0, new ItemBuilder(Material.CHEST).setDisplayName("§bKosmetik §8× §7Rechtsklick").build());
                        player.getInventory().setItem(1, new ItemBuilder(Material.GRAY_DYE).setDisplayName("§bGadgets §8× §cLeer").build());
                        player.getInventory().setItem(7, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§bEinstellungen §8× §7Rechtsklick").getSkull("http://textures.minecraft.net/texture/e4d49bae95c790c3b1ff5b2f01052a714d6185481d5b1c85930b3f99d2321674").build());
                        player.getInventory().setItem(3, new ItemBuilder(Material.NETHER_STAR).setDisplayName("§eLobbyswitcher §8× §7Rechtsklick").build());

                    }
                    break;
                }

                default:
                    sendUsage(sender);
                    break;
            }
        }
        return false;
    }

    private void sendUsage(CommandSender sender) {
        String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
        sender.sendMessage(prefix + "Verwendung: §b/lobby reload§7, §b/lobby setlocation <name>§7, §b/lobby removelocation <name>§7, §b/lobby build");
    }
}
