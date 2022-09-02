package de.titus.polizeiwache.utils;

import de.titus.polizeiwache.itembuilder.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class UtilsCommand implements CommandExecutor {

    public static Inventory op_utils = Bukkit.createInventory(null, 5 * 9, "§5Utils");

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if (player.hasPermission("core.utils")) {
            op_utils.setItem(10, new ItemBuilder(Material.COMMAND_BLOCK).setDisplayname("§7Gamemode:").setLocalizedName("gamemode").build());
            op_utils.setItem(12, new ItemBuilder(Material.GHAST_TEAR).setDisplayname("§7Vanish:").setLocalizedName("vanish").build());
            op_utils.setItem(14, new ItemBuilder(Material.FEATHER).setDisplayname("§7Fly:").setLocalizedName("fly").build());
            op_utils.setItem(16, new ItemBuilder(Material.GOLDEN_CARROT).setDisplayname("§7Heal:").setLocalizedName("heal").build());
            op_utils.setItem(28, new ItemBuilder(Material.IRON_PICKAXE).setDisplayname("§7Challenges:").setLocalizedName("challenge").build());
            op_utils.setItem(30, new ItemBuilder(Material.GOLDEN_CARROT).setDisplayname("§7Timer").setLocalizedName("timer").build());
            player.openInventory(op_utils);
        }
        return false;
    }
}