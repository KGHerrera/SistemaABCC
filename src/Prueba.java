import controlador.AlumnoDAO;
import modelo.Alumno;
import vista.VentanaInicio;

import javax.swing.*;
import java.util.ArrayList;

public class Prueba {
    public static void main(String[] args) {

        new VentanaInicio();

        //x = alumnoDAO.modificarRegistro(new Alumno("01","juan","carlos","segundo",(byte)20,(byte)10,"ISC"));


        /*
        ArrayList<Alumno> listaAlumnos = alumnoDAO.buscarAlumnos();

        for (Alumno a: listaAlumnos) {
            System.out.println(a);
        }

         */

    }
}
