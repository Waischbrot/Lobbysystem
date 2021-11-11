package de.rubymc.lobbysystem.commands;

import de.rubymc.lobbysystem.Main;
import de.rubymc.lobbysystem.util.Configmanager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;

public class RemoveWarp implements CommandExecutor {

    FileConfiguration config = Main.plugin.getConfig();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
        String noperm = ChatColor.translateAlternateColorCodes('&', config.getString("messages.commands.noperm"));
        Player player = (Player)sender;

        if (player.hasPermission("lobby.removewarp")) {
            if (args.length == 1) {
                if (Configmanager.cfg.getString(args[0]) != null) {
                    Configmanager.cfg.set(args[0], (Object)null);
                    try {
                        Configmanager.cfg.save(Configmanager.file);
                    } catch (IOException var7) {
                        var7.printStackTrace();
                    }

                    player.sendMessage(prefix + "Du hast den Warp §b" + args[0] + "§7 erfolgreich enfernt!");
                } else {
                    player.sendMessage(prefix + "§cDieser Warp existiert nicht!");
                }
            } else {
                player.sendMessage(prefix + "§cSyntax: /removewarp <Warp>");
            }
        } else {
            player.sendMessage(prefix + noperm);
        }
    return false;
    }
}
