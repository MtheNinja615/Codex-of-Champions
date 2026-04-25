package net.mtheninja615.codex_of_champions.item.weapons.metal_sword;

import net.minecraft.resources.ResourceLocation;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class MetalSwordModel  extends DefaultedItemGeoModel<MetalSwordItem> {
    public MetalSwordModel() {
        super(ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, ""));
    }

    @Override
    public ResourceLocation getModelResource(MetalSwordItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "geo/item/metal_sword.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MetalSwordItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "textures/item/metal_sword.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MetalSwordItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "animations/item/weapons/metal_sword_idle.animation.json");
    }
}
