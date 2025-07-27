package bili.dongshizhang.aeronauticalradio.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

import bili.dongshizhang.aeronauticalradio.world.inventory.SendRadioGUIMenu;
import bili.dongshizhang.aeronauticalradio.network.SendRadioGUIButtonMessage;
import bili.dongshizhang.aeronauticalradio.AeronauticalRadioMod;

public class SendRadioGUIScreen extends AbstractContainerScreen<SendRadioGUIMenu> {
	private final static HashMap<String, Object> guistate = SendRadioGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox RadioText;
	Button button_11800;
	Button button_11900;
	Button button_12000;
	Button button_12100;
	Button button_12200;

	public SendRadioGUIScreen(SendRadioGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("aeronautical_radio:textures/screens/send_radio_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		RadioText.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 6 && mouseX < leftPos + 30 && mouseY > topPos + 97 && mouseY < topPos + 121) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.aeronautical_radio.send_radio_gui.tooltip_radio_frequency"), mouseX, mouseY);
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
		if (RadioText.isFocused())
			return RadioText.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		RadioText.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String RadioTextValue = RadioText.getValue();
		super.resize(minecraft, width, height);
		RadioText.setValue(RadioTextValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.aeronautical_radio.send_radio_gui.label_airborne_radio"), 51, 4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.aeronautical_radio.send_radio_gui.label_empty"), 15, 106, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.aeronautical_radio.send_radio_gui.label_radio_frequency"), 51, 106, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.aeronautical_radio.send_radio_gui.label_the_same_radio_frequency_can_com"), 6, 16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.aeronautical_radio.send_radio_gui.label_can_communicate"), 6, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.aeronautical_radio.send_radio_gui.label_sent_information"), 42, 43, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		RadioText = new EditBox(this.font, this.leftPos + 7, this.topPos + 53, 160, 18, Component.translatable("gui.aeronautical_radio.send_radio_gui.RadioText")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.aeronautical_radio.send_radio_gui.RadioText").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.aeronautical_radio.send_radio_gui.RadioText").getString());
				else
					setSuggestion(null);
			}
		};
		RadioText.setSuggestion(Component.translatable("gui.aeronautical_radio.send_radio_gui.RadioText").getString());
		RadioText.setMaxLength(32767);
		guistate.put("text:RadioText", RadioText);
		this.addWidget(this.RadioText);
		button_11800 = Button.builder(Component.translatable("gui.aeronautical_radio.send_radio_gui.button_11800"), e -> {
			if (true) {
				AeronauticalRadioMod.PACKET_HANDLER.sendToServer(new SendRadioGUIButtonMessage(0, x, y, z));
				SendRadioGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 124, 56, 20).build();
		guistate.put("button:button_11800", button_11800);
		this.addRenderableWidget(button_11800);
		button_11900 = Button.builder(Component.translatable("gui.aeronautical_radio.send_radio_gui.button_11900"), e -> {
			if (true) {
				AeronauticalRadioMod.PACKET_HANDLER.sendToServer(new SendRadioGUIButtonMessage(1, x, y, z));
				SendRadioGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 60, this.topPos + 124, 56, 20).build();
		guistate.put("button:button_11900", button_11900);
		this.addRenderableWidget(button_11900);
		button_12000 = Button.builder(Component.translatable("gui.aeronautical_radio.send_radio_gui.button_12000"), e -> {
			if (true) {
				AeronauticalRadioMod.PACKET_HANDLER.sendToServer(new SendRadioGUIButtonMessage(2, x, y, z));
				SendRadioGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 114, this.topPos + 124, 56, 20).build();
		guistate.put("button:button_12000", button_12000);
		this.addRenderableWidget(button_12000);
		button_12100 = Button.builder(Component.translatable("gui.aeronautical_radio.send_radio_gui.button_12100"), e -> {
			if (true) {
				AeronauticalRadioMod.PACKET_HANDLER.sendToServer(new SendRadioGUIButtonMessage(3, x, y, z));
				SendRadioGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 33, this.topPos + 142, 56, 20).build();
		guistate.put("button:button_12100", button_12100);
		this.addRenderableWidget(button_12100);
		button_12200 = Button.builder(Component.translatable("gui.aeronautical_radio.send_radio_gui.button_12200"), e -> {
			if (true) {
				AeronauticalRadioMod.PACKET_HANDLER.sendToServer(new SendRadioGUIButtonMessage(4, x, y, z));
				SendRadioGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 87, this.topPos + 142, 56, 20).build();
		guistate.put("button:button_12200", button_12200);
		this.addRenderableWidget(button_12200);
	}
}
