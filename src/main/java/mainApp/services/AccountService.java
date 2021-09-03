package mainApp.services;

import mainApp.entities.Account;
import mainApp.entities.Transaction;
import mainApp.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;
    TransactionService transactionService;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account create(Account account) {
        return accountRepository.save(account);
    }

    public Account read(Long id){
        return accountRepository.findById(id).get();
    }

    public List<Account> readAll() {
        Iterable<Account> accountIterable = accountRepository.findAll();
        List<Account> result = new ArrayList<>();
        accountIterable.forEach(result::add);
        return result;
    }

    public Account update(Long id,Account newAccountData){
        Account originalAccount = accountRepository.findById(id).get();
        originalAccount.setAccountName(newAccountData.getAccountName());
        //originalAccount.setAccountNumber(newAccountData.getAccountNumber());
        originalAccount.setAccountType(newAccountData.getAccountType());
        originalAccount.setAmount(newAccountData.getAmount());
        originalAccount = accountRepository.save(originalAccount);
        return originalAccount;
    }

    public Account delete(Long id){
        Account accountInDb = read(id);
        accountRepository.delete(accountInDb);
        return accountInDb;
    }

    public Account delete(Account account){
        return delete(account.getAccountId());
    }

    public Account transfer(Long idFrom, Long idTo, Double amountToTransfer) throws Exception {
        // Account1 is where we are transfering from -> get the amount in account1 -> substract amountToTransfer
        // Account2 is where we are sending to -> get the amount in account2 -> add amountToTransfer
        // return your new balances are + account1.getamount + account2.getaccount
//        Double amount1 = account1.getAmount() - amountToTransfer;  // have to make logic reference specific account using the id.
//        Double amount2 = account2.getAmount() + amountToTransfer;
//        account1.setAmount(amount1);
//        account2.setAmount(amount2);

        Account result = withdraw(idFrom, amountToTransfer);
        deposit(idTo, amountToTransfer);

        return result; // returns account we withdraw from
    }

    public Account deposit(Long id, Double amountToDeposit) { // using id to reference the specific account
        Account originalAccount = accountRepository.findById(id).get();
        Double amount = originalAccount.getAmount() + amountToDeposit;
        originalAccount.setAmount(amount);

//        generateAndSaveTransaction(originalAccount,"DEPOSIT", true,
//                String.format("Deposited %s into account with id %s", amountToDeposit, originalAccount.getAccountId()));
//


        return originalAccount;

    }

    public Account withdraw(Long id, Double amountToWithdraw) throws Exception { // using id to reference the specific account
        Account originalAccount = accountRepository.findById(id).get();
        Double amount = originalAccount.getAmount() - amountToWithdraw;
        if (amount < 0) {
            throw new Exception("Insufficient funds");
        }
        originalAccount.setAmount(amount);

//        generateAndSaveTransaction(originalAccount,"WITHDRAW", true,
//                String.format("Withdrew %s from account with id %s", amountToWithdraw, originalAccount.getAccountId()));


        return originalAccount;
    }

    public Transaction generateAndSaveTransaction(Account account, String type, Boolean status, String info) {
        return transactionService.saveTransaction(new Transaction(null, type, status, info, Instant.now(), account));
    }

    //After each function call transaction method

    //
}
