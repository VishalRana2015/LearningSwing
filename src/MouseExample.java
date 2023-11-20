import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;

public class MouseExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("MouseEventExample");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(50,0);
        frame.getContentPane().setLayout( new BorderLayout());
        JPanel panel = new JPanel();
        Container c = frame.getContentPane();
        c.add(panel,BorderLayout.CENTER);
        panel.addMouseMotionListener( new MyMouseMotionListener());


        frame.setVisible(true);
    }
}


class MyMouseListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked"+ e.getPoint().toString());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse Entered" +e.getPoint().toString());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse Exited"+e.getPoint().toString());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse Pressed "+e.getPoint().toString());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse Realeased "+e.getPoint().toString());
    }

}

class MyMouseMotionListener implements MouseMotionListener{
    public void mouseDragged (MouseEvent e ){
        System.out.println("Mouse Dragged "+e.getPoint().toString());
    }
    public void mouseMoved ( MouseEvent e){
        System.out.println("Mouse Moved :"+e.getPoint().toString());

    }
}