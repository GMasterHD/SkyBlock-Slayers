package com.gmasterhd.slayers.jsons;

import com.gmasterhd.slayers.jsons.config.*;
import com.gmasterhd.slayers.utils.enums.Rarity;

import java.util.ArrayList;
import java.util.List;

public class Config {
	public List<Slayer> Slayers = new ArrayList<>();
	public static final int VERSION_ID = 0;
	
	public static Config getPredefinedValues() {
		Config config = new Config();
		
		Slayer zombie = new Slayer("Revenant Horror","Zombie","evenant Horr");
		zombie.Drops.add(new SlayerDrop("Foul Flesh", Rarity.RARE));
		zombie.Drops.add(new SlayerDrop("Undead Catalyst", Rarity.RARE));
		zombie.Drops.add(new SlayerDrop("Pestilence Rune", Rarity.RARE));
		zombie.Drops.add(new SlayerDrop("Enchanted Book", Rarity.RARE));
		zombie.Drops.add(new SlayerDrop("Beheaded Horror", Rarity.EPIC));
		zombie.Drops.add(new SlayerDrop("Revenant Catalyst", Rarity.EPIC));
		zombie.Drops.add(new SlayerDrop("Snake Rune", Rarity.EPIC));
		zombie.Drops.add(new SlayerDrop("Scythe Blade", Rarity.LEGENDARY));
		
		Slayer spider = new Slayer("Tarantula Broodfather", "Spider", "rantula Broodfat");
		spider.Drops.add(new SlayerDrop("Toxic Arrow Poison", Rarity.UNCOMMON));
		spider.Drops.add(new SlayerDrop("Bite Rune", Rarity.EPIC));
		spider.Drops.add(new SlayerDrop("Spider Catalyst", Rarity.RARE));
		spider.Drops.add(new SlayerDrop("Enchanted Book", Rarity.RARE));
		spider.Drops.add(new SlayerDrop("Fly Swatter", Rarity.EPIC));
		spider.Drops.add(new SlayerDrop("Tarantula Talisman", Rarity.EPIC));
		spider.Drops.add(new SlayerDrop("Disgested Mosquito", Rarity.LEGENDARY));
		
		Slayer wolf = new Slayer("Sven Packmaster", "Wolf", "ven Packmast");
		wolf.Drops.add(new SlayerDrop("Hamster Wheel", Rarity.RARE));
		wolf.Drops.add(new SlayerDrop("Spirit Rune", Rarity.RARE));
		wolf.Drops.add(new SlayerDrop("Enchanted Book", Rarity.RARE));
		wolf.Drops.add(new SlayerDrop("Red Claw Egg", Rarity.EPIC));
		wolf.Drops.add(new SlayerDrop("Grizzly Bait", Rarity.RARE));
		wolf.Drops.add(new SlayerDrop("Couture Rune", Rarity.LEGENDARY));
		wolf.Drops.add(new SlayerDrop("Overflux Capacitor", Rarity.LEGENDARY));
		
		config.Slayers.add(zombie);
		config.Slayers.add(spider);
		config.Slayers.add(wolf);
		
		return config;
	}
}
