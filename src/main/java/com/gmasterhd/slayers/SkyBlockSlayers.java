package com.gmasterhd.slayers;

import com.gmasterhd.slayers.commands.CommandSBS;
import com.gmasterhd.slayers.jsons.Config;
import com.gmasterhd.slayers.jsons.Saves;
import com.gmasterhd.slayers.listeners.SlayerListener;
import com.gmasterhd.slayers.listeners.SlayerRenderListener;
import com.gmasterhd.slayers.utils.PersistentFile;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SkyBlockSlayers.MODID, version = SkyBlockSlayers.VERSION, clientSideOnly = true)
public class SkyBlockSlayers {
	public static final String MODID = "skyblockslayers";
	public static final String VERSION = "1.0.0";
	
	public static Config config;
	public static Saves saves;
	
	public static PersistentFile<Config> configFile;
	public static PersistentFile<Saves> savesFile;
	
	public static int index_configSelectedSlayer = 2;
	public static int index_savesSelectedSlayer = 2;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		// Saves config file with predefined values if it not exists
		config = Config.getPredefinedValues();
		configFile = new PersistentFile<>(e.getModConfigurationDirectory().getPath() + "/" + MODID + "/config.json", config);
		config = configFile.load(Config.class);
		configFile.save(config);
		
		// Saves saves file with predefined values if it not exists
		saves = Saves.getPredefinedValues();
		savesFile = new PersistentFile<>(e.getModConfigurationDirectory().getAbsolutePath() + "/" + MODID + "/saves.json", saves);
		saves = savesFile.load(Saves.class);
		savesFile.save(saves);
		
		MinecraftForge.EVENT_BUS.register(new SlayerListener());
		MinecraftForge.EVENT_BUS.register(new SlayerRenderListener());
	}
	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
	}
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		ClientCommandHandler.instance.registerCommand(new CommandSBS());
	}
}
