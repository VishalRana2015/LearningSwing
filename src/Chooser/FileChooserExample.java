package Chooser;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;

public class FileChooserExample {
    public static void main(String[] args) {
        JFileChooser filechooser = new JFileChooser();
        JFrame frame = new JFrame("File Chooser Example");
        frame.setSize(500,500);
        frame.setLocation(50,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Open");
        filechooser.setApproveButtonMnemonic('O');
        filechooser.setApproveButtonToolTipText("Open a file");
        filechooser.setControlButtonsAreShown(true);
        File default_dir = new File("C:\\Users\\RANA1947\\Desktop");
        filechooser.setCurrentDirectory(default_dir);
        filechooser.setDialogTitle("Select a file.");
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        filechooser.setApproveButtonText("Accept");
        filechooser.setFileFilter( new FileNameExtensionFilter("Documents ","pdf","doc","xml"));
        filechooser.setAcceptAllFileFilterUsed(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int return_value =filechooser.showOpenDialog(frame);
                if ( return_value == JFileChooser.APPROVE_OPTION) {
                    System.out.println("Selected File" + filechooser.getSelectedFile());
                }
                else
                    System.out.println("No File Selected");
            }
        });
        frame.setContentPane(button);


        frame.setVisible(true);
    }
}
