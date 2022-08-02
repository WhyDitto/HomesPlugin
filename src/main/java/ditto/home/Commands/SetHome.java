package ditto.home.Commands;

import ditto.home.Utils.Color;
import ditto.home.Utils.DataUtil;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class SetHome implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if (args.length == 1) {
                String name = args[0].toLowerCase();

                if(DataUtil.getHome(player, name)) {
                    player.sendMessage(Color.Colorize("&aCreating a home with the name " + name));
                    Location loc = player.getLocation();
                    DataUtil.getConfig().set(player.getUniqueId().toString() + "." + name + ".x", loc.getX());
                    DataUtil.getConfig().set(player.getUniqueId().toString() + "." + name + ".y", loc.getY());
                    DataUtil.getConfig().set(player.getUniqueId().toString() + "." + name + ".z", loc.getZ());
                    DataUtil.saveConfig();
                } else {
                    player.sendMessage(Color.Colorize("&4A home with that name already exists!"));
                }



            } else {
                player.sendMessage(Color.Colorize("&4Invalid usage! /setHome <Name>"));


            }

        }

        return true;
    }
}
