package com.gasthiiml.halloween.events;

import com.gasthiiml.halloween.Halloween;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

@SuppressWarnings("ALL")
public class BlockPlaceEvent implements Listener {

    private Halloween plugin;

    public BlockPlaceEvent(Halloween plg) {
        plugin = plg;
    }

    @EventHandler
    public void onBlockPlace(org.bukkit.event.block.BlockPlaceEvent e) {
        if(e.getBlockPlaced().getType().equals(Material.SKULL_ITEM)) {
            e.setCancelled(true);
        }
        else return;
    }
}
