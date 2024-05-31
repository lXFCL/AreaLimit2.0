package org.yu1.arealimit.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.yu1.arealimit.commands.MainCommand;
import org.yu1.arealimit.datautil.fileutil.FileUtil;
import org.yu1.arealimit.util.Block;

public class BlockListener extends MainCommand implements Listener {
    @EventHandler
    public void Command(BlockBreakEvent e) {
        new Block(e.getBlock().getX(), e.getBlock().getZ(), e.getBlock().getWorld().getName(), e.getPlayer(), e,"Break");
    }
    @EventHandler
    public void Command(BlockPlaceEvent e) {
        new Block(e.getBlock().getX(), e.getBlock().getZ(), e.getBlock().getWorld().getName(), e.getPlayer(), e,"Place");
    }
}
