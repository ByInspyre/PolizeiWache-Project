package de.titus.polizeiwache.challenges;

import de.titus.polizeiwache.listeners.InventoryListener;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class IceListener implements Listener {
    boolean ice = InventoryListener.ice;


    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if(ice) {
            Player player = event.getPlayer();
            Block block = player.getLocation().subtract(0, 1, 0).getBlock();
            block.setType(Material.ICE);
            block.getRelative(0, 0, 1).setType(Material.ICE);
            block.getRelative(0, 0, 2).setType(Material.ICE);

            block.getRelative(1, 0, 0).setType(Material.ICE);
            block.getRelative(2, 0, 0).setType(Material.ICE);

            block.getRelative(1, 0, 1).setType(Material.ICE);
            block.getRelative(1, 0, 2).setType(Material.ICE);
            block.getRelative(2, 0, 1).setType(Material.ICE);
            block.getRelative(2, 0, 2).setType(Material.ICE);

            block.getRelative(-1, 0, -1).setType(Material.ICE);
            block.getRelative(-1, 0, -2).setType(Material.ICE);
            block.getRelative(-2, 0, -1).setType(Material.ICE);
            block.getRelative(-2, 0, -2).setType(Material.ICE);
        }
    }
}
