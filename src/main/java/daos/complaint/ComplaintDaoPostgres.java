package daos.complaint;

import entities.Complaint;
import entities.Level;
import util.ConnectUtil;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;

public class ComplaintDaoPostgres implements ComplaintDao{
    private int idMaker = 200;

    @Override
    public int createComplaint(Complaint complaint) {
        complaint.setComplaintId(idMaker);
        idMaker++;

        try (Connection conn = ConnectUtil.getConnection()){
            String sql = "insert into complaints values (?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, complaint.getComplaintId());
            ps.setString(2, complaint.getFirstName());
            ps.setString(3, complaint.getLastName());
            ps.setString(4, complaint.getDescription());

            ps.execute();
            conn.close();

            return 201;

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public ArrayList<Complaint> getAllComplaints() {
        try (Connection conn = ConnectUtil.getConnection()){
            String sql = "select * from complaints";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<Complaint> complaintsList = new ArrayList<>();

            while (rs.next()) {
                Complaint complaint = new Complaint();
                complaint.setComplaintId(rs.getInt("complaint_id"));
                complaint.setFirstName(rs.getString("first_name"));
                complaint.setLastName(rs.getString("last_name"));
                complaint.setDescription(rs.getString("description"));
                complaint.setPriority(rs.getString("priority"));
                complaint.setMeeting(rs.getInt("meeting"));
                complaintsList.add(complaint);
            }
            conn.close();
            return complaintsList;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int updateComplaintById(int complaintId, Level priority, int meetingId) {
        try (Connection conn = ConnectUtil.getConnection()){
            String sql = "update complaints set priority = ?, meeting = ? where complaint_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, priority, Types.OTHER);
            ps.setInt(2, meetingId);
            ps.setInt(3, complaintId);

            ps.execute();
            conn.close();

            return 200;

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return 422;
    }


}

