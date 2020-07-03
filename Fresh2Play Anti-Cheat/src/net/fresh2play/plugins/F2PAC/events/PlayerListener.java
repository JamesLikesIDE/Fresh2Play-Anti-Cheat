package net.fresh2play.plugins.F2PAC.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import net.fresh2play.plugins.F2PAC.F2PAC;
import net.fresh2play.plugins.F2PAC.checks.CheckResult;
import net.fresh2play.plugins.F2PAC.checks.CheckType;
import net.fresh2play.plugins.F2PAC.checks.Level;
import net.fresh2play.plugins.F2PAC.util.Settings;
import net.fresh2play.plugins.F2PAC.util.User;

public class PlayerListener implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		User u = F2PAC.getUser(e.getPlayer());
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK &&
				e.getPlayer().getItemInHand() != null && Settings.FOODS.contains(e.getPlayer().getItemInHand().getType())) {
			u.setFoodStarting();
			u.resetInvalidFoodEatableCount();
		}
	}
	
	@EventHandler
	public void  onFoodLevelChange(FoodLevelChangeEvent e) {
		User u = F2PAC.USERS.get(e.getEntity().getUniqueId());
		if(u.getPlayer().getItemInHand() != null && Settings.FOODS.contains(u.getPlayer().getItemInHand().getType())) {
			if(u.getInvalidFoodEatableCount() != 0) {
				e.setCancelled(true);
				u.getPlayer().teleport(u.getFoodStartLocation());
				F2PAC.log(new CheckResult(Level.DEFINITELY, "Tried to move fast whilse eating " + u.getInvalidFoodEatableCount() + " times in a row!, max=" + Settings.MAX_XZ_EATING_SPEED, CheckType.NOSLOW), u);
			}
		}
	}
	
}
