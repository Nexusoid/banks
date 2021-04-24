package fr.alternalis.banks.services;

import fr.alternalis.banks.dtos.UserDTO;
import fr.alternalis.banks.entities.User;
import fr.alternalis.banks.iservices.IUserService;
import fr.alternalis.banks.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService implements IUserService {

    private IUserRepository userRepository;

    private ModelMapper mapper = new ModelMapper();

    @Autowired
    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.getUserByUsername(username);
        if(user != null){
            return mapper.map(user, UserDTO.class);
        }
        return null;
    }

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

    @Override
    public void registerUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setBalance(50D);
        userRepository.save(user);
    }

}
