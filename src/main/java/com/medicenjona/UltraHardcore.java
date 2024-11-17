package com.medicenjona;

import com.medicenjona.commands.UltraHardcoreCommand;
import com.medicenjona.entity.ModEntities;
import com.medicenjona.entity.client.TigerRenderer;
import com.medicenjona.entity.custom.EnderClamEntity;
import com.medicenjona.entity.custom.LilithEntity;
import com.medicenjona.entity.custom.TigerEntity;
import com.medicenjona.utils.ConfigManager;
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

		FabricDefaultAttributeRegistry.register(ModEntities.TIGER, TigerEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.ERDERCLAM, EnderClamEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.LILITH, LilithEntity.setAttributes());


		//CMDS
		CommandRegistrationCallback.EVENT.register(((commandDispatcher, commandRegistryAccess, registrationEnvironment) ->
				UltraHardcoreCommand.registerCOmmands(commandDispatcher)
		));
		boolean initialState = ConfigManager.loadCongif();
		//UltraHardcoreCommand.villagerDifficulty(initialState); adadadad




		//EntityRendererRegistry.register(ModEntities.TIGER, TigerRenderer::new);



		LOGGER.info("Hello Fabric world!");
	}
}