package fr.alternalis.banks.repositories;

import fr.alternalis.banks.entities.Operation;
import fr.alternalis.banks.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository associated to the Operation entity.
 */
@Repository
public interface IOperationRepository extends JpaRepository<Operation, Long> {

    /**
     * Function that return the last operation(s) for a user from database.
     * @param number of needed operation(s).
     * @param user for which we need the operation(s).
     * @return A List of Operation containing all needed operations.
     */
    @Query(nativeQuery = true,
            value = "SELECT * "
           + "FROM Operation o "
           + "WHERE o.user = :user "
           + "ORDER BY o.date DESC "
           + "LIMIT :number"
    )
    public List<Operation> getLastOperations(@Param("number") int number, @Param("user") User user);

}
