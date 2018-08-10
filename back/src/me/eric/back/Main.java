package me.eric.back;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import static me.eric.back.RecordPosition.lastposition;

public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
        getLogger().info("Back plugin has been enabled.");
        getServer().getPluginManager().registerEvents(new ListenerClass(), this);
    }
    @Override
    public void onDisable(){
        getLogger().info("Back plugin has been disabled");
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(command.getName().equalsIgnoreCase("back")){
                if(!(lastposition.containsKey(p))){
                    p.sendMessage(ChatColor.RED+"" + "[返回] 你沒有已經儲存的位置!");
                    return true;
                }
                if(lastposition.containsKey(p)) {
                    p.teleport(lastposition.get(p));
                    p.sendMessage(ChatColor.GREEN+"[返回] 你已成功傳送到上一個位置!");
                    return true;
                }
            }
        }
        return false;
    }
}
