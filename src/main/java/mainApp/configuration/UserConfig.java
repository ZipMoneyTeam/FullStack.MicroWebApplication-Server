package mainApp.configuration;

import mainApp.entities.User;
import mainApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


import javax.annotation.PostConstruct;
@Configuration
public class UserConfig {
    @Autowired
    UserService userService;

    @PostConstruct
    public void setUp(){
        userService.create(new User());
        userService.create(new User());
    }

}
