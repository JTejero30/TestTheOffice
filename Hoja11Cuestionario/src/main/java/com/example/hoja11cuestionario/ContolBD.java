package com.example.hoja11cuestionario;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ContolBD {

    public static void ejecutar(String sql) throws ClassNotFoundException {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet rs;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/theoffice", "root", "");
            sentenciaSQL = conexion.createStatement();
            rs = sentenciaSQL.executeQuery(sql);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error");
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
