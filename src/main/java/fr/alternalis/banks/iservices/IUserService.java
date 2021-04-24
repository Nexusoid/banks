package fr.alternalis.banks.iservices;

import fr.alternalis.banks.dtos.UserDTO;

public interface IUserService {

    UserDTO getUserByUsername(String username);

    Boolean updateUserBalance(String username, Double value);

    void registerUser(String username, String password);
}
