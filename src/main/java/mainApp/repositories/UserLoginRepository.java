package mainApp.repositories;

import mainApp.entities.AppUser;
import mainApp.entities.UserLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends CrudRepository<UserLogin, Long> {

    @Query(nativeQuery = true,
           value = "SELECT * FROM USER_LOGIN WHERE email_id = :emailId" )
    UserLogin findByEmailId(@Param("emailId") String emailId);

    @Query(nativeQuery = true,
            value = "SELECT * FROM USER_LOGIN " +
                    "WHERE email_id = :emailId " +
                    "AND password = :password" )
    UserLogin findByEmailIdAndPassword(@Param("emailId") String emailId, @Param("password") String password);
}
