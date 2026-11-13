
package ventanas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    // CLASE INTERNA PARA LA COLA DE PRIORIDAD

    private static class Estado implements Comparable<Estado> {

        int indice;
        double distancia;

        public Estado(int indice, double distancia) {

            this.indice = indice;
            this.distancia = distancia;

        }

        // Comparar estados por distancia
        @Override
        public int compareTo(Estado otro) {

            return Double.compare(this.distancia,otro.distancia);
        }
    }


    // CLASE PARA GUARDAR EL RESULTADO

    public static class Resultado {

        private double distancia;
        private List<Lugar> camino;

        public Resultado(double distancia, List<Lugar> camino) {

            this.distancia = distancia;

            this.camino = camino;

        }

        public double getDistancia() {

            return distancia;

        }

        public List<Lugar> getCamino() {

            return Collections.unmodifiableList(camino);

        }

        public boolean existeRuta() {

            return !camino.isEmpty();

        }

    }

    // ALGORITMO DE DIJKSTRA

    public Resultado buscarRuta(
        Grafo grafo,
        String origen,
        String destino
    ) {

        // Obtener todos los lugares
        List<Lugar> lugares = grafo.getLugares();

        // Buscar objetos de origen y destino
        Lugar lugarOrigen = grafo.buscarLugar(origen);
        Lugar lugarDestino = grafo.buscarLugar(destino);

        if (lugarOrigen == null || lugarDestino == null) {

            return new Resultado(Double.POSITIVE_INFINITY,Collections.emptyList());

        }

        // Obtener indices
        int indiceOrigen = lugares.indexOf(lugarOrigen);
        int indiceDestino = lugares.indexOf(lugarDestino);

        int cantidad = lugares.size();

        // Arreglo de distancias
        double[] distancias = new double[cantidad];

        // Arreglo para reconstruir el camino
        int[] anteriores = new int[cantidad];

        // Inicializar arreglos
        for (int i = 0; i < cantidad; i++) {

            distancias[i] = Double.POSITIVE_INFINITY;

            anteriores[i] = -1;

        }

        // El origen comienza con distancia cero
        distancias[indiceOrigen] = 0;

        // Crear cola de prioridad
        PriorityQueue<Estado> cola = new PriorityQueue<>();

        cola.add(new Estado(indiceOrigen, 0)
        );



        // PROCESAR LOS LUGARES


        while (!cola.isEmpty()) {

            // Obtener el lugar con menor distancia
            Estado actual = cola.poll();

            int indiceActual = actual.indice;

            // Ignorar entradas antiguas de la cola
            if (actual.distancia > distancias[indiceActual]) {

                continue;

            }

            // Si llegamos al destino, terminamos
            if (indiceActual == indiceDestino) {

                break;

            }

            Lugar lugarActual = lugares.get(indiceActual);

            // Obtener conexiones del lugar actual
            List<Arista> conexiones = grafo.getAdyacencias(lugarActual.getNombre());

            // REVISAR CADA CONEXION
       
            for (Arista arista : conexiones) {

                Lugar vecino = arista.getDestino();

                double peso = arista.getPeso();

                int indiceVecino = lugares.indexOf(vecino);

                // Calcular nueva distancia
                double nuevaDistancia = distancias[indiceActual] + peso;


                // Comprobar si encontramos un camino mejor
                if (nuevaDistancia < distancias[indiceVecino]) {

                    // Actualizar distancia
                    distancias[indiceVecino] = nuevaDistancia;

                    // Guardar de donde llegamos
                    anteriores[indiceVecino] = indiceActual;

                    // Agregar a la cola
                    cola.add(new Estado(indiceVecino, nuevaDistancia) );

                }

            }

        }


        // RECONSTRUIR EL CAMINO

        if (distancias[indiceDestino] == Double.POSITIVE_INFINITY) {

            return new Resultado(Double.POSITIVE_INFINITY,Collections.emptyList());

        }

        ArrayList<Lugar> camino = new ArrayList<>();

        int actual = indiceDestino;

        while (actual != -1) {
            camino.add(lugares.get(actual));
            actual = anteriores[actual];

        }

        // Invertir porque reconstruimos desde el destino
        Collections.reverse(camino);

        // Devolver resultado
        return new Resultado(distancias[indiceDestino],camino);

    }

}
