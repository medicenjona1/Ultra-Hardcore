package com.medicenjona;

import com.medicenjona.entity.ModEntities;
import com.medicenjona.entity.client.TigerRenderer;
import com.medicenjona.entity.custom.EnderClamEntity;
import com.medicenjona.entity.custom.LilithEntity;
import com.medicenjona.entity.custom.TigerEntity;
import com.medicenjona.utils.DiffControl;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UltraHardcore implements ModInitializer {


	public static final String MOD_ID = "ultra-hardcore";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		/*
		* @Override
public void onInitialize() {
    CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
        dispatcher.register(CommandManager.literal("diff")
            .then(CommandManager.argument("target", StringArgumentType.word())
                .then(CommandManager.argument("state", BoolArgumentType.bool())
                    .executes(context -> {
                        String target = StringArgumentType.getString(context, "target");
                        boolean state = BoolArgumentType.getBool(context, "state");

                        if ("bill".equals(target)) {
                            MixinControl.ENABLE_CUSTOM_GOAL = state;
                            context.getSource().sendFeedback(Text.literal("Custom goal for Villager set to: " + state));
                        } else {
                            context.getSource().sendFeedback(Text.literal("Invalid target: " + target), false);
                        }
                        return 1;
                    }))));
    });
}

		*
		*
		* */

		FabricDefaultAttributeRegistry.register(ModEntities.TIGER, TigerEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.ERDERCLAM, EnderClamEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.LILITH, LilithEntity.setAttributes());


		//CMDS
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated, environment) -> {
			dispatcher.register(CommandManager.literal("diff")
					.then(CommandManager.argument("target", StringArgumentType.word())
							.then(CommandManager.argument("state", BoolArgumentType.bool())
									.executes(context -> {
										String target = StringArgumentType.getString(context, "target");
										boolean state = BoolArgumentType.getBool(context, "state");

										if ("bill".equals(target)) {
											DiffControl.ENABLE_CUSTOM_GOAL = state;
											context.getSource().sendFeedback(() -> Text.literal("Custom goal for Villager set to: " + state), false);
										} else {
											context.getSource().sendFeedback(() -> Text.literal("Invalid target: " + target), false);
										}
										return 1;
									})
							)
					)
			);
		});



		//EntityRendererRegistry.register(ModEntities.TIGER, TigerRenderer::new);



		LOGGER.info("Hello Fabric world!");
	}
}