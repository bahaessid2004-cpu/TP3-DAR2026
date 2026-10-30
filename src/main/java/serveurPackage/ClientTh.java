package serveurPackage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
public class ClientTh extends Thread{
        private Socket socket;
        private int numero;

        public ClientTh(Socket socket, int numero) {
            this.socket = socket;
            this.numero = numero;
        }

        @Override
        public void run() {
            try {
                System.out.println("Dialogue avec client n°" + numero);
                OutputStream os = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(os, true);
                pw.println("Bienvenue, vous êtes le client n°" + numero);
                socket.close();
            } catch (IOException e) {
                System.out.println("Erreur côté ClientProcess : " + e.getMessage());
            }
        }
    }


