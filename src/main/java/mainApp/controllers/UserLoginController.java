package mainApp.controllers;

import mainApp.dto.RegistrationDto;
import mainApp.entities.RegistrationResult;
import mainApp.entities.UserLogin;
import mainApp.services.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
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

    @PostMapping
    public ResponseEntity<RegistrationResult> registerUserAccount(@RequestBody RegistrationDto registrationDto) {
        return new ResponseEntity<>(userLoginService.register(registrationDto), HttpStatus.OK);
    }

}
