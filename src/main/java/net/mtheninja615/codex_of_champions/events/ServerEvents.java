package net.mtheninja615.codex_of_champions.events;

import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.entity.spells.firebolt.FireboltProjectile;
import io.redspace.ironsspellbooks.particle.BlastwaveParticleOptions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.mtheninja615.codex_of_champions.Registries.ItemRegistries;
import net.mtheninja615.codex_of_champions.item.weapons.DeathfireGreatswordItem;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class ServerEvents {
    // Deathfire Greatsword
    //Credits to Ace for da code
            if (mainhandItem.getItem() instanceof DeathfireGreatswordItem && (!(livingEntity instanceof Player player) || !player.getCooldowns().isOnCooldown(ItemRegistries.DEATHFIRE_GREATSWORD.get())))
    {


        //DiscerningTheEldritch.LOGGER.debug("Max HP: " + MAX_HEALTH);
        //DiscerningTheEldritch.LOGGER.debug("Base HP: " + baseHealth);
        //DiscerningTheEldritch.LOGGER.debug("Percent: " + percent);


            MagicManager.spawnParticles(target.level(), new BlastwaveParticleOptions(SchoolRegistry.FIRE.get().getTargetingColor(), 1.5f), target.getX(), target.getY() + 0.165F, target.getZ(), 1, 0, 0, 0, 0, true);

            for (int i = 0; i < 5; i++)
            {
                FireboltProjectile bolt = new FireboltProjectile(livingEntity.level(), livingEntity);

                Vec3 origin = target.getEyePosition().add(target.getForward().normalize().scale(1.2F)).subtract(0, 0.15,0);
                bolt.setPos(origin.subtract(0, bolt.getBbHeight() + 1, 0));
                Vec3 vec3 = target.getForward().add(0, 0.05, 0).normalize();
                bolt.shoot(vec3.scale(0.5F), 0.4F);
                bolt.setDamage(5);
                bolt.setHomingTarget(target);

                livingEntity.level().addFreshEntity(bolt);
            }

            if (livingEntity instanceof Player player)
            {
                player.getCooldowns().addCooldown(ItemRegistries.DEATHFIRE_GREATSWORD.get(), DeathfireGreatswordItem.COOLDOWN);
            }
        }
    }

