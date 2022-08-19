package services.complaints;

import daos.complaint.ComplaintDao;
import daos.complaint.ComplaintDaoPostgres;
import entities.Complaint;

public class ComplaintServicesLocal implements ComplaintServices{

    private ComplaintDao complaintDao;

    public ComplaintServicesLocal(ComplaintDao complaintDao) {
        this.complaintDao = complaintDao;
    }

    @Override
    public int createComplaint(Complaint complaint) {
        return this.complaintDao.createComplaint(complaint);
    }
}
