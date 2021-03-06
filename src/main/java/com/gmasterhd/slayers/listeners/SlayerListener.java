package com.gmasterhd.slayers.listeners;

import com.gmasterhd.slayers.SkyBlockSlayers;
import com.gmasterhd.slayers.jsons.config.Slayer;
import com.gmasterhd.slayers.jsons.saves.SlayerDrop;
import com.gmasterhd.slayers.utils.Toolbox;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.commons.lang3.time.StopWatch;

public class SlayerListener {
	public static Slayer config_lastSlayer = null;
	
	public static int index_saveFile = 2;
	public static int index_configFile = 2;
	
	@SubscribeEvent
	public void onGuiOpen(GuiOpenEvent e) {
		System.out.println("Saving Mod states...");
		SkyBlockSlayers.savesFile.save(SkyBlockSlayers.saves);
	}
	
	@SubscribeEvent
	public void onChatReceived(ClientChatReceivedEvent e) {
		if(e.type == 0 || e.type == 2) {
			String msg = EnumChatFormatting.getTextWithoutFormattingCodes(e.message.getUnformattedText());
			if(msg.contains("XP")) {
				// Get Position of killed Slayer in config file
				for(int x = 0; x < SkyBlockSlayers.config.Slayers.size(); ++x) {
					Slayer s = SkyBlockSlayers.config.Slayers.get(x);
					System.out.println(s.chatTrigger + " " + s.scoreTrigger);
					if(msg.contains(s.chatTrigger) /*&& Toolbox.scoreboardContains(Minecraft.getMinecraft().theWorld.getScoreboard(), s.scoreTrigger)*/) {
						config_lastSlayer = s;
						SkyBlockSlayers.index_configSelectedSlayer = x;
						System.out.println("Config: " + x + ", " + config_lastSlayer.name);
						System.out.println("SLAYER KILLED!");
					}
				}
				// Get Position of killed Slayer in saves file
				if(config_lastSlayer != null) {
					for(int x = 0; x < SkyBlockSlayers.saves.Slayers.size(); ++x) {
						if(config_lastSlayer.name.equals(SkyBlockSlayers.saves.Slayers.get(x).name)) {
							SkyBlockSlayers.index_savesSelectedSlayer = x;
							index_saveFile = x;
							System.out.println("Save: " + x);
							SkyBlockSlayers.saves.Slayers.set(SkyBlockSlayers.index_savesSelectedSlayer, new com.gmasterhd.slayers.jsons.saves.Slayer(SkyBlockSlayers.saves.Slayers.get(SkyBlockSlayers.index_savesSelectedSlayer).name, ++SkyBlockSlayers.saves.Slayers.get(SkyBlockSlayers.index_savesSelectedSlayer).killCount, SkyBlockSlayers.saves.Slayers.get(SkyBlockSlayers.index_savesSelectedSlayer).Drops));
							SkyBlockSlayers.savesFile.save(SkyBlockSlayers.saves);
							break;
						}
					}
				}
			}
			
			if(config_lastSlayer != null) {
				if(msg.contains("RARE DROP")) {
					System.out.println("Drop Message: " + msg);
					String dropName = msg.substring(msg.indexOf('(') + 1, msg.indexOf(')'));
					System.out.println("Drop Name: " + dropName);
					
					com.gmasterhd.slayers.jsons.saves.Slayer oldSlayer = SkyBlockSlayers.saves.Slayers.get(index_saveFile);
					int index_drop = -1;
					for(int x = 0; x < oldSlayer.Drops.size(); ++x) {
						SlayerDrop drop = oldSlayer.Drops.get(x);
						if(drop.name.equals(dropName)) {
							index_drop = x;
						}
					}
					if(index_drop >= 0) {
						oldSlayer.Drops.set(index_drop, new SlayerDrop(dropName, ++oldSlayer.Drops.get(index_drop).count));
					} else {
						oldSlayer.Drops.add(new SlayerDrop(dropName, 1));
					}
					
					if(msg.contains("CRAZY RARE DROP!")) {
						System.out.println("RNG!");
						StopWatch timer = new StopWatch();
						timer.start();
						SkyBlockSlayers.saves.Slayers.set(index_saveFile, new com.gmasterhd.slayers.jsons.saves.Slayer(SkyBlockSlayers.saves.Slayers.get(index_saveFile).name, SkyBlockSlayers.saves.Slayers.get(index_saveFile).killCount, SkyBlockSlayers.saves.Slayers.get(index_saveFile).Drops, timer));
					}
					
					SkyBlockSlayers.savesFile.save(SkyBlockSlayers.saves);
					config_lastSlayer = null;
				}
			} else {
				System.err.println("No Slayer killed!");
			}
		}
	}
}
