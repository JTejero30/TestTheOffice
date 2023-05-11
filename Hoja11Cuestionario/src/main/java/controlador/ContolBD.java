package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ContolBD {

    public static ArrayList<String> hacerArrayPregunta(String sql) throws ClassNotFoundException {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet rs;
        ArrayList<String> listaResult = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/theoffice?useSSL=false&user=root&password=");

            sentenciaSQL = conexion.createStatement();


            System.out.println(sql);

            rs = sentenciaSQL.executeQuery(sql);

            while (rs.next()) {
                listaResult.add(rs.getString("respuesta"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } finally {
            try {
                sentenciaSQL.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println("Conectado/desconectado");
        return listaResult;
    }

    public static void ejecutar(String sql) throws ClassNotFoundException {
        Connection conexion = null;
        Statement sentenciaSQL = null;

        ResultSet rs;
        int resultado = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexion = DriverManager.getConnection("jdbc:mysql://localhost/theoffice?useSSL=false&user=root&password=");

            sentenciaSQL = conexion.createStatement();
            resultado=sentenciaSQL.executeUpdate(sql);
            System.out.println(sql);


            if (resultado >= 1) {
                System.out.println("Se ha insertado bien.");
            } else {
                System.out.println("Se ha insertado mal");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } finally {
            try {
                sentenciaSQL.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println("Conectado/desconectado");
    }
}
