package app;

import daos.complaint.ComplaintDaoPostgres;
import daos.meetings.MeetingDao;
import daos.meetings.MeetingDaoPostgres;
import handlers.complaints.CreateComplaintHandler;
import handlers.meetings.GetAllMeetingsHandler;
import io.javalin.Javalin;
import services.complaints.ComplaintServices;
import services.complaints.ComplaintServicesImpl;
import services.meetings.MeetingServices;
import services.meetings.MeetingServicesImpl;

public class App {
    public static ComplaintServices complaintService = new ComplaintServicesImpl(new ComplaintDaoPostgres());
    public static MeetingServices meetingService = new MeetingServicesImpl(new MeetingDaoPostgres());

    public static void main(String[] args){
        //add Javalin
        Javalin app = Javalin.create(config ->
        {
            config.enableDevLogging();
            config.enableCorsForAllOrigins();
        });

        //Complaint Handlers
        CreateComplaintHandler createComplaintHandler = new CreateComplaintHandler();

        //Meeting Handlers
        GetAllMeetingsHandler getAllMeetingsHandler = new GetAllMeetingsHandler();

        //Call Complaint Handlers
        app.post("/complaints", createComplaintHandler);

        //Call Meeting Handlers
        app.get("/meetings", getAllMeetingsHandler);

        //start app
        app.start();

    }
}