package fr.alternalis.banks.repositories;

import fr.alternalis.banks.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    public User getUserByUsername(String username);

}
