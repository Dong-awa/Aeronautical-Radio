package bili.dongshizhang.aeronauticalradio.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import bili.dongshizhang.aeronauticalradio.network.AeronauticalRadioModVariables;
import bili.dongshizhang.aeronauticalradio.AeronauticalRadioMod;

public class AirborneRadioExpandedWuPinZaiWuPinLanShiMeiKeFaShengProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		assert Boolean.TRUE; //#dbg:AirborneRadioExpandedWuPinZaiWuPinLanShiMeiKeFaSheng:a1
		AeronauticalRadioMod.LOGGER.info((entity.getCapability(AeronauticalRadioModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AeronauticalRadioModVariables.PlayerVariables())).AirborneRadioFrequency);
		AeronauticalRadioMod.LOGGER.info(AeronauticalRadioModVariables.InformationFrequency);
		if ((entity.getCapability(AeronauticalRadioModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AeronauticalRadioModVariables.PlayerVariables())).AirborneRadioFrequency == AeronauticalRadioModVariables.InformationFrequency) {
			assert Boolean.TRUE; //#dbg:AirborneRadioExpandedWuPinZaiWuPinLanShiMeiKeFaSheng:a2
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(AeronauticalRadioModVariables.WorldVariables.get(world).information), true);
		}
	}
}
