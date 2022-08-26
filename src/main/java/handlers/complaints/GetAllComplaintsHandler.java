package handlers.complaints;

import app.App;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetAllComplaintsHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx){
        Gson gson = new Gson();
        String json = gson.toJson(App.complaintService.getAllComplaints());
        ctx.result(json);
    }
}
