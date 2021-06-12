package com.YTrollman.RefinedCurios.setup;

import com.YTrollman.RefinedCurios.RefinedCurios;
import com.YTrollman.RefinedCurios.curios.OpenNetworkItemMessageCurios;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class NetworkHandler {

    private final String protocolVersion = Integer.toString(1);
    private final SimpleChannel handler = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(RefinedCurios.MOD_ID, "main_channel"))
            .clientAcceptedVersions(protocolVersion::equals)
            .serverAcceptedVersions(protocolVersion::equals)
            .networkProtocolVersion(() -> protocolVersion)
            .simpleChannel();

    public void register() {
        int id = 0;

        handler.registerMessage(id++, OpenNetworkItemMessageCurios.class, OpenNetworkItemMessageCurios::encode, OpenNetworkItemMessageCurios::decode, OpenNetworkItemMessageCurios::handle);
    }

    public void sendToServer(Object message) {
        handler.sendToServer(message);
    }

    public void sendTo(ServerPlayerEntity player, Object message) {
        if (!(player instanceof FakePlayer)) {
            handler.sendTo(message, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
        }
    }
}
