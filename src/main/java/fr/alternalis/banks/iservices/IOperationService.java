package fr.alternalis.banks.iservices;

import fr.alternalis.banks.dtos.OperationDTO;
import fr.alternalis.banks.dtos.UserDTO;

import java.util.List;

/**
 * Interface of the operation service.
 */
public interface IOperationService {

    /**
     * Function that return the last operation(s) for an account.
     * @param number of requested operation(s)
     * @param user for who we need the operation(s)
     * @return A list of OperationDTO
     */
    List<OperationDTO> getLastOperations(int number, UserDTO user);

    /**
     * Function that persist an operation for a user.
     * @param user for who we need to persist the operation.
     * @param value associated with the operation.
     */
    void saveOperationForUser(UserDTO user, Double value);

}
