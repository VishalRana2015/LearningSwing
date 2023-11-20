package EditorPane;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class EditorPaneExample {
    public static void main(String[] args) {
        JEditorPane pane = null;
        try{
            pane = new JEditorPane("http://microsoft.com");
        }
        catch(IOException e){
            System.out.println("Exceptin thrown : "+e.getMessage());
        }


        JFrame frame = new JFrame( );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new JScrollPane(pane));
        frame.setSize(350,400);
        frame.setVisible(true);

    }
}

