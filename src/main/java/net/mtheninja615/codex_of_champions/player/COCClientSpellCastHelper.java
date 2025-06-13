package net.mtheninja615.codex_of_champions.player;


import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;
import net.mtheninja615.codex_of_champions.spells.nature.PetalStep;

public class COCClientSpellCastHelper {
    public static void handleClientboundPetalStep(Vec3 pos1, Vec3 pos2) {
        var player = Minecraft.getInstance().player;

        if (player != null) {
            var level = Minecraft.getInstance().player.level();
            PetalStep.particleCloud(level, pos1);
            PetalStep.particleCloud(level, pos2);
        }
    }
}
