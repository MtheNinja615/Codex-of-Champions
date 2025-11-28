package net.mtheninja615.codex_of_champions.item.spellbooks;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.entity.spells.comet.Comet;
import io.redspace.ironsspellbooks.entity.spells.icicle.IcicleProjectile;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.spells.ice.RayOfFrostSpell;
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
public class NorthernLightsSpellbook extends PassiveAbilitySpellbook {
    public static final int COOLDOWN = 5 * 20;

    public NorthernLightsSpellbook()
    {
        super(12, ItemPropertiesHelper.equipment().fireResistant().stacksTo(1).rarity(ASRarities.GLACIAL_RARITY_PROXY.getValue()));
        withSpellbookAttributes(
                new AttributeContainer(AttributeRegistry.MAX_MANA, 350, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.ICE_SPELL_POWER, 0.25F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
        );
    }

    @Override
    protected int getCooldownTicks() {
        return COOLDOWN;
    }

    @SubscribeEvent
    public static void handleAbility(LivingIncomingDamageEvent event)
    {
        var sheath = ((NorthernLightsSpellbook) ItemRegistries.NORTHERN_LIGHTS_SPELLBOOK.get());
        Entity attacker = event.getSource().getEntity();

        if (attacker instanceof ServerPlayer player)
        {
            if (sheath.isEquippedBy(player))
            {
                if (sheath.tryProcCooldown(player))
                {
                    var victim = event.getEntity();

                    IcicleProjectile icicle = new IcicleProjectile(player.level(), player);
                    icicle.setDamage(5);
                    icicle.setPos(victim.getX(), victim.getY() + 7, victim.getZ());
                    player.level().addFreshEntity(icicle);
                    var trajectory = new Vec3(0.05F, -0.85F, 0).normalize();
                    icicle.shoot(trajectory);

                }
            }
        }
    }
}
