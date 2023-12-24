package com.craftless.silkyfortune.loot;

import com.craftless.silkyfortune.SilkyFortuneMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModLootConditions {
    public static final DeferredRegister<LootItemConditionType> LOOT_ITEM_CONDITIONS = DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, SilkyFortuneMod.MODID);
    public static final RegistryObject<LootItemConditionType> BLOCK_TAG_LOOT_ITEM = LOOT_ITEM_CONDITIONS.register("blocktag", () -> new LootItemConditionType(new BlockTagLootItemCondition.Serializer()));
}
