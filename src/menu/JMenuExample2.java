package menu;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuDragMouseEvent;
import javax.swing.event.MenuDragMouseListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.event.*;

public class JMenuExample2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JMenuExample2");
        frame.setSize(500, 500);
        frame.setLocation(50, 0);

        JMenuBar menubar  = new JMenuBar();
        frame.setJMenuBar(menubar);
        //menubar.setLayout(new BorderLayout());
        JMenu edit = new JMenu("Edit");
        menubar.add(edit);
        menubar.add(new JMenu("Menu1")/*,BorderLayout.NORTH*/);
        //menubar.add(new JMenu("Menu2"),BorderLayout.CENTER);
        //menubar.add(new JMenu("Menu3"), BorderLayout.SOUTH);
        SingleSelectionModel m = menubar.getSelectionModel();
        System.out.println("Selection Model is :"+m.getClass().toString());
        System.out.println(menubar.getLayout());
        System.out.println(Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
        // setting help menu will result in undefined behavior and thus will throw an exception.
        // the Change event is defined on the model
       // ImageIcon icon = new ImageIcon("new ImageIcon(\"C:\\\\Users\\\\RANA1947\\\\IdeaProjects\\\\JAVA1\\\\Images\\\\cut.png");
     //   Image image = icon.getImage().getScaledInstance(20,20,1);
        JMenuItem cut = new JMenuItem("Cut",new ImageIcon("C:\\Users\\RANA1947\\IdeaProjects\\JAVA1\\Images\\cut.png"));
        JMenuItem copy = new JMenuItem("Copy",new ImageIcon("C:\\Users\\RANA1947\\IdeaProjects\\JAVA1\\Images\\copy.png"));
        JMenuItem paste = new JMenuItem("Paste",new ImageIcon("C:\\Users\\RANA1947\\IdeaProjects\\JAVA1\\Images\\paste.png"));
        cut.setAccelerator( KeyStroke.getKeyStroke('C',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);

        // Adding items to Meun1

        m.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("Property change Listener Fired.");


                if(menubar.isSelected())
                    System.out.println("Menu is selectd and index is "+m.getSelectedIndex());
                else
                    System.out.println("Menu is not Selected"+m.getSelectedIndex());
            }
        });

        cut.addMenuDragMouseListener(new MyMenuDragMouseListener());
        System.out.println(cut.getMenuDragMouseListeners().length);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}



class MyMenuDragMouseListener implements MenuDragMouseListener{

    @Override
    public void menuDragMouseReleased (MenuDragMouseEvent e){
        System.out.println("x : "+e.getX());
        System.out.println("Y :"+ e.getY());
        System.out.println("x in screen "+e.getXOnScreen());
        System.out.println("y on screen  : "+e.getYOnScreen());
        System.out.println("Source : "+e.getSource());
        System.out.println("Menu Selection Manager : "+e.getMenuSelectionManager());
        MenuElement[] ele  = e.getPath();
        for ( MenuElement ee : ele){
            System.out.print(ee.getComponent().getName() + ",");
        }
        System.out.println("Click count : "+e.getClickCount());
        System.out.println("When timestamp of event: "+e.getWhen());
        System.out.println("ID : "+e.getID());
        // differenet id for different event types
        System.out.println("Is event has been consumed : "+e.isConsumed());
        System.out.println("Is Alt(key) down :"+e.isAltDown());

    }
    @Override
    public void menuDragMouseEntered(MenuDragMouseEvent e){
        System.out.println("x : "+e.getX());
        System.out.println("Y :"+ e.getY());
        System.out.println("x in screen "+e.getXOnScreen());
        System.out.println("y on screen  : "+e.getYOnScreen());
        System.out.println("Source : "+e.getSource());
        System.out.println("Menu Selection Manager : "+e.getMenuSelectionManager());
        MenuElement[] ele  = e.getPath();
        for ( MenuElement ee : ele){
            System.out.print(ee.getComponent().getName() + ",");
        }
        System.out.println("Click count : "+e.getClickCount());
        System.out.println("When timestamp of event: "+e.getWhen());
        System.out.println("ID : "+e.getID());
        // differenet id for different event types
        System.out.println("Is event has been consumed : "+e.isConsumed());
        System.out.println("Is Alt(key) down :"+e.isAltDown());
    }
    @Override
    public void menuDragMouseExited(MenuDragMouseEvent e){
        System.out.println("x : "+e.getX());
        System.out.println("Y :"+ e.getY());
        System.out.println("x in screen "+e.getXOnScreen());
        System.out.println("y on screen  : "+e.getYOnScreen());
        System.out.println("Source : "+e.getSource());
        System.out.println("Menu Selection Manager : "+e.getMenuSelectionManager());
        MenuElement[] ele  = e.getPath();
        for ( MenuElement ee : ele){
            System.out.print(ee.getComponent().getName() + ",");
        }
        System.out.println("Click count : "+e.getClickCount());
        System.out.println("When timestamp of event: "+e.getWhen());
        System.out.println("ID : "+e.getID());
        // differenet id for different event types
        System.out.println("Is event has been consumed : "+e.isConsumed());
        System.out.println("Is Alt(key) down :"+e.isAltDown());
    }
    @Override
    public void menuDragMouseDragged(MenuDragMouseEvent e ){
        System.out.println("x : "+e.getX());
        System.out.println("Y :"+ e.getY());
        System.out.println("x in screen "+e.getXOnScreen());
        System.out.println("y on screen  : "+e.getYOnScreen());
        System.out.println("Source : "+e.getSource());
        System.out.println("Menu Selection Manager : "+e.getMenuSelectionManager());
        MenuElement[] ele  = e.getPath();
        for ( MenuElement ee : ele){
            System.out.print(ee.getComponent().getName() + ",");
        }
        System.out.println("Click count : "+e.getClickCount());
        System.out.println("When timestamp of event: "+e.getWhen());
        System.out.println("ID : "+e.getID());
        // differenet id for different event types
        System.out.println("Is event has been consumed : "+e.isConsumed());
        System.out.println("Is Alt(key) down :"+e.isAltDown());
    }
}