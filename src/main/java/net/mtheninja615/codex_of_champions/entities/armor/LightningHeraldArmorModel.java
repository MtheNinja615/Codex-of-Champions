package net.mtheninja615.codex_of_champions.entities.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.resources.ResourceLocation;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.item.armor.LightningHeraldArmorItem;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class LightningHeraldArmorModel extends DefaultedEntityGeoModel<LightningHeraldArmorItem> {
    public LightningHeraldArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(LightningHeraldArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "geo/lightning_herald_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LightningHeraldArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "textures/models/armor/lightning_herald_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LightningHeraldArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
