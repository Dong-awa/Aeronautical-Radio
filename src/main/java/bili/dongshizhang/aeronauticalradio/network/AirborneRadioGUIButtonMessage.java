
package bili.dongshizhang.aeronauticalradio.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

import bili.dongshizhang.aeronauticalradio.world.inventory.AirborneRadioGUIMenu;
import bili.dongshizhang.aeronauticalradio.procedures.Frequency122Procedure;
import bili.dongshizhang.aeronauticalradio.procedures.Frequency121Procedure;
import bili.dongshizhang.aeronauticalradio.procedures.Frequency120Procedure;
import bili.dongshizhang.aeronauticalradio.procedures.Frequency119Procedure;
import bili.dongshizhang.aeronauticalradio.procedures.Frequency118Procedure;
import bili.dongshizhang.aeronauticalradio.AeronauticalRadioMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AirborneRadioGUIButtonMessage {
	private final int buttonID, x, y, z;

	public AirborneRadioGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public AirborneRadioGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(AirborneRadioGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(AirborneRadioGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = AirborneRadioGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			Frequency118Procedure.execute(entity);
		}
		if (buttonID == 1) {

			Frequency119Procedure.execute(entity);
		}
		if (buttonID == 2) {

			Frequency120Procedure.execute(entity);
		}
		if (buttonID == 3) {

			Frequency121Procedure.execute(entity);
		}
		if (buttonID == 4) {

			Frequency122Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		AeronauticalRadioMod.addNetworkMessage(AirborneRadioGUIButtonMessage.class, AirborneRadioGUIButtonMessage::buffer, AirborneRadioGUIButtonMessage::new, AirborneRadioGUIButtonMessage::handler);
	}
}
