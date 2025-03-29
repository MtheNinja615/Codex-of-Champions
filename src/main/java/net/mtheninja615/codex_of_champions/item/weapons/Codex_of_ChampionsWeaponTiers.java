package net.mtheninja615.codex_of_champions.item.weapons;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public class Codex_of_ChampionsWeaponTiers implements Tier, IronsWeaponTier {

    //Crystal Claymore
    public static Codex_of_ChampionsWeaponTiers CRYSTAL_CLAYMORE = new Codex_of_ChampionsWeaponTiers(2600, 7, -3.0F, 10, BlockTags.INCORRECT_FOR_NETHERITE_TOOL, () -> Ingredient.of(ItemRegistry.MITHRIL_INGOT.get()),
            new AttributeContainer(AttributeRegistry.EVOCATION_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
//needed stuff
    @Override
    public AttributeContainer[] getAdditionalAttributes() {
        return new AttributeContainer[0];
    }

    @Override
    public int getUses() {
        return 0;
    }

    @Override
    public float getSpeed() {
        return 0;
    }

    @Override
    public float getAttackDamageBonus() {
        return 0;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return null;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}