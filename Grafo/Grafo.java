package Grafo;

public class Grafo {
    int numVerts;
    static int MaxVerts = 20; // final lo convierte en consante
    Vertice[] verts; // array del tipo Vertice
    int[][] matrizAd; // matriz de ayd - aristas

    // Constructor de inicializacion
    public Grafo() { //pone como valor predeterminado 20 nodos
        this(MaxVerts);
    }

    public Grafo(int mx) {
        matrizAd = new int[mx][mx]; // instancia la matriz en tipo int
        verts = new Vertice[mx]; // instancia vertices del tipo Vertice
        for (int i = 0; i < mx; i++){
            for (int j = 0; i < mx; i++){
                matrizAd[i][j] = 0; // inicializa en 0 la matriz
            }
        }
        numVerts = 0; // la cant de vertices tamb
    }

    // Para crear un nuevo vertice

    // Recibe un String
    public void nuevoVertice(String nom) {
        boolean esta = numVertice(nom) >= 0; // se fija si ya está en la lista
        if (!esta) { // si no esta incrementa el número de vértices
            Vertice v = new Vertice(nom);
            v.asigVert(numVerts); // lo asigna a la lista.
            verts[numVerts++] = v; // incrementa
        }
    }

    int numVertice(String vs) { // busca el vértice en el array. Devuelve -1 si no lo encuentra
        Vertice v = new Vertice(vs); // crea un v vertice con "vs" del tipo string
        boolean encontrado = false;
        int i = 0;
        for (; (i < numVerts) && !encontrado;) {
            encontrado = verts[i].equals(v);
            if (!encontrado)
                i++;
        }
        return (i < numVerts) ? i : -1; // si es verdadero se hace la primera, si no la segunda
    }

    // Recibe el nombre de cada vértice,
    public void nuevoArco(String a, String b) throws Exception {
        int verticea, verticeb;
        verticea = numVertice(a); // busca en el array el número de vértice asignado a cada uno de ellos
        verticeb = numVertice(b);
        if (verticea < 0 || verticeb < 0)
            throw new Exception("No existe");
        matrizAd[verticea][verticeb] = 1;// Marca la matriz.
    }

    // public void nuevoArco(int va, int vb) throws Exception {
    // if (va < 0 || vb < 0)
    // throw new Exception("Vértice no existe");
    // matrizAd[va][vb] = 1;
    // }

    // Determina si hay un enlace entre ambos nodos
    public boolean adyacente(String a, String b) throws Exception {
        int verticea, verticeb;
        verticea = numVertice(a);
        verticeb = numVertice(b);
        if (verticea < 0 || verticeb < 0)
            throw new Exception("No existe");
        return matrizAd[verticea][verticeb] == 1;
    }

    // public boolean adyacente(int va, int vb) throws Exception {
    // if (va < 0 || vb < 0)
    // throw new Exception("No existe pa");
    // return matrizAd[va][vb] == 1;

}