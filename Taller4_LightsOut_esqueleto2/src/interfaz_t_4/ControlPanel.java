package interfaz_t_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JComboBox<String> comboTamano;
    private JRadioButton rbtnFacil, rbtnMedio, rbtnDificil;
    private JButton btnNuevo, btnTop10, btnCambiarJugador;
    private VentanaTablero ventanaTablero;  // Referencia a la ventana principal

    public ControlPanel(VentanaTablero ventanaTablero) {
        this.ventanaTablero = ventanaTablero;
        setLayout(new FlowLayout());

        // Componentes de la interfaz
        btnNuevo = new JButton("Nuevo");
        btnTop10 = new JButton("Top-10");
        btnCambiarJugador = new JButton("Cambiar Jugador");

        comboTamano = new JComboBox<>(new String[]{"5x5", "6x6", "7x7"});

        rbtnFacil = new JRadioButton("F�cil");
        rbtnMedio = new JRadioButton("Medio");
        rbtnDificil = new JRadioButton("Dif�cil");
        ButtonGroup dificultadGroup = new ButtonGroup();
        dificultadGroup.add(rbtnFacil);
        dificultadGroup.add(rbtnMedio);
        dificultadGroup.add(rbtnDificil);

        add(new JLabel("Tama�o:"));
        add(comboTamano);
        add(new JLabel("Dificultad:"));
        add(rbtnFacil);
        add(rbtnMedio);
        add(rbtnDificil);
        add(btnNuevo);
        add(btnTop10);
        add(btnCambiarJugador);

        // A�adir manejadores de eventos
        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarNuevoJuego();
            }
        });

        btnTop10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTop10();
            }
        });

        btnCambiarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarJugador();
            }
        });
    }

    private void iniciarNuevoJuego() {
        // Obtener las configuraciones seleccionadas
        String tamanoSeleccionado = (String) comboTamano.getSelectedItem();
        String dificultadSeleccionada = rbtnFacil.isSelected() ? "F�cil" :
                                        rbtnMedio.isSelected() ? "Medio" : "Dif�cil";
        ventanaTablero.iniciarNuevoJuego(tamanoSeleccionado, dificultadSeleccionada);
    }

    private void mostrarTop10() {
        ventanaTablero.mostrarTop10();
    }

    private void cambiarJugador() {
        ventanaTablero.cambiarJugador();
    }
}



