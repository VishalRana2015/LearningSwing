package menu;

import javax.swing.event.MenuKeyListener;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class MenuKeyListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MenuKeyListener Example");
        frame.setSize(500,500);
        frame.setLocation(50,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menubar = new JMenuBar();
        JMenu menu = getMenuColor();
        menubar.add( menu);


        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        JCheckBox checkbox1  = new JCheckBox("CheckBox1");
        JCheckBox checkbox2 = new JCheckBox("CheckBox2");
        ButtonGroup group = new ButtonGroup();
        group.add(checkbox1);
        group.add(checkbox2);
        panel.setLayout(new GridLayout(4,1));
        panel.add(checkbox1);
        panel.add(checkbox2);
        frame.add(panel,BorderLayout.CENTER);
        frame.setJMenuBar(menubar);
        frame.setVisible(true);
        
    }
    public static JMenu getMenuColor(){
        JMenu menuColor = new JMenu("Select color");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem red = new JRadioButtonMenuItem("RED",true);
        MyMenuKeyListener listener = new MyMenuKeyListener();
        red.addMenuKeyListener( listener); 
        menuColor.add(red);
        group.add(red);
        menuColor.add( new JSeparator(JSeparator.HORIZONTAL));
        JRadioButtonMenuItem blue = new JRadioButtonMenuItem("Blue",false);
        group.add(blue);
        blue.addMenuKeyListener(listener);
        menuColor.add(blue);

        //Donot try to add normal button in menu item as you can they lack some common features present in menuitem
       // JRadioButton yellow = new JRadioButton("Yellow",false);
        //group.add(yellow);
        // yellow.addMenuKeyEvent(listener) ; // error in this statement
        //menuColor.add(yellow);

        return menuColor;
    }
}


class MyMenuKeyListener implements MenuKeyListener{
        @Override
    public void menuKeyPressed(MenuKeyEvent e ){

           MenuElement [] ele = e.getPath();
           JMenuItem item = (JMenuItem)ele[ele.length-1];
            System.out.println("MenuKeyPressed : "+e.getKeyChar() +  " on "+item.getText());
            System.out.println("---------------------------------");
        }
        @Override
        public void menuKeyReleased(MenuKeyEvent e){
            MenuElement [] ele = (MenuElement[])e.getPath();
            JMenuItem item = (JMenuItem)ele[ele.length-1];

            System.out.println("MenuKeyReleased: "+e.getKeyChar() + " on "+item.getText());
            //System.out.println("Source = "+e.getSource());
            System.out.println("------------------");
        }
        @Override
        public void menuKeyTyped( MenuKeyEvent e){
            MenuElement [] ele = (MenuElement[] )e.getPath();
            JMenuItem item = (JMenuItem)ele[ele.length-1];
            System.out.println("MenuKeyTyped: "+e.getKeyChar() + " on "+item.getText());
            // System.out.printn(e.getSource()); // source is not an JMenuItem
            System.out.println("-------------------------------");
        }
}