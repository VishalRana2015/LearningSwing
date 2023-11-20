package inputoutput;
import java.io.*;
import java.util.*;
public class inputstreamExample {
    public static void main(String[] args) throws Exception{
        InputStream in ;
        try {
            in = new FileInputStream("C:\\Users\\RANA1947\\IdeaProjects\\JAVA1\\src\\abc.txt");
            if ( in == null){
                System.out.println(" in is null");
            }
            else
                System.out.println("In in not null");
            System.out.println((char)in.read());
            System.out.println((char)in.read());
           //FileInputStream and InputStream mark method does not support mark and reset
            // you can check it by markSupported() method.
            byte[] b = new byte[2];
            in.read(b);

            in.close();
        }
        catch(FileNotFoundException e ){
            System.out.println("Some thing went wrong");
            System.out.println(e.getMessage());
        }

    }
}
