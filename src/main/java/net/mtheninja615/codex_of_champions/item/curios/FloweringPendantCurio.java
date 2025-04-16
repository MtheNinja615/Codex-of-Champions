package net.mtheninja615.codex_of_champions.item.curios;
//imports required
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.compat.Curios;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.item.curios.SimpleDescriptiveCurio;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

//Class Setup
    public class FloweringPendantCurio extends CurioBaseItem {
        public FloweringPendantCurio() {
            super(ItemPropertiesHelper.equipment().stacksTo(1).fireResistant() );
        }
//uhhhhhhhhhhhhhhh idk what this does I just looked at the DTE Github
            @Override
            public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
                Multimap<Holder<Attribute>, AttributeModifier> attr = LinkedHashMultimap.create();
                //The attributes of the curio
                attr.put(AttributeRegistry.NATURE_SPELL_POWER, new AttributeModifier(id, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
                attr.put(ALObjects.Attributes.OVERHEAL, new AttributeModifier(id, 0.15, AttributeModifier.Operation.ADD_VALUE));
            return attr;
         }
        }
