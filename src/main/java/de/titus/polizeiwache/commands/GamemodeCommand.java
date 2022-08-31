package de.titus.polizeiwache.commands;

import de.titus.polizeiwache.Polizeiwache;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("core.gamemode")) {
                if(args.length > 0) {
                    switch(args[0]) {
                        case "0":
                            player.setGameMode(GameMode.SURVIVAL);
                            player.sendMessage(Polizeiwache.getPrefix() + "§7Du bist jetzt in §eSURVIVAL");
                            break;
                        case "1":
                            player.setGameMode(GameMode.CREATIVE);
                            player.sendMessage(Polizeiwache.getPrefix() + "§7Du bist jetzt in §eCREATIVE");
                            break;
                        case "2":
                            player.setGameMode(GameMode.SPECTATOR);
                            player.sendMessage(Polizeiwache.getPrefix() + "§7Du bist jetzt in §eSPECTATOR");
                            break;
                        case "3":
                            player.setGameMode(GameMode.ADVENTURE);
                            player.sendMessage(Polizeiwache.getPrefix() + "§7Du bist jetzt in §eADVENTURE");
                            break;
                    }
                }
            } else {
                player.sendMessage(Polizeiwache.getSyntaxError() + "§cInsufficient Permission!");
            }
        }

        return false;
    }
}
