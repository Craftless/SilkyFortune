package com.craftless.silkyfortune.loot;

import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;

public class BlockTagLootItemCondition implements LootItemCondition {

    public static final Codec<BlockTagLootItemCondition> CODEC = RecordCodecBuilder.create(inst -> inst.group(Codec.STRING.fieldOf("tags").forGetter(m -> m.blockTag)).apply(inst, BlockTagLootItemCondition::new));

    private final String blockTag;

    public BlockTagLootItemCondition(String blockTag) {
        this.blockTag = blockTag;
    }

    public LootItemConditionType getType() {
        return ModLootConditions.BLOCK_TAG_LOOT_ITEM.get();
    }

    public Set<LootContextParam<?>> getReferencedContextParams() {
        return ImmutableSet.of(LootContextParams.BLOCK_STATE);
    }

    public boolean test(LootContext p_81772_) {
        BlockState blockstate = p_81772_.getParamOrNull(LootContextParams.BLOCK_STATE);
        return blockstate != null && blockstate.is(TagKey.create(ForgeRegistries.BLOCKS.getRegistryKey(), new ResourceLocation(this.blockTag)));
    }

    public static LootItemCondition.Builder getBuilder(TagKey<Block> blockTag) {
        return () -> new BlockTagLootItemCondition(blockTag.location().toString());
    }
}
