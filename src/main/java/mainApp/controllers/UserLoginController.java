package mainApp.controllers;

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

    @PostMapping(value = "/createMember")
    public ResponseEntity<UserLogin> create(@RequestBody UserLogin userLogin) {
        return new ResponseEntity<UserLogin>(userLoginService.create(userLogin), HttpStatus.CREATED);
    }

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<UserLogin> read(@PathVariable Long id) {
        return new ResponseEntity<UserLogin>(userLoginService.read(id), HttpStatus.OK);
    }

    @GetMapping(value = "/readAll")
    public ResponseEntity<Iterable<UserLogin>> readAll() {
        return new ResponseEntity<>(userLoginService.readAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<UserLogin> update(@PathVariable Long id, @RequestBody UserLogin userLogin) {
        return new ResponseEntity<>(userLoginService.update(id, userLogin), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<UserLogin> delete(@PathVariable Long id) {
        return new ResponseEntity<>(userLoginService.delete(id), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<UserLogin> delete(@RequestBody UserLogin userLogin) {
        return new ResponseEntity<>(userLoginService.delete(userLogin), HttpStatus.NO_CONTENT);
    }
}
