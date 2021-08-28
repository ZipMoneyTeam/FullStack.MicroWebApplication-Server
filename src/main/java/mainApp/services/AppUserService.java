package mainApp.services;

import mainApp.entities.AppUser;
import mainApp.entities.UserLogin;
import mainApp.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser create(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    public AppUser read(UserLogin userLogin) { return appUserRepository.findByEmailId(userLogin.getEmailId());}

    public AppUser read(String emailId) { return appUserRepository.findByEmailId(emailId);}


    public List<AppUser> readAll() {
        Iterable<AppUser> userIterable = appUserRepository.findAll();
        List<AppUser> result = new ArrayList<>();
        userIterable.forEach(result::add);
        return result;
    }

    public AppUser update(String emailId, AppUser newUserData){
        AppUser originalUser = read(emailId);
        originalUser.setFirstName(newUserData.getFirstName());
        originalUser.setLastName(newUserData.getLastName());
        originalUser.setBirthDate(newUserData.getBirthDate());
        originalUser.setPhoneNumber(newUserData.getPhoneNumber());
        originalUser.setEmailId(newUserData.getEmailId());
        originalUser = appUserRepository.save(originalUser);
        return originalUser;
    }

    public AppUser delete(String emailId){
        AppUser appUserInDb = read(emailId);
        appUserRepository.delete(appUserInDb);
       return appUserInDb;
    }

    public AppUser delete(AppUser appUser){
        return delete(appUser.getEmailId());
    }
}
