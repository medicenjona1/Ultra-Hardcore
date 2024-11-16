package com.medicenjona.entity.client;

import com.medicenjona.UltraHardcore;
import com.medicenjona.entity.custom.TigerEntity;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animatable.model.CoreGeoBone;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.model.data.EntityModelData;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;


public class TigerModel extends GeoModel<TigerEntity> {
    @Override
    public Identifier getModelResource(TigerEntity animatable) {
        return new Identifier(UltraHardcore.MOD_ID, "geo/tiger.geo.json");
    }

    @Override
    public Identifier getTextureResource(TigerEntity animatable) {
        return new Identifier(UltraHardcore.MOD_ID, "textures/entity/tiger.png");
    }

    @Override
    public Identifier getAnimationResource(TigerEntity animatable) {
        return new Identifier(UltraHardcore.MOD_ID, "animations/tiger.animation.json");
    }

    @Override
    public void setCustomAnimations(TigerEntity animatable, long instanceId, AnimationState<TigerEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
