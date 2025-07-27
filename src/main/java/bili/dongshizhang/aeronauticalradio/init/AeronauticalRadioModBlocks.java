
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package bili.dongshizhang.aeronauticalradio.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import bili.dongshizhang.aeronauticalradio.block.DispatchRadioBlock;
import bili.dongshizhang.aeronauticalradio.AeronauticalRadioMod;

public class AeronauticalRadioModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, AeronauticalRadioMod.MODID);
	public static final RegistryObject<Block> DISPATCH_RADIO = REGISTRY.register("dispatch_radio", () -> new DispatchRadioBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
