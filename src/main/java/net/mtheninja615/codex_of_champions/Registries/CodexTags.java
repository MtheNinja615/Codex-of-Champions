package net.mtheninja615.codex_of_champions.Registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.mtheninja615.codex_of_champions.CodexOfChampions;

public class CodexTags{

    /***
     * Items
     */

    // Magnetic School Fucus
    public static final TagKey<Item> MAGNETIC_FOCUS = ItemTags.create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "magnetic_focus").toString()));
}
