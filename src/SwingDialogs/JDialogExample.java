package SwingDialogs;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class JDialogExample {
    public static void main(String[] args) {
        JFrame frame  = new JFrame("JDialog Example");
        frame.setSize(500,500);
        frame.setLocation(50,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = frame.getContentPane();
        c.setLayout(new GridLayout(3,1));
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton ("Button 2");
        c.add( button1,0);
        c.add(button2,1);
    }
}
