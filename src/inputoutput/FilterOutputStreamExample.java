package inputoutput;
import java.io.*;

public class FilterOutputStreamExample {
    public static void main(String[] args) {
        InputStream in;
        OutputStream out;
        try {
           byte[] b = {71,72,73,74,75,76,77};
           ByteArrayInputStream input = new ByteArrayInputStream(b);
           System.out.println(new String(b));

        }
        catch(Exception e ){
            System.out.println(e.getMessage());
        }
    }
}
