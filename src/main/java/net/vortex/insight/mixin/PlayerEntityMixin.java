package net.vortex.insight.mixin;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo info) {
        // Превращаем 'this' (текущий объект) в игрока, чтобы управлять им
        PlayerEntity player = (PlayerEntity) (Object) this;

        // Условие для умного спринта:
        // 1. Игрок нажимает кнопку движения вперед (forwardSpeed > 0)
        // 2. Игрок не крадется (isSneaking)
        // 3. Игрок не под водой (чтобы не багал заплыв)
        if (player.forwardSpeed > 0 && !player.isSneaking() && !player.isSubmergedInWater()) {
            player.setSprinting(true);
        }
    }
}
