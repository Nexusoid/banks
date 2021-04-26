package fr.alternalis.banks.services;

import fr.alternalis.banks.dtos.UserDTO;
import fr.alternalis.banks.entities.User;
import fr.alternalis.banks.iservices.IUserService;
import fr.alternalis.banks.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import javax.transaction.Transactional;

/**
 * Service associated to the User entity.
 */
@Service
@Transactional
public class UserService implements IUserService {

    private IUserRepository userRepository;

    private ModelMapper mapper = new ModelMapper();

    @Autowired
    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * Function that find the user from it's username.
     * @param username of the requested user.
     * @return A UserDTO that contain all information for the user.
     */
    @Override
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.getUserByUsername(username);
        if(user != null){
            return mapper.map(user, UserDTO.class);
        }
        return null;
    }

    /**
     * Function that update the user balance.
     * @param username of the user for which the balance need to be updated.
     * @param value needed to be added/subtracted from the user balance.
     * @return A Boolean containing true if the user was updated, false otherwise.
     */
    @Override
    public Boolean updateUserBalance(String username, Double value) {
        User user = userRepository.getUserByUsername(username);
        if(user != null){
            user.setBalance(user.getBalance() + value);
            userRepository.saveAndFlush(user);
            return true;
        }
        return false;
    }

    /**
     * Function that persist a new User.
     * @param username of the new User.
     * @param password of the new User.
     * @return A Boolean containing true if the user was created, false otherwise.
     */
    @Override
    public Boolean registerUser(String username, String password) {
        UserDTO userExist = getUserByUsername(username);
        if(userExist == null){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setBalance(50D);
            userRepository.save(user);
            return true;
        }
        return false;
    }

}
