package mainApp.services;

import mainApp.dto.UserDto;
import mainApp.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserDto registration);
}
