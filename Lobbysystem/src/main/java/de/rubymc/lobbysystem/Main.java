package de.rubymc.lobbysystem;

import de.rubymc.lobbysystem.commands.LobbyCommand;
import de.rubymc.lobbysystem.features.JoinMessage;
import de.rubymc.lobbysystem.features.VoidTeleport;
import de.rubymc.lobbysystem.features.XPBar;
import de.rubymc.lobbysystem.gui.*;
import de.rubymc.lobbysystem.listener.*;
import de.rubymc.lobbysystem.util.Configmanager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        plugin.getLogger().info("");
        plugin.getLogger().info("§c__________________________________________________________");
        plugin.getLogger().info("");
        plugin.getLogger().info("§c                     LobbySystem [1.0.0]");
        plugin.getLogger().info("");
        plugin.getLogger().info("§cStatus:");
        plugin.getLogger().info("");
        plugin.getLogger().info("§cMC-Version: 1.16.5 (R0.1-SNAPSHOT, SPIGOT)");
        plugin.getLogger().info("§cAuthor Waischbrot, originally made for RubyMC.de");
        plugin.getLogger().info("");
        Configmanager.startup();
        plugin.getLogger().info("§c  > Registering listeners");
        listenerRegistration();
        plugin.getLogger().info("§c  > Registering commands");
        getCommand("lobby").setExecutor(new LobbyCommand());
        papiRegistration();
        plugin.getLogger().info("");
        plugin.getLogger().info("§cFinished (" + ChatColor.GRAY + "4" + ChatColor.RED + "ms)");
        plugin.getLogger().info("");
        plugin.getLogger().info("§c               Problems? Join for support:");
        plugin.getLogger().info("§c                 http://discord.rubymc.de");
        plugin.getLogger().info("");
        plugin.getLogger().info("§c__________________________________________________________");
        plugin.getLogger().info("");
    }

    @Override
    public void onDisable() {
        plugin.getLogger().info("§c");
        plugin.getLogger().info("§c__________________________________________________________");
        plugin.getLogger().info("§c");
        plugin.getLogger().info("§c                     LobbySystem [1.0.0]");
        plugin.getLogger().info("§c");
        plugin.getLogger().info("§cStatus:");
        plugin.getLogger().info("§c");
        plugin.getLogger().info("§cMC-Version: 1.16.5 (R0.1-SNAPSHOT, SPIGOT)");
        plugin.getLogger().info("§cAuthor Waischbrot, originally made for RubyMC.de");
        plugin.getLogger().info("§c");
        plugin.getLogger().info("§c  > Disabling plugin");
        plugin.getLogger().info("§c");
        plugin.getLogger().info("§cFinished (" + ChatColor.GRAY + "" + ChatColor.RED + "ms)");
        plugin.getLogger().info("§c");
        plugin.getLogger().info("§c__________________________________________________________");
        plugin.getLogger().info("§c");
    }

    private void listenerRegistration() {
        Bukkit.getPluginManager().registerEvents(new ItemClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new EventCancel(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInventory(), this);

        Bukkit.getPluginManager().registerEvents(new NavigatorGUI(), this);
        Bukkit.getPluginManager().registerEvents(new HiderGUI(), this);
        Bukkit.getPluginManager().registerEvents(new CosmeticGUI(), this);
        Bukkit.getPluginManager().registerEvents(new LobbyGUI(), this);
        Bukkit.getPluginManager().registerEvents(new ProfileGUI(), this);
        Bukkit.getPluginManager().registerEvents(new SettingsGUI(), this);

        Bukkit.getPluginManager().registerEvents(new JoinMessage(), this);
        Bukkit.getPluginManager().registerEvents(new XPBar(), this);
        Bukkit.getPluginManager().registerEvents(new VoidTeleport(), this);
    }

    private void papiRegistration() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            plugin.getLogger().info("§c  > Successfully loaded PlaceholderAPI");
        }
        else {
            plugin.getLogger().info("§c  > Papi was not found!");
        }
    }
}
