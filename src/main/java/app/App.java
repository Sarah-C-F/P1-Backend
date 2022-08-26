package app;

import daos.complaint.ComplaintDaoPostgres;
import daos.meetings.MeetingDao;
import daos.meetings.MeetingDaoPostgres;
import daos.registry.RegistryDaoPostgres;
import handlers.complaints.CreateComplaintHandler;
import handlers.complaints.GetAllComplaintsHandler;
import handlers.meetings.CreateMeetingHandler;
import handlers.meetings.GetAllMeetingsHandler;
import handlers.registry.GetPersonByLoginHandler;
import io.javalin.Javalin;
import services.complaints.ComplaintServices;
import services.complaints.ComplaintServicesImpl;
import services.meetings.MeetingServices;
import services.meetings.MeetingServicesImpl;
import services.registry.RegistryServices;
import services.registry.RegistryServicesImpl;

public class App {
    public static ComplaintServices complaintService = new ComplaintServicesImpl(new ComplaintDaoPostgres());
    public static MeetingServices meetingService = new MeetingServicesImpl(new MeetingDaoPostgres());
    public static RegistryServices registryServices = new RegistryServicesImpl(new RegistryDaoPostgres());

    public static void main(String[] args){
        //add Javalin
        Javalin app = Javalin.create(config ->
        {
            config.enableDevLogging();
            config.enableCorsForAllOrigins();
        });

        //Complaint Handlers
        CreateComplaintHandler createComplaintHandler = new CreateComplaintHandler();
        GetAllComplaintsHandler getAllComplaintsHandler = new GetAllComplaintsHandler();

        //Meeting Handlers
        GetAllMeetingsHandler getAllMeetingsHandler = new GetAllMeetingsHandler();
        CreateMeetingHandler createMeetingHandler = new CreateMeetingHandler();

        //Registry Handlers
        GetPersonByLoginHandler getPersonByLoginHandler = new GetPersonByLoginHandler();

        //Call Complaint Handlers
        app.post("/complaints", createComplaintHandler);
        app.get("/complaints", getAllComplaintsHandler);

        //Call Meeting Handlers
        app.get("/meetings", getAllMeetingsHandler);
        app.post("/meetings", createMeetingHandler);

        //Call Registry Handlers
        app.post("/registry", getPersonByLoginHandler);

        //start app
        app.start();

    }
}