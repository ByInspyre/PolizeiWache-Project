package de.titus.polizeiwache.tablist;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TablistManager {

    public void setPlayerList(Player player) {
        player.setPlayerListHeaderFooter("§9Polizei§fWache\n", "\n§9Plugin by §eTitus#0420");
    }

    public void setAllPlayerTeams() {
        Bukkit.getOnlinePlayers().forEach(this::setPlayerTeams);
    }

    public void setPlayerTeams(Player player) {
        Scoreboard scoreboard = player.getScoreboard();

        Team admins = scoreboard.getTeam("0001admins");
        if(admins == null) {
            admins = scoreboard.registerNewTeam("0001admins");
        }

        Team moderators = scoreboard.getTeam("0010moderators");
        if(moderators == null) {
            moderators = scoreboard.registerNewTeam("0010moderators");
        }

        Team supporters = scoreboard.getTeam("0100Developers");
        if(supporters == null) {
            supporters = scoreboard.registerNewTeam("0100Developers");
        }

        Team players = scoreboard.getTeam("1000players");
        if(players == null) {
            players = scoreboard.registerNewTeam("1000players");
        }

        admins.setPrefix(ChatColor.DARK_RED + "Admin " + ChatColor.DARK_GRAY + "| ");
        admins.setColor(ChatColor.DARK_RED);

        moderators.setPrefix(ChatColor.BLUE + "Mod " + ChatColor.DARK_GRAY + "| ");
        moderators.setColor(ChatColor.BLUE);

        supporters.setPrefix(ChatColor.AQUA + "Dev " + ChatColor.DARK_GRAY + "| ");
        supporters.setColor(ChatColor.AQUA);

        players.setPrefix(ChatColor.GREEN + "Player " + ChatColor.DARK_GRAY + "| ");
        players.setColor(ChatColor.GREEN);

        for (Player target: Bukkit.getOnlinePlayers()) {
            if(target.hasPermission("core.admin")) {
                admins.addEntry(target.getName());
                continue;
            } else if(target.hasPermission("core.moderator")) {
                moderators.addEntry(target.getName());
                continue;
            } else if(target.hasPermission("core.developer")) {
                supporters.addEntry(target.getName());
                continue;
            }

            players.addEntry(target.getName());
        }

    }

}
