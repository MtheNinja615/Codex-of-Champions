package net.mtheninja615.codex_of_champions.entities.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.resources.ResourceLocation;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.item.armor.FrostbiteArmorItem;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class FrostbiteArmorModel extends DefaultedEntityGeoModel<FrostbiteArmorItem> {
    public FrostbiteArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(FrostbiteArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "geo/frostbite_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FrostbiteArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "textures/models/armor/frostbite_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FrostbiteArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}