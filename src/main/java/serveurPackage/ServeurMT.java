package serveurPackage;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class ServeurMT {
        static final int PORT = 1234;
        static int compteurGlobal = 0;

        public static void main(String[] args) {
            try {
                ServerSocket serverSocket = new ServerSocket(PORT);
                System.out.println("Serveur calculatrice multi-threads démarré...");

                while (true) {
                    Socket socket = serverSocket.accept();
                    new Thread(() -> {
                        try {
                            java.io.ObjectInputStream ois = new java.io.ObjectInputStream(socket.getInputStream());
                            java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(socket.getOutputStream());

                            Operation op = (Operation) ois.readObject();
                            int resultat = 0;

                            switch (op.getOperateur()) {
                                case '+': resultat = op.getA() + op.getB(); break;
                                case '-': resultat = op.getA() - op.getB(); break;
                                case '*': resultat = op.getA() * op.getB(); break;
                                case '/': resultat = op.getA() / op.getB(); break;
                            }

                            oos.writeObject(resultat);

                            synchronized (ServeurMT.class) {
                                compteurGlobal++;
                                System.out.println("Opérations traitées : " + compteurGlobal);
                            }

                            socket.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
            } catch (IOException e) {
                System.out.println("Erreur côté serveur : " + e.getMessage());
            }
        }
    }



