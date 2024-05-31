package org.yu1.arealimit.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.yu1.arealimit.datautil.fileutil.FileUtil;

public class Start extends MainCommand{
    public Start(CommandSender sender, String[] args){
        if (sender.hasPermission(INSTANCE.getConfig().getString("Permission.start"))) {
            if(!(sender instanceof Player)){
                sender.sendMessage(INSTANCE.getConfig().getString("Messages.noPlayer").replace("&", "§"));
                return;
            }
            if(args.length != 2)
            {
                sender.sendMessage(INSTANCE.getConfig().getString("Messages.noCommand").replace("&", "§"));
                sender.sendMessage(INSTANCE.getConfig().getString("Commands.start").replace("&","§"));
                return;
            }
            FileUtil.setData("player",sender.getName());
            FileUtil.setData("areaName",args[1]);
            sender.sendMessage(INSTANCE.getConfig().getString("Messages.start").replace("&", "§"));
        } else {
            sender.sendMessage(INSTANCE.getConfig().getString("Messages.noPermission").replace("&", "§"));
        }
    }
}
