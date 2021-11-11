package de.rubymc.lobbysystem.commands;

import de.rubymc.lobbysystem.Main;
import de.rubymc.lobbysystem.util.Configmanager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor {

    FileConfiguration config = Main.plugin.getConfig();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player)sender;
        String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix"));
        String noperm = ChatColor.translateAlternateColorCodes('&', config.getString("messages.commands.noperm"));
        if (player.hasPermission("lobby.setspawn")) {
            Configmanager.createConfigLocation(player.getLocation(), "Spawn", Configmanager.file, Configmanager.cfg);
            player.sendMessage(prefix + "Du hast den §bSpawn §7erfolgreich gesetzt.");
        } else {
            player.sendMessage(prefix + noperm);
        }
        return false;
    }
}
