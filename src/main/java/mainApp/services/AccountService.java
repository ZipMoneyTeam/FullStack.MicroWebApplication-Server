package mainApp.services;

import mainApp.entities.Account;
import mainApp.entities.AppUser;
import mainApp.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account create(Account account) {
        return accountRepository.save(account);
    }

    public Account read(Long id){
        return accountRepository.findOne(id);
    }

    public List<Account> readAll() {
        Iterable<Account> accountIterable = accountRepository.findAll();
        List<Account> result = new ArrayList<>();
        accountIterable.forEach(result::add);
        return result;
    }

    public Account update(Long id,Account newAccountData){
        Account originalAccount = accountRepository.findOne(id);
        originalAccount.setAccountName(newAccountData.getAccountName());
        originalAccount.setAccountNumber(newAccountData.getAccountNumber());
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
        return delete(account.getId());
    }

    public Account transfer(Account account1, Account account2, Double amountToTransfer) {

        // Account1 is where we are transfering from -> get the amount in account1 -> substract amountToTransfer
        // Account2 is where we are sending to -> get the amount in account2 -> add amountToTransfer
        // return your new balances are + account1.getamount + account2.getaccount


//        Double amount1 = account1.getAmount() - amountToTransfer;  // have to make logic reference specific account using the id.
//        Double amount2 = account2.getAmount() + amountToTransfer;
//
//        account1.setAmount(amount1);
//        account2.setAmount(amount2);

        return account1;
    }

    public Account deposit(Long id, Double amountToDeposit) { // using id to reference the specific account
        Account originalAccount = accountRepository.findOne(id);
        Double amount = originalAccount.getAmount() + amountToDeposit;
        originalAccount.setAmount(amount);

        return originalAccount;
    }

    public Account withdraw(Long id, Double amountToWithdraw) { // using id to reference the specific account
        Account originalAccount = accountRepository.findOne(id);
        Double amount = originalAccount.getAmount() - amountToWithdraw;
        originalAccount.setAmount(amount);

        return originalAccount;
    }
}
