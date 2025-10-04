package net.mtheninja615.codex_of_champions.item.curios;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.acetheeldritchking.aces_spell_utils.utils.ASRarities;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

public class ChaosOrbCurio extends CurioBaseItem {
    public ChaosOrbCurio() {
        super(ItemPropertiesHelper.equipment().stacksTo(1).fireResistant() );
    }
    //uhhhhhhhhhhhhhhh idk what this does I just looked at the DTE Github
    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> attr = LinkedHashMultimap.create();
        //The attributes of the curio
        attr.put(AttributeRegistry.ELDRITCH_SPELL_POWER, new AttributeModifier(id, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        attr.put(ALObjects.Attributes.ARMOR_PIERCE, new AttributeModifier(id, 5, AttributeModifier.Operation.ADD_VALUE));
        return attr;
    }
}
