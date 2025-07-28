package net.mtheninja615.codex_of_champions.entities.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.resources.ResourceLocation;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.item.armor.BloodSoulArmorItem;
import net.mtheninja615.codex_of_champions.item.armor.CrusaderArmorItem;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class CrusaderArmorModel extends DefaultedEntityGeoModel<CrusaderArmorItem> {
    public CrusaderArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, ""));
    }

   // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(CrusaderArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "geo/crusader_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CrusaderArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "textures/models/armor/crusader_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CrusaderArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
