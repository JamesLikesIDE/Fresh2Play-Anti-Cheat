package net.fresh2play.plugins.F2PAC;

import static org.bukkit.ChatColor.GOLD;
import static org.bukkit.ChatColor.RED;
import static org.bukkit.ChatColor.WHITE;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.fresh2play.plugins.F2PAC.checks.CheckResult;
import net.fresh2play.plugins.F2PAC.events.JoinLeaveEvent;
import net.fresh2play.plugins.F2PAC.events.MoveListener;
import net.fresh2play.plugins.F2PAC.events.PlayerListener;
import net.fresh2play.plugins.F2PAC.util.Settings;
import net.fresh2play.plugins.F2PAC.util.User;

public class F2PAC extends JavaPlugin{
	
	public static HashMap<UUID, User> USERS = new HashMap<>();

	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Fresh2Play Anti-Cheat Loading...");
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new JoinLeaveEvent(), this);
		pm.registerEvents(new MoveListener(), this);
		pm.registerEvents(new PlayerListener(), this);
		
		
		for (Player p : Bukkit.getOnlinePlayers())
			USERS.put(p.getUniqueId(), new User(p));
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Fresh2Play Anti-Cheat Loaded!");
	}
	
	public static void log(CheckResult cr, User u) {
		String message = GOLD.toString() + "Fresh2Play Anti-Cheat " + RED + u.getPlayer().getName() + WHITE + " " + cr.getLevel().toString().toLowerCase() + " " + Settings.DONE + " " + RED + cr.getType().getName() + WHITE + "; " + cr.getMessage();
		for (Player p : Bukkit.getOnlinePlayers())
			if(p.hasPermission(Settings.notify)) 
				p.sendMessage(message);
		Bukkit.getConsoleSender().sendMessage(message);
	}
	
	public static User getUser(Player p) {
		return USERS.get(p.getUniqueId());
	}
	
}
