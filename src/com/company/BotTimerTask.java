package com.company;

import java.util.TimerTask;

public class BotTimerTask extends TimerTask
{
    private BotCore botCore;
    private boolean hasStarted = false;

    public BotTimerTask(BotCore botCore)
    {
        this.botCore = botCore;
    }

    @Override
    public void run()
    {
        botCore.startBot();
        this.hasStarted = true;
    }

    public void swichOff()
    {
        hasStarted = false;
    }

    public boolean isRunning()
    {
        return this.hasStarted;
    }
}
