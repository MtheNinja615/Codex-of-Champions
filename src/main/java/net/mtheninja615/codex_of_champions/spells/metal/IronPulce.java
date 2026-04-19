package net.mtheninja615.codex_of_champions.spells.metal;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.acetheeldritchking.aces_spell_utils.spells.ASSpellAnimations;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.Registries.CodexAttributeRegistry;
import net.mtheninja615.codex_of_champions.Registries.CodexSchoolRegistry;
import net.mtheninja615.codex_of_champions.entities.spells.iron_pulce.Ingot;
import net.mtheninja615.codex_of_champions.entities.spells.petal_blizzard.PetalBlizzard;

import java.util.List;
import java.util.Optional;
@AutoSpellConfig
public class IronPulce extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "iron_pulce");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2))
        );
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.COMMON)
            .setSchoolResource(CodexSchoolRegistry.MAGNETIC_RESOURCE)
            .setMaxLevel(10)
            .setCooldownSeconds(3)
            .build();

    public IronPulce() {
        this.manaCostPerLevel = 5;
        this.baseSpellPower = 1;
        this.spellPowerPerLevel = 1;
        this.baseManaCost = 10;
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(SoundRegistry.GUST_CAST.get());
    }

    @Override
    public AnimationHolder getCastStartAnimation() {
        return ASSpellAnimations.ANIMATION_SIMPLE_SHOOT;
    }

    @Override
    public CastType getCastType() {
        return CastType.INSTANT;
    }

    @Override
    public DefaultConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public ResourceLocation getSpellResource() {
        return spellId;
    }

    @Override
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(SoundRegistry.LIGHTNING_CAST.get());
    }

    @Override
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        Vec3 origin = entity.getEyePosition();

        Ingot ingot = new Ingot(world, entity);

        ingot.setDamage(getDamage(spellLevel, entity));

        ingot.setPos(entity.position().add(0, entity.getEyeHeight() - ingot.getBoundingBox().getYsize() * .5f, 0));
        ingot.shoot(entity.getLookAngle());

        world.addFreshEntity(ingot);
        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }


    public float getDamage(int spellLevel, LivingEntity caster) {
        if (caster == null) {
            return (float) getSpellPower(spellLevel, null) * 4;
        }

        double magnetPower = caster.getAttributeValue(CodexAttributeRegistry.MAGNETIC_MAGIC_POWER);
        double generalPower = caster.getAttributeValue(AttributeRegistry.SPELL_POWER);

        float damage = 6 + 7 * (float)(0.05) * spellLevel * (float)(magnetPower + generalPower);
        return damage;
    }

    public int getRadius(int spellLevel, LivingEntity caster) {
        return 2 + (int) getSpellPower(spellLevel, caster);


    }
}
