package vista.alumnos;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CambiosAlumnos extends VentanaAlumnos {

    public CambiosAlumnos() {
        txtTitulo.setText("Cambios Alumnos");
        btnAgregar.setText("Modificar");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
            if (!cajaNumControl.getText().equals("") && !cajaNombre.getText().equals("") && !cajaApePaterno.getText().equals("") &&
                    !cajaApeMaterno.getText().equals("") && !cajaEdad.getText().equals("") && comboSemestre.getSelectedIndex() != 0 && comboCarrera.getSelectedIndex() != 0) {

                a.setNumControl(cajaNumControl.getText());
                a.setNombre(cajaNombre.getText());
                a.setPrimerAp(cajaApePaterno.getText());
                a.setSegundoAp(cajaApeMaterno.getText());
                a.setEdad(Byte.parseByte(cajaEdad.getText()));
                a.setSemestre(Byte.parseByte((String) comboSemestre.getSelectedItem()));
                a.setCarrera((String) comboCarrera.getSelectedItem());

                if (alumnoDAO.modificarRegistro(a)) {
                    JOptionPane.showMessageDialog(null, "Se modifico correctamente");
                    actualizarTablas(tablaAlumnos);
                } else {
                    JOptionPane.showMessageDialog(null, "No se modifico");
                }


            } else {
                JOptionPane.showMessageDialog(null, "faltan datos");
            }
        }

        funcionalidadBotones(e);
    }
}
