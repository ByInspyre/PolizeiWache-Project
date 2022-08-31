package de.titus.polizeiwache.listeners;

import de.titus.polizeiwache.Polizeiwache;
import de.titus.polizeiwache.itembuilder.ItemBuilder;
import de.titus.polizeiwache.utils.UtilsCommand;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;


public class InventoryListener implements Listener {

    public static boolean nojump = Polizeiwache.nojump;
    public static boolean nosneak = Polizeiwache.nosneak;
    public static boolean ice = Polizeiwache.ice;

    public static Inventory gamemode = Bukkit.createInventory(null, 3 * 9, "§5Gamemodes:");
    public static Inventory vanish = Bukkit.createInventory(null, 3*9, "§5Vanish:");
    public static Inventory fly = Bukkit.createInventory(null, 3*9, "§5Fly:");
    public static Inventory heal = Bukkit.createInventory(null, 3*9, "§5Heal:");
    public static Inventory challenge = Bukkit.createInventory(null, 5*9, "§5Challenges:");
    public static Inventory timer = Bukkit.createInventory(null, 3*9, "§5Timer:");

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        if(event.getCurrentItem() == null) return;

        //TEAM-INVS

        if(event.getView().getTitle() == "§5Utils") { //UTIL-INV
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);

            if (event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch (event.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "gamemode":
                        gamemode.setItem(10, new ItemBuilder(Material.GRASS_BLOCK).setDisplayname("§eSurvival").setLocalizedName("survival").build());
                        gamemode.setItem(12, new ItemBuilder(Material.IRON_SWORD).setDisplayname("§eCreative").setLocalizedName("creative").build());
                        gamemode.setItem(14, new ItemBuilder(Material.GHAST_TEAR).setDisplayname("§eSpectator").setLocalizedName("spectator").build());
                        gamemode.setItem(16, new ItemBuilder(Material.CARROT_ON_A_STICK).setDisplayname("§eAdventure").setLocalizedName("adventure").build());
                        player.openInventory(gamemode);
                        break;
                    case "vanish":
                        vanish.setItem(14, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).setDisplayname("§aVanish on").setLocalizedName("onvanish").build());
                        vanish.setItem(16, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayname("§cVanish off").setLocalizedName("offvanish").build());
                        player.openInventory(vanish);
                        break;
                    case "fly":
                        fly.setItem(13, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).setDisplayname("§aFly on").setLocalizedName("onfly").build());
                        fly.setItem(15, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayname("§cFly off").setLocalizedName("offfly").build());
                        player.openInventory(fly);
                        break;
                    case "heal":
                        heal.setItem(13, new ItemBuilder(Material.GOLDEN_CARROT).setDisplayname("§aHeal me").setLocalizedName("healme").build());
                        heal.setItem(15, new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname("§aHeal all").setLocalizedName("healall").build());
                        player.openInventory(heal);
                        break;
                    case "challenge":
                        challenge.setItem(10, new ItemBuilder(Material.COBWEB).setDisplayname("§aNoJump").setLore("In dieser Challenge darfst du nicht springen!").setLocalizedName("nojump").build());
                        challenge.setItem(19, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).setLocalizedName("onnojump").build());
                        challenge.setItem(28, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setLocalizedName("offnojump").build());


                        challenge.setItem(12, new ItemBuilder(Material.FEATHER).setDisplayname("§aNoSneak").setLore("In dieser Challenge darfst du nicht sneaken!").setLocalizedName("nosneak").build());
                        challenge.setItem(21, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).setLocalizedName("onnosneak").build());
                        challenge.setItem(30, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setLocalizedName("offnojump").build());

                        challenge.setItem(14, new ItemBuilder(Material.ICE).setDisplayname("§aIce").setLore("In dieser Challenge spawnt Ice unter dir!").setLocalizedName("ice").build());
                        challenge.setItem(23, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).setLocalizedName("onice").build());
                        challenge.setItem(32, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setLocalizedName("offnojump").build());

                        player.openInventory(challenge);
                        break;
                    case "timer":
                        player.openInventory(timer);
                        break;
                }
            }
        }

        if (event.getView().getTitle() == "§5Gamemodes:") {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            Inventory op_utils = UtilsCommand.op_utils;
            if (event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch (event.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "survival":
                        player.setGameMode(GameMode.SURVIVAL);
                        player.openInventory(op_utils);
                        break;
                    case "creative":
                        player.setGameMode(GameMode.CREATIVE);
                        player.openInventory(op_utils);
                        break;
                    case "spectator":
                        player.setGameMode(GameMode.SPECTATOR);
                        player.openInventory(op_utils);
                        break;
                    case "adventure":
                        player.setGameMode(GameMode.ADVENTURE);
                        player.openInventory(op_utils);
                        break;

                }
            }
        }

        if(event.getView().getTitle() == "§5Vanish:") {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            Inventory op_utils = UtilsCommand.op_utils;
            if(event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch(event.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "onvanish":
                        player.setInvisible(true);
                        player.openInventory(op_utils);
                        break;
                    case "offvanish":
                        player.setInvisible(false);
                        player.openInventory(op_utils);
                        break;
                }
            }
        }

        if(event.getView().getTitle() == "§5Fly:") {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            Inventory op_utils = UtilsCommand.op_utils;
            if(event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch(event.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "onfly":
                        player.setAllowFlight(true);
                        player.setFlying(true);
                        player.openInventory(op_utils);
                        break;
                    case "offfly":
                        player.setAllowFlight(false);
                        player.setFlying(false);
                        player.openInventory(op_utils);
                        break;
                }
            }
        }

        if(event.getView().getTitle() == "§5Heal:") {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            Inventory op_utils = UtilsCommand.op_utils;
            if(event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch(event.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "healme":
                        player.setSaturation(20);
                        player.setHealth(20);
                        player.openInventory(op_utils);
                        break;
                    case "healall":
                        for (Player p:Bukkit.getOnlinePlayers()) {
                            p.setSaturation(20);
                            p.setHealth(20);
                        }
                        player.openInventory(op_utils);
                        break;
                }
            }
        }
        if (event.getView().getTitle() == "§5Challenges:") {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            Inventory op_utils = UtilsCommand.op_utils;
            if(event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch(event.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "onnojump":
                        nojump = true;
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 20, 20);
                        player.openInventory(challenge);
                        break;
                    case "offnojump":
                        nojump = false;
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 20, 0);
                        player.openInventory(challenge);
                        break;

                    case "onnosneak":
                        nosneak = true;
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 20, 20);
                        player.openInventory(challenge);
                        break;
                    case "offnosneak":
                        nosneak = false;
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 20, 0);
                        player.openInventory(challenge);
                        break;

                    case "onice":
                        ice = true;
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 20, 20);
                        player.openInventory(challenge);
                        break;
                    case "office":
                        ice = false;
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 20, 0);
                        player.openInventory(challenge);
                        break;
                }
            }
        }

        if(event.getView().getTitle() == "§5Timer:") {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            Inventory op_utils = UtilsCommand.op_utils;
            if(event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch(event.getCurrentItem().getItemMeta().getLocalizedName()) {

                }
            }
        }

    }



}
