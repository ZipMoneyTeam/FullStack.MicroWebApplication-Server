package mainApp.controllers;

import mainApp.entities.Account;
import mainApp.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account-controller")
public class AccountController {

    @Autowired
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(value = "/createAccount")
    public ResponseEntity<Account> create(@RequestBody Account account) {
        return new ResponseEntity<Account>(accountService.create(account), HttpStatus.CREATED);
    }

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<Account> read(@PathVariable Long id) {
        return new ResponseEntity<Account>(accountService.read(id), HttpStatus.OK);
    }

    @GetMapping(value = "/readAll")
    public ResponseEntity<Iterable<Account>> readAll() {
        return new ResponseEntity<>(accountService.readAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Account> update(@PathVariable Long id, @RequestBody Account account) {
        return new ResponseEntity<>(accountService.update(id, account), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Account> delete(@PathVariable Long id) {
        return new ResponseEntity<>(accountService.delete(id), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Account> delete(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.delete(account), HttpStatus.NO_CONTENT);
    }
}
