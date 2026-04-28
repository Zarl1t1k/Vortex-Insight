package net.vortex.insight.mixin;

import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class LightmapMixin {
    @Inject(method = "getNightVisionStrength", at = @At("HEAD"), cancellable = true)
    private static void onGetNightVisionStrength(CallbackInfoReturnable<Float> info) {
        // Мы заставляем игру думать, что у нас всегда эффект ночного зрения на 100%
        info.setReturnValue(1.0f);
    }
}
