package net.mtheninja615.codex_of_champions.entities.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.resources.ResourceLocation;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.item.armor.SakuraBlossomCloakArmorItem;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SakuraBlossomCloakArmorModel extends DefaultedEntityGeoModel<SakuraBlossomCloakArmorItem> {
    public SakuraBlossomCloakArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(SakuraBlossomCloakArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "geo/sakura_cloak_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SakuraBlossomCloakArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "textures/models/armor/sakura_blossom_cloak_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SakuraBlossomCloakArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
