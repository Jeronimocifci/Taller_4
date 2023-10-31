package interfaz_t_4;

import javax.swing.*;
import java.awt.*;

public class VentanaTablero extends JFrame {

    private static final long serialVersionUID = 1L;
    private ControlPanel controlPanel;
    private GameBoardPanel gameBoardPanel;
    private Top10Panel top10Panel;
    private Jugador jugador;
    private JLabel labelNombreJugador;

    public VentanaTablero() {
        setTitle("LightsOut");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        controlPanel = new ControlPanel(null);
        gameBoardPanel = new GameBoardPanel(5);  // Ajusta el tamaño según tus necesidades.
        top10Panel = new Top10Panel(null);

        add(controlPanel, BorderLayout.NORTH);
        add(gameBoardPanel, BorderLayout.CENTER);
        add(top10Panel, BorderLayout.EAST);  // Agregar el panel de Top 10 a la ventana

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaTablero();
    }

    public void iniciarNuevoJuego(String tamanoSeleccionado, String dificultadSeleccionada) {
        // Convertir el tamaño seleccionado a un valor entero
        int tamano = Integer.parseInt(tamanoSeleccionado.split("x")[0]);
        
        // Configurar la dificultad 
        int dificultad;
        switch (dificultadSeleccionada) {
            case "Fácil":
                dificultad = 5; // Ejemplo: 5 luces apagadas al inicio
                break;
            case "Medio":
                dificultad = 15; // Ejemplo: 15 luces apagadas al inicio
                break;
            case "Difícil":
                dificultad = 25; // Ejemplo: 25 luces apagadas al inicio
                break;
            default:
                dificultad = 10; // Valor por defecto
        }

        // Inicializar el tablero con el tamaño y la dificultad seleccionados
        gameBoardPanel.iniciarJuego(tamano, dificultad);
    }


    public void mostrarTop10() {
        // Actualizar y mostrar el panel de Top 10
        top10Panel.actualizarYMostrar();
    }


    public void cambiarJugador() {
        // Abrir un diálogo para cambiar el nombre del jugador
        String nuevoNombre = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre del jugador:");
        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
            // Establecer el nuevo nombre del jugador
            jugador.setNombre(nuevoNombre); // Actualizar el nombre en la clase Jugador

            // Actualizar el nombre en la interfaz, si es visible
            labelNombreJugador.setText(nuevoNombre);
        }
    }

}




