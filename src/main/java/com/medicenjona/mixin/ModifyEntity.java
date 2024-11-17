package com.medicenjona.mixin;


import com.medicenjona.commands.UltraHardcoreCommand;
import com.medicenjona.utils.DiffControl;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VillagerEntity.class)
public abstract class ModifyEntity extends PassiveEntity {
    protected ModifyEntity(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
    }
    @Inject(method = "createVillagerAttributes",
            at = @At("RETURN"), cancellable = false)
    private static void addAttackDamageAttribute(CallbackInfoReturnable<DefaultAttributeContainer.Builder> info){
        DefaultAttributeContainer.Builder attributes = info.getReturnValue();

        attributes.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0f);
        attributes.add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f);


    }


    @Inject(method = "<init>",
            at= @At("TAIL"))
    private void addCustomGoals(CallbackInfo info) {
        if(UltraHardcoreCommand.villagerDifficulty) {

            this.goalSelector.add(1, new SwimGoal(this));
            this.goalSelector.add(2, new MeleeAttackGoal(this, 1.2D, false));
            this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.75f, 1));

            this.goalSelector.add(4, new LookAroundGoal(this));

            //this.setCustomName(1, "test");
            this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
            this.targetSelector.add(2, new ActiveTargetGoal<>(this, MerchantEntity.class, true));
            this.targetSelector.add(3, new ActiveTargetGoal<>(this, ChickenEntity.class, true));
        } /*else {
            this.goalSelector.add();
        }*/


    }
}
