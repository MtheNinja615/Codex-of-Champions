package net.mtheninja615.codex_of_champions.setup;

import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.Registries.EntityRegistry;
import net.mtheninja615.codex_of_champions.entities.mobs.SummonedBogged;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = CodexOfChampions.MODID, bus = EventBusSubscriber.Bus.MOD)
public class CommonSetup {

    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(EntityRegistry.SUMMONED_BOGGED.get(), SummonedBogged.createAttributes().build());
    }
    }