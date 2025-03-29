package net.mtheninja615.codex_of_champions.Registries;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.mtheninja615.codex_of_champions.item.curios.FloweringPendantCurio;
import net.mtheninja615.codex_of_champions.item.curios.TrueFirewardRingCurio;
import net.mtheninja615.codex_of_champions.item.weapons.COCExtendedWeaponTiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
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
    // True Fireward Ring
    public static final Supplier<CurioBaseItem> TRUEFIREWARDRING = ITEMS.register("true_fireward_ring", TrueFirewardRingCurio::new);


    /***
     * Weapons
     */
    //Crystal Claymore
    public static final DeferredHolder<Item, Item> CRYSTAL_CLAYMORE = ITEMS.register("crystal_claymore", () ->
            new MagicSwordItem(COCExtendedWeaponTiers.CRYSTAL_CLAYMORE, ItemPropertiesHelper.equipment().rarity(Rarity.UNCOMMON).attributes(ExtendedSwordItem.createAttributes(COCExtendedWeaponTiers.CRYSTAL_CLAYMORE)),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.CHAIN_CREEPER_SPELL, 8))));
}
