package net.mtheninja615.codex_of_champions.Registries;

import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import net.mtheninja615.codex_of_champions.item.curios.FloweringPendantCurio;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.mtheninja615.codex_of_champions.CodexOfChampions;

import java.util.function.Supplier;

public class ItemRegistries {



    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CodexOfChampions.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    /***
     * Curios
     */

    // Flowering Pendant
    public static final Supplier<CurioBaseItem> FLOWERING_PENDANT = ITEMS.register("flowering_pendant", FloweringPendantCurio::new);
}
