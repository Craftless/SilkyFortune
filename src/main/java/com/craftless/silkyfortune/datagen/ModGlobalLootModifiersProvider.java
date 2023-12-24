package com.craftless.silkyfortune.datagen;

import com.craftless.silkyfortune.SilkyFortuneMod;
import com.craftless.silkyfortune.loot.BlockTagLootItemCondition;
import com.craftless.silkyfortune.loot.SilkyFortuneModifier;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, SilkyFortuneMod.MODID);
    }

    @Override
    protected void start() {
        add("silky_fortune", new SilkyFortuneModifier(new LootItemCondition[]{
                MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))).hasEnchantment(new EnchantmentPredicate(Enchantments.BLOCK_FORTUNE, MinMaxBounds.Ints.atLeast(1)))).build(),
                BlockTagLootItemCondition.getBuilder(Tags.Blocks.ORES).build()
        }));
    }
}
