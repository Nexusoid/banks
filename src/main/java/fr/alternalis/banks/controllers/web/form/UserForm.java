package fr.alternalis.banks.controllers.web.form;

/**
 * Form used on the banks website for login or register.
 */
public class UserForm {

    /**
     * @param username is the name of the account.
     */
    private String username;

    /**
     * @param password is the password of the account.
     */
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
