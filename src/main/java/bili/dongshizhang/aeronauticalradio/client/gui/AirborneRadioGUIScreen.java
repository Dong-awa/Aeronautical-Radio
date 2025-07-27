package bili.dongshizhang.aeronauticalradio.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

import bili.dongshizhang.aeronauticalradio.world.inventory.AirborneRadioGUIMenu;
import bili.dongshizhang.aeronauticalradio.network.AirborneRadioGUIButtonMessage;
import bili.dongshizhang.aeronauticalradio.AeronauticalRadioMod;

public class AirborneRadioGUIScreen extends AbstractContainerScreen<AirborneRadioGUIMenu> {
	private final static HashMap<String, Object> guistate = AirborneRadioGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_11800;
	Button button_11900;
	Button button_12000;
	Button button_12100;
	Button button_12200;

	public AirborneRadioGUIScreen(AirborneRadioGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("aeronautical_radio:textures/screens/airborne_radio_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 6 && mouseX < leftPos + 30 && mouseY > topPos + 68 && mouseY < topPos + 92) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.aeronautical_radio.airborne_radio_gui.tooltip_radio_frequency"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.aeronautical_radio.airborne_radio_gui.label_airborne_radio"), 51, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.aeronautical_radio.airborne_radio_gui.label_empty"), 15, 75, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.aeronautical_radio.airborne_radio_gui.label_radio_frequency"), 51, 70, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.aeronautical_radio.airborne_radio_gui.label_the_same_radio_frequency_can_com"), 6, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.aeronautical_radio.airborne_radio_gui.label_can_communicate"), 6, 34, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_11800 = Button.builder(Component.translatable("gui.aeronautical_radio.airborne_radio_gui.button_11800"), e -> {
			if (true) {
				AeronauticalRadioMod.PACKET_HANDLER.sendToServer(new AirborneRadioGUIButtonMessage(0, x, y, z));
				AirborneRadioGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 97, 56, 20).build();
		guistate.put("button:button_11800", button_11800);
		this.addRenderableWidget(button_11800);
		button_11900 = Button.builder(Component.translatable("gui.aeronautical_radio.airborne_radio_gui.button_11900"), e -> {
			if (true) {
				AeronauticalRadioMod.PACKET_HANDLER.sendToServer(new AirborneRadioGUIButtonMessage(1, x, y, z));
				AirborneRadioGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 60, this.topPos + 97, 56, 20).build();
		guistate.put("button:button_11900", button_11900);
		this.addRenderableWidget(button_11900);
		button_12000 = Button.builder(Component.translatable("gui.aeronautical_radio.airborne_radio_gui.button_12000"), e -> {
			if (true) {
				AeronauticalRadioMod.PACKET_HANDLER.sendToServer(new AirborneRadioGUIButtonMessage(2, x, y, z));
				AirborneRadioGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 114, this.topPos + 97, 56, 20).build();
		guistate.put("button:button_12000", button_12000);
		this.addRenderableWidget(button_12000);
		button_12100 = Button.builder(Component.translatable("gui.aeronautical_radio.airborne_radio_gui.button_12100"), e -> {
			if (true) {
				AeronauticalRadioMod.PACKET_HANDLER.sendToServer(new AirborneRadioGUIButtonMessage(3, x, y, z));
				AirborneRadioGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 33, this.topPos + 124, 56, 20).build();
		guistate.put("button:button_12100", button_12100);
		this.addRenderableWidget(button_12100);
		button_12200 = Button.builder(Component.translatable("gui.aeronautical_radio.airborne_radio_gui.button_12200"), e -> {
			if (true) {
				AeronauticalRadioMod.PACKET_HANDLER.sendToServer(new AirborneRadioGUIButtonMessage(4, x, y, z));
				AirborneRadioGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 87, this.topPos + 124, 56, 20).build();
		guistate.put("button:button_12200", button_12200);
		this.addRenderableWidget(button_12200);
	}
}
