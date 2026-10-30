package clientPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

        static final String HOST = "localhost";
        static final int PORT = 1234;

        public static void main(String[] args) {
            try {
                System.out.println("Connexion au serveur...");
                Socket socket = new Socket(HOST, PORT);
                System.out.println("Connecté au serveur !");

                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message = br.readLine();
                System.out.println("Message reçu : " + message);

                socket.close();
            } catch (IOException e) {
                System.out.println("Erreur côté client : " + e.getMessage());
            }
        }
    }



