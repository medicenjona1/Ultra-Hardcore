package com.medicenjona.items;

import com.medicenjona.UltraHardcore;
import com.medicenjona.entity.ModEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item TIGER_SPAWN_EGG = registerItem("tiger_spawn_egg",
            new SpawnEggItem(ModEntities.TIGER, 0xD57E36, 0x1D0D00,
                    new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(UltraHardcore.MOD_ID, name), item);
    }
    public static void registerModItems() {
        UltraHardcore.LOGGER.info("Registering Mod Items for " + UltraHardcore.MOD_ID);

    }
}
