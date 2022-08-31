package de.titus.polizeiwache.challenges;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import de.titus.polizeiwache.listeners.InventoryListener;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class NoJumpListener implements Listener {

    boolean nojump = InventoryListener.nojump;

    @EventHandler
    public void onJump(PlayerJumpEvent event) {
        if(nojump) {
            for (Player player: Bukkit.getOnlinePlayers()) {
                player.sendTitle("§c" + event.getPlayer().getName(), "§cIst gesprungen!");
                player.setGameMode(GameMode.SPECTATOR);
                nojump = false;
            }
        }
    }
}
