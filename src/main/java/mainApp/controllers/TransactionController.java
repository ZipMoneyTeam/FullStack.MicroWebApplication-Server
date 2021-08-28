package mainApp.controllers;

import com.sun.org.apache.regexp.internal.RE;
import mainApp.entities.AppUser;
import mainApp.entities.Transaction;
import mainApp.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/transaction-controller")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping(value = "/getTransaction/{id}")
    public ResponseEntity<Transaction> getTransaction(@RequestBody AppUser appUser) {
        return new ResponseEntity<>((Transaction) transactionService.getTransactionsByUser(appUser), HttpStatus.OK);
    }
    // Get transaction by userID

}
