package net.mtheninja615.codex_of_champions.Registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CodexOfChampions.MODID);

    public static final Supplier<CreativeModeTab> CODEX_OF_CHAMPIONS = CREATIVE_MODE_TAB.register("codex_of_champions",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemRegistries.FLOWERING_PENDANT.get()))
                    .title(Component.translatable("creativetab.codex_of_champions.codex_of_champions"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ItemRegistries.FLOWERING_PENDANT.get());


                    })
            .build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
