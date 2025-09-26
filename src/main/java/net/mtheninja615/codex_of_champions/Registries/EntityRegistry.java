package net.mtheninja615.codex_of_champions.Registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.entities.mobs.bosses.AlianaBoss;
import net.mtheninja615.codex_of_champions.entities.mobs.spellcastingmobs.PaladinEntity;
import net.mtheninja615.codex_of_champions.entities.spells.petal_blizzard.PetalBlizzard;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EntityRegistry {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, CodexOfChampions.MODID);

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

    /*** Aliana (currently ynlimplimented will add later)
    public static final DeferredHolder<EntityType<?>, EntityType<AlianaBoss>> ALIANA =
            ENTITIES.register("aliana", () -> EntityType.Builder.<AlianaBoss>of(AlianaBoss::new, MobCategory.MONSTER)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .build(ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "aliana").toString())
*/

    //Paladin
    public static final DeferredHolder<EntityType<?>, EntityType<PaladinEntity>> PALADIN =
            ENTITIES.register("paladin", () -> EntityType.Builder.of(PaladinEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .build(ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "paladin").toString()));

    // Petal Blizzard
    public static final DeferredHolder<EntityType<?>, EntityType<PetalBlizzard>> PETAL_BLIZZARD =
            ENTITIES.register("petal_blizzard", () -> EntityType.Builder.<PetalBlizzard>of(PetalBlizzard::new, MobCategory.MISC)
                    .sized(3f, 8.5f)
                    .clientTrackingRange(4)
                    .build(ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "petal_blizzard").toString())
            );


}
