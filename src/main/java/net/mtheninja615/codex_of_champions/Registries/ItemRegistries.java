package net.mtheninja615.codex_of_champions.Registries;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.compat.Curios;
import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.mtheninja615.codex_of_champions.item.armor.*;
import net.mtheninja615.codex_of_champions.item.curios.*;
import net.mtheninja615.codex_of_champions.item.staffs.COCStaffTier;
import net.mtheninja615.codex_of_champions.item.weapons.COCExtendedWeaponTiers;
import net.mtheninja615.codex_of_champions.item.weapons.TriBladeItem;
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
    /***
     * Crafting Stuff
     */
    public static final DeferredItem<Item> SOUL_FORGED_INGOT = ITEMS.register("soul_forged_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ARCANE_UPGRADE_TEMPLATE = ITEMS.register("arcane_upgrade_template",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BLAZE_CORE = ITEMS.register("blaze_core",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DIVINE_STAR = ITEMS.register("divine_star",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ELECTRIFIED_BRONZE = ITEMS.register("electrified_bronze",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ETERNAL_ICE = ITEMS.register("eternal_ice",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GAIA_FRUIT = ITEMS.register("gaia_fruit",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> REINFORCED_ENDER_EYE = ITEMS.register("reinforced_ender_eye",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SCULK_RIB = ITEMS.register("sculk_rib",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> VEXED_PAGE = ITEMS.register("vexed_page",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> WITHER_BONE = ITEMS.register("wither_bone",
            () -> new Item(new Item.Properties()));
    /***
     * Curios
     */

    // Flowering Pendant
    public static final Supplier<CurioBaseItem> FLOWERING_PENDANT = ITEMS.register("flowering_pendant", FloweringPendantCurio::new);
    // True Fireward Ring
    public static final Supplier<CurioBaseItem> TRUEFIREWARDRING = ITEMS.register("true_fireward_ring", TrueFirewardRingCurio::new);
    // Vampiric Charm
    public static final Supplier<CurioBaseItem> VAMPIRICCHARMCURIO = ITEMS.register("vampiric_charm", VampiricCharmCurio::new);
    // Chaos Orb
    public static final Supplier<CurioBaseItem> CHAOSORBCURIO = ITEMS.register("chaos_orb", ChaosOrbCurio::new);
    // Azure Anlace
    public static final Supplier<CurioBaseItem> AzureAnlaceCurio = ITEMS.register("azure_anlace", AzureAnlaceCurio::new);
    // Royal Rose
    public static final Supplier<CurioBaseItem> ROYALROSECURIO = ITEMS.register("royal_rose", RoyalRoseCurio::new);
    //Royal Anlace
    public static final Supplier<CurioBaseItem> ROYALANLACECURIO = ITEMS.register("royal_anlace", RoyalAnlaceCurio::new);
    // Frostbourne Sheath
    public static final Supplier<CurioBaseItem> VITALICSHEATHCURIO = ITEMS.register("vitalic_sheath", VitalicSheathCurio::new);
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

    //Angelic Annhilator
    public static final DeferredHolder<Item, Item> ANGELIC_ANNHILATOR = ITEMS.register("angelic_annhilator", () ->
            new MagicSwordItem(COCExtendedWeaponTiers.ANGELIC_ANNHILATOR, ItemPropertiesHelper.equipment().rarity(Rarity.RARE).attributes(ExtendedSwordItem.createAttributes(COCExtendedWeaponTiers.ANGELIC_ANNHILATOR)),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.DIVINE_SMITE_SPELL, 7))));

    //Excalibur
    public static final DeferredHolder<Item, Item> EXCALIBUR = ITEMS.register("excalibur", () ->
            new MagicSwordItem(COCExtendedWeaponTiers.EXCALIBUR, ItemPropertiesHelper.equipment().rarity(Rarity.RARE).attributes(ExtendedSwordItem.createAttributes(COCExtendedWeaponTiers.EXCALIBUR)),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.DIVINE_SMITE_SPELL, 6))));
    //Thunderbringer
    public static final DeferredHolder<Item, Item> THUNDERBRINGER = ITEMS.register("thunderbringer", () ->
            new MagicSwordItem(COCExtendedWeaponTiers.THUNDERBRINGER, ItemPropertiesHelper.equipment().rarity(Rarity.RARE).attributes(ExtendedSwordItem.createAttributes(COCExtendedWeaponTiers.THUNDERBRINGER)),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.THUNDERSTORM_SPELL, 9))));
    //Brutis
    public static final DeferredHolder<Item, Item> BRUTIS = ITEMS.register("brutis", () ->
            new MagicSwordItem(COCExtendedWeaponTiers.BRUTIS, ItemPropertiesHelper.equipment().rarity(Rarity.RARE).attributes(ExtendedSwordItem.createAttributes(COCExtendedWeaponTiers.BRUTIS)),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.SACRIFICE_SPELL, 7))));
    //Worldbreaker
    public static final DeferredHolder<Item, Item> WORLDBREAKER = ITEMS.register("worldbreaker", () ->
            new MagicSwordItem(COCExtendedWeaponTiers.WORLD_BREAKER, ItemPropertiesHelper.equipment().rarity(Rarity.RARE).attributes(ExtendedSwordItem.createAttributes(COCExtendedWeaponTiers.WORLD_BREAKER)),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.EARTHQUAKE_SPELL, 11))));
    //Worldbreaker
    public static final DeferredHolder<Item, Item> SCULK_SLICER = ITEMS.register("sculk_slicer", () ->
            new MagicSwordItem(COCExtendedWeaponTiers.SCULK_SLICER, ItemPropertiesHelper.equipment().rarity(Rarity.RARE).attributes(ExtendedSwordItem.createAttributes(COCExtendedWeaponTiers.SCULK_SLICER)),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.SONIC_BOOM_SPELL, 4))));
    //Monosword
    public static final DeferredHolder<Item, Item> MONOSWORD = ITEMS.register("monosword", () ->
            new MagicSwordItem(COCExtendedWeaponTiers.MONOSWORD, ItemPropertiesHelper.equipment().rarity(Rarity.RARE).attributes(ExtendedSwordItem.createAttributes(COCExtendedWeaponTiers.MONOSWORD)),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistries.PERSONA_BOND, 1))));
    //Plasmasword
    public static final DeferredHolder<Item, Item> PLASMASWORD = ITEMS.register("plasmasword", () ->
            new MagicSwordItem(COCExtendedWeaponTiers.PLASMASWORD, ItemPropertiesHelper.equipment().rarity(Rarity.RARE).attributes(ExtendedSwordItem.createAttributes(COCExtendedWeaponTiers.PLASMASWORD)),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistries.PERSONA_BOND, 1))));
    //Tri-Sword
    public static final DeferredHolder<Item, Item> TRIBLADE = ITEMS.register("tri_blade", TriBladeItem::new);
    /***
     * Armor
     */
    //Blood Soul Armor
    public static final DeferredHolder<Item, Item> BLOOD_SOUL_MASK = ITEMS.register("blood_soul_mask", () -> new BloodSoulArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(400))));
    public static final DeferredHolder<Item, Item> BLOOD_SOUL_ROBES = ITEMS.register("blood_soul_robes", () -> new BloodSoulArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(400))));
    public static final DeferredHolder<Item, Item> BLOOD_SOUL_LEGGINGS = ITEMS.register("blood_soul_leggings", () -> new BloodSoulArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(400))));
    public static final DeferredHolder<Item, Item> BLOOD_SOUL_BOOTS = ITEMS.register("blood_soul_boots", () -> new BloodSoulArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(400))));
    //Warden Hunter Armor
    public static final DeferredHolder<Item, Item> WARDEN_HUNTER_HELMET = ITEMS.register("warden_hunter_helmet", () -> new WardenHunterArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(400))));
    public static final DeferredHolder<Item, Item> WARDEN_HUNTER_ARMOR = ITEMS.register("warden_hunter_armor", () -> new WardenHunterArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(400))));
    public static final DeferredHolder<Item, Item> WARDEN_HUNTER_LEGGINGS = ITEMS.register("warden_hunter_leggings", () -> new WardenHunterArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(400))));
    public static final DeferredHolder<Item, Item> WARDEN_HUNTER_BOOTS = ITEMS.register("warden_hunter_boots", () -> new WardenHunterArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(400))));
    //Blossom Cloak Armor
    public static final DeferredHolder<Item, Item> BLOSSOM_CLOAK_HELMET = ITEMS.register("blossom_cloak_hood", () -> new BlossomCloakArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(400))));
    public static final DeferredHolder<Item, Item> BLOSSOM_CLOAK_ARMOR = ITEMS.register("blossom_cloak_robes", () -> new BlossomCloakArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(400))));
    public static final DeferredHolder<Item, Item> BLOSSOM_CLOAK_LEGGINGS = ITEMS.register("blossom_cloak_leggings", () -> new BlossomCloakArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(400))));
    public static final DeferredHolder<Item, Item> BLOSSOM_CLOAK_BOOTS = ITEMS.register("blossom_cloak_boots", () -> new BlossomCloakArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(400))));
    //Lightning Herald Armor
    public static final DeferredHolder<Item, Item> LIGTNING_HERALD_HELMET = ITEMS.register("ligtning_herald_helmet", () -> new LightningHeraldArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(400))));
    public static final DeferredHolder<Item, Item> LIGTNING_HERALD_ARMOR = ITEMS.register("ligtning_herald_chestplate", () -> new LightningHeraldArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(400))));
    public static final DeferredHolder<Item, Item> LIGTNING_HERALD_LEGGINGS = ITEMS.register("ligtning_herald_leggings", () -> new LightningHeraldArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(400))));
    public static final DeferredHolder<Item, Item> LIGTNING_HERALD_BOOTS = ITEMS.register("ligtning_herald_boots", () -> new LightningHeraldArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(400))));
    //Lightning Herald Armor
    public static final DeferredHolder<Item, Item> FROSTBITE_HELMET = ITEMS.register("frostbite_helmet", () -> new FrostbiteArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(400))));
    public static final DeferredHolder<Item, Item> FROSTBITE_ARMOR = ITEMS.register("frostbite_chestplate", () -> new FrostbiteArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(400))));
    public static final DeferredHolder<Item, Item> FROSTBITE_LEGGINGS = ITEMS.register("frostbite_leggings", () -> new FrostbiteArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(400))));
    public static final DeferredHolder<Item, Item> FROSTBITE_BOOTS = ITEMS.register("frostbite_boots", () -> new FrostbiteArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(400))));
    //Crusader Armor
    public static final DeferredHolder<Item, Item> CRUSADER_HELMET = ITEMS.register("crusader_helmet", () -> new CrusaderArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(400))));
    public static final DeferredHolder<Item, Item> CRUSADER_ARMOR = ITEMS.register("crusader_chestplate", () -> new CrusaderArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(400))));
    public static final DeferredHolder<Item, Item> CRUSADER_LEGGINGS = ITEMS.register("crusader_leggings", () -> new CrusaderArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(400))));
    public static final DeferredHolder<Item, Item> CRUSADER_BOOTS = ITEMS.register("crusader_boots", () -> new CrusaderArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(400))));
    //Monstrosity Armor
    public static final DeferredHolder<Item, Item> MONSTROSITY_HELMET = ITEMS.register("monstrosity_helmet", () -> new MonstrosityArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(400))));
    public static final DeferredHolder<Item, Item> MONSTROSITY_ARMOR = ITEMS.register("monstrosity_chestplate", () -> new MonstrosityArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(400))));
    public static final DeferredHolder<Item, Item> MONSTROSITY_LEGGINGS = ITEMS.register("monstrosity_leggings", () -> new MonstrosityArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(400))));
    public static final DeferredHolder<Item, Item> MONSTROSITY_BOOTS = ITEMS.register("monstrosity_boots", () -> new MonstrosityArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(400))));
    //Monstrosity Armor
    public static final DeferredHolder<Item, Item> GALA_HELMET = ITEMS.register("gala_hood", () -> new GalaArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(400))));
    public static final DeferredHolder<Item, Item> GALA_ARMOR = ITEMS.register("gala_robes", () -> new GalaArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(400))));
    public static final DeferredHolder<Item, Item> GALA_LEGGINGS = ITEMS.register("gala_leggings", () -> new GalaArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(400))));
    public static final DeferredHolder<Item, Item> GALA_BOOTS = ITEMS.register("gala_boots", () -> new GalaArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(400))));


    //Sakura Blossom Cloak Armor
    public static final DeferredHolder<Item, Item> SAKURA_BLOSSOM_CLOAK_HELMET = ITEMS.register("sakura_blossom_cloak_hood", () -> new SakuraBlossomCloakArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(400))));
    public static final DeferredHolder<Item, Item> SAKURA_BLOSSOM_CLOAK_ARMOR = ITEMS.register("sakura_blossom_cloak_robes", () -> new SakuraBlossomCloakArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(400))));
    public static final DeferredHolder<Item, Item> SAKURA_BLOSSOM_CLOAK_LEGGINGS = ITEMS.register("sakura_blossom_cloak_leggings", () -> new SakuraBlossomCloakArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(400))));
    public static final DeferredHolder<Item, Item> SAKURA_BLOSSOM_CLOAK_BOOTS = ITEMS.register("sakura_blossom_cloak_boots", () -> new SakuraBlossomCloakArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(400))));
    /***
     * Spellbooks
     */

// Codex Of Champions
    public static final DeferredHolder<Item, Item> CODEX_SPELLBOOK = ITEMS.register("codex_of_champions_spellbook", () ->
            new SpellBook(12).withSpellbookAttributes(
                    new AttributeContainer(AttributeRegistry.SPELL_POWER, .15F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    new AttributeContainer(AttributeRegistry.MAX_MANA, 4000, AttributeModifier.Operation.ADD_VALUE),
                    new AttributeContainer(AttributeRegistry.CASTING_MOVESPEED, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            ));
    // Aruroa Tome
    public static final DeferredHolder<Item, Item> ARUROA_SPELLBOOK = ITEMS.register("aurora_spellbook", () ->
            new SpellBook(10).withSpellbookAttributes(
                    new AttributeContainer(AttributeRegistry.ICE_SPELL_POWER, .10F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    new AttributeContainer(AttributeRegistry.MAX_MANA, 200, AttributeModifier.Operation.ADD_VALUE)
            ));
    /***
     * Staffs
     */
// Nameless Staff (Made for Ender)
    public static final DeferredHolder<Item, Item> NAMELESS_STAFF = ITEMS.register("nameless_staff", () -> new StaffItem(ItemPropertiesHelper.equipment(1).fireResistant().rarity(Rarity.RARE).attributes(ExtendedSwordItem.createAttributes(COCStaffTier.NAMELESS_STAFF))));


}
