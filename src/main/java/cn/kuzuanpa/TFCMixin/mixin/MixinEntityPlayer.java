package cn.kuzuanpa.TFCMixin.mixin;

import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(EntityPlayer.class)
public class MixinEntityPlayer {
    @ModifyArg(method = "jump", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/EntityPlayer;addExhaustion(F)V"))
    public float mixinJumpExhaustion(float p_71020_1_){
        return 0.1F;
    }
    @ModifyConstant(method = "addMovementStat", constant = @Constant(floatValue = 0.099999994F))
    public float mixinMovementExhaustion(float constant){
        return 0.02F;
    }
}
