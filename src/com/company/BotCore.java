package com.company;

import java.awt.*;
import java.awt.event.InputEvent;

public class BotCore
{
    public void startBot()
    {
        try
        {
            Robot robot = new Robot();
            Color color;

                robot.mouseMove(Util.PRESTIGE_UPGRADE_POSITION.x, Util.PRESTIGE_UPGRADE_POSITION.y);

                color = robot.getPixelColor(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);

                prestigeUpgrade(robot, color);

                for (Point position : Util.POSSIBLE_BLOOD_WEB_POSITIONS)
                {
                    robot.mouseMove(position.x, position.y);
                    color = robot.getPixelColor(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
                    normalUpgrade(robot, color, position);
                }

//            getInfo(robot);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void prestigeUpgrade(Robot robot, Color color) throws InterruptedException
    {
        if (color.getRed() > 250 && color.getGreen() > 250 && color.getBlue() > 250)
        {
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(1500);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
    }

    private void normalUpgrade(Robot robot, Color color, Point position) throws InterruptedException
    {
        if (165 > color.getRed() && color.getRed() > 145 &&
                160 > color.getGreen() && color.getGreen() > 140 &&
                125 > color.getBlue() && color.getBlue() > 105)
        {
            robot.mouseMove(position.x, position.y + 30);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(1000);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
    }

    private void getInfo(Robot robot) throws InterruptedException
    {
        Point p = new Point(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
        System.out.println(p);
        System.out.println(robot.getPixelColor(p.x, p.y));
        Thread.sleep(2000);
    }
}
