package fr.alternalis.banks.controllers.rest.json.response;

import fr.alternalis.banks.dtos.OperationDTO;

import java.util.List;

/**
 * Representation of the JSON response for an operation request.
 */
public class OperationsResponseJson {

    /**
     * @param operations is the list of the operations associated to the requested user.
     */
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
