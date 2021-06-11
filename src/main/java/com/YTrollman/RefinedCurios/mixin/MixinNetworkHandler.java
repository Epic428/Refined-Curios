package com.YTrollman.RefinedCurios.mixin;

import com.YTrollman.RefinedCurios.curios.OpenNetworkItemMessageCurios;
import com.refinedmods.refinedstorage.network.*;
import com.refinedmods.refinedstorage.network.craftingmonitor.CraftingMonitorCancelMessage;
import com.refinedmods.refinedstorage.network.craftingmonitor.CraftingMonitorUpdateMessage;
import com.refinedmods.refinedstorage.network.craftingmonitor.WirelessCraftingMonitorSettingsUpdateMessage;
import com.refinedmods.refinedstorage.network.disk.StorageDiskSizeRequestMessage;
import com.refinedmods.refinedstorage.network.disk.StorageDiskSizeResponseMessage;
import com.refinedmods.refinedstorage.network.grid.*;
import com.refinedmods.refinedstorage.network.tiledata.TileDataParameterMessage;
import com.refinedmods.refinedstorage.network.tiledata.TileDataParameterUpdateMessage;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = NetworkHandler.class, remap = false)
public class MixinNetworkHandler {
    private final String protocolVersion = Integer.toString(1);
    private final SimpleChannel handler;

    public MixinNetworkHandler() {
        NetworkRegistry.ChannelBuilder var10001 = NetworkRegistry.ChannelBuilder.named(new ResourceLocation("refinedstorage", "main_channel"));
        String var10002 = this.protocolVersion;
        var10002.getClass();
        var10001 = var10001.clientAcceptedVersions(var10002::equals);
        var10002 = this.protocolVersion;
        var10002.getClass();
        this.handler = var10001.serverAcceptedVersions(var10002::equals).networkProtocolVersion(() -> {
            return this.protocolVersion;
        }).simpleChannel();
    }

    /**
     * @author
     */
    @Overwrite
    public void register() {
        int id = 0;
        int var2 = id + 1;
        this.handler.registerMessage(id, StorageDiskSizeRequestMessage.class, StorageDiskSizeRequestMessage::encode, StorageDiskSizeRequestMessage::decode, StorageDiskSizeRequestMessage::handle);
        this.handler.registerMessage(var2++, StorageDiskSizeResponseMessage.class, StorageDiskSizeResponseMessage::encode, StorageDiskSizeResponseMessage::decode, StorageDiskSizeResponseMessage::handle);
        this.handler.registerMessage(var2++, FilterUpdateMessage.class, FilterUpdateMessage::encode, FilterUpdateMessage::decode, FilterUpdateMessage::handle);
        this.handler.registerMessage(var2++, FluidFilterSlotUpdateMessage.class, FluidFilterSlotUpdateMessage::encode, FluidFilterSlotUpdateMessage::decode, FluidFilterSlotUpdateMessage::handle);
        this.handler.registerMessage(var2++, TileDataParameterMessage.class, TileDataParameterMessage::encode, TileDataParameterMessage::decode, (msg, ctx) -> {
            TileDataParameterMessage.handle(ctx);
        });
        this.handler.registerMessage(var2++, TileDataParameterUpdateMessage.class, TileDataParameterUpdateMessage::encode, TileDataParameterUpdateMessage::decode, TileDataParameterUpdateMessage::handle);
        this.handler.registerMessage(var2++, GridItemUpdateMessage.class, GridItemUpdateMessage::encode, GridItemUpdateMessage::decode, GridItemUpdateMessage::handle);
        this.handler.registerMessage(var2++, GridItemDeltaMessage.class, GridItemDeltaMessage::encode, GridItemDeltaMessage::decode, GridItemDeltaMessage::handle);
        this.handler.registerMessage(var2++, GridItemPullMessage.class, GridItemPullMessage::encode, GridItemPullMessage::decode, GridItemPullMessage::handle);
        this.handler.registerMessage(var2++, GridItemGridScrollMessage.class, GridItemGridScrollMessage::encode, GridItemGridScrollMessage::decode, GridItemGridScrollMessage::handle);
        this.handler.registerMessage(var2++, GridItemInventoryScrollMessage.class, GridItemInventoryScrollMessage::encode, GridItemInventoryScrollMessage::decode, GridItemInventoryScrollMessage::handle);
        this.handler.registerMessage(var2++, GridItemInsertHeldMessage.class, GridItemInsertHeldMessage::encode, GridItemInsertHeldMessage::decode, GridItemInsertHeldMessage::handle);
        this.handler.registerMessage(var2++, GridClearMessage.class, (msg, buf) -> {
        }, (buf) -> {
            return new GridClearMessage();
        }, (msg, ctx) -> {
            GridClearMessage.handle(ctx);
        });
        this.handler.registerMessage(var2++, GridPatternCreateMessage.class, GridPatternCreateMessage::encode, GridPatternCreateMessage::decode, GridPatternCreateMessage::handle);
        this.handler.registerMessage(var2++, SetFilterSlotMessage.class, SetFilterSlotMessage::encode, SetFilterSlotMessage::decode, SetFilterSlotMessage::handle);
        this.handler.registerMessage(var2++, SetFluidFilterSlotMessage.class, SetFluidFilterSlotMessage::encode, SetFluidFilterSlotMessage::decode, SetFluidFilterSlotMessage::handle);
        this.handler.registerMessage(var2++, GridFluidUpdateMessage.class, GridFluidUpdateMessage::encode, GridFluidUpdateMessage::decode, GridFluidUpdateMessage::handle);
        this.handler.registerMessage(var2++, GridFluidDeltaMessage.class, GridFluidDeltaMessage::encode, GridFluidDeltaMessage::decode, GridFluidDeltaMessage::handle);
        this.handler.registerMessage(var2++, GridFluidInsertHeldMessage.class, (msg, buf) -> {
        }, (buf) -> {
            return new GridFluidInsertHeldMessage();
        }, (msg, ctx) -> {
            GridFluidInsertHeldMessage.handle(ctx);
        });
        this.handler.registerMessage(var2++, GridFluidPullMessage.class, GridFluidPullMessage::encode, GridFluidPullMessage::decode, GridFluidPullMessage::handle);
        this.handler.registerMessage(var2++, GridTransferMessage.class, GridTransferMessage::encode, GridTransferMessage::decode, GridTransferMessage::handle);
        this.handler.registerMessage(var2++, GridProcessingTransferMessage.class, GridProcessingTransferMessage::encode, GridProcessingTransferMessage::decode, GridProcessingTransferMessage::handle);
        this.handler.registerMessage(var2++, SecurityManagerUpdateMessage.class, SecurityManagerUpdateMessage::encode, SecurityManagerUpdateMessage::decode, SecurityManagerUpdateMessage::handle);
        this.handler.registerMessage(var2++, WirelessGridSettingsUpdateMessage.class, WirelessGridSettingsUpdateMessage::encode, WirelessGridSettingsUpdateMessage::decode, WirelessGridSettingsUpdateMessage::handle);
        this.handler.registerMessage(var2++, OpenNetworkItemMessage.class, OpenNetworkItemMessage::encode, OpenNetworkItemMessage::decode, OpenNetworkItemMessage::handle);
        this.handler.registerMessage(var2++, OpenNetworkItemMessageCurios.class, OpenNetworkItemMessageCurios::encode, OpenNetworkItemMessageCurios::decode, OpenNetworkItemMessageCurios::handle);
        this.handler.registerMessage(var2++, WirelessFluidGridSettingsUpdateMessage.class, WirelessFluidGridSettingsUpdateMessage::encode, WirelessFluidGridSettingsUpdateMessage::decode, WirelessFluidGridSettingsUpdateMessage::handle);
        this.handler.registerMessage(var2++, PortableGridSettingsUpdateMessage.class, PortableGridSettingsUpdateMessage::encode, PortableGridSettingsUpdateMessage::decode, PortableGridSettingsUpdateMessage::handle);
        this.handler.registerMessage(var2++, PortableGridItemUpdateMessage.class, PortableGridItemUpdateMessage::encode, PortableGridItemUpdateMessage::decode, PortableGridItemUpdateMessage::handle);
        this.handler.registerMessage(var2++, PortableGridItemDeltaMessage.class, PortableGridItemDeltaMessage::encode, PortableGridItemDeltaMessage::decode, PortableGridItemDeltaMessage::handle);
        this.handler.registerMessage(var2++, PortableGridFluidUpdateMessage.class, PortableGridFluidUpdateMessage::encode, PortableGridFluidUpdateMessage::decode, PortableGridFluidUpdateMessage::handle);
        this.handler.registerMessage(var2++, PortableGridFluidDeltaMessage.class, PortableGridFluidDeltaMessage::encode, PortableGridFluidDeltaMessage::decode, PortableGridFluidDeltaMessage::handle);
        this.handler.registerMessage(var2++, GridCraftingPreviewRequestMessage.class, GridCraftingPreviewRequestMessage::encode, GridCraftingPreviewRequestMessage::decode, GridCraftingPreviewRequestMessage::handle);
        this.handler.registerMessage(var2++, GridCraftingPreviewResponseMessage.class, GridCraftingPreviewResponseMessage::encode, GridCraftingPreviewResponseMessage::decode, GridCraftingPreviewResponseMessage::handle);
        this.handler.registerMessage(var2++, GridCraftingStartRequestMessage.class, GridCraftingStartRequestMessage::encode, GridCraftingStartRequestMessage::decode, GridCraftingStartRequestMessage::handle);
        this.handler.registerMessage(var2++, GridCraftingStartResponseMessage.class, (msg, buf) -> {
        }, (buf) -> {
            return new GridCraftingStartResponseMessage();
        }, (msg, ctx) -> {
            GridCraftingStartResponseMessage.handle(ctx);
        });
        this.handler.registerMessage(var2++, CraftingMonitorUpdateMessage.class, CraftingMonitorUpdateMessage::encode, CraftingMonitorUpdateMessage::decode, CraftingMonitorUpdateMessage::handle);
        this.handler.registerMessage(var2++, CraftingMonitorCancelMessage.class, CraftingMonitorCancelMessage::encode, CraftingMonitorCancelMessage::decode, CraftingMonitorCancelMessage::handle);
        this.handler.registerMessage(var2++, WirelessCraftingMonitorSettingsUpdateMessage.class, WirelessCraftingMonitorSettingsUpdateMessage::encode, WirelessCraftingMonitorSettingsUpdateMessage::decode, WirelessCraftingMonitorSettingsUpdateMessage::handle);
    }
}
