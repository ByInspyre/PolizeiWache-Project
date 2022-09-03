package de.titus.polizeiwache.scoreboard;

import de.titus.polizeiwache.Polizeiwache;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TestScoreboard extends ScoreboardBuilder{

    public int socialId;


    public TestScoreboard(Player player) {
        super(player, "   §9Polizei§fWache   ");
        socialId = 0;
        run();
    }

    @Override
    public void createScoreboard() {
        setScore(ChatColor.GRAY.toString(), 4);
        setScore("§7Dein Rang§8:", 3);
        if(player.hasPermission("core.admin")) {
            setScore("§8-§4Admin", 2);
        } else if(player.hasPermission("core.moderator")) {
            setScore("§8-§9Moderator", 2);
        } else if(player.hasPermission("core.developer")) {
            setScore("§8-§bDeveloper", 2);
        } else {
            setScore("§8-§aSpieler", 2);
        }
        setScore(ChatColor.RED.toString(), 1);
    }

    @Override
    public void update() {
    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {

                createScoreboard();
                update();

                switch(socialId) {
                    case 0:
                        setScore("§fChallenge §9Server", 0);
                        break;
                    case 1:
                        setScore("§9Polizei§fWache", 0);
                }
                socialId++;
                if(socialId > 1) {
                    socialId = 0;
                }

            }

        }.runTaskTimer(Polizeiwache.getInstance(), 100, 100);
    }
}

