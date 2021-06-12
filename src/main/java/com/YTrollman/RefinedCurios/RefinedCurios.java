package com.YTrollman.RefinedCurios;

import com.YTrollman.RefinedCurios.curios.CuriosIntegrationModComms;
import com.YTrollman.RefinedCurios.curios.KeyInputListener;
import com.YTrollman.RefinedCurios.setup.NetworkHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("refinedcurios")
public class RefinedCurios {
    public static final String MOD_ID = "refinedcurios";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public RefinedCurios() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        CuriosIntegrationModComms.registerMod(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        NetworkHandler.register();
    }

    private void doClientStuff(final FMLClientSetupEvent event) 
    {
        MinecraftForge.EVENT_BUS.register(new KeyInputListener());
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event)
    {

    }
}
