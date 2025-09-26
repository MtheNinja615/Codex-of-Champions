package net.mtheninja615.codex_of_champions.item.curios;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.entity.spells.root.RootEntity;
import net.acetheeldritchking.aces_spell_utils.items.curios.SheathCurioItem;
import net.acetheeldritchking.aces_spell_utils.utils.ASRarities;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.mtheninja615.codex_of_champions.Registries.ItemRegistries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import top.theillusivec4.curios.api.SlotContext;

@EventBusSubscriber
public class VitalicSheathCurio extends SheathCurioItem {
    public static final int COOLDOWN = 5 * 20;

    public VitalicSheathCurio() {
        super(new Properties().stacksTo(1).rarity(ASRarities.VERDANT_RARITY_PROXY.getValue()).fireResistant(), null);
    }

    @Override
    protected int getCooldownTicks() {
        return COOLDOWN;
    }

    @SubscribeEvent
    public static void handleAbility(LivingDamageEvent.Pre event)
    {
        var sheath = ((VitalicSheathCurio) ItemRegistries.VITALICSHEATHCURIO.get());
        Entity attacker = event.getSource().getEntity();

        if (attacker instanceof ServerPlayer player)
        {
            if (sheath.isEquippedBy(player))
            {
                if (sheath.tryProcCooldown(player))
                {
                    var victim = event.getEntity();

                    RootEntity rootEntity = new RootEntity(player.level(), player);
                    rootEntity.setDuration(125);
                    rootEntity.moveTo(victim.position());

                    player.level().addFreshEntity(rootEntity);
                    victim.startRiding(rootEntity, true);
                }
            }
        }
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> attr = LinkedHashMultimap.create();
        attr.put(AttributeRegistry.NATURE_SPELL_POWER, new AttributeModifier(id, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        attr.put(AttributeRegistry.CAST_TIME_REDUCTION, new AttributeModifier(id, 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        attr.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(id, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

        return attr;
    }
}