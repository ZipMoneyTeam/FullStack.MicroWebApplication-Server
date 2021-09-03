package mainApp.controllers;

import mainApp.entities.Account;
import mainApp.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
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

    @PostMapping(value = "/transfer/{idFrom}/{idTo}")
    public ResponseEntity<Account> transfer(@RequestBody Double amountToTransfer, @PathVariable Long idFrom, @PathVariable Long idTo) {
        ResponseEntity<Account> result;
        try {
            result = new ResponseEntity<>(accountService.transfer(idFrom, idTo, amountToTransfer), HttpStatus.OK);
        }
        catch(Exception e){
            result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }

    @PostMapping(value = "/deposit/{id}/{amountToDeposit}")
    public ResponseEntity<Account> deposit(@PathVariable Long id, @RequestBody Double amountToDeposit) {
        return new ResponseEntity<>(accountService.deposit(id, amountToDeposit), HttpStatus.OK);
    }

    @PostMapping(value = "/withdraw/{id}/{amountToWithdraw}")
    public ResponseEntity<Account> withdraw(@PathVariable Long id, @RequestBody Double amountToWithdraw) throws Exception {
        return new ResponseEntity<>(accountService.withdraw(id, amountToWithdraw), HttpStatus.OK);
    }


}
