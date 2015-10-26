package phoneBook;


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/notebook";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    public Connection getConnection() {
        return connection;
    }

    private Connection connection;
    public dbConnection () {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Connected");
            }
        } catch (SQLException e) {
            System.err.println("Fail to download class driver");
        }

    }
}
