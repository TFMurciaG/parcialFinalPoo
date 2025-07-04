
package hilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ManejoClientes implements Runnable {
    private Socket socketCliente;

    public ManejoClientes(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }
    
    @Override
    public void run(){
        try{
            InputStream inputStream = socketCliente.getInputStream();
            OutputStream outputStream = socketCliente.getOutputStream();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);
            
            String msg = reader.readLine();
            System.out.println("msg cliente: " + msg);
            
            writer.println("respuesta del server");
            socketCliente.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
}
