package com.company;

import com.company.GUI.BotFrame;

import java.awt.*;

public class BloodWebBot
{
    public static void main(String[] args)
    {
        BotCore botCore = new BotCore();
        EventQueue.invokeLater(() -> new BotFrame(botCore));

    }
}
