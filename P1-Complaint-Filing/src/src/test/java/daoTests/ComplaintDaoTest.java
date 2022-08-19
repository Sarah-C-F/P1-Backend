package daoTests;

import daos.complaint.ComplaintDao;
import daos.complaint.ComplaintDaoPostgres;
import entities.Complaint;
import org.junit.jupiter.api.*;
import util.ConnectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ComplaintDaoTest {

    static ComplaintDao complaintDao = new ComplaintDaoPostgres();

    @BeforeAll
    static void connect(){
        try (Connection conn = ConnectUtil.getConnection()) {
            String sql = "delete from complainttest ; delete from meetingtest; insert into meetingtest values (0, '00/00/00','NOT A MEETING')";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    void create_complaint_test(){
        Complaint test = new Complaint("John", "Doe", "testing");
        int result = complaintDao.createComplaint(test);

        Assertions.assertEquals(201, result);
    }

}
