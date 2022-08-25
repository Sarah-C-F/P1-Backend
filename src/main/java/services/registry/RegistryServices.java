package services.registry;

import entities.Registry;

public interface RegistryServices {

    Registry getPersonByLogin (String login, String log_pass);
}
