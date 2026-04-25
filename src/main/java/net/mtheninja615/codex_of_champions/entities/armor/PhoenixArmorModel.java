package net.mtheninja615.codex_of_champions.entities.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.resources.ResourceLocation;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.item.armor.MonstrosityArmorItem;
import net.mtheninja615.codex_of_champions.item.armor.PhoenixArmorItem;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class PhoenixArmorModel extends DefaultedEntityGeoModel<PhoenixArmorItem> {
    public PhoenixArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(PhoenixArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "geo/phoenix_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PhoenixArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "textures/models/armor/phoenix_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PhoenixArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
