package handlers.meetings;

import app.App;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetAllMeetingsHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx){
        Gson gson = new Gson();
        String json = gson.toJson(App.meetingService.getAllMeetings());
        ctx.result(json);
    }
}
