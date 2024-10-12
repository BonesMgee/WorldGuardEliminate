package com.jacobson.worldguardeliminate;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class WorldGuardEliminate extends JavaPlugin implements Listener {

    private ProtectedRegion region;
    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        String worldName = getConfig().getString("World");
        String regionName = getConfig().getString("Region");
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionManager regionManager = container.get(BukkitAdapter.adapt(Objects.requireNonNull(Bukkit.getWorld(worldName))));
        region = regionManager.getRegion(regionName);
        if(region != null) {
            getServer().getPluginManager().registerEvents(this,this);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    private void EntityTargetHandler(EntityTargetLivingEntityEvent event) {
        if (region.contains(BukkitAdapter.asBlockVector(event.getEntity().getLocation()))) {
            event.getEntity().remove();
        }
    }
}
