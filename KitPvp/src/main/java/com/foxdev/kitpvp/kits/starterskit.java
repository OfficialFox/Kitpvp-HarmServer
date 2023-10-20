package com.foxdev.kitpvp.kits;

import com.sun.tools.javac.jvm.Items;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class starterskit implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Only players!");
            return true;
        }

        Player player = (Player) commandSender;


        player.getInventory().setItem(0, new ItemStack(Material.IRON_SWORD, 1));
        player.getInventory().setItem(9, new ItemStack(Material.BREAD, 8));
        player.getInventory().setItem(8, new ItemStack(Material.GOLDEN_APPLE, 3));
        player.getInventory().setItem(1, new ItemStack(Material.BOW, 1));

        player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
        player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
        player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
        player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
        player.getInventory().setItemInOffHand(new ItemStack(Material.SHIELD, 1));


        return true;
    }
}
