package com.sena.papeleria.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
            "jdbc:sqlserver://localhost:14330;" +
                    "databaseName=papeleria_sena;" +
                    "encrypt=true;" +
                    "trustServerCertificate=true;";

    private static final String USUARIO = "usuario_papeleria";

    private static final String PASSWORD =
            System.getenv("PAPELERIA_DB_PASSWORD");

    public static Connection obtenerConexion() throws SQLException {

        if (PASSWORD == null || PASSWORD.isBlank()) {
            throw new SQLException(
                    "No se encontró la variable de entorno PAPELERIA_DB_PASSWORD."
            );
        }

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(
                    "No se encontró el driver JDBC de SQL Server.",
                    e
            );
        }

        return DriverManager.getConnection(
                URL,
                USUARIO,
                PASSWORD
        );
    }
}