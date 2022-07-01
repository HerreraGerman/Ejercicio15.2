package Grafo;
import java.io.BufferedReader;

class Main {

    public static void main(String[] args) {
      Grafo nombre = new Grafo(3);

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
      } while (!opcion.equals("4"));    

      nombre.mostrarMatriz();
      
      nombre.nuevoVertice("K");
      nombre.nuevoVertice("J");
      nombre.nuevoVertice("L");

      nombre.mostrarMatriz();
      System.out.println(" ");
      
      try{
        nombre.nuevoArco("K", "J");
        nombre.nuevoArco("J", "L");
        nombre.nuevoArco("L", "L");
        nombre.mostrarMatriz();
      }catch(Exception e){
        System.out.println("Error");
    }

    public static void opcionesMenu(){
      System.out.println("Seleccione una opción:");
      System.out.println("1) Insertar Vertice");
      System.out.println("2) Insertar Arco");
      System.out.println("3) Mostrar Matriz");
      System.out.println("4) Salir");
    }        
}
