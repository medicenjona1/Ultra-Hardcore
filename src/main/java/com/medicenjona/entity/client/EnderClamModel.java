package com.medicenjona.entity.client;

import com.medicenjona.UltraHardcore;
import com.medicenjona.entity.custom.EnderClamEntity;
import com.medicenjona.entity.custom.TigerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EnderClamModel extends GeoModel<EnderClamEntity> {
    @Override
    public Identifier getModelResource(EnderClamEntity animatable) {
        return new Identifier(UltraHardcore.MOD_ID, "geo/ender_clam.geo.json");
    }

    @Override
    public Identifier getTextureResource(EnderClamEntity animatable) {
        return new Identifier(UltraHardcore.MOD_ID, "textures/entity/ender_clam.png");
    }

    @Override
    public Identifier getAnimationResource(EnderClamEntity animatable) {
        return new Identifier(UltraHardcore.MOD_ID, "animations/ender_clam.animation.json");
    }

    @Override
    public void setCustomAnimations(EnderClamEntity animatable, long instanceId, AnimationState<EnderClamEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}