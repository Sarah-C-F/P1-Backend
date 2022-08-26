package services.complaints;

import entities.Complaint;

import java.util.ArrayList;

public interface ComplaintServices {

    int createComplaint (Complaint complaint);

    ArrayList<Complaint> getAllComplaints();

}
