import java.rmi.*;
import java.rmi.server.*;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.io.*;
import java.util.Scanner;

public class server extends UnicastRemoteObject implements Chat {
    public server() throws RemoteException {
    }

    public String chatting(String messagegot) throws RemoteException {
        String messagetosent;
        System.out.println(messagegot);
        Scanner input;
        input = new Scanner(System.in);
        char ch;
        ch = 'y';

        messagetosent = input.nextLine();

        return "vishal: "+messagetosent;

    }



    public static void main(String[] args) {
        try{
            Registry reg = LocateRegistry.createRegistry(5000);
            reg.rebind("rmiserver",new server());
        }
        catch( RemoteException e ){
            System.out.println(e);
        }
    }

}
