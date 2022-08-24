package services.registry;

import daos.registry.RegistryDao;
import entities.Registry;

public class RegistryServicesImpl implements RegistryServices{

    private RegistryDao registryDao;

    public RegistryServicesImpl(RegistryDao registryDao) {
        this.registryDao = registryDao;
    }

    @Override
    public boolean getPersonByLogin(String login, String pass) {
        boolean accurate = this.registryDao.getPersonByLogin(login, pass);
        return accurate;

    }
}
