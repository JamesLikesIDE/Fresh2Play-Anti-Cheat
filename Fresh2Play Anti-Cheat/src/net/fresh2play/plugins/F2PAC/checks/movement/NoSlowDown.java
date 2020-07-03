package net.fresh2play.plugins.F2PAC.checks.movement;

import org.bukkit.ChatColor;

import net.fresh2play.plugins.F2PAC.checks.CheckResult;
import net.fresh2play.plugins.F2PAC.checks.CheckType;
import net.fresh2play.plugins.F2PAC.checks.Level;
import net.fresh2play.plugins.F2PAC.util.Distance;
import net.fresh2play.plugins.F2PAC.util.Settings;
import net.fresh2play.plugins.F2PAC.util.User;

public class NoSlowDown {
	
	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.NOSLOW);

	public static void registerMove(Distance d, User u) {
		Double xzDist = (d.getxDiff() > d.getzDiff() ? d.getxDiff() : d.getzDiff());
		u.getPlayer().sendMessage(ChatColor.RED + "Eat: " + String.valueOf(xzDist));
		if(xzDist > Settings.MAX_XZ_EATING_SPEED && u.getFoodStarting() != null && System.currentTimeMillis() - u.getFoodStarting() > 2000);
			u.addInvalidFoodEatableCount();
	}
	
	public static CheckResult runCheck(Distance d, User u) {
		Double xzDist = (d.getxDiff() > d.getzDiff() ? d.getxDiff() : d.getzDiff());
		if(u.getPlayer().isBlocking())  {
			u.getPlayer().sendMessage(ChatColor.RED + "Blocking: " + String.valueOf(xzDist));
			if(xzDist > Settings.MAX_XZ_BLOCKING_SPEED)
			return new CheckResult(Level.DEFINITELY, " Tried to move fast whilst blocking ", CheckType.NOSLOW);
		}
		return PASS; // i think i see error 2 hh ? runCheck had 2 h in it so it made runChheck oh bruh
	}

}
