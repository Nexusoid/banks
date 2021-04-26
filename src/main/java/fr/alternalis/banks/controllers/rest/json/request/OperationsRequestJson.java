package fr.alternalis.banks.controllers.rest.json.request;

/**
 * JSON representation of an operations request.
 */
public class OperationsRequestJson {

    /**
     * @param username is the name linked to the user account.
     */
    private String username;

    /**
     * @param number is the number of wanted operations.
     */
    private String number;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
