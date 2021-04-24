package fr.alternalis.banks.iservices;

import fr.alternalis.banks.dtos.OperationDTO;
import fr.alternalis.banks.dtos.UserDTO;

import java.util.List;

public interface IOperationService {

    List<OperationDTO> getLastOperations(int number, UserDTO user);

    void saveOperationForUser(UserDTO user, Double value);

}
