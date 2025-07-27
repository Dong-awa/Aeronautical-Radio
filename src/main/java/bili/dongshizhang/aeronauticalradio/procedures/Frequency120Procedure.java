package bili.dongshizhang.aeronauticalradio.procedures;

import net.minecraft.world.entity.Entity;

import bili.dongshizhang.aeronauticalradio.network.AeronauticalRadioModVariables;

public class Frequency120Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 120;
			entity.getCapability(AeronauticalRadioModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.AirborneRadioFrequency = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
