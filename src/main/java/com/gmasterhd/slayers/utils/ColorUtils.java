package com.gmasterhd.slayers.utils;

import com.gmasterhd.slayers.utils.enums.Rarity;

public class ColorUtils {
	public static int getColor(Rarity rarity) {
		if(rarity == Rarity.COMMON) {
			return 0xFFFFFF;
		} else if(rarity == Rarity.UNCOMMON) {
			return 0x00AA00;
		} else if(rarity == Rarity.RARE) {
			return 0x5555FF;
		} else if(rarity == Rarity.EPIC) {
			return 0xAA00AA;
		} else if(rarity == Rarity.LEGENDARY) {
			return 0xFFAA00;
		}
		
		return 0x000000;
	}
}
