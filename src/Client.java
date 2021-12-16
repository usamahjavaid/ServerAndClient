import com.sun.source.tree.TryTree;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) {

        int PORT = 1996;

        try {
            Socket socket = new Socket("localhost", PORT);
            //Gøre klar til at modtage og sende data
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            while (true) {
                //Der er der, hvor man sender data til servern
                try {
                    outputStream.writeUTF(scanner.nextLine());
                    outputStream.flush();
                    //Læser data fra serveren
                    System.out.println(inputStream.readUTF());
                }
                catch (IOException e) {
                    System.out.println("Stop med at skrive til servern. Der er ingen forbindelse, dumme dig!");
                }

            }

            //socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

