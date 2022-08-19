package daos.complaint;

import entities.Complaint;
import util.ConnectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ComplaintDaoPostgres implements ComplaintDao{
    private int idMaker = 2;

    @Override
    public int createComplaint(Complaint complaint) {
        complaint.setComplaintId(idMaker);
        idMaker++;

        try (Connection conn = ConnectUtil.getConnection()){
            String sql = "insert into complaints values (?,?,?,?)";

//            string for testing
//            String sql = "insert into complainttest values (?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, complaint.getComplaintId());
            ps.setString(2, complaint.getFirstName());
            ps.setString(3, complaint.getLastName());
            ps.setString(4, complaint.getDescription());

            ps.execute();

            return 201;

        }catch (SQLException e) {
            e.printStackTrace();
        }


        return 0;
    }
}
