package net.fresh2play.plugins.F2PAC.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import net.fresh2play.plugins.F2PAC.F2PAC;
import net.fresh2play.plugins.F2PAC.checks.CheckResult;
import net.fresh2play.plugins.F2PAC.checks.movement.NoSlowDown;
import net.fresh2play.plugins.F2PAC.checks.movement.SpeedCheck;
import net.fresh2play.plugins.F2PAC.util.Distance;
import net.fresh2play.plugins.F2PAC.util.User;

public class MoveListener implements Listener {

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		User u = F2PAC.USERS.get(e.getPlayer().getUniqueId());
		Distance d = new Distance(e);
		CheckResult speed = SpeedCheck.runCheck(d, u);
		CheckResult noSlow = SpeedCheck.runCheck(d, u);
		NoSlowDown.registerMove(d, u);
		if(speed.failed()) {
			e.setTo(e.getFrom()); // <- lag back
			F2PAC.log(speed, u);
		}
		
		if(noSlow.failed()) {
			e.setTo(e.getFrom()); // <- lag back
			F2PAC.log(noSlow, u);
		}
	}
	
}
