import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) {


        try {
            Socket socket = new Socket("localhost", 1996);
            //Gøre klar til at modtage og sende data
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            while (true) {
                //Der er der, hvor man sender data til servern
                outputStream.writeUTF(scanner.nextLine());
                outputStream.flush();
                //Læser data fra serveren
                System.out.println(inputStream.readUTF());
            }

            //socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

