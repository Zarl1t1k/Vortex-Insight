package net.vortex.insight.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.vortex.insight.modules.ModuleManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo info) {
        // Превращаем текущий объект в игрока
        PlayerEntity player = (PlayerEntity) (Object) this;

        // Проверяем: 
        // 1. Включен ли модуль "Sprint" в нашем менеджере
        // 2. Двигается ли игрок вперед
        // 3. Не зажата ли клавиша приседания (Shift)
        if (ModuleManager.isEnabled("Sprint") && player.forwardSpeed > 0 && !player.isSneaking()) {
            player.setSprinting(true);
        }
    }
}
