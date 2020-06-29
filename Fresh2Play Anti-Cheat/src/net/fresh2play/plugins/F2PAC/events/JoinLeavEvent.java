package net.fresh2play.plugins.F2PAC.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.fresh2play.plugins.F2PAC.F2PAC;
import net.fresh2play.plugins.F2PAC.util.User;

public class JoinLeavEvent implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		F2PAC.USERS.put(p.getUniqueId(), new User(p));
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		F2PAC.USERS.remove(p.getUniqueId());
	}

}
