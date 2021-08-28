package mainApp.services;

import mainApp.entities.AppUser;
import mainApp.entities.RegistrationResult;
import mainApp.entities.UserLogin;
import mainApp.repositories.AppUserRepository;
import mainApp.repositories.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserLoginService {

    @Autowired
    UserLoginRepository userLoginRepository;

    @Autowired
    AppUserService appUserService;

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


    public RegistrationResult register(UserLogin registrationDto) {

        RegistrationResult result;

        UserLogin userLogin = userLoginRepository.findByEmailId(registrationDto.getEmailId());

        if (userLogin == null) {
            UserLogin newUserLogin = new UserLogin();
            create(newUserLogin);

            appUserService.create(null);

            result = RegistrationResult.SUCCESS;

        } else {
            AppUser existing = appUserService.read(userLogin);
            if(existing == null) {

                appUserService.create(null);

                result = RegistrationResult.USER_CREATED;
            }
            else {
                result = RegistrationResult.EMAIL_TAKEN;
            }
        }
        return result;
    }


//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
////    	creating simple authority
//        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_BANK_USER"));
//        User user = userRepository.findByEmail(email);
//        if (user == null) {
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getEmail(),
//                user.getPassword(),
//                authorities);
//    }
}
