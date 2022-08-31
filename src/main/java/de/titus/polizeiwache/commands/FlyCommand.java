package de.titus.polizeiwache.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("core.fly")) {
                if(!player.isFlying()) {
                    player.setAllowFlight(true);
                    player.setFlying(true);
                } else if(player.isFlying()) {
                    player.setFlying(false);
                    player.setAllowFlight(false);
                }
            }
        }

        return false;
    }
}
