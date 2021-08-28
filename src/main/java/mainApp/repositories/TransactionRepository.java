package mainApp.repositories;

import mainApp.entities.AppUser;
import mainApp.entities.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM TRANSACTION WHERE APP_USER = :appUser" )
    List<Transaction> findByAppUser(@Param("appUser") AppUser appUser);
}
