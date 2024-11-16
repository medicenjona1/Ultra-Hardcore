package com.medicenjona.entity.client;

import com.medicenjona.UltraHardcore;
import com.medicenjona.entity.custom.EnderClamEntity;
import com.medicenjona.entity.custom.LilithEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animatable.model.CoreGeoBone;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.model.data.EntityModelData;

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


}
