package net.mtheninja615.codex_of_champions.spells.ender;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.entity.spells.comet.Comet;
import io.redspace.ironsspellbooks.entity.spells.firebolt.FireboltProjectile;
import io.redspace.ironsspellbooks.entity.spells.magic_missile.MagicMissileProjectile;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.mtheninja615.codex_of_champions.CodexOfChampions;

import java.util.List;

@AutoSpellConfig
public class MissileSalvo extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "missile_salvo");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2)));
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.UNCOMMON)
            .setSchoolResource(SchoolRegistry.ENDER_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(40)
            .build();

    public MissileSalvo() {
        this.manaCostPerLevel = 1;
        this.baseSpellPower = 10;
        this.spellPowerPerLevel = 5;
        this.castTime = 60 - 5;
        this.baseManaCost = 5;
    }

    @Override
    public CastType getCastType() {
        return CastType.CONTINUOUS;
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
        Comet bolt = new Comet(world, entity);
        bolt.setPos(entity.position().add(0.75, entity.getEyeHeight() - bolt.getBoundingBox().getYsize() * .5f, 0));
        bolt.shoot(entity.getLookAngle());
        bolt.setDamage(getDamage(spellLevel, entity));
        world.addFreshEntity(bolt);
        Comet bolt1 = new Comet(world, entity);
        bolt1.setPos(entity.position().add(-0.75, entity.getEyeHeight() - bolt1.getBoundingBox().getYsize() * .5f, 0));
        bolt1.shoot(entity.getLookAngle());
        bolt1.setDamage(getDamage(spellLevel, entity));
        world.addFreshEntity(bolt1);
        Comet bolt2 = new Comet(world, entity);
        bolt2.setPos(entity.position().add(0, entity.getEyeHeight() - bolt2.getBoundingBox().getYsize() * .5f, 0));
        bolt2.shoot(entity.getLookAngle());
        bolt2.setDamage(getDamage(spellLevel, entity));
        world.addFreshEntity(bolt2);
        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }


    private int getCount(int spellLevel) {
        return spellLevel;
    }

    private float getDamage(int spellLevel, LivingEntity caster) {
        return getSpellPower(spellLevel, caster) * .25f;
    }

}
