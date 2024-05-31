package org.yu1.arealimit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.yu1.arealimit.AreaLimit;

import java.io.IOException;

public class MainCommand implements CommandExecutor {
    public static final AreaLimit INSTANCE = AreaLimit.getInstance();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length == 0) {
            for(String msg : INSTANCE.getConfig().getConfigurationSection("Commands").getKeys(false))
            {
                sender.sendMessage(INSTANCE.getConfig().getString("Commands." + msg).replace("&", "§"));
            }
        }else {
            switch (args[0]) {
                case "reload":
                    new Reload(sender);
                    break;
                case "start":
                    new Start();
                    break;
                default:
                    break;
            }
        }
        return false;
    }
}
