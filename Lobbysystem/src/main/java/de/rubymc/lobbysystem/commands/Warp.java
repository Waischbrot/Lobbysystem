package de.rubymc.lobbysystem.commands;

import de.rubymc.lobbysystem.Main;
import de.rubymc.lobbysystem.util.Configmanager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Warp implements CommandExecutor {

    FileConfiguration config = Main.plugin.getConfig();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 1) {
                if (Configmanager.cfg.getString(args[0]) != null) {
                    player.teleport(Configmanager.getConfigLocation(args[0], Configmanager.cfg));
                    player.sendMessage(prefix + "Du bist nun bei §b" + args[0] + "§7.");
                } else {
                    player.sendMessage(prefix + "§cDieser Warp existiert nicht!");
                }
            } else {
                player.sendMessage(prefix + "§cSyntax: /warp [Name]");
            }
        } else {
            sender.sendMessage(prefix + "Dieser Command kann nur von einem Spieler ausgeführt werden!");
        }
        return false;
    }
}
