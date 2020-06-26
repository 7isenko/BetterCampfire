package io.github._7isenko.bettercampfire;

import org.bukkit.Bukkit;
import org.bukkit.inventory.CampfireRecipe;
import org.bukkit.inventory.FurnaceRecipe;

public class CampfireRecipeTranslator {
    public static void addAll() {
        Bukkit.getServer().recipeIterator().forEachRemaining(recipe -> {
            if (recipe instanceof FurnaceRecipe) {
                try {
                    Bukkit.getServer().addRecipe(cast((FurnaceRecipe) recipe));
                } catch (IllegalArgumentException e) {
                    // shit happens lmao
                }
            }
        });
    }

    private static CampfireRecipe cast(FurnaceRecipe furnaceRecipe) {
        return new CampfireRecipe(furnaceRecipe.getKey(), furnaceRecipe.getResult(), furnaceRecipe.getInput().getType(), furnaceRecipe.getExperience(), furnaceRecipe.getCookingTime() * 3);
    }

}
