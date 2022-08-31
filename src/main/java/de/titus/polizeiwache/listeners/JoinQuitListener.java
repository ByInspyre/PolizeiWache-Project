package de.titus.polizeiwache.listeners;

import de.titus.polizeiwache.Polizeiwache;
import de.titus.polizeiwache.scoreboard.TestScoreboard;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.DARK_GRAY + "[" + "§a+" + ChatColor.DARK_GRAY + "]" + "§9 " + event.getPlayer().getName());

        new TestScoreboard(player);

        Polizeiwache.getInstance().getTablistManager().setPlayerList(player);
        Polizeiwache.getInstance().getTablistManager().setAllPlayerTeams();
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        event.setQuitMessage(ChatColor.DARK_GRAY + "[" + "§c-" + ChatColor.DARK_GRAY + "]" + "§9 " + event.getPlayer().getName());
    }
}
