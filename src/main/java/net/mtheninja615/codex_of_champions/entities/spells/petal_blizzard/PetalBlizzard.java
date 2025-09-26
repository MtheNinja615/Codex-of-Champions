package net.mtheninja615.codex_of_champions.entities.spells.petal_blizzard;

import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.mtheninja615.codex_of_champions.Registries.EntityRegistry;
import net.mtheninja615.codex_of_champions.Registries.SpellRegistries;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Optional;

public class PetalBlizzard extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public PetalBlizzard(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setNoGravity(true);
    }

    public PetalBlizzard(Level level, LivingEntity shooter)
    {
        this(EntityRegistry.PETAL_BLIZZARD.get(), level);
        setOwner(shooter);
    }

    @Override
    public void travel() {
        this.setPos(this.position().add(this.getDeltaMovement()));
        if (!this.isNoGravity())
        {
            Vec3 vec3 = this.getDeltaMovement();
            this.setDeltaMovement(vec3.x, vec3.y - 0.05000000074505806, vec3.z);
        }
    }

    public void setRotation(float x, float y) {
        this.setXRot(x);
        this.xRotO = x;
        this.setYRot(y);
        this.yRotO = y;
    }

    @Override
    public void tick() {
        // Save previous rotation for interpolation
        this.xRotO = this.getXRot();
        this.yRotO = this.getYRot();

        Vec3 deltaMovement = getDeltaMovement();
        double distance = deltaMovement.horizontalDistance();



        float newYRot = (float) (Mth.atan2(deltaMovement.x, deltaMovement.z) * (180F / Math.PI));
        float newXRot = (float) (Mth.atan2(deltaMovement.y, distance) * (180F / Math.PI));

        float maxDelta = 20f; // max degrees per tick
        this.setYRot(Mth.approachDegrees(this.yRotO, newYRot, maxDelta));
        this.setXRot(Mth.approachDegrees(this.xRotO, newXRot, maxDelta));

        super.tick();
    }

    @Override
    public void trailParticles() {
    }

    @Override
    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(this.level(), ParticleTypes.CHERRY_LEAVES, x, y, z, 90, 1, 5, 1, 1, true);
    }

    @Override
    public float getSpeed() {
        return 1.4f;
    }

    @Override
    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.of(SoundRegistry.GUST_CAST);
    }

    @Override
    protected void doImpactSound(Holder<SoundEvent> sound) {
        level().playSound(null, getX(), getY(), getZ(), sound, SoundSource.NEUTRAL, 1.5f, 1.0f);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        var target = pResult.getEntity();

        DamageSources.applyDamage(target, damage,
                SpellRegistries.PETAL_BLIZZARD.get().getDamageSource(this, getOwner()));

        level().playSound(null, getX(), getY(), getZ(),
                SoundRegistry.SUNBEAM_IMPACT.get(), SoundSource.NEUTRAL, 2.0f, 1.0f);


    }
    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);


        level().playSound(null, getX(), getY(), getZ(),
                SoundRegistry.GUST_CAST.get(), SoundSource.NEUTRAL, 2.0f, 1.0f);

        discard();
    }

    //ANIMATION
    private final RawAnimation idle = RawAnimation.begin().thenLoop("animation.petal_blizzard.idle");

    private PlayState predicate(software.bernie.geckolib.animation.AnimationState event) {
        event.getController().setAnimation(idle);
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<GeoAnimatable>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

}
