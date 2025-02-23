package mainApp.controllers;

import mainApp.dto.RegistrationDto;
import mainApp.entities.RegistrationResult;
import mainApp.entities.UserLogin;
import mainApp.entities.UserLoginResult;
import mainApp.services.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping(value = "/member-controller")
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;

    public UserLoginController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }



    @GetMapping(value = "/read/{id}")
    public ResponseEntity<UserLogin> read(@PathVariable String emailId) {
        return new ResponseEntity<UserLogin>(userLoginService.read(emailId), HttpStatus.OK);
    }

    @GetMapping(value = "/readAll")
    public ResponseEntity<Iterable<UserLogin>> readAll() {
        return new ResponseEntity<>(userLoginService.readAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<UserLogin> update(@PathVariable String emailId, @RequestBody UserLogin userLogin) {
        return new ResponseEntity<>(userLoginService.update(emailId, userLogin), HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete")
    public ResponseEntity<UserLogin> delete(@RequestBody UserLogin userLogin) {
        return new ResponseEntity<>(userLoginService.delete(userLogin), HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UserLoginResult> login(@RequestBody UserLogin userLogin) {
        UserLoginResult result = this.userLoginService.login(userLogin);
        HttpStatus status = result.equals(UserLoginResult.SUCCESS) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return new ResponseEntity<>(result, status);
    }

    @PostMapping(path = "/register",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegistrationResult> registerUserAccount(@RequestBody RegistrationDto registrationDto) {
        return new ResponseEntity<>(userLoginService.register(registrationDto), HttpStatus.OK);
    }

}
