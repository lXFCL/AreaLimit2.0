package org.yu1.arealimit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.yu1.arealimit.commands.MainCommand;
import org.yu1.arealimit.listener.BlockListener;
import org.yu1.arealimit.listener.PlayerListener;

public final class AreaLimit extends JavaPlugin {

    private static AreaLimit inst;
    public static AreaLimit INSTANCE;

    public static AreaLimit getInstance() {
        return inst;
    }
    public AreaLimit() {
        INSTANCE = getInstance();
    }
    @Override
    public void onLoad() {
        getLogger().info("§b§l[区域限制] §a-> §f插件已被载入");
    }
    @Override
    public void onEnable() {
        inst = this;
        getLogger().info("§b __   __   ____    ____     __        ");
        getLogger().info("§b/\\ \\ /\\ \\ /\\  _`\\ /\\  _`\\  /\\ \\       ");
        getLogger().info("§b\\ `\\`\\/'/'\\ \\ \\L\\_\\ \\ \\/\\_\\\\ \\ \\      ");
        getLogger().info("§b `\\/ > <   \\ \\  _\\/\\ \\ \\/_/_\\ \\ \\  __ ");
        getLogger().info("§b    \\/'/\\`\\ \\ \\ \\/  \\ \\ \\L\\ \\\\ \\ \\L\\ \\");
        getLogger().info("§b    /\\_\\\\ \\_\\\\ \\_\\   \\ \\____/ \\ \\____/");
        getLogger().info("§b    \\/_/ \\/_/ \\/_/    \\/___/   \\/___/ ");
        getLogger().info("§b§l[区域限制] §a-> §f插件已被加载");
        getLogger().info("§b§l[区域限制] §a-> §f插件作者§a§lYu1");
        getLogger().info("§b§l[区域限制] §a-> §f§c§l支持正版，请在九域下载本插件");
        getLogger().info("§b§l[区域限制] §a-> §f插件售后交流群:928752729");
        getLogger().info("§b§l[区域限制] §a-> §f需要定制插件可以进群加我");
        getLogger().info("§b§l[区域限制] §a-> §f感谢你的使用");
        getLogger().info("§b§l[区域限制] §a-> §f插件版本:1.0");
        saveDefaultConfig();
        reloadConfig();
        Bukkit.getPluginCommand("alt").setExecutor(new MainCommand());
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("§b§l[区域限制] §a-> §f感谢使用，插件卸载");
    }
}
