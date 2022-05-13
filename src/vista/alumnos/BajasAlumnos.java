package vista.alumnos;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BajasAlumnos extends VentanaAlumnos {

    public BajasAlumnos() {
        txtTitulo.setText("Bajas Alumnos");
        btnAgregar.setText("Eliminar");

        cajaNombre.setEditable(false);
        cajaApeMaterno.setEditable(false);
        cajaApePaterno.setEditable(false);
        cajaEdad.setEditable(false);

        comboSemestre.setEnabled(false);
        comboCarrera.setEnabled(false);
        comboCarrera.setEditable(false);
        comboSemestre.setEditable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
            if (!cajaNumControl.getText().equals("")) {
                if (alumnoDAO.eliminarRegistro(cajaNumControl.getText())) {
                    JOptionPane.showMessageDialog(null, "Se elimino correctamente");
                    actualizarTablas(tablaAlumnos);
                    restablecerComponentes(cajaNumControl, cajaNombre, cajaApePaterno, cajaApeMaterno, cajaEdad, comboCarrera, comboSemestre);
                } else {
                    JOptionPane.showMessageDialog(null, "No se elimino");
                }

            }
        }

        funcionalidadBotones(e);
    }
}
