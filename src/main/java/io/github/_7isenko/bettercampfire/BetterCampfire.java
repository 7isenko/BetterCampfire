package io.github._7isenko.bettercampfire;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class BetterCampfire extends JavaPlugin {
    // How to build: Maven/BetterCampfire/Lifecycle/package
    public static FileConfiguration config;
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        config = this.getConfig();

        // Add campfire recipes
        CampfireRecipeTranslator.addAll();

        // For campfire usage
        this.getServer().getPluginManager().registerEvents(new InteractionListener(), this);


    }

    @Override
    public void onDisable() {
        getLogger().info("Visit my github page https://github.com/7isenko");
    }
}