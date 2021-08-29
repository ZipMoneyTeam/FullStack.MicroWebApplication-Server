package mainApp.controllers;

import mainApp.entities.AppUser;
import mainApp.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/user-controller")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping(value = "/read/{emailId}")
    public ResponseEntity<AppUser> read(@PathVariable String emailId) {
        return new ResponseEntity<AppUser>(appUserService.read(emailId), HttpStatus.OK);
    }

    @GetMapping(value = "/readAll")
    public ResponseEntity<Iterable<AppUser>> readAll() {
        return new ResponseEntity<>(appUserService.readAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{emailId}")
    public ResponseEntity<AppUser> update(@PathVariable String emailId, @RequestBody AppUser appUser) {
        return new ResponseEntity<>(appUserService.update(emailId, appUser), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{emailId}")
    public ResponseEntity<AppUser> delete(@PathVariable String emailId) {
        return new ResponseEntity<>(appUserService.delete(emailId), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<AppUser> delete(@RequestBody AppUser appUser) {
        return new ResponseEntity<>(appUserService.delete(appUser), HttpStatus.NO_CONTENT);
    }
}

