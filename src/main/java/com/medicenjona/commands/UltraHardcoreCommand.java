package com.medicenjona.commands;

import com.medicenjona.utils.ConfigManager;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class UltraHardcoreCommand {
    public static boolean villagerDifficulty = false;

    public  static void registerCOmmands(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("diff")
                .then(CommandManager.literal("villagers"))
                .then(CommandManager.argument("state", BoolArgumentType.bool()).executes(context -> {
                            boolean state = BoolArgumentType.getBool(context, "state");
                        ConfigManager.saveConfig(state);
                    context.getSource().sendFeedback(() -> Text.literal("Custom goal for Villager set to: " + state), true);
                    villagerDifficulty = state;


                    return 1;
                }))
        );



    }


}
