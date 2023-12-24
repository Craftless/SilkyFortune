package com.craftless.silkyfortune;

import com.craftless.silkyfortune.loot.ModLootConditions;
import com.craftless.silkyfortune.loot.ModLootModifiers;
import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(SilkyFortuneMod.MODID)
public class SilkyFortuneMod
{
    public static final String MODID = "silkyfortune";

    public SilkyFortuneMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLootConditions.LOOT_ITEM_CONDITIONS.register(modEventBus);
        ModLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
    }
}
