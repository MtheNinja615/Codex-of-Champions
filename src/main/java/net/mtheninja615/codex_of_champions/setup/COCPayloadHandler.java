package net.mtheninja615.codex_of_champions.setup;


import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.network.particles.PetalStepParticlesPacket;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = CodexOfChampions.MODID)
public class COCPayloadHandler {

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar payloadRegistrar = event.registrar(CodexOfChampions.MODID).versioned("1.0.0").optional();

        //Particles
        payloadRegistrar.playToClient(PetalStepParticlesPacket.TYPE, PetalStepParticlesPacket.STREAM_CODEC, PetalStepParticlesPacket::handle);
    }
}