package org.yu1.arealimit.util;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.yu1.arealimit.commands.MainCommand;
import org.yu1.arealimit.datautil.fileutil.FileUtil;

public class Block extends MainCommand {
    public Block(int x, int z, String world, Player player, Cancellable e,String type)
    {
        for(String limitName : FileUtil.getKeys()){
            String worldName = FileUtil.getStringData(limitName + ".world");
            if(world.equals(worldName)){
                int x1 = FileUtil.getIntData(limitName + ".x1");
                int x2 = FileUtil.getIntData(limitName + ".x2");
                int z1 = FileUtil.getIntData(limitName + ".z1");
                int z2 = FileUtil.getIntData(limitName + ".z2");
                if(x2 <= x1){
                    int temp = x1;
                    x1 = x2;
                    x2 = temp;
                }
                if(z2 <= z1){
                    int temp = z1;
                    z1 = z2;
                    z2 = temp;
                }
                if(x >= x1 && x <= x2 && z >= z1 && z <=z2 && !player.isOp()){
                    e.setCancelled(true);
                    player.sendMessage(INSTANCE.getConfig().getString("Messages.no" + type).replace("&", "§"));
                    break;
                }
            }
        }
    }

}
