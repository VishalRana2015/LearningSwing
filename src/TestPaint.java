import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.color.*;

public class TestPaint {
    // a static internal class
    static class MyPanel extends Panel{
        MyPanel(){
            super();
            System.out.println("Constructor initialized");
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D canvas = (Graphics2D)g;
            float [] dastArray = {10,10};
            BasicStroke bs = new BasicStroke(1,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER,10,dastArray,0);
            canvas.setStroke(bs);

            canvas.setPaint(Color.PINK);
            canvas.fill3DRect(40,150,100,100,false);
            canvas.fillRect(20,20,300,100);
            canvas.setPaint(Color.BLACK);
            canvas.drawRect(20,20,300,100);



        }
    }

    public static void main(String[] args) {
        MyPanel panel  = new MyPanel();
        JFrame frame  = new JFrame("Canvas");
        frame.setSize(500,500);
        frame.setLocation(50,0);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        Container c = frame.getContentPane();
        c.add(panel,BorderLayout.CENTER);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

