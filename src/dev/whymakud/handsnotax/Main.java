package dev.whymakud.handsnotax;

import org.bukkit.plugin.java.*;

import java.io.*;
import org.bukkit.configuration.file.*;
import org.bukkit.event.*;
import org.bukkit.plugin.*;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class Main extends JavaPlugin implements CommandExecutor
{
    private static Main instance;
    private static FileConfiguration config;
    
    public static FileConfiguration getCongig() {
        return Main.config;
    }
    
    public static Main getInstance() {
        return Main.instance;
    }
    
    public static void setInstance(Main treeHandBreak) {
    	Main.instance = treeHandBreak;
    }
    
    public void onEnable() {
        setInstance(this);
        this.saveDefaultConfig();
        File file = new File(this.getDataFolder(), "/config.yml");
        Main.config = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        this.getServer().getPluginManager().registerEvents((Listener)new BreakEvent(), (Plugin)this);
        Bukkit.getConsoleSender().sendMessage("[§bMakudHandsNotAx§r] by §cwhymakud.github.io §renabled!");
    }
	
    
    public void onDisable() {
    }
    
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        if (player.hasPermission("makudhandsnotax.reload")) {
            File file = new File(this.getDataFolder(), "/config.yml");
            Main.config = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
          	 sender.sendMessage("§7[§bMakudHandsNotAx§7] §fby §cwhymakud.github.io §freloaded!");
        } else {
        	sender.sendMessage("§7[§bMakudHandsNotAx§7] §fby §cwhymakud.github.io §fnot rebooted, you §cdo not have§f permissions!");
        }
        return false;
    }
}
