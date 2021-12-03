
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor implements Runnable{
    
    //Se hace un lista de cLientes, variable para el puerto
    private ArrayList<Socket> clients;
    private int port;
    
    public Servidor(int port) {
        this.port = port;
        this.clients = new ArrayList();
    }

    @Override
    public void run() {
        ServerSocket server = null;
        Socket sc = null;
        DataInputStream in;

        try {
            //Creamos el socket del servidor
            server = new ServerSocket(port);
            System.out.println("Servidor iniciado");

            //Siempre estara escuchando peticiones
            while (true) {
                //Espero a que un cliente se conecte
                sc = server.accept(); 
                System.out.println("Cliente conectado");
                //Agrega cliente al socket
                clients.add(sc);

            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void sendInfo(Gas g) {
        //Recorre la lista de clinetes
        for (Socket socket : clients) {

            try {
                //Las salidas son aguardadas en la variable
                ObjectOutputStream objOS = new ObjectOutputStream(socket.getOutputStream());
                //Escribe los valores de la clase GAS en el OOS que van de salida
                objOS.writeObject(g);
                objOS.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
