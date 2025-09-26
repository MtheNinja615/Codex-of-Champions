package net.mtheninja615.codex_of_champions.entities.spells.petal_blizzard;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PetalBlizzardRenderer extends GeoEntityRenderer<PetalBlizzard> {
    public PetalBlizzardRenderer(EntityRendererProvider.Context context) {
        super(context, new PetalBlizzardModel());
        this.shadowRadius = 0f;
    }

    @Override
    public ResourceLocation getTextureLocation(PetalBlizzard animatable) {
        return ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "textures/spells/petal_blizzard.png");
    }

    @Override
    public void preRender(PoseStack poseStack, PetalBlizzard animatable, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {

        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTick, animatable.yRotO, animatable.getYRot())));
        poseStack.mulPose(Axis.XP.rotationDegrees(-Mth.lerp(partialTick, animatable.xRotO, animatable.getXRot())));

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
    }
}