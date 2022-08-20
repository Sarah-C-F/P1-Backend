package handlers.complaints;

import app.App;
import com.google.gson.Gson;
import entities.Complaint;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CreateComplaintHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) {
        String json = ctx.body();
        Gson gson = new Gson();
        Complaint complaint = gson.fromJson(json, Complaint.class);

        int saveComplaint = App.complaintService.createComplaint(complaint);

        if (saveComplaint == 201){
            ctx.status(saveComplaint);
            ctx.result("Complaint registered");
        } else {
            ctx.status(422);
            ctx.result("Complaint not registered, please try again later");
        }
    }


}
