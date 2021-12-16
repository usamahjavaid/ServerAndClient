import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) {

     new Thread( () ->{
        try {
            //Trin 1 - Lav server socket
            ServerSocket serverSocket = new ServerSocket(1996);

            // Trin 2 - Få en socket til at lytte på den angivet port
            System.out.println("Accepting connection on port 1997");
            Socket socket = serverSocket.accept();
            System.out.println("Connection established" + socket.getRemoteSocketAddress().toString());

            // Trin 3 - Data ind og ud
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            // Trin 4 - Her kan man sende og modtage data
            while (true) { // Evig løkke
                String incomingText = inputStream.readUTF();
                System.out.println("Tekst modtaget: " + incomingText);

                outputStream.writeUTF("Tak for teksten, den er modtaget: " + incomingText);
                outputStream.flush(); // Når man skriver noget (se linje 25), så husk at flush)
            }

            // Trin 5 - Luk forbindelsen
            //socket.close(); - udkommenteret når man sætter trin 4 i en while loop

        } catch (IOException e) {
            e.printStackTrace();
        }
    }).start();
}
}


