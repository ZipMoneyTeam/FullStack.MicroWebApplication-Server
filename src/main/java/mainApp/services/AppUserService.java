package mainApp.services;

import mainApp.entities.AppUser;
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

    public AppUser read(Long id){
        return appUserRepository.findById(id).get();
    }

    public List<AppUser> readAll() {
        Iterable<AppUser> userIterable = appUserRepository.findAll();
        List<AppUser> result = new ArrayList<>();
        userIterable.forEach(result::add);
        return result;
    }

    public AppUser update(Long id, AppUser newUserData){
        AppUser originalUser = appUserRepository.findById(id).get();
        originalUser.setFirstName(newUserData.getFirstName());
        originalUser.setLastName(newUserData.getLastName());
        originalUser.setBirthDate(newUserData.getBirthDate());
        originalUser.setPhoneNumber(newUserData.getPhoneNumber());
        originalUser.setEmailId(newUserData.getEmailId());
        originalUser = appUserRepository.save(originalUser);
        return originalUser;
    }

    public AppUser delete(Long id){
        AppUser appUserInDb = read(id);
        appUserRepository.delete(appUserInDb);
       return appUserInDb;
    }

    public AppUser delete(AppUser appUser){
        return delete(appUser.getId());
    }
}
