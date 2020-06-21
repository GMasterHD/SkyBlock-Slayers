package com.gmasterhd.slayers.jsons;

import com.gmasterhd.slayers.jsons.saves.*;

import java.util.ArrayList;
import java.util.List;

public class Saves {
	public List<Slayer> Slayers = new ArrayList<>();
	public boolean slayerVisible = false;
	public int[] slayerMenuPos = {
			5,
			5
	};
	
	public static Saves getPredefinedValues() {
		Saves saves = new Saves();
		Slayer zombie = new Slayer("Revenant Horror");
		Slayer spider = new Slayer("Tarantula Broodfather");
		Slayer wolf = new Slayer("Sven Packmaster");
		saves.Slayers.add(zombie);
		saves.Slayers.add(spider);
		saves.Slayers.add(wolf);
		
		return saves;
	}
	
	public void setSlayerMenuPos(int x, int y) {
		this.slayerMenuPos[0] = x;
		this.slayerMenuPos[1] = y;
	}
}
