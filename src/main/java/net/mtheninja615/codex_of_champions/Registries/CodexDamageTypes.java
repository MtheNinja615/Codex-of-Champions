package net.mtheninja615.codex_of_champions.Registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.mtheninja615.codex_of_champions.CodexOfChampions;

public class CodexDamageTypes {
    public static ResourceKey<DamageType> register(String name) {
        return ResourceKey.create(
                Registries.DAMAGE_TYPE,
                ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, name).toString())
        );
    }

    public static final ResourceKey<DamageType> MAGNETIC_MAGIC = register("magnetic");

    public static void bootstrap(BootstrapContext<DamageType> context)
    {
        context.register(MAGNETIC_MAGIC, new DamageType(MAGNETIC_MAGIC.location().getPath(), DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0F));
    }
}
