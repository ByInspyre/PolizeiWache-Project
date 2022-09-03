package de.titus.polizeiwache.commands;

import de.titus.polizeiwache.itembuilder.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class CmdCommand implements CommandExecutor {

    public static Inventory commands = Bukkit.createInventory(null, 4*9, "§7Commands:");

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;

        commands.setItem(1, new ItemBuilder(Material.BOOK).setDisplayname("§b/Discord").setLore("Sendet dir einen Link zu unserem Discord").build());
        player.openInventory(commands);
        return false;
    }
}
