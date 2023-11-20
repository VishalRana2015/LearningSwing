// java Program to create a simple JWindow 
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


class ToggleExample extends JFrame implements ActionListener{
    static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("New Title");
        frame.setSize(400,400);
        frame.setLocation(100,400);
        frame.setVisible(true);

        JRootPane rootpane = frame.getRootPane();
        JToggleButton tbutton = new JToggleButton ( );

        frame.setContentPane(tbutton);

        ImageIcon onimage = new ImageIcon (".\\Images\\onToggleButton.png");
        tbutton.setSelectedIcon(onimage);
        ImageIcon offimage = new ImageIcon( ".\\Images\\offToggleButton.png");
        tbutton.setIcon(offimage);
        frame.setContentPane(tbutton);
        BevelBorder bdraised = new BevelBorder( BevelBorder.RAISED);
        BevelBorder bdlowered = new BevelBorder( BevelBorder.LOWERED);
        tbutton.setBorder(bdraised);
        tbutton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                JToggleButton b = (JToggleButton)e.getSource() ;
                if ( b.isSelected()){
                    b.setBorder(bdlowered);
                }
                else
                    b.setBorder(bdraised);
            }
        });


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // altering with root pane
        frame.pack();
    }
    public void actionPerformed (ActionEvent e ){

    }

}