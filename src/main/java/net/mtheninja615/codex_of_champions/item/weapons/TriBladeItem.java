package net.mtheninja615.codex_of_champions.item.weapons;


import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.item.UniqueItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.item.Rarity;

public class TriBladeItem extends MagicSwordItem implements UniqueItem {
    public TriBladeItem() {
        super(
                COCExtendedWeaponTiers.TRISWORD,
                ItemPropertiesHelper.equipment(1).fireResistant().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(COCExtendedWeaponTiers.TRISWORD)),
                SpellDataRegistryHolder.of(
                        new SpellDataRegistryHolder(SpellRegistry.ICE_SPIKES_SPELL, 12),
                        new SpellDataRegistryHolder(SpellRegistry.POISON_BREATH_SPELL, 12),
                        new SpellDataRegistryHolder(SpellRegistry.FIRE_ARROW_SPELL, 12))

        );
    }
}