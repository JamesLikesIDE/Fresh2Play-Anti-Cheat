package net.fresh2play.plugins.F2PAC.checks.movement;

import net.fresh2play.plugins.F2PAC.checks.CheckResult;
import net.fresh2play.plugins.F2PAC.checks.CheckType;
import net.fresh2play.plugins.F2PAC.checks.Level;
import net.fresh2play.plugins.F2PAC.util.Distance;
import net.fresh2play.plugins.F2PAC.util.Settings;
import net.fresh2play.plugins.F2PAC.util.User;

public class SpeedCheck {
	
	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.SPEED);

	public static CheckResult runCheck(Distance d, User u) {
		Double xz_speed = (d.getxDiff() > d.getzDiff() ? d.getxDiff() : d.getzDiff());
		if(xz_speed > Settings.MAX_XZ_SPEED) 
			return new CheckResult(Level.DEFINITELY, "Tried to move faster than max speed. Speed=" + xz_speed.toString() + ", max=" + Settings.MAX_XZ_SPEED, CheckType.SPEED);
		return PASS;
	} 
	
}
