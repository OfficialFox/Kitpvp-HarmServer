package com.foxdev.kitpvp.npc;

import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class ProVillager implements Listener {
    @EventHandler

    public void onVillagerInteract(PlayerInteractEntityEvent event) {

        Player player = event.getPlayer();


        if (event.getRightClicked() instanceof Villager) {
            Villager villager = (Villager) event.getRightClicked();

            player.performCommand("prokit");

            villager.setAI(false);
            event.setCancelled(true);

        }
    }

}
