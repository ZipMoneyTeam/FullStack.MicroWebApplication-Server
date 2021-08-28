package mainApp.repositories;

import mainApp.entities.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, String> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM APP_USER WHERE email_id = :emailId" )
    AppUser findByEmailId(@Param("emailId") String emailId);

}
