
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package bili.dongshizhang.aeronauticalradio.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import bili.dongshizhang.aeronauticalradio.block.entity.DispatchRadioBlockEntity;
import bili.dongshizhang.aeronauticalradio.AeronauticalRadioMod;

public class AeronauticalRadioModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AeronauticalRadioMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> DISPATCH_RADIO = register("dispatch_radio", AeronauticalRadioModBlocks.DISPATCH_RADIO, DispatchRadioBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
