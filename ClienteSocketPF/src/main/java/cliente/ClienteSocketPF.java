package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSocketPF {

    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost",5000);
            System.out.println("Se ha conectado al server");
            
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream,true);
            PrintWriter writerN = new PrintWriter(outputStream,true);
BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            //mandamos el mensaje
            String msj;
            int num;
            Scanner s = new Scanner(System.in); 
            System.out.println("Ingrese su nombre");
            msj = s.nextLine();
            writer.println(msj);
            System.out.println("Ingrese un numero");
            num = s.nextInt();
            writerN.println(num);
            //leemos mensaje
            String res = reader.readLine();
            System.out.println("Respuesta del server: " + res);
            socket.close();
        }catch(IOException e){
        System.out.println(e);}
    }
}
