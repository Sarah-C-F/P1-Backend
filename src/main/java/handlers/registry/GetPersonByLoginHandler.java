package handlers.registry;

import app.App;
import com.google.gson.Gson;
import entities.Registry;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetPersonByLoginHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String json = ctx.body();
        Gson gson = new Gson();
        Registry logCheck = gson.fromJson(json, Registry.class);

        boolean accurate = App.registryServices.getPersonByLogin(logCheck.getLogin(), logCheck.getLogPass());

        if (accurate) {
            ctx.status(200);
        } else {
            ctx.status(401);
            ctx.result("Unauthorized access");
        }

    }
}
