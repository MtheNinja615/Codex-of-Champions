package net.mtheninja615.codex_of_champions.entities.spells.petal_blizzard;

import net.minecraft.resources.ResourceLocation;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import software.bernie.geckolib.model.GeoModel;

public class PetalBlizzardModel  extends GeoModel<PetalBlizzard> {

    @Override
    public ResourceLocation getModelResource(PetalBlizzard animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "geo/entities/spells/petal_blizzard.geo.json");
    }


    @Override
    public ResourceLocation getTextureResource(PetalBlizzard animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "textures/spells/petal_blizzard.png");
    }


    @Override
    public ResourceLocation getAnimationResource(PetalBlizzard animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "animations/entities/spells/petal_blizzard.animation.json");
    }

}
