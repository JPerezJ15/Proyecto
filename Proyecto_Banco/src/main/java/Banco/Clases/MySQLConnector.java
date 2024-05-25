package Banco.Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jonat
 */
public class MySQLConnector {

    private Connection conexion;
    private String user = "root";
    private String pass = "contramysqlacceso";
    private String dbName;

    public MySQLConnector(String dnName) {
        this.dbName = dnName;
    }

    public void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc.mysql://localhost:3306/" + dbName, user, pass);
            System.out.println("Se realizó la conexión con el servidor");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void closeConnection() {
        try {
            conexion.close();
            System.out.println("Se ha cerrado la conexión con el servidor");
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }
}
