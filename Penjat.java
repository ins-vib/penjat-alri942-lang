import java.util.Random;
import java.util.Scanner;

public class Penjat {

    static final String[] PARAULES = {
        "hola","cadira","tisores","riu","fotografia","escala",
        "llibre","ordinador","ratoli","armari","pati","programa","columna"
    };

    static final String[] DIBUIXOS = {
        """
           +---+
               |
               |
               |
              ===
        """,
        """
           +---+
           O   |
               |
               |
              ===
        """,
        """
           +---+
           O   |
           |   |
               |
              ===
        """,
        """
           +---+
           O   |
          /|   |
               |
              ===
        """,
        """
           +---+
           O   |
          /|\\  |
               |
              ===
        """,
        """
           +---+
           O   |
          /|\\  |
          /    |
              ===
        """,
        """
           +---+
           O   |
          /|\\  |
          / \\  |
              ===
        """
    };

    static Scanner teclat = new Scanner(System.in);

    public static String obtenirParaula() {
        Random generador = new Random();
        return PARAULES[generador.nextInt(PARAULES.length)];
    }

    public static void mostrarNinot(int errors) {
        System.out.println(DIBUIXOS[errors]);
    }

    public static char demanarLletra() {
        char lletra;

        while (true) {
            System.out.print("Entra una lletra: ");
            String entrada = teclat.nextLine().toLowerCase();

            if (entrada.length() == 1 && entrada.charAt(0) >= 'a' && entrada.charAt(0) <= 'z') {
                lletra = entrada.charAt(0);
                break;
            }

            System.out.println("Error: has d'escriure una lletra de la 'a' a la 'z'.");
        }

        return lletra;
    }

    public static char[] inicialitzarEstat(String paraula) {
        char[] estat = new char[paraula.length()];
        for (int i = 0; i < estat.length; i++) {
            estat[i] = '_';
        }
        return estat;
    }

    public static boolean actualitzarEstat(char[] estat, String paraula, char lletra) {
        boolean trobada = false;
        for (int i = 0; i < paraula.length(); i++) {
            if (paraula.charAt(i) == lletra) {
                estat[i] = lletra;
                trobada = true;
            }
        }
        return trobada;
    }

    public static void mostrarEstat(char[] estat) {
        for (char c : estat) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static boolean paraulaCompletada(char[] estat) {
        for (char c : estat) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String paraula = obtenirParaula();
        char[] estat = inicialitzarEstat(paraula);
        int errors = 0;

        System.out.println("PARAULA:");
        mostrarEstat(estat);

        while (errors < 6 && !paraulaCompletada(estat)) {
            System.out.println("Errors: " + errors + "/6");
            mostrarNinot(errors);

            char lletra = demanarLletra();

            if (actualitzarEstat(estat, paraula, lletra)) {
                System.out.println("Molt bé! La lletra '" + lletra + "' hi és!");
            } else {
                System.out.println("Llàstima! La lletra '" + lletra + "' no hi és.");
                errors++;
            }

            mostrarEstat(estat);
        }
      
        if (paraulaCompletada(estat)) {
            System.out.println("FELICITATS! Has encertat la paraula: " + paraula);
        } else {
            System.out.println("Has perdut! La paraula era: " + paraula);
            mostrarNinot(6);
        }
    }
}
