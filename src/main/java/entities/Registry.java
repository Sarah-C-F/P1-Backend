package entities;

import java.util.Locale;

import static entities.Role.UNCHECKED;

public class Registry {
    int registryId;
    String firstName;
    String lastName;
    Role accessRole = UNCHECKED;
    String login;
    String logPass;

    public Registry() {
    }

    public Registry(String login, String logPass) {
        this.login = login;
        this.logPass = logPass;
    }

    public Registry(int registryId, String firstName, String lastName, Role accessRole, String login, String logPass) {
        this.registryId = registryId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accessRole = accessRole;
        this.login = login;
        this.logPass = logPass;
    }

    public Registry(String firstName, String lastName, String login, String logPass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.logPass = logPass;
    }

    public int getRegistryId() {
        return registryId;
    }

    public void setRegistryId(int registryId) {
        this.registryId = registryId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getAccessRole() {
        return accessRole;
    }

    public void setAccessRole(String access) {
        access = access.toUpperCase();
        this.accessRole = Role.valueOf(access);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogPass() {
        return logPass;
    }

    public void setLogPass(String logPass) {
        this.logPass = logPass;
    }

    @Override
    public String toString() {
        return "Registry{" +
                "registryId=" + registryId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accessRole=" + accessRole +
                ", login='" + login + '\'' +
                ", logPass='" + logPass + '\'' +
                '}';
    }
}
