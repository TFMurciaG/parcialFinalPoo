
package hilos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketsHilosPF {

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server esperando conexiones...");
            
            while(true){
                Socket socketCliente = serverSocket.accept();
                System.out.println("CLiente conectado desde: " 
                        + socketCliente.getInetAddress());
                new Thread(new ManejoClientes(socketCliente)).start();
            }
        }catch(IOException e){
            System.out.println(e);
        }
        
    }
}

