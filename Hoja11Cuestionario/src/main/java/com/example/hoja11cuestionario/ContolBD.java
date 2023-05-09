package com.example.hoja11cuestionario;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ContolBD {

    public static ArrayList<String> selectConsultaIncidencias(int dato1) throws ClassNotFoundException {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet rs;
        int propietario = 1;
        String sql = "";
        ArrayList<String> listaResult = new ArrayList<>();

        try {
            // conectar con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/actividad11BD", "root", "");

            // creamos sentencias ejecutables sobre esa conexión
            sentenciaSQL = conexion.createStatement();

            // almaceno el resultado de la sql en un resulset (conjunto de registros)
            sql = "SELECT * FROM preguntas WHERE id_pregunta='" + dato1 + "'";
            // System.out.println(sql);

            rs = sentenciaSQL.executeQuery(sql);

            // chequeo que el result set no sea vacío, moviendo el cursor a la
            // primer fila. (El cursor inicia antes de la primer fila)
            while (rs.next()) {
                listaResult.add(rs.getString("pregunra"));
                listaResult.add(rs.getString("respuesta1"));
                listaResult.add(rs.getString("respuesta2"));
                listaResult.add(rs.getString("respuesta3"));
                listaResult.add(rs.getString("respuesta4"));
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
}
