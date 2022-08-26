package daos.meetings;

import entities.Meeting;
import util.ConnectUtil;

import java.sql.*;
import java.util.ArrayList;

public class MeetingDaoPostgres implements MeetingDao {
    private int idMaker = 100;
    @Override
    public ArrayList<Meeting> getAllMeetings() {

        try (Connection conn = ConnectUtil.getConnection()){
            String sql = "select * from meetings where meeting_id > 0";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<Meeting> meetingList = new ArrayList<Meeting>();

            while (rs.next()) {
                Meeting meeting = new Meeting();
                meeting.setMeetingId(rs.getInt("meeting_id"));
                meeting.setMeetingDate(rs.getLong("meeting_date"));
                meeting.setTopic(rs.getString("topic"));
                meetingList.add(meeting);
            }
            conn.close();
            return meetingList;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int createMeeting(Meeting meeting) {
        System.out.println(3);
        meeting.setMeetingId(idMaker);
        idMaker++;
        try (Connection conn = ConnectUtil.getConnection()){
            System.out.println(4);
            String sql = "insert into meetings values (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, meeting.getMeetingId());
            ps.setLong(2, meeting.getMeetingDate());
            ps.setString(3, meeting.getTopic());

            ps.execute();
            conn.close();

            return 200;


        }catch (SQLException e){
            e.printStackTrace();
        }
        return 422;
    }


}
