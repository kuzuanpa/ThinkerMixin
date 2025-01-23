package cn.kuzuanpa.TFCMixin.mixin;

import cn.kuzuanpa.TFCMixin.TFCMixin;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.settings.GameSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static cn.kuzuanpa.TFCMixin.TFCMixin.loadScreenTips;

@Mixin(GameSettings.class)
public class MixinUnicodeFontOnSetting {
    @Shadow protected Minecraft mc;

    @Shadow public boolean forceUnicodeFont;

    @Redirect(method = "setOptionValue", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/FontRenderer;setUnicodeFlag(Z)V"))
    public void setUnicode(FontRenderer instance, boolean p_78264_1_) {
        mc.fontRenderer.setUnicodeFlag(this.forceUnicodeFont);
    }
}
