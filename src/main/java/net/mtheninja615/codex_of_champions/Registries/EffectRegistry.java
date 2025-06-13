package net.mtheninja615.codex_of_champions.Registries;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.effects.PersonaBond;
import net.mtheninja615.codex_of_champions.effects.SummonBoggedEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static io.redspace.ironsspellbooks.registries.MobEffectRegistry.MOB_EFFECT_DEFERRED_REGISTER;

public class EffectRegistry {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, CodexOfChampions.MODID);
    //Persona Bond
    public static final Holder<MobEffect> PersonaBond = MOB_EFFECTS.register("persona_bond",
            () -> new PersonaBond(MobEffectCategory.BENEFICIAL, 0x657832)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED,
                            ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "persona_bond"), 0.15f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE,
                            ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "persona_bond"), 0.15f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
    public static final DeferredHolder<MobEffect, MobEffect> SUMMONED_BOGGED = MOB_EFFECT_DEFERRED_REGISTER.register("summoned_bogged",
            () -> new SummonBoggedEffect(MobEffectCategory.BENEFICIAL, 1238137));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }

}
