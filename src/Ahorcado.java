import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palabra = "webonaso";
        int intentos = 0;
        int intentosMaximos = 10;
        boolean resultado = false;
        String letrasProbadas = "";

        char[] letrasAdivinadas = new char[palabra.length()];
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        while (intentos < intentosMaximos && !resultado) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas));
            System.out.println("Introduce una letra:");

            String entrada = scanner.next().toLowerCase();
            if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
                System.out.println("Entrada no válida. Escribe una sola letra.");
                continue;
            }

            char letra = entrada.charAt(0);
            if (letrasProbadas.indexOf(letra) >= 0) {
                System.out.println("Ya probaste esa letra. Intenta con otra.");
                continue;
            }
            letrasProbadas += letra;

            boolean letraCorrecta = false;
            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("Letra incorrecta. Te quedan "
                        + (intentosMaximos - intentos) + " intentos.");
            }

            if (String.valueOf(letrasAdivinadas).equals(palabra)) {
                resultado = true;
                System.out.println("¡Felicidades! Adivinaste la palabra: " + palabra);
            }
        }

        if (!resultado) {
            System.out.println("Perdiste. La palabra era: " + palabra);
        }

        scanner.close();
    }
}
