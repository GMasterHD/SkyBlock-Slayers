package com.gmasterhd.slayers.jsons.config;

import com.gmasterhd.slayers.utils.enums.Rarity;

public class SlayerDrop {
	public String name;
	public String chatTrigger;
	public Rarity rarity;
	
	public SlayerDrop(String name, Rarity rarity) {
		this.name = name;
		this.chatTrigger = name;
		this.rarity = rarity;
	}
}
