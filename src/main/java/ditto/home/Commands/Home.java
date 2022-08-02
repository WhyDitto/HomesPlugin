package ditto.home.Commands;

import ditto.home.Utils.Color;
import ditto.home.Utils.DataUtil;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Home implements CommandExecutor {
    private static Location x;
    private static Location y;
    private static Location z;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;

            if (args.length == 0) {
                player.sendMessage(Color.Colorize("&4Invalid usage! /home <name>"));

            } else if (args.length == 1) {
                String name = args[0].toLowerCase();

                if(DataUtil.getHome(player, name)){
                    player.sendMessage(Color.Colorize("&4This home doesn't exist!"));

                } else {
                Location loc = DataUtil.getLocation(player, name);

                player.sendMessage(Color.Colorize("&aWarping you to your home " + name));
                player.teleport(loc);
                }
            }
        }
        return true;
    }
}
