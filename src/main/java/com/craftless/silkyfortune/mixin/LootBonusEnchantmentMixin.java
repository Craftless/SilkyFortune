package com.craftless.silkyfortune.mixin;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.LootBonusEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LootBonusEnchantment.class)
public class LootBonusEnchantmentMixin {
    @Inject(at = @At(value = "HEAD"), method = "checkCompatibility", cancellable = true)
    private void checkCompatibility(Enchantment p_45094_, CallbackInfoReturnable<Boolean> info) {
        info.cancel();
        info.setReturnValue(p_45094_ != (LootBonusEnchantment)(Object)this);
    }
}
