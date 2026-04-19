package net.mtheninja615.codex_of_champions.item.spellbooks;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.entity.spells.ChainLightning;
import io.redspace.ironsspellbooks.entity.spells.comet.Comet;
import io.redspace.ironsspellbooks.entity.spells.fire_arrow.FireArrowProjectile;
import io.redspace.ironsspellbooks.entity.spells.icicle.IcicleProjectile;
import io.redspace.ironsspellbooks.entity.spells.root.RootEntity;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.acetheeldritchking.aces_spell_utils.items.curios.PassiveAbilitySpellbook;
import net.acetheeldritchking.aces_spell_utils.utils.ASRarities;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.phys.Vec3;
import net.mtheninja615.codex_of_champions.Registries.ItemRegistries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber
public class CodexOfChampionsSpellbook extends PassiveAbilitySpellbook {
    public static final int COOLDOWN = 15 * 20;

    public CodexOfChampionsSpellbook()
    {
        super(12, ItemPropertiesHelper.equipment().fireResistant().stacksTo(1).rarity(ASRarities.ARID_RARITY_PROXY.getValue()));
        withSpellbookAttributes(
                new AttributeContainer(AttributeRegistry.MAX_MANA, 300, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, 0.50F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
        );
    }

    @Override
    protected int getCooldownTicks() {
        return COOLDOWN;
    }

    @SubscribeEvent
    public static void handleAbility(LivingIncomingDamageEvent event)
    {
        var sheath = ((CodexOfChampionsSpellbook) ItemRegistries.CODEX_OF_CHAMPIONS.get());
        Entity attacker = event.getSource().getEntity();

        if (attacker instanceof ServerPlayer player)
        {
            if (sheath.isEquippedBy(player))
            {
                if (sheath.tryProcCooldown(player))
                {
                    var victim = event.getEntity();

                    //Comet
                    Comet comet = new Comet(player.level(), player);
                    comet.setDamage(5);
                    comet.setCanRicochet(true);
                    comet.setPos(victim.getX() + 1, victim.getY() + 3, victim.getZ());
                    var trajectory = new Vec3(3F, -0.85F, 0).normalize();
                    comet.shoot(trajectory, 0.045F);
                    comet.setExplosionRadius(4.5F);
                    comet.setHomingTarget(victim);
                    player.level().addFreshEntity(comet);

                    //Icicle
                    IcicleProjectile icicle = new IcicleProjectile(player.level(), player);
                    icicle.setDamage(5);
                    icicle.setCanRicochet(true);
                    icicle.setPos(victim.getX() - 1, victim.getY() + 1, victim.getZ());
                    player.level().addFreshEntity(icicle);
                    icicle.setHomingTarget(victim);
                    trajectory = new Vec3(3F, -0.85F, 2F).normalize();
                    icicle.shoot(trajectory);


                    //Root
                    RootEntity rootEntity = new RootEntity(player.level(), player);
                    rootEntity.setDuration(300);
                    rootEntity.moveTo(victim.position());
                    player.level().addFreshEntity(rootEntity);
                    victim.startRiding(rootEntity, true);

                    //Chain Lightning
                    ChainLightning chainLightning = new ChainLightning(player.level(), player, victim);
                    chainLightning.setDamage(8);
                    chainLightning.range = 10;
                    chainLightning.maxConnections = 7;
                    player.level().addFreshEntity(chainLightning);

                    //Fire Arrow
                    FireArrowProjectile firearrow = new FireArrowProjectile(player.level(), player);
                    firearrow.setDamage(5);
                    firearrow.setCanRicochet(true);
                    firearrow.setPos(victim.getX() + 1, victim.getY() + 1, victim.getZ());
                    player.level().addFreshEntity(firearrow);
                    firearrow.setHomingTarget(victim);
                    trajectory = new Vec3(-5F, -0.85F, 0).normalize();
                    firearrow.shoot(trajectory);

                }
            }
        }
    }
}