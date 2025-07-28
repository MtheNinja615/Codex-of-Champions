package net.mtheninja615.codex_of_champions.entities.render;

import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.mtheninja615.codex_of_champions.entities.mobs.bosses.AlianaModel;

public class AlianaRenderer extends AbstractSpellCastingMobRenderer {
    public AlianaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AlianaModel());
    }

    @Override
    protected float getDeathMaxRotation(AbstractSpellCastingMob animatable) {
        return 0.0F;
    }
}
