package de.titus.polizeiwache.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("core.vanish")) {
                if(!player.isInvisible()) {
                    player.setInvisible(true);
                } else if(player.isInvisible()) {
                    player.setInvisible(false);
                }
            }
        }

        return false;
    }
}
