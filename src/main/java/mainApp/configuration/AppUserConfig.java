package mainApp.configuration;

import mainApp.entities.AppUser;
import mainApp.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class AppUserConfig {

    @Autowired
    private AppUserService appUserService;

    @PostConstruct
    public void setUp(){
        appUserService.create(new AppUser(1L, "Manny", "Mbanefo", "August 20 1998", "123456789", "123@gmail.com"));
        appUserService.create(new AppUser());
        appUserService.create(new AppUser());
    }

}
