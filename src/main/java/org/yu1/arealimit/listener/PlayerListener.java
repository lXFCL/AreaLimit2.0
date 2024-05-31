package org.yu1.arealimit.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.yu1.arealimit.commands.MainCommand;
import org.yu1.arealimit.datautil.fileutil.FileUtil;

public class PlayerListener extends MainCommand implements Listener {
    @EventHandler
    public void Command(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) return;
        if(FileUtil.getStringData("player") == null || !FileUtil.getStringData("player").equals(e.getPlayer().getName())) return;
        if(FileUtil.getStringData("areaName") == null) return;
        int x = e.getClickedBlock().getX();
        int z = e.getClickedBlock().getZ();
        String areaName = FileUtil.getStringData("areaName") + ".";
        String worldName = e.getClickedBlock().getLocation().getWorld().getName();
        if(e.getAction().equals(Action.LEFT_CLICK_BLOCK)){
            FileUtil.setData(areaName + "x1", x);
            FileUtil.setData(areaName + "z1", z);
            FileUtil.setData(areaName + "world", worldName);
            FileUtil.setData("first", 1);
            e.getPlayer().sendMessage(INSTANCE.getConfig().getString("Messages.first").replace("&", "§"));
        } else if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(FileUtil.getIntData("first") == 0){
                e.getPlayer().sendMessage(INSTANCE.getConfig().getString("Messages.noFirst").replace("&", "§"));
                return;
            }
            FileUtil.setData(areaName + "x2", x);
            FileUtil.setData(areaName + "z2", z);
            FileUtil.setData(areaName + "world", worldName);
            FileUtil.setData(areaName + "walk", true);
            FileUtil.setData("player", null);
            FileUtil.setData("areaName", null);
            FileUtil.setData("first", null);
            e.getPlayer().sendMessage(INSTANCE.getConfig().getString("Messages.second").replace("&", "§"));
        }
    }
}
