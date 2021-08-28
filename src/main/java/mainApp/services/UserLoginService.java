package mainApp.services;

import mainApp.entities.UserLogin;
import mainApp.repositories.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserLoginService {

    @Autowired
    UserLoginRepository userLoginRepository;

    public UserLoginService(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }

    public UserLogin create(UserLogin userLogin) {
        return userLoginRepository.save(userLogin);
    }

    public UserLogin read(Long id){
        return userLoginRepository.findById(id).get();
    }

    public List<UserLogin> readAll() {
        Iterable<UserLogin> userLoginIterable = userLoginRepository.findAll();
        List<UserLogin> result = new ArrayList<>();
        userLoginIterable.forEach(result::add);
        return result;
    }

    public UserLogin update(Long id, UserLogin newLoginData){
        UserLogin originalUserLogin = userLoginRepository.findById(id).get();
        originalUserLogin.setEmailId(newLoginData.getEmailId());
        originalUserLogin.setPassword(newLoginData.getPassword());
        originalUserLogin = userLoginRepository.save(originalUserLogin);
        return originalUserLogin;
    }

    public UserLogin delete(Long id){
        UserLogin userLoginInDb = read(id);
        userLoginRepository.delete(userLoginInDb);
        return userLoginInDb;
    }

    public UserLogin delete(UserLogin userLogin){
        return delete(userLogin.getId());
    }

}
