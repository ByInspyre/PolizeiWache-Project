package de.titus.polizeiwache.challenges;

import de.titus.polizeiwache.listeners.InventoryListener;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class NoSneakListener implements Listener {

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {
            Player player = event.getPlayer();
            Bukkit.getOnlinePlayers().forEach(player1 -> player.setGameMode(GameMode.SPECTATOR));
            Bukkit.getOnlinePlayers().forEach(player1 -> player.sendTitle("§cIhr habt versagt!", "§c" + event.getPlayer().getName() + " hat gesneakt!"));

    }
}
