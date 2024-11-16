package com.medicenjona;

import com.medicenjona.entity.ModEntities;
import com.medicenjona.entity.client.EnderClamRenderer;
import com.medicenjona.entity.client.LilithRenderer;
import com.medicenjona.entity.client.TigerRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class UltraHardcoreClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.TIGER, TigerRenderer::new);
        EntityRendererRegistry.register(ModEntities.ERDERCLAM, EnderClamRenderer::new);
        EntityRendererRegistry.register(ModEntities.LILITH, LilithRenderer::new);


    }
}
