import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerHandler {

    public void myfunction(){
        boolean running = true;
        try {
            ServerSocket serverSocket = new ServerSocket(6780);
            System.out.println("Server er klar til at modtage klient");
            Socket socket = serverSocket.accept();
            System.out.println("Forbindelse til klient oprettet");
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(isr);

            Scanner scan = new Scanner(System.in);
            while (running) {
                String msg = bufferedReader.readLine();
                System.out.println("Modtager fra klient: " + msg);

                System.out.println("Skriv din besked: ");
                pw.println(scan.nextLine());
                if (msg.equalsIgnoreCase("exit")){
                    running = false;
                }
            }
            socket.close();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
