package daos.complaint;

import entities.Complaint;

import java.util.ArrayList;

public interface ComplaintDao {

    //create
    int createComplaint(Complaint complaint);

    ArrayList<Complaint> getAllComplaints();

}
