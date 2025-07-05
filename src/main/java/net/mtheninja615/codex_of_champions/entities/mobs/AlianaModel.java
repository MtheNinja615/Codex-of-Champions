package net.mtheninja615.codex_of_champions.entities.mobs;

import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMobModel;
import net.minecraft.resources.ResourceLocation;
import net.mtheninja615.codex_of_champions.CodexOfChampions;

public class AlianaModel extends AbstractSpellCastingMobModel {
    @Override
    public ResourceLocation getTextureResource(AbstractSpellCastingMob mob) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "textures/entity/bosses/aliana.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AbstractSpellCastingMob object) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "animations/casting_animations.json");
    }
}