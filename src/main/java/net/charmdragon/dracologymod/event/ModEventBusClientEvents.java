package net.charmdragon.dracologymod.event;

import net.charmdragon.dracologymod.DracologyMod;
import net.charmdragon.dracologymod.entity.client.DevDragonModel;
import net.charmdragon.dracologymod.entity.client.ModModelLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DracologyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(ModModelLayers.DRAGON_LAYER, DevDragonModel::createBodyLayer);
    }
}
