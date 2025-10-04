package net.mtheninja615.codex_of_champions.Registries;

import io.redspace.ironsspellbooks.api.attribute.MagicRangedAttribute;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.mtheninja615.codex_of_champions.CodexOfChampions;

@EventBusSubscriber(modid = CodexOfChampions.MODID)
public class CodexAttributeRegistry {
    private static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(Registries.ATTRIBUTE, CodexOfChampions.MODID);

    public static final DeferredHolder<Attribute, Attribute> MAGNETIC_MAGIC_RESIST = registerResistanceAttribute("magnetic");

    public static final DeferredHolder<Attribute, Attribute> MAGNETIC_MAGIC_POWER = registerPowerAttribute("magnetic");

    public static void register(IEventBus eventBus)
    {
        ATTRIBUTES.register(eventBus);
    }

    @SubscribeEvent
    public static void modifyEntityAttributes(EntityAttributeModificationEvent event)
    {
        event.getTypes().forEach(entityType ->
                ATTRIBUTES.getEntries().forEach(
                        attributeDeferredHolder -> event.add(entityType, attributeDeferredHolder
                        )));
    }

    // ;_;
    private static DeferredHolder<Attribute, Attribute> registerResistanceAttribute(String id)
    {
        return ATTRIBUTES.register(id + "_magic_resist", () ->
                (new MagicRangedAttribute("attribute.codex_of_champions." + id + "_magic_resist",
                        1.0D, 0, 10).setSyncable(true)));
    }

    private static DeferredHolder<Attribute, Attribute> registerPowerAttribute(String id)
    {
        return ATTRIBUTES.register(id + "_spell_power", () ->
                (new MagicRangedAttribute("attribute.codex_of_champions." + id + "_spell_power",
                        1.0D, 0, 10).setSyncable(true)));
    }
}
