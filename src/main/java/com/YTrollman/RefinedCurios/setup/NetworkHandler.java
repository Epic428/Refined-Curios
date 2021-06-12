package com.YTrollman.RefinedCurios.setup;

import com.YTrollman.RefinedCurios.RefinedCurios;
import com.YTrollman.RefinedCurios.curios.OpenNetworkItemMessageCurios;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class NetworkHandler {

    private static int id = 0;
    private static final String PROTOCOL_VERSION = Integer.toString(1);
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(RefinedCurios.MOD_ID, "main_channel"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void register() {
        INSTANCE.registerMessage(id++, OpenNetworkItemMessageCurios.class, OpenNetworkItemMessageCurios::encode, OpenNetworkItemMessageCurios::decode, OpenNetworkItemMessageCurios::handle);
    }

    public static void sendToServer(Object message) {
        INSTANCE.sendToServer(message);
    }
}
