package net.vortex.insight.base;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class VortexInsight implements ClientModInitializer {
    public static boolean isPanicMode = false;

    @Override
    public void onInitializeClient() {
        // Регистрация нажатия клавиши (например, 'P' для проверки)
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null) {
                while (GLFW.glfwGetKey(client.getWindow().getHandle(), GLFW.GLFW_KEY_P) == GLFW.GLFW_PRESS) {
                    client.player.sendMessage(Text.literal("§b[Vortex] §fСистема работает!"), true);
                    break;
                }
            }
        });
    }
}
