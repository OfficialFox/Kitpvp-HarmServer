package com.foxdev.kitpvp.kits.abilitys;

import com.foxdev.kitpvp.KitPvp;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class AbilityListener implements Listener {


    private HashMap<UUID, Long> cooldowns = new HashMap<>();

    private KitPvp main;

    public AbilityListener(KitPvp main) {
        this.main = main;
    }


    @EventHandler
    public void sunFlowerPOWER(PlayerInteractEvent event) {

        Player player = event.getPlayer();


        if (player.getInventory().getItemInMainHand().getType() == Material.SUNFLOWER) {

            if (!isOnCooldown(player)) {

                LivingEntity target = getTargetEntity(player, 5);

                if(target != null){

                    target.setVelocity(player.getLocation().getDirection().multiply(5));

                    target.damage(5);

            }


        }

        startCooldown(player, 3);

    }

}

    private LivingEntity getTargetEntity(Player player, int maxDistance) {
        List<Entity> nearby = player.getNearbyEntities(maxDistance, maxDistance, maxDistance);
        for(Entity e : nearby) {
            if(e instanceof LivingEntity) {
                return (LivingEntity) e;
            }
        }
        return null;
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
