package fr.alternalis.banks.controllers.rest.json.request;

/**
 * JSON representation of a balance request.
 */
public class BalanceRequestJson {

    /**
     * @param username is the name linked to the user account.
     */
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
