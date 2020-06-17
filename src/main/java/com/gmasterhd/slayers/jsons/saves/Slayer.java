package com.gmasterhd.slayers.jsons.saves;

import java.util.ArrayList;
import java.util.List;

public class Slayer {
	public String name;
	public int killCount;
	public List<SlayerDrop> Drops = new ArrayList<>();
	
	public Slayer(String id) {
		this.killCount = 0;
		this.name = id;
	}
	public Slayer(String id, int killCount, List<SlayerDrop> drops) {
		this.name = id;
		this.killCount = killCount;
		this.Drops = drops;
	}
}
