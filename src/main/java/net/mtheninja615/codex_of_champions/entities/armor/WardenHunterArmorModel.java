package net.mtheninja615.codex_of_champions.entities.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.resources.ResourceLocation;
import net.mtheninja615.codex_of_champions.CodexOfChampions;

import net.mtheninja615.codex_of_champions.item.armor.WardenHunterArmorItem;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class WardenHunterArmorModel extends DefaultedEntityGeoModel<WardenHunterArmorItem> {
    public WardenHunterArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, ""));
    }

   // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(WardenHunterArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "geo/warden_hunter_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WardenHunterArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "textures/models/armor/warden_hunter_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WardenHunterArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
