package net.mtheninja615.codex_of_champions.entities.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.resources.ResourceLocation;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.item.armor.BloodSoulArmorItem;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class BloodSoulArmorModel extends DefaultedEntityGeoModel<BloodSoulArmorItem> {
    public BloodSoulArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, ""));
    }

   // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(BloodSoulArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "geo/blood_soul_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BloodSoulArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "textures/models/armor/blood_soul_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BloodSoulArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
