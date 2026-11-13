package ventanas;

public class Lugar {

    // Atributos del lugar
    private String nombre;
    private double x;
    private double y;

    // Constructor
    public Lugar(String nombre, double x, double y) {

        this.nombre = nombre;
        this.x = x;
        this.y = y;

    }

    // Obtener nombre
    public String getNombre() {
        return nombre;
    }

    // Obtener coordenada X
    public double getX() {
        return x;
    }

    // Obtener coordenada Y
    public double getY() {
        return y;
    }

}
