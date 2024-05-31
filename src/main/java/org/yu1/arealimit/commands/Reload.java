package org.yu1.arealimit.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

public class Reload extends MainCommand{
    public Reload(CommandSender sender)
    {
        if (sender.hasPermission(INSTANCE.getConfig().getString("Permission.reload"))) {
            INSTANCE.reloadConfig();
            sender.sendMessage(INSTANCE.getConfig().getString("Messages.reload").replace("&", "§"));
        } else {
            sender.sendMessage(INSTANCE.getConfig().getString("Messages.noPermission").replace("&", "§"));
        }
    }

}
