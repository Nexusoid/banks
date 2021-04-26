package fr.alternalis.banks.iservices;

import fr.alternalis.banks.dtos.UserDTO;

/**
 * Interface of the user service.
 */
public interface IUserService {

    /**
     * Function that find the user from it's username.
     * @param username of the requested user.
     * @return A UserDTO that contain all information for the user.
     */
    UserDTO getUserByUsername(String username);

    /**
     * Function that update the user balance.
     * @param username of the user for which the balance need to be updated.
     * @param value needed to be added/subtracted from the user balance.
     * @return A Boolean containing true if the user was updated, false otherwise.
     */
    Boolean updateUserBalance(String username, Double value);

    /**
     * Function that persist a new User.
     * @param username of the new User.
     * @param password of the new User.
     * @return A Boolean containing true if the user was created, false otherwise.
     */
    Boolean registerUser(String username, String password);
}
