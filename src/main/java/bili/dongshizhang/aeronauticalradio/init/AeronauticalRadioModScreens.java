
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package bili.dongshizhang.aeronauticalradio.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import bili.dongshizhang.aeronauticalradio.client.gui.SendRadioGUIScreen;
import bili.dongshizhang.aeronauticalradio.client.gui.AirborneRadioGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AeronauticalRadioModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(AeronauticalRadioModMenus.AIRBORNE_RADIO_GUI.get(), AirborneRadioGUIScreen::new);
			MenuScreens.register(AeronauticalRadioModMenus.SEND_RADIO_GUI.get(), SendRadioGUIScreen::new);
		});
	}
}
