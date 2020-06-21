package com.gmasterhd.slayers.commands;

import com.gmasterhd.slayers.SkyBlockSlayers;
import com.gmasterhd.slayers.jsons.saves.Slayer;
import com.gmasterhd.slayers.jsons.saves.SlayerDrop;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;

public class CommandSBS extends CommandBase {
	@Override
	public String getCommandName() {
		return "sbs";
	}
	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/sbs toggle: Toggles the Slayer menu \n /sbs reset <slayer>: Reset a specific slayer or drop of slayer \n /sbs <position|pos> <x> <y>";
	}
	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		if(args.length == 0) {
			sender.addChatMessage(new ChatComponentText(getCommandUsage(sender)));
		}
		
		if(args.length > 0) {
			if(args[0].equals("toggle")) {
				SkyBlockSlayers.saves.slayerVisible = !SkyBlockSlayers.saves.slayerVisible;
			}
		}
		if(args.length > 1) {
			if(args[0].equals("reset")) {
				boolean found = false;
				for(int x = 0; x < SkyBlockSlayers.saves.Slayers.size(); ++x) {
					if(SkyBlockSlayers.saves.Slayers.get(x).name.toLowerCase().replace(" ", "").equals(args[1].toLowerCase().replace(" ", ""))) {
						SkyBlockSlayers.saves.Slayers.set(x, new Slayer(SkyBlockSlayers.saves.Slayers.get(x).name));
						found = true;
					}
				}
				if(!found) {
					sender.addChatMessage(new ChatComponentText("No Slayer called " + args[1] + " found!"));
				}
			}
		}
		if(args.length > 2) {
			if(args[0].equals("position") || args[0].equals("pos")) {
				SkyBlockSlayers.saves.setSlayerMenuPos(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
				SkyBlockSlayers.savesFile.save(SkyBlockSlayers.saves);
			}
		}
		
		SkyBlockSlayers.savesFile.save(SkyBlockSlayers.saves);
	}
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return true;
	}
}
