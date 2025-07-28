package net.mtheninja615.codex_of_champions.entities.render;

import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.mtheninja615.codex_of_champions.entities.mobs.spellcastingmobs.PaladinModel;

public class PaladinRenderer extends AbstractSpellCastingMobRenderer {

    public PaladinRenderer(EntityRendererProvider.Context context) {
        super(context, new PaladinModel());
    }

}