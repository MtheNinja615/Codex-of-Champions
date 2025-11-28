package net.mtheninja615.codex_of_champions.item.weapons;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.effect.ImmolateEffect;
import io.redspace.ironsspellbooks.item.UniqueItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import io.redspace.ironsspellbooks.util.MinecraftInstanceHelper;
import net.acetheeldritchking.aces_spell_utils.utils.ASRarities;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class DeathfireGreatswordItem extends MagicSwordItem implements UniqueItem {
    public static final int COOLDOWN = 15 * 20;

    public DeathfireGreatswordItem() {
        super(
                COCExtendedWeaponTiers.DEATHFIRE_GREATSWORD,
                ItemPropertiesHelper.equipment(1).fireResistant().rarity(ASRarities.ACCURSED_RARITY_PROXY.getValue()).attributes(ExtendedSwordItem.createAttributes(COCExtendedWeaponTiers.DEATHFIRE_GREATSWORD)),
                SpellDataRegistryHolder.of(
                        new SpellDataRegistryHolder(SpellRegistry.FLAMING_STRIKE_SPELL, 1)
                )
        );
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        if (Screen.hasShiftDown())
        {
            tooltipComponents.add(
                    Component.translatable(
                            "tooltip.irons_spellbooks.passive_ability",
                            Component.literal(Utils.timeFromTicks(COOLDOWN, 1)).withStyle(ChatFormatting.LIGHT_PURPLE)
                    ).withStyle(ChatFormatting.DARK_PURPLE)
            );
            tooltipComponents.add(Component.literal(" ").append(Component.translatable(this.getDescriptionId() + ".desc")).withStyle(ChatFormatting.YELLOW));
        } else
        {
            tooltipComponents.add(Component.translatable("item.codex_of_champions.more_details").withStyle(ChatFormatting.GRAY));
        }
    }
}
