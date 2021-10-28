package de.rubymc.lobbysystem.util;

import de.rubymc.lobbysystem.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.logging.Level;

public class YmlMaker
{
    Main Plugin;
    public String fileName;
    private JavaPlugin plugin;
    public File ConfigFile;
    private FileConfiguration Configuration;

    public YmlMaker(Main Plugin)
    {
        this.Plugin = Plugin;
    }

    public YmlMaker(JavaPlugin plugin, String fileName)
    {
        if (plugin == null) {
            throw new IllegalArgumentException("plugin cannot be null");
        }
        this.plugin = plugin;
        this.fileName = fileName;
        File dataFolder = plugin.getDataFolder();
        if (dataFolder == null) {
            throw new IllegalStateException();
        }
        this.ConfigFile = new File(dataFolder.toString() + File.separatorChar + this.fileName);
    }

    public FileConfiguration getConfig()
    {
        return this.Configuration;
    }

    public void saveConfig()
    {
        if ((this.Configuration == null) || (this.ConfigFile == null)) {
            return;
        }
        try
        {
            getConfig().save(this.ConfigFile);
        }
        catch (IOException ex)
        {
            this.plugin.getLogger().log(Level.SEVERE, "Could not save config to " + this.ConfigFile, ex);
        }
    }

    public void saveDefaultConfig()
    {
        if (!this.ConfigFile.exists()) {
            this.plugin.saveResource(this.fileName, false);
        }
    }
}