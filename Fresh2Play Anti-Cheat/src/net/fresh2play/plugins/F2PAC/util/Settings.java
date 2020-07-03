package net.fresh2play.plugins.F2PAC.util;

import static org.bukkit.Material.*;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

public class Settings {

	public static final Double MAX_XZ_SPEED = 0.67D; // Adjustable up to 1.00D
	public static final Double MAX_XZ_EATING_SPEED = 0.299D;
	public static final Double MAX_XZ_BLOCKING_SPEED = 0.299D; // whats this for no slow
	public static final String notify = "f2pac.notify";
	public static final String DONE = "passed";
	
	
	public static final List<Material> FOODS;
	
	static {
		FOODS = new ArrayList<Material>();
		FOODS.add(RAW_CHICKEN);
		FOODS.add(RAW_BEEF);
		FOODS.add(RAW_FISH);
		FOODS.add(COOKED_FISH);
		FOODS.add(COOKED_MUTTON);
		FOODS.add(COOKED_CHICKEN);
		FOODS.add(COOKED_RABBIT);
		FOODS.add(COOKED_BEEF);
		FOODS.add(GOLDEN_APPLE);
		FOODS.add(GOLDEN_CARROT);
		FOODS.add(CARROT);
		FOODS.add(APPLE);
		FOODS.add(POTATO);
		FOODS.add(POISONOUS_POTATO);
		FOODS.add(BAKED_POTATO);
		FOODS.add(MUSHROOM_SOUP);
		FOODS.add(BREAD);
		FOODS.add(COOKIE);
		FOODS.add(ROTTEN_FLESH);
		FOODS.add(SPIDER_EYE);
		FOODS.add(PUMPKIN_PIE);
		FOODS.add(RABBIT_STEW);
		FOODS.add(PORK);
		FOODS.add(MELON);
	}
}


