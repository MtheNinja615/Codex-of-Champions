package net.mtheninja615.codex_of_champions.Registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EntityRegistry {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, CodexOfChampions.MODID);

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

  //public static final DeferredHolder<EntityType<?>, EntityType<SummonedBogged>> SUMMONED_BOGGED =
  //          ENTITIES.register("summoned_bogged", () -> EntityType.Builder.<SummonedBogged>of(SummonedBogged::new, MobCategory.CREATURE)
//
      //              .sized(1.4F, 1.4F)
    //                .clientTrackingRange(64)
  //                  .build(ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "summoned_bogged").toString()));
}
