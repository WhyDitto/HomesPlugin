package ditto.home;

import ditto.home.Commands.DeleteHome;
import ditto.home.Commands.Home;
import ditto.home.Commands.HomeList;
import ditto.home.Commands.SetHome;
import ditto.home.Utils.Color;
import ditto.home.Utils.DataUtil;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main main;

    @Override
    public void onEnable() {
        // Plugin startup logic
        main = this;

        DataUtil.setup();

        getServer().getConsoleSender().sendMessage(Color.Colorize("&aDitto's Homes has been enabled!"));

        registerCommands();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(Color.Colorize("&4Shutting down... Goodbye!"));
    }


    public static Main getInstance() {
        return main;
    }

    public void registerCommands(){
        getCommand("setHome").setExecutor(new SetHome());
        getCommand("homeList").setExecutor(new HomeList());
        getCommand("home").setExecutor(new Home());
        getCommand("deletehome").setExecutor(new DeleteHome());
    }

}
