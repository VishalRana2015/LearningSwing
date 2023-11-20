package Chooser;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import javax.swing.filechooser.*;
import java.io.*;

public class CustomFileFilterExample {
    public static void main(String[] args) {
        CustomFileFilterdoc filter = new CustomFileFilterdoc("Custom FileFilter","pdf","doc","mp4");
        JFileChooser filechooser = new JFileChooser();
        JFrame frame  = new JFrame("Custrom File Filter Doc");
        frame.setLocation(50,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        filechooser.setFileFilter( filter);
        JButton button = new JButton("Open File Chooser");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filechooser.showOpenDialog(frame);
            }
        });
        File currentdir = new File("C:\\Users\\RANA1947\\Desktop");
        filechooser.setCurrentDirectory(currentdir);
        filechooser.setFileView( new MyFileView());
        frame.setContentPane(button);
        frame.setVisible(true);
    }
}

class CustomFileFilterdoc extends javax.swing.filechooser.FileFilter{
    String description;
    String[] exts;
    public CustomFileFilterdoc(String desp, String ... exts){
        this.exts = exts;
        this.description = desp;
    }

    public boolean accept( File f){
        String ext = getExtension(f);

        if ( ext == null)
            return true;

        for ( int i =0; i < exts.length ; i++){
            if ( exts[i].equals(ext))
                return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public static String getExtension(File f){
        String name = f.getName();
        String extension;
        int index;
        index = name.lastIndexOf('.');
        if ( index > 0 && index < name.length() -1)
            extension = name.substring(index+1);
        else
            extension = null;

        return extension;
    }
}

class MyFileView extends FileView {
    @Override
    public Icon getIcon(File f ){
        Icon icon = null;
        if ( f.isDirectory()){
            icon = new ImageIcon("C:\\Users\\RANA1947\\IdeaProjects\\JAVA1\\Images\\folder.jpg");
        }
        else {
            String extension = CustomFileFilterdoc.getExtension(f);

            if (extension.equals("jpg") || extension.equals("png") || extension.equals("tiff") || extension.equals("bmp"))
                icon = new ImageIcon("C:\\Users\\RANA1947\\IdeaProjects\\JAVA1\\Images\\photo.jpg");
            if (extension.equals("doc")||  extension.equals("txt") )
            icon = new ImageIcon("C:\\Users\\RANA1947\\IdeaProjects\\JAVA1\\Images\\document.jpg");
            if (extension.equals("pdf"))
                icon = new ImageIcon("C:\\Users\\RANA1947\\IdeaProjects\\JAVA1\\Images\\pdf.jpg");
            if (extension.equals("mp4") || extension.equals("webm") || extension.equals("avi") || extension.equals("wmv") || extension.equals("mov") || extension.equals("mpg"))
                icon = new ImageIcon("C:\\Users\\RANA1947\\IdeaProjects\\JAVA1\\Images\\video.jpg");

        }
        return icon;
    }

}