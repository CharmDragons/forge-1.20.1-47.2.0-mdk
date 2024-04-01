package net.charmdragon.dracologymod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.charmdragon.dracologymod.DracologyMod;
import net.charmdragon.dracologymod.entity.custom.DragonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DragonRenderer extends MobRenderer<DragonEntity, DevDragonModel<DragonEntity>> {

    public DragonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DevDragonModel<>(pContext.bakeLayer(ModModelLayers.DRAGON_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(DragonEntity pEntity) {
        return new ResourceLocation(DracologyMod.MOD_ID, "textures/entity/dragon.png");
    }

    @Override
    public void render(DragonEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {


        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
