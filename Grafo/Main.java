package Grafo;
import java.io.BufferedReader;

class Main {

    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String opcion = "";

        System.out.print("\033[H\033[2J");
        System.out.println("Bienvenido");

        do {
            opcionesMenu();
            try {
                opcion = entrada.readLine();
            } catch (IOException e) {
                System.out.println("Elija una opción de la lista.");
            }
            switch (opcion) {
                case "1":
                    System.out.print("\033[H\033[2J");
                    break;
                case "2":
                    System.out.print("\033[H\033[2J");
                    break;
            }
         } while (!opcion.equals("2"));
    }

    public static void opcionesMenu(){
        System.out.println("Seleccione una opción:");
        System.out.println("1) Insertar Vertice");
        System.out.println("2) Salir");
    }
}