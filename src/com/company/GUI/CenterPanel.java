package com.company.GUI;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel
{

    public CenterPanel()
    {
        super(new FlowLayout());
        this.setPreferredSize(new Dimension(500, 500));
        validate();
    }
}
