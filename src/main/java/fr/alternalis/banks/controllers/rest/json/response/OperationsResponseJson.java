package fr.alternalis.banks.controllers.rest.json.response;

import fr.alternalis.banks.dtos.OperationDTO;

import java.util.List;

public class OperationsResponseJson {

    private List<OperationDTO> operations;

    public OperationsResponseJson(List<OperationDTO> operations){
        this.operations = operations;
    }

    public List<OperationDTO> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationDTO> operations) {
        this.operations = operations;
    }
}
