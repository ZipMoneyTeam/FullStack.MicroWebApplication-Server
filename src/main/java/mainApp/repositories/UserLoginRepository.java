package mainApp.repositories;

import mainApp.entities.AppUser;
import mainApp.entities.UserLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends CrudRepository<UserLogin, Long> {

    @Query("SELECT * FROM USER_LOGIN WHERE email_id = :emailId" )
    UserLogin findByEmailId(@Param("emailId") String emailId);

}
