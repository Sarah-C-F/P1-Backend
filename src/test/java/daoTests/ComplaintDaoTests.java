package daoTests;


import daos.complaint.ComplaintDao;
import daos.complaint.ComplaintDaoPostgres;
import entities.Complaint;
import entities.Level;
import org.junit.jupiter.api.*;
import util.ConnectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ComplaintDaoTests {

    static ComplaintDao complaintDao= new ComplaintDaoPostgres();

    @BeforeAll
    static void connect() {
        try(Connection conn = ConnectUtil.getConnection()) {
            String sql = "delete from complaints";
            PreparedStatement ps;
            if (conn != null) {
                ps = conn.prepareStatement(sql);
                ps.execute();
            }


        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    void create_complaint_test_standard() {
        Complaint test = new Complaint("test", "test", "testing");
        int result = complaintDao.createComplaint(test);

        Assertions.assertEquals(201, result);
    }

    @Test
    @Order(2)
    void get_all_complaints_test_standard(){
        ArrayList<Complaint> testList = complaintDao.getAllComplaints();

        Assertions.assertEquals(1, testList.size());
    }

    @Test
    @Order(3)
    void update_complaint_by_id_test_standard (){
        int test = complaintDao.updateComplaintById(200, Level.valueOf("UNASSIGNED"), 1);

        Assertions.assertEquals(200, test);
    }



}
