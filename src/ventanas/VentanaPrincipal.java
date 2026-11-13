package ventanas;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private JComboBox<String> origen;
    private JComboBox<String> destino;

    private JButton buscar;

    private JLabel distancia;

    public VentanaPrincipal() {

        // Configuración de ventana
        setTitle("Sistema de rutas inteligentes - ITSUR");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1100, 750);

        setMinimumSize(new Dimension(850, 600));

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // PRUEBA TEMPORAL DE DIJKSTRA

        Grafo grafo = DatosGrafo.crearGrafo();

        Dijkstra algoritmo = new Dijkstra();

        Dijkstra.Resultado resultado = algoritmo.buscarRuta(grafo,"Biblioteca","Cafeteria");

        System.out.println("RESULTADO DE DIJKSTRA");

        if (resultado.existeRuta()) {

            System.out.println("Ruta encontrada:");

            for (Lugar lugar : resultado.getCamino()) {

                System.out.print(lugar.getNombre() + " -> ");

            }

            System.out.println("\nDistancia total: "
                    + resultado.getDistancia() + " metros");

        } else {

            System.out.println("No existe una ruta.");

        }

        // PANEL DE CONTROLES
        JPanel controles = new JPanel();

        controles.setLayout(new BoxLayout(controles, BoxLayout.Y_AXIS));

        controles.setBackground(new Color(240, 240, 240));

        controles.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));

        controles.setPreferredSize(new Dimension(290, 0));

        // TITULO
        JLabel titulo = new JLabel("Sistema de rutas ITSUR");

        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        titulo.setMaximumSize(new Dimension(260, 35));

        // LUGARES
        String[] lugares = {
            "Selecciona un lugar",
            "Biblioteca",
            "Cafeteria",
            "Dirección",
            "Edificio A",
            "Edificio B",
            "Edificio E",
            "Edificio de Vinculacion",
            "Palapas",
            "Edificio de TICS",
            "Cancha de Futbol",
            "Canchas de basketball",
            "Estacionamiento",
            "Auditorio de vinculacion",
            "Auditorio principal",
            "Caseta de vigilancia del estacionamiento",
            "Caseta de vigilancia de la puerta principal",
            "Cocinas de Gastronomia",
            "Cabaña de Gastronomia"
        };

        // SELECTOR DE ORIGEN
        JLabel textoOrigen = new JLabel("Seleccionar origen:");

        textoOrigen.setAlignmentX(Component.LEFT_ALIGNMENT);

        origen = new JComboBox<>(lugares);

        origen.setMaximumRowCount(8);

        origen.setPreferredSize(new Dimension(250, 35));

        origen.setMaximumSize(new Dimension(250, 35));

        origen.setAlignmentX(Component.LEFT_ALIGNMENT);

        // SELECTOR DE DESTINO
        JLabel textoDestino = new JLabel("Seleccionar destino:");

        textoDestino.setAlignmentX(Component.LEFT_ALIGNMENT);

        destino = new JComboBox<>(lugares);

        destino.setMaximumRowCount(8);

        destino.setPreferredSize(new Dimension(250, 35));

        destino.setMaximumSize(new Dimension(250, 35));

        destino.setAlignmentX(Component.LEFT_ALIGNMENT);

        // BOTON BUSCAR
        buscar = new JButton("Buscar ruta");

        buscar.setPreferredSize(new Dimension(250, 40));

        buscar.setMaximumSize(new Dimension(250, 40));

        buscar.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Se activará al implementar Dijkstra
        buscar.setEnabled(false);

        // DISTANCIA
        distancia = new JLabel("Distancia total: -- metros");

        distancia.setFont(new Font("Arial", Font.BOLD, 14));

        distancia.setAlignmentX(Component.LEFT_ALIGNMENT);

        // AGREGAR COMPONENTES
        controles.add(titulo);

        controles.add(Box.createVerticalStrut(35));

        controles.add(textoOrigen);

        controles.add(Box.createVerticalStrut(10));

        controles.add(origen);

        controles.add(Box.createVerticalStrut(25));

        controles.add(textoDestino);

        controles.add(Box.createVerticalStrut(10));

        controles.add(destino);

        controles.add(Box.createVerticalStrut(30));

        controles.add(buscar);

        controles.add(Box.createVerticalStrut(30));

        controles.add(distancia);

        // PANEL DEL MAPA
        MapaPanel panelMapa = new MapaPanel();

        // AGREGAR A LA VENTANA
        add(controles, BorderLayout.WEST);

        add(panelMapa, BorderLayout.CENTER);

    }

    // METODO PRINCIPAL
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {VentanaPrincipal ventana = new VentanaPrincipal();

            ventana.setVisible(true);

        });

    }

}
