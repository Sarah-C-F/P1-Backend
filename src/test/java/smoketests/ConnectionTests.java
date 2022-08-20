package smoketests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.ConnectUtil;

import java.sql.Connection;

public class ConnectionTests {

    @Test
    void connection_available(){
        Connection connection = ConnectUtil.getConnection();
        System.out.println(connection);
        Assertions.assertNotNull(connection);
    }
}