package com.medicenjona.entity.custom;

import com.medicenjona.entity.ModEntities;
import com.medicenjona.entity.ia.goals.SummonMinionsGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.tslat.smartbrainlib.api.SmartBrainOwner;
import net.tslat.smartbrainlib.api.core.SmartBrain;
import org.jetbrains.annotations.Nullable;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.*;
import mod.azure.azurelib.core.object.PlayState;
import mod.azure.azurelib.util.AzureLibUtil;

public class LilithEntity extends AnimalEntity implements GeoEntity{
    private AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    public LilithEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 16.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f);
    }

    @Override
    protected void initGoals() {
        //this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.add(8, new SummonMinionsGoal(this));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.75f, 1));
        this.goalSelector.add(4, new LookAroundGoal(this));



        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        //this.targetSelector.add(2, new ActiveTargetGoal<>(this, MerchantEntity.class, true));
        //this.targetSelector.add(3, new ActiveTargetGoal<>(this, ChickenEntity.class, true));
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.LILITH.create(world);
    }

    private PlayState predicate(AnimationState tAnimationState) {
        if(tAnimationState.isMoving()) {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;


        } else if (this.handSwinging && tAnimationState.getController().getAnimationState().equals(AnimationController.State.STOPPED))
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("pet", Animation.LoopType.PLAY_ONCE));
        this.handSwinging = false;
if (this.dead && tAnimationState.getController().getAnimationState().equals(AnimationController.State.STOPPED)){
    tAnimationState.getController().setAnimation(RawAnimation.begin().then("run", Animation.LoopType.LOOP));
    this.handSwinging = false;

}

        tAnimationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(
                new AnimationController<>(this, "idle", event -> PlayState.CONTINUE)
                        .triggerableAnim("death", RawAnimation.begin().thenPlayAndHold("death"))

        );
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}



