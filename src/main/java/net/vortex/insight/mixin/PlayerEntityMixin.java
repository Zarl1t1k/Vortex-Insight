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
        PlayerEntity player = (PlayerEntity) (Object) this;
        // Авто-бег: если игрок движется вперед и не крадется
        if (player.forwardSpeed > 0 && !player.isSneaking()) {
            player.setSprinting(true);
        }
    }
}
