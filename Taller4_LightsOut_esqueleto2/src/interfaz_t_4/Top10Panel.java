package interfaz_t_4;

import javax.swing.*;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Top10;

import java.awt.*;

public class Top10Panel extends JPanel {
    private JTextArea top10Area;
    private Top10 logicaTop10;  

    public Top10Panel(Top10 logicaTop10) {
        this.logicaTop10 = logicaTop10;
        setLayout(new BorderLayout());
        top10Area = new JTextArea(10, 20);
        top10Area.setEditable(false);
        add(new JScrollPane(top10Area), BorderLayout.CENTER);
        setBorder(BorderFactory.createTitledBorder("Top 10 Scores"));
    }

    public void updateTop10(String top10Text) {
        top10Area.setText(top10Text);
    }

    public void actualizarYMostrar() {
        // Obtener la información actualizada del Top 10
        String top10Text = obtenerTextoTop10();
        // Actualizar el área de texto con la nueva información
        updateTop10(top10Text);
    }

    private String obtenerTextoTop10() {
        // Implementación actualizada para obtener la información del Top 10
        StringBuilder sb = new StringBuilder();
        for (RegistroTop10 registro : logicaTop10.darRegistros()) {
            sb.append(registro.toString()).append("\n");
        }
        return sb.toString();
    }
}


