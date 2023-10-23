package com.foxdev.kitpvp.kits;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class ProKit implements CommandExecutor {
    private Map<Player, Long> cooldowns = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Only players!");
            return true;
        }

        Player player = (Player) commandSender;


        if(cooldowns.containsKey(player) && System.currentTimeMillis() - cooldowns.get(player) < 10000){
            player.sendMessage("Nog minder dan 1 minuut kunt u weer de kit claimen,");

            return true;
        }

        player.getInventory().setItem(0, new ItemStack(Material.DIAMOND_SWORD, 1));
        player.getInventory().setItem(3, new ItemStack(Material.DIAMOND_AXE, 1));
        player.getInventory().setItem(2, new ItemStack(Material.SUNFLOWER, 1));
        player.getInventory().setItem(7, new ItemStack(Material.BREAD, 20));
        player.getInventory().setItem(8, new ItemStack(Material.GOLDEN_APPLE, 6));
        player.getInventory().setItem(1, new ItemStack(Material.BOW, 1));
        player.getInventory().setItem(9, new ItemStack(Material.ARROW, 64));

        player.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
        player.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
        player.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
        player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
        player.getInventory().setItemInOffHand(new ItemStack(Material.SHIELD, 1));


        cooldowns.put(player, System.currentTimeMillis());

        return true;
    }
}