package menu;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.*;

public class JMenuExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("New Frame");
        frame.setSize(500,500);
        frame.setLocation(50,0);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JCheckBox checkbox = new JCheckBox ( "Checkbox1");
        frame.setContentPane(checkbox);
        checkbox.setSelected(true);
        checkbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Action Listener");
            }
        });

        checkbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("Item State Changed");
                JCheckBox checkbox = (JCheckBox)e.getSource();
                if( checkbox.isSelected())
                    checkbox.setBackground(Color.BLUE);
                else
                    checkbox.setBackground(Color.RED);
            }
        });

        checkbox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("Change Listener");

            }
        });
        checkbox.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("Property Change Listener");
            }
        });
        frame.setVisible(true);

    }
}
