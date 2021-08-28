package mainApp.services;

import mainApp.dto.RegistrationDto;
import mainApp.entities.AppUser;
import mainApp.entities.RegistrationResult;
import mainApp.entities.UserLogin;
import mainApp.entities.UserLoginResult;
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

    public UserLogin create(RegistrationDto registration) {
        UserLogin userLogin = new UserLogin(registration.getEmailId(), registration.getPassword());
        return userLoginRepository.save(userLogin);
    }

    public UserLoginResult login(UserLogin userLogin) {
        UserLogin result = userLoginRepository.findByEmailIdAndPassword(userLogin.getEmailId(), userLogin.getPassword());
        return result != null ? UserLoginResult.SUCCESS : UserLoginResult.BAD_CREDENTIALS;
    }

    public UserLogin read(String emailId){
        return userLoginRepository.findByEmailId(emailId);
    }

    public List<UserLogin> readAll() {
        Iterable<UserLogin> userLoginIterable = userLoginRepository.findAll();
        List<UserLogin> result = new ArrayList<>();
        userLoginIterable.forEach(result::add);
        return result;
    }

    public UserLogin update(String emailId, UserLogin newLoginData){
        UserLogin originalUserLogin = userLoginRepository.findByEmailId(emailId);
        originalUserLogin.setEmailId(newLoginData.getEmailId());
        originalUserLogin.setPassword(newLoginData.getPassword());
        originalUserLogin = userLoginRepository.save(originalUserLogin);
        return originalUserLogin;
    }

    public UserLogin delete(String emailId){
        UserLogin userLoginInDb = read(emailId);
        userLoginRepository.delete(userLoginInDb);
        return userLoginInDb;
    }

    public UserLogin delete(UserLogin userLogin){
        return delete(userLogin.getEmailId());
    }


    public RegistrationResult register(RegistrationDto registrationDto) {

        RegistrationResult result;

        UserLogin userLogin = userLoginRepository.findByEmailId(registrationDto.getEmailId());

        if (userLogin == null) {
            create(registrationDto);

            appUserService.create(registrationDto);

            result = RegistrationResult.SUCCESS;

        } else {
            AppUser existing = appUserService.read(userLogin);
            if(existing == null) {

                appUserService.create(registrationDto);

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
