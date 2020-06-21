package com.gmasterhd.slayers.listeners;

import com.gmasterhd.slayers.SkyBlockSlayers;
import com.gmasterhd.slayers.jsons.saves.SlayerDrop;
import com.gmasterhd.slayers.utils.ColorUtils;
import com.gmasterhd.slayers.utils.enums.Rarity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SlayerRenderListener {
	@SubscribeEvent
	public void onRenderRegular(RenderGameOverlayEvent.Post e) {
		if((Minecraft.getMinecraft()).ingameGUI instanceof GuiIngameForge && (e.type == RenderGameOverlayEvent.ElementType.EXPERIENCE || e.type == RenderGameOverlayEvent.ElementType.JUMPBAR)) {
			if(SkyBlockSlayers.saves.slayerVisible) {
				GlStateManager.disableBlend();
				
				FontRenderer fr = Minecraft.getMinecraft().ingameGUI.getFontRenderer();
				int currentY = SkyBlockSlayers.saves.slayerMenuPos[1];
				for(int x = SkyBlockSlayers.config.Slayers.get(SkyBlockSlayers.index_configSelectedSlayer).Drops.size() - 1; x >= 0; --x) {
					SlayerDrop save_drop = null;
					boolean found = false;
					for(SlayerDrop s : SkyBlockSlayers.saves.Slayers.get(SkyBlockSlayers.index_savesSelectedSlayer).Drops) {
						if(s.name.equals(SkyBlockSlayers.config.Slayers.get(SkyBlockSlayers.index_configSelectedSlayer).Drops.get(x).name)) {
							save_drop = s;
							found = true;
							break;
						}
					}
					
					if(found) {
						fr.drawStringWithShadow(SkyBlockSlayers.config.Slayers.get(SkyBlockSlayers.index_configSelectedSlayer).Drops.get(x).name + ": " + save_drop.count, SkyBlockSlayers.saves.slayerMenuPos[0], currentY, ColorUtils.getColor(SkyBlockSlayers.config.Slayers.get(SkyBlockSlayers.index_configSelectedSlayer).Drops.get(x).rarity));
					} else {
						fr.drawStringWithShadow(SkyBlockSlayers.config.Slayers.get(SkyBlockSlayers.index_configSelectedSlayer).Drops.get(x).name + ": 0", SkyBlockSlayers.saves.slayerMenuPos[0], currentY, ColorUtils.getColor(SkyBlockSlayers.config.Slayers.get(SkyBlockSlayers.index_configSelectedSlayer).Drops.get(x).rarity));
					}
					
					currentY += 10;
				}
				fr.drawStringWithShadow("Killed Bosses: " + SkyBlockSlayers.saves.Slayers.get(SkyBlockSlayers.index_savesSelectedSlayer).killCount, SkyBlockSlayers.saves.slayerMenuPos[0], currentY, ColorUtils.getColor(Rarity.UNCOMMON));

				GlStateManager.enableBlend();
			}
		}
	}
}
