package dev.whymakud.handsnotax;

import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.event.*;
import java.util.*;

public class BreakEvent implements Listener
{
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        e.getPlayer();
        List<String> items = (List<String>)Main.getCongig().getStringList("axe-list");
        if (e.getBlock().getType().name().contains("LOG") && !items.contains(e.getPlayer().getItemInHand().getType().name().toLowerCase())) {
            e.getPlayer().damage((double)this.random_damage());
            if (this.isList()) {
                e.getPlayer().sendMessage(this.convertList(Main.getCongig().getStringList("message")));
            }
            else if (!Main.getCongig().getString("message").equals("null")) {
                if (!Main.getCongig().getString("message").isEmpty()) {
                    e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getCongig().getString("message")));
                }
            }
        }
    }
    
    public int random_damage() {
         int min = Main.getCongig().getInt("damage.min");
         int max = Main.getCongig().getInt("damage.max");
         int diff = max - min;
         Random random = new Random();
         int i = random.nextInt(diff + 1);
         return i += min;
    }
    
    public String convertList(List<String> list) {
        String message = "";
        for (String line : list) {
            message = message + ChatColor.translateAlternateColorCodes('&', line) + "\n";
        }
        return message;
    }
    
    public boolean isList() {
        return Main.getCongig().contains("message") && !Main.getCongig().getStringList("message").isEmpty();
    }
}