package ditto.home.Utils;

import ditto.home.Main;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class DataUtil {

    private static File file;
    private static FileConfiguration config;

    public static void setup(){
        Main.getInstance().getDataFolder().mkdir();

        try {
            file = new File(Main.getInstance().getDataFolder(), "config.yml");

            if(!file.exists()){
                file.createNewFile();
            }

        } catch (IOException e) {

            System.out.println("Could not create file!");

            e.printStackTrace();
        }

        config = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getConfig(){
        return config;
    }

    public static void saveConfig(){
        try {
            config.save(file);
        } catch (IOException e) {
            System.out.println("Could not save config!");
            e.printStackTrace();
        }

    }

    public static boolean getHome(Player player, String name){
        if(DataUtil.getConfig().get(player.getUniqueId().toString() + "." + name) == null){
            return true;
        } else {
            return false;
        }
    }

    public static Location getLocation(Player player, String name){
        double x = DataUtil.getConfig().getDouble(player.getUniqueId().toString() + "." + name + ".x");
        double y = DataUtil.getConfig().getDouble(player.getUniqueId().toString() + "." + name + ".y");
        double z = DataUtil.getConfig().getDouble(player.getUniqueId().toString() + "." + name + ".z");

        return new Location(player.getWorld(), x, y ,z);
    }

    public static void remove(Player player, String name){
        DataUtil.getConfig().set(player.getUniqueId().toString() + "." + name, null);
    }



}
