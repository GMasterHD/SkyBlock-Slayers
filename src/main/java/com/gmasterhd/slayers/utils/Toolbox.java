package com.gmasterhd.slayers.utils;

import net.minecraft.scoreboard.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.stream.Collectors;

public class Toolbox {
	public static List<String> getSidebarLines(Scoreboard board) {
		List<String> lines = new ArrayList();
		// Grab the main objective of the scoreboard.
		ScoreObjective objective = board.getObjectiveInDisplaySlot(1);
		
		List<Score> scores = (List<Score>)board.getSortedScores(objective);
		
		scores = (List<Score>)scores.stream().filter(input -> (input.getPlayerName() != null && !input.getPlayerName().startsWith("#"))).skip(Math.max(scores.size() - 15, 0)).collect(Collectors.toList());
		
		Formatter formatter = new Formatter();
		
		Collections.reverse(scores);
		for (Score score : scores) {
			int width = 30;
			ScorePlayerTeam scoreplayerteam = board.getPlayersTeam(score.getPlayerName());
			String playerName = ScorePlayerTeam.formatPlayerName((Team)scoreplayerteam, score.getPlayerName());
			playerName = RegexUtils.strip(playerName, RegexUtils.SIDEBAR_PLAYER_NAME_PATTERN);
			//if (stripControlCodes)
			//	playerName = StringUtils.func_76338_a(playerName);
			int points = score.getScorePoints();
			width = Math.max(width, (playerName + " " + points).length());
			formatter.format("%-" + width + "." + width + "s %d%n", new Object[] { playerName, Integer.valueOf(points) });
			
			lines.add(playerName);
			
			System.out.println("Width: " + width + " PlayerName: " + playerName);
		}
		
		return lines;
	}
	
	public static boolean scoreboardContains(Scoreboard board, String contains) {
		List<String> boardLines = getSidebarLines(board);
		
		boolean found = false;
		for(String s: boardLines) {
			if(s.contains(contains)) {
				found = true;
			}
		}
		
		return found;
	}
}
