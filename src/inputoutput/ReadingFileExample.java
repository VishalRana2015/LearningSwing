package inputoutput;
import java.io.*;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.event.*;
import java.awt.*;

public class ReadingFileExample {
    public static void main(String[] args) {
        JFrame frame  = new JFrame("Reading from file and Writing to JTextArea");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);


        JTextArea textarea = new JTextArea();
        textarea.setColumns(40);
        textarea .setRows(50);
        Font font = new Font("Courier New",Font.HANGING_BASELINE,12);
        textarea.setFont(font);
        textarea.setLineWrap(true);
        frame.setContentPane(textarea);

        // Reading from a file
        textarea.setCaretColor( Color.RED);
        textarea.setSelectedTextColor(Color.BLUE);
        textarea.setText("Vishal rana 007\n");
        textarea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                System.out.println("dot = "+e.getDot());
                System.out.println("mark=  "+e.getMark());

            }
        });

        // Reading from the file 'abc.txt'
        InputStream in;
        try{
            in=new FileInputStream("C:\\Users\\RANA1947\\IdeaProjects\\JAVA1\\src\\abc.txt");
            byte[] b = new byte[100];
            String s;
            while( in.read(b) != -1){
                textarea.append(b.toString());
            }

        }
        catch( Exception e){
            System.out.println(e.getMessage());
        }
    }
}
