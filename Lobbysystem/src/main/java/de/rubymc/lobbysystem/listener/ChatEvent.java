package de.rubymc.lobbysystem.listener;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        String message = ChatColor.translateAlternateColorCodes('&', event.getMessage());
        String rang = PlaceholderAPI.setPlaceholders(player, "%vault_prefix%");

        message = message.replaceAll("<3", "❤");
        message = message.replaceAll("->", "➜");
        message = message.replaceAll(":star:", "✪");
        message = message.replaceAll(":pen:", "✎");
        message = message.replaceAll(":phone:", "☎");
        message = message.replaceAll(":xx:", "✖");
        message = message.replaceAll(":a:", "Ⓐ");
        message = message.replaceAll(":b:", "Ⓑ");
        message = message.replaceAll(":c:", "Ⓒ");
        message = message.replaceAll(":d:", "Ⓓ");
        message = message.replaceAll(":e:", "Ⓔ");
        message = message.replaceAll(":f:", "Ⓕ");
        message = message.replaceAll(":g:", "Ⓖ");
        message = message.replaceAll(":h:", "Ⓗ");
        message = message.replaceAll(":i:", "Ⓘ");
        message = message.replaceAll(":j:", "Ⓙ");
        message = message.replaceAll(":k:", "Ⓚ");
        message = message.replaceAll(":l:", "Ⓛ");
        message = message.replaceAll(":m:", "Ⓜ");
        message = message.replaceAll(":n:", "Ⓝ");
        message = message.replaceAll(":o:", "Ⓞ");
        message = message.replaceAll(":p:", "Ⓟ");
        message = message.replaceAll(":q:", "Ⓠ");
        message = message.replaceAll(":r:", "Ⓡ");
        message = message.replaceAll(":s:", "Ⓢ");
        message = message.replaceAll(":t:", "Ⓣ");
        message = message.replaceAll(":u:", "Ⓤ");
        message = message.replaceAll(":v:", "Ⓥ");
        message = message.replaceAll(":w:", "Ⓦ");
        message = message.replaceAll(":x:", "Ⓧ");
        message = message.replaceAll(":y:", "Ⓨ");
        message = message.replaceAll(":z:", "Ⓩ");
        message = message.replaceAll(":1:", "➀");
        message = message.replaceAll(":2:", "➁");
        message = message.replaceAll(":3:", "➂");
        message = message.replaceAll(":4:", "➃");
        message = message.replaceAll(":5:", "➄");
        message = message.replaceAll(":6:", "➅");
        message = message.replaceAll(":7:", "➆");
        message = message.replaceAll(":8:", "➇");
        message = message.replaceAll(":9:", "➈");
        message = message.replaceAll(":10:", "➉");

        event.setFormat(rang + player.getName() + " §8➽ §7" + message);
    }
}
