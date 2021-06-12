package com.YTrollman.RefinedCurios.curios;

import com.refinedmods.refinedstorage.RSItems;
import com.refinedmods.refinedstorage.apiimpl.API;
import com.refinedmods.refinedstorage.apiimpl.network.grid.factory.PortableGridGridFactory;
import com.refinedmods.refinedstorage.item.NetworkItem;
import com.refinedmods.refinedstorage.item.blockitem.PortableGridBlockItem;
import com.refinedmods.refinedstorageaddons.RSAddonsItems;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.network.NetworkEvent;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.function.Supplier;

public class OpenNetworkItemMessageCurios {
    private static int slotId;

    public OpenNetworkItemMessageCurios(int slotId) {
        this.slotId = slotId;
    }

    public static OpenNetworkItemMessageCurios decode(PacketBuffer buf) {
        return new OpenNetworkItemMessageCurios(buf.readInt());
    }

    public static void encode(OpenNetworkItemMessageCurios message, PacketBuffer buf) {
        buf.writeInt(message.slotId);
    }

    public static void handle(OpenNetworkItemMessageCurios message, Supplier<NetworkEvent.Context> ctx) {
        ServerPlayerEntity player = ((NetworkEvent.Context)ctx.get()).getSender();
        if (player != null) {
            ((NetworkEvent.Context)ctx.get()).enqueueWork(() -> {
                if(Minecraft.class != null)
                {
                    if(Minecraft.getInstance().level != null && Minecraft.getInstance().level.isClientSide)
                    {
                        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.WIRELESS_GRID.get(), Minecraft.getInstance().player).isPresent()) {
                            ItemStack stack = CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.WIRELESS_GRID.get(), Minecraft.getInstance().player).get().getRight();
                            if (stack.getItem() instanceof NetworkItem) {
                                ((NetworkItem) stack.getItem()).applyNetwork(player.getServer(), stack, (n) -> {
                                    n.getNetworkItemManager().open(player, stack, message.slotId);
                                }, (err) -> {
                                    player.sendMessage(err, player.getUUID());
                                });
                            } else if (stack.getItem() instanceof PortableGridBlockItem) {
                                API.instance().getGridManager().openGrid(PortableGridGridFactory.ID, player, stack, message.slotId);
                            }
                        }
                        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.CREATIVE_WIRELESS_GRID.get(), Minecraft.getInstance().player).isPresent()) {
                            ItemStack stack = CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.CREATIVE_WIRELESS_GRID.get(), Minecraft.getInstance().player).get().getRight();
                            if (stack.getItem() instanceof NetworkItem) {
                                ((NetworkItem) stack.getItem()).applyNetwork(player.getServer(), stack, (n) -> {
                                    n.getNetworkItemManager().open(player, stack, message.slotId);
                                }, (err) -> {
                                    player.sendMessage(err, player.getUUID());
                                });
                            } else if (stack.getItem() instanceof PortableGridBlockItem) {
                                API.instance().getGridManager().openGrid(PortableGridGridFactory.ID, player, stack, message.slotId);
                            }
                        }

                        if(ModList.get().isLoaded("refinedstorageaddons"))
                        {
                            if(CuriosApi.getCuriosHelper().findEquippedCurio(RSAddonsItems.WIRELESS_CRAFTING_GRID, Minecraft.getInstance().player).isPresent()) {
                                ItemStack stack = CuriosApi.getCuriosHelper().findEquippedCurio(RSAddonsItems.WIRELESS_CRAFTING_GRID, Minecraft.getInstance().player).get().getRight();
                                if (stack.getItem() instanceof NetworkItem) {
                                    ((NetworkItem) stack.getItem()).applyNetwork(player.getServer(), stack, (n) -> {
                                        n.getNetworkItemManager().open(player, stack, message.slotId);
                                    }, (err) -> {
                                        player.sendMessage(err, player.getUUID());
                                    });
                                } else if (stack.getItem() instanceof PortableGridBlockItem) {
                                    API.instance().getGridManager().openGrid(PortableGridGridFactory.ID, player, stack, message.slotId);
                                }
                            }
                            if(CuriosApi.getCuriosHelper().findEquippedCurio(RSAddonsItems.CREATIVE_WIRELESS_CRAFTING_GRID, Minecraft.getInstance().player).isPresent()) {
                                ItemStack stack = CuriosApi.getCuriosHelper().findEquippedCurio(RSAddonsItems.CREATIVE_WIRELESS_CRAFTING_GRID, Minecraft.getInstance().player).get().getRight();
                                if (stack.getItem() instanceof NetworkItem) {
                                    ((NetworkItem) stack.getItem()).applyNetwork(player.getServer(), stack, (n) -> {
                                        n.getNetworkItemManager().open(player, stack, message.slotId);
                                    }, (err) -> {
                                        player.sendMessage(err, player.getUUID());
                                    });
                                } else if (stack.getItem() instanceof PortableGridBlockItem) {
                                    API.instance().getGridManager().openGrid(PortableGridGridFactory.ID, player, stack, message.slotId);
                                }
                            }
                        }

                        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.WIRELESS_FLUID_GRID.get(), Minecraft.getInstance().player).isPresent()) {
                            ItemStack stack = CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.WIRELESS_FLUID_GRID.get(), Minecraft.getInstance().player).get().getRight();
                            if (stack.getItem() instanceof NetworkItem) {
                                ((NetworkItem) stack.getItem()).applyNetwork(player.getServer(), stack, (n) -> {
                                    n.getNetworkItemManager().open(player, stack, message.slotId);
                                }, (err) -> {
                                    player.sendMessage(err, player.getUUID());
                                });
                            } else if (stack.getItem() instanceof PortableGridBlockItem) {
                                API.instance().getGridManager().openGrid(PortableGridGridFactory.ID, player, stack, message.slotId);
                            }
                        }
                        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.CREATIVE_WIRELESS_FLUID_GRID.get(), Minecraft.getInstance().player).isPresent()) {
                            ItemStack stack = CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.CREATIVE_WIRELESS_FLUID_GRID.get(), Minecraft.getInstance().player).get().getRight();
                            if (stack.getItem() instanceof NetworkItem) {
                                ((NetworkItem) stack.getItem()).applyNetwork(player.getServer(), stack, (n) -> {
                                    n.getNetworkItemManager().open(player, stack, message.slotId);
                                }, (err) -> {
                                    player.sendMessage(err, player.getUUID());
                                });
                            } else if (stack.getItem() instanceof PortableGridBlockItem) {
                                API.instance().getGridManager().openGrid(PortableGridGridFactory.ID, player, stack, message.slotId);
                            }
                        }

                        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.WIRELESS_CRAFTING_MONITOR.get(), Minecraft.getInstance().player).isPresent()) {
                            ItemStack stack = CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.WIRELESS_CRAFTING_MONITOR.get(), Minecraft.getInstance().player).get().getRight();
                            if (stack.getItem() instanceof NetworkItem) {
                                ((NetworkItem) stack.getItem()).applyNetwork(player.getServer(), stack, (n) -> {
                                    n.getNetworkItemManager().open(player, stack, message.slotId);
                                }, (err) -> {
                                    player.sendMessage(err, player.getUUID());
                                });
                            } else if (stack.getItem() instanceof PortableGridBlockItem) {
                                API.instance().getGridManager().openGrid(PortableGridGridFactory.ID, player, stack, message.slotId);
                            }
                        }
                        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.CREATIVE_WIRELESS_CRAFTING_MONITOR.get(), Minecraft.getInstance().player).isPresent()) {
                            ItemStack stack = CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.CREATIVE_WIRELESS_CRAFTING_MONITOR.get(), Minecraft.getInstance().player).get().getRight();
                            if (stack.getItem() instanceof NetworkItem) {
                                ((NetworkItem) stack.getItem()).applyNetwork(player.getServer(), stack, (n) -> {
                                    n.getNetworkItemManager().open(player, stack, message.slotId);
                                }, (err) -> {
                                    player.sendMessage(err, player.getUUID());
                                });
                            } else if (stack.getItem() instanceof PortableGridBlockItem) {
                                API.instance().getGridManager().openGrid(PortableGridGridFactory.ID, player, stack, message.slotId);
                            }
                        }

                        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.PORTABLE_GRID.get(), Minecraft.getInstance().player).isPresent()) {
                            ItemStack stack = CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.PORTABLE_GRID.get(), Minecraft.getInstance().player).get().getRight();
                            if (stack.getItem() instanceof NetworkItem) {
                                ((NetworkItem) stack.getItem()).applyNetwork(player.getServer(), stack, (n) -> {
                                    n.getNetworkItemManager().open(player, stack, message.slotId);
                                }, (err) -> {
                                    player.sendMessage(err, player.getUUID());
                                });
                            } else if (stack.getItem() instanceof PortableGridBlockItem) {
                                API.instance().getGridManager().openGrid(PortableGridGridFactory.ID, player, stack, message.slotId);
                            }
                        }
                        if(CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.CREATIVE_PORTABLE_GRID.get(), Minecraft.getInstance().player).isPresent()) {
                            ItemStack stack = CuriosApi.getCuriosHelper().findEquippedCurio(RSItems.CREATIVE_PORTABLE_GRID.get(), Minecraft.getInstance().player).get().getRight();
                            if (stack.getItem() instanceof NetworkItem) {
                                ((NetworkItem) stack.getItem()).applyNetwork(player.getServer(), stack, (n) -> {
                                    n.getNetworkItemManager().open(player, stack, message.slotId);
                                }, (err) -> {
                                    player.sendMessage(err, player.getUUID());
                                });
                            } else if (stack.getItem() instanceof PortableGridBlockItem) {
                                API.instance().getGridManager().openGrid(PortableGridGridFactory.ID, player, stack, message.slotId);
                            }
                        }
                    }
                }
            });
        }

        ((NetworkEvent.Context)ctx.get()).setPacketHandled(true);
    }
}
