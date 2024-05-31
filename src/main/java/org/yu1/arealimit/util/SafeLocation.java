package org.yu1.arealimit.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.yu1.arealimit.commands.MainCommand;

public class SafeLocation extends MainCommand {
    public static Location getLocation()
    {
        World world = Bukkit.getWorld(INSTANCE.getConfig().getString("Location.world"));
        int x = INSTANCE.getConfig().getInt("Location.x");
        int y = INSTANCE.getConfig().getInt("Location.y");
        int z = INSTANCE.getConfig().getInt("Location.z");
        return new Location(world,x,y,z);
    }
}
