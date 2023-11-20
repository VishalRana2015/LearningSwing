package Chooser;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.lang.*;
import javax.swing.filechooser.*;

public class FileSystemViewExample {
    public static void main(String[] args) {
        AudioClip clip;
        JFileChooser chooser = new JFileChooser();
        FileSystemView fsv = FileSystemView.getFileSystemView();
        System.out.println(fsv.getDefaultDirectory());
        File dir = new File("C:\\Users");
        File[] files = fsv.getFiles(dir,false);
        for ( File file : files){
            System.out.println(file);
        }
        System.out.println("FileHomeDirectory : "+fsv.getHomeDirectory());
        System.out.println("Get Parent Directory of  "+dir+": "+fsv.getParentDirectory(dir));
        System.out.print("Root Partitions :  ");
        File[] partitions = fsv.getRoots();
        for ( File partition : partitions ){
            System.out.print(partition +",");
        }
        ImageIcon icon = (ImageIcon)fsv.getSystemIcon(dir);
        JFrame frame = new JFrame ("FileSystemView");
        frame.setSize(500,500);
        frame.setLocation(50,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel(icon);
        frame.setContentPane(label);
        frame.setVisible(true);
        System.out.println();
        System.out.println("System Type Descriptio for a file "+dir+" : "+fsv.getSystemTypeDescription(dir));
        File file = new File("C:\\Users\\RANA1947\\codekaze2.cpp");
        System.out.println("Type Description for file "+file+" : "+fsv.getSystemTypeDescription(file));
        System.out.println(file+" is root"+fsv.isRoot(file));
        System.out.println(dir+" is root : "+fsv.isRoot(dir));
        File mayroot = new File("C:");
        System.out.println(mayroot + " is root  : "+fsv.isRoot(mayroot));
        System.out.println(dir + " is node "+fsv.isComputerNode(dir));
        System.out.println(file + "is node " +fsv.isComputerNode(file));
        File desktop = new File("C:\\Users\\RANA1947\\Desktop");
        System.out.println(" is Desktop is root : "+fsv.isRoot(desktop));
        System.out.println(" is Desktop traversable  : "+fsv.isTraversable(desktop));
        System.out.println( " is "+file+" traversable : "+fsv.isTraversable(file));
        System.out.println(" is " +dir+" traversable : "+fsv.isTraversable(dir));

        System.out.println(" is "+mayroot+" FloopyDrive : "+fsv.isFloppyDrive(mayroot));
        System.out.println( "is  " + mayroot+ " is Drive : "+fsv.isDrive(mayroot));
        System.out.println(" system display name of "+file+": "+ fsv.getSystemDisplayName(file));
    }
}
