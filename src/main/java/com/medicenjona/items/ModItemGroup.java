package com.medicenjona.items;

import com.medicenjona.UltraHardcore;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup ADMINS = Registry.register(Registries.ITEM_GROUP, new Identifier(UltraHardcore.MOD_ID, "admins"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.admins"))
                    .icon(() -> new ItemStack(ModItems.TIGER_SPAWN_EGG)).entries((displayContext, entries) -> {

                        entries.add(ModItems.TIGER_SPAWN_EGG);

                    }).build());

    public static void registerItemGroups() {
        // Example of adding to existing Item Group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.TIGER_SPAWN_EGG);

        });
    }
}
