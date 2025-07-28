package net.mtheninja615.codex_of_champions.entities.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.resources.ResourceLocation;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.item.armor.BlossomCloakArmorItem;
import net.mtheninja615.codex_of_champions.item.armor.MonstrosityArmorItem;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class MonstrosityArmorModel extends DefaultedEntityGeoModel<MonstrosityArmorItem> {
    public MonstrosityArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(MonstrosityArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "geo/redstone_monstrosity_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MonstrosityArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "textures/models/armor/redstone_monstrosity_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MonstrosityArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}