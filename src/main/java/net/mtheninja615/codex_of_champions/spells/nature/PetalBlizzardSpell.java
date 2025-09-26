package net.mtheninja615.codex_of_champions.spells.nature;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.entities.spells.petal_blizzard.PetalBlizzard;

import java.util.List;
import java.util.Optional;
@AutoSpellConfig
public class PetalBlizzardSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "petal_blizzard");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2))
        );
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.EPIC)
            .setSchoolResource(SchoolRegistry.NATURE_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(40)
            .build();

    public PetalBlizzardSpell() {
        this.manaCostPerLevel = 15;
        this.baseSpellPower = 1;
        this.spellPowerPerLevel = 1;
        this.castTime = 30;
        this.baseManaCost = 100;
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(SoundRegistry.NATURE_CAST.get());
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
        return Optional.of(SoundRegistry.NATURE_CAST.get());
    }

    @Override
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        Vec3 origin = entity.getEyePosition();

        PetalBlizzard petalblizzard = new PetalBlizzard(world, entity);

        petalblizzard.setDamage(getDamage(spellLevel, entity));

        petalblizzard.setPos(origin.add(entity.getForward()).subtract(0, petalblizzard.getBbHeight() - 7.5, 0));
        petalblizzard.shoot(entity.getLookAngle());

        world.addFreshEntity(petalblizzard);
        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }


    public float getDamage(int spellLevel, LivingEntity caster) {
        if (caster == null) {
            return (float) getSpellPower(spellLevel, null) * 4;
        }

        double naturePower = caster.getAttributeValue(AttributeRegistry.NATURE_SPELL_POWER);

        double generalPower = caster.getAttributeValue(AttributeRegistry.SPELL_POWER);

        float damage = 8 + 30 * (float)(naturePower + generalPower);
        return damage;
    }

    public int getRadius(int spellLevel, LivingEntity caster) {
        return 2 + (int) getSpellPower(spellLevel, caster);
    }
}
