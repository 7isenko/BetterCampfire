package io.github._7isenko.bettercampfire;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Campfire;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class InteractionListener implements Listener {
    private static int cookingTicks = BetterCampfire.config.getInt("cookingTime") * 20;

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Block block = event.getClickedBlock();

        if (block != null && block.getType() == Material.CAMPFIRE && event.getMaterial() != Material.AIR && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            event.setCancelled(true);
            Campfire campfire = (Campfire) block.getState();
            for (int i = 0; i < 4; i++) {
                if (campfire.getItem(i) != null)
                    continue;
                ItemStack is = event.getItem().clone();
                is.setAmount(1);
                campfire.setItem(i, is);
                campfire.setCookTime(i, 0);
                campfire.setCookTimeTotal(i, cookingTicks);
                campfire.update();
                event.getItem().setAmount(event.getItem().getAmount() - 1);
                break;
            }

        }
    }
}
