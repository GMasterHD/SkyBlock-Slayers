package com.gmasterhd.slayers.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class CommandSlayers extends CommandBase {
	@Override
	public String getCommandName() {
		return "sbslayers";
	}
	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/sbslayers";
	}
	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
	}
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return true;
	}
}
