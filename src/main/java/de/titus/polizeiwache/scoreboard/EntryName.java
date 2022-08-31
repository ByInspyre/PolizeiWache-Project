package de.titus.polizeiwache.scoreboard;

import org.bukkit.ChatColor;

public enum EntryName {

    ENTRY_0(0, ChatColor.DARK_GRAY.toString()),
    ENTRY_1(1, ChatColor.GRAY.toString()),
    ENTRY_2(2, ChatColor.BLUE.toString()),
    ENTRY_3(3, ChatColor.DARK_RED.toString()),
    ENTRY_4(4, ChatColor.YELLOW.toString()),
    ENTRY_5(5, ChatColor.GREEN.toString()),
    ENTRY_6(6, ChatColor.AQUA.toString()),
    ENTRY_7(7, ChatColor.BLACK.toString());

    private final int entry;
    private final String entryName;

    EntryName(int entry, String entryName) {
        this.entry = entry;
        this.entryName = entryName;
    }

    public int getEntry() {
        return entry;
    }

    public String getEntryName() {
        return entryName;
    }
}
