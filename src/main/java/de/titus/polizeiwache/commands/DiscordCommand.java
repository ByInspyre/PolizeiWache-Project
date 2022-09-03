package de.titus.polizeiwache.commands;

import de.titus.polizeiwache.Polizeiwache;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DiscordCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        player.sendMessage(Polizeiwache.getPrefix() + ChatColor.GRAY + "https://discord.gg/Xa5wnKQnKA");
        return false;
    }
}
