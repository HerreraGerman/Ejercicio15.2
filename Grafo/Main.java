

class Main {

    public static void main(String[] args) {

    Grafo nombre = new Grafo(3);
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
      System.out.println("jaja xd, error (como vos)");
    }
        
}