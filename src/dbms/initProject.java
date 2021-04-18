package dbms;

import java.sql.*;

public class initProject {
    // Establish connection
    public static Connection connection;
    public static Statement statement;
    public static ResultSet result;
    public static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/jsukhad";
    public static final String user = "jsukhad";
    public static final String password = "200314087";

    public static void connectToDatabase() {
        try {
            // Loading the driver. This creates an instance of the driver
            // and calls the registerDriver method to make MySql(MariaDB) Thin available to
            // clients.
            Class.forName("org.mariadb.jdbc.Driver");
            connection = null;
            statement = null;
            result = null;

            try {
                // Get a connection instance from the first driver in the
                // DriverManager list that recognizes the URL jdbcURL
                connection = DriverManager.getConnection(jdbcURL, user, password);
                // Create a statement instance that will be sending
                // your SQL statements to the DBMS
                statement = connection.createStatement();
            } finally {
                System.out.println("Database connected");
            }
        } catch (Throwable oops) {
            oops.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello");
        connectToDatabase();
        initTables.createTable();
        initTables.addData();
//        infoProcess.toUpdateStoreData();
    }

}

