package Networking.UDP;
import java.net.*;
import java.io.*;
import java.util.*;
public class server {
    public static void main(String[] args) {
        // server side application demo
        // Creating a socket to listen for UDP packet at port 5000
        try{
            DatagramSocket socket  = new DatagramSocket(5000);
            // Creating a datagram packet to store the retrieved information
            byte[] data;
            int length;
            data = new byte[10];
            length = 2;
            boolean finished = false;
            DatagramPacket packet = new DatagramPacket(data,length);
            String line;
            while ( !finished ){
                // reading a packet
                socket.receive(packet); // receiving a packet from port no. 5000 and blocking all operation till that.
                line = new String(data);
                System.out.println("Client : "+line);
                if ( line.toLowerCase().equals("exit") )
                    finished = true;
            }
        }
        catch(Exception e){
            System.out.println("Exception thrown : "+e.getMessage());
        }
     }
}
