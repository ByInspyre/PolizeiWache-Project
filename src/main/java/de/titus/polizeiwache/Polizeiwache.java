package de.titus.polizeiwache;

import de.titus.polizeiwache.challenges.IceListener;
import de.titus.polizeiwache.challenges.NoJumpListener;
import de.titus.polizeiwache.challenges.NoSneakListener;
import de.titus.polizeiwache.commands.*;
import de.titus.polizeiwache.listeners.InventoryListener;
import de.titus.polizeiwache.listeners.JoinQuitListener;
import de.titus.polizeiwache.listeners.PlayerProcessCommandEvent;
import de.titus.polizeiwache.tablist.TablistManager;
import de.titus.polizeiwache.utils.UtilsCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.GameRule;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Polizeiwache extends JavaPlugin {

    public Listener noJumpListener = new NoJumpListener();
    public Listener noSneakListener = new NoSneakListener();
    public Listener iceListener = new IceListener();


    public static boolean vanishBoolean = false;

    public static boolean flyBoolean = false;


    public static boolean nojump = false;

    public static boolean nosneak = false;

    public static boolean ice = false;


    public static String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.BLUE +"Polizei§fWache" + ChatColor.DARK_GRAY + "] ";
    public static String getPrefix() {
        return prefix;
    }

    public static String SyntaxError = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "SyntaxError" + ChatColor.DARK_GRAY + "] ";
    public static String getSyntaxError() {
        return SyntaxError;
    }

    private TablistManager tablistManager;
    public TablistManager getTablistManager() {
        return tablistManager;
    }

    private static Polizeiwache instance;
    public static Polizeiwache getInstance() {
        return instance;
    }



    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        Bukkit.getLogger().info(Polizeiwache.getPrefix() + "§aPlugin loaded");

        lstRegistration();
        cmdRegistration();

        WorldSettings();

        tablistManager = new TablistManager();
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(Polizeiwache.getPrefix() + "§cPlugin deloaded");
    }

    public void lstRegistration() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinQuitListener(), this);
        pm.registerEvents(new InventoryListener(), this);
        pm.registerEvents(new PlayerProcessCommandEvent(), this);
    }

    public void cmdRegistration() {
        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("utils").setExecutor(new UtilsCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("discord").setExecutor(new DiscordCommand());
        getCommand("commands").setExecutor(new CmdCommand());
    }

    public void WorldSettings() {
        Objects.requireNonNull(Bukkit.getWorld("world")).setDifficulty(Difficulty.HARD);
        Objects.requireNonNull(Bukkit.getWorld("flatroom")).setDifficulty(Difficulty.HARD);
        Objects.requireNonNull(Bukkit.getWorld("flatroom")).setPVP(false);
        Objects.requireNonNull(Bukkit.getWorld("flatroom")).setClearWeatherDuration(999999999);
        Objects.requireNonNull(Bukkit.getWorld("flatroom")).setGameRule(GameRule.DO_MOB_SPAWNING, false);
        Objects.requireNonNull(Bukkit.getWorld("flatroom")).setDifficulty(Difficulty.PEACEFUL);
    }

    public void sendMessageToAllPlayers(final String text) {
        for (final Player all : Bukkit.getOnlinePlayers()) {
            all.sendMessage(text);
        }
    }



}