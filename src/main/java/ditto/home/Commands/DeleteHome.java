package ditto.home.Commands;

import ditto.home.Utils.Color;
import ditto.home.Utils.DataUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeleteHome implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;

            if(args.length == 0){
                player.sendMessage(Color.Colorize("&4You did not specify which home to delete!"));
            }else if(args.length == 1){
                String name = args[0].toLowerCase();

                if(DataUtil.getHome(player, name)){
                    player.sendMessage(Color.Colorize("&4You don't have a home with that name!"));

                } else {

                    player.sendMessage(Color.Colorize("&4Deleting home with the name of " + name));
                    DataUtil.remove(player, name);
                }
            }
        }
        return true;
    }
}
