package mainApp.controllers;

import mainApp.entities.AppUser;
import mainApp.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user-controller")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping(value = "/createUser")
    public ResponseEntity<AppUser> create(@RequestBody AppUser appUser) {
        return new ResponseEntity<AppUser>(appUserService.create(appUser), HttpStatus.CREATED);
    }

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<AppUser> read(@PathVariable Long id) {
        return new ResponseEntity<AppUser>(appUserService.read(id), HttpStatus.OK);
    }

    @GetMapping(value = "/readAll")
    public ResponseEntity<Iterable<AppUser>> readAll() {
        return new ResponseEntity<>(appUserService.readAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<AppUser> update(@PathVariable Long id, @RequestBody AppUser appUser) {
        return new ResponseEntity<>(appUserService.update(id, appUser), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<AppUser> delete(@PathVariable Long id) {
        return new ResponseEntity<>(appUserService.delete(id), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<AppUser> delete(@RequestBody AppUser appUser) {
        return new ResponseEntity<>(appUserService.delete(appUser), HttpStatus.NO_CONTENT);
    }
}

