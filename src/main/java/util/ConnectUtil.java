package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectUtil {


    public static Connection getConnection() {

        try {

            Connection conn = DriverManager.getConnection(System.getenv("azure-p1-sql-jdbc"));

            return conn;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;

    }


}