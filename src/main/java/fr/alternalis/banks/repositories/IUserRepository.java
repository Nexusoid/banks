package fr.alternalis.banks.repositories;

import fr.alternalis.banks.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository associated to the User entity.
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    /**
     * Function that return a registered user.
     * @param username associated to the requested user account.
     * @return A User.
     */
    public User getUserByUsername(String username);

}
