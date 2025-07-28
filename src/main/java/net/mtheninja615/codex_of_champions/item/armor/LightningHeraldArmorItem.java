package net.mtheninja615.codex_of_champions.item.armor;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.mtheninja615.codex_of_champions.entities.armor.LightningHeraldArmorModel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class LightningHeraldArmorItem extends ImbuableModArmorItem {
    public LightningHeraldArmorItem(Type type, Properties settings) {
        // Add in your armor tier + additional attributes for your item
        super(ModArmorMaterials.SCHOOL_TWO, type, settings,
                new AttributeContainer(AttributeRegistry.MAX_MANA, 200.0, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.LIGHTNING_SPELL_POWER, .15, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.CASTING_MOVESPEED, .05, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, .10, AttributeModifier.Operation.ADD_VALUE)
        );
    }

    // Just supply the armor model here; you don't have to worry about making a new renderer
    // ISS already has a custom renderer used for armor models
    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new LightningHeraldArmorModel());
    }
}
