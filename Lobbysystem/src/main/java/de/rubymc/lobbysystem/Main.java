package de.rubymc.lobbysystem;

import de.rubymc.lobbysystem.listener.ItemClickListener;
import de.rubymc.lobbysystem.listener.JoinMessage;
import de.rubymc.lobbysystem.listener.PlayerInventory;
import de.rubymc.lobbysystem.listener.QuitListener;
import de.rubymc.lobbysystem.util.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private Config locations;
    private Config messages;

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Loaded Lobbysystem V1.0 by Waischbrot.");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Configs created and loaded.");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Listener registered.");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Commands registered.");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Thanks for using this Plugin (;");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("");



        createConfig();
        listenerRegistration();
        commandRegistration();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void createConfig() {
        saveDefaultConfig();
        /*
        if (getConfig().getBoolean("test")) {
            getLogger().info(getConfig().getString("msg"));
        }
        */
        locations = new Config("locations.yml", getDataFolder());
        messages = new Config("messages.yml", getDataFolder());

    }

    private void listenerRegistration() {
        Bukkit.getPluginManager().registerEvents(new ItemClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new QuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinMessage(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInventory(), this);
    }

    private void commandRegistration() {

    }

    public Config getLocations() {
        return locations;
    }

    public Config getMessages(){
        return messages;
    }
}
