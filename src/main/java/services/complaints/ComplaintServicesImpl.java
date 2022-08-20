package services.complaints;

import daos.complaint.ComplaintDao;
import entities.Complaint;

public class ComplaintServicesImpl implements ComplaintServices{

    private ComplaintDao complaintDao;

    public ComplaintServicesImpl(ComplaintDao complaintDao) {
        this.complaintDao = complaintDao;
    }

    @Override
    public int createComplaint(Complaint complaint) {
        int saveComplaint = this.complaintDao.createComplaint(complaint);
        System.out.println(saveComplaint);
        return saveComplaint;


    }
}
