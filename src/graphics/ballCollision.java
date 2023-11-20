package graphics;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class ballCollision {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ball Collision");
        frame.setSize(700,400);
        frame.setLocation(50,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Random rand = new Random();
        System.out.println(rand.nextDouble());
        System.out.println(rand.nextDouble());
        System.out.println(rand.nextInt(1000));
        int r,g,b;
        r = rand.nextInt(255);
        g = rand.nextInt(255);
        b = rand.nextInt(255);
        Color color = new Color(r,g,b);
        MyPanel panel = new MyPanel( 50,600, 300, 20, 30);
        frame.setContentPane(panel);
        frame.setVisible(true);
        try {
            while (true) {
                Thread.sleep(16);
                Container c = frame.getContentPane();
                int width;
                width = c.getWidth();
                panel.repaint();
            }
        }
        catch( Exception e){
            System.out.println("Exception thrown : "+e.getMessage());
        }


    }
}


class MyPanel extends JPanel{
    int n, width , height;
    Ball[] ball;
    public MyPanel( int n , int width, int height , int minradius , int maxradius){
        this.n = n;
        this.height = height;
        this.width = width;
        // Generating balls
        int radius, xc, yc, dx, dy;
        Color color;
        Random rand = new Random();
        // variables for color
        int r,g,b;
        ball= new Ball[n];
        for ( int i = 0; i < n ; i++){
            radius = minradius + (int)Math.ceil(rand.nextInt(maxradius-minradius));
            xc = rand.nextInt(width -radius);
            yc =rand.nextInt(height- radius);
            dx = rand.nextInt(8);
            dy = rand.nextInt(8);
            r = rand.nextInt(255);
            g = rand.nextInt(255);
            b = rand.nextInt(255);
            color = new Color(r,g,b);
            // also check that these new values does not collide with any other previous values
            int j;
            for ( j = 0; j < i; j++){
                if ( distance(xc,yc,ball[j].xc,ball[j].yc) < radius + ball[j].radius){
                    i = i -1;
                    break;
                }
            }
            if ( j == i )
                ball[i] = new Ball(xc,yc,radius,dx,dy,color);
        }

    }
    public static int distance ( int x1, int y1, int x2, int y2){
        double dis ;
        dis = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
        int distance =( int)dis;
        return distance;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gd = (Graphics2D)g;
        for ( int i =0; i < n; i++){
            ball[i].drawBall(g);
            ball[i].updatex(width);
            ball[i].updatey(height);
        }
    }


}

class Ball{
    int xc, yc, radius, dx, dy;
    Color color;
    public Ball(int xc, int yc, int radius, int dx, int dy, Color color){
        this.xc = xc;
        this.yc = yc;
        this.radius = radius;
        this.dx = dx;
        this.dy = dy;
        this.color = color;
    }
    public void drawBall( Graphics g){
        g.setColor(color);
        g.fillOval(xc,yc,radius, radius);
    }
    public void updatex(int width){
        xc = xc + dx;
        if ( xc  <= 0){
            xc  = 0;
            dx = -dx;
        }
        else{
            if ( xc >= width-radius){
                xc = width-radius;
                dx =-dx;
            }
        }
    }

    public void updatey( int height){
        yc = yc + dy;
        if ( yc <= 0){
            yc = 0;
            dy  = -dy;
        }
        else{
            if ( yc >= height - radius){
                yc = height-radius;
                dy = -dy;
            }
        }
    }
}