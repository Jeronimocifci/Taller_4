package interfaz_t_4;

public class Jugador {
    private String nombre; // Atributo para almacenar el nombre del jugador

    public Jugador() {
        this.nombre = "Jugador Anónimo"; // Nombre por defecto
    }

    public Jugador(String nombreInicial) {
        this.nombre = nombreInicial; // Establecer un nombre inicial
    }

    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre; // Actualizar el nombre del jugador
    }

    public String getNombre() {
        return nombre; // Obtener el nombre actual del jugador
    }

    
}

