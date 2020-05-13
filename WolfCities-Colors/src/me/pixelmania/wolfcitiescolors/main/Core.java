package me.pixelmania.wolfcitiescolors.main;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.pixelmania.wolfcitiescolors.utils.ChatFormat;

public class Core extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		Bukkit.getServer().getConsoleSender().sendMessage("[WolfCities-Colors] Successfully enabled!");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onPlayerMessage(AsyncPlayerChatEvent event) {
		if (!event.getPlayer().hasPermission("wolfcolors.allow")) {
			event.setMessage(ChatFormat.stripColors(event.getMessage()));
		}
	}
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onPlayerMessage(SignChangeEvent event) {
		if (!event.getPlayer().hasPermission("wolfcolors.allow")) {
			for (int i = 0; i != event.getLines().length; i++) {
				event.setLine(i, ChatFormat.stripColors(event.getLine(i)));
			}
		}
	}
	
}
