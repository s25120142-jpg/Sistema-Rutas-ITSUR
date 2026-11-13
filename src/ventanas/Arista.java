
package ventanas;

public class Arista {

    // Lugar al que lleva la conexion
    private Lugar destino;

    // Distancia entre los lugares
    private double peso;

    // Constructor
    public Arista(Lugar destino, double peso) {

        this.destino = destino;
        this.peso = peso;

    }

    // Obtener destino
    public Lugar getDestino() {
        return destino;
    }

    // Obtener peso
    public double getPeso() {
        return peso;
    }

}
