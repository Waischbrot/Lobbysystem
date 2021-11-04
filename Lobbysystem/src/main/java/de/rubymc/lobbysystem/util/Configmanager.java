package de.rubymc.lobbysystem.util;

import de.rubymc.lobbysystem.Main;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Configmanager {

    private static Plugin plugin = Main.plugin;

    public static void startup(){
        File configFile = new File(plugin.getDataFolder(), "config.yml");
        if(configFile.exists()){
            plugin.getLogger().info("§c  > Loading config");
        }
        else {
            plugin.getLogger().info("§c  > Creating Config");
            plugin.saveDefaultConfig();

            FileConfiguration c = plugin.getConfig();

            //Joinmessage
            c.createSection("joinmessage.enabled");
            c.createSection("joinmessage.message");

            //Hier eine Defaultmessage erstellen!
            List<String> joinmessage = new ArrayList<>();
            joinmessage.add("&8████████");
            joinmessage.add("&8█&c██████&8█                &c&lRuby&f&lMC");
            joinmessage.add("&c█&f██&c█████");
            joinmessage.add("&c████████    &bWillkommen &7auf unserem Netzwerk");
            joinmessage.add("&8█&4█&c█&4████&8█");
            joinmessage.add("&8██&4█&c█&4██&8██  &e⚠ &fBitte beachte, das wir derzeit &e⚠");
            joinmessage.add("&8███&4██&8███           &fnoch im Aufbau sind!");
            joinmessage.add("&8████████");
            c.set("joinmessage.enabled", true);
            c.set("joinmessage.message", joinmessage);

            //Messages die konfigurierbar sind
            c.createSection("messages.prefix");
            c.createSection("messages.socials.instagram");
            c.createSection("messages.socials.website");
            c.createSection("messages.socials.discord");
            c.createSection("messages.games.maintenance");
            c.createSection("messages.commands.reload");
            c.createSection("messages.commands.noperm");

            c.set("messages.prefix", "&bLobby &8• &7");
            c.set("messages.socials.instagram", "Folge uns auf Instagram &8♫ &ehttps://www.instagram.com/rubymc.de/");
            c.set("messages.socials.website", "Besuche gerne unsere Website &8♫ &chttps://rubymc.de");
            c.set("messages.socials.discord", "Trete unserem Discord bei &8♫ &bhttp://discord.rubymc.de");
            c.set("messages.games.maintenance", "Dieser Spielmodus befindet sich derzeit in &cWartungsarbeiten&7!");
            c.set("messages.commands.reload", "Du hast das Plugin erfolgreich neugeladen!");
            c.set("messages.commands.noperm", "&cDazu hast du leider keine Rechte!!!");

            //Warps
            c.createSection("warps");

            plugin.saveConfig();
        }
    }

    public static void reloadConfiguration() {
        plugin.reloadConfig();
    }

    public static void addWarp(String name, Location location){
        FileConfiguration config = plugin.getConfig();
        String configPath = "warps." + name;
        config.createSection(configPath);
        config.createSection(configPath + ".category");
        config.createSection(configPath + ".name");
        config.createSection(configPath + ".headlink");
        config.createSection(configPath + ".location");
        config.createSection(configPath + ".location.X");
        config.createSection(configPath + ".location.Y");
        config.createSection(configPath + ".location.Z");
        config.createSection(configPath + ".location.YAW");
        config.createSection(configPath + ".location.PITCH");
        config.createSection(configPath + ".location.WORLD");

        config.set(configPath + ".name", name);
        config.set(configPath + ".location.X", location.getX());
        config.set(configPath + ".location.Y", location.getY());
        config.set(configPath + ".location.Z", location.getZ());
        config.set(configPath + ".location.YAW", location.getYaw());
        config.set(configPath + ".location.PITCH", location.getPitch());
        config.set(configPath + ".location.WORLD", location.getWorld().getName());
        plugin.saveConfig();
    }

    public static void removeWarp(String name){
        FileConfiguration config = plugin.getConfig();
        config.set("warps." + name, null);
        plugin.saveConfig();
    }
}
