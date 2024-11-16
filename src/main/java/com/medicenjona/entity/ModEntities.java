package com.medicenjona.entity;

import com.medicenjona.UltraHardcore;
import com.medicenjona.entity.custom.EnderClamEntity;
import com.medicenjona.entity.custom.LilithEntity;
import com.medicenjona.entity.custom.TigerEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<TigerEntity> TIGER = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(UltraHardcore.MOD_ID, "tiger"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TigerEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.75f)).build());


    //ender
    public static final EntityType<EnderClamEntity> ERDERCLAM = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(UltraHardcore.MOD_ID, "ender"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EnderClamEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.75f)).build());

    //lilith
    public static final EntityType<LilithEntity> LILITH = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(UltraHardcore.MOD_ID, "lilith"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, LilithEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.75f)).build());
}
