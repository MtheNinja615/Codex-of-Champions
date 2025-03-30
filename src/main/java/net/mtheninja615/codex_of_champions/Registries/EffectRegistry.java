package net.mtheninja615.codex_of_champions.Registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.effects.CrystalisedEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


    public class EffectRegistry {
        public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, CodexOfChampions.MODID);

        public static final DeferredHolder<MobEffect, MobEffect> ABYSSAL_PREDATOR_EFFECT =
                MOB_EFFECTS.register("crystalised_effect", CrystalisedEffect::new);



        public static void register(IEventBus eventBus)
        {
            MOB_EFFECTS.register(eventBus);
        }
}
