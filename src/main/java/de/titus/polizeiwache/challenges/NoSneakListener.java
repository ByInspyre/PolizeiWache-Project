package de.titus.polizeiwache.challenges;

import de.titus.polizeiwache.listeners.InventoryListener;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class NoSneakListener implements Listener {

    boolean nosneak = InventoryListener.nosneak;

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {
        if(nosneak) {
            for (Player player: Bukkit.getOnlinePlayers()) {
                player.sendTitle("§c" + event.getPlayer().getName(), "§cIst gesneakt!");
                player.setGameMode(GameMode.SPECTATOR);
                nosneak = false;
            }
        }
    }
}
