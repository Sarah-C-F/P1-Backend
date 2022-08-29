package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectUtil {


    public static Connection getConnection() {

        try {

            Connection conn = DriverManager.getConnection(System.getenv("APPSETTING_azure_p1_sql_jdbc"));

            return conn;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;

    }


}