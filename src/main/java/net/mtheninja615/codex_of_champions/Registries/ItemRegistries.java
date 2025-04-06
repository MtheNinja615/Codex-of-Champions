package net.mtheninja615.codex_of_champions.Registries;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.mtheninja615.codex_of_champions.item.armor.BloodSoulArmorItem;
import net.mtheninja615.codex_of_champions.item.armor.WardenHunterArmorItem;
import net.mtheninja615.codex_of_champions.item.curios.FloweringPendantCurio;
import net.mtheninja615.codex_of_champions.item.curios.TrueFirewardRingCurio;
import net.mtheninja615.codex_of_champions.item.weapons.COCExtendedWeaponTiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.mtheninja615.codex_of_champions.CodexOfChampions;

import java.util.function.Supplier;

public class ItemRegistries {



    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CodexOfChampions.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final DeferredItem<Item> SOUL_FORGED_INGOT = ITEMS.register("soul_forged_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ARCANE_UPGRADE_TEMPLATE = ITEMS.register("arcane_upgrade_template",
            () -> new Item(new Item.Properties()));
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
            new MagicSwordItem(COCExtendedWeaponTiers.CRYSTAL_CLAYMORE, ItemPropertiesHelper.equipment().rarity(Rarity.RARE).attributes(ExtendedSwordItem.createAttributes(COCExtendedWeaponTiers.CRYSTAL_CLAYMORE)),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.CHAIN_CREEPER_SPELL, 8))));
    //Deathfire Greatsword
    public static final DeferredHolder<Item, Item> DEATHFIRE_GREATSWORD = ITEMS.register("deathfire_greatsword", () ->
            new MagicSwordItem(COCExtendedWeaponTiers.DEATHFIRE_GREATSWORD, ItemPropertiesHelper.equipment().rarity(Rarity.RARE).attributes(ExtendedSwordItem.createAttributes(COCExtendedWeaponTiers.DEATHFIRE_GREATSWORD)),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.FLAMING_STRIKE_SPELL, 10))));
    //Soulfire Greatsword
    public static final DeferredHolder<Item, Item> SOULFIRE_GREATSWORD = ITEMS.register("soulfire_greatsword", () ->
            new MagicSwordItem(COCExtendedWeaponTiers.SOULFIRE_GREATSWORD, ItemPropertiesHelper.equipment().rarity(Rarity.RARE).attributes(ExtendedSwordItem.createAttributes(COCExtendedWeaponTiers.SOULFIRE_GREATSWORD)),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.FLAMING_STRIKE_SPELL, 7))));

    /***
     * Armor
     */
    //Blood Soul Armor
    public static final DeferredHolder<Item, Item> BLOOD_SOUL_MASK = ITEMS.register("blood_soul_mask", () -> new BloodSoulArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredHolder<Item, Item> BLOOD_SOUL_ROBES = ITEMS.register("blood_soul_robes", () -> new BloodSoulArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredHolder<Item, Item> BLOOD_SOUL_LEGGINGS = ITEMS.register("blood_soul_leggings", () -> new BloodSoulArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredHolder<Item, Item> BLOOD_SOUL_BOOTS = ITEMS.register("blood_soul_boots", () -> new BloodSoulArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(19))));
    //Warden Hunter Armor
    public static final DeferredHolder<Item, Item> WARDEN_HUNTER_HELMET = ITEMS.register("warden_hunter_helmet", () -> new WardenHunterArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredHolder<Item, Item> WARDEN_HUNTER_ARMOR = ITEMS.register("warden_hunter_armor", () -> new WardenHunterArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredHolder<Item, Item> WARDEN_HUNTER_LEGGINGS = ITEMS.register("warden_hunter_leggings", () -> new WardenHunterArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredHolder<Item, Item> WARDEN_HUNTER_BOOTS = ITEMS.register("warden_hunter_boots", () -> new WardenHunterArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(19))));


    /***
     * Spellbooks
     */

// Codex Of Champions
    public static final DeferredHolder<Item, Item> CODEX_SPELLBOOK = ITEMS.register("codex_of_champions_spellbook", () ->
            new SpellBook(12).withSpellbookAttributes(
                    new AttributeContainer(AttributeRegistry.SPELL_POWER, .15F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    new AttributeContainer(AttributeRegistry.MAX_MANA, 500, AttributeModifier.Operation.ADD_VALUE),
                    new AttributeContainer(AttributeRegistry.CASTING_MOVESPEED, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            ));


}
