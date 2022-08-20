package app;

import daos.complaint.ComplaintDaoPostgres;
import handlers.complaints.CreateComplaintHandler;
import io.javalin.Javalin;
import services.complaints.ComplaintServices;
import services.complaints.ComplaintServicesImpl;

public class App {
    public static ComplaintServices complaintService = new ComplaintServicesImpl(new ComplaintDaoPostgres());

    public static void main(String[] args){
        //add Javalin
        Javalin app = Javalin.create(config ->
        {
            config.enableDevLogging();
            config.enableCorsForAllOrigins();
        });

        //Complaint Handlers
        CreateComplaintHandler createComplaintHandler = new CreateComplaintHandler();

        //Call Complaint Handlers
        app.post("/complaints", createComplaintHandler);

        //start app
        app.start();

    }
}