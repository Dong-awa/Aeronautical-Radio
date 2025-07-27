package bili.dongshizhang.aeronauticalradio.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import bili.dongshizhang.aeronauticalradio.network.AeronauticalRadioModVariables;

public class Send122Procedure {
	public static void execute(LevelAccessor world, HashMap guistate) {
		if (guistate == null)
			return;
		AeronauticalRadioModVariables.WorldVariables.get(world).information = guistate.containsKey("text:RadioText") ? ((EditBox) guistate.get("text:RadioText")).getValue() : "";
		AeronauticalRadioModVariables.WorldVariables.get(world).syncData(world);
		AeronauticalRadioModVariables.InformationFrequency = 122;
	}
}
