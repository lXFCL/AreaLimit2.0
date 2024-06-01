package org.yu1.arealimit.listener;

import org.yu1.arealimit.commands.MainCommand;
import org.yu1.arealimit.util.Task;

public class MoveListener extends MainCommand {
    public MoveListener() {
        int b = INSTANCE.getConfig().getInt("Settings.time");
        new Task().runTaskTimerAsynchronously(INSTANCE, 0L, 5L * b);
    }

}
