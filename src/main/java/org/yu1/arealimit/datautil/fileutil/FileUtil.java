package org.yu1.arealimit.datautil.fileutil;

import org.bukkit.configuration.file.YamlConfiguration;
import org.yu1.arealimit.commands.MainCommand;

import java.io.File;
import java.util.Set;

public class FileUtil extends MainCommand {
    static {
        new File(INSTANCE.getDataFolder() + "/data/");
    }
    public static <T> void setData(String dataName, T data)
    {
        File file = new File(INSTANCE.getDataFolder() + "/data/",  "area.yml");
        YamlConfiguration filec = YamlConfiguration.loadConfiguration(file);
        filec.set(dataName, data);
        try {
            filec.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getIntData(String dataName)
    {
        File file = new File(INSTANCE.getDataFolder() + "/data/", "area.yml");
        YamlConfiguration filec = YamlConfiguration.loadConfiguration(file);
        return filec.getInt(dataName);
    }
    public static String getStringData(String dataName)
    {
        File file = new File(INSTANCE.getDataFolder() + "/data/", "area.yml");
        YamlConfiguration filec = YamlConfiguration.loadConfiguration(file);
        return filec.getString(dataName);
    }
    public static Set<String> getKeys()
    {
        File file = new File(INSTANCE.getDataFolder() + "/data/", "area.yml");
        YamlConfiguration filec = YamlConfiguration.loadConfiguration(file);
        return filec.getKeys(false);
    }
}
