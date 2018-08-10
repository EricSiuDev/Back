package me.eric.back;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class ListenerClass implements Listener {
    @EventHandler
    public static void playerDeathEvent(PlayerDeathEvent e) {
        Player p = e.getEntity().getPlayer();
        Location l = e.getEntity().getLocation();
        RecordPosition.recPosition(p, l);
        return;
    }
    @EventHandler
    public static void playerRespawnEvent(PlayerRespawnEvent e){
        Player p = e.getPlayer();
        p.sendMessage(ChatColor.GREEN+"[返回] 你可以使用 /back回到死亡前的位置喔~");
        return;
    }
    @EventHandler
    public static void playerTeleportEvent(PlayerTeleportEvent e){
        Player p = e.getPlayer();
        Location l = e.getFrom();
        RecordPosition.recPosition(p, l);
    }
}
