package com.foxdev.kitpvp.kits.abilitys;

import com.foxdev.kitpvp.KitPvp;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class AbilityListener implements Listener {


    private HashMap<UUID, Long> cooldowns = new HashMap<>();

    private KitPvp main;

    public AbilityListener(KitPvp main){
        this.main = main;
    }


    @EventHandler
    public void onRightBlaze(PlayerInteractEvent event) {
        Player player = event.getPlayer();


        if (player.getInventory().getItemInMainHand().getType() == Material.BLAZE_ROD) {

            if (!isOnCooldown(player)) {

                player.getWorld().strikeLightning(player.getTargetBlock(null, 100).getLocation());
            }

            startCooldown(player, 3);

        }
    }

    private boolean isOnCooldown(Player player) {
        UUID id = player.getUniqueId();
        return cooldowns.containsKey(id) && cooldowns.get(id) > System.currentTimeMillis();
    }

    private void startCooldown(Player player, int seconds) {

        UUID id = player.getUniqueId();
        cooldowns.put(id, System.currentTimeMillis() + (seconds * 1000));


        new BukkitRunnable() {
            @Override
            public void run() {
                cooldowns.remove(id);
            }
        }.runTaskLater(main, seconds * 20);

    }
}
