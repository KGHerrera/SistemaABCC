package vista.alumnos;

import modelo.Alumno;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AltasAlumnos extends VentanaAlumnos {

    public AltasAlumnos() {

        btnBuscar.setVisible(false);

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

                if (alumnoDAO.agregarRegistro(a)) {
                    JOptionPane.showMessageDialog(null, "Se agrego correctamente");
                    actualizarTablas(tablaAlumnos);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al agregar");
                }

            } else {
                JOptionPane.showMessageDialog(null, "faltan datos");
            }
        }
        else{
            funcionalidadBotones(e);
        }



    }
}
