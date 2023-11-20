package Networking.UDP;
import java.net.*;
import java.io.*;
import java.util.*;
public class client {
    public static void main(String[] args) {
        // to send a packet first a socket is needed
        try {
            // using default constructor to send packet through any port available to it.
            DatagramSocket socket = new DatagramSocket();
            InetAddress local = InetAddress.getLocalHost();
            byte[] data = new byte[40];
            int length = 40;
            DatagramPacket packet = new DatagramPacket(data, length, local, 5000);
            boolean finished = false;
            String line;
            while (!finished) {
                Scanner input = new Scanner(System.in);
                line = input.nextLine();
                data = line.getBytes();
                length = data.length;
                packet.setLength(length);
                packet.setData(data);
                socket.send(packet);
                if (line.toLowerCase().equals("exit"))
                    finished = true;
            }
        }
        catch(Exception e){
            System.out.println("Exception caugth : "+e.getMessage());
        }
    }
}
