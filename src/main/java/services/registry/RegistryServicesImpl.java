package services.registry;

import daos.registry.RegistryDao;
import entities.Registry;

public class RegistryServicesImpl implements RegistryServices{

    private RegistryDao registryDao;

    public RegistryServicesImpl(RegistryDao registryDao) {
        this.registryDao = registryDao;
    }

    @Override
    public Registry getPersonByLogin(String login, String pass) {
        System.out.println(login + pass);
        Registry person2 = this.registryDao.getPersonByLogin(login, pass);
        return person2;

    }
}
