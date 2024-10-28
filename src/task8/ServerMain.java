package task8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    
    public static void main(String[] args) throws IOException {

        int port = Integer.valueOf(args[0]);


        //Instantiate server socket
        ServerSocket server = new ServerSocket(port);

        Socket sock = server.accept();

        // Instantiate reader and writer
    
        InputStream is = sock.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        DataInputStream dis = new DataInputStream(bis);

        OutputStream os = sock.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        DataOutputStream dos = new DataOutputStream(bos);

        while (true) {
            String command = dis.readUTF();
        
            if (command.equals("quit")) {
                break;
            }

            dos.writeUTF(String.valueOf(calculate(command)));
            dos.flush();
        }

        dis.close();
        bis.close();
        is.close();

        dos.close();
        bos.close();
        os.close();

        server.close();
       
    }

    private static double calculate(String command) {

        String[] parts = command.split(" ");

        double firstNumber = Double.valueOf(parts[0]);

        double secondNumber = Double.valueOf(parts[2]);

        String sign = parts[1];

        double result = 0;

        switch (sign) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                    break;
                }
                break; 
        }

        return result;
    }





    
}
