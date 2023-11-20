import java.rmi.*;


public interface Chat extends Remote {
    public String chatting( String messagegot) throws RemoteException;
}

