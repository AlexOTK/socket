
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Observable implements Runnable{

    private int port;

    public Cliente(int port) {
        this.port = port;
    }
    
    @Override
    public void run() {
        //Host del servidor
        final String HOST = "127.0.0.1";
        try {
            //Creo el socket para conectarme con el cliente
            Socket socket = new Socket(HOST, port);
            //Las entradas son guardadas en la variable
            ObjectInputStream objIS = new ObjectInputStream(socket.getInputStream());
            
            while (true) {
                //Se leen las entradas y se agurdan en la variable g de tipo GAS
//                Gas g = (Gas) objIS.readObject();
               
                //notifica cambios por medio del observable
                this.setChanged();
                this.notifyObservers(objIS.readObject());
                this.clearChanged();
                
            }

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
