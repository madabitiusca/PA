package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DesignPanel extends JPanel {
    public static final int W=800, H=600;
    private final MainFrame frame;
    public DesignPanel(MainFrame frame){
        this.frame=frame;
        setPreferredSize(new Dimension(W,H));
        setLayout(null);
    }

    public void addAtRandomLocation(JComponent component){
        Random random = new Random();

        int x=random.nextInt(W);
        int y=random.nextInt(H);
        int w= component.getPreferredSize().width;
        int h= component.getPreferredSize().height;
        component.setBounds(x,y,w,h);
        component.setToolTipText(component.getClass().getName());
        this.add(component);
        frame.repaint();
    }
}
