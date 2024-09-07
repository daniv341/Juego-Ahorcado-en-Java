import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        //si deseas cambiar el nombre del .java debes poner el mismo nombre despues de class y en el archivo
        Scanner scanner=new Scanner(System.in);
        String palabra="webonaso";
        int intentos=0;
        int intentosMaximos=10;
        //int contador=0;
        boolean resultado=false;

        char[] letrasAdivinadas= new char[palabra.length()];

        for (int index = 0; index < letrasAdivinadas.length; index++) {
            letrasAdivinadas[index]='_';
            
        }

        while (intentos<intentosMaximos || !resultado){
            System.out.println("palabra a adivinar: "+String.valueOf(letrasAdivinadas)+"(tamanio palabra: "+palabra.length()+")");
            System.out.println("introduce 1 letra, por favor");
            //tomara solo la primera letra
            char letra= Character.toLowerCase(scanner.next().charAt(0));
            boolean letraCorrecta=false;

            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i)==letra) {
                    letrasAdivinadas[i]=letra;
                    //evita que se reduzca el intento
                    letraCorrecta=true;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("letra incorrecta, pierde 1 intento, te quedan "+(intentosMaximos-intentos)+" intentos");
                
            }
            if(String.valueOf(letrasAdivinadas).equals(palabra)){
                System.out.println("Felicidades, haz adivinado la palabra"+palabra);
                
            }
            
        }
        if (!resultado) {
            System.out.println("perdiste webozaso");
        }
        
        scanner.close();

    }
}
