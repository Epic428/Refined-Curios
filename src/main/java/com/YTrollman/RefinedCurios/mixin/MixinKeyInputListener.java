package com.YTrollman.RefinedCurios.mixin;

import com.YTrollman.RefinedCurios.curios.OpenNetworkItemMessageCurios;
import com.refinedmods.refinedstorage.RS;
import com.refinedmods.refinedstorage.RSItems;
import com.refinedmods.refinedstorage.network.OpenNetworkItemMessage;
import com.refinedmods.refinedstorage.screen.KeyInputListener;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

@Mixin(value = KeyInputListener.class, remap = false)
public class MixinKeyInputListener {

    /**
     * @author
     */
    @Overwrite
    public static void findAndOpen(IInventory inv, Consumer<ITextComponent> onError, Item... items) {
        Set<Item> validItems = new HashSet(Arrays.asList(items));
        int slotFound = -1;

        for(int i = 0; i < inv.getContainerSize(); ++i) {
            ItemStack slot = inv.getItem(i);
            if (validItems.contains(slot.getItem())) {
                if (slotFound != -1) {
                    onError.accept(new TranslationTextComponent("misc.refinedstorage.network_item.shortcut_duplicate", new Object[]{new TranslationTextComponent(items[0].getDescriptionId())}));
                    return;
                }
                slotFound = i;
            }
        }

        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.WIRELESS_GRID.get(), ((LivingEntity)Minecraft.getInstance().player)).isPresent()) {
            slotFound = 0;
            RS.NETWORK_HANDLER.sendToServer(new OpenNetworkItemMessageCurios(slotFound));
        }
        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.CREATIVE_WIRELESS_GRID.get(), ((LivingEntity)Minecraft.getInstance().player)).isPresent()) {
            slotFound = 0;
            RS.NETWORK_HANDLER.sendToServer(new OpenNetworkItemMessageCurios(slotFound));
        }

        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.WIRELESS_FLUID_GRID.get(), ((LivingEntity)Minecraft.getInstance().player)).isPresent()) {
            slotFound = 1;
            RS.NETWORK_HANDLER.sendToServer(new OpenNetworkItemMessageCurios(slotFound));
        }
        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.CREATIVE_WIRELESS_FLUID_GRID.get(), ((LivingEntity)Minecraft.getInstance().player)).isPresent()) {
            slotFound = 1;
            RS.NETWORK_HANDLER.sendToServer(new OpenNetworkItemMessageCurios(slotFound));
        }

        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.WIRELESS_CRAFTING_MONITOR.get(), ((LivingEntity)Minecraft.getInstance().player)).isPresent()) {
            slotFound = 2;
            RS.NETWORK_HANDLER.sendToServer(new OpenNetworkItemMessageCurios(slotFound));
        }
        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.CREATIVE_WIRELESS_CRAFTING_MONITOR.get(), ((LivingEntity)Minecraft.getInstance().player)).isPresent()) {
            slotFound = 2;
            RS.NETWORK_HANDLER.sendToServer(new OpenNetworkItemMessageCurios(slotFound));
        }

        if (slotFound == -1) {
            onError.accept(new TranslationTextComponent("misc.refinedstorage.network_item.shortcut_not_found", new Object[]{new TranslationTextComponent(items[0].getDescriptionId())}));
        } else {
            RS.NETWORK_HANDLER.sendToServer(new OpenNetworkItemMessage(slotFound));
        }
    }
}
