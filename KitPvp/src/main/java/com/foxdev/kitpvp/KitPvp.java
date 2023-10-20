package com.foxdev.kitpvp;

import com.foxdev.kitpvp.kits.abilitys.AbilityListener;
import com.foxdev.kitpvp.kits.starterskit;
import com.foxdev.kitpvp.listeners.PlayerListeners;
import com.foxdev.kitpvp.npc.command.StartersSpawner;
import com.foxdev.kitpvp.npc.startervillager;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class KitPvp extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerListeners(), this);
        getServer().getPluginManager().registerEvents(new startervillager(), this);
        getCommand("starters").setExecutor(new starterskit());
        getCommand("startersnpc").setExecutor(new StartersSpawner());


        //Ability Listener
        getServer().getPluginManager().registerEvents(new AbilityListener(this), this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
