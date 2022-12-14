package de.titus.polizeiwache.listeners;

import de.titus.polizeiwache.Polizeiwache;
import de.titus.polizeiwache.itembuilder.ItemBuilder;
import de.titus.polizeiwache.utils.UtilsCommand;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;


public class InventoryListener implements Listener {

    public static Inventory gamemode = Bukkit.createInventory(null, 3 * 9, "§5Gamemodes:");
    public static Inventory vanish = Bukkit.createInventory(null, 3*9, "§5Vanish:");
    public static Inventory fly = Bukkit.createInventory(null, 3*9, "§5Fly:");
    public static Inventory heal = Bukkit.createInventory(null, 3*9, "§5Heal:");
    public static Inventory challenge = Bukkit.createInventory(null, 4*9, "§5Challenges:");
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
                        gamemode.setItem(18, new ItemBuilder(Material.ARROW).setDisplayname("§7Back").setLocalizedName("back").build());
                        player.openInventory(gamemode);
                        break;
                    case "vanish":
                        vanish.setItem(13, new ItemBuilder(Material.SUGAR).setDisplayname("§7Vanish").setLocalizedName("vanish").build());
                        vanish.setItem(18, new ItemBuilder(Material.ARROW).setDisplayname("§7Back").setLocalizedName("back").build());
                        player.openInventory(vanish);
                        break;
                    case "fly":
                        fly.setItem(13, new ItemBuilder(Material.STRING).setDisplayname("§7Fly").setLocalizedName("fly").build());
                        fly.setItem(18, new ItemBuilder(Material.ARROW).setDisplayname("§7Back").setLocalizedName("back").build());
                        player.openInventory(fly);
                        break;
                    case "heal":
                        heal.setItem(12, new ItemBuilder(Material.GOLDEN_CARROT).setDisplayname("§aHeal me").setLocalizedName("healme").build());
                        heal.setItem(14, new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname("§aHeal all").setLocalizedName("healall").build());
                        heal.setItem(18, new ItemBuilder(Material.ARROW).setDisplayname("§7Back").setLocalizedName("back").build());
                        player.openInventory(heal);
                        break;
                    case "challenge":
                        challenge.setItem(10, new ItemBuilder(Material.COBWEB).setDisplayname("§aNoJump").setLore("In dieser Challenge").setLore("darfst du nicht springen").setLocalizedName("nojump").build());
                        challenge.setItem(19, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).build());

                        challenge.setItem(11, new ItemBuilder(Material.FEATHER).setDisplayname("§aNoSneak").setLore("In dieser Challenge").setLore("darfst du nicht sneaken").setLocalizedName("nosneak").build());
                        challenge.setItem(20, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).build());

                        challenge.setItem(12, new ItemBuilder(Material.ICE).setDisplayname("§aIce").setLore("In dieser Challenge").setLore("spawnt Eis unter dir!").setLocalizedName("ice").build());
                        challenge.setItem(21, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).build());

                        challenge.setItem(27, new ItemBuilder(Material.ARROW).setDisplayname("§7Back").setLocalizedName("back").build());
                        player.openInventory(challenge);
                        break;
                    case "timer":
                        timer.setItem(18, new ItemBuilder(Material.ARROW).setDisplayname("§7Back").setLocalizedName("back").build());
                        player.openInventory(timer);
                        break;
                    default:
                        break;
                }
            }
        }

        if (event.getView().getTitle() == "§5Gamemodes:") {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            if (event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch (event.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "survival":
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(Polizeiwache.getPrefix() + "§7Du bist jetzt in §eSURVIVAL");
                        break;
                    case "creative":
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(Polizeiwache.getPrefix() + "§7Du bist jetzt in §eCREATIVE");
                        break;
                    case "spectator":
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(Polizeiwache.getPrefix() + "§7Du bist jetzt in §eSPECTATOR");
                        break;
                    case "adventure":
                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(Polizeiwache.getPrefix() + "§7Du bist jetzt in §eADVENTURE");
                        break;
                    case "back":
                        player.openInventory(UtilsCommand.op_utils);
                        break;
                    default:
                        break;
                }
            }
        }

        if(event.getView().getTitle() == "§5Vanish:") {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            if(event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch(event.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "vanish":
                        if(!Polizeiwache.vanishBoolean) {
                            player.setInvisible(true);
                            Polizeiwache.vanishBoolean = true;
                            player.sendMessage(Polizeiwache.getPrefix() + "§aDu bist jetzt im Vanish!");
                        } else {
                            player.setInvisible(false);
                            Polizeiwache.vanishBoolean = false;
                            player.sendMessage(Polizeiwache.getPrefix() + "§cDu bist jetzt nicht mehr im Vanish!");
                        }
                        break;
                    case "back":
                        player.openInventory(UtilsCommand.op_utils);
                        break;
                    default:
                        break;
                }
            }
        }

        if(event.getView().getTitle() == "§5Fly:") {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            if(event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch(event.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "fly":
                        if(!Polizeiwache.flyBoolean) {
                            player.setAllowFlight(true);
                            player.setFlying(true);
                            Polizeiwache.flyBoolean = true;
                            player.sendMessage(Polizeiwache.getPrefix() + "§aDu fliegst jetzt!");
                        } else {
                            player.setAllowFlight(false);
                            player.setFlying(false);
                            Polizeiwache.flyBoolean = false;
                            player.sendMessage(Polizeiwache.getPrefix() + "§cDu fliegst jetzt nicht mehr!");
                        }
                        break;
                    case "back":
                        player.openInventory(UtilsCommand.op_utils);
                        break;
                    default:
                        break;
                }
            }
        }

        if(event.getView().getTitle() == "§5Heal:") {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            if(event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch(event.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "healme":
                        player.setSaturation(20);
                        player.setHealth(20);
                        player.sendMessage(Polizeiwache.getPrefix() + "§aDu hast dich gehealt!");
                        break;
                    case "healall":
                        for (Player p:Bukkit.getOnlinePlayers()) {
                            p.setSaturation(20);
                            p.setHealth(20);
                            player.sendMessage(Polizeiwache.getPrefix() + "§aDu hast alle Spieler gehealt!");
                        }
                        break;
                    case "back":
                        player.openInventory(UtilsCommand.op_utils);
                        break;
                    default:
                        break;
                }
            }
        }
        if (event.getView().getTitle() == "§5Challenges:") {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            if(event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch(event.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "nojump":
                        if(!Polizeiwache.nojump) {
                            Polizeiwache.nojump = true;
                            challenge.setItem(19, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).build());
                            Bukkit.getPluginManager().registerEvents(Polizeiwache.getInstance().noJumpListener, Polizeiwache.getInstance());
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 20);
                            Polizeiwache.getInstance().sendMessageToAllPlayers(Polizeiwache.getPrefix() + "§aDie Challenge 'NoJump' wurde gestartet!");
                        } else {
                            Polizeiwache.nojump = false;
                            challenge.setItem(19, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).build());
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 10);
                            Polizeiwache.getInstance().sendMessageToAllPlayers(Polizeiwache.getPrefix() + "§cDie Challenge 'NoJump' wurde gestoppt!");
                        }
                        break;
                    case "nosneak":
                        if(!Polizeiwache.nosneak) {
                            Polizeiwache.nosneak = true;
                            challenge.setItem(20, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).build());
                            Bukkit.getPluginManager().registerEvents(Polizeiwache.getInstance().noSneakListener, Polizeiwache.getInstance());
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 20);
                            Polizeiwache.getInstance().sendMessageToAllPlayers(Polizeiwache.getPrefix() + "§aDie Challenge 'NoSneak' wurde gestartet!");
                        } else {
                            Polizeiwache.nosneak = false;
                            challenge.setItem(20, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).build());
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 10);
                            Polizeiwache.getInstance().sendMessageToAllPlayers(Polizeiwache.getPrefix() + "§cDie Challenge 'NoSneak' wurde gestoppt!");
                        }
                        break;
                    case "ice":
                        if(!Polizeiwache.ice) {
                            Polizeiwache.ice = true;
                            challenge.setItem(21, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).build());
                            Bukkit.getPluginManager().registerEvents(Polizeiwache.getInstance().iceListener, Polizeiwache.getInstance());
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 20);
                            Polizeiwache.getInstance().sendMessageToAllPlayers(Polizeiwache.getPrefix() + "§aDie Challenge 'Ice' wurde gestartet!");
                        } else {
                            Polizeiwache.ice = false;
                            challenge.setItem(21, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).build());
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 10);
                            Polizeiwache.getInstance().sendMessageToAllPlayers(Polizeiwache.getPrefix() + "§cDie Challenge 'Ice' wurde gestoppt!");
                        }
                        break;
                    case "back":
                        player.openInventory(UtilsCommand.op_utils);
                        break;
                    default:
                        break;
                }
            }
        }

        if(event.getView().getTitle() == "§5Timer:") {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            if(event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch(event.getCurrentItem().getItemMeta().getLocalizedName()) {

                    case "back":
                        player.openInventory(UtilsCommand.op_utils);
                        break;
                    default:
                        break;
                }
            }
        }

        if(event.getView().getTitle() == "§7Commands:") {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
        }

    }



}
