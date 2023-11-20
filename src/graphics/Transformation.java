package graphics;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.geom.AffineTransform;

public class Transformation {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Transformation Example");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(50,0);
        PanelDuplicate panel = new PanelDuplicate();
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}


class PanelDuplicate extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        double[] array = new double[6];
        AffineTransform ts;
        Graphics2D gd = (Graphics2D)g;
        ts = gd.getTransform();
        int height , width;
        width = this.getWidth();
        height = this.getHeight();
        ts.translate( width/2 , height/2);
        ts.scale(1,-1);
        ts.getMatrix(array);
        gd.setTransform(ts);
        gd.drawRect(100,100,100,100);
        gd.drawLine(-292,0,292,0);
        gd.drawLine(0,280,0,-280);
        gd.rotate(3.14/4);
        gd.drawRect(100,100,100,100);
        ts.scale(4,4);
        System.out.println("width of tip : "+((BasicStroke)gd.getStroke()).getLineWidth());
        gd.setTransform(ts);
        System.out.println("widht of tip after transform : "+((BasicStroke)gd.getStroke()).getLineWidth());
        gd.drawRect( 0,0,20,20);
        for (int i =0; i < 6 ;i++)
            System.out.println("array[i]" + array[i]);
    }
}