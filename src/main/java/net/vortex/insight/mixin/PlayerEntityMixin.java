package net.vortex.insight.mixin;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    
    @Inject(method = "getAbilities().getWalkSpeed()", at = @At("HEAD"), cancellable = true)
    private void onGetSpeed(CallbackInfoReturnable<Float> info) {
        // Здесь в будущем будет код для SpeedHack
    }
}
