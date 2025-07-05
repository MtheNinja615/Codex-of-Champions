package net.mtheninja615.codex_of_champions.Registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.entities.mobs.AlianaBoss;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EntityRegistry {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, CodexOfChampions.MODID);

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

    // The Ascended One
    public static final DeferredHolder<EntityType<?>, EntityType<AlianaBoss>> ALIANA =
            ENTITIES.register("aliana", () -> EntityType.Builder.<AlianaBoss>of(AlianaBoss::new, MobCategory.MONSTER)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .build(ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "aliana").toString())
            );
}
