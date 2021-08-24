package mainApp.controllers;

import mainApp.entities.User;
import mainApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user-controller")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/createUser")
    public ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<User>(userService.create(user), HttpStatus.CREATED);
    }

    @GetMapping(value = "/read{id}")
    public ResponseEntity<User> read(@PathVariable Long id) {
        return new ResponseEntity<User>(userService.read(id), HttpStatus.OK);
    }

    @GetMapping(value = "/readAll")
    public ResponseEntity<Iterable<User>> readAll() {
        return new ResponseEntity<>(userService.readAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/update{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        return new ResponseEntity<>(userService.update(id, user), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }
}
