package de.titus.polizeiwache;

import de.titus.polizeiwache.challenges.IceListener;
import de.titus.polizeiwache.challenges.NoJumpListener;
import de.titus.polizeiwache.challenges.NoSneakListener;
import de.titus.polizeiwache.commands.FlyCommand;
import de.titus.polizeiwache.commands.GamemodeCommand;
import de.titus.polizeiwache.commands.NoJumpCommand;
import de.titus.polizeiwache.commands.VanishCommand;
import de.titus.polizeiwache.listeners.InventoryListener;
import de.titus.polizeiwache.listeners.JoinQuitListener;
import de.titus.polizeiwache.tablist.TablistManager;
import de.titus.polizeiwache.utils.UtilsCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Polizeiwache extends JavaPlugin {

    public Listener noJumpListener = new NoJumpListener();
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

        //lstRegistration();
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
        pm.registerEvents(new NoJumpListener(), this);
        pm.registerEvents(new NoSneakListener(), this);
        pm.registerEvents(new IceListener(), this);
    }

    public void cmdRegistration() {
        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("utils").setExecutor(new UtilsCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("nojump").setExecutor(new NoJumpCommand());
    }

    public void WorldSettings() {
        Bukkit.getWorld("world").setDifficulty(Difficulty.HARD);
    }

}