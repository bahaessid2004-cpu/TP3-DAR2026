package clientPackage;
import serveurPackage.Operation;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientMT {

        public static void main(String[] args) {
            try {
                Socket socket = new Socket("localhost", 1234);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Scanner sc = new Scanner(System.in);

                while (true) {
                    System.out.print("Donnez une opération (ex: 10 + 5) ou 'quit' : ");
                    String saisie = sc.nextLine();
                    if (saisie.equalsIgnoreCase("quit")) break;

                    String[] parts = saisie.split(" ");
                    int a = Integer.parseInt(parts[0]);
                    char op = parts[1].charAt(0);
                    int b = Integer.parseInt(parts[2]);

                    Operation operation = new Operation(a, b, op);
                    oos.writeObject(operation);
                    oos.flush();

                    int resultat = (int) ois.readObject();
                    System.out.println("Résultat = " + resultat);
                }

                socket.close();
                sc.close();
            } catch (Exception e) {
                System.out.println("Erreur côté client : " + e.getMessage());
            }
        }
    }


