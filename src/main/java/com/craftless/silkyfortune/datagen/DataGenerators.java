package com.craftless.silkyfortune.datagen;

import com.craftless.silkyfortune.SilkyFortuneMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SilkyFortuneMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        generator.addProvider(e.includeServer(), new ModGlobalLootModifiersProvider(packOutput));
    }
}
