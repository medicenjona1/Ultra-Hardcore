package com.medicenjona.entity.client;

import com.medicenjona.UltraHardcore;
import com.medicenjona.entity.custom.EnderClamEntity;
import com.medicenjona.entity.custom.LilithEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class LilithModel extends GeoModel<LilithEntity> {
    @Override
    public Identifier getModelResource(LilithEntity animatable) {
        return new Identifier(UltraHardcore.MOD_ID, "geo/lilith.geo.json");
    }

    @Override
    public Identifier getTextureResource(LilithEntity animatable) {
        return new Identifier(UltraHardcore.MOD_ID, "textures/entity/lilith.png");
    }

    @Override
    public Identifier getAnimationResource(LilithEntity animatable) {
        return new Identifier(UltraHardcore.MOD_ID, "animations/lilith.animation.json");
    }

    @Override
    public void setCustomAnimations(LilithEntity animatable, long instanceId, AnimationState<LilithEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
