package de.titus.polizeiwache.challenges;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import de.titus.polizeiwache.Polizeiwache;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public class NoJumpListener implements Listener {

    @EventHandler
    public void onJump(PlayerJumpEvent event) {
        Player player = event.getPlayer();
        Bukkit.getOnlinePlayers().forEach(player1 -> player.setGameMode(GameMode.SPECTATOR));
        Bukkit.getOnlinePlayers().forEach(player1 -> player.sendTitle("§cIhr habt versagt!", "§c" + event.getPlayer().getName() + " ist gesprungen"));
        HandlerList.unregisterAll(Polizeiwache.getInstance().noJumpListener);
    }
}
