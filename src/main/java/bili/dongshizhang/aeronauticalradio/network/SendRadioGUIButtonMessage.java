
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

import bili.dongshizhang.aeronauticalradio.world.inventory.SendRadioGUIMenu;
import bili.dongshizhang.aeronauticalradio.procedures.Send122Procedure;
import bili.dongshizhang.aeronauticalradio.procedures.Send121Procedure;
import bili.dongshizhang.aeronauticalradio.procedures.Send120Procedure;
import bili.dongshizhang.aeronauticalradio.procedures.Send119Procedure;
import bili.dongshizhang.aeronauticalradio.procedures.Send118Procedure;
import bili.dongshizhang.aeronauticalradio.AeronauticalRadioMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SendRadioGUIButtonMessage {
	private final int buttonID, x, y, z;

	public SendRadioGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public SendRadioGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(SendRadioGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(SendRadioGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = SendRadioGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			Send118Procedure.execute(world, guistate);
		}
		if (buttonID == 1) {

			Send119Procedure.execute(world, guistate);
		}
		if (buttonID == 2) {

			Send120Procedure.execute(world, guistate);
		}
		if (buttonID == 3) {

			Send121Procedure.execute(world, guistate);
		}
		if (buttonID == 4) {

			Send122Procedure.execute(world, guistate);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		AeronauticalRadioMod.addNetworkMessage(SendRadioGUIButtonMessage.class, SendRadioGUIButtonMessage::buffer, SendRadioGUIButtonMessage::new, SendRadioGUIButtonMessage::handler);
	}
}
