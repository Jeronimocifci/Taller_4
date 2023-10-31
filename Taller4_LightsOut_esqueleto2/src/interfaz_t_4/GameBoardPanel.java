package interfaz_t_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameBoardPanel extends JPanel {
    private int size;
    private JToggleButton[][] buttons;

    public GameBoardPanel(int size) {
        this.size = size;
        setLayout(new GridLayout(size, size));
        buttons = new JToggleButton[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JToggleButton button = new JToggleButton();
                button.setPreferredSize(new Dimension(50, 50)); // Tamaño del botón
                button.addActionListener(new ButtonListener(i, j));
                buttons[i][j] = button;
                add(button);
            }
        }
    }

    private class ButtonListener implements ActionListener {
        private int row, col;

        public ButtonListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            toggleButtonState(row, col);
        }

    }

    // Método para cambiar el estado de un botón y sus adyacentes
    private void toggleButtonState(int row, int col) {
        // Cambiar el estado del botón en [row][col]
        buttons[row][col].setSelected(!buttons[row][col].isSelected());

        // Cambiar el estado de los botones adyacentes si están dentro del tablero
        if (row > 0) { // Arriba
            buttons[row - 1][col].setSelected(!buttons[row - 1][col].isSelected());
        }
        if (row < size - 1) { // Abajo
            buttons[row + 1][col].setSelected(!buttons[row + 1][col].isSelected());
        }
        if (col > 0) { // Izquierda
            buttons[row][col - 1].setSelected(!buttons[row][col - 1].isSelected());
        }
        if (col < size - 1) { // Derecha
            buttons[row][col + 1].setSelected(!buttons[row][col + 1].isSelected());
        }
    }


    public void iniciarJuego(int tamano, int dificultad) {
        this.size = tamano;
        removeAll(); // Eliminar todos los componentes actuales
        setLayout(new GridLayout(size, size));
        buttons = new JToggleButton[size][size];
        initializeBoard();

        // Determinar el número de botones a activar basado en la dificultad
        int botonesActivos;
        switch (dificultad) {
            case 1: // Fácil
                botonesActivos = size; // Por ejemplo, un botón activo por fila
                break;
            case 2: // Medio
                botonesActivos = size * 2; // Dos botones activos por fila
                break;
            case 3: // Difícil
                botonesActivos = size * 3; // Tres botones activos por fila
                break;
            default:
                botonesActivos = size; // Valor por defecto
        }

        // Activar botones aleatoriamente
        Random rand = new Random();
        for (int i = 0; i < botonesActivos; i++) {
            int fila = rand.nextInt(size);
            int columna = rand.nextInt(size);
            buttons[fila][columna].setSelected(true);
        }

        revalidate(); // Para asegurar que el panel se actualice correctamente
        repaint();
    }


}

