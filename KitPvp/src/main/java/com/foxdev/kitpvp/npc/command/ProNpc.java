package com.foxdev.kitpvp.npc.command;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

public class ProNpc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        Player player = (Player) sender;
        Location loc = player.getLocation();

        Villager villager = loc.getWorld().spawn(loc, Villager.class);


        villager.setAI(false);
        villager.setPersistent(true);
        villager.setInvulnerable(true);
        villager.setCollidable(false);
        villager.setNoDamageTicks(Integer.MAX_VALUE);

        villager.setCustomName("Pro Villager");

        return true;
    }
}