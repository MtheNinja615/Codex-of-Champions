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

    public static final Supplier<CreativeModeTab> CODEX_OF_CHAMPIONS = CREATIVE_MODE_TAB.register("codex_of_champions_crafting",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemRegistries.GAIA_FRUIT.get()))
                    .title(Component.translatable("creativetab.codex_of_champions.crafting"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //School Crafting Materials
                        output.accept(ItemRegistries.DIVINE_STAR.get());
                        output.accept(ItemRegistries.WITHER_BONE.get());
                        output.accept(ItemRegistries.GAIA_FRUIT.get());
                        output.accept(ItemRegistries.ETERNAL_ICE.get());
                        output.accept(ItemRegistries.BLAZE_CORE.get());
                        output.accept(ItemRegistries.ELECTRIFIED_BRONZE.get());
                        output.accept(ItemRegistries.REINFORCED_ENDER_EYE.get());
                        output.accept(ItemRegistries.SCULK_RIB.get());
                        output.accept(ItemRegistries.VEXED_PAGE.get());
                        //Misc Crafting Materials
                        output.accept(ItemRegistries.ARCANE_UPGRADE_TEMPLATE.get());
                        output.accept(ItemRegistries.SOUL_FORGED_INGOT.get());





                    })
            .build());
    public static final Supplier<CreativeModeTab> CODEX_OF_CHAMPIONS_GEAR = CREATIVE_MODE_TAB.register("codex_of_champions_gear",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemRegistries.CODEX_OF_CHAMPIONS.get()))
                    .title(Component.translatable("creativetab.codex_of_champions.gear"))
                    .displayItems((itemDisplayParameters, output) -> {
                    //Weapons
                        output.accept(ItemRegistries.TRIBLADE.get());
                        output.accept(ItemRegistries.BRUTIS.get());
                        output.accept(ItemRegistries.EXCALIBUR.get());
                        output.accept(ItemRegistries.ANGELIC_ANNHILATOR.get());
                        output.accept(ItemRegistries.CRYSTAL_CLAYMORE.get());
                        output.accept(ItemRegistries.SOULFIRE_GREATSWORD.get());
                        output.accept(ItemRegistries.DEATHFIRE_GREATSWORD.get());
                        output.accept(ItemRegistries.SCULK_SLICER.get());
                        output.accept(ItemRegistries.WORLDBREAKER.get());
                        output.accept(ItemRegistries.THUNDERBRINGER.get());
                    //Staves
                        output.accept(ItemRegistries.NAMELESS_STAFF.get());
                    //Curios
                        output.accept(ItemRegistries.FLOWERING_PENDANT.get());
                        output.accept(ItemRegistries.TRUEFIREWARDRING.get());
                        output.accept(ItemRegistries.AzureAnlaceCurio.get());
                        output.accept(ItemRegistries.CHAOSORBCURIO.get());
                        output.accept(ItemRegistries.VAMPIRICCHARMCURIO.get());
                        output.accept(ItemRegistries.ROYALROSECURIO.get());
                        output.accept(ItemRegistries.ROYALANLACECURIO.get());
                      //  output.accept(ItemRegistries.VITALICSHEATHCURIO.get());

                        //Spellbooks
                        output.accept(ItemRegistries.ARUROA_SPELLBOOK.get());
                        output.accept(ItemRegistries.CODEX_OF_CHAMPIONS.get());

                    //Armor
                        output.accept(ItemRegistries.BLOOD_SOUL_MASK.get());
                        output.accept(ItemRegistries.BLOOD_SOUL_ROBES.get());
                        output.accept(ItemRegistries.BLOOD_SOUL_LEGGINGS.get());
                        output.accept(ItemRegistries.BLOOD_SOUL_BOOTS.get());

                        output.accept(ItemRegistries.BLOSSOM_CLOAK_HELMET.get());
                        output.accept(ItemRegistries.BLOSSOM_CLOAK_ARMOR.get());
                        output.accept(ItemRegistries.BLOSSOM_CLOAK_LEGGINGS.get());
                        output.accept(ItemRegistries.BLOSSOM_CLOAK_BOOTS.get());
                    })
                    .build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
