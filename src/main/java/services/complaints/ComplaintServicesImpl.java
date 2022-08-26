package services.complaints;

import daos.complaint.ComplaintDao;
import entities.Complaint;
import entities.Level;

import java.util.ArrayList;

public class ComplaintServicesImpl implements ComplaintServices{

    private ComplaintDao complaintDao;

    public ComplaintServicesImpl(ComplaintDao complaintDao) {
        this.complaintDao = complaintDao;
    }

    @Override
    public int createComplaint(Complaint complaint) {
        int saveComplaint = this.complaintDao.createComplaint(complaint);
        return saveComplaint;
    }

    @Override
    public ArrayList<Complaint> getAllComplaints() {
        return this.complaintDao.getAllComplaints();
    }

    @Override
    public int updateComplaintById(int complaintId, Level priority, int meeting) {
        return this.complaintDao.updateComplaintById(complaintId, priority, meeting);
    }
}
