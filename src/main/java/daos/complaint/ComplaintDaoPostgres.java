package daos.complaint;

import entities.Complaint;
import entities.Meeting;
import util.ConnectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

            ArrayList<Complaint> complaintsList = new ArrayList<Complaint>();

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

}

