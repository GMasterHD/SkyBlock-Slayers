package com.gmasterhd.slayers.utils;

import com.gmasterhd.slayers.SkyBlockSlayers;
import com.gmasterhd.slayers.jsons.Config;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class AuoUpdater {
	public static final String UPDATE_URL = "https://drive.google.com/uc?export=download&id=1G_nBSYyaBHxeGE3ZVUqDpWSTOAzvBQdO";
	
	public static boolean updateAvailable = false;
	
	public static void checkForUpdates() {
		System.out.println("Checking for updates...");
		new Thread("Update-Checker") {
			public void run() {
				try {
					URL url = new URL(UPDATE_URL);
					Scanner s = new Scanner(url.openStream());
					String firstLine = s.nextLine();
					
					System.out.println(firstLine);
					
					if(Integer.parseInt(firstLine) > Config.VERSION_ID) {
						System.out.println("New Version found!");
						System.out.println("Current Version: " + Config.VERSION_ID + " Update: " + firstLine);
						updateAvailable = true;
						String update = s.nextLine();
						System.out.println("Update URL " + update);
						SkyBlockSlayers.updateURL = update;
					}
				} catch(MalformedURLException e) {
					e.printStackTrace();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
