package com.company.GUI;

import com.company.BotCore;
import com.company.BotTimerTask;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

public class BotFrame extends JFrame implements KeyListener
{
    CenterPanel centerPanel;
    BotCore botCore;
    Timer timer;
    BotTimerTask timerTask;

    public BotFrame(BotCore botCore)
    {
        super("Blood Web Bot");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.setResizable(true);
        this.setVisible(true);

        this.botCore = botCore;
        timerTask = new BotTimerTask(botCore);
        this.timer = new Timer();

        this.addKeyListener(this);

        centerPanel = new CenterPanel();
        this.add(centerPanel, BorderLayout.CENTER);

    }

    private void startTimer()
    {
        timer.cancel();
        timerTask = new BotTimerTask(botCore);
        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }


    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyChar() == '[')
        {
            startTimer();
        }
        else if (e.getKeyChar() == ']')
        {
            timerTask.swichOff();
            timer.cancel();
        }
    }
}
