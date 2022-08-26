package daoTests;

import daos.meetings.MeetingDao;
import daos.meetings.MeetingDaoPostgres;
import entities.Meeting;
import org.junit.jupiter.api.*;
import util.ConnectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MeetingDaoTests {

    static MeetingDao meetingDao = new MeetingDaoPostgres();

    @BeforeAll
    static void connect() {
        try (Connection conn = ConnectUtil.getConnection()) {
            String sql = "delete from complaints; delete from meetings";
            PreparedStatement ps;
            if (conn != null) {
                ps = conn.prepareStatement(sql);
                ps.execute();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    void create_meeting_test_standard () {
        Meeting testMeeting = new Meeting(0,1661523705, "create_meeting_test_standard");
        int result = meetingDao.createMeeting(testMeeting);

        Assertions.assertEquals(200, result);
    }

    @Test
    @Order(2)
    void get_all_meetings_test_standard () {
        ArrayList<Meeting> test = meetingDao.getAllMeetings();

        Assertions.assertEquals(1, test.size());
    }
}
