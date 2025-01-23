package cn.kuzuanpa.TFCMixin.mixin;

import cn.kuzuanpa.TFCMixin.TFCMixin;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static cn.kuzuanpa.TFCMixin.TFCMixin.loadScreenTips;

@Mixin(Minecraft.class)
public abstract class MixinUnicodeFontOnStart {
    @Shadow public GameSettings gameSettings;

    @Inject(method = "func_152349_b", at = @At("HEAD"), cancellable = true)
    public void setUnicode(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(gameSettings.forceUnicodeFont);
    }
}
