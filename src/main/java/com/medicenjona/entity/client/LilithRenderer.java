package com.medicenjona.entity.client;

import com.medicenjona.UltraHardcore;
import com.medicenjona.entity.custom.EnderClamEntity;
import com.medicenjona.entity.custom.LilithEntity;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import mod.azure.azurelib.renderer.layer.AutoGlowingGeoLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class LilithRenderer extends GeoEntityRenderer<LilithEntity> {
    public LilithRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new LilithModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

   /* @Override
    public Identifier getTextureLocation(LilithEntity animatable) {
        return new Identifier(UltraHardcore.MOD_ID, "textures/entity/lilith.png");
    }

    @Override
    public void render(LilithEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }*/
}
