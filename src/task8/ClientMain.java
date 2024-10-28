package task8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.OutputStream;
import java.io.InputStream;

public class ClientMain {
    
    public static void main(String[] args) throws UnknownHostException, IOException{
        int port = Integer.valueOf(args[0]);

        String host = args[1];

        Socket sock = new Socket(host, port);

        OutputStream os = sock.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        DataOutputStream dos = new DataOutputStream(bos);

        InputStream is = sock.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        DataInputStream dis = new DataInputStream(bis);

        Console cons = System.console();
        
        while (true) {
            System.out.print("Command: ");
            String command = cons.readLine().trim().toLowerCase();

            if (command.equals("quit")) {
                dos.writeUTF(command);
                dos.flush();
                break;
            }

            dos.writeUTF(command);
            dos.flush();

            double result = Double.valueOf(dis.readUTF());
            System.out.printf("Result: %.2f\n", result);
        }

        dos.close();
        bos.close();
        os.close();

        dis.close();
        bis.close();
        is.close();

        sock.close();
    }
    
}
