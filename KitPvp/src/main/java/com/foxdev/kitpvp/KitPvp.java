package com.foxdev.kitpvp;

import com.foxdev.kitpvp.kits.ProKit;
import com.foxdev.kitpvp.kits.abilitys.AbilityListener;
import com.foxdev.kitpvp.listeners.PlayerListeners;
import com.foxdev.kitpvp.npc.ProVillager;
import com.foxdev.kitpvp.npc.command.ProNpc;
import org.bukkit.plugin.java.JavaPlugin;

public final class KitPvp extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerListeners(), this);
        getServer().getPluginManager().registerEvents(new ProVillager(), this);
        getCommand("prokit").setExecutor(new ProKit());
        getCommand("pronpc").setExecutor(new ProNpc());


        //Ability Listener
        getServer().getPluginManager().registerEvents(new AbilityListener(this), this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
