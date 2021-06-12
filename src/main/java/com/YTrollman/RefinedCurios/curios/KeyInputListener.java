package com.YTrollman.RefinedCurios.curios;

import com.YTrollman.RefinedCurios.setup.NetworkHandler;
import com.refinedmods.refinedstorage.RSItems;
import com.refinedmods.refinedstorage.RSKeyBindings;
import com.refinedmods.refinedstorageaddons.RSAddonsItems;
import com.refinedmods.refinedstorageaddons.RSAddonsKeyBindings;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.util.Util;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.function.Consumer;

public class KeyInputListener {

    public KeyInputListener() {
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent e) {
        if (Minecraft.getInstance().player != null) {
            PlayerInventory inv = Minecraft.getInstance().player.inventory;

            if(ModList.get().isLoaded("refinedstorageaddons"))
            {
                if (RSKeyBindings.OPEN_WIRELESS_GRID.isDown()) {
                    findAndOpen(inv, error -> Minecraft.getInstance().player.sendMessage(error, Util.NIL_UUID), RSItems.WIRELESS_GRID.get(), RSItems.CREATIVE_WIRELESS_GRID.get());
                } else if (RSKeyBindings.OPEN_WIRELESS_FLUID_GRID.isDown()) {
                    findAndOpen(inv, error -> Minecraft.getInstance().player.sendMessage(error, Util.NIL_UUID), RSItems.WIRELESS_FLUID_GRID.get(), RSItems.CREATIVE_WIRELESS_FLUID_GRID.get());
                } else if (RSKeyBindings.OPEN_PORTABLE_GRID.isDown()) {
                    findAndOpen(inv, error -> Minecraft.getInstance().player.sendMessage(error, Util.NIL_UUID), RSItems.PORTABLE_GRID.get(), RSItems.CREATIVE_PORTABLE_GRID.get());
                } else if (RSKeyBindings.OPEN_WIRELESS_CRAFTING_MONITOR.isDown()) {
                    findAndOpen(inv, error -> Minecraft.getInstance().player.sendMessage(error, Util.NIL_UUID), RSItems.WIRELESS_CRAFTING_MONITOR.get(), RSItems.CREATIVE_WIRELESS_CRAFTING_MONITOR.get());
                } else if (RSAddonsKeyBindings.OPEN_WIRELESS_CRAFTING_GRID.isDown()) {
                    findAndOpen(inv, error -> Minecraft.getInstance().player.sendMessage(error, Util.NIL_UUID), RSAddonsItems.WIRELESS_CRAFTING_GRID, RSAddonsItems.CREATIVE_WIRELESS_CRAFTING_GRID);
                }
            }
            else
            {
                if (RSKeyBindings.OPEN_WIRELESS_GRID.isDown()) {
                    findAndOpen(inv, error -> Minecraft.getInstance().player.sendMessage(error, Util.NIL_UUID), RSItems.WIRELESS_GRID.get(), RSItems.CREATIVE_WIRELESS_GRID.get());
                } else if (RSKeyBindings.OPEN_WIRELESS_FLUID_GRID.isDown()) {
                    findAndOpen(inv, error -> Minecraft.getInstance().player.sendMessage(error, Util.NIL_UUID), RSItems.WIRELESS_FLUID_GRID.get(), RSItems.CREATIVE_WIRELESS_FLUID_GRID.get());
                } else if (RSKeyBindings.OPEN_PORTABLE_GRID.isDown()) {
                    findAndOpen(inv, error -> Minecraft.getInstance().player.sendMessage(error, Util.NIL_UUID), RSItems.PORTABLE_GRID.get(), RSItems.CREATIVE_PORTABLE_GRID.get());
                } else if (RSKeyBindings.OPEN_WIRELESS_CRAFTING_MONITOR.isDown()) {
                    findAndOpen(inv, error -> Minecraft.getInstance().player.sendMessage(error, Util.NIL_UUID), RSItems.WIRELESS_CRAFTING_MONITOR.get(), RSItems.CREATIVE_WIRELESS_CRAFTING_MONITOR.get());
                }
            }
        }
    }

    public static void findAndOpen(IInventory inv, Consumer<ITextComponent> onError, Item... items) {
        int slotFound = -1;

        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.WIRELESS_GRID.get(), Minecraft.getInstance().player).isPresent()) {
            slotFound = 0;
            NetworkHandler.sendToServer(new OpenNetworkItemMessageCurios(slotFound));
        }
        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.CREATIVE_WIRELESS_GRID.get(), Minecraft.getInstance().player).isPresent()) {
            slotFound = 0;
            NetworkHandler.sendToServer(new OpenNetworkItemMessageCurios(slotFound));
        }

        if(ModList.get().isLoaded("refinedstorageaddons"))
        {
            if(CuriosApi.getCuriosHelper().findEquippedCurio(RSAddonsItems.WIRELESS_CRAFTING_GRID, Minecraft.getInstance().player).isPresent()) {
                slotFound = 0;
                NetworkHandler.sendToServer(new OpenNetworkItemMessageCurios(slotFound));
            }
            if(CuriosApi.getCuriosHelper().findEquippedCurio(RSAddonsItems.CREATIVE_WIRELESS_CRAFTING_GRID, Minecraft.getInstance().player).isPresent()) {
                slotFound = 0;
                NetworkHandler.sendToServer(new OpenNetworkItemMessageCurios(slotFound));
            }
        }

        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.WIRELESS_FLUID_GRID.get(), Minecraft.getInstance().player).isPresent()) {
            slotFound = 1;
            NetworkHandler.sendToServer(new OpenNetworkItemMessageCurios(slotFound));
        }
        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.CREATIVE_WIRELESS_FLUID_GRID.get(), Minecraft.getInstance().player).isPresent()) {
            slotFound = 1;
            NetworkHandler.sendToServer(new OpenNetworkItemMessageCurios(slotFound));
        }

        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.WIRELESS_CRAFTING_MONITOR.get(), Minecraft.getInstance().player).isPresent()) {
            slotFound = 2;
            NetworkHandler.sendToServer(new OpenNetworkItemMessageCurios(slotFound));
        }
        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.CREATIVE_WIRELESS_CRAFTING_MONITOR.get(), Minecraft.getInstance().player).isPresent()) {
            slotFound = 2;
            NetworkHandler.sendToServer(new OpenNetworkItemMessageCurios(slotFound));
        }

        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.PORTABLE_GRID.get(), Minecraft.getInstance().player).isPresent()) {
            slotFound = 3;
            NetworkHandler.sendToServer(new OpenNetworkItemMessageCurios(slotFound));
        }
        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.CREATIVE_PORTABLE_GRID.get(), Minecraft.getInstance().player).isPresent()) {
            slotFound = 3;
            NetworkHandler.sendToServer(new OpenNetworkItemMessageCurios(slotFound));
        }

        if (slotFound == -1) {
            onError.accept(new TranslationTextComponent("misc.refinedstorage.network_item.shortcut_not_found", new Object[]{new TranslationTextComponent(items[0].getDescriptionId())}));
        }
    }
}
