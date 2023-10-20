package com.foxdev.kitpvp.npc;

import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class startervillager implements Listener {

    @EventHandler
    public void onVillagerInteract(PlayerInteractEntityEvent event){
        if(event.getRightClicked() instanceof Villager){
            Villager villager = (Villager) event.getRightClicked();

            event.getPlayer().performCommand("starters");
//-=
            villager.setAI(false);
            event.setCancelled(true);
        }
    }
}
