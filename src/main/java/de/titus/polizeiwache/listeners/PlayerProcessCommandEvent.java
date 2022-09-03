package de.titus.polizeiwache.listeners;

import de.titus.polizeiwache.Polizeiwache;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerProcessCommandEvent implements Listener {

    @EventHandler
    public void onPreProcess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();

        if (event.getMessage().contains("plugins")) {
            player.sendMessage(Polizeiwache.getSyntaxError() + "§7Dein TV-Gerät wurde Erfolgreich mit Viren infiziert.");
            event.setCancelled(true);
        }
        if (event.getMessage().contains("pl")) {
            player.sendMessage(Polizeiwache.getSyntaxError() + "§7Dein TV-Gerät wurde Erfolgreich mit Viren infiziert.");
            event.setCancelled(true);
        }
        if (event.getMessage().contains("ver")) {
            player.sendMessage(Polizeiwache.getSyntaxError() + "§7Dein TV-Gerät wurde Erfolgreich mit Viren infiziert.");
            event.setCancelled(true);
        }

    }
}
