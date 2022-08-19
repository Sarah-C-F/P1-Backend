package serviceTests;

import org.junit.jupiter.api.BeforeAll;
import util.ConnectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ComplaintServicesTest {

    @BeforeAll
    static void connect(){
        try (Connection conn = ConnectUtil.getConnection()) {
            String sql = "delete from complaints ; delete from meetings; insert into meetings values (0, '00/00/00','NOT A MEETING')";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
