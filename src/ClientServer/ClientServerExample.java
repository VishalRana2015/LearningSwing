package ClientServer;
import java.net.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Color;
import java.awt.*;
// Create a program that initimate the behavior of nslookup utility
// The nslookup utility resolves ip address from name and vice versa
// It goes in the interactive mode if no argument is supplied
// otherwise, it resolve the name and produces the output
// In the interactive mode, user can enter name of IP address and the system tries to resolve the input.
public class ClientServerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame ("New Frame");
        // Creating a simple web server application from the main menu ant the things that are written so far.
        try{
            InetAddress address = InetAddress.getByName("www.oreilly.com");
            JLabel label = new JLabel("This is label");
            label.setBorder ( new EtchedBorder(EtchedBorder.RAISED,Color.BLUE,Color.RED));
            frame.setSize(500,500);
            frame.setLocation(50,0);
            JPanel panel = new JPanel();
            frame.setLayout(new BorderLayout());
            panel.setSize(400,400);
            panel.setPreferredSize(new Dimension(400,400));
            panel.getInsets(new Insets(10,10,10,10));
            label.setPreferredSize(new Dimension(100,100));
            label.setSize(100,100);

            MyBorder border = new MyBorder( new Insets(10,10,10,10));
            label.setBorder(border);
            border.setColor(Color.RED);
            panel.add(label);
            frame.add(panel,BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);
        }
        catch(UnknownHostException e){
            System.out.println("Exception thrown : "+e.getLocalizedMessage());
        }
    }
    static class MyBorder extends BevelBorder{
        Insets inset ;
        Color color;
        public MyBorder(Insets inset){
            super(BevelBorder.RAISED);
            this.inset = inset;
            color = Color.BLUE;
        }
        @Override
        public void paintBorder( Component c , Graphics og , int x, int y , int width , int height){
            Graphics2D g = (Graphics2D)og;
            g.setColor(color);
            g.fillRoundRect(x,y,width,inset.top,10,10);
            g.fillRoundRect(x,y,x+inset.left,y+height,10,10);
            g.fillRoundRect(x+width-inset.left,y,x+width,y+height,10,10);
            g.fillRoundRect( x,y+height-inset.top,x+width,y+height,10,10);
            //g.fillRoundRect(x+15,y+15,50,50,5,5);
            g.drawString(((JLabel)c).getText(),x+inset.left+5,(y+height)/2);

        }
        public void setColor( Color color){
            this.color = color;
        }

    }
}
