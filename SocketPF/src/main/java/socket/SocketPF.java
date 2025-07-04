package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;

/**
 *
 * @author carlo
 */
public class SocketPF {

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Esperando conexiones...");
            Socket socketCliente = serverSocket.accept();
            System.out.println("Cliente se conecta desde: " 
                    + socketCliente.getInetAddress());
            //flujos de entrada y salida
            InputStream inputStream = socketCliente.getInputStream();
            OutputStream outputStream = socketCliente.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);
            String msg = reader.readLine();
            int n = Integer.parseInt(reader.readLine());
            int n2 = n*n;
            LocalDate fecha = LocalDate.now();
            System.out.println("msg del cliente: " + msg + " "+n+" "+ n2);
            writer.println("Bienvenido " + msg + " " +n2 +" "+ fecha);
            socketCliente.close();
            serverSocket.close();
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
