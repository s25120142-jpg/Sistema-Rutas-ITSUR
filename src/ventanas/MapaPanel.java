package ventanas;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class MapaPanel extends JPanel {

    private BufferedImage mapa;

    public MapaPanel() {

        // Cargar imagen del ITSUR
        try {

            URL ruta = getClass().getResource("/imagenes/fotoItsur.png");

            if (ruta == null) {

                System.out.println("NO SE ENCONTRO LA IMAGEN");

            } else {

                mapa = ImageIO.read(ruta);

                System.out.println("MAPA CARGADO CORRECTAMENTE");
            }

        } catch (IOException e) {

            System.out.println("ERROR AL CARGAR MAPA: " + e.getMessage());
        }

        setBackground(Color.WHITE);

        setPreferredSize(new Dimension(750, 600));
    }

    // Dibujar el mapa
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (mapa == null) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g.create();

        // Mejorar calidad de imagen
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        // Calcular escala conservando proporciones
        double escala = Math.min( (double) getWidth() / mapa.getWidth(),(double) getHeight() / mapa.getHeight());

        int ancho = (int) (mapa.getWidth() * escala);
        int alto = (int) (mapa.getHeight() * escala);

        // Centrar imagen
        int x = (getWidth() - ancho) / 2;
        int y = (getHeight() - alto) / 2;

        // Dibujar mapa
        g2.drawImage(mapa, x, y,ancho,  alto, this);

        g2.dispose();
    }
}
