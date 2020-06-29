package net.fresh2play.plugins.F2PAC.checks;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;

public enum CheckType {
	
	SPEED("Speed", new Permission("f2pac.bypass.speed"));
	
	private String name;
	private Permission perm;

	private CheckType(String name, Permission perm) {
		this.name = name;
		this.perm = perm;
		Bukkit.getPluginManager().addPermission(perm);
	}

	public String getName() {
		return name;
	}

	public Permission getPerm() {
		return perm;
	}
	
}
