package net.mtheninja615.codex_of_champions.spells.nature;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.events.SpellSummonEvent;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.Registries.EffectRegistry;
import net.mtheninja615.codex_of_champions.entities.mobs.SummonedBogged;
import net.neoforged.neoforge.common.NeoForge;

import java.util.List;
import java.util.Optional;

@AutoSpellConfig
public class SummonBogged extends AbstractSpell {
    private final ResourceLocation spellId =  ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "summon_bogged");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.hp", getBoggedHealth(spellLevel, null)),
                Component.translatable("ui.irons_spellbooks.damage", getBoggedDamage(spellLevel, null))
        );
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.RARE)
            .setSchoolResource(SchoolRegistry.NATURE_RESOURCE)
            .setMaxLevel(10)
            .setCooldownSeconds(280)
            .build();

    public SummonBogged() {
        this.manaCostPerLevel = 10;
        this.baseSpellPower = 4;
        this.spellPowerPerLevel = 1;
        this.castTime = 20;
        this.baseManaCost = 50;
    }

    @Override
    public CastType getCastType() {
        return CastType.LONG;
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
        return Optional.of(SoundEvents.BOGGED_AMBIENT);
    }

    @Override
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        int summonTime = 100;

        SummonedBogged bogged = new SummonedBogged(world, entity);
        bogged.setPos(entity.position());

        bogged.getAttributes().getInstance(Attributes.ATTACK_DAMAGE).setBaseValue(getBoggedDamage(spellLevel, entity));
        bogged.getAttributes().getInstance(Attributes.MAX_HEALTH).setBaseValue(getBoggedHealth(spellLevel, entity));
        bogged.setHealth(bogged.getMaxHealth());
        var event = NeoForge.EVENT_BUS.post(new SpellSummonEvent<SummonedBogged>(entity, bogged, this.spellId, spellLevel));
        world.addFreshEntity(event.getCreature());

        bogged.addEffect(new MobEffectInstance(EffectRegistry.SUMMONED_BOGGED, summonTime, 0, false, false, false));
        int effectAmplifier = 0;
        if (entity.hasEffect(EffectRegistry.SUMMONED_BOGGED))
            effectAmplifier += entity.getEffect(EffectRegistry.SUMMONED_BOGGED).getAmplifier() + 1;
        entity.addEffect(new MobEffectInstance(EffectRegistry.SUMMONED_BOGGED, summonTime, effectAmplifier, false, false, true));

        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }

    private float getBoggedHealth(int spellLevel, LivingEntity caster) {
        return 50 + spellLevel * 4;
    }

    private float getBoggedDamage(int spellLevel, LivingEntity caster) {
        return getSpellPower(spellLevel, caster);
    }


}
