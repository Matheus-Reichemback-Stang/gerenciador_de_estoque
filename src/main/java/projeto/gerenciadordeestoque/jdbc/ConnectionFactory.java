package projeto.gerenciadordeestoque.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection connection;

    private ConnectionFactory(Connection connection) {
    }
    public static Connection getConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = initConnection();
        }
        return connection;
    }

    private static Connection initConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/estoque_de_produtos", "postgres", "111222");
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
