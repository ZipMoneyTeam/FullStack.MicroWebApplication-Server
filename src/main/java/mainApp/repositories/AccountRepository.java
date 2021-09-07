package mainApp.repositories;

import mainApp.entities.Account;
import mainApp.entities.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM ACCOUNT WHERE email_id_email_id = :emailId" )
    List<Account> findByEmailId(@Param("emailId") String emailId);
}
