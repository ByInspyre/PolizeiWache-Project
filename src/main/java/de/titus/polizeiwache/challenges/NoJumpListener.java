package de.titus.polizeiwache.challenges;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import de.titus.polizeiwache.listeners.InventoryListener;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class NoJumpListener implements Listener {

    boolean nojump_start = InventoryListener.nojump_start;
    boolean nojump_stop = InventoryListener.nojump_stop;

    @EventHandler
    public void onJump(PlayerJumpEvent event) {
        if(nojump_start && !nojump_stop) {
            Player player = event.getPlayer();
            Bukkit.getOnlinePlayers().forEach(player1 -> player.setGameMode(GameMode.SPECTATOR));
            Bukkit.getOnlinePlayers().forEach(player1 -> player.sendTitle("§cIhr habt versagt!", "§c" + event.getPlayer().getName() + " ist gesprungen"));
        }
    }
}
