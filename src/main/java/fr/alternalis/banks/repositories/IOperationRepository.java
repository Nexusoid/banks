package fr.alternalis.banks.repositories;

import fr.alternalis.banks.entities.Operation;
import fr.alternalis.banks.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOperationRepository extends JpaRepository<Operation, Long> {

    @Query(nativeQuery = true,
            value = "SELECT * "
           + "FROM Operation o "
           + "WHERE o.user = :user "
           + "ORDER BY o.date DESC "
           + "LIMIT :number"
    )
    public List<Operation> getLastOperations(@Param("number") int number, @Param("user") User user);

}
