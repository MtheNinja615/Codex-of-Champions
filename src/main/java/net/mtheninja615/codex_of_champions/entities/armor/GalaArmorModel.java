package net.mtheninja615.codex_of_champions.entities.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.resources.ResourceLocation;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.item.armor.GalaArmorItem;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GalaArmorModel extends DefaultedEntityGeoModel<GalaArmorItem> {
    public GalaArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GalaArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "geo/gala_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GalaArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "textures/models/armor/gala_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GalaArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}