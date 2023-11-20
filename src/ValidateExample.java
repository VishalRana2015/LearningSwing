
 /*       http://java.sun.com/j2se/1.3/docs/api/javax/swing/JComponent.html

        The Challenges of Cloud IntegrationDownload
        Preparing for the Internet of Things: What You Need to KnowDownload
        My understanding or invalidate(), validate(), revalidate(), repaint() is as follows -
        invalidate()/validate()/revalidate() only affects the layout. It results in a repaint
        if the layout actually changes.
        invalidate()/validate() is the mechanism for batching changes
        (like beginPaint, paint, paint, paint, endPaint of windowing SDKs). You mark, using invalidate(),
        all the components that might affect the layout as invalid. Then call the parent container's validate()
         method. In the validate() method the parent checks if at least one of its immediate children is invalid.
          If it finds a child marked invalid, it calls layoutComponents() on its layout manager.
        If the layoutmanager actually re-lays out the children, then, as a side effect, repaint() will get called.

        The thing to note here is that the Container only looks for invalid immediate children.

        For precisely this reason sometimes the resulting layout is not what you expected as the parent's parent
         and children's chidren may not get re-layed out. To work around this issue Swing added the revalidate()
         method.

        What revalidate() does is basically marks all the container upto the top level (window and its
        subclasses or applet) as invalid. Then it calls validate() on the top level.
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.VolatileImage;
import java.beans.PropertyChangeListener;
import javax.swing.border.*;

public class ValidateExample extends JFrame {
    ValidateExample(String text) {
        super(text);
    }

    public boolean set = false;
    int count = 0;

    @Override
    public void validate() {
        super.validate();
        if (set)
            System.out.println(" Validate frame" + count++);
    }

    @Override
    public void revalidate() {
        super.revalidate();
        if ( set)
            System.out.println("REvalidate Frame " + count++);
    }

    @Override
    public void invalidate() {
        super.invalidate();
        if ( set)
            System.out.println("Invalidate Frame"+ count++);
    }

    public static void main(String[] args) {
        ValidateExample ve = new ValidateExample("Validate Example Frame");
        ve.setSize(500,400);
        ve.setLocation(50,0);
        //ve.setVisible(true);
        ve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ve.getContentPane().setLayout( new BorderLayout());
        MyPanel panel1 = new MyPanel();

        JButton l1b = new JButton("Label1Button");
        JButton l2b = new JButton("Label2Button");
        panel1.setLayout(new FlowLayout());
        panel1.add(l1b);
        panel1.add(l2b);
        Container c = ve.getContentPane();
        c.add(panel1,BorderLayout.SOUTH);

        Mylabel label1 = new Mylabel(" Label1");
        Mylabel label2 = new Mylabel ("Label2 ");

        l1b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ve.set = true;
                label1.set = true;
                label2.set = true;
                Font font = new Font("Courier New",Font.ITALIC,20);
                label1.setFont(font);
                System.out.println("Action Performed on label1");
                ve.set=false;
                label1.set= false;
                label2.set = false;
            }
        });

        MyPanel panel2  = new MyPanel();
        l2b.addActionListener( new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            ve.set = true;
            panel2.set= true;
            label1.set = true;
            label2.set = true;
            Font font = new Font("Courier New",Font.ITALIC,140);
            label2.setFont(font);
            System.out.println("Action Performed on label2");

            panel2.set = false;
            ve.set=false;
            label1.set= false;
            label2.set = false;
        }
    });

        panel2.setLayout( new FlowLayout());
        panel2.add(label1);
        panel2.add(label2);
        System.out.println(label1.getParent());
        c.add(panel2,BorderLayout.CENTER);
        ve.setVisible(true);

    }

}



class MyPanel extends JPanel{
    int count;
     public boolean set;
    public MyPanel(){
        super();
        count =0;
        set = false;
    }

    @Override
    public void invalidate() {
        super.invalidate();
        if ( set) {
            System.out.println("Ivalidate Panel");
            System.out.println("JPanel Invalidate " + count++);
        }
    }

    @Override
    public void validate() {
        super.validate();
        if (set){
            System.out.println("Validate Panel " + count++);
            System.out.println("Validate panel");
        }
    }

    @Override
    public void revalidate() {
        super.revalidate();
        if ( set) {
            System.out.println("Revalidate panel");
            System.out.println("Revalidate Panel" + count++);
        }
    }
}

class Mylabel extends JLabel {
    int count ;
    public boolean set;
    public Mylabel(String text){
        super(text);
        set = false;
        count =0;
    }

    @Override
    public void revalidate() {
        super.revalidate();

        if ( set) {
            System.out.println("Revalidate " + super.getText() + " " + count++);
            System.out.println("is valid root " + this.isValidateRoot());
        }
    }

    @Override
    public void invalidate() {
        super.invalidate();

        if ( set) {
            System.out.println("Is Valid root " + this.isValidateRoot());
            System.out.println("Invalidate " + super.getText() + " " + count++);
        }
    }

    @Override
    public void validate() {
        super.validate();

        if ( set){
            System.out.println("Is valid Root "+ this.isValidateRoot());
            System.out.println("Validate "+super.getText()+" "+count++);
    }   }
}