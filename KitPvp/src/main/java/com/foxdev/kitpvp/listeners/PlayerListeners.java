package com.foxdev.kitpvp.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerListeners implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (event.getPlayer().hasPlayedBefore()) {
            Player player = event.getPlayer();
            player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(1.6);
            player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(4);


        } else {
            Bukkit.broadcastMessage("WELCOME " + event.getPlayer().getName());
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Player killer = player.getKiller();

        if(killer != null){
            killer.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 1));

        }

        player.getInventory().clear();

        event.setDroppedExp(0);
        event.getDrops().clear();
        event.setKeepInventory(true);
        event.setKeepLevel(true);


    }

}
