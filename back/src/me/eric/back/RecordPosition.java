package me.eric.back;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class RecordPosition{
    public static HashMap<Player, Location> lastposition = new HashMap<>();
    public static void recPosition(Player p, Location l){
            lastposition.put(p, l);
        }
}
