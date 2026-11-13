package ventanas;

public class DatosGrafo {

    public static Grafo crearGrafo() {

        Grafo grafo = new Grafo();
        
        // 1. AGREGAR LOS LUGARES

        grafo.agregarLugar(new Lugar("Biblioteca", 0, 0));
        grafo.agregarLugar(new Lugar("Cafeteria", 0, 0));
        grafo.agregarLugar(new Lugar("Direccion", 0, 0));
        grafo.agregarLugar(new Lugar("Edificio A", 0, 0));
        grafo.agregarLugar(new Lugar("Edificio B", 0, 0));
        grafo.agregarLugar(new Lugar("Edificio E", 0, 0));
        grafo.agregarLugar(new Lugar("Edificio de Vinculacion", 0, 0));
        grafo.agregarLugar(new Lugar("Palapas", 0, 0));
        grafo.agregarLugar(new Lugar("Edificio de TICS", 0, 0));
        grafo.agregarLugar(new Lugar("Cancha de Futbol", 0, 0));
        grafo.agregarLugar(new Lugar("Canchas de basketball", 0, 0));
        grafo.agregarLugar(new Lugar("Estacionamiento", 0, 0));
        grafo.agregarLugar(new Lugar("Auditorio de vinculacion", 0, 0));
        grafo.agregarLugar(new Lugar("Auditorio principal", 0, 0));
        grafo.agregarLugar(new Lugar("Caseta de vigilancia del estacionamiento", 0, 0));
        grafo.agregarLugar(new Lugar("Caseta de vigilancia de la puerta principal", 0, 0));
        grafo.agregarLugar(new Lugar("Cabaña de Gastronomia", 0, 0));
        grafo.agregarLugar(new Lugar("Cocinas de Gastronomia", 0, 0));

        // 2. AGREGAR LAS CONEXIONES
     
        // Caseta de vigilancia de la puerta principal
        grafo.conectar("Caseta de vigilancia de la puerta principal", "Biblioteca", 42);
        grafo.conectar("Caseta de vigilancia de la puerta principal", "Edificio A", 104);
        grafo.conectar("Caseta de vigilancia de la puerta principal", "Edificio B", 117);

        // Caseta de vigilancia del estacionamiento
        grafo.conectar("Caseta de vigilancia del estacionamiento", "Edificio B", 105);

        // Edificio B
        grafo.conectar("Edificio B", "Estacionamiento", 99);
        grafo.conectar("Edificio B", "Cancha de Futbol", 95);
        grafo.conectar("Edificio B", "Edificio de TICS", 52);
        grafo.conectar("Edificio B", "Edificio A", 48);

        // Estacionamiento
        grafo.conectar("Estacionamiento", "Cancha de Futbol", 110);

        // Edificio de TICS
        grafo.conectar("Edificio de TICS", "Edificio A", 55);
        grafo.conectar("Edificio de TICS", "Edificio E", 45);
        grafo.conectar("Edificio de TICS", "Cafeteria", 37);

        // Cafetería
        grafo.conectar("Cafeteria", "Edificio E", 24);
        grafo.conectar("Cafeteria", "Canchas de basketball", 37);

        // Canchas de basketball
        grafo.conectar("Canchas de basketball", "Auditorio principal", 31);

        // Auditorio principal
        grafo.conectar("Auditorio principal", "Edificio E", 49);
        grafo.conectar("Auditorio principal", "Cabaña de Gastronomia", 74);

        // Edificio E
        grafo.conectar("Edificio E", "Cabaña de Gastronomia", 76);
        grafo.conectar("Edificio E", "Palapas", 82);

        // Cabaña de Gastronomía
        grafo.conectar("Cabaña de Gastronomia", "Edificio A", 86);
        grafo.conectar("Cabaña de Gastronomia", "Direccion", 19);
        grafo.conectar("Cabaña de Gastronomia", "Cocinas de Gastronomia", 27);

        // Dirección
        grafo.conectar("Direccion", "Auditorio de vinculacion", 31);
        grafo.conectar("Direccion", "Edificio de Vinculacion", 39);
        grafo.conectar("Direccion", "Cocinas de Gastronomia", 13);
        
        // Edificio de Vinculación
        grafo.conectar("Edificio de Vinculacion", "Auditorio de vinculacion", 31);
        grafo.conectar("Edificio de Vinculacion", "Palapas", 50);
        grafo.conectar("Edificio de Vinculacion", "Cocinas de Gastronomia", 36);

        // Palapas
        grafo.conectar("Palapas", "Edificio A", 35);
        grafo.conectar("Palapas", "Biblioteca", 41);

        return grafo;
    }
}
