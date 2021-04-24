package fr.alternalis.banks.controllers.rest.json.response;

import fr.alternalis.banks.dtos.OperationDTO;

import java.util.List;

public class BalanceResponseJson {

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
