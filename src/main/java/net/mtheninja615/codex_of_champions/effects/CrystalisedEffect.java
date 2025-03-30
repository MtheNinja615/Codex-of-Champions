/*package net.mtheninja615.codex_of_champions.effects;

import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.mtheninja615.codex_of_champions.CodexOfChampions;


public class CrystalisedEffect extends MagicMobEffect {
    public CrystalisedEffect() {
        super(MobEffectCategory.BENEFICIAL, 221222);
        this.addAttributeModifier(Attributes.ATTACK_DAMAGE, CodexOfChampions.id("crystalised_effect"), CrystalisedEffect.ATTACK_DAMAGE_PER_LEVEL, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
    }
    public static final float ATTACK_DAMAGE_PER_LEVEL = 0.25f;

    @Override
    public void removeAttributeModifiers(AttributeMap attributeMap) {
        super.removeAttributeModifiers(attributeMap);
    }

    @Override
    public MobEffect addAttributeModifier(Holder<Attribute> attribute, ResourceLocation id, double amount, AttributeModifier.Operation operation) {
        return super.addAttributeModifier(attribute, id, amount, operation);
    }
}
*/
