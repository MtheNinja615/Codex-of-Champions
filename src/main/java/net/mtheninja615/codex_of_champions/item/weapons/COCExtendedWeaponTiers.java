package net.mtheninja615.codex_of_champions.item.weapons;

import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.mtheninja615.codex_of_champions.Registries.ItemRegistries;
import java.util.function.Supplier;

public class COCExtendedWeaponTiers implements Tier, IronsWeaponTier {
    //  Crystal Claymore
    public static COCExtendedWeaponTiers CRYSTAL_CLAYMORE = new COCExtendedWeaponTiers(12000, 12, -3.5F, 10, BlockTags.INCORRECT_FOR_NETHERITE_TOOL, () -> Ingredient.of(ItemRegistries.VEXED_PAGE.get()),
            new AttributeContainer(AttributeRegistry.EVOCATION_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
    //  Soulfire Greatsword
    public static COCExtendedWeaponTiers SOULFIRE_GREATSWORD = new COCExtendedWeaponTiers(12000, 10, -3.0F, 10, BlockTags.INCORRECT_FOR_NETHERITE_TOOL, () -> Ingredient.of(ItemRegistries.SOUL_FORGED_INGOT.get()),
            new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.OVERHEAL, 0.125, AttributeModifier.Operation.ADD_VALUE)
            );

    //  Deathfire Greatsword
    public static COCExtendedWeaponTiers DEATHFIRE_GREATSWORD = new COCExtendedWeaponTiers(16000, 11, -3.2F, 10, BlockTags.INCORRECT_FOR_NETHERITE_TOOL, () -> Ingredient.of(ItemRegistries.SOUL_FORGED_INGOT.get()),
            new AttributeContainer(AttributeRegistry.ELDRITCH_MAGIC_RESIST, 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, 0.20, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.OVERHEAL, 0.25, AttributeModifier.Operation.ADD_VALUE)
    );
//Angelic Annhilator
    public static COCExtendedWeaponTiers ANGELIC_ANNHILATOR = new COCExtendedWeaponTiers(16000, 8, -2.5F, 10, BlockTags.INCORRECT_FOR_NETHERITE_TOOL, () -> Ingredient.of(ItemRegistries.DIVINE_STAR.get()),
            new AttributeContainer(AttributeRegistry.HOLY_SPELL_POWER, 0.20, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.HEALING_RECEIVED, 0.20, AttributeModifier.Operation.ADD_VALUE)
    );
//Exaclibur
    public static COCExtendedWeaponTiers EXCALIBUR = new COCExtendedWeaponTiers(16000, 7, -2.5F, 10, BlockTags.INCORRECT_FOR_NETHERITE_TOOL, () -> Ingredient.of(ItemRegistries.DIVINE_STAR.get()),
            new AttributeContainer(AttributeRegistry.HOLY_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );
    //Thunderbringer
    public static COCExtendedWeaponTiers THUNDERBRINGER = new COCExtendedWeaponTiers(16000, 10, -3.2F, 10, BlockTags.INCORRECT_FOR_NETHERITE_TOOL, () -> Ingredient.of(ItemRegistries.DIVINE_STAR.get()),
            new AttributeContainer(AttributeRegistry.LIGHTNING_SPELL_POWER, 0.20, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(Attributes.MOVEMENT_SPEED, 0.02, AttributeModifier.Operation.ADD_VALUE)
    );
    //Brutis
    public static COCExtendedWeaponTiers BRUTIS = new COCExtendedWeaponTiers(16000, 6, -2.5F, 10, BlockTags.INCORRECT_FOR_NETHERITE_TOOL, () -> Ingredient.of(ItemRegistries.WITHER_BONE.get()),
            new AttributeContainer(AttributeRegistry.BLOOD_SPELL_POWER, 0.20, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(Attributes.SNEAKING_SPEED, 20, AttributeModifier.Operation.ADD_VALUE)
    );
    //World Breaker
    public static COCExtendedWeaponTiers WORLD_BREAKER = new COCExtendedWeaponTiers(16000, 12, -3.5F, 10, BlockTags.INCORRECT_FOR_NETHERITE_TOOL, () -> Ingredient.of(ItemRegistries.GAIA_FRUIT.get()),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.20, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.OVERHEAL, 0.2, AttributeModifier.Operation.ADD_VALUE)
    );
    //Sculk Slicer
    public static COCExtendedWeaponTiers SCULK_SLICER = new COCExtendedWeaponTiers(16000, 6, -2.5F, 10, BlockTags.INCORRECT_FOR_NETHERITE_TOOL, () -> Ingredient.of(ItemRegistries.SCULK_RIB.get()),
            new AttributeContainer(AttributeRegistry.ELDRITCH_SPELL_POWER, 0.20, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.CURRENT_HP_DAMAGE, 0.05, AttributeModifier.Operation.ADD_VALUE)
    );
    //Monosword
    public static COCExtendedWeaponTiers MONOSWORD = new COCExtendedWeaponTiers(16000, 9, -2.5F, 10, BlockTags.INCORRECT_FOR_NETHERITE_TOOL, () -> Ingredient.of(ItemRegistry.DIVINE_SOULSHARD.get()),
            new AttributeContainer(AttributeRegistry.MAX_MANA, 250, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, 0.25, AttributeModifier.Operation.ADD_VALUE)
    );

    //private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final TagKey<Block> incorrectBlocksForDrops;
    private final Supplier<Ingredient> repairIngredient;
    private final AttributeContainer[] attributeContainers;

    private COCExtendedWeaponTiers(int uses, float damage, float speed, int enchantmentValue, TagKey<Block> incorrectBlocksForDrops, Supplier<Ingredient> repairIngredient, AttributeContainer... attributes) {
        //this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.repairIngredient = repairIngredient;
        this.attributeContainers = attributes;
    }

    @Override
    public AttributeContainer[] getAdditionalAttributes() {
        return this.attributeContainers;
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return damage;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return incorrectBlocksForDrops;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}