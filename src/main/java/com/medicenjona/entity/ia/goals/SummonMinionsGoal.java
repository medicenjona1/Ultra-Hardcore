package com.medicenjona.entity.ia.goals;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.world.ServerWorld;

import java.util.EnumSet;

public class SummonMinionsGoal extends Goal {
    private final MobEntity bossEntity;
    private boolean hasSummoned = false;

    public SummonMinionsGoal(MobEntity bossEntity) {
        this.bossEntity = bossEntity;
        this.setControls(EnumSet.of(Control.MOVE, Control.TARGET));
    }


    @Override
    public boolean canStart() {
        return !hasSummoned && bossEntity.getHealth() <= bossEntity.getMaxHealth() * 0.2;

    }

    @Override
    public void start() {
        if (bossEntity.getWorld() instanceof ServerWorld serverWorld) {
            summonMobs(serverWorld);
            hasSummoned = true;
        }

    }
    private void summonMobs(ServerWorld world) {
        for (int i = 0; i < 3; i ++) {
            EntityType.ZOMBIE.spawn(world, null, null,
                    bossEntity.getBlockPos().add(world.random.nextBetween(-3, 3), 0, world.random.nextBetween(-3, 3)), SpawnReason.EVENT, true, false
            );
        }


    }
}
