package com.mycompany.pharmacy.managment.system;
import java.sql.*;

public class DBConnection {
     private static final String URL =
        "jdbc:sqlserver://localhost:1433;databaseName=Pharmace_Mangment;encrypt=true;trustServerCertificate=true;";

    private static final String USER = "sa";
    private static final String PASSWORD = "Ib@01275895751";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
