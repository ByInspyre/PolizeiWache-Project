package de.titus.polizeiwache.commands;

import de.titus.polizeiwache.Polizeiwache;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NoJumpCommand implements CommandExecutor {

    public static boolean nojump = Polizeiwache.nojump;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(!nojump) {
                nojump = true;
            } else {
                nojump = false;
            }
        }

        return false;
    }
}
