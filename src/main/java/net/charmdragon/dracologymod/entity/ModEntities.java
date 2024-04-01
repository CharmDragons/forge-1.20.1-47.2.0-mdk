package net.charmdragon.dracologymod.entity;

import net.charmdragon.dracologymod.DracologyMod;
import net.charmdragon.dracologymod.entity.custom.DragonEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.event.InputEvent;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DracologyMod.MOD_ID);

    public static final RegistryObject<EntityType<DragonEntity>> DRAGON =
            ENTITY_TYPES.register("dragon", () -> EntityType.Builder.of(DragonEntity::new, MobCategory.CREATURE)
                    .sized(2.5f, 2.5f).build("dragon"));

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }
}
