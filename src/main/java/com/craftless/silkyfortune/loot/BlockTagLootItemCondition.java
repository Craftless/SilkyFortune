package com.craftless.silkyfortune.loot;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
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

    final TagKey<Block> blockTag;

    public BlockTagLootItemCondition(TagKey<Block> blockTag) {
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
        return blockstate != null && blockstate.is(this.blockTag);
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<BlockTagLootItemCondition> {
        public void serialize(JsonObject p_81795_, BlockTagLootItemCondition p_81796_, JsonSerializationContext p_81797_) {
            p_81795_.addProperty("blocktag", p_81796_.blockTag.location().toString());
        }

        public BlockTagLootItemCondition deserialize(JsonObject p_81805_, JsonDeserializationContext p_81806_) {
            ResourceLocation resourcelocation = new ResourceLocation(GsonHelper.getAsString(p_81805_, "blocktag"));
            TagKey<Block> blockTag = TagKey.create(ForgeRegistries.BLOCKS.getRegistryKey(), resourcelocation);
            return new BlockTagLootItemCondition(blockTag);
        }
    }
}
