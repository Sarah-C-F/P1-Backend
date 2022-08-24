package daos.registry;

import entities.Registry;
import io.javalin.http.Handler;

public interface RegistryDao{

    boolean getPersonByLogin(String login, String pass);
}
