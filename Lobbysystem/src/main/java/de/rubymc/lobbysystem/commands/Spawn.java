package de.rubymc.lobbysystem.commands;

import de.rubymc.lobbysystem.Main;
import de.rubymc.lobbysystem.util.Configmanager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {

    FileConfiguration config = Main.plugin.getConfig();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player)sender;
        String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
        if (Configmanager.cfg.getString("Spawn") != null) {
            p.sendMessage(prefix + "Du bist nun am Spawn!");
            p.teleport(Configmanager.getConfigLocation("Spawn", Configmanager.cfg));
        } else {
            p.sendMessage(prefix + "§cEs existiert noch kein Spawn...");
        }
        return false;
    }
}
