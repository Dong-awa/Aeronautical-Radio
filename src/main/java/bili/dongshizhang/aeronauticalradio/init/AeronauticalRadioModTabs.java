
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package bili.dongshizhang.aeronauticalradio.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import bili.dongshizhang.aeronauticalradio.AeronauticalRadioMod;

public class AeronauticalRadioModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AeronauticalRadioMod.MODID);
	public static final RegistryObject<CreativeModeTab> AERONAUTICAL_RADIO_CARD = REGISTRY.register("aeronautical_radio_card",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.aeronautical_radio.aeronautical_radio_card")).icon(() -> new ItemStack(AeronauticalRadioModItems.AIRBORNE_RADIO.get())).displayItems((parameters, tabData) -> {
				tabData.accept(AeronauticalRadioModBlocks.DISPATCH_RADIO.get().asItem());
				tabData.accept(AeronauticalRadioModItems.AIRBORNE_RADIO_EXPANDED.get());
				tabData.accept(AeronauticalRadioModItems.AIRBORNE_RADIO.get());
				tabData.accept(AeronauticalRadioModItems.ANTENNA.get());
				tabData.accept(AeronauticalRadioModItems.EPOXY_RESIN.get());
				tabData.accept(AeronauticalRadioModItems.GLASS_FIBER_FABRIC.get());
				tabData.accept(AeronauticalRadioModItems.PCB.get());
				tabData.accept(AeronauticalRadioModItems.CIRCUIT_BOARD.get());
				tabData.accept(AeronauticalRadioModItems.ELECTRONIC_COMPONENT.get());
				tabData.accept(AeronauticalRadioModItems.RADIO_COMPONENTS.get());
				tabData.accept(AeronauticalRadioModItems.RADIO_MODULE.get());
			}).build());
}
