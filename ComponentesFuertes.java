import java.io.*;
import Grafo.*;

public class ComponentesFuertes{
    static BufferedReader entrada = new BufferedReader(
    new InputStreamReader(System.in));
    static final int CLAVE = 0xffff;
    public static void main(String [] a)throws Exception{
        int n, i, v;
        GrafoMatriz ga;
        GrafoMatriz gaInverso;
        System.out.print("Número de vértices del grafo: ");
        n = Integer.parseInt(entrada.readLine());
        ga = new GrafoMatriz(n);
        gaInverso = new GrafoMatriz(n);
        int []m = new int [n];
        int []descendientes = new int[n];
        int []ascendientes = new int[n];
        int []bosque = new int[n];
        entradaGrafo(ga, n);
        grafoInverso(ga, gaInverso, n);
        Vertice [] vs = new Vertice[n];
        vs = ga.vertices();
        for (i = 0; i < n; i++)
        bosque[i] = 0;
        v = 0; // vértice de partida
        do {
            m = RecorreGrafo.recorrerProf(ga, vs[v].nomVertice());
            // se obtiene conjunto de vértices descendientes
            for (i = 0; i < n; i++){
                descendientes[i] = m[i]!= CLAVE ? 1 : 0;
            }
            // recorre el grafo inverso y obtiene ascendientes
            m = RecorreGrafo.recorrerProf(gaInverso, vs[v].nomVertice());
            // se obtiene conjunto de vértices descendientes
            for (i = 0; i < n; i++){
                ascendientes[i] = m[i]!= CLAVE ? 1 : 0;
            }
            System.out.print("\nComponente conexa { ");
            for (i = 0; i < n; i++){
                if (descendientes[i] * ascendientes[i] == 1){
                    System.out.print(" " + vs[i].nomVertice());
                    bosque[i] = 1;
                }
            }
            System.out.println(" }");

            // vértice a partir del cual se obtiene otra componente
            v = todosArboles(bosque,n);
        } while (v != -1);

    } // fin del método main
    static void
    grafoInverso(GrafoMatriz g, GrafoMatriz x, int n) throws Exception{
        Vertice [] vr = g.vertices();
        for (int i = 0; i < n; i++)
        x.nuevoVertice(vr[i].nomVertice());
        for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
        if (g.adyacente(i,j)) x.nuevoArco(j,i);
    }
    static int todosArboles(int [] bosque, int n){
        int i, w;
        w = i = -1;
        do
        {
        if (bosque[++i] == 0)
        w = i;
        } while ((i < n - 1) && (w == -1));
        return w;
    }
    static void entradaGrafo(GrafoMatriz gr, int n)
    throws Exception{...}
}