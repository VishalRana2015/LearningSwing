package Chooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

public class ColorChooserExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame ("Color Chooser Example");
        frame.setSize(500,500);
        frame.setLocation(50,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Choose Background Color");
        Container c = frame.getContentPane();
        c.setLayout( new BorderLayout());
        c.add(button,BorderLayout.NORTH);
        button.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                Color color = JColorChooser.showDialog(frame,"Choose Color ",Color.BLUE);
                c.setBackground(color);
            }
        });

        frame.setVisible(true);

    }
}
