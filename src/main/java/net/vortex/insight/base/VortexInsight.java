package net.vortex.insight.base;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.vortex.insight.gui.ClickGui;
import org.lwjgl.glfw.GLFW;

public class VortexInsight implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Если нажат ПРАВЫЙ SHIFT и меню еще не открыто
            if (client.player != null && GLFW.glfwGetKey(client.getWindow().getHandle(), GLFW.GLFW_KEY_RIGHT_SHIFT) == GLFW.GLFW_PRESS) {
                if (!(client.currentScreen instanceof ClickGui)) {
                    client.setScreen(new ClickGui());
                }
            }
        });
    }
}
