package ditto.home.Commands;

import ditto.home.Utils.Color;
import ditto.home.Utils.DataUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class HomeList implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;


            try{
                ArrayList<String> homes = new ArrayList<>();

                for (String key : DataUtil.getConfig().getConfigurationSection(player.getUniqueId().toString()).getKeys(false)){
                    homes.add(key);
                }
                player.sendMessage(ChatColor.GRAY + "Homes:");

                for(String home : homes){
                    player.sendMessage(ChatColor.GRAY + "- " + home);
                }

            } catch (NullPointerException e) {
                player.sendMessage(Color.Colorize("&4You don't have any homes set"));
            }

        }

        return true;
    }
}
