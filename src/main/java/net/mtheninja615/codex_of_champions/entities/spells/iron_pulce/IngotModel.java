package net.mtheninja615.codex_of_champions.entities.spells.iron_pulce;

import net.minecraft.resources.ResourceLocation;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.entities.spells.petal_blizzard.PetalBlizzard;
import software.bernie.geckolib.model.GeoModel;

public class IngotModel extends GeoModel<Ingot> {

    @Override
    public ResourceLocation getModelResource(Ingot animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "geo/entities/spells/ingot.geo.json");
    }


    @Override
    public ResourceLocation getTextureResource(Ingot animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "textures/spells/ingot.png");
    }


    @Override
    public ResourceLocation getAnimationResource(Ingot animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "animations/entities/spells/no_anim.animation.json");
    }

}