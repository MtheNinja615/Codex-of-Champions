package net.mtheninja615.codex_of_champions.entities.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.resources.ResourceLocation;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.item.armor.BlossomCloakArmorItem;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class BlossomCloakArmorModel  extends DefaultedEntityGeoModel<BlossomCloakArmorItem> {
    public BlossomCloakArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(BlossomCloakArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "geo/blossom_cloak_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BlossomCloakArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "textures/models/armor/blossom_cloak_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BlossomCloakArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}