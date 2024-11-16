package com.medicenjona.entity.client;

import com.medicenjona.UltraHardcore;
import com.medicenjona.entity.custom.EnderClamEntity;
import com.medicenjona.entity.custom.TigerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class EnderClamRenderer extends GeoEntityRenderer<EnderClamEntity> {
    public EnderClamRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new EnderClamModel());
    }

    @Override
    public Identifier getTextureLocation(EnderClamEntity animatable) {
        return new Identifier(UltraHardcore.MOD_ID, "textures/entity/ender_clam.png");
    }

    @Override
    public void render(EnderClamEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
