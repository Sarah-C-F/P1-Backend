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
        System.out.println(logCheck.getLogin());
        System.out.println(logCheck.getLogPass());

        Registry person2 = App.registryServices.getPersonByLogin(logCheck.getLogin(), logCheck.getLogPass());
        String personString = gson.toJson(person2);
        if (person2.getRegistryId()==202) {
            ctx.status(202);
            ctx.result(personString);
        } else if (person2.getRegistryId()==302) {
            ctx.status(302);
            ctx.result(personString);
        }else{
            ctx.status(401);
            ctx.result("Unauthorized access");
        }

    }
}
