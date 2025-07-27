
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package bili.dongshizhang.aeronauticalradio.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import bili.dongshizhang.aeronauticalradio.world.inventory.SendRadioGUIMenu;
import bili.dongshizhang.aeronauticalradio.world.inventory.AirborneRadioGUIMenu;
import bili.dongshizhang.aeronauticalradio.AeronauticalRadioMod;

public class AeronauticalRadioModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, AeronauticalRadioMod.MODID);
	public static final RegistryObject<MenuType<AirborneRadioGUIMenu>> AIRBORNE_RADIO_GUI = REGISTRY.register("airborne_radio_gui", () -> IForgeMenuType.create(AirborneRadioGUIMenu::new));
	public static final RegistryObject<MenuType<SendRadioGUIMenu>> SEND_RADIO_GUI = REGISTRY.register("send_radio_gui", () -> IForgeMenuType.create(SendRadioGUIMenu::new));
}
