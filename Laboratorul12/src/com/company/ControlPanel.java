package com.company;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private final JLabel classNameLabel = new JLabel("Class name");
    private final JTextField classNameField = new JTextField(30);
    private final JLabel textLabel = new JLabel("default text");
    private final JTextField textField = new JTextField(10);
    private final JButton createButton = new JButton("Add component");
    public ControlPanel(MainFrame frame) {
        this.frame=frame;
        init();
    }
    private void init(){
        add(classNameField);
        add(classNameField);
        add(textField);
        add(textLabel);
        add(createButton);
        createButton.addActionListener(e ->{
            JComponent component = createDynamicComponent(classNameField.getText());
            setComponentText(component, textField.getText());
            frame.designPanel.addAtRandomLocation(component);
        });
    }

    private JComponent createDynamicComponent(String className) {
        try{
            Class newClass = Class.forName(className);
            return (JComponent) newClass.newInstance();

        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setComponentText(JComponent component,String text){
        Class newClass = component.getClass();
        Method method = null;
        try{
            method = newClass.getMethod("setTest",String.class);
            method.invoke(component,text);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
