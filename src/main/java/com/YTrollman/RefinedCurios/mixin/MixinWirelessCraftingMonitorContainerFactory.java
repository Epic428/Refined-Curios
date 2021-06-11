package com.YTrollman.RefinedCurios.mixin;

import com.refinedmods.refinedstorage.RSContainers;
import com.refinedmods.refinedstorage.RSItems;
import com.refinedmods.refinedstorage.container.CraftingMonitorContainer;
import com.refinedmods.refinedstorage.container.factory.WirelessCraftingMonitorContainerFactory;
import com.refinedmods.refinedstorage.tile.craftingmonitor.CraftingMonitorTile;
import com.refinedmods.refinedstorage.tile.craftingmonitor.WirelessCraftingMonitor;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import top.theillusivec4.curios.api.CuriosApi;

@Mixin(value = WirelessCraftingMonitorContainerFactory.class, remap = false)
public class MixinWirelessCraftingMonitorContainerFactory {

    /**
     * @author
     */
    @Overwrite
    public CraftingMonitorContainer create(int windowId, PlayerInventory inv, PacketBuffer data) {
        int slotId = data.readInt();
        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.WIRELESS_CRAFTING_MONITOR.get(), inv.player).isPresent()) {
            WirelessCraftingMonitor wirelessCraftingMonitor = new WirelessCraftingMonitor(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.WIRELESS_CRAFTING_MONITOR.get(), Minecraft.getInstance().player).get().getRight(), null, slotId);
            return new CraftingMonitorContainer(RSContainers.WIRELESS_CRAFTING_MONITOR, wirelessCraftingMonitor, null, inv.player, windowId);
        }
        else if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.CREATIVE_WIRELESS_CRAFTING_MONITOR.get(), inv.player).isPresent()) {
            WirelessCraftingMonitor wirelessCraftingMonitor = new WirelessCraftingMonitor(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.CREATIVE_WIRELESS_CRAFTING_MONITOR.get(), Minecraft.getInstance().player).get().getRight(), null, slotId);
            return new CraftingMonitorContainer(RSContainers.WIRELESS_CRAFTING_MONITOR, wirelessCraftingMonitor, null, inv.player, windowId);
        }
        else
        {
            ItemStack stack = inv.getItem(slotId);
            WirelessCraftingMonitor wirelessCraftingMonitor = new WirelessCraftingMonitor(stack, null, slotId);
            return new CraftingMonitorContainer(RSContainers.WIRELESS_CRAFTING_MONITOR, wirelessCraftingMonitor, null, inv.player, windowId);
        }
    }
}
