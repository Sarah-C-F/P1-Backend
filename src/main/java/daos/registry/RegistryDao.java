package daos.registry;

import entities.Registry;
import io.javalin.http.Handler;

public interface RegistryDao{

    Registry getPersonByLogin(String login, String pass);
}
