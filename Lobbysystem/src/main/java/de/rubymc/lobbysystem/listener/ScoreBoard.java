package de.rubymc.lobbysystem.listener;

import de.rubymc.lobbysystem.mysql.CoinsAPI;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.scoreboard.*;

import java.util.Iterator;

public class ScoreBoard implements Listener {

    public static void setBoard(Player player) {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective object = board.registerNewObjective("aaa", "bbb");

        object.setDisplayName("§b§lLobby §b| §bOnline " + Bukkit.getOnlinePlayers().size());
        object.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score a1 = object.getScore(" §b§L       ");
        Score a2 = object.getScore("§b ▎ §b" + player.getName());
        String rang = PlaceholderAPI.setPlaceholders(player, "%vault_rank%");
        Score a3 = object.getScore("§b ▎ §7Rang: " + rang);
        Score a4 = object.getScore("§b ▎ §7Rubine: " + CoinsAPI.getCoins(player.getUniqueId().toString()));
        Score a5 = object.getScore(" §b§L ");
        Score a6 = object.getScore("§b ▎ §bEinstellungen");
        Score a7 = object.getScore("§b ▎ §7Angezeigt:");
        Score a8 = object.getScore("§b ▎ §7Sprache:");
        Score a9 = object.getScore("§b ▎ §7Position:");
        Score a10 = object.getScore(" §b§l ");
        Score a11 = object.getScore("§b ▎ §bNetzwerklevel");
        Score a12 = object.getScore("§b ▎ §cBald verfügbar!");
        a1.setScore(12);
        a2.setScore(11);
        a3.setScore(10);
        a4.setScore(9);
        a5.setScore(8);
        a6.setScore(7);
        a7.setScore(6);
        a8.setScore(5);
        a9.setScore(4);
        a10.setScore(3);
        a11.setScore(2);
        a12.setScore(1);
        player.setScoreboard(board);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Iterator var = Bukkit.getOnlinePlayers().iterator();

        while(var.hasNext()) {
            Player all = (Player)var.next();
            setBoard(all);
        }

    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        if (player.isSneaking()) {
            setBoard(player);
        }

    }
}
