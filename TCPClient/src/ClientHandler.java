import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler {

    public void myfunction(){
        boolean running = true;
        try {
            Socket socket = new Socket("localhost", 6780);
            System.out.println("Har oprettet forbindelse til server");

            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(isr);

            Scanner scan = new Scanner(System.in);
            while (running){
                System.out.println("Skriv din besked: ");
                pw.println(scan.nextLine());

                String msg = bufferedReader.readLine();
                System.out.println("Modtaget fra server: " + msg);
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
