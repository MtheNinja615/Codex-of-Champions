package net.mtheninja615.codex_of_champions.Registries;

import io.redspace.ironsspellbooks.api.spells.SchoolType;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static io.redspace.ironsspellbooks.api.registry.SchoolRegistry.SCHOOL_REGISTRY_KEY;

public class CodexSchoolRegistry  {
    private static final DeferredRegister<SchoolType> CODEX_SCHOOLS = DeferredRegister.create(SCHOOL_REGISTRY_KEY, CodexOfChampions.MODID);

    public static void register(IEventBus eventBus)
    {
        CODEX_SCHOOLS.register(eventBus);
    }

    private static Supplier<SchoolType> registerSchool(SchoolType type)
    {
        return CODEX_SCHOOLS.register(type.getId().getPath(), () -> type);
    }

    public static final ResourceLocation MAGNETIC_RESOURCE = CodexOfChampions.id("magnetic");

    public static final Supplier<SchoolType> ASTRAL = registerSchool(new SchoolType
            (
                    MAGNETIC_RESOURCE,
                    CodexTags.MAGNETIC_FOCUS,
                    Component.translatable("school.codex_of_champions.magnetic").withStyle(Style.EMPTY.withColor(0x2c2fb0)),
                    CodexAttributeRegistry.MAGNETIC_MAGIC_POWER,
                    CodexAttributeRegistry.MAGNETIC_MAGIC_RESIST,
                    SoundRegistry.LIGHTNING_LANCE_CAST,
                    CodexDamageTypes.MAGNETIC_MAGIC
            ));
}