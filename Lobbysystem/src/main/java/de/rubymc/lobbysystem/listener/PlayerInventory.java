package de.rubymc.lobbysystem.listener;

import de.rubymc.lobbysystem.util.ItemBuilder;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

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
        player.getInventory().setItem(5, new ItemBuilder(Material.BLAZE_ROD).setDisplayName("§bPlayerhider §8× §aAlle").build());

        //Cosmetics
        player.getInventory().setItem(0, new ItemBuilder(Material.CHEST).setDisplayName("§bCosmetics §8× §7Rightclick").build());

        //Gadgetslot
        player.getInventory().setItem(1, new ItemBuilder(Material.GRAY_DYE).setDisplayName("§bGadgets §8× §cEmpty").build());

        //Settings
        player.getInventory().setItem(7, new ItemBuilder(Material.PLAYER_HEAD).setDisplayName("§bSettings §8× §7Rightclick").getSkull("http://textures.minecraft.net/texture/e4d49bae95c790c3b1ff5b2f01052a714d6185481d5b1c85930b3f99d2321674").build());

        //Lobbyswitcher
        player.getInventory().setItem(3, new ItemBuilder(Material.NETHER_STAR).setDisplayName("Lobbyswitcher §8× §7Rightclick").build());
    }
}
