package conexionBD;

import java.sql.*;

public class ConexionBD {

    private Connection conexion;
    private Statement stm; // se recomienda utilizar PrepareStatement Evitar Sql Injection
    private ResultSet rs;

    public ConexionBD() {
        // permite cargar / utilizar el driver del gestor BD a utilizar
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 127.0.0.1
            String URL = "jdbc:mysql://localhost:3306/Escuela_Topicos";

            conexion = DriverManager.getConnection(URL, "root", "12345");

            //System.out.println("conexion establecida");

        } catch (ClassNotFoundException e) {
            System.out.println("no se encontro el controlador");
        } catch (SQLException e) {
            System.out.println("error al conectar a la base de datos");
        }
    }

    // metodos especiales para ABC (Altas, bajas, cambios)

    public boolean ejecutarInstruccionDML(String instruccionSQL) {
        boolean resultado = false;

        try {
            stm = conexion.createStatement();
            //System.out.println(instruccionSQL);
            //resultado = stm.execute(instruccionSQL);

            if (stm.executeUpdate(instruccionSQL) == 1) resultado = true;
            System.out.println();

        } catch (SQLException e) {
            System.out.println("Error en la ejecucion de la instruccion sql");
        }


        return resultado;
    }

    // metodo especial para consultas

    public ResultSet ejecutarConsulta(String consulta) {

        try {
            stm = conexion.createStatement();
            rs = stm.executeQuery(consulta);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;

    }

    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion con la BD");
        }

    }




}
