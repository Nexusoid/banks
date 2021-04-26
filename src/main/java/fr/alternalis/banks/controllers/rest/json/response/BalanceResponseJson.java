package fr.alternalis.banks.controllers.rest.json.response;

/**
 * Representation of the JSON response for a balance request.
 */
public class BalanceResponseJson {

    /**
     * @param balance is the balance of the requested user.
     */
    private Double balance;

    public BalanceResponseJson(Double balance){
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
