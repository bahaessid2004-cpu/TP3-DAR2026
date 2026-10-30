package serveurPackage;
import java.io.Serializable;

public class Operation implements Serializable{

        private int a, b;
        private char operateur;

        public Operation(int a, int b, char operateur) {
            this.a = a;
            this.b = b;
            this.operateur = operateur;
        }

        public int getA() { return a; }
        public int getB() { return b; }
        public char getOperateur() { return operateur; }
    }


