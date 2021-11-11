package de.rubymc.lobbysystem.commands;

import de.rubymc.lobbysystem.Main;
import de.rubymc.lobbysystem.util.Configmanager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetWarp implements CommandExecutor {

    FileConfiguration config = Main.plugin.getConfig();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
        String noperm = ChatColor.translateAlternateColorCodes('&', config.getString("messages.commands.noperm"));

        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (player.hasPermission("lobby.setwarp")) {
                if (args.length == 1) {
                    if (Configmanager.cfg.getString(args[0]) == null) {
                        Configmanager.createConfigLocation(player.getLocation(), args[0], Configmanager.file, Configmanager.cfg);
                        player.sendMessage(prefix + "§7Du hast den Warp §b" + args[0] + " §7erfolgreich gesetzt!");
                    } else {
                        player.sendMessage(prefix + "§cDieser Warp existiert bereits!");
                    }
                } else {
                    player.sendMessage(prefix + "§cSyntax: /setwarp [Warp]");
                }
            } else {
                player.sendMessage(prefix + noperm);
            }
        } else {
            sender.sendMessage(prefix + noperm);
        }
        return false;
    }
}
