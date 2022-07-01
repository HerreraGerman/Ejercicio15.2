package Grafo;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Le faltan controladores. Ejemplo: Que no se ponga el mismo nombre de vertices */ 

class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    String opcion = "", seleccion1 = "", seleccion2 = "";
    int numVert = 0;
    int restantes = 0;
    Grafo nombre = new Grafo(3);

    System.out.print("\033[H\033[2J");
    System.out.println("Bienvenido!");

    nombre.mostrarMatriz();
      
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
          if (numVert < 3) {
            System.out.println("Ingrese el nombre del nuevo vertice");
            seleccion1 = entrada.readLine();
            nombre.nuevoVertice(seleccion1);
            System.out.print("Vertice " + seleccion1 + " ingresado");
            numVert++;
          } else {
            System.out.println("Maximo numero de vertices alcanzados!");
          }
          break;
        case "2":
          System.out.print("\033[H\033[2J");
          if (numVert != 0) {
            System.out.println("Ingrese el nombre del primer vertice para el arco");
            seleccion1 = entrada.readLine();
            System.out.println("Ingrese el nombre del segundo vertice para el arco");
            seleccion2 = entrada.readLine();
            nombre.nuevoArco(seleccion1, seleccion2);
            System.out.print("Arco entre " + seleccion1 + " y " + seleccion2 + " ingresado");
          } else {
            System.out.println("Debe ingresar nodos primero!");
          }
          break;
        case "3":
          System.out.print("\033[H\033[2J");
          if (numVert == 3) {
            nombre.mostrarMatriz();
            System.out.println(" ");
          } else {
            restantes = 3 - numVert;
            System.out.println("La matriz no esta completa! Faltan " + restantes + " vertices!");
          }
          break;
        case "4":
          System.out.print("\033[H\033[2J");
          System.out.println("See u next time!");
          break;
      }
    } while (!opcion.equals("4"));
  }

  public static void opcionesMenu(){
    System.out.println("\nSeleccione una opción:");
    System.out.println("1) Insertar Nodos");
    System.out.println("2) Insertar Arcos");
    System.out.println("3) Mostrar Matriz");
    System.out.println("4) Salir");
  }        
}
