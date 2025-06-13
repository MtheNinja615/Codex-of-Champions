package net.mtheninja615.codex_of_champions.spells.nature;

import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import io.redspace.ironsspellbooks.util.Log;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.network.particles.PetalStepParticlesPacket;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.List;
import java.util.Optional;
@AutoSpellConfig
public class PetalStep  extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "petal_step");

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.EPIC)
            .setSchoolResource(SchoolRegistry.NATURE_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(3)
            .build();

    public PetalStep() {
        this.baseSpellPower = 10;
        this.spellPowerPerLevel = 10;
        this.baseManaCost = 20;
        this.manaCostPerLevel = 2;
        this.castTime = 0;
    }

    @Override
    public DefaultConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public CastType getCastType() {
        return CastType.INSTANT;
    }

    @Override
    public ResourceLocation getSpellResource() {
        return spellId;
    }

    @Override
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.empty();
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(SoundEvents.CHERRY_LEAVES_FALL);
    }

    @Override
    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        if (Log.SPELL_DEBUG) {
            IronsSpellbooks.LOGGER.debug("PetalStep.onCast isClient:{}, entity:{}, pmd:{}", level.isClientSide, entity, playerMagicData);
        }
        var teleportData = (TeleportData) playerMagicData.getAdditionalCastData();

        Vec3 dest = null;
        if (teleportData != null) {
            var potentialTarget = teleportData.getTeleportTargetPosition();
            if (potentialTarget != null) {
                dest = potentialTarget;
            }
        }

        if (dest == null) {
            dest = findTeleportLocation(level, entity, getDistance(spellLevel, entity));
        }

        PacketDistributor.sendToPlayersTrackingEntityAndSelf(entity, new PetalStepParticlesPacket(entity.position(), dest));

        if (entity.isPassenger()) {
            entity.stopRiding();
        }
        Utils.handleSpellTeleport(this, entity, dest);
        entity.resetFallDistance();

        playerMagicData.resetAdditionalCastData();

//        level.playSound(null, dest.x, dest.y, dest.z, getCastFinishSound().get(), SoundSource.NEUTRAL, 1f, 1f);
        entity.playSound(getCastFinishSound().get(), 2.0f, 1.0f);

        //Getaway Effect

        entity.addEffect(new MobEffectInstance(ALObjects.MobEffects.MOVEMENT_SPEED, 150, 1, false, false, true));
        entity.addEffect(new MobEffectInstance(MobEffectRegistry.TRUE_INVISIBILITY, 75, 0, false, false, true));
        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }

    public static Vec3 findTeleportLocation(Level level, LivingEntity entity, float maxDistance) {
        if (Log.SPELL_DEBUG) {
            IronsSpellbooks.LOGGER.debug("TeleportSpell.findTeleportLocation isClient:{}, entity:{}", level.isClientSide, entity);
        }

        var blockHitResult = Utils.getTargetBlock(level, entity, ClipContext.Fluid.NONE, maxDistance);
        return solveTeleportDestination(level, entity, blockHitResult.getBlockPos(), blockHitResult.getLocation());
    }

    public static Vec3 solveTeleportDestination(Level level, LivingEntity entity, BlockPos blockPos, Vec3 vec3) {
        BlockPos pos = blockPos;
        Vec3 bbOffset = entity.getForward().normalize().multiply(entity.getBbWidth() / 3, 0, entity.getBbHeight() / 3);
        Vec3 bbImpact = vec3.subtract(bbOffset);

        double ledgeY = level.clip(new ClipContext(Vec3.atBottomCenterOf(pos).add(0, 3, 0), Vec3.atBottomCenterOf(pos), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, CollisionContext.empty())).getLocation().y;
        boolean isAir = level.getBlockState(new BlockPos(new Vec3i(pos.getX(), (int) ledgeY, pos.getZ())).above()).isAir();
        boolean los = level.clip(new ClipContext(bbImpact, bbImpact.add(0, ledgeY - pos.getY(), 0), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getType() == HitResult.Type.MISS;

        if (isAir && los && Math.abs(ledgeY - pos.getY()) <= 3) {
            return new Vec3(pos.getX() + .5, ledgeY + 0.001, pos.getZ() + .5);
        }
        return level.clip(new ClipContext(bbImpact, bbImpact.add(0, -entity.getBbHeight(), 0), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getLocation().add(0, 0.001, 0);
    }

    public static void particleCloud(Level level, Vec3 pos) {
        if (level.isClientSide) {
            double width = 0.5;
            float height = 1;
            for (int i = 0; i < 55; i++) {
                double x = pos.x + Utils.random.nextDouble() * width * 2 - width;
                double y = pos.y + height + Utils.random.nextDouble() * height * 1.2 * 2 - height * 1.2;
                double z = pos.z + Utils.random.nextDouble() * width * 2 - width;
                double dx = Utils.random.nextDouble() * .1 * (Utils.random.nextBoolean() ? 1 : -1);
                double dy = Utils.random.nextDouble() * .1 * (Utils.random.nextBoolean() ? 1 : -1);
                double dz = Utils.random.nextDouble() * .1 * (Utils.random.nextBoolean() ? 1 : -1);
                level.addParticle(ParticleTypes.CHERRY_LEAVES, true, x, y, z, dx, dy, dz);
            }
        }
    }

    private float getDistance(int spellLevel, LivingEntity sourceEntity) {
        return (float) (Utils.softCapFormula(getEntityPowerMultiplier(sourceEntity)) * getSpellPower(spellLevel, null));
    }

    public static class TeleportData implements ICastData {
        private Vec3 teleportTargetPosition;

        public TeleportData(Vec3 teleportTargetPosition) {
            this.teleportTargetPosition = teleportTargetPosition;
        }

        public void setTeleportTargetPosition(Vec3 targetPosition) {
            this.teleportTargetPosition = targetPosition;
        }

        public Vec3 getTeleportTargetPosition() {
            return this.teleportTargetPosition;
        }

        @Override
        public void reset() {
            //Nothing needed here for teleport
        }
    }

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.distance", Utils.stringTruncation(getDistance(spellLevel, caster), 1)));
    }

    @Override
    public AnimationHolder getCastStartAnimation() {
        return AnimationHolder.none();
    }

}