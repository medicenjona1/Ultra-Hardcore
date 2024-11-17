package com.medicenjona.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigManager {
    private static final File CONFIG_FILE = new File("config/hardcore.json");

    private static final Gson GSON = new Gson();

    public static void saveConfig(boolean state) {
        try {
            JsonObject config = new JsonObject();
            config.addProperty("villagerDifficulty", state);
            FileWriter writer = new FileWriter(CONFIG_FILE);
                GSON.toJson(config, writer);
                writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean loadCongif() {
        if (!CONFIG_FILE.exists()) {
            return false;
        }
        try {
            FileReader reader = new FileReader(CONFIG_FILE);
            JsonObject config = GSON.fromJson(reader, JsonObject.class);
            return config.get("villagerDifficulty").getAsBoolean();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
