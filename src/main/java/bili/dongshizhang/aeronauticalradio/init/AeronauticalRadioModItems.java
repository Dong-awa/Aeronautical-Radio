
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package bili.dongshizhang.aeronauticalradio.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import bili.dongshizhang.aeronauticalradio.item.RadioModuleItem;
import bili.dongshizhang.aeronauticalradio.item.RadioComponentsItem;
import bili.dongshizhang.aeronauticalradio.item.PCBItem;
import bili.dongshizhang.aeronauticalradio.item.GlassFiberFabricItem;
import bili.dongshizhang.aeronauticalradio.item.EpoxyResinItem;
import bili.dongshizhang.aeronauticalradio.item.ElectronicComponentItem;
import bili.dongshizhang.aeronauticalradio.item.CircuitBoardItem;
import bili.dongshizhang.aeronauticalradio.item.AntennaItem;
import bili.dongshizhang.aeronauticalradio.item.AirborneRadioItem;
import bili.dongshizhang.aeronauticalradio.item.AirborneRadioExpandedItem;
import bili.dongshizhang.aeronauticalradio.AeronauticalRadioMod;

public class AeronauticalRadioModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, AeronauticalRadioMod.MODID);
	public static final RegistryObject<Item> AIRBORNE_RADIO = REGISTRY.register("airborne_radio", () -> new AirborneRadioItem());
	public static final RegistryObject<Item> AIRBORNE_RADIO_EXPANDED = REGISTRY.register("airborne_radio_expanded", () -> new AirborneRadioExpandedItem());
	public static final RegistryObject<Item> ANTENNA = REGISTRY.register("antenna", () -> new AntennaItem());
	public static final RegistryObject<Item> PCB = REGISTRY.register("pcb", () -> new PCBItem());
	public static final RegistryObject<Item> EPOXY_RESIN = REGISTRY.register("epoxy_resin", () -> new EpoxyResinItem());
	public static final RegistryObject<Item> GLASS_FIBER_FABRIC = REGISTRY.register("glass_fiber_fabric", () -> new GlassFiberFabricItem());
	public static final RegistryObject<Item> ELECTRONIC_COMPONENT = REGISTRY.register("electronic_component", () -> new ElectronicComponentItem());
	public static final RegistryObject<Item> CIRCUIT_BOARD = REGISTRY.register("circuit_board", () -> new CircuitBoardItem());
	public static final RegistryObject<Item> RADIO_COMPONENTS = REGISTRY.register("radio_components", () -> new RadioComponentsItem());
	public static final RegistryObject<Item> RADIO_MODULE = REGISTRY.register("radio_module", () -> new RadioModuleItem());
	public static final RegistryObject<Item> DISPATCH_RADIO = block(AeronauticalRadioModBlocks.DISPATCH_RADIO);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
