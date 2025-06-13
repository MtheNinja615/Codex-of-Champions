package net.mtheninja615.codex_of_champions.spells.fire;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.entity.spells.firebolt.FireboltProjectile;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.mtheninja615.codex_of_champions.CodexOfChampions;

import java.util.List;
@AutoSpellConfig
public class FireCluster extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "fire_cluster");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2)),
                Component.translatable("ui.irons_spellbooks.projectile_count", getCount(spellLevel)));
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.EPIC)
            .setSchoolResource(SchoolRegistry.FIRE_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(45)
            .build();

    public FireCluster() {
        this.manaCostPerLevel = 20;
        this.baseSpellPower = 8;
        this.spellPowerPerLevel = 4;
        this.castTime = 0;
        this.baseManaCost = 45;
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
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        int count = getCount(spellLevel);
        float damage = getDamage(spellLevel, entity);
        int degreesPerBolt = 360 / count;
        var raycast = Utils.raycastForEntity(world, entity, 32, true);
        for (int i = 0; i < count; i++) {
            FireboltProjectile bolt = new FireboltProjectile(world, entity);
            int rotation = degreesPerBolt * i - (degreesPerBolt);
            bolt.setDamage(damage);
            Vec3 spawn = entity.getEyePosition().add(new Vec3(0, 1.5, 0).zRot(rotation * Mth.DEG_TO_RAD).xRot(-entity.getXRot() * Mth.DEG_TO_RAD).yRot(-entity.getYRot() * Mth.DEG_TO_RAD));bolt.moveTo(spawn);
            bolt.shoot(raycast.getLocation().subtract(spawn).normalize());
            world.addFreshEntity(bolt);
        }
        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }


    private int getCount(int spellLevel) {
        return spellLevel;
    }

    private float getDamage(int spellLevel, LivingEntity caster) {
        return getSpellPower(spellLevel, caster) * .25f;
    }

}