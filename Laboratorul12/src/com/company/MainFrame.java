package com.company;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainFrame extends JFrame {
    ControlPanel controlPanel;
    DesignPanel designPanel;
    public MainFrame() {
        super("Swing Designer");
        rootPane.setPreferredSize(new Dimension(1000,1000));
        init();
        addComponents();
        this.setLayout(new BorderLayout());
        this.setVisible(true);
    }
    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.controlPanel = new ControlPanel(this);
        this.designPanel = new DesignPanel(this);

        pack();
    }

    private void addComponents(){
        this.add(controlPanel, BorderLayout.NORTH);
        this.add(designPanel,BorderLayout.CENTER);
    }

}
