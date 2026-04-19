package net.mtheninja615.codex_of_champions.events;

import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.entity.spells.acid_orb.AcidOrb;
import io.redspace.ironsspellbooks.entity.spells.fire_arrow.FireArrowProjectile;
import io.redspace.ironsspellbooks.entity.spells.magic_arrow.MagicArrowProjectile;
import io.redspace.ironsspellbooks.entity.spells.magic_missile.MagicMissileProjectile;
import io.redspace.ironsspellbooks.entity.spells.poison_cloud.PoisonSplash;
import io.redspace.ironsspellbooks.particle.BlastwaveParticleOptions;
import io.redspace.ironsspellbooks.particle.ShockwaveParticleOptions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.mtheninja615.codex_of_champions.Registries.ItemRegistries;
import net.mtheninja615.codex_of_champions.entities.spells.petal_blizzard.PetalBlizzard;
import net.mtheninja615.codex_of_champions.item.weapons.DeathfireGreatswordItem;
import net.mtheninja615.codex_of_champions.item.weapons.EnderKhopeshItem;
import net.mtheninja615.codex_of_champions.item.weapons.HawthornEdgeItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.jar.Attributes;

@EventBusSubscriber
public class ServerEvents {


    @SubscribeEvent
    public static void livingDamageEvent(LivingDamageEvent.Post event) {
        var sourceEntity = event.getSource().getEntity();
        var target = event.getEntity();


        if (sourceEntity instanceof LivingEntity livingEntity) {
            ItemStack mainhandItem = livingEntity.getMainHandItem();

            // Deathfire Greatsword
            //Credits to Ace for code
            if (mainhandItem.getItem() instanceof DeathfireGreatswordItem && (!(livingEntity instanceof Player player) || !player.getCooldowns().isOnCooldown(ItemRegistries.DEATHFIRE_GREATSWORD.get()))) {


                MagicManager.spawnParticles(target.level(), new BlastwaveParticleOptions(SchoolRegistry.FIRE.get().getTargetingColor(), 1.5f), target.getX(), target.getY() + 0.165F, target.getZ(), 1, 0, 0, 0, 0, true);


                for (int i = 0; i < 1; i++) {
                    FireArrowProjectile bolt = new FireArrowProjectile(livingEntity.level(), livingEntity);

                    Vec3 origin = sourceEntity.getEyePosition().add(target.getForward().normalize().scale(0.9F)).add(0, 3, 0);
                    bolt.setPos(origin.subtract(0, bolt.getBbHeight() - 2, 0));
                    Vec3 vec3 = target.getForward().add(0, -180, 0).normalize();
                    bolt.shoot(vec3.scale(0.5F));
                    bolt.setDamage(20);
                    bolt.setHomingTarget(target);


                    livingEntity.level().addFreshEntity(bolt);
                }

                if (livingEntity instanceof Player player) {
                    player.getCooldowns().addCooldown(ItemRegistries.DEATHFIRE_GREATSWORD.get(), DeathfireGreatswordItem.COOLDOWN);
                }


            }
            // Hawthorn Edge
            if (mainhandItem.getItem() instanceof HawthornEdgeItem && (!(livingEntity instanceof Player player) || !player.getCooldowns().isOnCooldown(ItemRegistries.HAWTHORN_EDGE.get()))) {


                MagicManager.spawnParticles(target.level(), new ShockwaveParticleOptions(SchoolRegistry.NATURE.get().getTargetingColor(), 1.5f, false), target.getX(), target.getY() + 0.165F, target.getZ(), 1, 0, 0, 0, 0, true);


                for (int i = 0; i < 1; i++) {
                    AcidOrb bolt = new AcidOrb(livingEntity.level(), livingEntity);

                    Vec3 origin = sourceEntity.getEyePosition().add(target.getForward().normalize().scale(0.9F)).add(0, 3, 0);
                    bolt.setPos(origin.subtract(0, bolt.getBbHeight() - 2, 0));
                    Vec3 vec3 = target.getForward().add(0, -180, 0).normalize();
                    bolt.shoot(vec3.scale(0.1F));
                    bolt.setDamage(20);
                    bolt.setHomingTarget(target);


                    livingEntity.level().addFreshEntity(bolt);
                }

                if (livingEntity instanceof Player player) {
                    player.getCooldowns().addCooldown(ItemRegistries.HAWTHORN_EDGE.get(), DeathfireGreatswordItem.COOLDOWN);
                }


            }
            /***
            // Ender Khopesh
            if (mainhandItem.getItem() instanceof EnderKhopeshItem && (!(livingEntity instanceof Player player) || !player.getCooldowns().isOnCooldown(ItemRegistries.ENDER_KHOPESH.get()))) {


                MagicManager.spawnParticles(target.level(), new BlastwaveParticleOptions(SchoolRegistry.ENDER.get().getTargetingColor(), 2f), target.getX(), target.getY() + 0.165F, target.getZ(), 1, 0, 0, 0, 0, true);


                for (int i = 0; i < 1; i++) {
                    MagicArrowProjectile bolt = new MagicArrowProjectile(livingEntity.level(), livingEntity);

                    Vec3 origin = sourceEntity.getEyePosition().add(target.getForward().normalize().scale(0.9F)).add(0, 3, 0);
                    bolt.setPos(origin.subtract(0, bolt.getBbHeight() - 2, 0));
                    Vec3 vec3 = target.getForward().add(0, -180, 0).normalize();
                    bolt.shoot(vec3.scale(0.5F));
                    bolt.setDamage(10);
                    bolt.setHomingTarget(target);


                    livingEntity.level().addFreshEntity(bolt);
                }

                if (livingEntity instanceof Player player) {
                    player.getCooldowns().addCooldown(ItemRegistries.ENDER_KHOPESH.get(), EnderKhopeshItem.COOLDOWN);
                }
            }
             ***/
            // Ender Khopesh Pt 2.
            if (mainhandItem.getItem() instanceof EnderKhopeshItem && (!(livingEntity instanceof Player player) || !player.getCooldowns().isOnCooldown(ItemRegistries.ENDER_KHOPESH.get()))) {


                MagicManager.spawnParticles(target.level(), new BlastwaveParticleOptions(SchoolRegistry.ENDER.get().getTargetingColor(), 1.5f), target.getX(), target.getY() + 0.165F, target.getZ(), 1, 0, 0, 0, 0, true);


                for (int i = 1; i < 4; i++) {
                    MagicMissileProjectile bolt = new MagicMissileProjectile(livingEntity.level(), livingEntity);
                    int count = 4;
                    int degreesPerBolt = 360 / count;
                    int rotation = degreesPerBolt * i - (degreesPerBolt);

                    Vec3 origin = target.getEyePosition().add(target.getForward().normalize().scale(0.9F)).add(0, 3, 0);
                    bolt.setPos(origin.subtract(0, bolt.getBbHeight() - 2, 0));
                    Vec3 vec3 = target.getForward().add(rotation, 0, 0).normalize();
                    bolt.shoot(vec3.scale(0.5F));
                    bolt.setDamage(5);
                    bolt.setHomingTarget(target);


                    livingEntity.level().addFreshEntity(bolt);
                }

                if (livingEntity instanceof Player player) {
                    player.getCooldowns().addCooldown(ItemRegistries.ENDER_KHOPESH.get(), EnderKhopeshItem.COOLDOWN);
                }
            }
        }
    }
}

