package com.craftless.silkyfortune.loot;

import com.craftless.silkyfortune.SilkyFortuneMod;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, SilkyFortuneMod.MODID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> SILKY_FORTUNE = LOOT_MODIFIER_SERIALIZERS.register("silky_fortune", SilkyFortuneModifier.CODEC);
}