package net.mtheninja615.codex_of_champions.network.particles;

import io.redspace.ironsspellbooks.player.ClientSpellCastHelper;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class PetalStepParticlesPacket  implements CustomPacketPayload {
    private final Vec3 pos1;
    private final Vec3 pos2;
    public static final CustomPacketPayload.Type<PetalStepParticlesPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(CodexOfChampions.MODID, "petal_step_particles"));
    public static final StreamCodec<RegistryFriendlyByteBuf, PetalStepParticlesPacket> STREAM_CODEC = CustomPacketPayload.codec(PetalStepParticlesPacket::write, PetalStepParticlesPacket::new);

    public PetalStepParticlesPacket(Vec3 pos1, Vec3 pos2) {
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    public PetalStepParticlesPacket(FriendlyByteBuf buf) {
        pos1 = buf.readVec3();
        pos2 = buf.readVec3();
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeVec3(pos1);
        buf.writeVec3(pos2);
    }

    public static void handle(PetalStepParticlesPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            ClientSpellCastHelper.handleClientboundTeleport(packet.pos1, packet.pos2);
        });
    }

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}