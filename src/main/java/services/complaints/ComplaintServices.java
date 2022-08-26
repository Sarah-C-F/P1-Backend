package services.complaints;

import entities.Complaint;
import entities.Level;

import java.util.ArrayList;

public interface ComplaintServices {

    int createComplaint (Complaint complaint);

    ArrayList<Complaint> getAllComplaints();

    int updateComplaintById(int complaintId, Level priority, int meeting);

}
