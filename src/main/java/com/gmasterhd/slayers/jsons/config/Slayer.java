package com.gmasterhd.slayers.jsons.config;

import java.util.ArrayList;
import java.util.List;

public class Slayer {
	public String name;
	public String type;
	public String chatTrigger;
	public String scoreTrigger;
	public List<SlayerDrop> Drops = new ArrayList<>();
	
	public Slayer(String name, String type, String chatTrigger, String scoreTrigger) {
		this.name = name;
		this.type = type;
		this.chatTrigger = chatTrigger;
		this.scoreTrigger = scoreTrigger;
	}
	public Slayer(String name, String type, String scoreTrigger) {
		this.name = name;
		this.type = type;
		this.chatTrigger = type + " Slayer XP";
		this.scoreTrigger = scoreTrigger;
	}
}
