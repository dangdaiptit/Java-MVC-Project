package studentmanager.model.util;

import java.sql.*;

public class DBUtil {

    public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //localhost:<PORT>  databaseName=<Tên của database vừa tạo>
    public static String dbURL = "jdbc:sqlserver://localhost:1433; databaseName=student;"
            + "encrypt=true; trustServerCertificate=true; sslProtocol=TLSv1.2";

    //Username và Password connect SQLsever
    public static String dbUser = "sa";
    public static String dbPass = "231200";


    public static Connection getConnect() throws ClassNotFoundException, SQLException {
        Class.forName(DBUtil.driverName);
        return DriverManager.getConnection(DBUtil.dbURL, DBUtil.dbUser, DBUtil.dbPass);
    }

    public static void close(Connection connection, Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }


    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }
}