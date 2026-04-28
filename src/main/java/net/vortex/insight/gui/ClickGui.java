package net.vortex.insight.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.vortex.insight.modules.ModuleManager;

public class ClickGui extends Screen {
    public ClickGui() {
        super(Text.literal("Vortex ClickGUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Темный фон меню
        context.fill(10, 10, 150, 100, 0x90000000); 
        context.drawTextWithShadow(this.textRenderer, "VORTEX INSIGHT", 15, 15, 0x00AAAA);

        int yOffset = 35;
        // Проходим по всем нашим модулям и рисуем их
        for (String name : ModuleManager.modules.keySet()) {
            boolean enabled = ModuleManager.isEnabled(name);
            int color = enabled ? 0x55FF55 : 0xFF5555; // Зеленый если ВКЛ, Красный если ВЫКЛ
            
            context.drawTextWithShadow(this.textRenderer, name, 20, yOffset, color);
            yOffset += 12;
        }
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int yOffset = 35;
        for (String name : ModuleManager.modules.keySet()) {
            // Простая проверка: если кликнули в районе текста модуля
            if (mouseX > 20 && mouseX < 100 && mouseY > yOffset && mouseY < yOffset + 10) {
                ModuleManager.toggle(name);
                return true;
            }
            yOffset += 12;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldPause() {
        return false; // Игра не замирает при открытом меню
    }
}
