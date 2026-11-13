
package ventanas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grafo {

    // Lista de lugares
    private ArrayList<Lugar> lugares;

    // Lista de adyacencias
    private ArrayList<ArrayList<Arista>> adyacencias;

    // Constructor
    public Grafo() {

        lugares = new ArrayList<>();

        adyacencias = new ArrayList<>();

    }

    // Agregar un lugar
    public void agregarLugar(Lugar lugar) {

        if (buscarIndice(lugar.getNombre()) != -1) {

            throw new IllegalArgumentException( "El lugar ya existe");

        }

        lugares.add(lugar);

        // Crear una lista de conexiones para ese lugar
        adyacencias.add(new ArrayList<>());

    }

    // Buscar la posicion de un lugar
    private int buscarIndice(String nombre) {

        for (int i = 0; i < lugares.size(); i++) {

            if (lugares.get(i).getNombre().equals(nombre)) {

                return i;

            }

        }

        return -1;

    }

    // Agregar conexion bidireccional
    public void conectar(
        String origen,
        String destino,
        double peso
    ) {

        if (peso < 0) {

            throw new IllegalArgumentException("El peso no puede ser negativo");

        }

        int indiceOrigen = buscarIndice(origen);

        int indiceDestino = buscarIndice(destino);

        if (indiceOrigen == -1 || indiceDestino == -1) {

            throw new IllegalArgumentException("Uno de los lugares no existe");

        }

        // Obtener los objetos Lugar
        Lugar lugarOrigen = lugares.get(indiceOrigen);

        Lugar lugarDestino = lugares.get(indiceDestino);

        // Conexion de origen a destino
        adyacencias.get(indiceOrigen).add( new Arista(lugarDestino, peso) );

        // Conexion de destino a origen
        adyacencias.get(indiceDestino).add(new Arista(lugarOrigen, peso) );

    }

    // Obtener todos los lugares
    public List<Lugar> getLugares() {

        return Collections.unmodifiableList(lugares);

    }

    // Obtener conexiones de un lugar
    public List<Arista> getAdyacencias(String nombre) {

        int indice = buscarIndice(nombre);

        if (indice == -1) {

            return Collections.emptyList();

        }

        return Collections.unmodifiableList(adyacencias.get(indice));

    }

    // Buscar un lugar
    public Lugar buscarLugar(String nombre) {

        int indice = buscarIndice(nombre);

        if (indice == -1) {
            return null;
        }

        return lugares.get(indice);

    }

}
