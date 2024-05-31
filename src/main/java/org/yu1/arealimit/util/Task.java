package org.yu1.arealimit.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;
import org.yu1.arealimit.AreaLimit;
import org.yu1.arealimit.datautil.fileutil.FileUtil;

public class Task extends BukkitRunnable {
    public static final AreaLimit INSTANCE = AreaLimit.getInstance();
    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            String world = player.getWorld().getName();
            int x = player.getLocation().getBlockX();
            int z = player.getLocation().getBlockZ();
            for(String limitName : FileUtil.getKeys()){
                String worldName = FileUtil.getStringData(limitName + ".world");
                boolean walk = FileUtil.getBoolData(limitName + ".walk");
                if(!walk) continue;
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
                        // 检查玩家是否装备了冰霜行者靴子
                        PlayerInventory inventory = player.getInventory();
                        ItemStack boots = inventory.getBoots();
                        if (boots != null  && boots.getItemMeta().hasEnchants()) {
                            if (boots.getEnchantmentLevel(Enchantment.FROST_WALKER) > 0) {
                                player.teleport(SafeLocation.getLocation());
                                // 玩家装备了冰霜行者，阻止他们进入
                                player.sendMessage(INSTANCE.getConfig().getString("Messages.noWalker").replace("&", "§"));
                            }
                        }
                        break;
                    }
                }
            }
        }
    }

}
