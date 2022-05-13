package controlador;

import conexionBD.ConexionBD;
import modelo.Alumno;
import vista.ResultSetTableModel;

import javax.swing.*;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//DAO - Data Acces Object
public class AlumnoDAO {

    ConexionBD con = new ConexionBD();

    // Altas
    public boolean agregarRegistro(Alumno a) {
        boolean res = false;

        // proceso de alta en la base de datos MySQL

        /* insercion de registro mysql

            INSERT INTO alumnos VALUES("01", "Look", "Skywañker", "-", 50, 7, "ISC");

            create table Alumnos(Num_Control VARCHAR(10), Primer_Ap VARCHAR(50), Segundo_Ap VARCHAR(50), Edad TINYINT, Semestre TINYInt, Carrera Varchar(50));
         */

        //String sql = "INSERT INTO alumnos VALUES(\"01\", \"Look\", \"Skywañker\", \"-\", 50, 7, \"ISC\")";

        //String sql2 = "INSERT INTO alumnos VALUES('02', 'Look', 'Skywañker', '-', 50, 7, 'ISC')";

        String sql3 = "INSERT INTO alumnos VALUES('" + a.getNumControl() + "', '" + a.getNombre() + "', '" + a.getPrimerAp() + "', '" + a.getSegundoAp() + "', " + a.getEdad() + ", " + a.getSemestre() + ", '" + a.getCarrera() + "')";

        res = con.ejecutarInstruccionDML(sql3);

        return res;
    }

    // Bajas
    public boolean eliminarRegistro(String numControl) {
        boolean res = false;
        // proceso de baja en la base de datos MySQL

        String sql = "DELETE FROM alumnos WHERE Num_Control = '" + numControl + "';";
        res = con.ejecutarInstruccionDML(sql);
        return res;
    }

    // Cambios
    public boolean modificarRegistro(Alumno a) {
        boolean res = false;

        // proceso de cambios en la base de datos MySQL


        String sql = "UPDATE alumnos SET Num_Control='" + a.getNumControl() + "', Nombre='" + a.getNombre() + "', Primer_Ap='" + a.getPrimerAp() + "', Segundo_AP='" + a.getSegundoAp() + "', Edad=" + a.getEdad() + ", Semestre=" + a.getSemestre() + ", Carrera='" + a.getCarrera() + "' WHERE Num_Control='" + a.getNumControl() + "'";
        res = con.ejecutarInstruccionDML(sql);
        return res;
    }

    // Consultas
    public ArrayList<Alumno> buscarAlumnos() {
        boolean res = false;
        String sql = "SELECT * FROM alumnos";

        ResultSet rs = con.ejecutarConsulta(sql);

        ArrayList<Alumno> listaAlumnos = new ArrayList<>();

        try {
            rs.next();
            do {
                String nc = rs.getString(1);
                String n = rs.getString(2);
                String pa = rs.getString(3);
                String sa = rs.getString(4);
                byte e = rs.getByte(5);
                byte s = rs.getByte(6);
                String c = rs.getString(7);

                Alumno a = new Alumno(nc, n, pa, sa, e, s, c);

                listaAlumnos.add(a);

            } while (rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // proceso de Consultas en la base de datos MySQL

        return listaAlumnos;
    }

    // Consultas
    public Alumno buscarAlumno(String filtro) {
        boolean res = false;

        // proceso de Consultas en la base de datos MySQL

        return null;
    }


    public Alumno buscarAlumnoID(String id) {
        ResultSet rs = con.ejecutarConsulta("SELECT * FROM alumnos WHERE Num_Control='" + id + "' ");

        if (rs != null) {
            try {
                rs.next();
                String nc = rs.getString(1);
                String n = rs.getString(2);
                String pa = rs.getString(3);
                String sa = rs.getString(4);
                byte e = rs.getByte(5);
                byte s = rs.getByte(6);
                String c = rs.getString(7);

                return new Alumno(nc, n, pa, sa, e, s, c);

            } catch (Exception e) {

            }

        }

        return null;

    }


    // Metodos para ABCC

    public String generarConsultaEmpleadoModel(Alumno e) {

        String consulta = "";
        if (e.getNumControl() != null) {
            consulta += "Num_Control='" + e.getNumControl() + "' and ";
        }

        if (e.getNombre() != null) {
            consulta += "Nombre='" + e.getNombre() + "' and ";
        }

        if (e.getPrimerAp() != null) {
            consulta += "Primer_Ap='" + e.getPrimerAp() + "' and ";
        }

        if (e.getSegundoAp() != null) {
            consulta += "Segundo_Ap='" + e.getSegundoAp() + "' and ";
        }

        if (e.getEdad() != 0) {
            consulta += "Edad=" + e.getEdad() + " and ";
        }

        if (e.getSemestre() != 0) {
            consulta += "Semestre=" + e.getSemestre() + " and ";
        }

        if (e.getCarrera() != null) {
            consulta += "Carrera='" + e.getCarrera() + "' and ";
        }

        if ((consulta.substring(consulta.length() - 4, consulta.length()).equals("and ")))
            consulta = consulta.substring(0, consulta.length() - 4);

        return consulta;
    }

    public ResultSetTableModel obtenerConsulta(Alumno a) {

        ResultSetTableModel modeloDatos = null;
        String consulta = "select * from alumnos where ";
        consulta += generarConsultaEmpleadoModel(a);

        try {
            modeloDatos = new ResultSetTableModel("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost/Escuela_Topicos?useTimezone=true&serverTimezone=UTC",

                    consulta);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modeloDatos;

    }




}
