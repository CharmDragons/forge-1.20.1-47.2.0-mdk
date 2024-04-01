package net.charmdragon.dracologymod.event;

import net.charmdragon.dracologymod.DracologyMod;
import net.charmdragon.dracologymod.entity.ModEntities;
import net.charmdragon.dracologymod.entity.custom.DragonEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DracologyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event)
    {
        event.put(ModEntities.DRAGON.get(), DragonEntity.createAttribute().build());
    }
}