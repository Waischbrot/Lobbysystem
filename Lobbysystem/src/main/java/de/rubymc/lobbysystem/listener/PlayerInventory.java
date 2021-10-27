package de.rubymc.lobbysystem.listener;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import de.rubymc.lobbysystem.util.ItemBuilder;

import org.bukkit.Material;
import org.bukkit.craftbukkit.libs.org.codehaus.plexus.util.Base64;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class PlayerInventory implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        //Löscht das Spielerinv
        player.getInventory().clear();

        //Navigator Item
        player.getInventory().setItem(4, new ItemBuilder(Material.COMPASS).setDisplayName("§bNavigator §8× §7Rightclick").setGlow(true).build());

        //Profil
        player.getInventory().setItem(8, new ItemBuilder(Material.PLAYER_HEAD, (short) 3).setHead(player.getName()).setDisplayName("§bProfile §8× §7Rightclick").build());

        //Playerhider

        //Cosmetics
        player.getInventory().setItem(0, new ItemBuilder(Material.CHEST).setDisplayName("§bCosmetics §8× §7Rightclick").build());

        //Gadgetslot
        player.getInventory().setItem(1, new ItemBuilder(Material.GRAY_DYE).setDisplayName("§bGadgets §8× §cEmpty").build());

        //Settings
        player.getInventory().setItem(7, getSkull("http://textures.minecraft.net/texture/4c298b7aaa9925ca5419ba92573395a276a827e717d8547fef3e43e630eb3e8e"));


        //Lobbyswitcher
    }

    public ItemStack getSkull(String url) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
        if (url.isEmpty()) return head;


        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;
        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }
}
