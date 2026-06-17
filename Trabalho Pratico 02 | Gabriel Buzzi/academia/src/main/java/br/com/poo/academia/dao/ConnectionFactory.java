package br.com.poo.academia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL      = "jdbc:postgresql://localhost:5432/academia";
    private static final String USUARIO  = "gabrielbuzzi";
    private static final String SENHA    = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

}
