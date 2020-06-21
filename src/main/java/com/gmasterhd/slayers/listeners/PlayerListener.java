package com.gmasterhd.slayers.listeners;

import com.gmasterhd.slayers.SkyBlockSlayers;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Iterator;
import java.util.List;

public class PlayerListener {
	@SubscribeEvent
	public void onPlayerJoin(EntityJoinWorldEvent e) {
		if(e.entity instanceof EntityPlayerSP) {
			if(!SkyBlockSlayers.updateURL.equals("NONE")) {
				ClickEvent ce = new ClickEvent(ClickEvent.Action.OPEN_URL, SkyBlockSlayers.updateURL);
				Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("SkyBlock Utils > An update is available! Go to https://github.com/gmasterhd/skyblock-slayers/ to download!"));
			}
		}
	}
}
